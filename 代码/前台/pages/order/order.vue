<template>
	<view>
		<navigator url="../address/address" class="address-section">
			<view class="order-content">
				<view class="yticon icon-shouhuodizhi"><image src="../../static/地址管理.png"></image></view>
				<view class="cen">
					<view class="top">
						<text class="address">{{addressData.address}} {{addressData.addressName}}</text>
					</view>
					<text class="name">{{addressData.name}}  {{addressData.mobile}}</text>
				</view>
				<view class="yticon icon-you"><image src="../../static/箭头右.png"></image></view>
			</view>
		</navigator>

		<view class="goods-detail" v-for="(item,index) in goods" :key="index">
			<view class="detail-left">
				<view class="goods-left">
					  <image :src="image_url+item.did" class="img"></image>  <!--src="image_url+item.code"-->
				</view>
				<view class="size">
				    <text class="name">{{item.name}}</text>
					<text class="msg">{{item.message}}</text>
				    <text class="goods-price">￥{{item.price}}</text>
				</view>
			</view>
			<view class="detail-right">
				<text class="num">×{{item.num}}</text>				
			</view>
		</view>
		
		
		<view class="yt-list">
			<view class="yt-list-cell b-b">
				<text class="cell-tit clamp">配送服务</text>
				<text class="cell-tip">快递免邮</text>
			</view>
			<view class="yt-list-cell desc-cell" >
				<text class="cell-tit clamp">订单备注</text>
				<input class="desc" type="text" placeholder="无备注" placeholder-class="placeholder" />
			</view>
		<view class="kongbai">
					
		</view>
			
		</view>
		
		<view class="footer">
			<view class="price-content">
				<text>合计:</text>
				<text class="price-tip">￥{{totalprice}}</text>
				<text class="price"></text>
			</view>
			<text class="submit" @click="submit">提交订单</text>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {	
				goods:[
					
					
					
				],
				image_url:'',
				addressData: {
					name: '李红',
					mobile: '18807054382',
					addressName: '梅西湖街道建顺源9栋2单元',
					address: '湖南省长沙市岳麓区',
					default: false,
				},
			}
		},
		onLoad(options) {
			let a=options.n;
			this.goods = JSON.parse(a);
			//this.image_url='http://111.229.3.64:8184/goods/queryGoodsLogo?code='
			this.image_url='http://223.4.21.161:8081/drug/getimg?imgid='
		},
		methods: {
			submit(){
				uni.redirectTo({
					url: ''
				})
			},
		},
		computed:{
			totalprice(){
				let totalprice=0;
				this.goods.map(item => {
				    totalprice+=item.price*item.num
				})
				return totalprice
			}
		},
	}
</script>

<style lang="scss">
	page {
		background-color: #f5f5f5;
		padding-bottom: 100upx;
	}
	.address-section {
		padding: 30upx 0;
		background: #fff;
		position: relative;
		margin-bottom: 20rpx;

		.order-content {
			display: flex;
			align-items: center;
		}

		.icon-shouhuodizhi {
			flex-shrink: 0;
			display: flex;
			align-items: center;
			justify-content: center;
			width: 60rpx;
			image{
				mode:aspectFit;
				height: 60rpx;
				width: 60rpx;
			}
		}

		.cen {
			display: flex;
			flex-direction: column;
			flex: 1;
			font-size: 28upx;
		}

		.name {
			font-size: 34upx;
			margin-right: 24upx;
		}

		.address {
			margin-top: 16upx;
			margin-right: 20upx;
		}

		.icon-you {
			width: 30rpx;
			flex-shrink: 0;
			display: flex;
			align-items: center;
			justify-content: center;
			padding-right: 20rpx;
			image{
				mode:aspectFit;
				height: 30rpx;
				width: 30rpx;
			}
		}

		.a-bg {
			position: absolute;
			left: 0;
			bottom: 0;
			display: block;
			width: 100%;
			height: 5upx;
		}
	}
	
	.yt-list {
		margin-top: 16upx;
		background: #fff;
	}

	.yt-list-cell {
		display: flex;
		align-items: center;
		padding: 10upx 30upx 10upx 40upx;
		line-height: 70upx;
		position: relative;
		&.cell-hover {
			background: #fafafa;
		}
		&.b-b:after {
			left: 30upx;
		}
		.cell-tit {
			flex: 1;
			font-size: 26upx;
			margin-right: 10upx;
		}
		.cell-tip {
			font-size: 26upx;
		}		
		.desc {
			flex: 1;
		}
	}

	.footer{
		position: fixed;
		left: 0;
		bottom: 0;
		z-index: 995;
		display: flex;
		align-items: center;
		width: 750rpx;
		height: 150rpx;
		justify-content: space-between;
		font-size: 30upx;
		background-color: #fff;
		z-index: 998;
		box-shadow: 0 -1px 5px rgba(0,0,0,.1);
		.price-content{
			padding-left: 30upx;
		}
		.price-tip{
			margin-left: 8rpx;
			color:#F44545;
			font-weight: bold;
		}
		.price{
			font-size: 36upx;
		}
		.submit{
			margin-right: 15rpx;
			text-align: center;
			line-height: 90rpx;
			color: #fff;
			font-size: 30rpx;
			font-weight: bold;
			background-color: #516f25;
			border-radius: 50rpx;
			width: 250rpx;
		}
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
		    .detail-right{
		        text{
		            width: 150rpx;
		            line-height: 50rpx;
		            text-align: center;
		            display: inline-block;
		            margin-right: 10rpx;
		        }
				.num{
					font-size: 40rpx;
					font-weight: bold;
					color: #516f25;
				}   
		    }
		}
		}
		
		.kongbai{
			height: 200rpx;
			background-color: #f5f5f5;
		}

</style>
