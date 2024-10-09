package com.example.enguidanos.biometria_jaime;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Server {
    private static final String URL = "http://192.168.1.115:8080";
    public static void guardarMedicion(final String ozono, final String temp, RequestQueue requestqueue){
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error", error.toString());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> Params = new HashMap<>();
                Params.put("ozono", ozono);
                Params.put("temperatura", temp);
                return Params;
            }
        };
        requestqueue.add(stringRequest);
    }
}
