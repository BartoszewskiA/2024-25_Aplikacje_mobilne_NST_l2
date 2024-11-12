package com.example.lab02p01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tv_licznik;
    Button btn_plus;
    Button btn_minus;
    int licznik = 0;

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
        tv_licznik = findViewById(R.id.tv_licznik);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);

        tv_licznik.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                licznik=0;
                tv_licznik.setText(String.valueOf(licznik));
                return false;
            }
        });
//        btn_plus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                licznik++;
//                tv_licznik.setText(String.valueOf(licznik));
//            }
//        });
//
//        btn_minus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                licznik--;
//                tv_licznik.setText(String.valueOf(licznik));
//            }
//        });

        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if(id == R.id.btn_plus)
                    licznik++;
                else
                    licznik--;
                tv_licznik.setText(String.valueOf(licznik));
            }
        };
        btn_plus.setOnClickListener(sluchacz);
        btn_minus.setOnClickListener(sluchacz);




    }
}