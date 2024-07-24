package com.example.demo.serviceimpl;

import com.example.demo.entity.Buyer;
import com.example.demo.entity.User;
import com.example.demo.entity.Seller;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public Buyer getuse(String phone, String password) {
        return userMapper.getuse(phone,password);
    }

    public Buyer getavatar(String bid){
        return userMapper.getavatar(bid);
    }

    public Buyer newuse(String phone,String password){
        userMapper.newuse(phone, password);
        return userMapper.getuse(phone, password);
    }

    public void changecity(String bid, String city){
        userMapper.changecity(bid, city);
    }

    public void changemessage(String bid, String message){
        userMapper.changemessage(bid, message);
    }

    public void changephone(String bid, String phone){
        userMapper.changephone(bid, phone);
    }

    public void changepwd(String bid, String password){
        userMapper.changepwd(bid, password);
    }
    public Buyer getuserbyID(String BID){
        return userMapper.getuserbyID(BID);
    }


    public void addarchives(String bid,String chatresult){
        userMapper.addarchives(bid, chatresult);
    }
    public void addressee(String bid,String address,String name,String phone){
        userMapper.addressee(bid, address, name, phone);
    }

}