package com.example.maxz.maxzbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }//onCreate main method
    public void clickSignUP (View view){

        startActivity(new Intent(MainActivity.this,SignUPActivity.class));

    }

}//main class
