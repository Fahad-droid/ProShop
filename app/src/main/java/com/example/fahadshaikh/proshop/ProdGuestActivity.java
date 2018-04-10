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

public class ProdGuestActivity extends AppCompatActivity implements View.OnClickListener{

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
        setContentView(R.layout.prod_guest);
        cartb = (Button)findViewById(R.id.cartb);


        text = (TextView)findViewById(R.id.text2);

        //text.setText("Welcome : "+emailvalue);




        check1 =(CheckBox)findViewById(R.id.chkbox);
        check2 =(CheckBox)findViewById(R.id.chkbox1);
        check3 =(CheckBox)findViewById(R.id.chkbox2);


        amount = (Button)findViewById(R.id.amount);
        // sms = (Button)findViewById(R.id.sms);

    cartb.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i = new Intent(ProdGuestActivity.this, CartUser.class);
        i.putExtra("check1",check1.isChecked());
        i.putExtra("check2",check2.isChecked());
        i.putExtra("check3",check3.isChecked());
        startActivity(i);
    }
});


        amount.setOnClickListener(ProdGuestActivity.this);
        //   sms.setOnClickListener(GuestActivity.this);

    }

   @Override
    public void onClick(View v) {

        if(v.getId() == R.id.amount)
        {



            double temp1 = 0.0;
            double temp2 = 0.0;
            double temp3 = 0.0;
            double temp = 0.0;
            if(check1.isChecked())
            {

                temp1 = price1;
            }
            if(check2.isChecked())
            {
                temp2 = price2;
            }

            if(check3.isChecked())
            {
                temp3 = price3;
            }


            temp = temp1 + temp2 + temp3;
            Toast.makeText(getBaseContext(),"Added to cart",Toast.LENGTH_LONG).show();
            amount.setText("Cart Total : "+temp);
        }






    }
}
