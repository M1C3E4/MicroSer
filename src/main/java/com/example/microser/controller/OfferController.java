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

    @GetMapping("/findByTitle/{title}")
    public Optional<OfferEntity> pullByTitle(@PathVariable String title){
        return offerService.getByTitle(title);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        OfferEntity offerEntity1 = new OfferEntity(1L, "PythonDeveloper", 15000);
        saveOffer(offerEntity1);
        OfferEntity offerEntity2 = new OfferEntity(2L, "JavaDeveloper", 9000);
        saveOffer(offerEntity2);
    }

    private OfferEntity saveOffer(OfferEntity offerEntity) {
        return offerRepository.save(offerEntity);
    }

}
