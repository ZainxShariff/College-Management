package com.lbas.collegestudentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DeveloperActivity extends AppCompatActivity {

    private ImageView devImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        devImg = findViewById(R.id.devImage);

        getSupportActionBar().setTitle("Developers");

        devImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeveloperActivity.this, FullImageView.class);
                intent.putExtra("image","https://firebasestorage.googleapis.com/v0/b/lbas-college-app.appspot.com/o/Glide%2Fauitorium.jpg?alt=media&token=57446914-8bed-4597-b9fd-82581514551b");
                startActivity(intent);
            }
        });
    }
}