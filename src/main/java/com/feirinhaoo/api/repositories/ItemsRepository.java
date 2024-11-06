package com.feirinhaoo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feirinhaoo.api.models.ItemsModel;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsModel, Long> {
    
}
