package com.lbas.lbascollegeadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lbas.lbascollegeadmin.faculty.UpdateFaculty;
import com.lbas.lbascollegeadmin.notice.DeleteNoticeActivity;
import com.lbas.lbascollegeadmin.notice.UploadNotice;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView uploadNotice,addGalleryImage,addPdf,addFaculty,deleteNotice;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadNotice = findViewById(R.id.addNotice);
        uploadNotice.setOnClickListener(this);

        addGalleryImage = findViewById(R.id.addGalleryImage);
        addGalleryImage.setOnClickListener(this);

        addPdf = findViewById(R.id.addPdf);
        addPdf.setOnClickListener(this);

        addFaculty = findViewById(R.id.addFaculty);
        addFaculty.setOnClickListener(this);

        deleteNotice = findViewById(R.id.deleteNotice);
        deleteNotice.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.addNotice:
                intent= new Intent(MainActivity.this, UploadNotice.class);
                startActivity(intent);
                break;

            case R.id.addGalleryImage:
                intent= new Intent(MainActivity.this,UploadImage.class);
                startActivity(intent);
                break;

            case R.id.addPdf:
                intent= new Intent(MainActivity.this,UploadPdf.class);
                startActivity(intent);
                break;

            case R.id.addFaculty:
                intent= new Intent(MainActivity.this, UpdateFaculty.class);
                startActivity(intent);
                break;

            case R.id.deleteNotice:
                intent= new Intent(MainActivity.this, DeleteNoticeActivity.class);
                startActivity(intent);
                break;

        }
    }
}