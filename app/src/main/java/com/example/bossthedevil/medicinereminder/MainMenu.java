package com.example.bossthedevil.medicinereminder;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {

    Button add,edit,del;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        add=findViewById(R.id.adddata);
        edit=findViewById(R.id.edit);
      //  del=findViewById(R.id.deldata);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainMenu.this,Setalaram.class);
                startActivity(i);
                finish();
            }
        });
       edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"get",Toast.LENGTH_LONG).show();

            }
        });
        //edit.setOnClickListener(this);
       // del.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

/*if(v.getId()== R.id.adddata){
    Intent i= new Intent(MainMenu.this,SetReminder.class);
    startActivity(i);
    finish();
}
if(v.getId()== R.id.edit){
    Intent i= new Intent(MainMenu.this,SetReminder.class);
    startActivity(i);
    finish();
}*/
/*if(v.getId()== R.id.deldata){
   // Intent i= new Intent(MainMenu.this,SetReminder.class);
   // startActivity(i);

   // finish();
}
   */ }

    @Override
    public void onBackPressed() {
        this.finish();

            }
}
