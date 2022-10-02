package com.example.microser.repository;

import antlr.collections.List;
import com.example.microser.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {
   Optional<OfferEntity>findByTitle(String title);
    Optional<OfferEntity> findById(Long id);
}
