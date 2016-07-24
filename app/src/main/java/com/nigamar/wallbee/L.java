package com.nigamar.wallbee;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Appy on 24/07/16.
 */

public class L {
    static final String TAG="NIGAMAR";
    public static void d(String message){
        Log.d(TAG,message);
    }
    public static void t(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
