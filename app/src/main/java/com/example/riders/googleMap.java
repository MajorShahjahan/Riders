package com.example.riders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class googleMap extends AppCompatActivity {
    Double lat, lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        Intent i = getIntent();
        String lat_got = i.getStringExtra("lattitude");
        String lang_got = i.getStringExtra("longitude");
        final String name = i.getStringExtra("name");

        lat = Double.parseDouble(lat_got);
        lang = Double.parseDouble(lang_got);

        SupportMapFragment mapFragment =(SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                LatLng latLng = new LatLng(lat, lang);
//                LatLng latLng = new LatLng(31.459313,74.3002805);

                //create marker option
                MarkerOptions options = new MarkerOptions().position(latLng)
                        .title(name).icon(BitmapDescriptorFactory.fromResource(R.drawable.car));

                //zoom map
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));

                //add marker on map
                googleMap.addMarker(options);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        startActivity(new Intent(googleMap.this,MainActivity.class));
        return super.onOptionsItemSelected(item);

    }
}
