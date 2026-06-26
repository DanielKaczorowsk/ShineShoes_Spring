package com.example.shineshoes.core.Controllers;
import com.example.shineshoes.core.DTO.ManagementDTO;
import com.example.shineshoes.core.DTO.ProductVariantDTO;
import com.example.shineshoes.core.Model.Product;
import com.example.shineshoes.core.Services.ManagementProduct;
import com.example.shineshoes.core.Services.HomeServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/shopSite")
@CrossOrigin(origins = "http://localhost:3000" , allowCredentials = "true")
public class ShopController
{
    private final HomeServices services;
    private final ManagementProduct managementProduct;
    private final ObjectMapper objectMapper;
    public ShopController (HomeServices service, ManagementProduct managementProduct, ObjectMapper objectMapper){this.services = service;
        this.managementProduct = managementProduct;
        this.objectMapper = objectMapper;
    }
    @PostMapping("/newproduct")
    public ResponseEntity<List<Product>> newBoots()
    {
        List<Product> newBoots = this.services.getNewsBoots();
        return ResponseEntity.ok(newBoots);
    }
    @PostMapping("/top/{name}")
    public ResponseEntity<List<Product>> topBoots(@PathVariable String name)
    {
        List<Product> topSneakers = this.services.getTopProduct(name);
        return ResponseEntity.ok(topSneakers);
    }
    @PostMapping("/models")
    public ResponseEntity<List<Product>> getNewsBoots()
    {
        List<Product> allModels = this.services.getNewsBoots();
        return ResponseEntity.ok(allModels);
    }
    @PostMapping(value = "/addproduct",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addProduct(@RequestParam("managementDTOJson") String managementDTOJson)
                                        //@RequestParam("productVariantDTOJson") String productVariantDTOJson)
                                            /*,
                                             @RequestPart("images") List<MultipartFile> images)*/
    {
        try
        {
            ManagementDTO managementDTO = objectMapper.readValue(managementDTOJson, ManagementDTO.class);
            //ProductVariantDTO productVariantDTO = objectMapper.readValue(productVariantDTOJson,ProductVariantDTO.class);
            managementProduct.addProduct(managementDTO);
            return ResponseEntity.ok(Map.of("message", "Produkt zostal dodany pomyslnie!"));
        }
        catch(Exception e)
        {
            log.error("Błąd podczas przetwarzania dodawania produktu: ", e);
            return ResponseEntity.badRequest().body("Błąd parsowania danych: " + e.getMessage());
        }
    }
}
