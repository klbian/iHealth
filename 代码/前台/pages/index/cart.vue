<template>
	<view>
		<!-- <view class="empty" v-if="show==false">
			<view class="empty-text">空空如也</view>
			<view class="empty-button" @click="goshopping">去选购</view>
		</view> -->
		<view v-if="show==true">
			<view class="goods-detail" v-for="(item,index) in goods" :key="index">
				<view class="detail-left">
					<view class="goods-left">
						<checkbox-group @click="selected(item) " >
							<label>
								<view v-if="item.flag" ><image src="../../static/选择按钮 (已选择).png" class="xuanze"></image></view>
								<view v-else ><image src="../../static/选择按钮(未选).png" class="xuanze"></image></view>
							</label>
						</checkbox-group>
						  <image  :src="image_url+item.did" class="img"></image>       <!--src="image_url+item.code"-->
					</view>
					<view class="size">
					    <text class="name">{{item.dname}}</text>
						<text class="msg">{{item.dmessage}}</text>
					    <text class="goods-price">￥{{item.price}}</text>
					</view>
				</view>
				<view class="right">
					<view class="detail-right">
						<text class="subtract" @click="reduce(item,index)">-</text>
						<text class="num">{{item.num}}</text>
						<text @click="add(item)" class="add">+</text>
					</view>
					
					<view class="delete"  @click="shanchu(index)" >
						<image src="../../static/删除.png"  class="shanchu" mode="scaleToFill"></image>
						
					</view>
				</view>
			</view>
		</view>
		<view class="end">
			<view class="end-left">
				<checkbox-group @click="selectgoods()">
					<label>
						<view v-if="allchecked" ><image src="../../static/选择按钮 (已选择).png" class="quanxuan"></image></view>
						<view v-else ><image src="../../static/选择按钮(未选).png" class="quanxuan"></image></view>
					</label>
				</checkbox-group>
				<view>
					合计：<text>￥ {{totalPrice}}</text>
				</view>
				</view>
				<view class="end-right">		    
					<button  @click="createOrder()">去结算({{totalNum}})</button>
				</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				show:true,
				allchecked:true,
				checked:true,
				goods:[
					
				],
				image_url:'',
			}
		},
		onLoad(){
				
			if(getApp().globalData.uid==''){
				uni.redirectTo({
					url: '../login/login'
				})
			}else{
				this.image_url='http://223.4.21.161:8081/drug/getimg?imgid='
				this.getmycart();	
	
			}
			
		},
		onShow() {
			//this.getmycart();	
		},
		methods: {
			getmycart: async function(){
				await this.getcart();
				this.getdrug();
				},
				
				getcart() {
					const that =this;
					return new Promise((resolve,reject) =>{
						
						console.log("getcart开始");
						uni.request({
						  url: 'http://223.4.21.161:8081/cart/getcart', // 请求的URL
						  method: 'GET', // 请求方法，可选值包括：GET/POST/PUT/DELETE等
						  data: {
								uid:getApp().globalData.uid
							  }, // 请求参数，可根据接口文档自行添加 
						  
						  success: (res) => { // 请求成功回调函数  
							console.log(res.data); // 输出返回的数据
							console.log(that.goods);
							if(res.data.code==200) 
							{
								console.log(that.goods);
								that.goods=res.data.data;
								console.log("getcart完成");
							}
							else{
								uni.showToast({title:res.data.message,duration: 1500});
							}
							resolve('suc');
						  },
						  fail: (err) => { // 请求失败回调函数
						    console.log(err);
							uni.showToast({title:'网络请求失败',duration: 1500});
							reject('err')
						  }
						});	
						
					})
			
								
					},
			
			
				getdrug(){
					console.log("getdrug开始");
					let list = this.goods;
					const that = this;
					console.log(list);
					list.forEach((item,index)=>{
						
						uni.request({
							url:'http://223.4.21.161:8081/drug/getDrugByID',
							method:'GET',
							data:{
								DID:item.did
							},
							success:(res) => {
								
								if(res.data.code==200){
									that.$set(this.goods[index],'dname',res.data.data[0].dname);
									that.$set(this.goods[index],'dmessage',res.data.data[0].dmessage);
									that.$set(this.goods[index],'flag',false);
									console.log("getdrug完成");
								}
								else{
									uni.showToast({title:res.data.message,duration: 1500});
									console.log("getdrug未完成");
								}
							},
							fail:(err) => {
								console.log(err);
								uni.showToast({title:'网络请求失败',duration: 1500});
							}
						})
						})
					
				},
				
				
				selected(item){
					item.flag=!item.flag;	
					let a = true;
					this.goods.forEach((x)=>{
						if(x.flag===false) a=false;
					})
					if(a){
						this.allchecked=true
					}else{
						this.allchecked=false
					}
				},
				selectgoods(){
					console.log(this.goods);
					this.allchecked=!this.allchecked
					if(this.allchecked){
						this.goods.map(item=>{
							this.checked=true						
							item.flag=true
						})
					}else{
						this.goods.map(item=>{
							this.checked=false
							item.flag=false
						})
					}
			
				},
				reduce(item,index){
					let num=item.num
					if(num>1){
						num-=1
					}
					item.num=num
				},
				shanchu(index){
					this.goods.splice(index,1)
				},
				add(item){
					let num =item.num
					item.num=num+1
				},
				// createOrder(){
				// 	uni.navigateTo({
				// 		url: '/pages/order/order'
				// 	});
				// },
				createOrder(){
					let list = this.goods;
					let goodsData = [];
					list.forEach(item=>{
						if(item.flag){
							goodsData.push({
								name:item.dname,
								num:item.num,
								price:item.price,
								message:item.dmessage,
								did:item.did
								//code:item.code,
							})
						}
					})
					
					uni.navigateTo({
						url: '../order/order?n='+JSON.stringify(goodsData)
					})
				}
			},
			computed:{
				totalNum(){
					let totalNum = 0;
					this.goods.map(item => {
					    item.flag ? totalNum += item.num : totalNum += 0
					})
					return totalNum
				},
				
				totalPrice() {
				    let totalPrice = 0;
				    this.goods.map(item => {
				        item.flag ? totalPrice += item.num * item.price : totalPrice += 0
				    })
				    return totalPrice
				},
		}
	}
</script>

<style lang="scss">
page{
		background-color: #f5f5f5;
	}
	.goods{
		line-height: 80rpx;
		background-color: #fff;
		&-detail{
			
		    display: flex;
		    padding: 30rpx 15rpx 30rpx 30rpx;
		    background-color: #fff;
		    justify-content: space-between;
		    border-bottom: 5rpx solid #F1F1F1;
		    align-items: center;
		    .detail-left{
		        display: flex;
		        .goods-left{
		            display: flex;
		            align-items: center;
					.selected{
						color: #F1F1F1;
					}
					.img{
						width: 140rpx;
						height: 140rpx;
					}
					.xuanze{
						width: 40rpx;
						height: 40rpx;
						margin-right: 30rpx;
					}
		        }
		    }
		    .size{
		        display: flex;
		        justify-content: space-around;
		        flex-direction: column;
		        margin-left: 30rpx;
				
		        .goods-price{
		            font-size: 30rpx;
		            color: #F44545;
		            font-weight: bold;
		        }
				.name{
					font-size: 30rpx; 
					font-weight: bold;
					overflow: hidden;
					word-break: break-all;
					text-overflow: ellipsis; 
					display: -webkit-box;
					-webkit-box-orient: vertical;
					-webkit-line-clamp: 1;
				}
				.msg{
					font-size: 25rpx; 
					color:darkgrey;
					overflow: hidden;
					word-break: break-all;
					text-overflow: ellipsis; 
					display: -webkit-box;
					-webkit-box-orient: vertical;
					-webkit-line-clamp: 1;		
				}
		    } 
		}
		
	}
	
	
	.right{
		align-items: center;
		width: 150rpx;
		flex-direction: column;
	}
	.detail-right{
		padding-left: 40rpx;
		display: flex;
		width: 150rpx;
		align-items: center;
		 text{
		    line-height: 50rpx;
		    text-align: center;
		    display: inline-block;
		    background-color: #F7F7F7;
		    margin-right: 10rpx;
		}
		.num{
			font-size: 30rpx;
			font-weight: bold;
			border-radius: 20rpx;
		}
		.add {
		    color: #000000;		           
		     margin-right: 20rpx;
			background-color: #fff;
		}
		.subtract{
			color: #000000;
			background-color: #fff;
		}
		
		
		}
		.delete{
			margin-top: 20rpx;
			width: 50rpx;
			align-items: center;
			.shanchu{
				padding-left: 55rpx;
			width: 40rpx;
			height: 40rpx;
		}	
		
		
	}
	// .empty{
	// 	    position: relative;
	// 	    top: 220rpx;
	// 	    text-align: center;
	// 	    display: flex;
	// 	    align-items: center;
	// 	    flex-direction: column;
	// 	    &-text{
	// 	        color: #808080;
	// 	        margin-bottom: 50rpx;
	// 	    }
	// 	    &-button{
	// 	        width: 300rpx;
	// 	        height: 90rpx;
	// 	        color:orange;
	// 	        border: 1rpx solid orange;
	// 	        text-align: center;
	// 	        line-height: 90rpx;
	// 	        border-radius: 48rpx;
	// 	    }		
	// }
	.end{
	    height: 150rpx;
	    background-color:#fff;
	    position: fixed;
	    bottom: 0rpx;
	    left: 0;
	    display: flex;
	    align-items: center;
		width: 750rpx;
		padding-bottom: calc(var(--window-bottom) );
	    &-left{
	        display: flex;
	        justify-content: space-between;
	        padding: 0 30rpx;
			width: 440rpx;
	        .end-flex{
	            display: flex;
	            align-items: center;
	        }
			text{
				color: #f00;
				font-weight: bold;
			}
			.quanxuan{
				
				width: 40rpx;
				height: 40rpx;
				margin-right: 30rpx;
				
			}
	    }
	    &-right{
			button{
				
				margin-right: 15rpx;
				line-height: 90rpx;
				background-color: #516f25;
				text-align: center;
				font-size: 30rpx;
				font-weight: bold;
				color: #fff;
				border-radius: 50rpx;
				width: 250rpx;
			}
			
		}
	}
</style>
