package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.Timer;
import java.util.TimerTask;

public class backServiceDemo extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("EnvioAutomatico", "se inicio el servicio");

        final LocationLibrary ubicacion = new LocationLibrary(this, "Act3Konfio");

        //myTask = new MyTask();
        //myTask.execute();

        //startCheckThread();

        final Handler handler = new Handler();
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            //Ejecuta tu AsyncTask!
                            AsyncTask myTask = new AsyncTask() {
                                @Override
                                protected Object doInBackground(Object[] objects) {
                                    //System.out.println("holaaaaaaqa");
                                    LatLng coordenadas = ubicacion.getLocation().getUbicacion();
                                    System.out.println("Lat : " + coordenadas.latitude + "Lon : " + coordenadas.longitude);
                                    return null;
                                }
                            };
                            myTask.execute();
                        } catch (Exception e) {
                            Log.e("error", e.getMessage());
                        }
                    }
                });
            }
        };

        timer.schedule(task, 0, 5000);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        //isService = false;
        super.onDestroy();
        System.out.println("se acabo el servicio");
        //System.out.println(“El servicio a Terminado”);
    }

    /*private void ejecutar(){
        final Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                metodoEjecutar();//llamamos nuestro metodo
                handler.postDelayed(this,30000);//se ejecutara cada 10 segundos
            }
        },5000);//empezara a ejecutarse después de 5 milisegundos
    }
    private void metodoEjecutar() {
        System.out.println("que pedooo?");
    }*/
}
