import request from '@/utils/request';
import axios from 'axios';

// 按类获取商品
export const reqGoodsList = (code) => request({
    url: `http://111.229.3.64:8442/goodsInfo/getGoodsByCategory?category=${code}`,
    method: 'get'
});

// 通过id查找商品详情
export const reqDetial = (id) => request({
    url: `http://111.229.3.64:8442/goodsInfo/getGoodsByCode?code=${id}`,
    method: 'get'
});

// 添加商品
export const addGoods = (goods) => request({
    url: 'http://111.229.3.64:8442/goodsInfo/newGoods',
    // data: JSON.stringify(goods),
    data: goods,
    method: 'POST'
});

// 删除商品
export const delGoods = (code) => request({
    url: `http://111.229.3.64:8442/goodsInfo/deleteGoods?code=${code}`,
    method: 'DELETE'
});

// 获取商品图片
export const getGoodsImgList = (code) => request({
    url: `http://111.229.3.64:8442/goodsInfo/getGoodsImagesInformation?goods=${code}`,
    method: 'GET'
});
