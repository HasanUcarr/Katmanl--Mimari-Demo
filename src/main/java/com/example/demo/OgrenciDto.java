package com.example.demo;

import java.util.List;
import java.util.ArrayList;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class OgrenciDto {

    private Long id;

    @NotBlank(message = "Öğrenci adı boş bırakılamaz!")
    @Size(min = 2, message = "Öğrenci adı en az 2 karakter olmalıdır!")
    private String ad;

    @NotBlank(message = "Bölüm bilgisi boş bırakılamaz!")
    private String bolum;

    private List<DersDto> dersler = new ArrayList<>();

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
    public List<DersDto> getDersler(){return dersler;}
    public void setDersler(List<DersDto> dersler){this.dersler = dersler;}
}
