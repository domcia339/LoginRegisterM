package com.example.domi.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText etName= (EditText) findViewById(R.id.etName);
        final EditText etSurname= (EditText) findViewById(R.id.etSurname);
        final EditText etPassword= (EditText) findViewById(R.id.etPassword);
        final EditText etUsername= (EditText) findViewById(R.id.etUsername);

        final Button bRegister= (Button) findViewById(R.id.bRegister);
    }

    private void TestAppLoad(){
        int i =1+1;
        int ii=2+2;
        int iiii=i+ii;
    }
}
