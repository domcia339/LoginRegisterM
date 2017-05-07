package com.example.domi.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

       /* final EditText etLogin=(EditText) findViewById(R.id.etLogin);
        final EditText etName=(EditText) findViewById(R.id.etName);
        final EditText etSurname=(EditText) findViewById(R.id.etSurname);
        final TextView welcomeMessage= (TextView) findViewById(R.id.tvWelcomeMsg);

        Intent intent =getIntent();
        String name= intent.getStringExtra("name");
        String surname=intent.getStringExtra("surname");
        String login=intent.getStringExtra("login");

        String message = name + "Welcome";
        welcomeMessage.setText(message);
        etLogin.setText(login);
        etName.setText(name);
        etSurname.setText(surname);*/
    }
}
