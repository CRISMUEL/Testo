package com.example.jgilb.testonline;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jgilb.testonline.Model.Questions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class nature extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    TextView txt1;
    TextView time1;

    DatabaseReference datar1;

    int total = 0;
    int correct = 0;
    int wrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        txt1 = findViewById(R.id.txt1);
        time1 = findViewById(R.id.time1);

        updateQuestion();
        time(20, time1);

    }

    public void updateQuestion() {

        total++;
        if (total > 10) {

            //abre el resultado en otro activity
            Intent i = new Intent(nature.this, resultados.class);
            i.putExtra("total", String.valueOf(total));
            i.putExtra("correcto", String.valueOf(correct));
            i.putExtra("incorrecto", String.valueOf(wrong));
            startActivity(i);

        } else {

            datar1 = FirebaseDatabase.getInstance().getReference().child("nature").child(String.valueOf(total));
            datar1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    final Questions question = dataSnapshot.getValue(Questions.class);

                    txt1.setText(question.getQuestion());
                    btn1.setText(question.getOption1());
                    btn2.setText(question.getOption2());
                    btn3.setText(question.getOption3());

                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (btn1.getText().toString().equals(question.getAnswer())) {

                                Toast.makeText(getApplicationContext(), "Respuesta correcta ", Toast.LENGTH_SHORT).show();
                                btn1.setBackgroundColor(Color.GREEN);
                                correct = correct + 1;
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            } else {
                                //la respuesta verdadera sera la que se marque en azul, y la incoorecta es rojo

                                Toast.makeText(getApplicationContext(), "Respuesta incorrecta ", Toast.LENGTH_SHORT).show();
                                wrong = wrong + 1;
                                btn1.setBackgroundColor(Color.RED);

                                if (btn2.getText().toString().equals((question.getAnswer()))) {

                                    btn2.setBackgroundColor(Color.GREEN);

                                } else if (btn3.getText().toString().equals(question.getAnswer())) {

                                    btn3.setBackgroundColor(Color.GREEN);

                                }

                                Handler handler1 = new Handler();
                                handler1.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 1500);
                            }
                        }
                    });

                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (btn2.getText().toString().equals(question.getAnswer())) {

                                Toast.makeText(getApplicationContext(), "Respuesta correcta ", Toast.LENGTH_SHORT).show();
                                btn2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct = correct + 1;
                                        btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            } else {
                                //la respuesta verdadera sera la que se marque en azul, y la incoorecta es rojo

                                Toast.makeText(getApplicationContext(), "Respuesta incorrecta ", Toast.LENGTH_SHORT).show();
                                wrong = wrong + 1;
                                btn2.setBackgroundColor(Color.RED);

                                if (btn1.getText().toString().equals((question.getAnswer()))) {

                                    btn1.setBackgroundColor(Color.GREEN);

                                } else if (btn3.getText().toString().equals(question.getAnswer())) {

                                    btn3.setBackgroundColor(Color.GREEN);

                                }

                                Handler handler1 = new Handler();
                                handler1.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 1500);
                            }

                        }
                    });

                    btn3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (btn3.getText().toString().equals(question.getAnswer())) {

                                Toast.makeText(getApplicationContext(), "Respuesta correcta ", Toast.LENGTH_SHORT).show();
                                btn3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct = correct + 1;
                                        btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            } else {
                                //la respuesta verdadera sera la que se marque en azul, y la incoorecta es rojo

                                Toast.makeText(getApplicationContext(), "Respuesta incorrecta ", Toast.LENGTH_SHORT).show();
                                wrong = wrong + 1;
                                btn3.setBackgroundColor(Color.RED);

                                if (btn1.getText().toString().equals((question.getAnswer()))) {

                                    btn1.setBackgroundColor(Color.GREEN);

                                } else if (btn2.getText().toString().equals(question.getAnswer())) {

                                    btn2.setBackgroundColor(Color.GREEN);

                                }

                                Handler handler1 = new Handler();
                                handler1.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        btn1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        btn3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();

                                    }
                                }, 1500);
                            }
                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
    }
    public void time(int Seconds, final TextView time1){

        new CountDownTimer(Seconds * 1000 + 1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds/60;
                seconds = seconds % 60;
                time1.setText(String.format("%02d", minutes) + ":" + String.format("%02d", seconds));

            }

            @Override
            public void onFinish() {

                time1.setText("Completado");
                Intent i = new Intent(nature.this, resultados.class);
                i.putExtra("total", String.valueOf(total));
                i.putExtra("correcto", String.valueOf(correct));
                i.putExtra("incorrecto", String.valueOf(wrong));
                startActivity(i);
            }

        }.start();

    }

    //Boton atras
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //preventing default implementation previous to android.os.Build.VERSION_CODES.ECLAIR
            Toast.makeText(getApplicationContext(), "No puede regresar, termina de realizar el examen", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
