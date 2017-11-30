package com.example.androidfirewall.callsilent.CallStateUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;

import com.example.androidfirewall.callsilent.DBUtils.DBHelper;

import java.util.ArrayList;


public class PhoneStateReceiver extends BroadcastReceiver {

    AudioManager audioManager;
    DBHelper mydb;
    ArrayList<String> numbersList;
    static int initialState;
    int k = 0;

    @Override
    public void onReceive(final Context context, Intent intent) {

        mydb = new DBHelper(context);
        numbersList = new ArrayList<>();
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        Cursor res = mydb.getAllData();
        while (res.moveToNext()) {
            numbersList.add(res.getString(2));
        }

        if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING)){
            initialState = audioManager.getRingerMode();

            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            if (numbersList != null){
                for (int i=0;i<numbersList.size();i++){
                    String no = numbersList.get(i);
                    if (PhoneNumberUtils.compare(no, incomingNumber)){
                        audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                        break;
                    }
                }
            }
        }

        else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_IDLE)){
            if (initialState == 2) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            }
        }

    }

}
