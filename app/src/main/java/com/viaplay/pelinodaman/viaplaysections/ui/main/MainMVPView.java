package com.viaplay.pelinodaman.viaplaysections.ui.main;

import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySection;

import java.util.List;

public interface MainMVPView {

    void onError(String message);

    void setSectionsList(List<ViaplaySection> viaplaySections);
}
