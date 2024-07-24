<template>
<view class="flex-col page">
  <view class="flex-col" >
	
    <view class="flex-col justify-start section">
      <view class="flex-col section_2">
        <view class="flex-row group">
          <image
            class="image"
            :src="avatar+user.id"
          />
          <view class="flex-col items-start self-start group_2 ml-5-5" >
            <text class="text">{{user.bname}}</text>
            <text class="font text_2 mt-5-5">{{user.message}}</text>
          </view>

		
		</view>
        <view class="flex-row equal-division group_3 mt-5">
          <view class="flex-col items-center group_4 equal-division-item">
            <text class="font_2">0</text>
            <text class="font_3 text_3 mt-7">浏览历史</text>
          </view>
          <view class="flex-col items-center group_4 equal-division-item">
            <text class="font_2">0</text>
            <text class="font_3 text_3 mt-7">收藏</text>
          </view>
          <view class="flex-col items-center group_4 equal-division-item">
            <text class="font_2">0</text>
            <text class="font_3 text_3 mt-7-5">积分</text>
          </view>
          <view class="flex-col items-center group_4 equal-division-item">
            <text class="font_2">0</text>
            <text class="font_3 text_3 mt-7-5">优惠卷</text>
          </view>
        </view>
       
	  </view>
	   <image src='../../static/liudong.gif' mode='scaleToFill' style="height: 80rpx;width: 100%;bottom: 0;z-index: 99; mix-blend-mode: screen;"></image>
    </view>
    <view class="flex-col group_5">
      <view class="flex-col self-stretch section_3">
        <view class="flex-col">
          <view class="flex-row justify-between items-center group_6">
            <text class="text_4">我的订单</text>
            <view class="flex-row group_7"  @click="navTo('/pages/payment/payment?state=0')">
              <text class="text_5">全部订单</text>
              <image
                class="shrink-0 image_2"
                src="../../static/mine_menu/箭头.png"
              />
            </view>
          </view>
          <view class="flex-row equal-division_2 mt-9-5">
            <view class="flex-col items-center group_8 equal-division-item_2">
              <image
                class="image_3"
                src="../../static/image-menu/待支付.png"
				 @click="navTo('/pages/payment/payment?state=1')"
              />
              <text class="font_4 mt-8-5">待付款</text>
            </view>
            <view class="flex-col items-center group_8 equal-division-item_2">
              <image
                class="image_3"
                src="../../static/image-menu/订单.png"
                 @click="navTo('/pages/payment/payment?state=2')"
			  />
              <text class="font_4 mt-9">待出库</text>
            </view>
            <view class="flex-col items-center group_8 equal-division-item_2">
              <image
                class="image_3"
                src="../../static/image-menu/待收货.png"
				 @click="navTo('/pages/payment/payment?state=3')"
              />
              <text class="font_4 mt-9-5">待收货</text>
            </view>
            <view class="flex-col items-center group_8 equal-division-item_2">
              <image
                class="image_3"
                src="../../static/image-menu/统计.png"
				@click="navTo('/pages/payment/payment?state=4')"
              />
              <text class="font_4 mt-8-5">待评价</text>
            </view>
            <view class="flex-col items-center group_8 equal-division-item_2">
              <image
                class="image_3"
                src="../../static/image-menu/售后.png"
				@click="navTo('/pages/payment/payment?state=5')"
              />
              <text class="font_4 mt-8-5">退货退款</text>
            </view>
          </view>
        </view>
        <view class="flex-col mt-31">
          <text class="self-start font_5 text_6">我的服务</text>
          <view class="flex-row equal-division_3 group_9 mt-14-5">
            <view class="flex-col items-start group_10 equal-division-item_3">
              <image
                class="image_4"
                src="../../static/mine_menu/我的问诊.png"
              />
              <text class="font text_7 mt-7">我的问诊</text>
            </view>
            <view class="flex-col items-start group_10 equal-division-item_3">
              <image
                class="image_4"
                src="../../static/mine_menu/我的处方.png"
              />
              <text class="font text_7 mt-7">我的处方</text>
            </view>
            <view class="flex-col items-start group_10 equal-division-item_3">
              <image
                class="image_4"
                src="../../static/mine_menu/我的预约.png"
              />
              <text class="font text_7 mt-7-5">我的预约</text>
            </view>
            <view class="flex-col items-start group_10 equal-division-item_3">
              <image
                class="image_4"
                src="../../static/mine_menu/报告评估.png"
              />
              <text class="font text_7 mt-7">报告评估</text>
            </view>
            <view class="flex-col items-start group_10 equal-division-item_3">
              <image
                class="image_4"
                src="../../static/mine_menu/健康诊断.png"
              />
              <text class="font text_7 mt-6-5">健康评估</text>
            </view>
          </view>
        </view>
      </view>
      <view class="flex-col self-stretch section_4">
        <text class="self-start font_5 text_8">个人中心</text>
        <view class="grid mt-8-5">
          <view class="flex-col items-center relative grid-item">
            <image
              class="image_5"
              src="../../static/mine_menu/收货地址.png"
            />
            <text class="font mt-9-5">收货地址</text>
          </view>
          <view class="flex-col items-center relative grid-item">
            <image
              class="image_5"
              src="../../static/mine_menu/我的评价.png"
            />
            <text class="font mt-10-5">我的评价</text>
          </view>
          <view class="flex-col items-center relative grid-item">
            <image
              class="image_5"
              src="../../static/mine_menu/我的投诉.png"
            />
            <text class="font mt-10-5">我的投诉</text>
          </view>
          <view class="flex-col items-center relative grid-item">
            <image
              class="image_5"
              src="../../static/mine_menu/我的保单.png"
            />
            <text class="font mt-10-5">我的保单</text>
          </view>
          <view class="flex-col items-center relative grid-item" @click="remind()">
            <image
              class="image_5"
              src="../../static/mine_menu/用药提醒.png"
            />
            <text class="font mt-10-5">用药提醒</text>
          </view>
          <view class="flex-col items-center relative grid-item">
            <image
              class="image_5"
              src="../../static/mine_menu/用药人.png"
            />
            <text class="font mt-11">用药人</text>
          </view>
        </view>
      </view>
      <view class="flex-col justify-start items-center button text-wrapper" @click="handleLogout"><text class="text_9">退出登录</text></view>
    </view>
  </view>
  

  
</view>

</template>

<script>
export default {
  components: {},
  props: {},
  data() {
    return {
		user:{},
		avatar:''
		
		
		
		
	}
  },
	onLoad() {
		this.avatar='http://223.4.21.161:8081/user/getavatar?bid='
		if(getApp().globalData.uid==''){
			uni.redirectTo({
				url: '../login/login'
			})
		}		
		else this.getuser();
		
		// if(this.user.id==null){
		// 	uni.redirectTo({
		// 		url: '../login/login'
		// 	})
		// }
	},
  methods: {
		navTo(url){
						// if(!this.hasLogin){
						// 	url = '/pages/public/login';
						// }
						uni.navigateTo({  
							url
						})  
						
					}, 
					handleLogout() {
						getApp().globalData.uid=null;
					  uni.redirectTo({
					  	url: '../login/login'
					  })
					},
						remind(){
							uni.navigateTo({
								url:'/pages/remind_medicine/remind_medicine'
							})
						},
						getuser(){
							uni.request({
							  url: 'http://223.4.21.161:8081/user/getuserbyID', 
							  method: 'GET', 
							  data: {
									bid:getApp().globalData.uid,
								  }, 
							  success: (res) => { // 请求成功回调函数
							    console.log(res.data); // 输出返回的数据
								if(res.data.code==200) 
								{
									this.user=res.data.data;
								}
								else{
									uni.showToast({title:res.data.message,duration: 1500});
								}
							  },
							  fail: (err) => { // 请求失败回调函数
							    console.log(err);
								uni.showToast({title:'网络请求失败',duration: 1500});
							  }
						});
						
					},
			
			}
}
</script>

<style scoped lang="scss">
.ml-5-5 {
  margin-left: 11.34rpx;
}
.mt-5 {
  margin-top: 10rpx;
}
.mt-9-5 {
  margin-top: 19.34rpx;
}
.mt-9 {
  margin-top: 18rpx;
}
.mt-31 {
  margin-top: 62rpx;
}
.mt-14-5 {
  margin-top: 29.34rpx;
}
.mt-7 {
  margin-top: 14rpx;
}
.mt-10-5 {
  margin-top: 21.34rpx;
}
.mt-11 {
  margin-top: 22rpx;
}
.mt-21-5 {
  margin-top: 43.34rpx;
}
.mt-7-5 {
  margin-top: 15.34rpx;
}
.mt-5-5 {
  margin-top: 11.34rpx;
}
.mt-8-5 {
  margin-top: 17.34rpx;
}
.mt-6-5 {
  margin-top: 13.34rpx;
}
.page {
  background-color: #eff5f3;
  width: 100%;
  overflow-y: auto;
  overflow-x: hidden;
  height: 100%;
  padding-bottom:50rpx;
  .section {
    padding: 60rpx 0 0;
    background-color: #009254;
    border-radius: 0rpx 0rpx 13.34rpx 26.66rpx;
    .section_2 {
      margin: 0 25.34rpx;
      padding: 0 54.66rpx;
      background-color: #ffffff;
      border-radius: 33.34rpx;
      .group {
        padding-top: 32rpx;
        .image {
          width: 140rpx;
          height: 140rpx;
        }
        .group_2 {
          margin-top: 39.34rpx;
          padding: 0 9.34rpx 20.66rpx 26rpx;
          border-bottom: solid 4rpx #9c9c9c;
          .text {
            color: #000000;
            font-size: 40rpx;
            font-family: Adobe Heiti Std;
            line-height: 32rpx;
          }
          .text_2 {
            color: #999a99;
            line-height: 22.66rpx;
          }
        }
      }
      .equal-division {
        margin-left: 4rpx;
        margin-right: 6.66rpx;
        .group_4 {
          flex: 1 1 144.88rpx;
          .font_2 {
            font-size: 36.66rpx;
            font-family: Adobe Heiti Std;
            line-height: 28.66rpx;
            color: #000000;
          }
          .font_3 {
            font-size: 23.34rpx;
            font-family: Adobe Heiti Std;
            line-height: 22rpx;
            color: #999999;
          }
          .text_3 {
            font-size: 22.66rpx;
            line-height: 21.34rpx;
          }
        }
        .equal-division-item {
          padding: 10.66rpx 0;
        }
      }
      .group_3 {
        padding-bottom: 7.34rpx;
      }
    }
  }
  .group_5 {
    padding: 30rpx 19.34rpx 0;
    .section_3 {
      margin-right: 4rpx;
      padding: 43.34rpx 0 26rpx;
      background-color: #ffffff;
      border-radius: 46.66rpx;
      .group_6 {
        padding: 0 42rpx;
        .text_4 {
          color: #000000;
          font-size: 31.34rpx;
          font-family: Adobe Heiti Std;
          line-height: 30rpx;
        }
        .group_7 {
          margin-right: 14rpx;
          .text_5 {
            color: #999999;
            font-size: 22rpx;
            font-family: Adobe Heiti Std;
            line-height: 20.66rpx;
          }
          .image_2 {
            width: 9.34rpx;
            height: 20rpx;
          }
        }
      }
      .equal-division_2 {
        padding: 0 21.34rpx;
        .group_8 {
          flex: 1 1 132.76rpx;
          .image_3 {
            width: 64rpx;
            height: 64rpx;
          }
          .font_4 {
            font-size: 26rpx;
            font-family: Adobe Heiti Std;
            line-height: 24.66rpx;
            color: #000000;
          }
        }
        .equal-division-item_2 {
          padding: 2.66rpx 10.66rpx 10.66rpx;
        }
      }
      .text_6 {
        margin-left: 46rpx;
      }
      .equal-division_3 {
        align-self: stretch;
        .group_10 {
          flex: 1 1 133.34rpx;
          .image_4 {
            margin-left: 12rpx;
            width: 80rpx;
            height: 80rpx;
			margin-bottom: 15rpx;
          }
          .text_7 {
            margin-left: 10.66rpx;
          }
        }
        .equal-division-item_3 {
          padding: 5.34rpx 9.34rpx 12rpx 13.34rpx;
        }
      }
      .group_9 {
        padding: 0 20rpx;
      }
    }
    .section_4 {
      margin-top: 23.34rpx;
      padding: 28rpx 0 32rpx;
      background-color: #ffffff;
      border-radius: 46.66rpx;
      .text_8 {
        margin-left: 46rpx;
      }
      .grid {
        padding: 0 21.34rpx;
        height: 229.34rpx;
        display: grid;
        grid-template-rows: repeat(2, minmax(0, 1fr));
        grid-template-columns: repeat(5, minmax(0, 1fr));
        row-gap: 0;
        column-gap: 0;
        .grid-item {
          padding: 12rpx 5.34rpx;
          .image_5 {
            width: 48rpx;
            height: 48rpx;
          }
        }
      }
    }
    .font_5 {
      font-size: 28.66rpx;
      font-family: Adobe Heiti Std;
      line-height: 27.34rpx;
      color: #000000;
    }
    .button {
      align-self: center;
      margin-top: 42rpx;
      .text_9 {
        color: #ffffff;
        font-size: 43.34rpx;
        font-family: Adobe Heiti Std;
        line-height: 40rpx;
      }
    }
    .text-wrapper {
      padding: 26.66rpx 0;
      background-color: #009254;
      border-radius: 46.66rpx;
      width: 426rpx;
    }
  }
  .font {
    font-size: 23.34rpx;
    font-family: Adobe Heiti Std;
    line-height: 22rpx;
    color: #000000;
  }
  .section_5 {
    padding: 26rpx 0 32rpx;
    flex: 1 1 150rpx;
    background-color: #ffffff;
    height: 128.66rpx;
    .image_6 {
      width: 60.66rpx;
      height: 42rpx;
    }
    .text_10 {
      color: #1aaf64;
    }
  }
  .section_6 {
    padding: 34rpx 0 32rpx;
    flex: 1 1 150rpx;
    background-image: url('https://ide.code.fun/api/image?token=6560094f28456c0011656844&name=b8835c56e8b970466bd9baa2a3819f6d.png');
    background-size: 100% 100%;
    background-repeat: no-repeat;
    height: 129.34rpx;
    .image_10 {
      width: 60rpx;
      height: 30rpx;
    }
    .text_11 {
      line-height: 16rpx;
    }
  }
  .font_6 {
    font-size: 18.66rpx;
    font-family: Adobe Heiti Std;
    line-height: 16.66rpx;
    color: #4d4c4c;
  }
  .section_7 {
    flex: 1 1 150rpx;
    padding: 30rpx 0 32rpx;
    background-image: url('https://ide.code.fun/api/image?token=6560094f28456c0011656844&name=b8835c56e8b970466bd9baa2a3819f6d.png');
    background-size: 100% 100%;
    background-repeat: no-repeat;
    height: 129.34rpx;
    .image_7 {
      width: 51.34rpx;
      height: 37.34rpx;
    }
    .text_12 {
      line-height: 17.34rpx;
    }
    .image_8 {
      width: 47.34rpx;
      height: 37.34rpx;
    }
    .text_13 {
      line-height: 16rpx;
    }
  }
  .section_8 {
    padding: 32rpx 36.66rpx;
    flex: 1 1 150rpx;
    background-image: url('https://ide.code.fun/api/image?token=6560094f28456c0011656844&name=b8835c56e8b970466bd9baa2a3819f6d.png');
    background-size: 100% 100%;
    background-repeat: no-repeat;
    height: 129.34rpx;
    .image_9 {
      margin-left: 8.66rpx;
      width: 60.66rpx;
      height: 34rpx;
    }
  }
}
</style>