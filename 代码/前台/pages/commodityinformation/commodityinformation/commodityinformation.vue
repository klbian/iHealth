<template>
	<view class="Info">
		<view class="Info_b1">
			<image class="bim" src="/static/puer.jpeg"></image>
			<view class="btit">
				<text class="btitle">云南十大普洱茶</text>	
				<image class="in" src="/static/right.jpeg"></image>
			</view>
		</view>
		<view class="Info_b2">
			<image class="bim" src="/static/tianma.jpeg"></image>
			<view class="btit">
				<text class="btitle">十大天麻品牌</text>
				<image class="in" src="/static/right.jpeg"></image>
			</view>
		</view>
		<view class="order">
			<view class="stit">
				<text class="stitle">知名特产品牌</text>
			</view>
			<view class="order-list">
				<view v-for="(item, index) in list">
					<image class="order-img" :src="item.URL"></image>
					<view class="order-stitle">{{ item.name }}</view>
				</view>
			</view>
			<!-- <view class="order-list">
				<view class="order-item">
					<image class="order-img" src="/static/logo.png" mode=""></image>
					<view class="">东阿阿胶</view>
				</view>
				<view class="order-item">
					<image class="order-img" src="/static/logo.png" mode=""></image>
					<view class="">张飞</view>
				</view>
				<view class="order-item">
					<image class="order-img" src="/static/logo.png" mode=""></image>
					<view class="">郫县豆瓣</view>
				</view>
			</view>
			<view class="order-list">
				<view class="order-item">
					<image class="order-img" src="/static/logo.png" mode=""></image>
					<view class="">孝感牌</view>
				</view>
				<view class="order-item">
					<image class="order-img" src="/static/logo.png" mode=""></image>
					<view class="">西凤酒</view>
				</view>
				<view class="order-item">
					<image class="order-img" src="/static/logo.png" mode=""></image>
					<view class="">美丹</view>
				</view>
			</view>
			<view class="order-list">
				<view class="order-item">
					<image class="order-img" src="/static/logo.png" mode=""></image>
					<view class="">周村烧饼</view>
				</view>
				<view class="order-item">
					<image class="order-img" src="/static/logo.png" mode=""></image>
					<view class="">德州扒鸡</view>
				</view>
				<view class="order-item">
					<image class="order-img" src="/static/logo.png" mode=""></image>
					<view class="">峨眉雪芽</view>
				</view>
			</view>	 -->
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				list:[
					{	
						name: '东阿阿胶',
						URL: '/static/logo.png',
						
					},
					{	
						name:'张飞',
						URL:'/static/logo.png', 
					},
					{
						name:'郫县豆瓣',
						URL:'/static/logo.png', 
					},
					{
						name:'孝感牌',
						URL:'/static/logo.png', 
					},
					{
						name:'西凤酒',
						URL:'/static/logo.png', 
					},
					{
						name:'美丹',
						URL:'/static/logo.png', 
					},
					{
						name:'周村烧饼',
						URL:'/static/logo.png', 
					},
					{
						name:'德州扒鸡',
						URL:'/static/logo.png', 
					},
					{
						name:'峨眉雪芽',
						URL:'/static/logo.png', 
					},
				]
			};
		},
		created() {
			this.getlist()
		},
		onLoad() {
			this.getlist()
		},
		methods:{
			getlist(){
				this.list.forEach(item=>{
					if(item.content.length > 60){
						item.isMore = true
						item.contentAll = true
					}else{
						item.isMore = false
						item.contentAll = false
					}
				})
			},
			changeAllFun(item, index){
				let list = JSON.parse(JSON.stringify(this.list));	
				list.forEach((elem,ind)=>{
					if(index === ind){
						elem.contentAll = !elem.contentAll
					} 
				})
				this.list  =  list 
			}
		}
	};
</script>

<style>
	.Info {
		text-align: center;
		height: 400rpx;
		margin-top: 10rpx;
	}
	.in {
		right: 0rpx;
		width: 60rpx;
		height: 40rpx;
	},
	.bim {
		left: 0rpx;
		top: 125rpx;
		width: 600rpx;
		height: 400rpx;
		margin-top: 10rpx;
	},
	.btit {
		left: 0px;
		top: 125px;
		width: 750rpx;
		height: 60rpx;
		line-height: 20px;
		background-color: rgba(255, 255, 255, 1);
		text-align: left;
		border: 1px solid rgba(187, 187, 187, 1);
	},
	.btitle {
		left: 0px;
		/* top: 271px; */
		width: 99px;
		height: 20px;
		color: rgba(16, 16, 16, 1);
		font-size: 14px;
		font-family: PingFangSC-regular;
	},
	.order {
		text-align: center;
		border: 3px solid rgba(187, 187, 187, 1);
	},
	.stit {
		width: 750rpx;
		height: 50rpx;
		text-align: center;
		border: 3px solid rgba(187, 187, 187, 1);
	},
	.stitle {
		align-items: center;
		width: 250rpx;
		height: 20px;
		color: rgba(16, 16, 16, 1);
		font-size: 14px;
		font-family: PingFangSC-regular;
		border: 3px solid rgba(187, 187, 187, 1);
	},
	.order-list{
		width: 750rpx;
		display: flex;
	    flex-direction: row;
		flex-wrap: wrap;
		align-items: center;
	},
	.order-stitle {
		align-items: center;
		width: 234rpx;
		height: 20px;
		color: rgba(16, 16, 16, 1);
		font-size: 14px;
		font-family: PingFangSC-regular;
		border: 3px solid rgba(187, 187, 187, 1);
	},
	.order-item{
	    flex:1;
	    display: flex;
	    flex-direction: column;
	    justify-content: center;
	    align-items: center;
	},
	.order-img{
		margin-top: 10rpx;
	    width: 80rpx;
	    height: 80rpx;
	}
</style>