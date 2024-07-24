<template>
	<view class="container">
		<view class="address-list">
			<view class="a-address" v-for="(item,index) in addressList" :key="index">
				<view class="left-text" :class="item.isDefault? 'active':''" @tap="selectTap(item.id)">
					<view class="address">
						{{item.address}} {{item.addressName}}
					</view>
					<view class="name">
						{{item.name}}{{item.mobile}}
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				addressList: [{
						id: 1,
						name: '张三',
						mobile: '1351234562',
						addressName: '南京东路南昌大学9栋',
						address: '江西省南昌市青山湖区',	
						isDefault:false
					},
					{
						id: 2,
						name: '李红',
						mobile: '18807054382',
						addressName: '梅西湖街道建顺源9栋2单元',
						address: '湖南省长沙市岳麓区',
						isDefault:true
					},
					{
						id: 3,
						name: '小刚',
						mobile: '1000100000',
						address: '广东省广州长隆动物园',
						addressName: '梅西湖街道建顺源9栋2单元',
						isDefault:false
					}
				]
			}
		},
		onLoad() {
			
		},
		methods: {
			selectTap(id) {			
				this.addressList.forEach(item=>{
					if(item.isDefault){
						item.isDefault=false;						
					}
				})
				this.addressList[id-1].isDefault=true;
			},
		}
	}
</script>

<style>
	.container {
		background-color: #F2f2f2;
	}

	.address-list {
		width: 100%;
		background-color: #fff;
		margin-top: 20rpx;
		padding-bottom: 100rpx;
	}

	.address-list .a-address {
		width: 720rpx;
		margin-left: 30rpx;
		display: flex;
		justify-content: space-between;
		align-items: center;
		padding: 30rpx 0;
		border-bottom: 1rpx solid #eee;
	}

	.a-address .left-text {
		width: 610rpx;
		box-sizing: border-box;
		padding-left: 58rpx;
	}

	.a-address .left-text.active {
		background: url("../../static/对勾.png") no-repeat left center;
		background-size: 50rpx auto;
	}

	.a-address .left-text .address {
		margin-bottom: 20rpx;
	}

	.a-address .left-text .name {
		font-size: 24rpx;
		color: #888888;
		line-height: 36rpx;
	}

	.a-address .right-edit {
		width: 109rpx;
		height: 100%;
		padding: 50rpx 0 50upx 58rpx;
		box-sizing: border-box;
		background-size: 35rpx auto;
	}
	
	.bottom-box {
		position: fixed;
		width: 100%;
		bottom: 0;
		font-size: 28rpx;
		color: #000000;
		border-top: 1rpx solid #eee;
		height: 100rpx;
		line-height: 100rpx;
		background-size: 15rpx auto;
	}

</style>