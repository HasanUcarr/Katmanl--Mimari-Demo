package com.example.demo;
import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ogrenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ad;
    private String bolum;

    @OneToMany(mappedBy = "ogrenci", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ders> dersler = new ArrayList<>();
    public Ogrenci(){   
    }
    public Ogrenci(String ad, String bolum){
        this.ad = ad;
        this.bolum = bolum;
    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }
    public List<Ders> getDersler(){return dersler;}
    public void setDersler(List<Ders> dersler){this.dersler = dersler;}


}
