package com.example.domi.loginregister;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 * Created by Domi on 07.05.2017.
 */

public class SqlConnection extends AppCompatActivity {

   public static boolean dialog=false;
    public static void alterDialogShow(Context context, String mes){

        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setMessage(mes);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                // Handle your on click action
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }

    public static Connection dbConnector(){

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Domi","wbd2016");
            return conn;
        }catch(Exception e){
            dialog =true;
            //alterDialogShow(SqlConnection.this,e);
            System.out.println(e);

            return null;
        }

    }
}
