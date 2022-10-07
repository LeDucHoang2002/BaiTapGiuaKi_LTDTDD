package com.example.baitapgiuaki_ltdtdd;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity_File extends AppCompatActivity {
    private List<File> arrayFile = new ArrayList<>();
    private File_Adapter adapter;
    private ListView lvFile;
    private EditText editSchoolName;
    private EditText editSchoolAddress;
    private TextView tv_add,tv_Close;
    private RelativeLayout layout;
    private LinearLayout layout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_file);
        editSchoolName = findViewById(R.id.editSchoolName);
        editSchoolAddress = findViewById(R.id.editSchoolAddress);
        tv_add=findViewById(R.id.tv_add);
        tv_Close=findViewById(R.id.tvClose);
        layout=findViewById(R.id.layout4);
        layout2=findViewById(R.id.layout3);
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
        findViewById(R.id.btnOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.GONE);
                layout2.setVisibility(View.VISIBLE);
                addSchool();
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
    }
    private void addSchool() {
        String name = editSchoolName.getText().toString();
        String address = editSchoolAddress.getText().toString();
        int hinh = (R.drawable.img_2);
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(address)){
            Toast.makeText(this, "Please enter school name and address", Toast.LENGTH_SHORT).show();
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
        arrayFile.add(new File("Spaghetti","120$",R.drawable.img_2));
        arrayFile.add(new File("Cream","50$",R.drawable.img_2));
        arrayFile.add(new File("Hamburger","150$",R.drawable.img_2));
        arrayFile.add(new File("Chicken KFC","140$",R.drawable.img_2));

    }
    private void deleteFile(final int position){
        new AlertDialog.Builder(this)
                .setTitle("Delete Dish")
                .setMessage("Are you want delete Dish?")
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