package com.example.myapplication;

import com.google.android.gms.maps.model.LatLng;

public class LocationProvider {

    private LatLng ubicacion;
    private String provider;

    public LocationProvider() {
    }

    public LatLng getUbicacion() {
        return ubicacion;
    }

    public String getProvider() {
        return provider;
    }

    public void setUbicacion(LatLng ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
