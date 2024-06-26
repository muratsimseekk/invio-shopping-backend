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

    //Her bir ekleme yapildiginda urun sayisi 0 veya null ise 1 e ceker , degilse 1 artirir .

    @Override
    public BasketResponse addToCart(Long basketID, Long productID) {
        Basket basket = basketRepository.findById(basketID)
                .orElseThrow(() -> new CommonException("Basket bulunamadi . ID : " + basketID, HttpStatus.NOT_FOUND));
        Product product = productRepository.findById(productID)
                .orElseThrow(() -> new CommonException("Product bulunamadi. ID : " + productID, HttpStatus.NOT_FOUND));

        basket.getProductList().add(product);
        product.setBasket(basket);

        if (product.getCount() == null) {
            product.setCount(1);
        } else {
            product.setCount(product.getCount() + 1);
        }

        // Toplam fiyatı hesaplama logic .
        Double totalPrice = 0.0;
        for (Product product1 : basket.getProductList()) {
            totalPrice += product1.getPrice() * product1.getCount();
        }
        basket.setTotalPrice(totalPrice);

        // Sepeti kaydet logic .
        basketRepository.save(basket);

        return BasketDtoConvertion.converBasket(basket);
    }

    //Her bir cikarma yapildiginda urun sayisi urun sayisi 1 olana kadar urun sepette kalir(sayisi azalir) eger 1 olursa sepetten silinir.
    @Override
    public BasketResponse removeFromCart(Long basketID, Long productID) {
        Basket basket = basketRepository.findById(basketID)
                .orElseThrow(() -> new CommonException("Basket bulunamadi . ID : " + basketID, HttpStatus.NOT_FOUND));

        boolean removed = false;
        Iterator<Product> iterator = basket.getProductList().iterator();
        while (iterator.hasNext()) {
            Product product1 = iterator.next();
            if (product1.getId() == productID) {
                if (product1.getCount() == 1) {
                    iterator.remove();
                    removed = true;
                } else {
                    product1.setCount(product1.getCount() - 1);
                    removed = true;
                }
                break;
            }
        }

        if (!removed) {
            throw new CommonException("Cikarilacak product bulunamadi . ID : " + productID, HttpStatus.NOT_FOUND);
        }

        // Toplam fiyatı güncelle
        double totalPrice = 0.0;
        for (Product product : basket.getProductList()) {
            totalPrice += product.getPrice() * product.getCount();
        }
        basket.setTotalPrice(totalPrice);

        basketRepository.save(basket);
        return BasketDtoConvertion.converBasket(basket);
    }



}
