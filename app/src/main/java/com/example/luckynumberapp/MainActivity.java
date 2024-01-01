package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button myBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBtn = findViewById(R.id.myBtn);
        editText = findViewById(R.id.editText);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goSecondActivity(editText.getText().toString().trim());
            }
        });
    }

    public void goSecondActivity(String name){

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name",name);
        startActivity(intent);

    }
}

