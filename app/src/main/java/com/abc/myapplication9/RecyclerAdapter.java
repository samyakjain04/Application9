package com.abc.myapplication9;

import android.content.Context;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.text.CollationElementIterator;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyviewHolder> {

    Context context;
    List<Movie> movieList;

    public RecyclerAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerAdapter.MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_adapter,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, int position) {

        Movie movie = movieList.get(position);
        holder.name.setText(movie.getName());
        holder.id.setText(movie.getId());
        Picasso.get()
                .load(movie.getProfileImage())
                .into(holder.profileImage);
    }

    @Override
    public int getItemCount() {
        if(movieList != null){
            return movieList.size();
        }
        return 0;

    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView id;
        ImageView profileImage;

        public MyviewHolder(View itemView) {
            super(itemView);


            name= (TextView) itemView.findViewById(R.id.name);
            id= (TextView) itemView.findViewById(R.id.id);
            profileImage=(ImageView)itemView.findViewById((R.id.profileImage));


        }
    }
}