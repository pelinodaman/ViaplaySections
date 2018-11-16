package com.viaplay.pelinodaman.viaplaysections.ui.detail;

import android.content.Context;
import android.util.Log;

import com.viaplay.pelinodaman.viaplaysections.R;
import com.viaplay.pelinodaman.viaplaysections.data.db.repositories.SectionDetailRepository;
import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySection;
import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySectionDetail;
import com.viaplay.pelinodaman.viaplaysections.network.ApiClient;
import com.viaplay.pelinodaman.viaplaysections.network.ApiService;
import com.viaplay.pelinodaman.viaplaysections.utils.Utils;

import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SectionDetailPresenter implements SectionDetailMVPPresenter {

    private SectionDetailMVPView mView;
    private Context mContext;
    private SectionDetailRepository sectionDetailRepository;

    public SectionDetailPresenter(Context context, SectionDetailMVPView view) {
        this.mContext = context;
        this.mView = view;
        this.sectionDetailRepository = new SectionDetailRepository(context);
    }

    @Override
    public void fetchData(ViaplaySection viaplaySection) {
        if(Utils.checkInternetConnection(mContext)) {
            ApiService service = ApiClient.getInstance().create(ApiService.class);
            Call<ViaplaySectionDetail> call = service.getSectionDetail(viaplaySection.getHref().replace("{?dtg}", ""));

            call.enqueue(new Callback<ViaplaySectionDetail>() {
                @Override
                public void onResponse(Call<ViaplaySectionDetail> call, Response<ViaplaySectionDetail> response) {
                    Log.i("Response", response.toString());
                    if(response.body() != null) {
                        ViaplaySectionDetail sectionDetail = response.body();
                        mView.setFields(sectionDetail);
                        sectionDetailRepository.upsert(sectionDetail);

                    }
                }

                @Override
                public void onFailure(Call<ViaplaySectionDetail> call, Throwable t) {
                    Log.i("Failure", t.toString());
                    mView.onError(mContext.getString(R.string.api_call_error));
                }
            });
        } else {
            try {
                mView.setFields(sectionDetailRepository.getSectionDetailWithSectionId(viaplaySection.getId()));
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
