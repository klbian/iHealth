package com.example.demo.mapper;

import cn.hutool.db.sql.Order;
import com.example.demo.entity.Drug;
import com.example.demo.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface OrdersMapper {
    public List<Orders> getorder();
    public List<Drug>  getorderDrug();

    public void addDrugToOrders();
    public void cancelOrder();

    public void newOrder();
    public void payOrder();

}
