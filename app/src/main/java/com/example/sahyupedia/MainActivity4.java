package com.example.sahyupedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity4 extends AppCompatActivity {

    private Button gachaButton;
    private TextView diamondCountTextView;
    private int diamondCount = 100;
    private Button kembaliButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gachaButton = findViewById(R.id.gachaButton);
        diamondCountTextView = findViewById(R.id.diamondCountTextView);
        kembaliButton = findViewById(R.id.bckButton);
        updateDiamondCount();

        gachaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performGacha();
            }
        });

        kembaliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }


    private void performGacha() {
        if (diamondCount >= 10) {
            diamondCount -= 10;
            updateDiamondCount();

            Random random = new Random();
            int randomNumber = random.nextInt(100);

            Intent intent = new Intent(MainActivity4.this, MainActivity5.class);

            if (randomNumber < 50) {
                intent.putExtra("hadiah", "Hadiah 1 (Common)");
            } else if (randomNumber < 80) {
                intent.putExtra("hadiah", "Hadiah 2 (Uncommon)");
            } else if (randomNumber < 95) {
                intent.putExtra("hadiah", "Hadiah 3 (Rare)");
            } else {
                intent.putExtra("hadiah", "Hadiah 4 (Legendary)");
            }

            startActivity(intent);
        } else {
            Toast.makeText(this, "Diamond tidak cukup!", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateDiamondCount() {
        diamondCountTextView.setText("Diamond: " + diamondCount);
    }
}