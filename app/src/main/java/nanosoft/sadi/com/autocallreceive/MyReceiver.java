package nanosoft.sadi.com.autocallreceive;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Nanosoft-Android on 3/19/2018.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        TelephonyManager telephonyManager = null;
        PhoneStateListener listener = new PhoneStateListener()
        {
            @SuppressLint("WrongConstant")
            public void onCallStateChanged(int state, String incomingNumber)
            {
                switch (state)
                {
                    case TelephonyManager.CALL_STATE_IDLE:
                        Toast.makeText(context, "Call Ended..", Toast.LENGTH_LONG).show();
                        Log.i("stop", "Call Ended....");
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        Toast.makeText(context, "Call Picked..", Toast.LENGTH_LONG) .show();
                        Log.i("received", "Call Picked....");
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                        Toast.makeText(context, "Call Ringing.." + incomingNumber,5000).show();
                        break;
                }
            }
        };
        // Register the listener with the telephony manager
        telephonyManager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
    }
}
