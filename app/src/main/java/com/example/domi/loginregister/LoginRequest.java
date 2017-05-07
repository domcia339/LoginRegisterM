package com.example.domi.loginregister;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Domi on 07.05.2017.
 */

public class LoginRequest  extends StringRequest {

    private static final String LOGIN_REQUEST_URL="https://episodic-nights.000webhostapp.com/Login.php";
    private Map<String, String> params;

    public LoginRequest( String login, String password, Response.Listener<String> listener){
        super(Method.POST, LOGIN_REQUEST_URL, listener,null);
        params= new HashMap<>();
        params.put("login", login);
        params.put("password", password);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
