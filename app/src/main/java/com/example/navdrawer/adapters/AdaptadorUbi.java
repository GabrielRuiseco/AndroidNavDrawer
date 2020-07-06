package com.example.navdrawer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navdrawer.R;
import com.example.navdrawer.Ubicacion;

import java.util.ArrayList;

public class AdaptadorUbi extends RecyclerView.Adapter<AdaptadorUbi.UbiHolder> implements OnClickListener{

    private ArrayList<Ubicacion> dl1;
    private Context context;
    private View.OnClickListener listener;

    public AdaptadorUbi(ArrayList<Ubicacion> dl1, Context context) {
        this.dl1 = dl1;
        this.context = context;
    }

    @NonNull
    @Override
    public AdaptadorUbi.UbiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_loc, parent, false);
        v.setOnClickListener(this);
        return new AdaptadorUbi.UbiHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorUbi.UbiHolder holder, int position) {
        holder.tx1.setText(dl1.get(position).getName());
        holder.tx2.setText(Double.toString(dl1.get(position).getLat()));
        holder.tx3.setText(Double.toString(dl1.get(position).getLon()));
    }

    @Override
    public int getItemCount() {
        return dl1.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class UbiHolder extends RecyclerView.ViewHolder {
        TextView tx1, tx2, tx3;

        public UbiHolder(@NonNull View itemView) {
            super(itemView);
            tx1 = itemView.findViewById(R.id.name_loc);
            tx2 = itemView.findViewById(R.id.lat_loc);
            tx3 = itemView.findViewById(R.id.lon_loc);
        }
    }
}
