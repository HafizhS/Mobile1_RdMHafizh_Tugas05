package com.example.mobile1_rdmhafizh_tugas05.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class DataPenduduk implements Parcelable {
    public String nik;
    public String nama;
    public String tempatLahir;
    public long tanggalLahir;
    public String alamat;
    public String jenisKelamin;
    public String pekerjaan;
    public String statusPerkawinan;

    public DataPenduduk(Parcel in) {
        nik = in.readString();
        nama = in.readString();
        tempatLahir = in.readString();
        tanggalLahir = in.readLong();
        alamat = in.readString();
        jenisKelamin = in.readString();
        pekerjaan = in.readString();
        statusPerkawinan = in.readString();
    }

    public static final Creator<DataPenduduk> CREATOR = new Creator<DataPenduduk>() {
        @Override
        public DataPenduduk createFromParcel(Parcel in) {
            return new DataPenduduk(in);
        }

        @Override
        public DataPenduduk[] newArray(int size) {
            return new DataPenduduk[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nik);
        parcel.writeString(nama);
        parcel.writeString(tempatLahir);
        parcel.writeLong(tanggalLahir);
        parcel.writeString(alamat);
        parcel.writeString(jenisKelamin);
        parcel.writeString(pekerjaan);
        parcel.writeString(statusPerkawinan);
    }
}
