package com.invio.shoppingdemo.service;

import com.invio.shoppingdemo.dto.BasketResponse;
import com.invio.shoppingdemo.dto.ProductResponse;
import com.invio.shoppingdemo.entity.Basket;
import com.invio.shoppingdemo.entity.Product;
import com.invio.shoppingdemo.exceptions.CommonException;
import com.invio.shoppingdemo.repository.BasketRepository;
import com.invio.shoppingdemo.repository.ProductRepository;
import com.invio.shoppingdemo.util.BasketDtoConvertion;
import com.invio.shoppingdemo.util.ProductDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Override
    public List<ProductResponse> findAll() {
        return ProductDtoConvertion.convertProductList( productRepository.findAll());
    }

    @Override
    public ProductResponse findById(Long id) {
        Optional<Product> optional = productRepository.findById(id);

        if (optional.isPresent()){
            return ProductDtoConvertion.convertProduct(optional.get());
        }

        throw new CommonException("Girilen Id'de bir Product bulunamadi . ID: " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public Product findByProductId(Long id) {
        Optional<Product> optional = productRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }
        throw new CommonException("Girilen Id'de bir Product bulunamadi . ID: " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public ProductResponse save(Product product) {
         productRepository.save(product);
        return ProductDtoConvertion.convertProduct(product);
    }

    @Override
    public ProductResponse delete(Long id) {
        Optional<Product> optional = productRepository.findById(id);

        if (optional.isPresent()){
            //TODO return type
            productRepository.delete(optional.get());
            return ProductDtoConvertion.convertProduct(optional.get());
        }
        throw new CommonException("Girilen Id'de bir Product bulunamadi . ID: " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public List<ProductResponse> sortByAsc() {
        return ProductDtoConvertion.convertProductList(productRepository.sortByAsc());
    }

    @Override
    public List<ProductResponse> sortByDesc() {
        return ProductDtoConvertion.convertProductList(productRepository.sortByDesc());
    }

    @Override
    public List<ProductResponse> determineSorting(String sort) {
        if (sort.equals("asc")){
            return sortByAsc();
        } else if (sort.equals("desc")) {
            return sortByDesc();
        }
        throw new CommonException("Girilen sort degeri tanimsiz !." ,HttpStatus.BAD_REQUEST);
    }




}
