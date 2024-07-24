<template >
<view class="flex-col page">
  <view class="flex-col">
    <view class="flex-row justify-center section_2" v-for="medicine in take_medicine_array" :key="medicine.id">
      <image
        class="image_2"
        :src="medicine.url"
      />
      <view class="flex-col self-center group ml-7-5">
        <text class="self-start text_2">{{medicine.name}}</text>
        <view class="self-stretch group_2 mt-17">
          <text class="font_2" >
            每天：{{getFormattedTimes(medicine)}},
            <br />
          </text>
          <text class="font_2">每次{{medicine.count}}{{medicine.unit}}，点击查看更多…</text>
        </view>
      </view>
      <switch
        class="switch image_3 ml-7-5" color="#009254" :checked="medicine.IS_open_remind" @change="handleSwitchChange(medicine)"
      />
    </view>
	
	</view>
	<view class="flex-col justify-start items-center text-wrapper mt-560-5" @click="add_remind()" >
	    <text class="font text_3">添加药品</text>
	  </view>
  </view>
 
</template>


<style lang="scss">
page {
  background: #eef5f2;
}
</style>

<script>
	import {take_medicine_array,getFormattedTimes} from "./take_medicine.js"
export default {
  components: {},
  props: {},
  data() {
    return {
		take_medicine_array:take_medicine_array
		
	};
  },

  methods: {
	  getFormattedTimes,
	  handleSwitchChange(medicine) {
	        // Update the IS_open_remind property when the switch changes
	        medicine.IS_open_remind = !medicine.IS_open_remind;
	      },
		  add_remind(){
			  uni.navigateTo({
			  	url:'/pages/add_medicine_remind/add_medicine_remind'
			  })
		  }
  },
};
</script>

<style scoped lang="scss">
.ml-125-5 {
  margin-left: 251.34rpx;
}
.mt-17 {
  margin-top: 34rpx;
}
.ml-7-5 {
  margin-left: 15.34rpx;
}
.mt-560-5 {
  margin-top: 1121.34rpx;
}
.page {
  background-color: red;
  width: 100%;
  overflow-y: auto;
  overflow-x: hidden;
  height: 100%;
  .section {
    padding: 40rpx 36rpx 42rpx;
    background-image: url('https://ide.code.fun/api/image?token=6561adb928456c001165ae2a&name=c0e804aef071bb2a0502dfd5628bd6ee.png');
    background-size: 100% 100%;
    background-repeat: no-repeat;
    .image {
      width: 30.66rpx;
      height: 53.34rpx;
    }
    .text {
      color: #000000;
    }
  }
  .section_2 {
    padding: 0 6.66rpx 2.66rpx;
    background-color: #ffffff;
    .image_2 {
      width: 256.66rpx;
      height: 256.66rpx;
    }
    .group {
      width: 306rpx;
      .text_2 {
        margin-left: 19.34rpx;
        color: #000000;
        font-size: 31.34rpx;
        font-family: Adobe Heiti Std;
        line-height: 29.34rpx;
      }
      .group_2 {
        line-height: 32rpx;
        .font_2 {
          font-size: 24.66rpx;
          font-family: Adobe Heiti Std;
          line-height: 32rpx;
          color: #999999;
        }
      }
    }
    .switch {
      align-self: flex-start;
      margin-top: 136.66rpx;
    }
    .image_3 {
      width: 94rpx;
      height: 46.66rpx;
    }
  }
  .text-wrapper {
    padding: 40rpx 0;
    background-color: #009254;
    height: 114.66rpx;
	position: absolute;
	bottom: 0;
	width: 100%;
    .text_3 {
      color: #ffffff;
      line-height: 32.66rpx;
    }
  }
  .font {
    font-size: 34.66rpx;
    font-family: Adobe Heiti Std;
    line-height: 32rpx;
  }
}
</style>