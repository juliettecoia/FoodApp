package com.example.juliettecoia.essai_carte;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final float DEFAULTZOOM = 10;
    public static String FBTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        makeMarkers(googleMap);

        LatLngBounds PNW = new LatLngBounds(new LatLng(44.78, -123.03), new LatLng(48.68, -122.59));
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(PNW, 0));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.showInfoWindow();
                FBTitle = marker.getTitle();
                Intent intent = new Intent(MapsActivity.this, NavigationDrawer.class);
                startActivity(intent);
                return false;
            }
        });
    }

    public void makeMarkers(GoogleMap googleMap)
    {
        LatLng ll1 = new LatLng(45.559333, -122.588504);
        mMap.addMarker(new MarkerOptions().position(ll1).title("Northeast Emergency Food Project").snippet("4800 NE 72nd Ave, Portland, OR 97218"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll1));

        LatLng ll2 = new LatLng(45.539165, -122.853956);
        mMap.addMarker(new MarkerOptions().position(ll2).title("Oregon Food Bank West").snippet("1870 NW 173rd Ace, Beaverton, OR 97006"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll2));

        LatLng ll3 = new LatLng(45.537865, -122.706987);
        mMap.addMarker(new MarkerOptions().position(ll3).title("Lift Urban Portland").snippet("2701 NW Vaughn St #102, Portland, OR 97210"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll3));

        LatLng ll4 = new LatLng(45.523901, -122.680590);
        mMap.addMarker(new MarkerOptions().position(ll4).title("Food and Water Watch").snippet("917 SW Oak St #404, Portland, OR 97205"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll4));

        LatLng ll5 = new LatLng(45.539563, -122.673317);
        mMap.addMarker(new MarkerOptions().position(ll5).title("Sunshine Division").snippet("687 N Thompson St, Portland, OR 97227"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll5));

        LatLng ll6 = new LatLng(45.554089, -122.657155);
        mMap.addMarker(new MarkerOptions().position(ll6).title("Allen Temple Food Pantry").snippet("4214 NE 8th Ave, Portland, OR 97211"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll6));

        LatLng ll7 = new LatLng(45.497663, -122.645033);
        mMap.addMarker(new MarkerOptions().position(ll7).title("The Pongo Fund Pet Food Bank").snippet("3632 SE 20th Ave, Portland, OR 97202"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll7));

        LatLng ll8 = new LatLng(45.468586, -122.710466);
        mMap.addMarker(new MarkerOptions().position(ll8).title("The Neighborhood House").snippet("7780 SW Capitol Hwy, Portland, OR 97219"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll8));

        LatLng ll9 = new LatLng(45.581128, -122.631571);
        mMap.addMarker(new MarkerOptions().position(ll9).title("Oregon Food Bank").snippet("7900 NE 33rd Dr, Portland, OR 97211"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll9));

        LatLng ll10 = new LatLng(45.540593, -122.559249);
        mMap.addMarker(new MarkerOptions().position(ll10).title("Crossroads Food Bank").snippet("2407 NE 102nd Ave, Portland, OR 97220"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll10));

        LatLng ll11 = new LatLng(45.550902, -122.669349);
        mMap.addMarker(new MarkerOptions().position(ll11).title("Hope House Food Bank").snippet("3837 N Gantenbein Ave, Portland, OR 97227"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll11));

        LatLng ll12 = new LatLng(45.485425, -122.788053);
        mMap.addMarker(new MarkerOptions().position(ll12).title("Sunshine Pantry").snippet("10895 SW 5th St, Beaverton, OR 97005"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll12));

        LatLng ll13 = new LatLng(45.450348, -122.629126);
        mMap.addMarker(new MarkerOptions().position(ll13).title("Esther's Pantry").snippet("10202 SE 32nd Ave, Milwaukie, OR 97222"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll13));

        LatLng ll14 = new LatLng(45.460222, -122.580718);
        mMap.addMarker(new MarkerOptions().position(ll14).title("Clackamas Service Center").snippet("8800 SE 80th Ave, Portland, OR 97206"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll14));
    }

    public void geoLocate(View v) throws IOException{

        hideSoftKeyboard(v);

        EditText et = (EditText) findViewById(R.id.editText1);
        String location = et.getText().toString();

        Geocoder gc = new Geocoder(this);
        List<Address>list = gc.getFromLocationName(location, 1);
        Address add = list.get(0);
        String locality = add.getLocality();

        Toast.makeText(this, locality, Toast.LENGTH_LONG).show();

        double lat = add.getLatitude();
        double lng = add.getLongitude();

        gotoLocation(lat, lng, DEFAULTZOOM);
    }

    private void gotoLocation(double lat, double lng, float zoom){
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, zoom);
        mMap.moveCamera(update);

        //mMap.addMarker(new MarkerOptions().position(ll).title(locality));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ll));
    }

    private void hideSoftKeyboard (View v){
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(),0);
    }

}
