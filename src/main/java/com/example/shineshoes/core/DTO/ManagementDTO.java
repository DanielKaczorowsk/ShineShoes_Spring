package com.example.shineshoes.core.DTO;

import com.example.shineshoes.core.Model.ProductVariant;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManagementDTO
{
    @NotBlank(message = "Brak nazwy")
    private String name;
    @NotBlank(message = "Brak opisu")
    private String description;
    @NotBlank(message = "Brak modelu")
    private String model;
    @NotNull(message = "Brak ceny")
    @Positive(message = "Cena musi byc > 0")
    private BigDecimal price;
    @NotEmpty(message = "Brak kategori")
    private List<@NotBlank String> category;
    @NotEmpty(message = "Brak wariantow")
    private List<ProductVariantDTO> productVariantDTO;
}
