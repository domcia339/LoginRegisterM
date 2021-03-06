package com.example.domi.loginregister;

import android.support.v7.app.AlertDialog;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Domi on 07.05.2017.
 */

public class RegisterRequest extends StringRequest{

    private static final String REGISTER_REQUEST_URL="https://episodic-nights.000webhostapp.com/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String name, String surname, String login, String password, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener,null);
        params= new HashMap<>();
        params.put("name", name);
        params.put("surname", surname);
        params.put("login", login);
        params.put("password", password);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
