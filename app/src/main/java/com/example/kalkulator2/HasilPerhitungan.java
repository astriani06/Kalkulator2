package com.example.kalkulator2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HasilPerhitungan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_perhitungan);

        Intent intent = getIntent();

        TextView tampilHitung = findViewById(R.id.tampilHitung);

        if(intent.hasExtra("pesanError")){
            tampilHitung.setText(intent.getStringExtra("pesanError"));
        }else {
            tampilHitung.setText(String.valueOf(intent.getDoubleExtra("hasil", 0)));
        }
    }
}