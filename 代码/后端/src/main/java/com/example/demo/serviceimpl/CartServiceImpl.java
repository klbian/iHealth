package com.example.demo.serviceimpl;

import com.example.demo.entity.Cart;
import com.example.demo.mapper.CartMaapper;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMaapper cartMaapper;

    @Override
    public void addcart(String uid,String did,String sid){
        cartMaapper.addcart(uid,did,sid);
    }

    @Override
    public void removecart(String uid,String did,String sid){
        cartMaapper.removecart(uid, did,sid);
    }

    public void emptycart(String uid){
        cartMaapper.emptycart(uid);
    }

    public List<Cart> getcart(String uid){
        return cartMaapper.getcart(uid);
    }

    public void addnum(String uid,String did,String sid){
        cartMaapper.addnum(uid, did,sid);
    }

    public void subnum(String uid,String did,String sid){
        cartMaapper.subnum(uid,did,sid);
    }

}
