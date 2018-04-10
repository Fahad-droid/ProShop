package com.example.fahadshaikh.proshop;

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

public class ProdUserActivity extends AppCompatActivity implements View.OnClickListener
{

    private  String emailvalue;
    private TextView text;
    private Button cartr;

    int price1 = 1000;
    int price2 = 900;
    int price3 = 900;

    int disc = 5;
    int disc1 = 5;
    int disc3 = 5;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private Button amountr,sms;
    private Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prod_disc);
        cartr = (Button)findViewById(R.id.cartr);

        i = getIntent();

        emailvalue = i.getStringExtra("EMAIL");

        text = (TextView)findViewById(R.id.text1);

        text.setText("Welcome : "+emailvalue);




        check1 =(CheckBox)findViewById(R.id.chkbox);
        check2 =(CheckBox)findViewById(R.id.chkbox1);
        check3 =(CheckBox)findViewById(R.id.chkbox2);


        amountr = (Button)findViewById(R.id.amountr);
        //sms = (Button)findViewById(R.id.sms);


        cartr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProdUserActivity.this, CartUser.class);
                i.putExtra("check1",check1.isChecked());
                i.putExtra("check2",check2.isChecked());
                i.putExtra("check3",check3.isChecked());
                startActivity(i);
            }
        });

       amountr.setOnClickListener(this);
  //      sms.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        double temp1 = 0.0;
        double temp2 = 0.0;
        double temp3 = 0.0;
        double temp = 0.0;
        if(v.getId() == R.id.amountr)
        {

            double result = price1/100;
            double firstprice1 = result * (100-disc);
            // check1.setText(firstprice1.);

            double result1 = price2/100;
            double firstprice2 = result1 * (100-disc1);

            double result2 = price3/100;
            double firstprice3 = result2 * (100-disc3);

            if(check1.isChecked())
            {

                temp1 = firstprice1;
            }
            if(check2.isChecked())
            {
                temp2 = firstprice2;
            }

            if(check3.isChecked())
            {
                temp3 = firstprice3;
            }


            temp = temp1 + temp2 + temp3;
            Toast.makeText(getBaseContext(),"Added to cart",Toast.LENGTH_LONG).show();
            amountr.setText("Cart Total : "+temp);
        }
//        else if(v.getId() == R.id.sms)
//        {
//            try {
//
//                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
//                sendIntent.putExtra("Amount : "+temp, "default content");
//                sendIntent.setType("vnd.android-dir/mms-sms");
//                startActivity(sendIntent);
//
//            } catch (Exception e) {
//                Toast.makeText(getApplicationContext(),
//                        "SMS cannot be sent on Emulator !",
//                        Toast.LENGTH_LONG).show();
//                e.printStackTrace();
//            }
//
//        }

    }
}
