package com.example.appsorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editTextMin, editTextMax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewResultado);
        editTextMin = findViewById(R.id.editTextTextMin);
        editTextMax = findViewById(R.id.editTextTextMax);
    }

    public void sorteia(View view) {
        Integer min = null, max = null;

        if (!editTextMin.getText().toString().trim().isEmpty()){
            min = Integer.parseInt(editTextMin.getText().toString());
        }

        if (!editTextMax.getText().toString().trim().isEmpty()) {
            max = Integer.parseInt(editTextMax.getText().toString());
        }

        if (min == null || max == null){
            textView.setText("Há campo(s) vazio(s). Por favor, preencha-o(s)!");
        }else if (min>max) {
            textView.setText("O valor mínimo não pode ser maior que o valor máximo.");
        }else{
            int result = new Random().nextInt(max-min)+min;
            textView.setText("O valor gerado foi: " + Integer.toString(result) + ".");
        }
    }
}