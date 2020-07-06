package com.example.navdrawer.adapters;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navdrawer.MainActivity;
import com.example.navdrawer.R;

import java.util.ArrayList;

public class PermissionsAdapter extends RecyclerView.Adapter<PermissionsAdapter.PermissionsViewHolder> {

    private ArrayList<String> permissions;
    private Context context;

    public PermissionsAdapter(ArrayList<String> permissions, Context cont) {
        this.permissions = permissions;
        this.context = cont;
    }

    @NonNull
    @Override
    public PermissionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_permissions, parent, false);
        return new PermissionsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PermissionsViewHolder holder, int position) {
        holder.sw.setText(permissions.get(position).replace("android.permission.", ""));
        holder.permission = permissions.get(position);
    }

    @Override
    public int getItemCount() {
        return permissions.size();
    }

    public class PermissionsViewHolder extends RecyclerView.ViewHolder {
        Switch sw;
        String permission;

        public PermissionsViewHolder(@NonNull View itemView) {
            super(itemView);
            sw = itemView.findViewById(R.id.sw1);
            sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (ContextCompat.checkSelfPermission((Activity) context, permission) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText((Activity) context, "Este permiso ya fue consedido", Toast.LENGTH_SHORT).show();
                    } else {
                        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permission)) {
                            new AlertDialog.Builder((Activity) context)
                                    .setTitle("Permiso Necesario")
                                    .setMessage("Necesitas este permiso para usar " + permission)
                                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            ActivityCompat.requestPermissions((Activity) context, new String[]{permission}, 1);
                                        }
                                    }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    sw.setChecked(false);
                                }
                            }).create().show();
                        } else {
                            ActivityCompat.requestPermissions((Activity) context, new String[]{permission}, 1);
                        }
                    }
                }
            });
        }
    }
}
