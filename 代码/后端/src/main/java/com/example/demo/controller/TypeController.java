package com.example.demo.controller;


import com.example.demo.entity.Type;
import com.example.demo.entity.User;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Api(tags = "分类")
@RestController
@CrossOrigin
@RequestMapping("/type")
public class TypeController {
    @Autowired
    TypeService typeService;

    @ApiOperation(value = "获取类别")
    @GetMapping("/gettype")
    public Result gettype(){
        List<Type> types = typeService.gettype();
        return Result.success(types);
    }

    @ApiOperation(value = "获取类别图标")
    @GetMapping("/geticon")
    public ResponseEntity<byte[]> geticon(String typeid){
        String tid = typeService.existtid(typeid);
        if(tid!=null) {
            Type type = typeService.geticon(typeid);
            byte[] img = type.getIcon();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            return new ResponseEntity<>(img, headers, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "添加类别")
    @PostMapping("/newtype")
    public Result newtype(String typename,String sortorder,@RequestParam MultipartFile icon){
        String order = typeService.existorder(sortorder);
        if (order!=null){
            return Result.error("顺序重复");
        }
        else {
            InputStream ins = null;
            byte[] data = new byte[1024];
            try {
                ins = icon.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                while ((len = ins.read(buffer)) != -1) {
                    bos.write(buffer, 0, len);
                }
                bos.flush();
                data = bos.toByteArray();
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            typeService.newtype(typename,sortorder,data);
            return Result.success();
        }
    }

    @ApiOperation(value = "删除类别")
    @PostMapping("/deltype")
    public Result deltype(String typeid){
        String tid = typeService.existtid(typeid);
        if(tid!=null) {
            typeService.deltype(typeid);
            return Result.success();
        }
        else{
            return Result.error("该类不存在");
        }
    }

    @ApiOperation(value = "重命名类别")
    @PostMapping("/renametype")
    @ApiImplicitParam(name = "res", value = "typeid<br>typename")
    public Result renametype(@RequestBody Map<String,String> res) {
        String typeid=res.get("typeid");
        String typename=res.get("typename");
        String tid = typeService.existtid(typeid);
        if (tid != null) {
            typeService.renametype(typeid, typename);
            return Result.success();
        }
        else{
            return Result.error("该类不存在");
        }
    }

    @ApiOperation(value = "修改类别顺序")
    @PostMapping("/changeorder")
    @ApiImplicitParam(name = "res", value = "typeid<br>sortorder")
    public Result changeorder(@RequestBody Map<String,String> res){
        String typeid=res.get("typeid");
        String sortorder=res.get("sortorder");
        String tid = typeService.existtid(typeid);
        String order=typeService.existorder(sortorder);
        if (tid != null && order ==null) {
            typeService.changeorder(typeid, sortorder);
            return Result.success();
        }
        else if(tid==null){
            return Result.error("该类不存在");
        }
        else{
            return Result.error("顺序重复");
        }
    }
}
