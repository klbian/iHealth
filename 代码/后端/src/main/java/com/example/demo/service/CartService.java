package com.example.demo.service;

import com.example.demo.entity.Cart;

import java.util.List;

public interface CartService {
    public void addcart(String uid,String did,String sid);

    public void removecart(String uid,String did,String sid);

    public void emptycart(String uid);

    public List<Cart> getcart(String uid);

    public void addnum(String uid,String did,String sid);

    public void subnum(String uid,String did,String sid);

}
