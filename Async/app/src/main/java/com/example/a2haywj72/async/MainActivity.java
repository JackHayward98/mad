package com.example.a2haywj72.async;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URLEncoder;

import android.app.AlertDialog;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a2haywj72.async.MainActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**Called when the activity is first created/ */
    class MyTask extends AsyncTask<String,Void,String>
    {
        public String doInBackground(String... params)
        {


            HttpURLConnection conn = null;
            try
            {
                String artist = URLEncoder.encode(params[0], "UTF-8");
                URL url = new URL("http://www.free-map.org.uk/course/mad/ws/hits.php?artist="+ artist);
                conn = (HttpURLConnection) url.openConnection();
                InputStream in = conn.getInputStream();
                if(conn.getResponseCode() == 200)
                {
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    String result = "", line;
                    while((line = br.readLine()) !=null)
                    {
                        result += line+"\n";
                    }
                    return result;
                }
                else
                {
                    return "HTTP ERROR: " + conn.getResponseCode();
                }
            }
            catch(IOException e)
            {
                return e.toString();
            }
            finally
            {
                if(conn!=null)
                {
                    conn.disconnect();
                }
            }
        }

        public void onPostExecute(String result)
        {
            TextView et1 = (TextView)findViewById(R.id.tv1);
            et1.setText(result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button)findViewById(R.id.btn1);
        b.setOnClickListener(this);
    }
    public void onClick (View view) {
        EditText artist = (EditText) findViewById(R.id.et1);
        MyTask t = new MyTask();
        t.execute(artist.getText().toString());

    }
}
