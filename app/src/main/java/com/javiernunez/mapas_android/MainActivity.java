package com.javiernunez.mapas_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


    }
    public void irMapa(View v){
        String titulo="";
        String descripcion="";
        double lat=0;
        double lng=0;
        int zoom=12;
        int tipoMap= GoogleMap.MAP_TYPE_NORMAL;
        switch(v.getId()) {
            case R.id.btAtocha:
                titulo=getResources().getString(R.string.btAtocha);
                descripcion="Cercanías, Largo Recorrido y AVE";
                lat=40.407073380850385;
                lng=-3.6913571695892045;
                zoom=16;
                tipoMap=GoogleMap.MAP_TYPE_SATELLITE;
                break;
            case R.id.btAlcala:
                titulo=getResources().getString(R.string.btAlcala);
                descripcion="Puerta de Alcalá";
                lat=40.420003451076276;
                lng=-3.6887506042297713;
                zoom=17;
                break;
            case R.id.btRetiro:
                titulo=getResources().getString(R.string.btRetiro);
                descripcion="Estatua del Ángel Caído";
                lat=40.41105287104751;
                lng=-3.682544828002954;
                tipoMap=GoogleMap.MAP_TYPE_SATELLITE;
                zoom=15;
                break;
            case R.id.btSol:
                titulo=getResources().getString(R.string.btSol);
                descripcion="Kilómetro 0";
                lat=40.41661658737299;
                lng=-3.7038049907184822;
                zoom=17;
                break;
        }
        //Toast.makeText(MainActivity.this, "Se ha pulsado "+titulo, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra(getString(R.string.p_zoom),zoom);
        i.putExtra(getString(R.string.p_desc),descripcion);
        i.putExtra(getString(R.string.p_titulo),titulo);
        i.putExtra(getString(R.string.p_lat),lat);
        i.putExtra(getString(R.string.p_lng),lng);
        i.putExtra(getString(R.string.p_tipoMapa),tipoMap);

        startActivity(i);

    }
}
