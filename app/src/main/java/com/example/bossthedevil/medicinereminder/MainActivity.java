package com.example.bossthedevil.medicinereminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
EditText username,mobile;
    private static final String REGISTER_URL = "http://192.168.0.107/reminder/adduser.php";

    // private static final String REGISTER_URL = "http://192.168.164.2/data/bal/connect.php";



ProgressBar progressBarlog;


    public static final String KEY_FULLNAME = "mail";
    // public static final String KEY_SURENAME = "surename";
    public static final String KEY_MOBILE = "mobile";
Button button;
  /*  private static final String REGISTER_URL = "https://themexpert.net/dakmama/change_password.php";
    public static final String KEY_USERNAME = "muser_name";
    public static final String KEY_EMAIL= "email";*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, MainMenu.class));
            return;


        }

        username=findViewById(R.id.username);
        mobile=findViewById(R.id.mobile);
        progressBarlog=findViewById(R.id.progbarlog);
        progressBarlog.setVisibility(View.GONE);
       button=findViewById(R.id.sub);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               reguser();
           }
       });

    }
   /* public  void usercreat(){
        String nameu= username.getText().toString();
        String passu= mobile.getText().toString();

        if(nameu!=null &&passu!=null){
            SharedPrefManager.getInstance(this).storeuserName(nameu);
            SharedPrefManager.getInstance(this).storeuserPass(passu);

            Toast.makeText(MainActivity.this,"User Creation  Success",Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity.this,MainMenu.class);
            startActivity(i);
            finish();

        }
    }*/
    private void reguser() {
        final String sname = username.getText().toString().trim();

        final String smobile = mobile.getText().toString().trim();








        if (sname.equals("")||smobile.equals("")) {

            Toast.makeText(MainActivity.this,"Required field are Missing",Toast.LENGTH_LONG).show();

        }else{

            progressBarlog.setVisibility(View.VISIBLE);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            SharedPrefManager.getInstance(getApplicationContext()).storeuserName(sname);
                            SharedPrefManager.getInstance(getApplicationContext()).storeuserPass(smobile);
                            progressBarlog.setVisibility(View.GONE);
                            Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                            Intent i= new Intent(MainActivity.this,MainMenu.class);
                            startActivity(i);
                            finish();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                            error.printStackTrace();
                        }
                    }){
                @Override
                protected Map<String,String> getParams(){
                    Map<String,String> params = new HashMap<String, String>();
                    params.put(KEY_FULLNAME,sname);

                    params.put(KEY_MOBILE,smobile);


                    return params;
                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }
    }





}

