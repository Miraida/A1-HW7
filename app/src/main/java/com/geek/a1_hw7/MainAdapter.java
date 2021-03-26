package com.geek.a1_hw7;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private List<UserContactModel> list;
    private Context context;
    private IFragment listener;

    public MainAdapter(List<UserContactModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private UserContactModel model;
        private TextView name,chat;
        private ImageView photo;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.profile_name_textView);
            chat = itemView.findViewById(R.id.profile_chat_textView);
            photo = itemView.findViewById(R.id.profile_photo_imageView);
        }

        public void onBind(UserContactModel userContactModel) {
            this.model = userContactModel;
            name.setText(model.getName());
            chat.setText(model.getTitle());
            Glide.with(context).load(model.getImage()).circleCrop().into(photo);
        }

        @Override
        public void onClick(View v) {
            if (listener != null){
                listener.displayDetails(model);
            }
        }
    }
    public void setOnClickListener(IFragment mListener) {
        listener = mListener;
    }
}
