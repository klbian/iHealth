package com.example.demo.controller;


import com.example.demo.entity.Buyer;
import com.example.demo.service.UserService;
import com.example.demo.util.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "用户")
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;


    @ApiOperation(value = "登录", notes = "用户登录")
    @ApiImplicitParam(name = "user", value = "phone,password")
    @PostMapping("/login")
    public Result login(@RequestBody Map<String, String> user) {
        String phone = user.get("phone");
        String password = user.get("password");

        // 检查传入参数是否为空，如果为空，直接返回
        if (phone == null || password == null || phone.isEmpty() || password.isEmpty()) {
            return Result.error("账号和密码不能为空");
        }
        // 调用 userService.login 方法，获取用户信息
        Buyer buyer = userService.getuse(phone,password);

        // 检查是否找到用户
        if (buyer != null) {
                return Result.success(buyer);
        } else {
            return Result.error("用户名或密码错误");
        }
    }





    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public Result registerUser(@RequestBody Map<String, String> user) {

        String phone = user.get("phone");
        String password = user.get("password");
        // 验证验证码是否正确
        Buyer buyer = userService.newuse(phone,password);
        if (buyer!=null) {
            return Result.success(buyer);
        }
        // 检查用户名是否已经存在
        else  {
            return Result.error("用户名已存在");
        }

    }

    @ApiOperation(value = "修改信息")
    @PostMapping("/modifyinfo")
    public void modifyinfo(@RequestBody Map<String, String> info){
        String bid = info.get("BID");
        String message = info.get("message");
        String phone = info.get("phone");
        userService.changemessage(bid,message);
        userService.changephone(bid,phone);
    }

    @ApiOperation(value = "修改密码")
    @PostMapping("/modifypwd")
    public void modifypwd(@RequestBody Map<String, String> info){
        String bid = info.get("BID");
        String pwd = info.get("pwd");
        userService.changepwd(bid,pwd);
    }

    @ApiOperation(value = "定位")
    @PostMapping("/position")
    public void position(

            @RequestBody Map<String,String> res){
        String bid=res.get("BID");
        String city=res.get("city");
        userService.changecity(bid, city);
    }

    @ApiOperation(value = "获取头像")
    @GetMapping("/getavatar")
    public ResponseEntity<byte[]> getavatar(String bid){
        Buyer buyer = userService.getavatar(bid);
        byte[] img = buyer.getIcon();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(img,headers,HttpStatus.OK);
    }


    @ApiOperation(value = "通过ID获取用户信息")
    @GetMapping("/getuserbyID")
    public Result getuserbyID(String bid){

        Buyer users = userService.getuserbyID(bid);
        return Result.success(users);
    }

    @ApiOperation(value = "添加收件人")
    @GetMapping("/newaddress")
    public Result newaddress(@RequestBody Map<String, String> res){
        String bid=res.get("bid");
        String address=res.get("address");
        String name=res.get("name");
        String phone=res.get("phone");
        userService.addressee(bid,address,name,phone);
        return Result.success();
    }

}
