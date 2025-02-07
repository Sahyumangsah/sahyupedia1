package com.example.sahyupedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    TextView tvNamaBarangHeader, tvNamaBarang, tvJumlah;
    ImageView ivBarang;
    EditText etNamaBarang, etJumlah;
    Button btnBeli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        tvNamaBarangHeader = findViewById(R.id.textView);
        ivBarang = findViewById(R.id.imageView);
        tvNamaBarang = findViewById(R.id.textView2);
        etNamaBarang = findViewById(R.id.editText);
        tvJumlah = findViewById(R.id.textView3);
        etJumlah = findViewById(R.id.editText2);
        btnBeli = findViewById(R.id.button);



        tvNamaBarangHeader.setText("Raket");
        tvNamaBarang.setText("Alamat");
        ivBarang.setImageResource(R.drawable.raket1);


        btnBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaBarang = etNamaBarang.getText().toString();
                String jumlahString = etJumlah.getText().toString();

                if (namaBarang.isEmpty() || jumlahString.isEmpty()) {
                    Toast.makeText(MainActivity4.this, "Silahkan isi nama barang dan jumlah", Toast.LENGTH_SHORT).show();
                    return; // Stop further execution
                }

                int jumlah = Integer.parseInt(jumlahString);


                String message = "Anda membeli " + jumlah + " " + namaBarang;

                    Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                    startActivity(intent);


                etNamaBarang.setText("");
                etJumlah.setText("");

            }
        });
    }
}