package com.example.maxz.maxzbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUPActivity extends AppCompatActivity {

    //ประกาศตัวแปร
    private EditText userEditText, passEditText, nameEditText, addressEditText;
    private String userString, passString, nameString, addressString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        userEditText = (EditText) findViewById(R.id.editText);
        passEditText = (EditText) findViewById(R.id.editText2);
        nameEditText = (EditText) findViewById(R.id.editText3);
        addressEditText = (EditText) findViewById(R.id.editText4);


    }//main method

    public void clickSignUpSign(View view) {
        //get value form edittext
        userString = userEditText.getText().toString().trim();
        passString = passEditText.getText().toString().trim();
        nameString = nameEditText.getText().toString().trim();
        addressString = addressEditText.getText().toString().trim();

        // เช็คการกรอกครบไหม
        if (userString.equals("") ||
                passString.equals("") ||
                nameString.equals("") ||
                addressString.equals("")) {
            //มีช่องว่าง
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this,"มีช่องว่าง","กรุณากรอกทุกช่องครับ");

        } else {
            //ไม่มีช่องว่าง
            uploadUserToServer();



        }


    }//click signUP

    private void uploadUserToServer() {

    }


}//main class
