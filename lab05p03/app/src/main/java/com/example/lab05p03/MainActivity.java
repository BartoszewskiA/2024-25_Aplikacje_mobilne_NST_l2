package com.example.lab05p03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn = findViewById(R.id.btn_01);
        et = findViewById(R.id.et_01);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                double x=0;
//                try {
//                    x = Double.parseDouble(et.getText().toString());
//
//                } catch (Exception e) {
//                    Toast.makeText(MainActivity.this, "Brak danych", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                if (et.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Brak danych", Toast.LENGTH_SHORT).show();
                    return;
                }
                double x = Double.parseDouble(et.getText().toString());
            }
        });

    }
}