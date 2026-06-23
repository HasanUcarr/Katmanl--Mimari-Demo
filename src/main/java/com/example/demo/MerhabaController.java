package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerhabaController {

    private final MerhabaService merhabaSercive;

    public MerhabaController(MerhabaService merhabaService){
        this.merhabaSercive = merhabaService;
    }

    @GetMapping("/merhaba")
    public String MesajVer(@RequestParam(value = "isim", defaultValue = "Misafir") String isim) {
        return merhabaSercive.ozelMesajUret(isim);
    }
    
}
