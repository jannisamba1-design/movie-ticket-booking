package com.moviebooking.inventory.controller;

import com.moviebooking.inventory.dto.LockRequest;
import com.moviebooking.inventory.service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/lock")
    public ResponseEntity<Void> lock(@Valid @RequestBody LockRequest request) {
        inventoryService.lockSeats(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/release")
    public ResponseEntity<Void> release(@Valid @RequestBody LockRequest request) {
        inventoryService.releaseSeats(request);
        return ResponseEntity.ok().build();
    }
}
