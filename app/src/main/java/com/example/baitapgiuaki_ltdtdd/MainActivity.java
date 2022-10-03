package com.example.baitapgiuaki_ltdtdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView editText,editText2,Tv_Sginup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(TextView)findViewById(R.id.edit_maSV);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_FLAG_SIGNED);
        editText2=(TextView)findViewById(R.id.password);
        Tv_Sginup=(TextView) findViewById(R.id.tvSignup);
        Button btnOpen=(Button) findViewById(R.id.buttonLogin);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String maSV=editText.getText().toString();
                String pass=editText2.getText().toString();
                if (pass.equals("")==true||maSV.equals("")==true){
                    Toast.makeText(MainActivity.this, "Nhập MaSV và Password", Toast.LENGTH_SHORT).show();
                }else {
                    if (maSV.equals("2050531200150")==true){
                        Intent intent=new Intent(getApplicationContext(),Activity_profile.class);
                        intent.putExtra("MaSV",maSV);
                        startActivity(intent);
                    }else {

                        Toast.makeText(MainActivity.this, "Tài Khoản Sai", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}