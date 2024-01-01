package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView number;
    Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");


        int randNum = generateRandomNumber();

        number = findViewById(R.id.randNumText);
        shareBtn = findViewById(R.id.shareBtn);
        number.setText(String.valueOf(randNum));
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(randNum, userName);
            }
        });

    }

    private int generateRandomNumber() {
        Random random = new Random();
        int randNum = random.nextInt(100);

        return randNum;
    }

    private void shareData(int randNum, String userName) {
        // Implicit Intent !!!!!!!

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, userName + " Mail Subject of Lucky Number App");
        intent.putExtra(Intent.EXTRA_TEXT, "Your lucky number is : " + randNum);
        startActivity(Intent.createChooser(intent,"Choose a Platform to Share:"));

    }
}

