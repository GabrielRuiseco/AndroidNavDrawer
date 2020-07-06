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
import com.example.navdrawer.fragmentMap;
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

        if (getArguments() != null) {
            this.lat = getArguments().getDouble("lat");
            this.lon = getArguments().getDouble("lon");
            this.name = getArguments().getString("name");
        }

        Fragment fragment = new fragmentMap();
        Bundle b =new Bundle();
        b.putString("name", name);
        b.putDouble("lat", lat);
        b.putDouble("lon", lon);
        fragment.setArguments(b);
        FragmentManager fragmentManager = MainActivity.this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment, fragment, null);
        fragmentTransaction.commit();
        return root;
    }
}