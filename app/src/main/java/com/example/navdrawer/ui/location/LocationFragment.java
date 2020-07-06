package com.example.navdrawer.ui.location;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.navdrawer.R;
import com.example.navdrawer.SingleRequestQueue;
import com.example.navdrawer.Ubicacion;
import com.example.navdrawer.adapters.AdaptadorUbi;
import com.example.navdrawer.fragmentMap;
import com.example.navdrawer.ui.map.MapFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class LocationFragment extends Fragment {

    JSONArray jsonArray;
    ArrayList<Ubicacion> ubications = new ArrayList<>();
    RecyclerView recyclerView;
    private LocationViewModel locationViewModel;
    NavController navController;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        locationViewModel =
                ViewModelProviders.of(this).get(LocationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_location, container, false);
////        final TextView textView = root.findViewById(R.id.text_location);
////        locationViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
////            @Override
////            public void onChanged(@Nullable String s) {
////                textView.setText(s);
////            }
//        });
        recuperateUbi(root);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= Navigation.findNavController(view);
    }

    private void recuperateUbi(final View v) {
        String url = "http://ramiro174.com/api/recuperargps";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getContext(), "Success", Toast.LENGTH_LONG).show();
                try {
                    jsonArray = response.getJSONArray("data");
                    Gson gson=new Gson();
                    Type ubicasionType = new TypeToken<ArrayList<Ubicacion>>(){}.getType();
                    ubications=gson.fromJson(String.valueOf(jsonArray),ubicasionType);
                    Log.d("TAG", ubications.toString());

                    recyclerView = (RecyclerView) v.findViewById(R.id.Recycler2);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    AdaptadorUbi adaptadorUbi = new AdaptadorUbi(ubications, getContext());
                    adaptadorUbi.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Bundle bundle = new Bundle();
                            bundle.putString("name", ubications.get(recyclerView.getChildAdapterPosition(view)).getName());
                            Log.d("TAG NAME", String.valueOf(ubications.get(recyclerView.getChildAdapterPosition(view)).getName()));
                            bundle.putFloat("lat", ubications.get(recyclerView.getChildAdapterPosition(view)).getLat());
                            Log.d("TAG2", String.valueOf(ubications.get(recyclerView.getChildAdapterPosition(view)).getLon()));
                            bundle.putFloat("lon", ubications.get(recyclerView.getChildAdapterPosition(view)).getLon());

                            navController.navigate(R.id.nav_map, bundle);
                        }
                    });
                    recyclerView.setAdapter(adaptadorUbi);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        });
        SingleRequestQueue.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);
    }

}