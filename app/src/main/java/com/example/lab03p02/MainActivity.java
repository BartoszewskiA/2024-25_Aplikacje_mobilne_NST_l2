package com.example.lab03p02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView iv_01, iv_02, iv_03, iv_04;
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
        iv_01 = findViewById(R.id.iv_01);
        iv_02 = findViewById(R.id.iv_02);
        iv_03 = findViewById(R.id.iv_03);
        iv_04 = findViewById(R.id.iv_04);

        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                int wybrany_rysunek=0;
                if(id == R.id.iv_01)
                    wybrany_rysunek = R.drawable.wilk01;
                else if(id == R.id.iv_02)
                    wybrany_rysunek = R.drawable.wilk02;
                else if(id == R.id.iv_03)
                    wybrany_rysunek = R.drawable.wilk03;
                else if(id == R.id.iv_04)
                    wybrany_rysunek = R.drawable.wilk04;

                Intent intencja = new Intent(MainActivity.this, MainActivity2.class);
                intencja.putExtra("rysunek", wybrany_rysunek);
                startActivity(intencja);
            }
        };

        iv_01.setOnClickListener(sluchacz);
        iv_02.setOnClickListener(sluchacz);
        iv_03.setOnClickListener(sluchacz);
        iv_04.setOnClickListener(sluchacz);

    }
}