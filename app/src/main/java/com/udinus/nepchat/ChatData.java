package com.udinus.nepchat;

import java.util.ArrayList;

public class ChatData {

    private static String[] name = {"Rizka", "Daffa" , "Kikik", "Megan", "Brian", "Alfa", "Varell", "Risq", "Irfan", "Aris", "Apta"};

    private static int[] image = {
            R.drawable.rizka,
            R.drawable.daffa,
            R.drawable.kikik,
            R.drawable.megan,
            R.drawable.brian,
            R.drawable.alfa,
            R.drawable.varell,
            R.drawable.risq,
            R.drawable.irfan,
            R.drawable.aris,
            R.drawable.apta
    };

    static ArrayList<Chat> getListData() {
        ArrayList<Chat> list = new ArrayList<>();
        for(int i=0; i<name.length; i++){
        Chat chat = new Chat();
            chat.setName(name[i]);
            chat.setImage(image[i]);
            list.add(chat);
        }
        return list;
    }
}


