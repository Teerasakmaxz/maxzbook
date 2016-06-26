package com.example.maxz.maxzbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class SignUPActivity extends AppCompatActivity {

    //ประกาศตัวแปร
    private EditText userEditText, passEditText, nameEditText, addressEditText;
    private String userString, passString, nameString, addressString;
    private static final String URLPHP = "http://swiftcodingthai.com/25JUN/add_user_maxz.php";
    private static final String money = "500";

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

        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("User", userString)
                .add("Password", passString)
                .add("Name", nameString)
                .add("Address", addressString)
                .add("Money", money)
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(URLPHP).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
             finish();
            }
        });





    }


}//main class
