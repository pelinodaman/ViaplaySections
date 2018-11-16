package com.viaplay.pelinodaman.viaplaysections.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "t_section_detail", foreignKeys = @ForeignKey(entity = ViaplaySection.class,
        parentColumns = "id", childColumns = "sectionId", onDelete = CASCADE))
public class ViaplaySectionDetail {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    @NonNull
    @SerializedName("sectionId")
    @Expose
    private String sectionId;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionId() {
        return sectionId;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }
}
