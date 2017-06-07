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

public class RegisterActivity extends AppCompatActivity {
    private EditText txtEmailReg;
    private EditText txtPassReg;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        txtEmailReg=(EditText)findViewById(R.id.txtEmailReg);
        txtPassReg=(EditText)findViewById(R.id.txtPassReg);
        firebaseAuth=FirebaseAuth.getInstance();


    }

    public void btnRegister_Click(View v){
        final ProgressDialog progressDialog=ProgressDialog.show(RegisterActivity.this,"Please wait...","Processing...",true);
        (firebaseAuth.createUserWithEmailAndPassword(txtEmailReg.getText().toString(),txtPassReg.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task){
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"Registration successful",Toast.LENGTH_LONG).show();
                            Intent i=new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(i);
                        }
                        else{
                            Log.e("ERROR",task.getException().toString());

                            Toast.makeText(RegisterActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }

                    }}

                );

    }
}

