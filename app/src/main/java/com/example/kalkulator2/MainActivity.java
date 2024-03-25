package com.example.kalkulator2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void prosesHitung(View view){
        EditText angka1 = findViewById(R.id.angka1);
        EditText angka2 = findViewById(R.id.angka2);

        Spinner operator = findViewById(R.id.operator);
        String tipeOperator = String.valueOf(operator.getSelectedItem());

        Intent intent = new Intent(this, HasilPerhitungan.class);

        double nilai1 = Double.parseDouble(angka1.getText().toString());
        double nilai2 = Double.parseDouble(angka2.getText().toString());
        double hasil = 0;

        if(tipeOperator.equals("Tambah")){
            hasil = nilai1 + nilai2;
        }else if(tipeOperator.equals("Kurang")){
            hasil = nilai1 - nilai2;
        }else if(tipeOperator.equals("Kali")){
            hasil = nilai1 * nilai2;
        }else if(tipeOperator.equals("Bagi")){
            if(nilai2 != 0) {
                hasil = nilai1 / nilai2;
            }else{
                String pesanErrorNol = getString(R.string.psnErrNol);
                intent.putExtra("pesanError", pesanErrorNol);
            }

        }else if(tipeOperator.equals("Modulus")){
            hasil = nilai1 % nilai2;
        }

        intent.putExtra("hasil", hasil);
        startActivity(intent);
    }
}