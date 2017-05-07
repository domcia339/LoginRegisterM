package com.example.domi.loginregister;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etLogin= (EditText) findViewById(R.id.etLogin);
        final EditText etPassword= (EditText) findViewById(R.id.etPassword);
        final Button bLogin= (Button) findViewById(R.id.bLogin);
        final TextView registerLink= (TextView) findViewById(R.id.tvRegisterHere);

        registerLink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Opne refister page
                Intent registerIntent= new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);

            }
        });


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final  String login=etLogin.getText().toString();
                final  String password=etPassword.getText().toString();


                Response.Listener<String> responseListener= new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                String name= jsonResponse.getString("name");
                                String surname=jsonResponse.getString("surname");

                                Intent intent= new Intent(LoginActivity.this, UserAreaActivity.class);
                                intent.putExtra("name", name);
                                intent.putExtra("surname",surname);
                                intent.putExtra("login", login);
                                intent.putExtra("password", password);

                                LoginActivity.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder= new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            AlertDialog.Builder builder1= new AlertDialog.Builder(LoginActivity.this);
                            builder1.setMessage((CharSequence) e)
                                    .setNegativeButton("Retry",null)
                                    .create()
                                    .show();
                        }
                    }
                };

                LoginRequest loginRequest= new LoginRequest(login,password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}
