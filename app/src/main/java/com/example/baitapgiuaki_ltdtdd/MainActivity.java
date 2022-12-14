package com.example.baitapgiuaki_ltdtdd;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView editText,editText2,sigup,logIn;
    LinearLayout singUpLayout,logInLayout;
    Button singIn;
    EditText eMails,passwordss,passwords01;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (TextView) findViewById(R.id.eMail);
        editText2 = (TextView) findViewById(R.id.passwords);
        sigup =(TextView) findViewById(R.id.singUp);
        logIn =(TextView) findViewById(R.id.logIn);
        singUpLayout=(LinearLayout)findViewById(R.id.singUpLayout) ;
        logInLayout=(LinearLayout)findViewById(R.id.logInLayout);
        singIn=(Button)findViewById(R.id.singIn);
        cbRemember =(CheckBox)findViewById(R.id.cb_Save);
        eMails = (EditText) findViewById(R.id.eMails);
        passwordss = (EditText) findViewById(R.id.passwordss);
        passwords01 = (EditText) findViewById(R.id.passwords01);
        sharedPreferences =getSharedPreferences("data", MODE_PRIVATE);
        editText.setText(sharedPreferences.getString("taikhoan",""));
        editText2.setText(sharedPreferences.getString("matkhau",""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked",false));
        sigup.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                sigup.setBackground(getDrawable(R.drawable.switch_trcks));
                sigup.setTextColor(getColor(R.color.white));
                logIn.setBackground(getDrawable(R.drawable.switch_tumbs));
                logIn.setTextColor(getColor(R.color.pinkColor));
                singUpLayout.setVisibility(View.VISIBLE);
                logInLayout.setVisibility(View.GONE);
            }
        });
        logIn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                logIn.setBackground(getDrawable(R.drawable.switch_trcks));
                logIn.setTextColor(getColor(R.color.white));
                sigup.setBackground(getDrawable(R.drawable.switch_tumbs));
                sigup.setTextColor(getColor(R.color.pinkColor));
                logInLayout.setVisibility(View.VISIBLE);
                singUpLayout.setVisibility(View.GONE);
            }
        });
        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uername =editText.getText().toString().trim();
                String pass =editText2.getText().toString().trim();
                if (uername.equals("abc")&&pass.equals("123")){
                    Toast.makeText(MainActivity.this, "????ng Nh???p Th??nh C??ng", Toast.LENGTH_SHORT).show();
                    if(cbRemember.isChecked()){
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("taikhoan",uername);
                        editor.putString("matkhau",pass);
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                    Intent intent=new Intent(getApplicationContext(),Activity_home_page.class);
                    startActivity(intent);
                }else {
                        if(uername.equals("")==true&&pass.equals("")==true){
                            String uername1 =eMails.getText().toString().trim();
                            String pass1 =passwordss.getText().toString().trim();
                            String pass2 =passwords01.getText().toString().trim();
                            if( uername1.equals("")==false && passwordss.getText().toString() != passwords01.getText().toString()){
                                Intent intent=new Intent(getApplicationContext(),Activity_home_page.class);
                                startActivity(intent);
                                Toast.makeText(MainActivity.this, "????ng Nh???p Th??nh C??ng ", Toast.LENGTH_SHORT).show();
                            }else {
                                if (uername1.equals("")==true){
                                    Toast.makeText(MainActivity.this, "Y??u C???u Nh???p Email", Toast.LENGTH_SHORT).show();
                                }
                                if (passwordss.getText().toString()==passwords01.getText().toString()){
                                    Toast.makeText(MainActivity.this, "M???t kh???u kh??ng kh???p", Toast.LENGTH_SHORT).show();
                                }
                                if (pass1.equals("")==true||pass2.equals("")==true){
                                    Toast.makeText(MainActivity.this, "Y??u C???u Nh???p m???t kh???u", Toast.LENGTH_SHORT).show();
                                }
                            }}else {
                                Toast.makeText(MainActivity.this, "????ng Nh???p Kh??ng Th??nh C??ng", Toast.LENGTH_SHORT).show();

                    }
                }}

        });
    }
}