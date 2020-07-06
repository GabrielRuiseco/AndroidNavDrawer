package com.example.navdrawer.ui.map;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.navdrawer.MainActivity;
import com.example.navdrawer.R;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment {

    double lat, lon;
    String name;



//    private MapViewModel mapViewModel;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng latLng = new LatLng(lat, lon);
            float zoom = 17;
            googleMap.addMarker(new MarkerOptions().position(latLng).title(name));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,zoom));
            googleMap.getUiSettings().setZoomControlsEnabled(true);
            UiSettings settings = googleMap.getUiSettings();
            settings.setZoomControlsEnabled(true);
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        mapViewModel =
//                ViewModelProviders.of(this).get(MapViewModel.class);
        View root = inflater.inflate(R.layout.fragment_map, container, false);


//        final TextView textView = root.findViewById(R.id.text_slideshow);
//        mapViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

//        if (getArguments() != null) {
//            this.lat = getArguments().getDouble("lat");
//            this.lon = getArguments().getDouble("lon");
//            this.name = getArguments().getString("name");
//        }

//        Fragment fragment = new fragmentMap();
//        Bundle b =new Bundle();
//        b.putString("name", name);
//        b.putDouble("lat", lat);
//        b.putDouble("lon", lon);
//        fragment.setArguments(b);
//        FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.fragment, fragment, null);
//        fragmentTransaction.commit();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            lat = 19.2389;
            lon = -103.7653;
            name = "Torreon";
            if (getArguments() != null) {
                this.lat = getArguments().getDouble("lat");
           Log.d("TAGADENTRODELFRAGMENT", String.valueOf(lat));
                this.lon = getArguments().getDouble("lon");
            Log.d("TAGADENTRODELFRAGMENT2", String.valueOf(lon));
                this.name = getArguments().getString("name");
            Log.d("TAGADENTRODELFRAGMENT3", String.valueOf(name));
            }
            mapFragment.getMapAsync(callback);
        }
    }
}