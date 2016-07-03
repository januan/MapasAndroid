package com.javiernunez.mapas_android;

import android.content.pm.PackageManager;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private String titulo;
    private String descrip;
    private int zoom;
    private int tipoMapa;
    private double latitud;
    private double longitud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        //recibe parámetros
        Bundle parametros = getIntent().getExtras();
        zoom=parametros.getInt(getResources().getString(R.string.p_zoom));
        tipoMapa=parametros.getInt(getResources().getString(R.string.p_tipoMapa));
        titulo=parametros.getString(getResources().getString(R.string.p_titulo));
        descrip=parametros.getString(getResources().getString(R.string.p_desc));
        latitud=parametros.getDouble(getResources().getString(R.string.p_lat));
        longitud=parametros.getDouble(getResources().getString(R.string.p_lng));

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng posicion = new LatLng(latitud, longitud);
        //LatLng bahamas = new LatLng(24.63364117616753, -77.75061981228032);

        //mMap.setMyLocationEnabled(true);

        // MAP_TYPE_TERRAIN, MAP_TYPE_HYBRID and MAP_TYPE_NONE
        mMap.setMapType(tipoMapa);

        mMap.addMarker(new MarkerOptions()
                .title(titulo)
                .snippet(descrip)
                .position(posicion));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(posicion));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posicion, zoom));
    }
}
