package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/ogrenciler") // Bu controller altındaki tüm uç noktalar bu adresten başlar.
public class OgrenciController {

    private final OgrenciService ogrenciService;

    public OgrenciController(OgrenciService ogrenciService) {
        this.ogrenciService = ogrenciService;
    }
    // HTTP POST isteği. Veritabanına yeni kayıt eklemek için kullanılır.
    // @RequestBody: Dışarıdan gelen JSON verisini Java 'Ogrenci' nesnesine dönüştürür.
    @PostMapping
    public OgrenciDto kayitOlustur(@Valid @RequestBody OgrenciDto ogrenciDto) {
        return ogrenciService.ogrenciKaydet(ogrenciDto);
    }

    // HTTP GET isteği. Veritabanındaki kayıtları okumak için kullanılır.
    @GetMapping
    public List<OgrenciDto> listele() {
        return ogrenciService.tumOgrencileriGetir();
    }

    @PutMapping("/{id}")
    public OgrenciDto Guncelle(@PathVariable Long id, @Valid @RequestBody OgrenciDto guncelOgrenciDto) {
        return ogrenciService.ogrenciGuncelle(id, guncelOgrenciDto);
    }

    @DeleteMapping("/{id}")
    public void sil(@PathVariable Long id){
        ogrenciService.ogrenciSil(id);
    }
}