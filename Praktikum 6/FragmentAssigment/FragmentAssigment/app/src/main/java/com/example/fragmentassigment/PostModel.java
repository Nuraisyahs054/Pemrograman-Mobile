package com.example.fragmentassigment;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class PostModel implements Parcelable {
    private String username;
    private String name;
    private String caption;
    private String profile;
    private String upload;


    //menginisialisasi nilai atribut-atribut dalam objek PostModel.
    public PostModel(String username, String name, String caption, String profile, String upload) {
        this.username = username;
        this.name = name;
        this.caption = caption;
        this.profile = profile;
        this.upload = upload;
    }


    // constructor yang digunakan untuk membaca nilai atribut PostModel dari objek Parcel.
    protected PostModel(Parcel in) {
        username = in.readString();
        name = in.readString();
        caption = in.readString();
        profile = in.readString();
        upload = in.readString();
    }

    public static final Creator<PostModel> CREATOR = new Creator<PostModel>() {
        @Override
        public PostModel createFromParcel(Parcel in) {
            return new PostModel(in);
        }

        @Override
        public PostModel[] newArray(int size) {
            return new PostModel[size];
        }
    };

    //dapat mengakses nilai atribut-atribut dalam objek PostModel dari luar kelas,
    // seperti untuk menampilkan informasi pengguna dan unggahan gambar di antarmuka pengguna aplikasi.
    public String getProfile() {
        return profile;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getUpload() {
        return upload;
    }

    public String getCaption() {
        return caption;
    }

    public void setImageUri(String profile) {
        this.profile = profile;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUri1(String upload) {
        this.upload = upload;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //digunakan untuk menulis nilai atribut objek Parcelable ke dalam Parcel.
    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(name);
        parcel.writeString(caption);
        parcel.writeString(profile);
        parcel.writeString(upload);
    }
}