<template>
	<view class='commodity-list'>
		
		<!-- 商品列表组件 -->
		<Commodity :dataList='commodityList'></Commodity>
		
	</view>
</template>

<script>
import Commodity from './Commodity.vue'
export default {
	data () {
		return {
			commodityList:[
				{
					id:1,
					imgUrl:"../../static/img/commodity1.jpg",
					name:"大姨绒毛大款2020年必须买,不买你就不行了,爆款疯狂GG008大姨绒毛大款2020年必须买,不买你就不行了,爆款疯狂GG008",
					pprice:"299",
					oprice:"659",
					discount:"5.2"
				},
				{
					id:2,
					imgUrl:"../../static/img/commodity2.jpg",
					name:"大姨绒毛大款2020年必须买,不买你就不行了,爆款疯狂GG008大姨绒毛大款2020年必须买,不买你就不行了,爆款疯狂GG008",
					pprice:"299",
					oprice:"659",
					discount:"5.2"
				},
				{
					id:3,
					imgUrl:"../../static/img/commodity3.jpg",
					name:"大姨绒毛大款2020年必须买,不买你就不行了,爆款疯狂GG008大姨绒毛大款2020年必须买,不买你就不行了,爆款疯狂GG008",
					pprice:"299",
					oprice:"659",
					discount:"5.2"
				},
				{
					id:4,
					imgUrl:"../../static/img/commodity4.jpg",
					name:"大姨绒毛大款2020年必须买,不买你就不行了,爆款疯狂GG008大姨绒毛大款2020年必须买,不买你就不行了,爆款疯狂GG008",
					pprice:"299",
					oprice:"659",
					discount:"5.2"
				}
			]
		}
	},
	components:{
		Commodity
	}
}
</script>

<style>
</style>
1.5 Commodity.vue代码为：
<template>
	<view class='commodity'>
		<!-- 单个商品组件 -->
		
		<view class='commodity-item' 
			v-for="(item,index) in dataList"
			:key='index'
		>
			<image class='commodity-img' :src="item.imgUrl" mode=""></image>
			<view class='commodity-content'>
				<text class='commodity-name'>{{item.name}}</text>
				<view>
					<text class='pprice'>¥{{item.pprice}}</text>
					<text class='oprice'>¥{{item.oprice}}</text>
				</view>
				<text class='discount'>{{item.discount}}折</text>
			</view>
		</view>
	
	</view>
</template>

<script>
export default {
	props:{
		dataList:Array
	}
}
</script>

<style scoped>
.commodity{
	display: flex;
	flex-wrap: wrap;
}
.commodity-item{
	width: 375rpx;
	padding-bottom:20rpx;
}
.commodity-img{
	width:100%;
	height: 375rpx;
}
.commodity-content{
	text-align: center;
}
.commodity-name{
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp:2;
	-webkit-box-orient:vertical;
	color:#333333;
	word-break: break-all;
	padding:6rpx 20rpx;
}
.oprice{
	text-decoration: line-through;
	font-size:24rpx;
	color:#999999;
}
.discount{
	border-radius: 4rpx;
	border:1px solid #FF3333;
	padding:2rpx 10rpx;
	font-size:20rpx;
	color:#FF3333;
}
</style>
