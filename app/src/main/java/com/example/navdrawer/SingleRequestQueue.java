package com.example.navdrawer;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SingleRequestQueue {
    private static SingleRequestQueue instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    private SingleRequestQueue(Context context){
        ctx=context;
        requestQueue=getRequestQueue();
    }

    public static synchronized SingleRequestQueue getInstance(Context context){
        if (instance==null){
            instance = new SingleRequestQueue(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
