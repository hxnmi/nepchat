package com.udinus.nepchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvChat;
    private ArrayList<Chat> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#313131'>" + getString(R.string.app_name) + "</font>"));

        rvChat = findViewById(R.id.recyclerView);
        rvChat.setHasFixedSize(true);

        list.addAll(ChatData.getListData());
        showRecyclerList();

    }

    private void showRecyclerList(){
        rvChat.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter userAdapter = new UserAdapter(list);
        rvChat.setAdapter(userAdapter);

        userAdapter.setOnItemClickCallback(new UserAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Chat chat) {
                Intent moveIntent = new Intent(MainActivity.this,ChatActivity.class);
                moveIntent.putExtra(ChatActivity.ITEM_EXTRA, chat);
                moveIntent.putExtra("name",chat.getName());
                startActivity(moveIntent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.search: {
                Toast.makeText(this,"Search clicked.",Toast.LENGTH_SHORT).show();}
                break;
            case R.id.invite:{
                Toast.makeText(this,"Invite Clicked.",Toast.LENGTH_SHORT).show();}
                break;
            case R.id.groups:{
                Toast.makeText(this,"Groups Clicked.",Toast.LENGTH_SHORT).show();}
                break;
            case R.id.settings:{
                Toast.makeText(this,"Settings Clicked.",Toast.LENGTH_SHORT).show();}
                break;
            case R.id.about:{
                Intent i = new Intent(MainActivity.this, About.class);
                startActivity(i);}
                break;
            case R.id.logout:{
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);}
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.topmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}