package com.example.demo.service;

import com.example.demo.entity.Type;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TypeService {
    public void newtype(String typename, String sortorder,byte[] icon);
    public void deltype(String typeid);
    public void renametype(String typeid,String typename);
    public void changeorder(String typeid,String sortorder);
    public List<Type> gettype();
    public Type geticon(String typeid);

    public String existorder(String order);
    public String existtid(String tid);
}
