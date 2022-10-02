package com.example.microser.controller;

import com.example.microser.entity.OfferEntity;
import com.example.microser.repository.OfferRepository;
import com.example.microser.service.OfferService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OfferController {

    private final OfferService offerService;
    private final OfferRepository offerRepository;

    public OfferController(OfferService offerService, OfferRepository offerRepository) {
        this.offerService = offerService;
        this.offerRepository = offerRepository;
    }

    @GetMapping("/findById/{id}")
    public Optional<OfferEntity> pullById(@PathVariable Long id){
        return offerService.getById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        OfferEntity offerEntity = new OfferEntity(1L, "JavaDeveloper", 12000);
        saveOffer(offerEntity);
        OfferEntity offerEntity1 = new OfferEntity(2L, "PythonDeveloper", 15000);
        saveOffer(offerEntity1);
    }

    private OfferEntity saveOffer(OfferEntity offerEntity) {
        return offerRepository.save(offerEntity);
    }

}
