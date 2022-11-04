package com.example.receptordetrucades;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 *
 * @author Laura López - Novembre de 2018
 * Exemple per a crear un receptor de broadcast a partir d'una trucada entrant. Funciona amb APIs anteriors a la 28 (Android Pie) i també amb la 28
 */
public class MainActivity extends AppCompatActivity {
    public static final int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE = 999;  //Els identificadors dels permisos son arbitraris
    public static final int MY_PERMISSIONS_REQUEST_PROCESS_OUTGOING_CALLS = 999;
    public static final int MY_PERMISSIONS_REQUEST_READ_CALL_LOG = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Sol·licitem tots els permisos necessaris en temps d'execució. Aquest fet és imprescindible per garantir la compatibilitat amb l'API 28 i posteriors
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getApplicationContext().checkSelfPermission(Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // Es pregunta a l'usuari el permis
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_STATE},
                    MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
        }

        if (getApplicationContext().checkSelfPermission(Manifest.permission.PROCESS_OUTGOING_CALLS)
                != PackageManager.PERMISSION_GRANTED) {
            // Es pregunta a l'usuari el permis
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS},
                    MY_PERMISSIONS_REQUEST_PROCESS_OUTGOING_CALLS);
        }

        if (getApplicationContext().checkSelfPermission(Manifest.permission.READ_CALL_LOG)
                != PackageManager.PERMISSION_GRANTED) {
            // Es pregunta a l'usuari el permis
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CALL_LOG},
                    MY_PERMISSIONS_REQUEST_READ_CALL_LOG);
        }
    }
}
