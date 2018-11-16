package com.viaplay.pelinodaman.viaplaysections.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Links {

    @SerializedName("viaplay:sections")
    @Expose
    private List<ViaplaySection> viaplaySections = null;

    public List<ViaplaySection> getViaplaySections() {
        return viaplaySections;
    }

    public void setViaplaySections(List<ViaplaySection> viaplaySections) {
        this.viaplaySections = viaplaySections;
    }

}