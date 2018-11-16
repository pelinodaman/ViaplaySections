package com.viaplay.pelinodaman.viaplaysections.ui.main;

import android.content.Context;
import android.util.Log;

import com.viaplay.pelinodaman.viaplaysections.R;
import com.viaplay.pelinodaman.viaplaysections.data.db.repositories.SectionRepository;
import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplayBase;
import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySection;
import com.viaplay.pelinodaman.viaplaysections.network.ApiClient;
import com.viaplay.pelinodaman.viaplaysections.network.ApiService;
import com.viaplay.pelinodaman.viaplaysections.utils.Utils;

import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainMVPPresenter {

    private MainMVPView mView;
    private Context mContext;
    private SectionRepository sectionRepository;

    public MainPresenter(Context context, MainMVPView view) {
        this.mContext = context;
        this.mView = view;
        this.sectionRepository = new SectionRepository(context);
    }

    @Override
    public void fetchData() {
        if(Utils.checkInternetConnection(mContext)) {
            ApiService service = ApiClient.getInstance().create(ApiService.class);
            String url = "https://content.viaplay.se/androiddash-se";
            Call<ViaplayBase> call = service.getSections("https://content.viaplay.se/androiddash-se");

            call.enqueue(new Callback<ViaplayBase>() {
                @Override
                public void onResponse(Call<ViaplayBase> call, Response<ViaplayBase> response) {
                    Log.i("Response", response.toString());
                    if(response.body() != null) {
                        List<ViaplaySection> viaplaySections = response.body().getLinks().getViaplaySections();
                        mView.setSectionsList(viaplaySections);
                        sectionRepository.upsert(viaplaySections.toArray(new ViaplaySection[viaplaySections.size()]));
                    }
                }

                @Override
                public void onFailure(Call<ViaplayBase> call, Throwable t) {
                    Log.i("Failure", t.toString());
                    mView.onError(mContext.getString(R.string.api_call_error));
                }
            });
        } else {
            try {
                mView.setSectionsList(sectionRepository.getAllSections());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
