package com.example.baitapgiuaki_ltdtdd;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_File2 extends AppCompatActivity {

    private TextView ten;
    private TextView mota;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_file2);

        mota = findViewById(R.id.textviewMoTa);
        ten = findViewById(R.id.textviewTen);
        img=findViewById(R.id.imageviewHinh);

        String ten1 = getIntent().getStringExtra("Ten");
        String mota1 = getIntent().getStringExtra("MoTa");
        int hinh=getIntent().getIntExtra("Hinh",6);
        img.setImageResource(hinh);
        ten.setText(ten1);
        mota.setText(mota1);


    }
}