package com.example.lab04p01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab04p01.databinding.ActivityMain2Binding;
import com.example.lab04p01.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    int[] obrazy = new int[]{R.drawable.wilk01,
            R.drawable.wilk02,
            R.drawable.wilk03,
            R.drawable.wilk04};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.a2Iv01.setImageResource(obrazy[0]);
        binding.a2Iv02.setImageResource(obrazy[1]);
        binding.a2Iv03.setImageResource(obrazy[2]);
        binding.a2Iv04.setImageResource(obrazy[3]);

        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                int do_wyslania;
                if(id == R.id.a2_iv_01)
                    do_wyslania = 0;
                else if(id == R.id.a2_iv_02)
                    do_wyslania = 1;
                else if(id == R.id.a2_iv_03)
                    do_wyslania = 2;
                else
                    do_wyslania = 3;
                Intent odpowiedz = new Intent();
                odpowiedz.putExtra("obrazek", obrazy[do_wyslania]);
                setResult(RESULT_OK, odpowiedz);
                finish();
            }
        };

        binding.a2Iv01.setOnClickListener(sluchacz);
        binding.a2Iv02.setOnClickListener(sluchacz);
        binding.a2Iv03.setOnClickListener(sluchacz);
        binding.a2Iv04.setOnClickListener(sluchacz);



    }
}