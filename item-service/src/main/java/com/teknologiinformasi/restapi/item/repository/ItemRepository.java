package com.teknologiinformasi.restapi.item.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teknologiinformasi.restapi.item.model.Item;

// import com.teknologiinformasi.restapi.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}