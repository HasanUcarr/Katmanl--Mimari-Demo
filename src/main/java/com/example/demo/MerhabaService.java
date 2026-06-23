package com.example.demo;

import org.springframework.stereotype.Service;;

@Service
public class MerhabaService {
    public String ozelMesajUret(String isim){
        return "sistem katmanlı mimari ile çalışıyor. istek gönderen: " + isim; 
    }
}
