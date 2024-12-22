package com.example.lab03p01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {

    EditText et_cena;
    Slider sb_raty;
    TextView tv_wynik;
    RadioGroup radioGroup01;
    RadioButton rb_01;
    RadioButton rb_02;
    RadioButton rb_03;
    CheckBox checkbox01;
    Button btn_licz;


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
        sb_raty = findViewById(R.id.slider_raty);
        tv_wynik = findViewById(R.id.tv_wynik);
        radioGroup01 = findViewById(R.id.radioGroup01);
        rb_01 = findViewById(R.id.rb_01);
        rb_02 = findViewById(R.id.rb_02);
        rb_03 = findViewById(R.id.rb_03);
        checkbox01 = findViewById(R.id.checkbox01);
        btn_licz = findViewById(R.id.btn_licz);
        sluchacze();


    }

    private void sluchacze() {
        btn_licz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                przelicz();
            }
        });
        sb_raty.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                przelicz();
            }
        });

        checkbox01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                przelicz();
            }
        });

        radioGroup01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                przelicz();
            }
        });

    }

    private void przelicz() {
        double cena =0;
        try {
            cena = Double.parseDouble(et_cena.getText().toString());
        } catch (Exception e)
        {
            Toast.makeText(this, "Wpisz cenę", Toast.LENGTH_SHORT).show();
            return;
        }
        double gwarancja=0;
        if (rb_01.isChecked())
            gwarancja = 0;
        else if(rb_02.isChecked())
            gwarancja = cena*0.15;
        else if(rb_03.isChecked())
            gwarancja = cena*0.3;

        double rata = (cena+gwarancja) / sb_raty.getValue();

        if(checkbox01.isChecked())
            rata +=10;

                String w ="";
        w+=String.valueOf(sb_raty.getValue());
        w+=" rat\n";
        w+=String.format("%.2f", rata);
        w+=" zł / mies";
        tv_wynik.setText(w);
    }
}