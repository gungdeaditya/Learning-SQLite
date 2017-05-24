package com.example.gungdeaditya.samplesqliteapps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gungdeaditya.samplesqliteapps.R;
import com.example.gungdeaditya.samplesqliteapps.model.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gungde Aditya on 07/02/2016.
 */
public class ListDataAdapter extends ArrayAdapter {
    List list = new ArrayList();

     public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler{
        TextView NAME,MOB,EMAIL;
    }

    @Override
    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.NAME = (TextView) row.findViewById(R.id.text_user_name);
            layoutHandler.MOB = (TextView) row.findViewById(R.id.text_user_mobile);
            layoutHandler.EMAIL = (TextView) row.findViewById(R.id.text_user_email);
            row.setTag(layoutHandler);
        }
        else{
            layoutHandler = (LayoutHandler) row.getTag();
        }
        Data dataProvider = (Data)this.getItem(position);
        layoutHandler.NAME.setText(dataProvider.getName());
        layoutHandler.MOB.setText(dataProvider.getMob());
        layoutHandler.EMAIL.setText(dataProvider.getEmail());

        return row;
    }
}
