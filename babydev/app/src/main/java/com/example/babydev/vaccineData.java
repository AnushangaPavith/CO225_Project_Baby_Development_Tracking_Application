package com.example.babydev;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class vaccineData {
    @PrimaryKey(autoGenerate = true)
    public int vaccineID;

    @ColumnInfo(name = "age")
    public int age;

    @ColumnInfo(name = "vaccine")
    public String vaccine;

    @ColumnInfo(name = "DOV")
    public String DOV;
}
