package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Ders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dersAdi;
    private int kredi;

    @ManyToOne
    @JoinColumn(name = "ogrenci_id")
    private Ogrenci ogrenci;

    public Ders(){
    }
    public Long getId(){return id;}
    public void setId(Long id){
        this.id = id;
    }
    public String getDersAdi(){return dersAdi;}
    public void setDersAdi(String dersAdi){
        this.dersAdi = dersAdi;
    }
    public int getKredi(){return kredi;}
    public void setKredi(int kredi){
        this.kredi = kredi;
    }
    public Ogrenci getOgrenci(){return ogrenci;}
    public void SetOgrenci(Ogrenci ogrenci){
        this.ogrenci = ogrenci;
    }

}
