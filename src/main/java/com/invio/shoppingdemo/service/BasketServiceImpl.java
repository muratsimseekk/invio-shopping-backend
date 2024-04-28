package com.invio.shoppingdemo.service;

import com.invio.shoppingdemo.dto.BasketResponse;
import com.invio.shoppingdemo.entity.Basket;
import com.invio.shoppingdemo.exceptions.CommonException;
import com.invio.shoppingdemo.repository.BasketRepository;
import com.invio.shoppingdemo.util.BasketDtoConvertion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService{

    private BasketRepository basketRepository;
    @Override
    public Basket save(Basket basket) {
        return basketRepository.save(basket);
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
}
