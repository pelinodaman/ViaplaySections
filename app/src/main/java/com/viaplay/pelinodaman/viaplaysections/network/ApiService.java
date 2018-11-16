package com.viaplay.pelinodaman.viaplaysections.network;

import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplayBase;
import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySectionDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {

    @GET
    Call<ViaplayBase> getSections(@Url String url);

    @GET
    Call<ViaplaySectionDetail> getSectionDetail(@Url String url);

}
