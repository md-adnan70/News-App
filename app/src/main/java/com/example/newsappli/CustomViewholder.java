package com.example.newsappli;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewholder extends RecyclerView.ViewHolder {
    TextView text_Title,text_Source;
    ImageView img_Headline;
    CardView cardView;
    public CustomViewholder(@NonNull View itemView) {
        super(itemView);
        text_Title = itemView.findViewById(R.id.text_Title);
        text_Source = itemView.findViewById(R.id.text_Source);
        img_Headline = itemView.findViewById(R.id.img_headLine);
        cardView = itemView.findViewById(R.id.main_container);
    }
}
