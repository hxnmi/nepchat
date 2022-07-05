package com.udinus.nepchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    public static final String ITEM_EXTRA = "item_extra";

    EditText userInput;
    RecyclerView recyclerView;
    List<ResponseMessage> messages;
    MsgAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#313131'>" + getString(R.string.app_name) + "</font>"));
        String name= getIntent().getStringExtra("name");
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_chat);
        userInput=findViewById(R.id.messageBox);
        recyclerView=findViewById(R.id.conversation);
        messages = new ArrayList<>();
        messageAdapter = new MsgAdapter(messages);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(messageAdapter);
        userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int i, KeyEvent event) {
                if(i == EditorInfo.IME_ACTION_SEND){
                    ResponseMessage message = new ResponseMessage(userInput.getText().toString(),true);
                    messages.add(message);
                    ResponseMessage message2 = new ResponseMessage(userInput.getText().toString(),false);
                    messages.add(message2);
                    messageAdapter.notifyDataSetChanged();
                    if (!isLastVisible())
                        recyclerView.smoothScrollToPosition(messageAdapter.getItemCount()-1);
                }
                return true;
            }
        });
    }
    boolean isLastVisible(){
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int pos = layoutManager.findLastCompletelyVisibleItemPosition();
        int numItems = recyclerView.getAdapter().getItemCount();
        return (pos >= numItems);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return super.onSupportNavigateUp();
    }
}