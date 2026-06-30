package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ogrenciler")
public class OgrenciController {

    private final OgrenciService ogrenciService;

    public OgrenciController(OgrenciService ogrenciService) {
        this.ogrenciService = ogrenciService;
    }

    @PostMapping
    public OgrenciDto kayitOlustur(@Valid @RequestBody OgrenciDto ogrenciDto) {
        return ogrenciService.ogrenciKaydet(ogrenciDto);
    }

    @GetMapping
    public List<OgrenciDto> listele() {
        return ogrenciService.tumOgrencileriGetir();
    }

    @PutMapping("/{id}")
    public OgrenciDto Guncelle(@PathVariable Long id, @Valid @RequestBody OgrenciDto guncelOgrenciDto) {
        return ogrenciService.ogrenciGuncelle(id, guncelOgrenciDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> sil(@PathVariable Long id){
        ogrenciService.ogrenciSil(id);
        return ResponseEntity.noContent().build(); 
    }
}