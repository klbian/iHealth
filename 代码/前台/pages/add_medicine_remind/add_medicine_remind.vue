<template>
    <view class="flex-col page">
      <view class="flex-col">
        <view class="flex-col section">
          <view class="flex-row items-center">
            <image
              class="image"
              src="../../static/mine_menu/添加药品.png"
            />
            <view class="flex-col flex-1 group ml-10-5">
              <view class="flex-row items-center self-stretch group_2">
                <text class="font text_2">药品名称</text>
                <text class="ml-14 font text">999感冒灵</text>
              </view>
              <view class="self-end section_2"></view>
              <view class="flex-row justify-between items-center self-stretch group_3">
                <view class="flex-row">
                  <text class="self-center font">药品用量</text>
                  <input class="self-start font text_3 ml-41"></input>
                </view>
                <picker  :range="unitData" mode="selector" @change="unitDataChange" @cancel="cancelSelect" class="flex-row group_4">
                <view class="flex-row group_4">
                  <text class="self-center font text_4">单位  </text>
                  <text class="self-end font ml-30-5">{{selectedUnit}}</text>
                </view>
                </picker>
              </view>
            </view>
          </view>
          <view class="flex-col items-end">
            <view class="section_3"></view>
            <view class="section_4"></view>
          </view>
        </view>
        <view class="flex-row items-center group_5">
          <text class="font_2 text_5">服药时间</text>
          <view v-if="selectTimeArray.length > 0" class="flex-col justify-start items-center text-wrapper_2"  v-for="(time, index) in selectTimeArray" :key="index">
		  <picker :value="selectedTimes[index]"  v-model="selectedTimes[index]" @change="handlePickerChange(index)" @cancel="handleCancel(index)" mode="time" class="font_3 text_6">
			  <text class="font_3 text_6">{{time}}</text>
			  </picker>
			  </view>
		  <picker mode="time" @change="bindTimeChange ">
          <view class="flex-col justify-start items-center text-wrapper_2"><text class="font_3 text_6">+</text></view>
		  </picker>
        </view>
      </view>
      <view class="flex-col items-start view">
        <view class="divider"></view>
        <view class="flex-row items-center group_7">
          <text class="font_2 text_7">重复</text>
		  <picker mode="date" :value="date" :start="startDate" :end="endDate" @change="bindDateChange" class="flex-row shrink-0 group_8">
          <view class="flex-row shrink-0 group_8">
            <text class="font_3">{{stardate}}</text>
            <image
              class="shrink-0 image_2 ml-2-5"
              src="../../static/mine_menu/下箭头.png"
            />
          </view>
		 </picker>
		 <picker mode="date" :value="date" :start="startDate" :end="endDate" @change="bindDate2Change" class="flex-row shrink-0 group_8">
          <view class="flex-row shrink-0 group_9">
            <text class="font_3">{{selectedEndDate}}</text>
            <image
              class="shrink-0 image_2 ml-2-5"
              src="../../static/mine_menu/下箭头.png"
            />
          </view>
		  </picker>
        </view>
      </view>
      <view class="flex-col items-start view_2">
        <view class="divider"></view>
        <text class="font_2 text_8">备注</text>
        <input class="font_3 text_9"></input>
      </view>
      <view class="flex-col justify-start items-center text-wrapper_3"><text class="text_10">保存信息</text></view>
    </view>
    </template>
    
    <script>
    export default {
      components: {},
      props: {},
      data() {
		   const currentDate = this.getDate({
		              format: true
		          });
		const currentDateObj = new Date(); // 获取当前日期
		currentDateObj.setDate(currentDateObj.getDate() + 15); // 加上15天
				  
		const selectEndDate = currentDateObj.toISOString().slice(0, 10); // 格式化为 YYYY-MM-DD 形式

        return {
			TodayDate:"",
            unitData:["组","mg","ml","l","片","粒","丸","袋","滴","喷","ug","瓶","其他"],
			selectedUnit:"",
			stardate:currentDate,
			selectedEndDate:selectEndDate,
			selectTimeArray:[],
			 selectedTimes: [], // 存储每个时间的选择
			Inputbeizhu:"",
			InputCount:"",
			
        };
      },
	  computed: {
	          startDate() {
	              return this.getDate('start');
	          },
	          endDate() {
	              return this.getDate('end');
	          }
	      },
    
      methods: {
	handlePickerChange(index) {
	      // 处理 picker 值改变事件，更新 selectedTimes 数组
	      // 可以使用 this.$set 方法确保响应性
	      this.$set(this.selectedTimes, index, /* 新的选择的时间值 */);
	    },
	handleCancel(index) {
      // 处理取消选择事件，从数组中删除相应的时间
      this.selectTimeArray.splice(index, 1);
      this.selectedTimes.splice(index, 1);
    },
         //点击按钮的时候触发，
	  unitDataChange(e){
		  const val = e.detail.value;
		  this.selectedUnit = this.unitData[val];
	      console.log(this.selectedUnit);
	  },
	  cancelSelect(e){
		  console.log("您已取消选择");
	  },
	   bindDateChange: function(e) {
	              this.stardate = e.detail.value
	          },
		bindDate2Change: function(e) {
			        this.selectedEndDate = e.detail.value
			},
		bindTimeChange: function(e) {
		    const selectedTime = e.detail.value;		    
		    // 将选择的时间追加到数组中
		    this.selectTimeArray.push(selectedTime);
			},
		
	  getDate(type) {
	              const date = new Date();
	              let year = date.getFullYear();
	              let month = date.getMonth() + 1;
	              let day = date.getDate();
	  
	              if (type === 'start') {
	                  year = year;
	              } else if (type === 'end') {
	                  year = year + 2;
	              }
	              month = month > 9 ? month : '0' + month;
	              day = day > 9 ? day : '0' + day;
	              return `${year}-${month}-${day}`;
	          }
      },
	  mounted() {
	      // 在组件挂载时初始化 selectedTimes 数组，可以使用当前时间
	      this.selectedTimes = Array(this.selectTimeArray.length).fill(/* 初始时间值，比如当前时间 */);
	    },
    };
    </script>
    
    <style scoped lang="scss">
    .ml-10-5 {
      margin-left: 21.34rpx;
    }
    .ml-41 {
      margin-left: 100rpx;
	  width: 60rpx;
    }
    .ml-30-5 {
      margin-left: 0;
    }
    .ml-2-5 {
      margin-left: 5.34rpx;
    }
    .page {
      background-color: #eff5f3;
      width: 100%;
      overflow-y: auto;
      overflow-x: hidden;
      height: 100%;
      .section {
        padding: 50rpx 25.34rpx 66rpx 32rpx;
        background-color: #009254;
        .image {
          width: 145.34rpx;
          height: 144.66rpx;
        }
        .group {
          margin-right: 2.66rpx;
          .group_2 {
            padding-bottom: 19.34rpx;
            .text_2 {
              line-height: 29.34rpx;
            }
            .text {
              line-height: 29.34rpx;
            }
          }
          .section_2 {
            background-color: #ffffff;
            width: 392rpx;
            height: 1.34rpx;
          }
          .group_3 {
            padding: 37.34rpx 2rpx 0;
            .text_3 {
              line-height: 23.34rpx;
            }
            .group_4 {
              margin-right: 32rpx;
			  width: 150rpx;
              .text_4 {
                line-height: 30rpx;
				margin-right: 30rpx;
				
              }
            }
          }
          .font {
            font-size: 31.34rpx;
            font-family: Adobe Heiti Std;
            line-height: 28.66rpx;
            color: #ffffff;
          }
        }
        .section_3 {
          margin-right: 214.66rpx;
          background-color: #ffffff;
          width: 180rpx;
          height: 1.34rpx;
        }
        .section_4 {
          background-color: #ffffff;
          width: 106.66rpx;
          height: 1.34rpx;
        }
      }
      .group_5 {
        padding: 37.34rpx 40rpx 0;
        .text_5 {
          line-height: 28rpx;
        }
        .text-wrapper {
          margin-left: 28.66rpx;
          padding: 17.34rpx 0 18rpx;
          border-radius: 10rpx;
		  border: 4rpx solid #d0d0d0;
          background-size: 100% 100%;
          background-repeat: no-repeat;
          width: 114rpx;
          height: 58.66rpx;
        }
        .text-wrapper_2 {
          margin-left: 20rpx;
          padding: 19.34rpx 0 20.66rpx;
          border-radius: 6.66rpx;
          border-radius: 10rpx;
          border: 4rpx solid #d0d0d0;
          background-size: 100% 100%;
          background-repeat: no-repeat;
          width: 114rpx;
          height: 58.66rpx;
          .text_6 {
            line-height: 18.66rpx;
          }
        }
      }
      .view {
        margin-left: 12.66rpx;
        margin-top: 46rpx;
        overflow-x: hidden;
        .group_7 {
          margin-left: 31.34rpx;
          padding-top: 39.34rpx;
          .text_7 {
            line-height: 28rpx;
          }
          .group_8 {
            margin-left: 34.66rpx;
          }
          .group_9 {
            margin-left: 46rpx;
          }
          .image_2 {
            width: 30rpx;
            height: 20rpx;
          }
        }
      }
      .font_2 {
        font-size: 30rpx;
        font-family: Adobe Heiti Std;
        line-height: 28.66rpx;
        color: #999999;
      }
      .font_3 {
        font-size: 30rpx;
        font-family: Adobe Heiti Std;
        line-height: 23.34rpx;
        color: #616161;
      }
      .view_2 {
        margin-left: 14rpx;
        margin-top: 61.34rpx;
        padding-bottom: 842rpx;
        overflow-x: hidden;
        .text_8 {
          margin-left: 30.66rpx;
          margin-top: 25.34rpx;
        }
        .text_9 {
          margin-left: 62.66rpx;
          margin-top: 21.34rpx;
          line-height: 28rpx;
        }
      }
      .divider {
        background-color: #c3c1c1;
        width: 2206rpx;
        height: 2rpx;
      }
      .text-wrapper_3 {
        padding: 41.34rpx 0 63.34rpx;
        background-color: #009254;
        .text_10 {
          color: #ffffff;
          font-size: 34.66rpx;
          font-family: Adobe Heiti Std;
          line-height: 33.34rpx;
        }
      }
    }
    </style>