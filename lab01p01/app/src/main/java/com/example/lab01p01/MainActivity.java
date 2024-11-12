package com.example.lab01p01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText01, editText02;
    TextView textView03;
    Button button01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText01 = findViewById(R.id.editText01);
        editText02 = findViewById(R.id.editText02);
        textView03 = findViewById(R.id.textView03);
        button01 = findViewById(R.id.button01);

    }

    public void oblicz(View view) {
        String s1,s2;
        int a=0,b=0;
        s1 = editText01.getText().toString();
        if(!s1.isEmpty())
        {
            a = Integer.parseInt(s1);
        }
        else
        {
            a=0;
            editText01.setText("0");
        }
        s2 = editText02.getText().toString();
        if(!s2.isEmpty())
        {
            b=Integer.parseInt(s2);
        }
        else
        {
            b=0;
            editText02.setText("0");
        }
        int wynik = a + b;
        textView03.setText(String.valueOf(wynik));
    }
}