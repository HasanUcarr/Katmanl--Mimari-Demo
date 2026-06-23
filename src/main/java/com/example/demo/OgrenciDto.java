package com.example.demo;

public class OgrenciDto {

    private Long id;
    private String ad;
    private String bolum;

    public OgrenciDto(){
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getAd(){
        return ad;
    }
    public void setAd(String ad){
        this.ad = ad;
    }
    public String getBolum(){
        return bolum;
    }
    public void setBolum(String bolum){
        this.bolum = bolum;
    }
}
