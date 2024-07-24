<template>
<view class="flex-col page">
  <view class="flex-col section" >
	 
    <view class="flex-row items-center section_2">
      <image
        class="shrink-0 image_3"
        src="../../static/main_menu/搜索.png"
      />
      <text class="font text">药品、症状、品牌、药店</text>
      <image
        class="shrink-0 image"
        src="../../static/main_menu/相机.png"
      />
      <image
        class="shrink-0 image_2"
        src="../../static/main_menu/扫码.png"
      />
    </view>
    <view class="mt-14 flex-row group_10 group">
      <view class="flex-col justify-start items-center text-wrapper text-wrapper_1">
        <text class="font_2 text_2">腹痛腹泻</text>
      </view>
      <view class="flex-col justify-start items-center text-wrapper text-wrapper_12 ml-7">
        <text class="font_2 text_3">皮肤过敏</text>
      </view>
      <view class="flex-col justify-start items-center text-wrapper text-wrapper_2 ml-7">
        <text class="font_2 text_4">支气管炎</text>
      </view>
      <view class="flex-col justify-start items-center text-wrapper text-wrapper_13 ml-7">
        <text class="font_2 text_5">肝胆用药</text>
      </view>
      <view class="flex-col justify-start text-wrapper text-wrapper_3 ml-7">
        <text class="font_2 text_6">跌打损伤</text>
      </view>
    </view>
  </view>
  <view class="flex-row equal-division">
    <view class="flex-col group_2 equal-division-item">
      <view class="flex-col items-center section_20">
        <image
          class="image_4"
          src="../../static/medicine_menu/17001875389279945603.png"
        />
        <text class="mt-10 font_3 text_7">商品分类</text>
      </view>
      <view class="flex-col items-center section_3">
        <image
          class="image_7"
          src="../../static/medicine_menu/17001875389374953927.png"
        />
        <text class="mt-12 font_3 text_7">养生保健</text>
      </view>
    </view>
    <view class="flex-col group_2 equal-division-item">
      <view class="flex-col items-center section_21">
        <image
          class="image_4"
          src="../../static/medicine_menu/17001875389358705120.png"
        />
        <text class="mt-10 font_3 text_7 text_8">心脑血管</text>
      </view>
      <view class="flex-col items-center section_5">
        <image
          class="image_9"
          src="../../static/medicine_menu/17001875396885593110.png"
        />
        <text class="mt-12 font_3 text_7">男性健康</text>
      </view>
    </view>
    <view class="flex-col group_2 equal-division-item">
      <view class="flex-col items-center section_4">
        <image
          class="image_5"
          src="../../static/medicine_menu/f4693f07c4af268e5c3e1083e7d8268a.png"
        />
        <text class="mt-10 font_4 text_7">女性健康</text>
      </view>
      <view class="flex-col items-center section_19">
        <image
          class="image_8"
          src="../../static/medicine_menu/17001875395107482292.png"
        />
        <text class="font_4 text_7 mt-11">肠胃用药</text>
      </view>
    </view>
    <view class="flex-col group_2 equal-division-item">
      <view class="flex-col items-center section_1">
        <image
          class="image_6"
          src="../../static/medicine_menu/17001875389301829316.png"
        />
        <text class="mt-10 font_3 text_7 text_9">儿童用药</text>
      </view>
      <view class="flex-col items-center section_23">
        <image
          class="image_6"
          src="../../static/medicine_menu/17001875395170322904.png"
        />
        <text class="mt-12 font_3 text_7 text_11">皮肤用药</text>
      </view>
    </view>
    <view class="flex-col group_2 equal-division-item">
      <view class="flex-col items-center section_22">
        <image
          class="image_6"
          src="../../static/medicine_menu/17001875389338277713.png"
        />
        <text class="mt-12 font_3 text_7 text_10">呼吸哮喘</text>
      </view>
      <view class="flex-col items-center section_12">
        <image
          class="image_6"
          src="../../static/medicine_menu/17001875396715303624.png"
        />
        <text class="font_3 text_7 text_12 mt-15">风湿骨科</text>
      </view>
    </view>
  </view>
  <view class="flex-col group_3">
    <view class="flex-col section_6">
      <view class="flex-row justify-between items-center group_4">
        <text class="font_5 text_13">乐享健康</text>
        <view class="flex-row section_7">
          <image
            class="image_10"
            src="../../static/medicine_menu/17001378825785055425.png"
          />
          <text class="font text_14">更多</text>
        </view>
      </view>
      <view class="flex-row view group">
        <view class="flex-col items-center shrink-0 section_8">
          <text class="font_6 text_15">气管炎</text>
          <view class="section_9 mt-3"></view>
        </view>
        <view class="flex-col justify-start items-center shrink-0 text-wrapper_4">
          <text class="font_6 text_16">流行性感冒</text>
        </view>
        <view class="flex-col justify-start items-center shrink-0 text-wrapper_5">
          <text class="font_7 text_55">滋补调养</text>
        </view>
        <view class="flex-col justify-start items-center shrink-0 text-wrapper_14">
          <text class="font_7 text_17">腹痛腹泻</text>
        </view>
        <view class="flex-col justify-start shrink-0 text-wrapper_6"><text class="font_7 text_18">消化不良</text></view>
      </view>
      <view class="grid">
        <view class="flex-col grid-item_1" v-for="(medicine,index) in medicine_array.slice(0,6)" :key="index">
          <view class="flex-col items-center self-stretch" @click="gotodetail(medicine.drugID)">
            <image
              class="shrink-0 image_11"
              :src="img_url+medicine.drugID"
            />
            <text class="font_6 text_19">{{medicine.dname}}</text>
          </view>
          <text class="self-start font_8 text_1">{{medicine.dmessage}}</text>
          <text class="self-start font text_57">销量：{{medicine.dsales}}</text>
        </view>
      </view>
    </view>
    <view class="mt-22 flex-col section_10">
      <view class="flex-col items-start group_1">
        <text class="text_22">秒懂健康</text>
        <view class="section_11 mt-3"></view>
      </view>
      <view class="mt-10 grid_2">
        <view class="flex-col grid-item_7" v-for="(medicine,index) in medicine_array" :key="index">
          <image
            class="shrink-0 self-center image_12"
           :src="img_url+medicine.drugID"
          />
          <text class="self-start font_6 text_34">{{medicine.dname}}</text>
          <text class="self-start font_8 text_38 text_36">{{medicine.dmessage}}</text>
          <view class="flex-row items-center self-stretch group_7">
            <text class="font">销量：{{medicine.dsales}}</text>
            <view class="ml-14 flex-col justify-start items-center text-wrapper_7 button_2">
              <text class="font_9 text_41">加入购物车</text>
            </view>
          </view>
        </view>
      </view>
    </view>
  </view>
</view>
</template>

<script>
import medicine_detailVue from '../medicine_detail/medicine_detail.vue';
export default {
  components: {},
  props: {},
  data() {
    return {
		medicine_array:[],
		img_url:'',
	};
  },
	onLoad() {
		this.img_url='http://223.4.21.161:8081/drug/getimg?imgid=',
		this.getmedicine()
	},
  methods: {
    onClick() {
		
      uni.navigateTo({ url: '/pages/BuyMediaclMAIN1/BuyMediaclMAIN1' });
    },
	gotodetail(drugid){
		uni.navigateTo({
			url:'/pages/medicine_detail/medicine_detail?drugid='+drugid
		})
	},
  
  getmedicine() {
  	uni.request({
  	  url: 'http://223.4.21.161:8081/drug/showdrug', // 请求的URL
  	  method: 'GET', // 请求方法，可选值包括：GET/POST/PUT/DELETE等
  	  data: {
  		  }, // 请求参数，可根据接口文档自行添加 
  	  
	  success: (res) => { // 请求成功回调函数  
		console.log(res.data); // 输出返回的数据
  		if(res.data.code==200) 
  		{
  			this.medicine_array=res.data.data;
			console.log(this.medicine_array);
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
  },
};
</script>

<style scoped lang="scss">
.ml-7 {
  margin-left: 14rpx;
}
.mt-11 {
  margin-top: 22rpx;
}
.mt-15 {
  margin-top: 30rpx;
}
.mt-3 {
  margin-top: 6rpx;
}
.page {
  background-color: #ffffff;
  overflow: hidden;
  width: 100%;
  overflow-y: auto;
  overflow-x: hidden;
  height: 100%;
  padding-top: 60rpx;
  .section {
    padding: 48rpx 0 23.66rpx 22rpx;
    background-color: #00a651;
    .section_2 {
      margin-left: 26rpx;
      margin-right: 48rpx;
      padding: 28rpx 30rpx 28rpx 34.08rpx;
      background-color: #ffffff;
      border-radius: 24rpx;
      .image_3 {
        width: 40rpx;
        height: 40rpx;
      }
      .text {
        margin-left: 35.68rpx;
        color: #abafb3;
        font-size: 32rpx;
        line-height: 29.6rpx;
      }
      .image {
        margin-left: 24.24rpx;
        width: 68rpx;
        height: 52rpx;
      }
      .image_2 {
        margin-left: 18rpx;
        width: 50rpx;
        height: 50rpx;
      }
    }
    .group_10 {
      padding-left: 4rpx;
      overflow: scroll;
      .text-wrapper {
        flex-shrink: 0;
        .font_2 {
          font-size: 30rpx;
          font-family: Poppins;
          line-height: 25.88rpx;
          color: #ffffff;
        }
        .text_2 {
          font-size: 28rpx;
        }
        .text_3 {
          font-size: 28rpx;
        }
        .text_4 {
          font-size: 28rpx;
          line-height: 25.96rpx;
        }
        .text_5 {
          font-size: 28rpx;
          line-height: 25.9rpx;
        }
        .text_6 {
          margin-left: 20.96rpx;
          font-size: 28rpx;
          line-height: 25.84rpx;
        }
      }
      .text-wrapper_1 {
        padding: 12.42rpx 0 10.04rpx;
        background-color: #fbfffd4d;
        border-radius: 24rpx;
        width: 160rpx;
        height: 48.34rpx;
      }
      .text-wrapper_12 {
        padding: 12.46rpx 0 10.02rpx;
        background-color: #fbfffd4d;
        border-radius: 24rpx;
        width: 160rpx;
        height: 48.34rpx;
      }
      .text-wrapper_2 {
        padding: 12.36rpx 0 10.02rpx;
        background-color: #fbfffd4d;
        border-radius: 24rpx;
        width: 156rpx;
        height: 48.34rpx;
      }
      .text-wrapper_13 {
        padding: 12.5rpx 0 9.94rpx;
        background-color: #fbfffd4d;
        border-radius: 24rpx;
        width: 160rpx;
        height: 48.34rpx;
      }
      .text-wrapper_3 {
        padding: 12.5rpx 0 9.98rpx;
        background-color: #fbfffd4d;
        border-radius: 24rpx 0 0 24rpx;
        height: 48.34rpx;
      }
    }
  }
  .equal-division {
    margin-top: 8rpx;
    .group_2 {
      flex: 1 1 150rpx;
      .section_20 {
        padding: 16rpx 0 22.6rpx;
        background-color: #fffdfd;
      }
      .section_3 {
        padding: 18rpx 0 22.64rpx;
        background-color: #fffdfd;
        .image_7 {
          width: 68rpx;
          height: 68rpx;
        }
      }
      .font_3 {
        font-size: 20rpx;
        font-family: Poppins;
        line-height: 18.48rpx;
        color: #4d4c4c;
      }
      .text_7 {
        opacity: 0.9;
      }
      .section_21 {
        padding: 16rpx 0 22.6rpx;
        background-color: #fffcfc;
        .text_8 {
          line-height: 18.58rpx;
        }
      }
      .image_4 {
        width: 74rpx;
        height: 74rpx;
      }
      .section_5 {
        padding: 26rpx 0 22.62rpx;
        background-color: #fffcfc;
        .image_9 {
          width: 78rpx;
          height: 60rpx;
        }
      }
      .section_4 {
        padding: 16rpx 0 22.6rpx;
        background-color: #fffcfc;
        .image_5 {
          width: 73.84rpx;
          height: 73.84rpx;
        }
      }
      .section_19 {
        padding: 22rpx 0 22.58rpx;
        background-color: #fffcfc;
        .image_8 {
          width: 66rpx;
          height: 66rpx;
        }
      }
      .font_4 {
        font-size: 20rpx;
        font-family: Poppins;
        line-height: 18.5rpx;
        color: #4d4c4c;
      }
      .section_1 {
        padding: 26rpx 0 22.58rpx;
        background-color: #fffcfc;
        .text_9 {
          line-height: 18.52rpx;
        }
      }
      .section_23 {
        padding: 22rpx 0 22.58rpx;
        background-color: #fffcfc;
        .text_11 {
          line-height: 18.54rpx;
        }
      }
      .image_6 {
        width: 64rpx;
        height: 64rpx;
      }
      .section_22 {
        padding: 22rpx 0 22.62rpx;
        background-color: #fffcfc;
        .text_10 {
          line-height: 18.46rpx;
        }
      }
      .section_12 {
        padding: 16rpx 0 22.66rpx;
        background-color: #fffcfc;
        .text_12 {
          line-height: 18.44rpx;
        }
      }
    }
    .equal-division-item {
      padding: 10rpx 0;
    }
  }
  .group_3 {
    margin-top: 18rpx;
    .section_6 {
      margin: 0 36rpx;
      padding-bottom: 22rpx;
      border-radius: 30rpx;
      box-shadow: 9rpx 8rpx 5rpx 1rpx #99a19eb8, inset 2rpx 1rpx 5rpx #00000059;
      //background-image: url('https://ide.code.fun/api/image?token=655ef78528456c0011652e64&name=b3d08f8b729ca1fbef0652bc861109e6.png');
      background-size: 100% 100%;
      background-repeat: no-repeat;
      .group_4 {
        padding: 32rpx 17.36rpx 20.98rpx;
        .text_13 {
          line-height: 33.26rpx;
        }
        .section_7 {
          margin-right: 14.64rpx;
          padding: 0 9.38rpx 2rpx;
          background-color: #ffffff;
          width: 98rpx;
          height: 34rpx;
          .image_10 {
            margin-left: 52.62rpx;
            width: 26rpx;
            height: 32rpx;
          }
          .text_14 {
            margin-left: -78.62rpx;
            margin-top: 2.76rpx;
            color: #000000;
            line-height: 27.72rpx;
          }
        }
      }
      .view {
        margin-left: 16rpx;
        margin-right: 30rpx;
        overflow: scroll;
        .section_8 {
          padding: 13.76rpx 0 10rpx;
          background-color: #fffcfc;
          width: 110rpx;
          height: 60rpx;
          .text_15 {
            font-size: 26rpx;
            line-height: 24.08rpx;
          }
          .section_9 {
            background-color: #00a651;
            width: 50rpx;
            height: 6rpx;
          }
        }
        .text-wrapper_4 {
          padding: 13.72rpx 0 22.12rpx;
          background-color: #fffcfc;
          width: 170rpx;
          height: 60rpx;
          .text_16 {
            color: #a2a2a2;
            font-size: 26rpx;
            line-height: 24.16rpx;
          }
        }
        .text-wrapper_5 {
          padding: 13.84rpx 0 22.12rpx;
          background-color: #fffcfc;
          width: 150rpx;
          height: 60rpx;
          .text_55 {
            font-size: 26rpx;
            line-height: 24.02rpx;
          }
        }
        .text-wrapper_14 {
          padding: 13.82rpx 0 22.16rpx;
          background-color: #fffcfc;
          width: 150rpx;
          height: 60rpx;
          .text_17 {
            font-size: 26rpx;
            line-height: 24.02rpx;
          }
        }
        .font_7 {
          font-size: 24rpx;
          font-family: Poppins;
          line-height: 22.72rpx;
          color: #a1a1a1;
        }
        .text-wrapper_6 {
          padding: 13.84rpx 0 22.18rpx;
          background-color: #fffcfc;
          height: 60rpx;
          .text_18 {
            margin-left: 16.98rpx;
            font-size: 26rpx;
            line-height: 23.98rpx;
          }
        }
      }
      .grid {
        padding: 0 22rpx;
        height: 583rpx;
        display: grid;
        grid-template-rows: repeat(2, minmax(0, 1fr));
        grid-template-columns: repeat(3, minmax(0, 1fr));
        row-gap: 19rpx;
        column-gap: 0;
        .grid-item_1 {
          padding: 0 4.56rpx 13.12rpx 4.56rpx;
          background-color: #ffffff;
          .text_19 {
            line-height: 22.3rpx;
          }
          .text_1 {
            margin-left: 9.68rpx;
            margin-top: 20.7rpx;
            font-size: 22rpx;
          }
          .text_57 {
            margin-top: 9.86rpx;
          }
        }
        .grid-item {
          padding: 0 4.56rpx 13.12rpx;
          background-color: #ffffff;
          .text_21 {
            line-height: 22.3rpx;
          }
          .text_56 {
            margin-left: 9.68rpx;
            margin-top: 23rpx;
            font-size: 22rpx;
          }
          .text_58 {
            margin-top: 9.86rpx;
          }
        }
        .image_11 {
          width: 176rpx;
          height: 176rpx;
        }
        .grid-item_3 {
          padding: 0 4.56rpx 13.12rpx 4.56rpx;
          background-color: #ffffff;
          .text_65 {
            line-height: 22.3rpx;
          }
          .text_61 {
            margin-left: 9.68rpx;
            margin-top: 20.7rpx;
            font-size: 22rpx;
          }
          .text_66 {
            margin-top: 9.86rpx;
          }
        }
        .grid-item_4 {
          padding: 0 2.72rpx 13.12rpx 8.38rpx;
          background-color: #ffffff;
          .text_67 {
            line-height: 22.3rpx;
          }
          .text_60 {
            margin-left: 9.68rpx;
            margin-top: 20.7rpx;
            font-size: 22rpx;
          }
          .text_63 {
            margin-top: 9.86rpx;
          }
        }
        .grid-item_5 {
          padding: 0 4.56rpx 13.12rpx;
          background-color: #ffffff;
          .text_59 {
            line-height: 22.3rpx;
          }
          .text_62 {
            margin-left: 9.68rpx;
            margin-top: 20.7rpx;
            font-size: 22rpx;
          }
          .text_64 {
            margin-top: 9.86rpx;
          }
        }
      }
    }
    .section_10 {
      padding: 9.04rpx 35rpx 32rpx;
      background-image: linear-gradient(180deg, #ffffffa6 0%, #00a651a6 67.2%);
      .group_1 {
        padding: 0 4.24rpx;
        .text_22 {
          color: #000000;
          font-size: 44rpx;
          font-family: Poppins;
          line-height: 40.66rpx;
        }
        .section_11 {
          margin-left: 37.4rpx;
          background-color: #40bc7d;
          width: 128.82rpx;
          height: 10rpx;
        }
      }
      .grid_2 {
        margin-right: 5.92rpx;
        height: 1240rpx;
        display: grid;
        grid-template-rows: repeat(3, minmax(0, 1fr));
        grid-template-columns: repeat(2, minmax(0, 1fr));
        row-gap: 22rpx;
        column-gap: 36.44rpx;
        .grid-item_2 {
          padding: 0 6.56rpx 12rpx;
          background-color: #ffffff;
          .text_23 {
            font-size: 22rpx;
          }
          .text_24 {
            margin-left: 14.68rpx;
            margin-top: 23.82rpx;
          }
          .group_6 {
            margin-top: 11.64rpx;
            .text_26 {
              margin-top: 8.2rpx;
            }
            .text_37 {
              margin-top: 8.2rpx;
            }
          }
          .text_33 {
            margin-left: 5.94rpx;
            line-height: 22.3rpx;
          }
          .text_35 {
            margin-left: 14.68rpx;
            margin-top: 38.86rpx;
          }
        }
        .grid-item_7 {
          padding: 0 6.56rpx 18rpx;
          background-color: #ffffff;
          .text_38 {
            font-size: 22rpx;
          }
          .text_25 {
            margin-left: 14.68rpx;
            margin-top: 23.82rpx;
          }
          .group_7 {
            margin-top: 5.64rpx;
          }
          .text_34 {
            margin-left: 10rpx;
            line-height: 22.3rpx;
          }
          .text_36 {
            margin-left: 14.68rpx;
            margin-top: 10rpx;
          }
        }
        .image_12 {
          width: 232rpx;
          height: 246rpx;
        }
        .button_2 {
          padding: 15.72rpx 0 14.06rpx;
          background-color: #00a651;
          border-radius: 40rpx;
          height: 52rpx;
        }
        .font_9 {
          font-size: 24rpx;
          font-family: Poppins;
          line-height: 22.72rpx;
          color: #ffffff;
        }
        .grid-item_8 {
          padding: 0 6.56rpx 20rpx;
          background-color: #ffffff;
          .text_28 {
            margin-left: 5.94rpx;
            line-height: 22.3rpx;
          }
          .text_30 {
            margin-left: 14.68rpx;
            margin-top: 38.86rpx;
            font-size: 22rpx;
          }
          .group_9 {
            margin-top: 3.64rpx;
          }
        }
        .text-wrapper_8 {
          flex: 1 1 0;
          margin-right: 12.26rpx;
          .text_27 {
            line-height: 22.22rpx;
          }
          .text_48 {
            line-height: 22.22rpx;
          }
        }
        .grid-item_9 {
          padding: 0 6.56rpx 26rpx;
          background-color: #ffffff;
          .text_29 {
            margin-left: 5.94rpx;
            line-height: 22.3rpx;
          }
          .text_31 {
            margin-left: 14.68rpx;
            margin-top: 38.86rpx;
            font-size: 22rpx;
          }
          .text_32 {
            margin-bottom: 7.1rpx;
          }
        }
        .text-wrapper_7 {
          flex: 1 1 0;
          margin-right: 16.52rpx;
          .text_41 {
            line-height: 22.22rpx;
          }
          .text_47 {
            line-height: 22.22rpx;
          }
        }
      }
    }
    .font_5 {
      font-size: 36rpx;
      font-family: Poppins;
      line-height: 33.44rpx;
      color: #000000;
    }
    .font_8 {
      font-size: 24rpx;
      font-family: Poppins;
      line-height: 20.48rpx;
      color: #7e7e7e;
    }
    .font_6 {
      font-size: 24rpx;
      font-family: Poppins;
      line-height: 22.72rpx;
      color: #000000;
    }
  }
  .font {
    font-size: 30rpx;
    font-family: Poppins;
    line-height: 22.72rpx;
    color: #fd6a00;
  }
  .group {
    overflow: scroll;
    &::-webkit-scrollbar {
      display: none;
    }
  }
}
</style>