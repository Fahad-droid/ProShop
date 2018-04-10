package com.example.fahadshaikh.proshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by fahadshaikh on 2017-04-24.
 */

public class CartRegisteredUser extends AppCompatActivity implements View.OnClickListener
{

    private  String emailvalue;
    private TextView text;


    int price1 = 1000;
    int price2 = 900;
    int price3 = 900;

    int disc = 5;
    int disc1 = 5;
    int disc3 = 5;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private Button amount,sms;
    public Button cartb;
    private Button viewstore, prtopay;
    private Intent i;
    RelativeLayout iphoneLayout;
    RelativeLayout samsungLayout;
    RelativeLayout lgLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
        cartb = (Button)findViewById(R.id.cartb);
        prtopay = (Button)findViewById(R.id.prtopay);
        iphoneLayout = (RelativeLayout) findViewById(R.id.rl1);
        iphoneLayout.setVisibility(View.INVISIBLE);
        samsungLayout = (RelativeLayout) findViewById(R.id.rl2);
        samsungLayout.setVisibility(View.INVISIBLE);
        lgLayout = (RelativeLayout) findViewById(R.id.rl3);
        lgLayout.setVisibility(View.INVISIBLE);

        i = getIntent();

        Boolean check1 = getIntent().getExtras().getBoolean("check1");
        Boolean check2 = getIntent().getExtras().getBoolean("check2");
        Boolean check3 = getIntent().getExtras().getBoolean("check3");

        if(check1)
        {

            this.iphoneLayout.setVisibility(View.VISIBLE);
        }

        if(check2)
        {

            this.samsungLayout.setVisibility(View.VISIBLE);
        }

        if(check3)
        {

            this.lgLayout.setVisibility(View.VISIBLE);
        }




        //check1 =(CheckBox)findViewById(R.id.chkbox);
        //check2 =(CheckBox)findViewById(R.id.chkbox1);
        //check3 =(CheckBox)findViewById(R.id.chkbox2);

        viewstore = (Button) findViewById(R.id.viewstore);
        prtopay = (Button) findViewById(R.id.prtopay);
        amount = (Button)findViewById(R.id.amount);
      //  sms = (Button)findViewById(R.id.sms);

        viewstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CartRegisteredUser.this, StoreLocation.class);
                startActivity(i);
            }
        });

        prtopay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CartRegisteredUser.this, PaymentGateway.class);
                startActivity(i);
            }
        });


//        amount.setOnClickListener(this);
//        sms.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {


        double temp1 = 0.0;
        double temp2 = 0.0;
        double temp3 = 0.0;
        double temp = 0.0;
        if(v.getId() == R.id.amount)
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
            Toast.makeText(getBaseContext(),"Value : "+temp,Toast.LENGTH_LONG).show();
            amount.setText("Amount : "+temp);
        }
        else if(v.getId() == R.id.cartb)
        {

            Intent i = new Intent(getBaseContext(),CartUser.class);
            startActivity(i);
        }

    }
}
