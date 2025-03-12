package com.inventory.inventory.controller;

import com.inventory.inventory.dto.InventoryDTO;
import com.inventory.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/item")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<InventoryDTO> getItems() {
        return inventoryService.getAllItems();
    }

    @GetMapping("/{itemId}")
    public InventoryDTO getItemById(@PathVariable Integer itemId) {
        return inventoryService.getItemById(itemId);
    }

    @PostMapping
    public InventoryDTO saveItem(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.saveItem(inventoryDTO);
    }

    @PutMapping
    public InventoryDTO updateItem(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.updateItem(inventoryDTO);
    }

    @DeleteMapping("/{itemId}")
    public String deleteItem(@PathVariable Integer itemId) {
        return inventoryService.deleteItem(itemId);
    }
}
