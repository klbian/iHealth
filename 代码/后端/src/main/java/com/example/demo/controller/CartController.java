package com.example.demo.controller;

import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;
import com.example.demo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "购物车")
@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @ApiOperation(value = "加入购物车")
    @PostMapping("/addcart")
    public void addcart(String uid, String did,String sid){
        cartService.addcart(uid,did,sid);
    }
    @ApiOperation(value = "移出购物车")
    @PostMapping("/removecart")
    public void removecart(String uid,String did,String sid){
        cartService.removecart(uid, did,sid);
    }
    @ApiOperation(value = "清空购物车")
    @PostMapping("/emptycart")
    public void emptycart(String uid){
        cartService.emptycart(uid);
    }

    @ApiOperation(value = "获取购物车")
    @GetMapping("/getcart")
    public Result getcart(String uid){
        List<Cart> carts = cartService.getcart(uid);
        return Result.success(carts);
    }
    @ApiOperation(value = "添加数量")
    @PostMapping("/addnum")
    public void addnum(String uid,String did,String sid){
        cartService.addnum(uid, did,sid);
    }

    @ApiOperation(value = "减少数量")
    @PostMapping("/subnum")
    public void subnum(String uid,String did,String sid){
        cartService.subnum(uid, did,sid);
    }


}
