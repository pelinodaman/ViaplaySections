package com.viaplay.pelinodaman.viaplaysections.ui.detail;

import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySectionDetail;

public interface SectionDetailMVPView {

    void setFields(ViaplaySectionDetail sectionDetail);

    void onError(String message);
}
