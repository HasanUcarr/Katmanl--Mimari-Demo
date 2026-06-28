package com.example.demo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


public class DersDto {
    private Long id;

    @NotBlank(message = "Ders adı boş olamaz!")
    private String dersAdi;

    @Positive(message = "Kredi pozitif bir sayı olmalıdır!")
    private int kredi;

    public Long getId(){return id;}
    public void setId(Long id) {this.id = id;}

    public String getDersAdi(){return dersAdi;}
    public void setDersAdi(String dersAdi){this.dersAdi = dersAdi;}

    public int getKredi(){return kredi;}
    public void setKredi(int kredi){this.kredi = kredi;}
}
