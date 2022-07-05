package com.udinus.nepchat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.CustomViewHolder> {

    List<ResponseMessage> messages;

    public MsgAdapter(List<ResponseMessage> messages) {
        this.messages = messages;
    }

    @Override
    public int getItemViewType(int i) {
        if (messages.get(i).isMe()) {
            return R.layout.item_sent;
        }
        return R.layout.item_receive;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CustomViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(MsgAdapter.CustomViewHolder holder, int i) {
        holder.txtView.setText(messages.get(i).getTextMessage());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView txtView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            txtView = itemView.findViewById(R.id.textmessage);
        }
    }
}