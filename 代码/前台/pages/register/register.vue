<template>
	<view class="sun-index">
		<view class="sun-logo-box">
			<view class="sun-logo">
				<image class="sun-icon-img" src="@/static/imgs/moom_white.png"/>
			</view>
		</view>
		<view class="sun-login-box">
			<view class="sun-label">
				<image style="width: 28rpx;height:39rpx;" src="@/static/imgs/mobile_icon.png"/>
				<text class="label-text"> 手机</text>
			</view>
			<view class="sun-input-box">
				<input v-model="mobile" type="text" placeholder="请输入手机号" placeholder-class="placeholder-class"/>
				<image @click="mobile=''" class="close-icon" src="@/static/imgs/close_icon.png"/>
			</view>
		</view>
		<view class="sun-login-box">
			<view class="sun-label">
				<image style="width: 29rpx;height:29rpx;" src="@/static/imgs/code_icon.png"/>
				<text class="label-text"> 验证码 </text>
			</view>
			<view class="sun-input-box">
				<input v-model="code" type="text" placeholder="请输入验证码" placeholder-class="placeholder-class"/>
				<text class="code-text" :class="{ gray: showTime }" @click="handleGetCodeClick">{{showTime?currentCountTime+'后重新获取':'获取验证码'}}</text>
			</view>
		</view>
		<view class="sun-login-box">
			<view class="sun-label">
				<image style="width: 29rpx;height:37rpx;" src="@/static/imgs/pwd_icon.png"/>
				<text class="label-text">密码 </text>
			</view>
			<view class="sun-input-box">
				<input v-model="password" type="text" placeholder="请输入密码" placeholder-class="placeholder-class"/>
				<image @click="password=''" class="close-icon" src="@/static/imgs/close_icon.png"/>
			</view>
		</view>
		<view class="login-btn-box">
			<view class="login-btn" @click="handleSubmit()"> 注册 </view>
		</view>
	</view>
</template>

<script setup>
	//import { t } from '@/locale/index.js'
	//import { reactive, onMounted } from 'vue'
	export default {
		data() {
			return {
				mobile:'',
				password:'',
				code:'',
				countTime: 60, 
				currentCountTime: 60,
				showTime:false,
				timeId:null
			}
		},
		methods: {

			
			handleSubmit() {
				if(!this.mobile) return uni.showToast({title: '请输入手机号',duration: 1500})
				if(!this.code) return uni.showToast({title: '请输入验证码',duration: 1500})
				if(!this.password) return uni.showToast({title: '请输入密码',duration: 1500})
				
				const that = this;
					uni.request({
					  url: 'http://223.4.21.161:8081/user/register', // 请求的URL
					  method: 'POST', // 请求方法，可选值包括：GET/POST/PUT/DELETE等
					  data: {
							u_account:that.mobile,
							u_pw:that.password,
							testCode:"123456",
							u_pwTest:that.password
						  }, // 请求参数，可根据接口文档自行添加
					  
					  success: (res) => { // 请求成功回调函数
					    console.log(res.data); // 输出返回的数据
						if(res.data=="注册成功") 
						{
							uni.showToast({title:'注册成功',duration: 1500})
							setTimeout(() => {
								uni.switchTab({
									url: '/pages/login/login'
									
								})
				
							}, 1000)	
						}
						else{
							uni.showToast({title:'注册失败',duration: 1500});
						}
					  },
					  fail: (err) => { // 请求失败回调函数
					    console.log(err);
						uni.showToast({title:'网络请求失败',duration: 1500});
					  }
					});	
				},
				
				
				
			},
			
			handleGetCodeClick() {
				this.showTime = true
				if(this.showTime && this.currentCountTime !== this.countTime) return
				this.currentCountTime
				this.timeId = setInterval(()=>{
					this.currentCountTime--
					if(this.currentCountTime <= 0) {
						this.currentCountTime = this.countTime
						this.showTime = false
						clearInterval(this.timeId)
					}
				},1000)
			}	
			
		
	}

	

</script>

<style scoped>
	.sun-logo-box {
		display: flex;
		justify-content: center;
		align-items: center;
		width: 750rpx;
		height: 300rpx;
	}
	.sun-icon-img {
		width: 120rpx;
		height: 120rpx;
	}
	.sun-logo {
		display: flex;
		justify-content: center;
		align-items: center;
		width: 180rpx;
		height: 180rpx;
		border-radius: 15rpx;
		background-color: #009245;
		box-shadow: 0rpx 0rpx 30rpx rgba(0, 146, 69, 0.5);
	}
	.close-icon {
		width: 36rpx;
		height: 34rpx;
	}
	.sun-login-box {
		padding: 20rpx 60rpx;
	}
	.sun-label {
		display: flex;
		align-items: center;
	}
	.label-text {
		margin-left: 16rpx;
		font-weight: 500;
		color: #272e2d;
		font-size: 30rpx;
	}
	.sun-input-box {
		display: flex;
		align-items: center;
		height: 100rpx;
		border-bottom: 1rpx solid #eee;
		padding: 0px 10rpx;
	}
	.sun-input-box input {
		flex: 1;
	}
	.placeholder-class {
		font-size: 30rpx;
		color: #C0C0C0;
	}
	.sun-tip {
		display: flex;
		justify-content: space-between;
		padding: 0rpx 68rpx;
	}
	.sun-tip-text {
		color: #009245;
	}
	.login-btn-box {
		position: absolute;
		bottom: 129rpx;
		left: 0;
		width: 750rpx;
		padding: 50rpx 68rpx 0rpx;
	}
	.login-btn {
		height: 82rpx;
		border-radius: 41rpx;
		background-color: #009245;
		box-shadow: -1px 12px 11px 0px rgba(16, 170, 157, 0.4);
		text-align: center;
		line-height: 82rpx;
		font-size: 36rpx;
		font-weight: 500;
		color: #fff;
	}
	.code-text {
		font-size: 28rpx;
		color: #009245;
	}
	.gray {
		color: #C0C0C0;
	}
</style>
