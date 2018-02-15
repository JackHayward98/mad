package com.example.a2haywj72.class3;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    MapView mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences (this));
        setContentView(R.layout.activity_main);


    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()== R.id.choosemap)
        {
           Intent intent = new Intent (this, com.example.a2haywj72.class3.MapChooseActivity.class);
            startActivity(intent);
            //react to the menu item being selected...
            return true;
        }
        return false;
    }
    public void onStart()
    {
        super.onStart();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        double lat = Double.parseDouble ( prefs.getString("lat", "50.9") );
        double lon = Double.parseDouble ( prefs.getString("lon", "-1.4") );
        int zoom = Integer.parseInt(prefs.getString("zoom", "11"));
        String mapViewCode = prefs.getString("mapView", "NONE");

        mv = (MapView)findViewById(R.id.map1);
        mv.setBuiltInZoomControls(true);

        mv.getController().setZoom(zoom);
        mv.getController().setCenter(new GeoPoint(lat,lon));
        // do something with the preference data...
    }

}
