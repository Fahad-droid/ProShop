package com.example.fahadshaikh.proshop;

/**
 * Created by fahadshaikh on 2017-04-27.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
//package com.example.fahadshaikh.proshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by fahadshaikh on 2017-04-24.
 */

public class ConfirmPage extends AppCompatActivity {

    private  String emailvalue;
    private TextView text;
    public Button cartb;


    int price1 = 1000;
    int price2 = 900;
    int price3 = 900;

    int disc = 20;
    int disc1 = 45;
    int disc3 = 50;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private Button amount,sms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_confirm);
//        cartb = (Button)findViewById(R.id.cartb);
//
//
//        text = (TextView)findViewById(R.id.text2);

        //text.setText("Welcome : "+emailvalue);




    }


}
