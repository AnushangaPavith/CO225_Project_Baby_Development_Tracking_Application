package com.example.babydev;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;

@Database(entities = {userData.class}, version = 1)
public abstract class babyDB extends RoomDatabase {
    public abstract userDAO USERDAO();
//    public abstract vaccineDAO VACCINEDAO();

    private static babyDB INSTANCE;
    public static babyDB getDbInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), babyDB.class, "myDB").allowMainThreadQueries().build();
        }

        return INSTANCE;
    }
}
