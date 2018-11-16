package com.viaplay.pelinodaman.viaplaysections.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ViaplayBase {

    @SerializedName("_links")
    @Expose
    private Links links;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

}