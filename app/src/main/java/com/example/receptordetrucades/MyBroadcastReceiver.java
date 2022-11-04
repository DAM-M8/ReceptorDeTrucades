package com.example.receptordetrucades;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;


public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Action: " + intent.getAction() + "\n");
        sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
        String log = sb.toString();
        Log.d(TAG, log);
        Toast.makeText(context, log, Toast.LENGTH_LONG).show();
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        Toast.makeText(context, state, Toast.LENGTH_LONG).show();

            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)){ //
                Log.e(TAG, "Inside EXTRA_STATE_RINGING");
                String number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.e(TAG, "Trucada entrant: " + number);
                Toast toast = Toast.makeText(context, "Numero de la trucada entrant: " + number, Toast.LENGTH_SHORT);
                toast.show();
                Log.d("Receptor Anunci: ", number + " intent="+ intent);
            }
            else if(state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
                Log.d(TAG, "Inside EXTRA_STATE_IDLE");
            }
    }



}
