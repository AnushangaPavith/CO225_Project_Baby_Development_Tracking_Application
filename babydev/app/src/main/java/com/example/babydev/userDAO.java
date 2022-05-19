package com.example.babydev;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface userDAO {
    @Insert
    void InsertUser(userData user);

    @Query("SELECT * FROM userData")
    List<userData> getUser();

    @Delete
    void DeleteUser(userData user);

}


