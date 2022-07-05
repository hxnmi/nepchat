package com.udinus.nepchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    Context context;

    private ArrayList<Chat> listChat;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback (OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    public UserAdapter(ArrayList<Chat> list) {
        this.listChat = list;
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_conversation, viewGroup, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {

        Chat chat = listChat.get(i);
        Glide.with(userViewHolder.itemView.getContext())
                .load(chat.getImage())
                .apply(new RequestOptions().override(55, 55))
                .into(userViewHolder.imgIcon);

        userViewHolder.txtTitle.setText(chat.getName());

        userViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listChat.get(userViewHolder.getAdapterPosition()));

            }
        });
    }

    @Override
    public int getItemCount() {
        return listChat.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView txtTitle;
        TextView lastMsg;
        TextView msgTime;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon = itemView.findViewById(R.id.profile);
            txtTitle = itemView.findViewById(R.id.username);
            lastMsg = itemView.findViewById(R.id.lastMsg);
            msgTime = itemView.findViewById(R.id.msgTime);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Chat list);
    }
}