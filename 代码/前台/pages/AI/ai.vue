<template>
	<view>
		<u-notice-bar bgColor='#7966ff' color="#fff" text="通知*********" mode="closable">
		</u-notice-bar>
		<view class="box-1" id="list-box">
			<view class="talk-list">
				<view v-for="(item,index) in talkList" @click="handleCopy(item.content)" :key="index"
					:id="`msg-${index}`">
					<view class="item flex_col" :class=" item.type == 1 ? 'push':'pull' ">
						<image v-if="item.type == 1" :src="vuex_user?vuex_user.avatar:'/static/avatar.png'" mode="aspectFill" class="pic"></image>
						<image v-else src="/static/logo.png" mode="aspectFill" class="pic"></image>
						<view v-if="item.content" class="content">{{item.content}}</view>
						<view v-else class="content"><u-loading-icon></u-loading-icon></view>
					</view>
				</view>
			</view>
		</view>
		<view class="box-2">
			<view class="flex_col">
				<view @click="handleopen">
					<image class="avatar" :src="vuex_user?vuex_user.avatar:'/static/avatar.png'"></image>
				</view>
				<view class="flex_grow">
					<input type="text" class="content" v-model="content" placeholder="请输入聊天内容"
						placeholder-style="color:#DDD;" :cursor-spacing="6" @confirm="send">
				</view>
				<button class="send" @tap="send">发送</button>
			</view>
		</view>

	</view>
</template>

<script>
	// 在页面中定义激励视频广告
	let videoAd = null
	// import models from '@/components/model/model.vue'
	// import wxLogin from '@/components/wxLogin/wxLogin.vue'
	export default {
		// components:{
		// 	models,
		// 	wxLogin
		// },
		data() {
			return {
				picshow: false,
				isvalue: '标准线路',
				
				channel: '',
				// 签到
				isSign: false,
				signShow: false,
				signTitle: '',
				signIntegral: 0,
				inviteIntegral: 0,
				adIntegral: 0,
				chatIntegral: 0,
				// 登录弹窗
				loginShow: false,
				talkList: [],
				content: '',
				downShow: false,
				downTitle: '',
				show: false,
			}
		},
		async onLoad() {
			const that = this
			uni.setNavigationBarTitle({
				title: 'AI问诊',
			})
			// that.getConfig()
		},
		
		// onShareAppMessage(res) {
		// 	return {
		// 		title: '我等风也等你，近听水无声~',
		// 		imageUrl: '/static/wenda.png',
		// 		path: '/pages/index/index?userId='+this.vuex_user._id
		// 	}
		// },
		// onShareTimeline(res) {
		// 	return {
		// 		title: '我等风也等你，近听水无声~',
		// 		imageUrl: '/static/wenda.png',
		// 		path: '/pages/index/index?userId='+this.vuex_user._id
		// 	}
		// },
		mounted() {
			this.$nextTick(() => {
				this.getHistoryMsg();
			});
		},
		methods: {
			// async getConfig(){
			// 	let that = this
			// 	let config = await uniCloud.callFunction({
			// 		name: 'config_map',
			// 		data: {
			// 			appcode: that.appcode,
			// 			'keys': ['signIntegral', 'inviteIntegral', 'adIntegral','chatIntegral']
			// 		},
			// 	})
			// 	if(config.result.success) {
			// 		that.signIntegral = parseInt(config.result.data[0])
			// 		that.inviteIntegral = parseInt(config.result.data[1])
			// 		that.adIntegral = parseInt(config.result.data[2])
			// 		that.chatIntegral = parseInt(config.result.data[3])
			// 	}
			// },
			
			
			modelSave(){
				if(!this.vuex_user){
					this.loginShow = true
					return
				}
				this.modelShow = false
			},
			async getUser(){
				let that = this
				let detail = await uniCloud.callFunction({
					name: 'query_map',
					data: {
						dbName: "wx_user",
						id: that.vuex_user._id
					},
				})
				that.$u.vuex('vuex_user', detail.result)
			},
			// 我的
			async getSign(){
				let that = this
				const startTime = new Date(new Date().toLocaleDateString()).getTime()
				const endTime = new Date(new Date().toLocaleDateString()).getTime() + 24 * 60 * 60 * 1000 - 1
				let query = await uniCloud.callFunction({
					name: 'sign_flag',
					data: {
						dbName: 'wx_sign',
						"userId": that.vuex_user._id,
						"startTime": startTime,
						"endTime": endTime
					},
				})
				if(query.result.success) that.isSign = true
				else that.isSign = false
			},
			
			
			async userIntegral(){
				var that = this
				uni.showLoading({
					mask: true,
					title: '加载中...'
				})
				let data = await uniCloud.callFunction({
					name: 'user_integral',
					data: {
						appcode: that.appcode,
						userId: that.vuex_user._id
					},
				})
				uni.hideLoading()
				if(data.result.success){
					that.getUser()
					that.signTitle = "<p style='font-weight: 550;font-size: 16px;'>恭喜你！</p><p style='padding-top: 10px;'>获得<span class='num'>"+data.result.integral+"</span>积分</p>"
					that.signShow = true
				}
			},
			
			
			// 登录
			async getUserInfo(){
				uni.showLoading({
					title: '授权中...'
				});
				var that = this
				await uni.getUserInfo({
				  desc: '更新您的个人信息',
				  success: (res) => {
					  that.name = res.userInfo.nickName; //昵称
					  that.avatar = res.userInfo.avatarUrl; //头像
					  // 成功后进行登录,获取code
					  that.wxlogin();
				  },
				  fail(err){
					  uni.showToast({
					  	icon: 'none',
					  	title: '授权失败',
					  	duration: 1500
					  })
				  }
				})
				uni.hideLoading()
			},
			
			//已经授权，自动登录
			async wxlogin() {
				let that = this;
				uni.showLoading({
					title: '登录中...'
				});
				uni.login({
					provider: 'weixin',
					success: function(loginRes) {
						let code = loginRes.code;
						that.wxloginres(code);
					},
					fail(err){
						uni.hideLoading()
						uni.showToast({
							icon: 'none',
							title: '登录失败',
							duration: 1500
						})
					}
				});
				
			},
			//登录后提交服务器获取进一步信息
			async wxloginres(wxcode) {
				let that = this;
				
				var userId = uni.getStorageSync('userId')
				
				var mptype
				// #ifdef MP-WEIXIN
					mptype = 'wx'
				// #endif
				// #ifdef MP-QQ
					mptype = 'qq'
				// #endif
				
				let authorize = await uniCloud.callFunction({
					name: 'user_authorize',
					data: {
						appcode:that.appcode,
						name: that.name,
						avatar: that.avatar,
						mptype: mptype,
						code: wxcode,
						userId: userId,
					},
				})
				if(authorize.result.success){
					that.$u.vuex('vuex_user',authorize.result.data)
					that.getUser()
					await that.getSign()
					uni.showToast({
						icon: 'none',
						mask: true,
						title: '登录成功',
						duration: 1500
					})
					// #ifdef MP-WEIXIN
					if(!authorize.result.newUser){
						that.loginShow = false
						that.$u.vuex('showWxLogin',true)
					}
					// #endif
					// #ifndef MP-WEIXIN
					// #endif
					uni.removeStorageSync('userId')
				}else{
					uni.showToast({
						icon: 'none',
						mask: true,
						title: authorize.result.msg,
						duration: 1500
					})
				}
				uni.hideLoading()
				that.loginShow = false
			},
			getLoginShow(){
				let that = this
				that.loginShow = true
			},
			
			handlepicopen() {
				this.picshow = true
				this.show = false
			},
			handlepiccancel() {
				this.picshow = false
			},
			handlepicconfirm(data) {
				this.channel = data.value[0].channel
				this.picshow = false
				this.isvalue = data.value[0].label
				uni.setNavigationBarTitle({
					title: `智撩AI机器人-${this.isvalue}`,
				})
			},
			close() {
				this.show = false
			},
			handleopen() {
				this.show = true
			},
			handleCopy(message) {
				const that = this
				uni.setClipboardData({
					data: message,
					success: function() {}
				})
			},
			// 获取历史消息
			getHistoryMsg() {
				let get = async () => {
					let data = [{
						content: `智能AI为您服务：\n1. 知乎百度答题、做作业题目\n2. 写代码、写文案、写论文，写小说\n3. 文案润色、翻译、写诗作词\n4. 扮演面试官、扮演书籍电影角色\n例1：写一篇工作日报我是行政\n例2：帮我写作业，题目是xxx\n例3：把下文翻译成英文：xxx\n例4：写一出能活的短视频剧本\n例5：英文写物理相关的论文\n例6：用王小波的风格写篇情书\n
或者可以问我其他问题\n越完整的描述，我越精确`, // 消息内容
						type: 0,// 此为消息类别，设 1 为发出去的消息，0 为收到对方的消息,
						state: 0
					}];
					// 将获取到的消息数据合并到消息数组中
					this.talkList = [...data, ...this.talkList];
					// 数据挂载后执行，不懂的请自行阅读 Vue.js 文档对 Vue.nextTick 函数说明。
					// 设置当前滚动的位置
					this.setPageScrollTo();
				}
				get();
			},
			// 设置页面滚动位置
			setPageScrollTo() {
				this.$nextTick(() => {
					const selector = `#msg-${this.talkList.length-1}`;
					let view = uni.createSelectorQuery().in(this).select(selector);
					view.boundingClientRect((res) => {
						uni.pageScrollTo({
							scrollTop: res.top - 30, // -30 为多显示出大半个消息的高度，示意上面还有信息。
							duration: 0
						});
					}).exec();
				})
			},
			// 发送信息
			async send() {
				const that = this
				// if(!that.vuex_user){
				// 	that.loginShow = true
				// 	return
				// }
				if (!that.content) {
					uni.showToast({
						title: '请输入有效的内容',
						icon: 'none'
					})
					return;
				}
				
				// if(this.chatIntegral > 0){
				// 	var integral = this.vuex_user.integral
				// 	if(integral < this.chatIntegral){
				// 		this.show = true
				// 		this.downShow = true
				// 		this.downTitle = "<p style='font-weight: 550;font-size: 16px;'>提问需要 "+this.chatIntegral+" 积分</p><p style='padding-top: 10px;'>您当前仅有<span class='num'>"+integral+"</span>积分，无法发起提问，快去赚积分吧~</p>"
				// 		return
				// 	}
				// }
				that.talkList.push({
					content: that.content, // 消息内容
					type: 1 ,// 此为消息类别，设 1 为发出去的消息，0 为收到对方的消息,
					state: 1,
				})
				
				console.log(this.talkList)

				// let messages = that.talkList.filter(item=>{
				// 	return item.state==1
				// })
				// messages = messages.map(item=>{
				// 	return {
				// 		content: item.content,
				// 		role: item.type==1?'user':'assistant'
				// 	}
				// })
				
				
				uni.request({
				  url: 'http://223.4.21.161:8081/wxchat', // 请求的URL
				
				  method: 'POST', // 请求方法，可选值包括：GET/POST/PUT/DELETE等
				  data: {
						bid:'8008121291',
						que:that.content
					
					  }, // 请求参数，可根据接口文档自行添加
				  
				  success: (res) => { // 请求成功回调函数
				    console.log(res.data); // 输出返回的数据
					if(res.data.code==200) 
					{
						that.talkList.push({
							content: res.data.data, // 消息内容
							type: 2 ,// 此为消息类别，设 1 为发出去的消息，0 为收到对方的消息,
							state: 0,
						})
						this.$forceUpdate()
						this.setPageScrollTo();
						
					}
					else{
						that.talkList.push({
							content: "获取失败", // 消息内容
							type: 2 ,// 此为消息类别，设 1 为发出去的消息，0 为收到对方的消息,
							state: 0,
						})
						
					}
				  },
				  fail: (err) => { // 请求失败回调函数
				    console.log(err);
					uni.showToast({title:'网络请求失败',duration: 1500});
				  }
				});	
				this.$forceUpdate()
				this.setPageScrollTo();
				that.content = ''
				// let res = await uniCloud.callFunction({
				// 	name: 'openai',
				// 	data: {
				// 		messages:messages,
				// 		channel:that.channel,
				// 		appcode:that.appcode,
				// 		userId: that.vuex_user._id
				// 	},
				// })
				// if(res.result.success){
				// 	that.getUser()
				// 	that.talkList[that.talkList.length-1] = {
				// 		content: res.result.content, // 消息内容
				// 		type: 0 ,// 此为消息类别，设 1 为发出去的消息，0 为收到对方的消息,
				// 		state: 1,
				// 	}
				// 	this.$forceUpdate()
				// 	// 设置当前滚动的位置
				// 	this.setPageScrollTo();
				// }else{
				// 	uni.showToast({
				// 		title: res.result.msg,
				// 		icon: 'none'
				// 	})
				// 	that.talkList[that.talkList.length-2].state = 0
				// 	that.talkList[that.talkList.length-1] = {
				// 		content: res.result.msg, // 消息内容
				// 		type: 0 ,// 此为消息类别，设 1 为发出去的消息，0 为收到对方的消息,
				// 		state: 0,
				// 	}
				// }
			}
		}
	}
</script>

<style lang="scss">
	
	page {
		background-color: #f3f3f3;
		font-size: 28rpx;
		box-sizing: border-box;
		color: #333;
		letter-spacing: 0;
		word-wrap: break-word;
	}
	
	/* 按钮样式处理 */
	button {
		font-size: 28rpx;
	}
	
	/* 取消按钮默认的边框线效果 */
	button:after {
		border: none;
	}
	
	/* 设置图片默认样式，取消默认尺寸 */
	image {
		display: block;
		height: auto;
		width: auto;
	}
	
	/* 输入框默认字体大小 */
	input {
		font-size: 28rpx;
	}
	
	/* 列式弹性盒子 */
	.flex_col {
		display: flex;
		flex-direction: row;
		flex-wrap: nowrap;
		justify-content: flex-start;
		align-items: center;
		align-content: center;
	}
	
	/* 行式弹性盒子 */
	.flex_row {
		display: flex;
		flex-direction: column;
		flex-wrap: nowrap;
		justify-content: flex-start;
		align-items: flex-start;
		align-content: flex-start;
	}
	
	/* 弹性盒子弹性容器 */
	.flex_col .flex_grow {
		width: 0;
		flex-grow: 1;
	}
	
	.flex_row .flex_grow {
		flex-grow: 1;
	}
	
	
	.box-1 {
		
		width: 100%;
		height: auto;
		padding-bottom: 100rpx;
		box-sizing: content-box;
	
		/* 兼容iPhoneX */
		// margin-bottom: 0;
		// margin-bottom: constant(safe-area-inset-bottom);
		// margin-bottom: env(safe-area-inset-bottom);
	}
	
	.box-2 {
		padding-bottom: calc(var(--window-bottom) );
		position: fixed;
		left: 0;
		width: 100%;
		bottom: 0;
		height: auto;
		z-index: 2;
		border-top: #e5e5e5 solid 1px;
		box-sizing: content-box;
		background-color: #F3F3F3;
	
		// /* 兼容iPhoneX */
		// padding-bottom: 0;
		// padding-bottom: constant(safe-area-inset-bottom);
		// padding-bottom: env(safe-area-inset-bottom);
	
/* 		>view {
			padding: 0 20rpx;
			height: 100rpx;
		} */
	
		.content {
			background-color: #fff;
			height: 80rpx;
			padding: 0 20rpx;
			border-radius: 40rpx;
			font-size: 28rpx;
		}
	
		.send {
			background-color: #7966ff;
			color: #fff;
			height: 64rpx;
			margin-left: 20rpx;
			border-radius: 32rpx;
			padding: 0;
			width: 120rpx;
			line-height: 62rpx;
	
			&:active {
				background-color: #7966ff;
			}
		}
		.avatar{
			width: 58rpx;
			height: 58rpx;
			margin-right: 20rpx;
			border-radius: 50%;
		}
	}
	
	.talk-list {
		padding-bottom: 20rpx;
	
		/* 消息项，基础类 */
		.item {
			padding: 20rpx 20rpx 0 20rpx;
			align-items: flex-start;
			align-content: flex-start;
			color: #333;
	
			.pic {
				width: 92rpx;
				height: 92rpx;
				border-radius: 50%;
				border: #fff solid 1px;
			}
	
			.content {
				padding: 20rpx;
				border-radius: 4px;
				max-width: 500rpx;
				word-break: break-all;
				line-height: 52rpx;
				position: relative;
			}
	
			/* 收到的消息 */
			&.pull {
				.content {
					margin-left: 32rpx;
					background-color: #fff;
					white-space: pre-wrap;
	
					&::after {
						content: '';
						display: block;
						width: 0;
						height: 0;
						border-top: 16rpx solid transparent;
						border-bottom: 16rpx solid transparent;
						border-right: 20rpx solid #fff;
						position: absolute;
						top: 30rpx;
						left: -18rpx;
					}
				}
			}
	
			/* 发出的消息 */
			&.push {
				/* 主轴为水平方向，起点在右端。使不修改DOM结构，也能改变元素排列顺序 */
				flex-direction: row-reverse;
	
				.content {
					margin-right: 32rpx;
					background-color: #a0e959;
	
					&::after {
						content: '';
						display: block;
						width: 0;
						height: 0;
						border-top: 16rpx solid transparent;
						border-bottom: 16rpx solid transparent;
						border-left: 20rpx solid #a0e959;
						position: absolute;
						top: 30rpx;
						right: -18rpx;
					}
				}
			}
		}
	}
</style>

