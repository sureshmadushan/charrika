package com.charrika.www.charrika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void btnRegister_Click(View v){
        Intent i=new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(i);

    }
    public void btnLogin_Click(View v){
        Intent i=new Intent(MainActivity.this,LoginActivity.class);
        startActivity(i);
    }
}
