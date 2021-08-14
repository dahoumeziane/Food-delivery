package com.dahou.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Get data through intent
        displayText = findViewById(R.id.displayText);
        String data = getIntent().getStringExtra("data");
        displayText.setText(data);


    }
}