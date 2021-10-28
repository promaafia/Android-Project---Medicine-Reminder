package com.example.bossthedevil.medicinereminder;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SPscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i= new Intent(SPscreen.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },3000);
    }
}
