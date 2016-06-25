package com.example.maxz.maxzbook;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by maxz on 6/25/16 AD.
 */
public class MyAlert {

    public void myDialog(Context context,String strtitle,String strmessage) {

        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.nobita48);
        builder.setTitle(strtitle);
        builder.setMessage(strmessage);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

                dialogInterface.dismiss();

            }
        });
        builder.show();

    }


}//main class
