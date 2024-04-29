package com.invio.shoppingdemo.service;

import com.invio.shoppingdemo.dto.BasketResponse;
import com.invio.shoppingdemo.entity.Basket;
import com.invio.shoppingdemo.entity.Product;
import com.invio.shoppingdemo.exceptions.CommonException;
import com.invio.shoppingdemo.repository.BasketRepository;
import com.invio.shoppingdemo.repository.ProductRepository;
import com.invio.shoppingdemo.util.BasketDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService{

    private BasketRepository basketRepository;
    private ProductRepository productRepository;
    @Override
    public BasketResponse save(Basket basket) {
        basketRepository.save(basket);
        return BasketDtoConvertion.converBasket(basket);
    }

    @Override
    public BasketResponse delete(Long id) {

        Optional<Basket> optional = basketRepository.findById(id);

        if (optional.isPresent()){
            basketRepository.delete(optional.get());
            return BasketDtoConvertion.converBasket(optional.get());
        }
        throw new CommonException("Ilgili ID de Basket bulunamadi. ID : " +id , HttpStatus.NOT_FOUND);
    }

    @Override
    public BasketResponse findById(Long id) {
        Optional<Basket> optional = basketRepository.findById(id);

        if (optional.isPresent()){
            return BasketDtoConvertion.converBasket(optional.get());
        }

        throw new CommonException("Ilgili ID de Basket bulunamadi. ID : " +id , HttpStatus.NOT_FOUND);
    }

    @Override
    public Basket findByBasketId(Long id) {
        Optional<Basket> optional = basketRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }

        throw new CommonException("Ilgili ID de Basket bulunamadi. ID : " +id , HttpStatus.NOT_FOUND);
    }

    @Override
    public BasketResponse addToCart(Long basketID, Long productID) {
        Basket basket = basketRepository.findById(basketID)
                .orElseThrow(()->new CommonException("Basket bulunamadi . ID : "+basketID , HttpStatus.NOT_FOUND));
        Product product = productRepository.findById(productID)
                .orElseThrow(()-> new CommonException("Product bulunamadi. ID : "+productID,HttpStatus.NOT_FOUND));

        basket.getProductList().add(product);
        product.setBasket(basket);
        //TODO eger ayni ID li product var ise sayisini artir yoksa ekle .

        basketRepository.save(basket);

        return BasketDtoConvertion.converBasket(basket);
    }

    @Override
    public BasketResponse removeFromCart(Long basketID, Long productID) {
        Basket basket = basketRepository.findById(basketID)
                .orElseThrow(()->new CommonException("Basket bulunamadi . ID : "+basketID , HttpStatus.NOT_FOUND));

        boolean removed = false;
        Iterator<Product> iterator = basket.getProductList().iterator();
        while (iterator.hasNext()) {
            Product product1 = iterator.next();
            if (Objects.equals(productID, product1.getId())) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        //TODO eger bir Productin birden fazla adedi varsa 1 cikar . Sadece 1 tane varsa remove et .

        if (!removed) {
            throw new CommonException("Cikarilacak product bulunamadi . ID : " + productID, HttpStatus.NOT_FOUND);
        }

        basketRepository.save(basket);
        return BasketDtoConvertion.converBasket(basket);


    }


}
