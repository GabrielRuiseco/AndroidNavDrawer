//package com.example.navdrawer;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.UiSettings;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//
//public class fragmentMap extends SupportMapFragment implements OnMapReadyCallback {
//
////    double lat, lon;
////    String name;
////
////    public fragmentMap() {
////    }
////
////    @Override
////    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
////        View view = super.onCreateView(layoutInflater, viewGroup, bundle);
////        lat = 19.2389;
////        lon = -103.7653;
////        name = "Torreon";
////        if (getArguments() != null) {
////            this.lat = getArguments().getDouble("lat");
////            Log.d("TAGADENTRODE", String.valueOf(lat));
////            this.lon = getArguments().getDouble("lon");
////            Log.d("TAG2", String.valueOf(lon));
////            this.name = getArguments().getString("name");
////            Log.d("TAG2", String.valueOf(name));
////        }
////        getMapAsync(this);
////        return view;
////    }
////
////    @Override
////    public void onMapReady(GoogleMap googleMap) {
////        LatLng latlng = new LatLng(lat, lon);
////        float zoom = 17;
////        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, zoom));
////
////        googleMap.getUiSettings().setZoomControlsEnabled(true);
////
////        googleMap.addMarker(new MarkerOptions().position(latlng).title(name));
////
////        UiSettings settings = googleMap.getUiSettings();
////
////        settings.setZoomControlsEnabled(true);
//    }
//}
