package com.example.demo;

import org.springframework.stereotype.Service;
import com.example.demo.DersDto;
import com.example.demo.Ders;
import java.util.ArrayList;
import java.util.List;

@Service
public class OgrenciService{

    private final OgrenciRepository ogrenciRepository;

    public OgrenciService(OgrenciRepository ogrenciRepository){
        this.ogrenciRepository = ogrenciRepository;
    }

    public OgrenciDto ogrenciKaydet(OgrenciDto ogrenciDto){
        Ogrenci entity = new Ogrenci();
        entity.setAd(ogrenciDto.getAd());
        entity.setBolum(ogrenciDto.getBolum());

        if(ogrenciDto.getDersler() != null){
            for(DersDto dersDto : ogrenciDto.getDersler()){
                Ders dersEntity = new Ders();
                dersEntity.setDersAdi(dersDto.getDersAdi());
                dersEntity.setKredi(dersDto.getKredi());
                //ilişkinin kurulduğu yer burası
                dersEntity.SetOgrenci(entity);
                // Ders entity'sini, Öğrenci entity'sinin listesine ekliyoruz
                entity.getDersler().add(dersEntity);
            }
        }
        //CascadeType.ALL burada öğrenciyi kaydettiğimiz için öğrenciye ait tüm dersleri de kaydetmesini sağladı
        Ogrenci kaydedilenEntity =ogrenciRepository.save(entity);

        //Kaydedilen veriyi tekrar DTO'ya çevirip dışarı yolluyor
        OgrenciDto responseDto = new OgrenciDto();
        responseDto.setId(kaydedilenEntity.getId());
        responseDto.setAd(kaydedilenEntity.getAd());
        responseDto.setBolum(kaydedilenEntity.getBolum());


        for(Ders ders : kaydedilenEntity.getDersler()){
            DersDto dDto = new DersDto();
            dDto.setId(ders.getId());
            dDto.setDersAdi(ders.getDersAdi());
            dDto.setKredi(ders.getKredi());
            responseDto.getDersler().add(dDto);
        }
        return responseDto;
    }

    public List<OgrenciDto> tumOgrencileriGetir(){

        List<Ogrenci> ogrenciler = ogrenciRepository.findAll();
        List<OgrenciDto> dtoList = new ArrayList<>();

        for(Ogrenci ogrenci : ogrenciler){
            OgrenciDto dto  = new OgrenciDto();
            dto.setId(ogrenci.getId());
            dto.setAd(ogrenci.getAd());
            dto.setBolum(ogrenci.getBolum());

            for(Ders ders: ogrenci.getDersler()){
                DersDto dersDto = new DersDto();
                dersDto.setId(ders.getId());
                dersDto.setDersAdi(ders.getDersAdi());
                dersDto.setKredi(ders.getKredi());
                dto.getDersler().add(dersDto);
            }
            dtoList.add(dto);
        }
        return dtoList;

    }
    public OgrenciDto ogrenciGuncelle(Long id, OgrenciDto guncelBilgilerDto){

        Ogrenci mevcutOgrenci = ogrenciRepository.findById(id).orElse(null);

        if(mevcutOgrenci != null){
            mevcutOgrenci.setAd(guncelBilgilerDto.getAd());
            mevcutOgrenci.setBolum(guncelBilgilerDto.getBolum());

            Ogrenci guncellenenEntity = ogrenciRepository.save(mevcutOgrenci);

            OgrenciDto responseDto = new OgrenciDto();
            responseDto.setId(guncellenenEntity.getId());
            responseDto.setAd(guncellenenEntity.getAd());
            responseDto.setBolum(guncellenenEntity.getBolum());

            return responseDto;
        }
        return null;
    }
    public void ogrenciSil(Long id){
        ogrenciRepository.deleteById(id);
    }
    
}