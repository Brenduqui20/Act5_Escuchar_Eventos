package com.example.act5evento;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent; // Asegúrate de que esta línea esté presente
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etN1;
    private EditText etN2;
    private EditText etN3;
    private TextView mayor;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etN1 = findViewById(R.id.etN1);
        etN2 = findViewById(R.id.etN2);
        etN3 = findViewById(R.id.etN3);

        mayor = findViewById(R.id.tvMayor);
        btnCalcular = findViewById(R.id.btnCalcular);

        etN1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    etN2.requestFocus();
                    return true;
                }
                return false;
            }
        });

        etN2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {

                    etN3.requestFocus();
                    return true;
                }
                return false;
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strN1 = etN1.getText().toString();
                String strN2 = etN2.getText().toString();
                String strN3 = etN3.getText().toString();

                int n1 = Integer.parseInt(strN1);
                int n2 = Integer.parseInt(strN2);
                int n3 = Integer.parseInt(strN3);

                int numeroMayor = (n1 > n2) ? ((n1 > n3) ? n1 : n3) : ((n2 > n3) ? n2 : n3);

                mayor.setText("El número mayor es: " + numeroMayor);
            }
        });


    }
}