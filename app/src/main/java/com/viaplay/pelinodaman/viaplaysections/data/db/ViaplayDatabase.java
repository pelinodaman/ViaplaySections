package com.viaplay.pelinodaman.viaplaysections.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.viaplay.pelinodaman.viaplaysections.data.db.dao.ViaplaySectionDao;
import com.viaplay.pelinodaman.viaplaysections.data.db.dao.ViaplaySectionDetailDao;
import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySection;
import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySectionDetail;


@Database(entities = {ViaplaySection.class, ViaplaySectionDetail.class}, version = 1)
public abstract class ViaplayDatabase extends RoomDatabase {

    private static volatile ViaplayDatabase INSTANCE;

    public abstract ViaplaySectionDao sectionDao();

    public abstract ViaplaySectionDetailDao sectionDetailDao();

    public static ViaplayDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ViaplayDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ViaplayDatabase.class, "viaplay_database").build();
                }
            }
        }
        return INSTANCE;
    }

}
