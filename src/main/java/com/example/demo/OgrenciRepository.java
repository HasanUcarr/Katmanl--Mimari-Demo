package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {
    // JpaRepository sayesinde kaydetme, silme, güncelleme ve ID ile bulma 
    // gibi standart veritabanı işlemleri otomatik olarak bu arayüze yüklenir.
    // İçine hiçbir kod yazmamıza gerek yoktur.
}