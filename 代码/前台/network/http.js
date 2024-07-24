import {
	baseURL,
	
} from './base.js'; //导入接口的前缀地址
  export function classification() {  //分类
  	return myRequest({
  		url:'queryCategories',
  		// url:'queryGoodsByCategory?category=%E6%89%8B%E6%9C%BA',queryPromoteGoods
  	}
  	)
  }
  export function classcontent(code) {  //内容
  	return myRequest({
  		url:'queryGoodsByCategory?category='+code,
		data:code
  		// url:'queryGoodsByCategory?category=%E6%89%8B%E6%9C%BA',queryPromoteGoods
  	}
  	)
  }
 export function recommend() {  //推荐
 	return myRequest({
		url:'queryPromoteGoods',
 		// url:'queryGoodsByCategory?category=%E6%89%8B%E6%9C%BA',queryPromoteGoods
 	}
	)
 }
 export function pic(code) {  //图片
 	return myRequest({
		
		 responseType: 'arraybuffer',
		 encoding: 'base64',
 		url:'queryGoodsLogo?code='+code,
		data:code
 	}
 	)
 }
 
export const myRequest = (options) => {
	return new Promise((resolve, reject) => {
		uni.request({
			url: baseURL + options.url, //接口地址：前缀+方法中传入的地址
			method: options.method || 'GET', //请求方法：传入的方法或者默认是“GET”
			data: options.data || {}, //传递参数：传入的参数或者默认传递空集合
			// headers: {
			//     'Authorization ': window.localStorage.getItem('token') //自定义请求头信息
			// },
			success: (res) => {
				resolve(res)
			},
			// 这里的接口请求，如果出现问题就输出接口请求失败
			fail: (err) => {
				console.log(err)
				reject(err)
			}
		})
	})
}