package com.example.demo.mapper;

import com.example.demo.entity.Buyer;
import com.example.demo.entity.User;
import com.example.demo.entity.Seller;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public Buyer getuse(String phone, String password);

    public Buyer getavatar(String bid);
    public Buyer newuse(String phone,String password);
    public void changecity(String bid,String city);
    public void changemessage(String bid,String message);
    public void changephone(String bid,String phone);
    public void changepwd(String bid,String password);
    public Buyer getuserbyID(String BID);

    public void addarchives(String bid,String chatresult);

    public void addressee(String bid,String address,String name,String phone);

}
