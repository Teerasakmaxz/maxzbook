package com.example.maxz.maxzbook;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //ประกาศตัวแปร
    private EditText userEditText, passworkEditText;
    private String userString, passwordString;
    private static final String URLJson = "http://swiftcodingthai.com/25JUN/php_get_maxz.php";
    private boolean stausABoolean = true;
    private String truePasswordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind
        userEditText = (EditText) findViewById(R.id.editText5);
        passworkEditText = (EditText) findViewById(R.id.editText6);

    }//onCreate main method



    //inner class
    private class SynUserTABLE extends AsyncTask<Void, Void, String> {


        @Override
        protected String doInBackground(Void... params) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(URLJson).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                Log.d("26June", "e==>" + e.toString());
                return null;
            }

        }//doINBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("26June", "Json ==>" + s);
            try {

                JSONArray jsonArray = new JSONArray(s);
                for (int i=0;i<jsonArray.length();i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (userString.equals(jsonObject.getString("User"))) {
                        stausABoolean = false;
                        truePasswordString = jsonObject.getString("Password");
                    } else {
                    }

                }//for

                if (stausABoolean) {
                    MyAlert myAlert = new MyAlert();
                    myAlert.myDialog(MainActivity.this,"ไม่มี User นี้","ไม่มี"+userString+"ในฐานข้อมูล");

                } else if (passwordString.equals(truePasswordString)) {
                    Intent intent = new Intent(MainActivity.this, ShowBook.class);
                    startActivity(intent);
                    finish();
                } else {
                    MyAlert myAlert = new MyAlert();
                    myAlert.myDialog(MainActivity.this,"Password ผิด","กรุณากรอกให้ถูก");
                }


            } catch (Exception e) {
                Log.d("26June", "e onPost ==>" + e.toString());
            }

    }//Onpost

    }//class


    public void clickSignIN(View view) {
        userString = userEditText.getText().toString().trim();
        passwordString = passworkEditText.getText().toString().trim();
        if (userString.equals("") || passwordString.equals("")) {

            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "มีช่องว่าง", "กรุณากรอกทุกช่อง");

        } else {

            SynUserTABLE synUserTABLE = new SynUserTABLE();
            synUserTABLE.execute();

        }//if


    }//clickSignIN

    public void clickSignUP(View view) {

        startActivity(new Intent(MainActivity.this, SignUPActivity.class));

    }//clickSignUP

}//main class
