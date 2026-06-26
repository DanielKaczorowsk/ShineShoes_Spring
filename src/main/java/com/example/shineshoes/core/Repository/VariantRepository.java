package com.example.shineshoes.core.Repository;

import com.example.shineshoes.core.Model.Product;
import com.example.shineshoes.core.Model.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;


@Repository
public interface VariantRepository extends JpaRepository<ProductVariant,Long>
{
    Optional<ProductVariant> findByProductAndColorAndSize(Product product,String color,BigDecimal size);
}