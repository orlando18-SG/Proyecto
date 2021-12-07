package com.example.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    private EditText email, password;
    private Button btnLogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        firebaseAuth=FirebaseAuth.getInstance();

        email = (EditText)findViewById(R.id.edUser);
        password = (EditText)findViewById(R.id.edPass);
        btnLogin = (Button)findViewById(R.id.btnIngresar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IniciarSesion();
            }
        });
    }

    private void IniciarSesion() {
        String user = email.getText().toString().trim();
        String contraseña = password.getText().toString().trim();

        if(TextUtils.isEmpty(user)){
            Toast.makeText(this, "Ingrese Usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(contraseña)){
            Toast.makeText(this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(user, contraseña)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(login.this,"Bienvenido: " + email.getText(),
                                    Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(login.this,MainActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(login.this, "Usuario o Contraseña Incorrecto",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}