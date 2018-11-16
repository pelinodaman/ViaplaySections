package com.viaplay.pelinodaman.viaplaysections.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySectionDetail;

@Dao
public interface ViaplaySectionDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void upsert(ViaplaySectionDetail... detail);

    @Query("DELETE FROM t_section_detail")
    void deleteAll();

    @Query("SELECT * FROM t_section_detail WHERE sectionId = :sectionId")
    ViaplaySectionDetail getSectionDetail(String sectionId);
}
