package com.example.lab02p02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et_cena;
    TextView tv_wynik;
    SeekBar sb_raty;
    Button btn_oblicz;

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
        et_cena = findViewById(R.id.et_cena);
        tv_wynik = findViewById(R.id.tv_wynik);
        sb_raty = findViewById(R.id.sb_raty);
        btn_oblicz = findViewById(R.id.btn_oblicz);

        btn_oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                przelicz();
            }
        });

        sb_raty.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                przelicz();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    private void przelicz() {
        double cena =0;
        try {
            cena = Double.parseDouble(et_cena.getText().toString());
        } catch (Exception e)
        {
            return;
        }
        double rata = cena / sb_raty.getProgress();
        String w ="";
        w+=String.valueOf(sb_raty.getProgress());
        w+=" rat\n";
        w+=String.format("%.2f", rata);
        w+=" zł / mies";
        tv_wynik.setText(w);
    }
}