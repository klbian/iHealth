import request from '@/utils/request';

export const reqVarietyList = () => request({
    url: 'http://111.229.3.64:8442/categoryInfo/getCategorys',
    method: 'get'
});

export const delVariety = (code) => request({
    url: 'http://111.229.3.64:8442/categoryInfo/deleteCategory?code=' + code,
    method: 'delete'
});

export const addVariety = (code, name, sortby) => request({
    url: `http://111.229.3.64:8442/categoryInfo/newCategory?code=${code}&name=${name}&sortby=${sortby}`,
    method: 'POST'
});

export const editVariety = (code, name, sortby) => request({
    url: `http://111.229.3.64:8442/categoryInfo/eidtCategory?code=${code}&name=${name}&sortby=${sortby}`,
    method: 'PUT'
});
