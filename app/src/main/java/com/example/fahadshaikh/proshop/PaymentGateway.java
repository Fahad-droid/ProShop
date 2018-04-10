package com.example.fahadshaikh.proshop;

/**
 * Created by fahadshaikh on 2017-04-27.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.example.fahadshaikh.proshop.GMailSender;
import android.telephony.SmsManager;
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

public class PaymentGateway extends AppCompatActivity implements View.OnClickListener{

    private  String emailvalue;
    private TextView text;
    public Button cartb;
    public int temp;

    int price1 = 1000;
    int price2 = 900;
    int price3 = 900;

    int disc = 20;
    int disc1 = 45;
    int disc3 = 50;
    private CheckBox check1;
    private CheckBox check2;
    private CheckBox check3;
    private Button amount,sms,btnpaymnet, btnconfirm2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_page);
        cartb = (Button)findViewById(R.id.cartb);
        btnpaymnet = (Button)findViewById(R.id.btnpayment);
        btnconfirm2 = (Button)findViewById(R.id.btnconfirm);


        text = (TextView)findViewById(R.id.text2);

//        SmsManager manager = SmsManager.getDefault();
//        manager.sendTextMessage(6475355156,null,HI,null, null);

        btnconfirm2.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                try {
                    new mail().execute();
                   // String number = "+16475355156";  // The number on which you want to send SMS
                   // startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "Email/SMS sent Successfully",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

                Intent i = new Intent(PaymentGateway.this, ConfirmPage.class);
                startActivity(i);

            }


        });

        btnpaymnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),
                        "Payment Successfull !!",
                        Toast.LENGTH_LONG).show();


//                Intent i = new Intent(PaymentGateway.this, ConfirmPage.class);
//                startActivity(i);
            }
        });

        //text.setText("Welcome : "+emailvalue);




        check1 =(CheckBox)findViewById(R.id.chkbox);
        check2 =(CheckBox)findViewById(R.id.chkbox1);
        check3 =(CheckBox)findViewById(R.id.chkbox2);


        amount = (Button)findViewById(R.id.amount);
        // sms = (Button)findViewById(R.id.sms);

//        cartb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(CartUser.this, PaymentGateway.class);
//                i.putExtra("check1",check1.isChecked());
//                i.putExtra("check2",check2.isChecked());
//                i.putExtra("check3",check3.isChecked());
//                startActivity(i);
//            }
//        });


//        amount.setOnClickListener(PaymentGateway.this);
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
            Toast.makeText(getBaseContext(),"Value : "+temp,Toast.LENGTH_LONG).show();
            amount.setText("Amount : "+temp);
        }

        else// if(v.getId() == R.id.btnconfirm)
        {
//            try {
//
//                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
//                sendIntent.putExtra("Amount : " + temp, "default content");
//                sendIntent.setType("vnd.android-dir/mms-sms");
//                startActivity(sendIntent);
//
//            } catch (Exception e) {
//                Toast.makeText(getApplicationContext(),
//                        "SMS cannot be sent on Emulator !",
//                        Toast.LENGTH_LONG).show();
//                e.printStackTrace();
//            }


//            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
//            smsIntent.setType("vnd.android-dir/mms-sms");
//            smsIntent.putExtra("address","+1 437 777 2337");
//            smsIntent.putExtra("sms_body","your desired message");
//            startActivity(smsIntent);
//
//            Toast.makeText(getBaseContext(),"Thank you" ,Toast.LENGTH_LONG).show();

        }







    }

    class mail extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... params) {

            GMailSender sender = new GMailSender("mai6016@gmail.com", "webinfo2016176016");

            try {

                //System.out.println("SUB : "+email1);
                sender.sendMail("ProShop Inc.",
                        "Thank you for shopping with us. Your Order has been placed successfully. " +
                                "\n\nWe Hope to see you again soon. Should you have any questions, please contact us at 1800-SHOPPRO-#" +
                                " (# is your store number.)","fahad.droid@gmail.com","fahad.droid@gmail.com");



            } catch (Exception e) {

                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {

            super.onPostExecute(result);
           // System.out.println("Mail send>>"+ Validmail);
            Toast.makeText(PaymentGateway.this, "Email\'SMS Sent Successfully", Toast.LENGTH_LONG).show();


        }
    }

}
