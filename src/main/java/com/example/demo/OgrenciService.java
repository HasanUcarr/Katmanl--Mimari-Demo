package com.example.demo;

import org.springframework.stereotype.Service;
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

        Ogrenci kaydedilenEntity = ogrenciRepository.save(entity);

        OgrenciDto responseDto = new OgrenciDto();
        responseDto.setId(kaydedilenEntity.getId());
        responseDto.setAd(kaydedilenEntity.getAd());
        responseDto.setBolum(kaydedilenEntity.getBolum());

        return responseDto;
    }

    public List<OgrenciDto> tumOgrencileriGetir(){

        List<Ogrenci> ogrenciler = ogrenciRepository.findAll();
        List<OgrenciDto> dtoList = new ArrayList<>();

        for(Ogrenci ogrenci: ogrenciler){
            OgrenciDto dto = new OgrenciDto();
            dto.setId(ogrenci.getId());
            dto.setAd(ogrenci.getAd());
            dto.setBolum(ogrenci.getBolum());
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