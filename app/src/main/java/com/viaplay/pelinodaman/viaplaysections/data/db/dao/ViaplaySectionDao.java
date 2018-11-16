package com.viaplay.pelinodaman.viaplaysections.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySection;

import java.util.List;

@Dao
public interface ViaplaySectionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void upsert(ViaplaySection... section);

    @Query("DELETE FROM t_section")
    void deleteAll();

    @Query("SELECT * from t_section")
    List<ViaplaySection> getAllSections();
}
