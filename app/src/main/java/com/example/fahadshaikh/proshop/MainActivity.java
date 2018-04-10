package com.example.fahadshaikh.proshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailt;
    private EditText passwordt;
    private Button loginBtn;
    private Button RegisterBtn;
    private Button Guestbtn;
    private TextView text;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(MainActivity.this);
        text= (TextView)findViewById(R.id.text1);
        emailt = (EditText)findViewById(R.id.emailt);
        passwordt = (EditText)findViewById(R.id.passwordt);
        loginBtn = (Button)findViewById(R.id.loginBtn);
        RegisterBtn = (Button)findViewById(R.id.RegisterBtn);
        Guestbtn = (Button) findViewById(R.id.Guesttbtn);
        loginBtn.setOnClickListener(this);
        RegisterBtn.setOnClickListener(this);
        Guestbtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        if(v.getId() == R.id.loginBtn)
        {

            verifyFromSQLite();


        }
        else if(v.getId() == R.id.RegisterBtn)
        {

            Intent i = new Intent(getBaseContext(),NewUsersActivity.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.Guesttbtn)
        {
            Intent i = new Intent(getBaseContext(),ProdGuestActivity.class);
            startActivity(i);

        }

    }

    private void verifyFromSQLite() {

        if (databaseHelper.checkUser(emailt.getText().toString().trim()
                , passwordt.getText().toString().trim())) {


            Intent i = new Intent(getBaseContext(),ProdUserActivity.class);
            i.putExtra("EMAIL", emailt.getText().toString().trim());
            emptyInputEditText();

            startActivity(i);

        } else {
            // Snack Bar to show success message that record is wrong
            Toast.makeText(getBaseContext(), "Invalid Details", Toast.LENGTH_SHORT).show();
            //   Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }
    }

    private void emptyInputEditText() {
        emailt.setText(null);

        passwordt.setText(null);
        //  textInputEditTextConfirmPassword.setText(null);
    }
}