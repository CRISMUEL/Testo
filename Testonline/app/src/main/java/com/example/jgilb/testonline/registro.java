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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class registro extends AppCompatActivity {

    Button btn1;
    Button btn2;
    EditText usuario;
    EditText contraseña;
    FirebaseAuth frb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        frb1 = FirebaseAuth.getInstance();

        usuario = findViewById(R.id.usuario);
        contraseña = findViewById(R.id.contraseña);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(registro.this, login.class);
                startActivity(i);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    public void register() {

        String user = usuario.getText().toString().trim();
        String password = contraseña.getText().toString().trim();

        //para que los edittext no esten vacios
        if (TextUtils.isEmpty(user)) {
            Toast.makeText(this, "Se debe ingresar un usuario", Toast.LENGTH_LONG).show();

        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Se debe ingresar una contraseña", Toast.LENGTH_LONG).show();

        }

        //creando el nuevo usuario
        frb1.createUserWithEmailAndPassword(user, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    Toast.makeText(registro.this, "Se ha registrado exitosamente", Toast.LENGTH_LONG).show();

                } else {

                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {//si presenta una colision

                        Toast.makeText(registro.this, "Ese usuario ya existe", Toast.LENGTH_SHORT).show();

                    }else{

                        Toast.makeText(registro.this, "No registrado, comprueba la conexion a internet", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
    }
}
