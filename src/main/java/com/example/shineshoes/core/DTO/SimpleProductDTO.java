package com.example.shineshoes.core.DTO;

import java.math.BigDecimal;

public record SimpleProductDTO(
        Long id,
        String name,
        String description,
        String model,
        BigDecimal price
) {}
