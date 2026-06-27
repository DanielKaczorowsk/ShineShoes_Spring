package com.example.shineshoes.core.Services;


import com.example.shineshoes.core.DTO.SimpleProductDTO;
import com.example.shineshoes.core.Model.Product;
import com.example.shineshoes.core.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeServices
{
    public final ProductRepository product;
    @Transactional
    public List<SimpleProductDTO> getNewsBoots()
    {
        return product.findTop30ByOrderByCreatedAtDesc();
    }
    @Transactional
    public List<Product> getTopProduct(String name)
    {
        Pageable topTen = PageRequest.of(0, 30);
        return product.findProductByCategoryWithTop(name,topTen);
    }
    @Transactional
        public List<String> findFirst30DistinctModelBy()
    {
        Pageable model = PageRequest.of(0, 30);
        return product.findDistinctModels(model);
    }

}
