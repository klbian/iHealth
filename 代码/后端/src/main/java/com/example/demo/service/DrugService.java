package com.example.demo.service;

import com.example.demo.entity.Drug;
import com.example.demo.entity.Images;
import com.example.demo.entity.Supply;

import java.math.BigDecimal;
import java.util.List;

public interface DrugService {
    public List<Drug> showdrug();

    public List<Drug> getDrugByType(String TypeID);
    public List<Drug> getDrugByID(String DID);
    public void newDrug(String Dname, String Dmessage ,String Dtype);
    public void delDrug(String DID);
    public void editDrug(String DID,String Dname,String Dmessage,String Dtype);

    public void supplyDrug(String DID, String SID, int Dinventory, BigDecimal Dprice);
    public void delsupDrug(String DID,String SID);
    public void changeDinDrug(String DID,String SID,int Dinventory);
    public void changepriceDrug(String DID,String SID,BigDecimal price);
    public List<Supply> getsupplybyDID(String DID);

    public Images getimg(String imgID);
    public List<Images> getimgID(String DID);
    public String existDrug(String DID);
}
