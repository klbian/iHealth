

<template>
<view class="flex-col page">
  <view class="flex-col group simple-linear">
    <view class="flex-row justify-between items-center group_4">
      <view class="flex-row items-center button">
        <text class="font text_4">感冒发烧</text>
        <image
          class="shrink-0 image_7"
          src="../../static/main_menu/热门.png"
        />
      </view>
      <view class="flex-col justify-start items-center button_2"><text class="font_2 text_5">阿奇霉素</text></view>
      <view class="flex-col justify-start items-center text-wrapper_2"><text class="font_2">糖尿病</text></view>
      <view class="flex-col justify-start items-center button_1"><text class="font_2 text_6">补肾壮阳</text></view>
      <view class="flex-col justify-start items-center button_4"><text class="font_2">儿童用药</text></view>
    </view>
    <view class="flex-row justify-between items-center relative group_2">
		<view class="flex-row items-center">
		  <image
		    class="shrink-0 image"
		    src="../../static/main_menu/定位.png"
		  />
		  <text class="text_2">南昌</text>
		  <image
		    class="shrink-0 image_3"
		    src="../../static/main_menu/箭头.png"
		  />
		</view>
      <view class="flex-row items-center">
        <image
          class="shrink-0 image_2"
          src="../../static/main_menu/image.png"
        />
        <text class="text ml-6-5">IHealth</text>
      </view>
      
    </view>
    <view class="flex-row items-center section">
      <view class="flex-row items-center flex-1" @click="fideit()">
        <image
          class="shrink-0 image_6"
          src="../../static/main_menu/搜索.png"
        />
        <text class="text_3 ml-14-5">药品、症状、品牌、药店</text>
      </view>
      <view class="ml-20 flex-row shrink-0 group_3">
        <image
          class="image_4"
          src="../../static/main_menu/相机.png"
        />
        <image
          class="image_5 ml-13-5"
          src="../../static/main_menu/扫码.png"
        />
      </view>
    </view>
  </view>
  <view class="flex-col mt-25-5">
    <view class="flex-col section_2" @click="datarukou()">
      <image
        class="image_8"
        src="../../static/main_menu/大数据预测地图.png"
      />
      <view class="mt-10 flex-row justify-between items-baseline">
        <text class="font_3 text_7">大数据预测地图</text>
        <text class="font text_8">点击查看更多</text>
      </view>
    </view>
    <view class="flex-col group_5">
      <view class="flex-row equal-division">
        <image
          class="image_9 image_1"
          src="../../static/main_menu/问诊按钮.png"
		  @click="wenzheng()"
        />
        <image
          class="image_9 image_17 ml-14-5"
          src="../../static/main_menu/买药.png"
		  @click="gotobuy_medicine()"
        />
		
      </view>
      <view class="flex-col mt-17-5">
        <view class="flex-col relative section_3">
          <text class="self-start font_3 text_9">专科中心</text>
          <view class="flex-row self-stretch mt-12-5">
            <image
              class="image_12"
              src="../../static/main_menu/皮肤专科.png"
            />
            <view class="flex-col items-center group_6">
              <image
                class="image_10"
                src="../../static/main_menu/心脑血管.png"
              />
              <image
                class="image_13 mt-5-5"
                src="../../static/main_menu/消化内科.png"
              />
            </view>
            <view class="flex-col justify-start items-center relative group_7">
              <image
                class="image_14"
                src="../../static/main_menu/泌尿外科.png"
              />
              <image
                class="image_11 pos"
                src="../../static/main_menu/呼吸内科.png"
              />
            </view>
          </view>
        </view>
<!--        <view class="flex-col justify-start section_5 group_5">
          <view class="flex-row">
            <view class="flex-col items-center section_4 section_1">
              <image
                class="image_15"
                src="https://ide.code.fun/api/image?token=655de6fa28456c001164fe14&name=c461663cf961119deea811ceda80bf64.png"
              />
              <text class="font_4 text_10 mt-8-5">首页</text>
            </view>
            <view class="flex-col items-center section_4 equal-division-item_3">
              <image
                class="image_15"
                src="https://ide.code.fun/api/image?token=655de6fa28456c001164fe14&name=e5f54eca9fc1476e0ef26c22ce462c7c.png"
              />
              <text class="font_4 mt-8-5">药品</text>
            </view>
            <view class="flex-col items-center section_4 section_7">
              <image
                class="image_15"
                src="https://ide.code.fun/api/image?token=655de6fa28456c001164fe14&name=892d97b5d190b4d6d7b872a973fe42b1.png"
              />
              <text class="mt-8 font_4 text_11">问诊</text>
            </view>
            <view class="flex-col items-center section_4 equal-division-item_3">
              <image
                class="image_15"
                src="https://ide.code.fun/api/image?token=655de6fa28456c001164fe14&name=69c9e4fb0322f174eaa27b73809da817.png"
              />
              <text class="font_4 mt-8-5">购物车</text>
            </view>
            <view class="flex-col items-center section_4 equal-division-item_3">
              <image
                class="image_15"
                src="https://ide.code.fun/api/image?token=655de6fa28456c001164fe14&name=e2335ca0eccb06a0a49d2068e291a116.png"
              />
              <text class="font_4 mt-8-5">我的</text>
            </view>
          </view>
        </view> -->
      </view>
    </view>
  </view>
</view>
</template>

<script>
	import {
		recommend,
	} from '../../network/http.js';
	export default {


		data() {
			return {
				
				
				title: '该文字为商品描述',
				indicatorDots: true,
				autoplay: true,
				interval: 4000, //切换的间隔时间
				duration: 500, //滑动动画时长	
				image_url:{
					type:String,
					de:'http://111.229.3.64:8184/goods/queryGoodsLogo?code=',
					},
				info: [{
						url: '/static/show1.jpg',
					},
					{
						url: '/static/show2.jpg',
					},
					{
						url: '/static/show3.jpg',
					}
				],
				loadm: [
					{
						url:'/static/book1.jpg',
						name:'高性能MySQL',
						price:30,
						soldnum:10
					},
					{
						url:'/static/book2.jpg',
						name:'Java编程思想',
						price:50,
						soldnum:2
					},
					{
						url:'/static/book3.jpg',
						name:'C primer plus',
						price:60,
						soldnum:0
					}
	
				],

			}
		},
		onLoad() {

			
			//this.sp();
			
		},


		methods: {
			
			fideit(){		
				uni.navigateTo({
					url: '../HM-search/HM-search'
				})
			},
			 cc(code){
			 	console.log(code);
			 },
			async sp() {
				await recommend().then(res => {
					
					const code = res.statusCode;
					if (code === 200) {
						this.loadm = res.data;
					} else {
						uni.showToast({
							title: res.data.msg
						})
					}
				}).catch(err => {
					console.log(err)
				})
			},
			
			datarukou(){
				uni.navigateTo({
					url: '../bigdata/bigdata'
				})
			},
			wenzheng(){
				uni.switchTab({
					url:'/pages/AI/ai'
				})
			},
			gotobuy_medicine(){
				uni.switchTab({
					url:'/pages/Commodity column/index'
				})
			},
			


		},
		


	}
</script>

<style scoped lang="scss">
.ml-6-5 {
  margin-left: 13.34rpx;
}
.ml-13-5 {
  margin-left: 27.34rpx;
}
.mt-25-5 {
  margin-top: 51.34rpx;
}
.ml-14-5 {
  margin-left: 29.34rpx;
}
.mt-17-5 {
  margin-top: 35.34rpx;
	margin-bottom: 20rpx;
}
.mt-12-5 {
  margin-top: 25rpx;
  margin-left: -15rpx;
  margin-right: 15rpx;
}
.mt-5-5 {
  margin-top: 11.34rpx;
}
.mt-8-5 {
  margin-top: 17.34rpx;
}
.page {
  background-color: #eff5f3;
  width: 100%;
  overflow-y: auto;
  overflow-x: hidden;
  height: 100%;
  padding-top:60rpx;
  
  .group {
    padding: 27.34rpx 34.66rpx 0 36.66rpx;
    height: 274.66rpx;
    .group_4 {
      margin-top: 209rpx;
      transform: translateY(-25rpx);
      .button {
        padding: 0 12.66rpx 11.34rpx;
        background-color: #fee5de;
        border-radius: 20rpx;
        width: 133.34rpx;
        height: 38rpx;
        .text_4 {
          color: #fb1b1b;
          line-height: 19.34rpx;
        }
        .image_7 {
          width: 20rpx;
          height: 26.66rpx;
        }
      }
      .button_2 {
        padding-bottom: 9.34rpx;
        background-color: #ffffff99;
        border-radius: 20rpx;
        width: 120rpx;
        height: 34rpx;
        .text_5 {
          color: #010101;
        }
      }
      .text-wrapper_2 {
        padding-bottom: 9.34rpx;
        background-color: #ffffff99;
        border-radius: 20rpx;
        width: 100rpx;
        height: 34rpx;
      }
      .font_2 {
        font-size: 21.34rpx;
        font-family: Adobe Heiti Std;
        line-height: 20rpx;
		margin-top: 5rpx;
        color: #000000;
      }
      .button_1 {
        padding-bottom: 9.34rpx;
        background-color: #ffffff99;
        border-radius: 20rpx;
        width: 120rpx;
        height: 34rpx;
        .text_6 {
          line-height: 20.66rpx;
        }
      }
      .button_4 {
        padding-bottom: 10.66rpx;
        background-color: #ffffff99;
        border-radius: 20rpx;
        width: 120rpx;
        height: 34rpx;
      }
    }
    .group_2 {
      margin-left: 12rpx;
      margin-top: -247.34rpx;
      padding-left: 8rpx;
      padding-bottom: 12rpx;
      .image_2 {
        width: 46.66rpx;
        height: 53.34rpx;
      }
      .text {
        color: #009254;
        font-size: 52.66rpx;
        font-family: Arial Rounded MT Bold;
        line-height: 39.34rpx;
      }
      .image {
        width: 43.34rpx;
        height: 50rpx;
      }
      .text_2 {
        margin-left: 14.66rpx;
        color: #000000;
        font-size: 40.66rpx;
        font-family: Adobe Heiti Std;
        line-height: 37.34rpx;
      }
      .image_3 {
        width: 16rpx;
        height: 34rpx;
      }
    }
    .section {
      margin-left: 12rpx;
      padding: 28rpx 31.34rpx 28.66rpx;
      background-color: #ffffff;
      border-radius: 26.66rpx;
      .image_6 {
        width: 40rpx;
        height: 40rpx;
      }
      .text_3 {
        color: #acacac;
        font-size: 32rpx;
        font-family: Adobe Heiti Std;
        line-height: 30.66rpx;
      }
      .group_3 {
        margin-right: 7.34rpx;
        .image_4 {
          width: 46.66rpx;
          height: 43.34rpx;
        }
        .image_5 {
          width: 43.34rpx;
          height: 43.34rpx;
        }
      }
    }
  }
  .simple-linear {
    background: linear-gradient(45deg, #04a360, 30%, #eef5f2);
  }
  .section_2 {
    margin-left: 40rpx;
    margin-right: 43rpx;
    padding: 33rpx 28rpx 18rpx;
    background-color: #f1ae67;
    border-radius: 30rpx;
    transform: translateY(-10rpx);
    .image_8 {
      margin-left: 5.34rpx;
      margin-right: 5.34rpx;
      width: 600rpx;
      height: 391.34rpx;
    }
    .text_7 {
      color: #eff5f3;
    }
    .text_8 {
      margin-right: 21.34rpx;
      color: #eff5f3;
      line-height: 19.34rpx;
    }
  }
  .font {
    font-size: 20rpx;
    font-family: Adobe Heiti Std;
    line-height: 20rpx;
  }
  .group_5 {
    margin-top: 41.34rpx;
    .equal-division {
      margin-left: 35rpx;
      margin-right: 43rpx;
      transform: translateY(-10rpx);
      .image_9 {
        flex: 1 1 326.66rpx;
      }
      .image_1 {
        height: 134rpx;
      }
      .image_17 {
        height: 133.34rpx;
      }
    }
    .section_3 {
      margin-left: 32.66rpx;
      margin-right: 50rpx;
      padding: 30.66rpx 3.34rpx 38.66rpx 35.34rpx;
      background-color: #ffffff;
      box-shadow: 9.2rpx 7.72rpx 4.74rpx 0.58rpx #99a19eb8, inset 1.54rpx 1.28rpx 4.66rpx #00000059;
      border-radius: 26.66rpx;
      .text_9 {
        margin-left: 21.34rpx;
        color: #000000;
        line-height: 40.66rpx;
      }
      .image_12 {
        flex: 1 1 198.66rpx;
        height: 210.66rpx;
      }
      .group_6 {
        margin-left: 12.66rpx;
        flex: 1 1 198.66rpx;
        .image_10 {
          width: 198.66rpx;
          height: 101.34rpx;
        }
        .image_13 {
          width: 198.66rpx;
          height: 100.66rpx;
        }
      }
      .group_7 {
        margin-left: 18.66rpx;
        padding-top: 113.34rpx;
        flex: 1 1 198.66rpx;
        .image_14 {
          width: 198.66rpx;
          height: 100rpx;
        }
        .image_11 {
          width: 200rpx;
          height: 150.66rpx;
        }
        .pos {
          position: absolute;
          left: 0;
          right: 0;
          top: 0;
        }
      }
    }
    .section_5 {
      background-color: #eff5f3;
      .section_4 {
        flex: 1 1 150rpx;
        .image_15 {
          width: 64rpx;
          height: 64rpx;
        }
        .font_4 {
          font-size: 26.66rpx;
          font-family: Adobe Heiti Std;
          line-height: 24.66rpx;
          color: #4d4c4c;
        }
        .text_10 {
          color: #1aaf64;
        }
        .text_11 {
          line-height: 26rpx;
        }
      }
      .section_1 {
        padding: 42rpx 0 51.34rpx;
        background-color: #ffffff;
        height: 198.66rpx;
      }
      .equal-division-item_3 {
        padding: 43.32rpx 0 51.34rpx;
        background-color: #ffffff;
        height: 200rpx;
      }
      .section_7 {
        padding: 43.32rpx 0 50.66rpx;
        background-color: #ffffff;
        height: 200rpx;
      }
    }
  }
  .font_3 {
    font-size: 43.34rpx;
    font-family: Adobe Heiti Std;
    line-height: 40rpx;
  }
}
</style>