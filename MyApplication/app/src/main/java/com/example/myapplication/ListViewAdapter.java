package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.model.Movie;

import java.util.List;

//ListView的适配器
public class ListViewAdapter extends BaseAdapter {
    private List<Movie> Movies;
    private Context context;

    public ListViewAdapter(List<Movie> Movies, Context context) {
        this.Movies = Movies;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Movies.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).
                inflate(R.layout.movie_item, parent, false);
        ImageView image = convertView.findViewById(R.id.imageView);
        TextView name = convertView.findViewById(R.id.name);
        TextView desc = convertView.findViewById(R.id.desc);
        image.setBackgroundResource(Movies.get(position).getImg());
        name.setText(Movies.get(position).getName());
        desc.setText(Movies.get(position).getDesc());
        return convertView;
    }
}
