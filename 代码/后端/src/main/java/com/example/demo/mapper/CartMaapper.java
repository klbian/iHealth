package com.example.demo.mapper;

import com.example.demo.entity.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMaapper {
    public void addcart(String BID, String DID,String SID);
    public void removecart(String BID, String DID,String SID);
    public void emptycart(String BID);
    public void addnum(String BID, String DID,String SID);
    public void subnum(String BID, String DID,String SID);
    public List<Cart> getcart(String BID);
}
