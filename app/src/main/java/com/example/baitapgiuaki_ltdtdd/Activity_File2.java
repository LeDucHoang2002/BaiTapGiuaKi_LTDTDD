package com.example.baitapgiuaki_ltdtdd;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Activity_File2 extends AppCompatActivity {
    private ImageView imgSignup;
    private TextView ten,tv_chitiet,mota,tv_them,tvClose,tv_sua;
    private EditText    edit_chitiet;
    private ImageView img;

    private RelativeLayout layout;
    private AppCompatButton btnOk;

    private com.google.android.material.bottomnavigation.BottomNavigationView BottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_file2);
        BottomNavigationView =findViewById(R.id.BottomNavigationView);
        mota = findViewById(R.id.textviewMoTa);
        ten = findViewById(R.id.textviewTen);
        img=findViewById(R.id.imageviewHinh);
        imgSignup =findViewById(R.id.imgSignup);
        tv_chitiet=findViewById(R.id.tv_chitiet);
        tv_them=findViewById(R.id.tv_them);
        edit_chitiet=findViewById(R.id.edit_chitiet);
        layout=findViewById(R.id.layout);
        btnOk=findViewById(R.id.btnOk);
        tvClose=findViewById(R.id.tvClose);
        tv_sua=findViewById(R.id.tv_sua);
        String ten1 = getIntent().getStringExtra("Ten");
        String mota1 = getIntent().getStringExtra("MoTa");
        int hinh=getIntent().getIntExtra("Hinh",6);
        img.setImageResource(hinh);
        ten.setText(ten1);
        mota.setText(mota1);
        if (ten.getText().toString().equals("Hội An")){
            tv_chitiet.setText("Hội An mang vẻ đẹp bình lặng và cổ kính. " +
                    "Sức hấp dẫn của đô thị hơn 400 năm tuổi xuất phát từ những kiến trúc cổ, " +
                    "những nhà mái ngói rêu phong, những con phố đèn lồng đầy màu sắc,... ");
        }else {
            if (ten.getText().toString().equals("Thành Phố Huế")){
                tv_chitiet.setText("Cầu Trường Tiền hay cầu Tràng Tiền là chiếc cầu dài 402,60 m. " +
                        "Đầu cầu phía bắc thuộc phường Đông Ba, " +
                        "đầu cầu phía nam thuộc phường Phú Hội tại trung tâm thành phố Huế, " +
                        "tỉnh Thừa Thiên Huế, Việt Nam.");
            }else {
                if (ten.getText().toString().equals("Quảng Bình")){
                    tv_chitiet.setText("Động Phong Nha (Động nước) là danh thắng tiêu biểu nhất của hệ thống hang động thuộc quần thể danh thắng Phong Nha-Kẻ Bàng. " +
                            "Tổng chiều dài 7.729 mét, có 14 hang, " +
                            "có dòng sông ngầm dài 13.969 mét lung linh kỳ ảo và rực rỡ nhất. " +
                            "Cửa động cao khoảng 10 mét, rộng 25 mét.");
                }else {
                    if (ten.getText().toString().equals("Đà Lạt")){
                        tv_chitiet.setText("Quảng trường Lâm Viên xây dựng trong sáu năm theo đồ án của kiến trúc sư Trần Văn Dũng, " +
                                "có các phân khu chức năng, gồm khu vực bên ngoài có tổng diện tích 72.405 m², " +
                                "khán đài sức chứa 15 nghìn người, sân lễ hội; khu vực đài phun nước nghệ thuật; khu vực thảm cỏ, cây xanh, bãi đỗ xe.");
                    }
                    else {
                        tv_them.setVisibility(View.VISIBLE);
                        tv_sua.setVisibility(View.GONE);
                    }
                }

            }
        }
        tv_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tg = tv_chitiet.getText().toString();
                layout.setVisibility(View.VISIBLE);
                edit_chitiet.setText(tg);
                tv_sua.setVisibility(View.GONE);
            }
        });
        tv_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.VISIBLE);
                tv_them.setVisibility(View.GONE);
            }
        });
        tvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.GONE);
                tv_sua.setVisibility(View.VISIBLE);
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tg = edit_chitiet.getText().toString();
                if (tg.equals("")){
                    tv_them.setVisibility(View.VISIBLE);
                    layout.setVisibility(View.GONE);
                    tv_sua.setVisibility(View.GONE);
                }else {
                tv_chitiet.setText(tg);
                layout.setVisibility(View.GONE);
                tv_sua.setVisibility(View.VISIBLE);}
            }
        });
        imgSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Activity_File.class);
                startActivity(intent);
            }
        });
        BottomNavigationView.setOnNavigationItemSelectedListener(new com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id== R.id.nav_home){
                    Intent intent=new Intent(getApplicationContext(), Activity_home_page.class);
                    startActivity(intent);
                }if (id==R.id.nav_file){
                    Intent intent=new Intent(getApplicationContext(), Activity_profile.class);
                    startActivity(intent);
                }
                if (id==R.id.nav_file){
                    Intent intent=new Intent(getApplicationContext(), Activity_File.class);
                    startActivity(intent);
                }
                return false;
            }
        });

    }
}