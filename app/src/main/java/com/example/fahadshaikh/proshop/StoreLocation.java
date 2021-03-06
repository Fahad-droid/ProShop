package com.example.fahadshaikh.proshop;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class StoreLocation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    //get the latitude
                    double latitude = location.getLatitude();
                    //get the longitude
                    double longitude = location.getLongitude();
                    //intantiate the class, latilng
                    LatLng latLng = new LatLng(latitude, longitude);
                    //Instantiate the class, Geocoder
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                        String str = addressList.get(0).getPostalCode() + ",";
                        str += addressList.get(0).getCountryName();
                        mMap.addMarker(new MarkerOptions().position(latLng).title(str));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10.2f));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });
        } else if (locationManager.isProviderEnabled(locationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    //get the latitude
                    double latitude = location.getLatitude();
                    //get the longitude
                    double longitude = location.getLongitude();
                    //intantiate the class, latilng
                    LatLng latLng = new LatLng(latitude, longitude);
                    //Instantiate the class, Geocoder
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                        String str = addressList.get(0).getLocality() + ",";
                        str += addressList.get(0).getCountryName();
                        mMap.addMarker(new MarkerOptions().position(latLng).title(str));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10.2f));
                    } catch (IOException e) {
                        e.printStackTrace();

                    }


                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });
        }
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
   // @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

         //Add a marker in Sydney and move the camera
        LatLng store1 = new LatLng(43.703527, -79.3424819);
        mMap.addMarker(new MarkerOptions().position(store1).title("Store 1").snippet("You selected Store 1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(store1, 10.2f));
        Toast.makeText(getBaseContext(),"Select your nearest store",Toast.LENGTH_LONG).show();

        LatLng store2 = new LatLng(43.817699, -79.1880791);
        mMap.addMarker(new MarkerOptions().position(store2).title("Store 2").snippet("You selected Store 2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(store2, 10.2f));

        LatLng store3 = new LatLng(43.7002588, -79.2885307);
        mMap.addMarker(new MarkerOptions().position(store3).title("Store 3").snippet("You selected Store 3"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(store3, 10.2f));

        LatLng store4 = new LatLng(43.6965742, -79.4073589);
        mMap.addMarker(new MarkerOptions().position(store4).title("Store 4").snippet("You selected Store 4"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(store4, 10.2f));

        LatLng store5 = new LatLng(43.847414, -79.3705507);
        mMap.addMarker(new MarkerOptions().position(store5).title("Store 5").snippet("You selected Store 5"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(store5, 10.2f));
    }


}
