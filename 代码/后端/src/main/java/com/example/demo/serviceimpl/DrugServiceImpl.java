package com.example.demo.serviceimpl;

import com.example.demo.entity.Drug;
import com.example.demo.entity.Images;
import com.example.demo.entity.Supply;
import com.example.demo.mapper.DrugMapper;
import com.example.demo.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    DrugMapper drugMapper;

    public List<Drug> showdrug(){
        return drugMapper.showdrug();
    }

    @Override
    public List<Drug> getDrugByType(String TypeID) {
        return drugMapper.getDrugByType(TypeID);
    }

    @Override
    public List<Drug> getDrugByID(String DID) {
        return drugMapper.getDrugByID(DID);
    }

    @Override
    public void newDrug(String Dname, String Dmessage, String Dtype) {
        drugMapper.newDrug( Dname, Dmessage, Dtype);
    }

    @Override
    public void delDrug(String DID) {
        drugMapper.delDrug(DID);
    }

    @Override
    public void editDrug(String DID, String Dname, String Dmessage, String Dtype) {
        drugMapper.editDrug(DID, Dname, Dmessage, Dtype);
    }

    @Override
    public void supplyDrug(String DID, String SID, int Dinventory, BigDecimal Dprice) {
        drugMapper.supplyDrug(DID, SID, Dinventory, Dprice);
    }

    @Override
    public void delsupDrug(String DID, String SID) {
        drugMapper.delsupDrug(DID, SID);
    }

    @Override
    public void changeDinDrug(String DID, String SID, int Dinventory) {
        drugMapper.changeDinDrug(DID, SID, Dinventory);
    }
    public void changepriceDrug(String DID,String SID,BigDecimal price){
        drugMapper.changepriceDrug(DID, SID, price);
    }
    @Override
    public List<Supply> getsupplybyDID(String DID) {
        return drugMapper.getsupplybyDID(DID);
    }

    public Images getimg(String imgID){
        return drugMapper.getimg(imgID);
    }

    public List<Images> getimgID(String DID){
        return drugMapper.getimgID(DID);
    }

    public String existDrug(String DID){
        return drugMapper.existDrug(DID);
    }
}
