package com.viaplay.pelinodaman.viaplaysections.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "t_section")
public class ViaplaySection implements Parcelable{

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;


    public ViaplaySection(@NonNull String id, String title, String href, String type, String name) {
        this.id = id;
        this.title = title;
        this.href = href;
        this.type = type;
        this.name = name;
    }

    protected ViaplaySection(Parcel in) {
        id = in.readString();
        title = in.readString();
        href = in.readString();
        type = in.readString();
        name = in.readString();
    }

    public static final Creator<ViaplaySection> CREATOR = new Creator<ViaplaySection>() {
        @Override
        public ViaplaySection createFromParcel(Parcel in) {
            return new ViaplaySection(in);
        }

        @Override
        public ViaplaySection[] newArray(int size) {
            return new ViaplaySection[size];
        }
    };



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(href);
        dest.writeString(type);
        dest.writeString(name);
    }
}