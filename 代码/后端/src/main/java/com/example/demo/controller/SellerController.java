package com.example.demo.controller;

import com.example.demo.service.DrugService;
import com.example.demo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;

@Api(tags = "商家")
@RestController
@CrossOrigin
@RequestMapping("/drug")
public class SellerController {

    @Autowired
    DrugService drugService;

    @ApiOperation(value = "商家添加提供药品")
    @PostMapping("/supplyDrug")
    public Result supplyDrug(String DID, String SID, int Dinventory, BigDecimal Dprice){
        drugService.supplyDrug(DID,SID,Dinventory,Dprice);
        return Result.success();
    }

    @ApiOperation(value = "商家删除提供的药品")
    @PostMapping("/delsupDrug")
    public Result delsupDrug(String DID,String SID){
        drugService.delsupDrug(DID, SID);
        return Result.success();
    }

    @ApiOperation(value = "商家修改库存")
    @PostMapping("/changeDinDrug")
    public Result changeDinDrug(String DID,String SID,int Dinventory){
        drugService.changeDinDrug(DID, SID, Dinventory);
        return Result.success();
    }

    @ApiOperation(value = "商家修改价格")
    @PostMapping("/changepriceDrug")
    public Result changeDinDrug(String DID,String SID,BigDecimal price){
        drugService.changepriceDrug(DID, SID, price);
        return Result.success();
    }
}
