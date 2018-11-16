package com.viaplay.pelinodaman.viaplaysections.data.db.repositories;

import android.content.Context;
import android.os.AsyncTask;

import com.viaplay.pelinodaman.viaplaysections.data.db.ViaplayDatabase;
import com.viaplay.pelinodaman.viaplaysections.data.db.dao.ViaplaySectionDao;
import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySection;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class SectionRepository {

    private ViaplaySectionDao mSectionDao;

    public SectionRepository(Context context) {
        ViaplayDatabase db = ViaplayDatabase.getDatabase(context);
        mSectionDao = db.sectionDao();
    }

    public void upsert (ViaplaySection... section) {
        new upsertAsyncTask(mSectionDao).execute(section);
    }

    private static class upsertAsyncTask extends AsyncTask<ViaplaySection , Void, Void> {

        private ViaplaySectionDao mAsyncTaskDao;

        upsertAsyncTask(ViaplaySectionDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ViaplaySection... params) {
            mAsyncTaskDao.deleteAll();
            mAsyncTaskDao.upsert(params);
            return null;
        }

    }

    public List<ViaplaySection> getAllSections() throws ExecutionException, InterruptedException {
        return new getAllAsyncTask(mSectionDao).execute().get();
    }

    private static class getAllAsyncTask extends AsyncTask<Void , Void, List<ViaplaySection>> {

        private ViaplaySectionDao mAsyncTaskDao;

        getAllAsyncTask(ViaplaySectionDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected List<ViaplaySection> doInBackground(Void... voids) {
            return mAsyncTaskDao.getAllSections();
        }

    }

}
