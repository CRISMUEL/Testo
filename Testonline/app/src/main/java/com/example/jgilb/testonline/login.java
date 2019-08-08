package com.example.jgilb.testonline;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

        EditText usuario;
        EditText contraseña;
        Button btn2;
        FirebaseAuth frb1;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            frb1 = FirebaseAuth.getInstance();

            usuario = findViewById(R.id.usuario);
            contraseña = findViewById(R.id.contraseña);
            btn2 = findViewById(R.id.btn2);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //login();
                    Intent i = new Intent (login.this, materias.class);
                    startActivity(i);
                }
            });
        }

        public void login () {

            final String user = usuario.getText().toString().trim();
            String password = contraseña.getText().toString().trim();

            //para que los edittext no esten vacios
            if (TextUtils.isEmpty(user)) {
                Toast.makeText(this, "Se debe ingresar un usuario", Toast.LENGTH_LONG).show();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Se debe ingresar una contraseña", Toast.LENGTH_LONG).show();
                return;
            }

            //creando el nuevo usuario
            frb1.signInWithEmailAndPassword(user, password).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {

                        Toast.makeText(login.this, "Bienvenido al sistema " + user, Toast.LENGTH_LONG).show();
                        Intent i = new Intent(login.this, materias.class);
                        startActivity(i);

                    } else {

                        Toast.makeText(login.this, "Este usuario no existe", Toast.LENGTH_LONG).show();

                    }
                }
            });

        }

    public void registrarse(View view) {

        Intent i = new Intent(login.this, registro.class);
        startActivity(i);


    }

    public void btn2(View view) {

        finish();
        System.exit(0);

    }
}
