package com.example.newsappli;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsappli.Modals.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewholder> {
    private Context context;
    private List<NewsHeadlines> headlines;
    private SelectListner listner;

    public CustomAdapter(Context context, List<NewsHeadlines> newsHeadlinesArrayList,SelectListner listner) {
        this.context = context;
        this.headlines = newsHeadlinesArrayList;
        this.listner = listner;
    }

    @NonNull
    @Override
    public CustomViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewholder(LayoutInflater.from(context).inflate(R.layout.headline_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewholder holder, int position) {
    holder.text_Title.setText(headlines.get(position).getTitle());
    holder.text_Source.setText(headlines.get(position).getSource().getName());

    if(headlines.get(position).getUrlToImage()!=null){
        Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_Headline);
    }

    holder.cardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            listner.OnNewsClicked(headlines.get(position));
        }
    });

    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
