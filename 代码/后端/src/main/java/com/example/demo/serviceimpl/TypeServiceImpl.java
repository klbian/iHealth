package com.example.demo.serviceimpl;

import com.example.demo.entity.Type;
import com.example.demo.mapper.TypeMapper;
import com.example.demo.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;

    @Override
    public void newtype(String typename, String sortorder,byte[] icon){
        typeMapper.newtype(typename,  sortorder,icon);
    }

    public void deltype(String typeid){
        typeMapper.deltype(typeid);
    }
    public void renametype(String typeid,String typename){
        typeMapper.renametype(typeid, typename);
    }
    public void changeorder(String typeid,String sortorder){
        typeMapper.changeorder(typeid, sortorder);
    }
    public List<Type> gettype(){

        return typeMapper.gettype();

    }

    public Type geticon(String typeid){
        return typeMapper.geticon(typeid);
    }

    public String existorder(String order){
        return typeMapper.existorder(order);
    }
    public String existtid(String tid){
        return typeMapper.existtid(tid);
    }

}
