package com.example.kalyanasadi.gridviewexample.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.kalyanasadi.gridviewexample.MainActivity;
import com.example.kalyanasadi.gridviewexample.R;

import java.util.ArrayList;


public class CustomGrid extends BaseAdapter {

    Activity activity;
    ArrayList<Integer> list;
    int selectedPosition=-1;

    public CustomGrid(MainActivity mainActivity, ArrayList<Integer> imgList) {
        this.activity = mainActivity;
        this.list = imgList;

    }

    @Override
    public int getCount() {
        return list.size();
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
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
      final   ViewHolder viewHolder;


        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.grid_single, null);
            viewHolder.imgGallery = (ImageView) convertView.findViewById(R.id.grid_image);

            viewHolder.imgGallery.setImageResource(list.get(i));
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Log.d("CustomGrid","@ getView selectedPosition :"+selectedPosition);

        if(i==selectedPosition){
            viewHolder.imgGallery.setImageResource(R.drawable.blanck_universe);
        }else{
            viewHolder.imgGallery.setImageResource(R.mipmap.ic_launcher);
        }


        viewHolder.imgGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                selectedPosition=i;
                notifyDataSetChanged();


            }
        });


        return convertView;
    }


    public class ViewHolder {
        ImageView imgGallery;
        LinearLayout linearLayout;
    }
}
