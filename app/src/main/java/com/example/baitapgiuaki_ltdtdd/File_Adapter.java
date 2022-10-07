package com.example.baitapgiuaki_ltdtdd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class File_Adapter extends BaseAdapter {
        private Context context;
        private int layout;
        private List<File> File_List;
        public File_Adapter(Context context, int layout, List<File>file_List){
            this.context=context;
            this.layout=layout;
            this.File_List =file_List;
        }
        @Override
        public int getCount() {
            return File_List.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            TextView txtTen = (TextView) view.findViewById(R.id.textviewTen);
            TextView txtMoTa = (TextView) view.findViewById(R.id.textviewMoTa);
            ImageView imgHinh = (ImageView) view.findViewById(R.id.imageviewHinh);

            File file= File_List.get(i);
            txtTen.setText(file.getTen());
            txtMoTa.setText(file.getMoTa());
            imgHinh.setImageResource(file.getHinh());
            return view;
        }
    }

