package com.example.demo.controller;

import com.example.demo.entity.Drug;
import com.example.demo.entity.Images;
import com.example.demo.entity.Supply;
import com.example.demo.entity.User;
import com.example.demo.service.DrugService;
import com.example.demo.service.TypeService;
import com.example.demo.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "药品")
@RestController
@CrossOrigin
@RequestMapping("/drug")
public class DrugController {

    @Autowired
    private DrugService goodsService;
    @Autowired
    private TypeService typeService;

    @ApiOperation(value = "获取所有药品信息", notes = "获取药品的所有信息")
    @GetMapping("/showdrug")
    public Result showdrug(){
        List<Drug> goods = goodsService.showdrug();
            return Result.success(goods);
    }

    @ApiOperation(value = "根据类别获取药品")
    @GetMapping("/getDrugByType")
    public Result getDrugByType(String typeid){
        String id = typeService.existtid(typeid);
        if (id==null){
            return Result.error("类别不存在");
        }else{
            List<Drug> drugs = goodsService.getDrugByType(typeid);
            return Result.success(drugs);
        }
    }

    @ApiOperation(value = "根据ID获取药品")
    @GetMapping("/getDrugByID")
    public Result getDrugByID(String DID){
        String id = goodsService.existDrug(DID);
        if (id==null){
            return Result.error("药品不存在");
        }else{
            List<Drug> drugs = goodsService.getDrugByID(DID);
            return Result.success(drugs);
        }
    }

    @ApiOperation(value = "上架商品")
    @PostMapping("/newDrug")
    @ApiImplicitParam(name = "res", value = "Dname<br>Dmessage<br>Dtype")
    public Result newDrug(@RequestBody Map<String,String> res) {
        String Dname = res.get("Dname");
        String Dmessage = res.get("Dmessage");
        String Dtype = res.get("Dtype");
        String type = typeService.existtid(Dtype);
        if(type!=null){
            goodsService.newDrug(Dname, Dmessage, Dtype);
            return Result.success();
        }
        else {
            return Result.error("类型不存在");
        }
    }

    @ApiOperation(value = "删除商品")
    @PostMapping("/delDrug")
    public Result delDrug(@RequestBody Map<String,String> res){
        String DID=res.get("DID");
        String id = goodsService.existDrug(DID);
        if (id==null){
            return Result.error("药品不存在");
        }else{
            goodsService.delDrug(DID);
            return Result.success();
        }

    }

    @ApiOperation(value = "修改商品")
    @PostMapping("/editDrug")
    @ApiImplicitParam(name = "res", value = "{<br>\"DID\": \" \" , <br>\"Dname\": \" \" , <br>\"Dmessage\": \" \" , <br>\"Dtype\": \" \" <br> }")
    public Result editDrug(@RequestBody Map<String,String> res){

        String DID=res.get("DID");
        String Dname=res.get("Dname");
        String Dmessage=res.get("Dmessage");
        String Dtype=res.get("Dtype");
        String id = goodsService.existDrug(DID);
        String typeid = typeService.existtid(Dtype);
        if (id==null){
            return Result.error("药品不存在");
        }else if (typeid==null){
            return Result.error("类别不存在");
        }else{
            goodsService.editDrug(DID, Dname, Dmessage, Dtype);
            return Result.success();
        }

    }

    @ApiOperation(value = "获取哪些商家提供该药品")
    @GetMapping("/getsupplybyDID")
    public Result getsupplybyDID(String DID){
        List<Supply> drugs = goodsService.getsupplybyDID(DID);
        return Result.success(drugs);
    }

    @ApiOperation(value = "获取药品图片")
    @GetMapping("/getimg")
    public ResponseEntity<byte[]> getimg(String imgid){
        Images images = goodsService.getimg(imgid);
        byte[] img = images.getImg();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(img,headers, HttpStatus.OK);
    }

    @ApiOperation(value = "获取药品图片ID")
    @GetMapping("/getimgid")
    public Result getimgid(String did){
        List<Images> images = goodsService.getimgID(did);
        return Result.success(images);
    }



}
