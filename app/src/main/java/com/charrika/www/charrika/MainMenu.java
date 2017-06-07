package com.charrika.www.charrika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {
    private TextView txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        txtEmail=(TextView)findViewById(R.id.txtEmail);
        txtEmail.setText(getIntent().getExtras().getString("Email"));
    }
    public void onClick_HillSide(View v){
        Intent i=new Intent(MainMenu.this,HillSide.class);
        startActivity(i);

    }
    public void onClick_Safari(View v){
        //Intent i=new Intent(MainMenu.this,Safari.class);
        //startActivity(i);

    }
}
