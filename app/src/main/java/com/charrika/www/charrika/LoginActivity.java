package com.charrika.www.charrika;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText txtEmailLog;
    private EditText txtPassLog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        txtEmailLog=(EditText)findViewById(R.id.txtEmailLog);
        txtPassLog=(EditText)findViewById(R.id.txtPassLog);
        firebaseAuth=FirebaseAuth.getInstance();
    }
    public void btnLogin_Click(View v){
    final ProgressDialog progressDialog=ProgressDialog.show(LoginActivity.this,"Please wait ...","Proccessing...",true);
        (firebaseAuth.signInWithEmailAndPassword(txtEmailLog.getText().toString(),txtPassLog.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this,"Login successful",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(LoginActivity.this,MainMenu.class);
                    i.putExtra("Email",firebaseAuth.getCurrentUser().getEmail());
                    startActivity(i);

                }else{
                    Log.e("ERROR",task.getException().toString());
                    Toast.makeText(LoginActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
