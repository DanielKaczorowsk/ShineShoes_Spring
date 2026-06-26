package com.example.shineshoes.core.Services;


import com.example.shineshoes.core.Model.Product;
import com.example.shineshoes.core.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeServices
{
    public final ProductRepository product;
    @Transactional
    public List<Product> getNewsBoots()
    {
        Pageable newBoots = PageRequest.of(0, 12);
        return product.findProductByNews(newBoots);
    }
    @Transactional
    public List<Product> getTopProduct(String name)
    {
        Pageable topTen = PageRequest.of(0, 10);
        return product.findProductByCategoryWithTop(name,topTen);
    }
    public List<String> getAllModel()
    {
        return product.findAllModels();
    }

}
