package com.example.baitapgiuaki_ltdtdd;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Activity_File extends AppCompatActivity {
    private ImageView imgSignup;
    private List<File> arrayFile = new ArrayList<>();
    private File_Adapter adapter;
    private ListView lvFile;
    private EditText editNamefie;
    private EditText editAddressfile;
    private TextView tv_add,tv_Close;
    private RelativeLayout layout;
    private LinearLayout layout2;
    private com.google.android.material.bottomnavigation.BottomNavigationView BottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_file);
        editNamefie = findViewById(R.id.editSchoolName);
        editAddressfile = findViewById(R.id.editSchoolAddress);
        tv_add=findViewById(R.id.tv_add);
        tv_Close=findViewById(R.id.tvClose);
        layout=findViewById(R.id.layout4);
        layout2=findViewById(R.id.layout3);
        imgSignup =findViewById(R.id.imgSignup);
        BottomNavigationView =findViewById(R.id.BottomNavigationView);
        AnhXa();
        adapter =new File_Adapter(this,R.layout.item_file,arrayFile);
        lvFile.setAdapter(adapter);
        lvFile.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                deleteFile(i);
            }
        });
        lvFile.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                showInfoFile(i);
                return false;

            }
        });
        imgSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Activity_profile.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btnOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.GONE);
                layout2.setVisibility(View.VISIBLE);
                addFile();
            }
        });
        tv_add.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.GONE);
            }
        });
        tv_Close.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                layout2.setVisibility(View.VISIBLE);
                layout.setVisibility(View.GONE);
            }
        });
        BottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id== R.id.nav_home){
                    Intent intent=new Intent(getApplicationContext(), Activity_home_page.class);
                    startActivity(intent);
                }if(id== R.id.nav_profile){
                    Intent intent=new Intent(getApplicationContext(), Activity_profile.class);
                    startActivity(intent);
                }if (id==R.id.nav_file){
                    Intent intent=new Intent(getApplicationContext(), Activity_File.class);
                    startActivity(intent);
                }
                return false;
            }
        });
    }
    private void addFile() {
        String name = editNamefie.getText().toString();
        String address = editAddressfile.getText().toString();
        int hinh = (R.drawable.img_danang);
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(address)){
            Toast.makeText(this, "Please enter file name and address", Toast.LENGTH_SHORT).show();
            return;
        }
        File s = new File(name,address,hinh);
        s.setTen(name);
        s.setMoTa(address);
        s.setHinh(hinh);
        arrayFile.add(s);

        adapter.notifyDataSetChanged();
    }
    private void showInfoFile(int position){
        File s = arrayFile.get(position);

        Intent i = new Intent(this, Activity_File2.class);

        i.putExtra("Ten", s.getTen());
        i.putExtra("MoTa", s.getMoTa());
        i.putExtra("Hinh",s.getHinh());
        startActivity(i);
    }

    private void AnhXa() {
        lvFile=(ListView) findViewById(R.id.listviewMonHoc);
        arrayFile=new ArrayList<>();
        arrayFile.add(new File("Hội An","Phố cổ Hội An",R.drawable.img_hoian));
        arrayFile.add(new File("Thành Phố Huế","Cầu Trường Tiền",R.drawable.img_hue));
        arrayFile.add(new File("Quảng Bình","Động Phong Nha",R.drawable.img_quangbinh));
        arrayFile.add(new File("Đà Lạt","Quảng trừơng Trúc Lâm Viên",R.drawable.img_dalat));

    }
    private void deleteFile(final int position){
        new AlertDialog.Builder(this)
                .setTitle("Delete File")
                .setMessage("Are you want delete file?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        arrayFile.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("Canncel", null)
                .show();
    }

}