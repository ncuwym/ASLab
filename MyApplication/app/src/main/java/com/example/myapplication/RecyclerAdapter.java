package com.example.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.Movie;

import java.util.List;

//RecyclerView适配器
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder> {

    private List<Movie> movieList;
    private Context context;

    public RecyclerAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Movie myMovie = movieList.get(position);
        Drawable drawable = context.getResources().getDrawable(myMovie.getImg(), null);
        holder.img.setImageDrawable(drawable);
        holder.name.setText(myMovie.getName());
        holder.desc.setText(myMovie.getDesc());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView desc;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.rimageView);
            name = itemView.findViewById(R.id.rname);
            desc = itemView.findViewById(R.id.rdesc);
        }
    }
}
