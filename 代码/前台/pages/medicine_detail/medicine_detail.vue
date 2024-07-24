<template>
<view class="flex-col page">
	<view class="flex-col" >
  <view class="flex-col items-center section">
    <text class="text">Ihealth</text>
    <image
      class="image mt-12-5"
      :src="img_url"
    />
  </view>
  <view class="flex-col group">
    <view class="flex-col section_2">
      <view class="flex-row items-baseline self-stretch relative group_2">
        <view class="group_3">
          <text class="font text_3">￥</text>
          <text class="text_2">23.</text>
          <text class="font_2">69</text>
        </view>
        <text class="font_2 text_4">￥33.45</text>
        <view class="section_3 pos"></view>
      </view>
      <view class="flex-row justify-between items-center self-stretch group_4">
        <view class="flex-row">
          <view class="flex-col justify-start text-wrapper"><text class="font_3 text_5">满100减10可领</text></view>
          <view class="flex-col justify-start text-wrapper ml-15"><text class="font_3 text_6">满50减4可领</text></view>
        </view>
        <view class="flex-row group_5">
          <text class="font_3">优惠</text>
          <image
            class="shrink-0 image_2"
            src="https://ide.code.fun/api/image?token=65672148fcfbac001135c898&name=82a2bf48e1c0640d7e503ccee6aa4494.png"
          />
        </view>
      </view>
      <text class="self-start font text_7">{{medicine.dname}} {{medicine.dmessage}}</text>
      <text class="self-start font_3 text_8">月售{{medicine.dsales}}</text>
      <view class="flex-row self-stretch section_4">
        <view class="shrink-0 self-center group_7">
          <text class="font_5">
            药品
            <br />
          </text>
          <text class="font_5">说明</text>
        </view>
        <view class="shrink-0 self-center relative section_6"></view>
        <view class="shrink-0 self-center group_6 view_2 textbox">
          <text class="font_5">主治功能：</text>
          <text class="font_4">
            解热镇
            <br />
            痛。用于感冒引起的
            <br />
          头疼，发热，鼻…</text>
        </view>
        <view class="shrink-0 self-center section_5 view_3"></view>
        <view class="shrink-0 self-start group_6 view textbox">
          <text class="font_4 text_9">常见用法：</text>
          <text class="font_4">
            开水冲
            <br />
          </text>
          <text class="font_4">
            服。一次10克(1
            <br />
          </text>
          <text class="font_4">袋),一日三次。</text>
        </view>
        <view class="shrink-0 self-center section_5 view_4"></view>
		<view class="shrink-0 self-start group_6 view textbox">
		  <text class="font_4 text_9">常见用法：</text>
		  <text class="font_4">
		    开水冲
		    <br />
		  </text>
		  <text class="font_4">
		    服。一次10克(1
		    <br />
		  </text>
		  <text class="font_4">袋),一日三次。</text>
		</view>
      </view>
    </view>
    <view class="flex-col section_7 mt-13-5">
      <view class="flex-row items-center group_8">
        <view class="flex-row flex-1">
          <image
            class="shrink-0 image_3"
            src="https://ide.code.fun/api/image?token=65672148fcfbac001135c898&name=ecca394d4185c3247c5f57cd0b64bf32.png"
          />
          <view class="ml-10 flex-col items-start flex-1 group_9">
            <text class="font_2 text_10">智能问诊</text>
            <text class="font_4 text_12 mt-6-5">大模型医学AI | 24小时在线 | 问诊开药</text>
          </view>
        </view>
        <view class="flex-col justify-start items-center button text-wrapper_2 ml-19-5">
          <text class="font_6 text_11">去咨询</text>
        </view>
      </view>
      <view class="flex-col justify-start text-wrapper_3">
        <text class="font_6 text_13">“请描述您的病情、症状等，将为您提供合适的药方“</text>
      </view>
    </view>
  </view>

  </view>
  
  <view class="flex-row justify-between items-center section_8" style="position: fixed;bottom: 0;width: 100%;">
    <view class="flex-col items-center">
      <image
        class="image_4"
        src="../../static/detail/药店.png"
      />
      <text class="font_8 mt-7-5">店铺</text>
    </view>
    <view class="flex-col">
      <view class="flex-row items-center group_10">
        <image
          class="image_5"
          src="../../static/detail/信息.png"
        />
        <image
          class="image_6 ml-30-5"
          src="../../static/detail/shopcar.png"
        />
      </view>
      <view class="flex-row mt-5-5">
        <text class="font_8 text_16" >问商家</text>
        <text class="font_8 text_17 ml-22-5" @click="gotoshopcar()">购物车</text>
      </view>
    </view>
    <view class="flex-row">
      <view class="flex-col justify-start items-center text-wrapper_4"  @click="toggle('bottom')">
        <text class="font_7 text_14">加入购物车</text>
      </view>
      <view class="flex-col justify-start items-center text-wrapper_5">
        <text class="font_7 text_15">立即购买</text>
      </view>
    </view>
  </view>
  <view>
  			<!-- 普通弹窗 -->
  			<uni-popup ref="popup" background-color="#fff" @change="change">
  			      <!-- 调整弹窗内容的布局 -->
  			      <view class="popup-content" :class="{ 'popup-height': type === 'left' || type === 'right' }">
  			        <!-- 弹窗头部内容 -->
  			        <view class="popup-header">
  			          <text>选择商品加入购物车</text>
  			        </view>
  			
  			        <!-- 弹窗主体内容 -->
  			        <view class="popup-body">
  			          <!-- 循环渲染商家信息 -->
  			          <view class="seller-info items-center" v-for="(seller, index) in seller_array" :key="index" @click="AddToShopcar(seller.sid)">
  			            <text style="padding-left: 30rpx;">{{seller.sname}} </text>
						<text style="color: white;font-size: 90%;float: right;margin-right: 30rpx;">价格：{{seller.dprice}} 销量：{{seller.dinventory}}</text>
  			          </view>
  			        </view>
  			      </view>
  			    </uni-popup>
  		</view>
</view>
</template>

<script>
export default {
  components: {},
  props: {},
  data() {
    return {
		medicine:{},
		img_url:'',
		seller_array:[],
		drugid:'',
		sellerid:'',
		userid:'',
	};
  },
  onLoad:function(option){
  	  console.log("drug id:",option.drugid);	
  	  this.getDrugInfo(option.drugid);
	  this.getSellerInfo(option.drugid);
  	  this.img_url='http://223.4.21.161:8081/drug/getimg?imgid='+option.drugid;
	  this.drugid=option.drugid;
	  this.userid=getApp().globalData.uid;
  },

  methods: {
	  AddToShopcar(sellid){
		  uni.request({
		  	url:'http://223.4.21.161:8081/cart/addcart?did='+this.drugid+'&sid='+sellid+'&uid='+this.userid,
			method:'POST',
			data:{
				did:this.drugid,
				sid:sellid,
				uid:this.userid,
			},
			
			success: (res) => { // 请求成功回调函数
			  console.log(res.data); // 输出返回的数据
								
			uni.showToast({title:'添加购物车成功',duration: 1500});
			},
			fail: (err) => { // 请求失败回调函数
			  console.log(err);
			uni.showToast({title:'网络请求失败',duration: 1500});
			}
		  })
	  },
	  getSellerInfo(did){
	  		  uni.request({
	  		  	url:'http://223.4.21.161:8081/drug/getsupplybyDID?DID='+did,
	  			method:'GET',
	  			
	  			success: (res) => {
	  				console.log(res.data);
	  				if(res.data.code==200)
	  				{
	  					this.seller_array=res.data.data;
	  					console.log(this.seller_array);
	  				}
	  				else
	  				{
	  					uni.showToast({
	  						title:res.data.message,duration:1500
	  					});
	  				}
	  			},
	  			fail:(err)=>{
	  				console.log(err);
	  				uni.showToast({
	  					title:'网络请求失败',duration:1500
	  				});
	  			}
	  		  });
	  },
	  toggle(type) {
	  				this.type = type
	  				// open 方法传入参数 等同在 uni-popup 组件上绑定 type属性
	  				this.$refs.popup.open(type)
	  			},
	  change(e) {
	  				console.log('当前模式：' + e.type + ',状态：' + e.show);
	  			},
	  confirmShare() {
	  				this.$refs.popupShare.open()
	  			},
	  			select(e) {
	  				uni.showToast({
	  					title: `您选择了第${e.index+1}项：${e.item.text}`,
	  					icon: 'none'
	  				})
	  			},
	  getDrugInfo(did){
	  		  uni.request({
	  		  	url:'http://223.4.21.161:8081/drug/getDrugByID?DID='+did,
	  			method:'GET',
	  			
	  			success: (res) => {
	  				console.log(res.data);
	  				if(res.data.code==200)
	  				{
	  					this.medicine=res.data.data[0];
	  					console.log(this.medicine);
	  				}
	  				else
	  				{
	  					uni.showToast({
	  						title:res.data.message,duration:1500
	  					});
	  				}
	  			},
	  			fail:(err)=>{
	  				console.log(err);
	  				uni.showToast({
	  					title:'网络请求失败',duration:1500
	  				});
	  			}
	  		  });
	  },
	  gotoshopcar(){
		  uni.switchTab({
		  	url:'/pages/index/index'
		  })
	  },
	  aiwenzhen(){
		uni.switchTab({
			url:'/pages/AI/ai'
		})
	  }
  },
};
</script>

<style scoped lang="scss">
.popup-content {
  /* 调整弹窗内容的样式 */
  padding: 20px;
  border-radius: 10px;
}

.popup-height {
  /* 如果是上下位置的弹窗，可以设置高度 */
  height: 80vh; /* 80% 的视口高度，根据需要调整 */
}

.popup-header {
  /* 弹窗头部样式 */
  text-align: center;
  margin-bottom: 10px;
}

.popup-body {
  /* 弹窗主体样式 */
}

.seller-info {
  /* 商家信息样式 */
  margin-bottom: 10px;
  padding: 25.34rpx 0;
  background-color: #f0af66;
  border-radius: 40rpx 40rpx 40rpx 40rpx;
}

.mt-12-5 {
  margin-top: 25.34rpx;
}
.ml-15 {
  margin-left: 30rpx;
}
.mt-13-5 {
  margin-top: 27.34rpx;
}
.mt-6-5 {
  margin-top: 13.34rpx;
}
.ml-19-5 {
  margin-left: 39.34rpx;
}
.mt-7-5 {
  margin-top: 15.34rpx;
}
.ml-30-5 {
  margin-left: 61.34rpx;
}
.mt-5-5 {
  margin-top: 11.34rpx;
}
.ml-22-5 {
  margin-left: 45.34rpx;
}
.page {
  background-color: #eff5f3;
  width: 100%;
  overflow-y: auto;
  overflow-x: hidden;
  height: 100%;
  .section {
    padding: 14.66rpx 0 22.66rpx;
    background-color: #009254;
    .text {
      color: #ffffff;
      font-size: 53.34rpx;
      font-family: Berlin Sans FB Demi;
      font-weight: 700;
      line-height: 38rpx;
    }
    .image {
      border-radius: 33.34rpx;
      width: 94.4889vw;
      height: 86.3111vw;
    }
  }
  .group {
    padding: 22rpx 18.66rpx 36rpx;
	height: 900rpx;
    .section_2 {
      padding: 38.66rpx 18.66rpx 29.34rpx 22rpx;
      border-radius: 26.66rpx;
      background-image: url("../../static/e7812405ed08e16abdbe5b4c08352e11.png");
      background-size: 100% 100%;
      background-repeat: no-repeat;
      .group_2 {
        padding: 0 13.34rpx;
        .group_3 {
          height: 41.34rpx;
          .text_3 {
            color: #ffffff;
            line-height: 30rpx;
          }
          .text_2 {
            color: #ffffff;
            font-size: 53.34rpx;
            font-family: Adobe Heiti Std;
            line-height: 41.34rpx;
          }
        }
        .text_4 {
          margin-left: 19.34rpx;
          opacity: 0.5;
        }
        .section_3 {
          background-color: #ffffff80;
          width: 117.34rpx;
          height: 3.34rpx;
        }
        .pos {
          position: absolute;
          left: 186.66rpx;
          top: 30rpx;
        }
      }
      .group_4 {
        margin-top: 41.34rpx;
        .text-wrapper {
          padding: 13.34rpx 0;
          background-color: #fff5f5;
          height: 48.66rpx;
          .text_5 {
            margin-left: 18rpx;
            margin-right: 13.34rpx;
          }
          .text_6 {
            margin-left: 18.66rpx;
            margin-right: 16rpx;
          }
        }
        .group_5 {
          margin-right: 26rpx;
          .image_2 {
            width: 24rpx;
            height: 24rpx;
          }
        }
      }
      .font {
        font-size: 40rpx;
        font-family: Adobe Heiti Std;
      }
      .text_7 {
        margin-left: 13.34rpx;
        margin-top: 27.34rpx;
        color: #020202;
        line-height: 38rpx;
      }
      .font_3 {
        font-size: 24rpx;
        font-family: Adobe Heiti Std;
        line-height: 22.66rpx;
        color: #e7470d;
      }
      .text_8 {
        margin-left: 18rpx;
        margin-top: 20rpx;
        color: #adadad;
      }
      .section_4 {
        margin-top: 22.66rpx;
        padding: 18.66rpx 22.66rpx 22rpx;
        background-color: #f9fafc;
        border-radius: 16.66rpx;
		overflow: scroll;
		&::-webkit-scrollbar {
		  display: none;
		}
		.textbox{
			width:225rpx;
			height: 82rpx;
		}
        .group_7 {
          line-height: 27.34rpx;
          height: 54.66rpx;
        }
        .section_6 {
          margin-left: 19.34rpx;
          background-color: #c0c0c0;
          box-shadow: 0.52rpx -0.42rpx 1.74rpx 0.26rpx #99a19eb8;
          width: 1.34rpx;
          height: 88rpx;
        }
        .group_6 {
          line-height: 27.34rpx;
          height: 82rpx;
          .text_9 {
            color: #010101;
          }
        }
        .view_2 {
          margin-left: 14.66rpx;
        }
        .font_5 {
          font-size: 25.34rpx;
          font-family: Adobe Heiti Std;
          line-height: 27.34rpx;
          color: #000000;
        }
        .section_5 {
          background-color: #828385;
          width: 0.66rpx;
          height: 91.34rpx;
        }
        .view_3 {
          margin-left: 12rpx;
        }
        .view {
          margin-left: 18.66rpx;
        }
        .view_4 {
          margin-left: 14.66rpx;
        }
      }
    }
    .section_7 {
      padding: 0 18.66rpx 16.66rpx;
      background-image: linear-gradient(180deg, #f2fefc 0%, #ffffff 100%);
      border-radius: 26.66rpx;
      .group_8 {
        padding: 21.34rpx 0 26rpx;
        .image_3 {
          width: 85.34rpx;
          height: 74rpx;
        }
        .group_9 {
          margin-top: 2.66rpx;
          .text_10 {
            color: #000000;
            line-height: 31.34rpx;
          }
          .text_12 {
            color: #818382;
            font-size: 24.66rpx;
            line-height: 28rpx;
          }
        }
        .button {
          flex-shrink: 0;
          margin-right: 5.34rpx;
          .text_11 {
            color: #ffffff;
            font-size: 24.66rpx;
          }
        }
        .text-wrapper_2 {
          padding: 13.34rpx 0;
          background-color: #03d2af;
          border-radius: 25.34rpx;
          width: 116.66rpx;
          height: 50.66rpx;
        }
      }
      .text-wrapper_3 {
        margin: 0 13.34rpx;
        padding: 10.66rpx 0 14rpx;
        background-color: #edfdfc;
        border-radius: 13.34rpx;
        .text_13 {
          margin-left: 22.66rpx;
          margin-right: 36rpx;
          color: #09a087;
          font-size: 24.66rpx;
        }
      }
      .font_6 {
        font-size: 25.34rpx;
        font-family: Adobe Heiti Std;
        line-height: 24rpx;
      }
    }
    .font_2 {
      font-size: 33.34rpx;
      font-family: Adobe Heiti Std;
      line-height: 26rpx;
      color: #ffffff;
    }
    .font_4 {
      font-size: 25.34rpx;
      font-family: Adobe Heiti Std;
      line-height: 27.34rpx;
      color: #828385;
    }
  }
  .section_8 {
    padding: 19.34rpx 21.34rpx 25.34rpx 35.34rpx;
    background-color: #ffffff;
    .image_4 {
      width: 46.66rpx;
      height: 42.66rpx;
    }
    .font_8 {
      font-size: 21.34rpx;
      font-family: Adobe Heiti Std;
      line-height: 20rpx;
      color: #4d4c4c;
    }
    .group_10 {
      padding: 0 5.34rpx;
      .image_5 {
        width: 46.66rpx;
        height: 46.66rpx;
      }
      .image_6 {
        width: 46.66rpx;
        height: 40.66rpx;
      }
    }
    .text_16 {
      line-height: 19.34rpx;
    }
    .text_17 {
      line-height: 20.66rpx;
    }
    .text-wrapper_4 {
      padding: 25.34rpx 0;
      background-color: #000000;
      border-radius: 40rpx 0rpx 0rpx 40rpx;
      width: 193.34rpx;
      height: 80rpx;
      .text_14 {
        color: #efc08e;
        line-height: 29.34rpx;
      }
    }
    .text-wrapper_5 {
      padding: 25.34rpx 0;
      background-color: #f1ae67;
      border-radius: 0rpx 40rpx 40rpx 0rpx;
      width: 162rpx;
      height: 80rpx;
      .text_15 {
        color: #ffffff;
        line-height: 28.66rpx;
      }
    }
    .font_7 {
      font-size: 30.66rpx;
      font-family: Adobe Heiti Std;
    }
  }
}
</style>