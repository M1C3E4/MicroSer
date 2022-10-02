package com.example.microser.service;

import antlr.collections.List;
import com.example.microser.entity.OfferEntity;
import com.example.microser.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.ObjDoubleConsumer;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    public Optional<OfferEntity> getById (Long id){
        return offerRepository.findById(id);
    }

    public Optional<OfferEntity> getByTitle(String title){
        return offerRepository.findByTitle(title);
    }

}
