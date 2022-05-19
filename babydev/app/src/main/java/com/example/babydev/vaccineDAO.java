package com.example.babydev;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface vaccineDAO {
    @Insert
    void InsertVaccine(vaccineData vaccine);

    @Query("SELECT * FROM vaccineData")
    List<vaccineData> getVaccine();

    @Delete
    void DeleteVaccine(vaccineData vaccine);
}
