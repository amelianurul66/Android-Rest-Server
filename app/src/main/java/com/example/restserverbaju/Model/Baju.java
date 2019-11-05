package com.example.restserverbaju.Model;

import com.google.gson.annotations.SerializedName;

public class Baju {
        @SerializedName("id_kemeja")
        private String id_kemeja;
        @SerializedName("merk")
        private String merk;
        @SerializedName("ukuran")
        private String ukuran;
//    @SerializedName("foto")
//    private String foto;

        public Baju(){}

//    public Baju(String id, String nama, String nomor, String foto) {
//        this.id = id;
//        this.nama = nama;
//        this.nomor = nomor;
//        this.foto = foto;
//    }

        public Baju(String id_kemeja, String merk, String ukuran) {
            this.id_kemeja = id_kemeja;
            this.merk = merk;
            this.ukuran = ukuran;
        }

        public String getId() {
            return id_kemeja;
        }

        public void setId_kemeja(String id_kemeja) {
            this.id_kemeja = id_kemeja;
        }

        public String getMerk() {
            return merk;
        }

        public void setMerk(String merk) {
            this.merk = merk;
        }

        public String getUkuran() {
            return ukuran;
        }

        public void setUkuranr(String ukuran) {
            this.ukuran = ukuran;
        }

//    public void setFoto(String foto) {
//        this.foto = foto;
//    }
//
//    public String getFoto() {
//        return foto;
//    }
}
