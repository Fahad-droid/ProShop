package com.example.fahadshaikh.proshop;

/**
 * Created by fahadshaikh on 2017-04-24.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class NewUsersActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText email_text;
    private EditText password_text;
    private EditText phone_text;
    private Button save;
    private String phoneValue,emailValue,passwordValue;
    //private User user = new User();
    private User user = new User();

    private final AppCompatActivity activity = NewUsersActivity.this;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        databaseHelper = new DatabaseHelper(activity);
        email_text = (EditText)findViewById(R.id.email);
        password_text = (EditText)findViewById(R.id.password);
        phone_text = (EditText)findViewById(R.id.phone);


        save = (Button)findViewById(R.id.btn);



        save.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btn)
        {
            // emailValue = email_text.getText().toString();
            // passwordValue = email_text.getText().toString();
            //phoneValue = email_text.getText().toString();


            postDataToSQLite();


            Intent i = new Intent(getBaseContext(),MainActivity.class);
            startActivity(i);
        }
    }


    private void postDataToSQLite() {

        if (!databaseHelper.checkUser(email_text.getText().toString().trim())) {

            user.setName(phone_text.getText().toString().trim());
            user.setEmail(email_text.getText().toString().trim());
            user.setPassword(password_text.getText().toString().trim());

            databaseHelper.addUser(user);

            // Snack Bar to show success message that record saved successfully
            //  Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();


        } else {
            // Snack Bar to show error message that record already exists
            // Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }


    }


    private void emptyInputEditText() {
        email_text.setText(null);
        phone_text.setText(null);
        password_text.setText(null);
        //  textInputEditTextConfirmPassword.setText(null);
    }
}
