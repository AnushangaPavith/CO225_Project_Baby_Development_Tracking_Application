package com.example.babydev;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class userData {
    @PrimaryKey(autoGenerate = true)
    public int userID;

    @ColumnInfo(name = "Gname")
    public String Gname;

    @ColumnInfo(name = "Bname")
    public String Bname;

    @ColumnInfo(name = "DOB")
    public String DOB;

    @ColumnInfo(name = "gender")
    public String gender;

    @ColumnInfo(name = "Bweight")
    public double Bweight;

    @ColumnInfo(name = "Bheight")
    public double Bheight;

}

