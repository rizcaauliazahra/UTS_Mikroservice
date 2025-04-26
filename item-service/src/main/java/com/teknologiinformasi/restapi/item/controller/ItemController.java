package com.teknologiinformasi.restapi.item.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teknologiinformasi.restapi.item.model.Item;
import com.teknologiinformasi.restapi.item.service.ItemService;

// import com.teknologiinformasi.restapi.model.Item;
// import com.teknologiinformasi.restapi.service.ItemService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    private static final Logger log = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    // Endpoint untuk mengambil semua item
    @GetMapping
    public List<Item> getAllItem() {
        log.info("GET /api/item accessed");
        return itemService.getAllItem();
    }

    // Endpoint untuk mengambil item berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        log.info("GET /api/item/{} accessed", id);
        return itemService.getItemById(id)
                .map(item -> ResponseEntity.ok().body(item))
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint untuk membuat item baru
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        log.info("POST /api/item accessed with body: {}", item);
        return itemService.createItem(item);
    }

    // Endpoint untuk mengupdate item yang sudah ada
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
        log.info("PUT /api/item/{} accessed with body: {}", id, itemDetails);

        try {
            Item updatedItem = itemService.updateItem(id, itemDetails);
            return ResponseEntity.ok(updatedItem);
        } catch (RuntimeException e) {
            log.warn("PUT /api/item/{} failed: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint untuk menghapus item
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteItem(@PathVariable Long id) {
        log.info("DELETE /api/item/{} accessed", id);
        Map<String, String> response = new HashMap<>();
        try {
            itemService.deleteItem(id);
            response.put("message", "Item berhasil dihapus");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("message", "Item tidak ditemukan dengan id " + id);
            log.warn("DELETE /api/item/{} failed: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}