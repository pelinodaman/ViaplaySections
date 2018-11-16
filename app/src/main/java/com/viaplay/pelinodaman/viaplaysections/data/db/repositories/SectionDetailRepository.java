package com.viaplay.pelinodaman.viaplaysections.data.db.repositories;

import android.content.Context;
import android.os.AsyncTask;

import com.viaplay.pelinodaman.viaplaysections.data.db.ViaplayDatabase;
import com.viaplay.pelinodaman.viaplaysections.data.db.dao.ViaplaySectionDetailDao;
import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySectionDetail;

import java.util.concurrent.ExecutionException;

public class SectionDetailRepository {

    private ViaplaySectionDetailDao mSectionDetailDao;

    public SectionDetailRepository(Context context) {
        ViaplayDatabase db = ViaplayDatabase.getDatabase(context);
        mSectionDetailDao = db.sectionDetailDao();
    }

    public void upsert (ViaplaySectionDetail sectionDetail) {
        new upsertAsyncTask(mSectionDetailDao).execute(sectionDetail);
    }

    private static class upsertAsyncTask extends AsyncTask<ViaplaySectionDetail , Void, Void> {

        private ViaplaySectionDetailDao mAsyncTaskDao;

        upsertAsyncTask(ViaplaySectionDetailDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ViaplaySectionDetail... params) {
            mAsyncTaskDao.upsert(params[0]);
            return null;
        }

    }

    public ViaplaySectionDetail getSectionDetailWithSectionId(String sectionId) throws ExecutionException, InterruptedException {
        return new getDetailAsyncTask(mSectionDetailDao).execute(sectionId).get();
    }

    private static class getDetailAsyncTask extends AsyncTask<String , Void, ViaplaySectionDetail> {

        private ViaplaySectionDetailDao mAsyncTaskDao;

        getDetailAsyncTask(ViaplaySectionDetailDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected ViaplaySectionDetail doInBackground(final String... params) {
            return mAsyncTaskDao.getSectionDetail(params[0]);
        }

    }
}
