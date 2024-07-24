<template>
  <view class="content">
	<view class="dtitle">
		<text>大数据分析</text>
	</view>
	
    <view class="charts-box1">
		<view class="boxtitle">
			<view class="title-left">
				<text></text>
			</view>
			<view class="title-right">
				<text>流行病预测</text>
			</view>
		</view>
       <qiun-data-charts 
         type="rose"
         :opts="opts1"
         :chartData="chartData"
       />
     </view>
   
    <view class="charts-box2" >
		<view class="boxtitle">
			<view class="title-left">
				<text></text>
			</view>
			<view class="title-right">
				<text>疾病分布</text>
			</view>
		</view>
      <qiun-data-charts type="map" :opts="opts2" :chartData="chartsDataMap1" />
    </view>
  </view>
</template>

<script>
//下面是演示数据，您的项目不需要引用，数据需要您从服务器自行获取

import mapdata from '@/mockdata/mapp.json'

export default {
  data() {
    return {
	chartData: {},
    chartsDataMap1:{},
	
	opts1:{
		color: ["#1890FF","#91CB74","#FAC858","#EE6666","#73C0DE","#3CA272","#FC8452","#9A60B4","#ea7ccc"],
		fontColor: '#ffffff',
				padding: [5,5,5,5],
		        enableScroll: false,
		        legend: {
		          show: true,
		          position: "left",
		          lineHeight: 25
		        },
		        extra: {
		          rose: {
		            type: "radius",
		            minRadius: 50,
		            activeOpacity: 0.5,
		            activeRadius: 10,
		            offsetAngle: 0,
		            labelWidth: 15,
		            border: true,
		            borderWidth: 2,
		            borderColor: "#FFFFFF",
		            linearType: "custom"
		          }
		        }
	},
	
	
	opts2: {
			fontSize:10,
			fontColor: '#ffffff',
	        color: ['#fe9e00','#0260c8','#0260c8','#0260c8','#0260c8','#0260c8','#0260c8','#0260c8','#0260c8','#0260c8','#0260c8','#0260c8'],
	        enableScroll: false,
	        extra: {
	          map: {
				
	            border: true,
	            borderWidth: 0.3,
	            borderColor:"#000000",
	            fillOpacity: 1,
	            activeBorderColor: "#ffffff",
	            activeFillColor: "#FACC14",
				activeTextColor:'#ffffff',
	            activeFillOpacity: 1
	          }
	        }
	      }
    };
  },
  onReady() {
    //模拟从服务器获取数据
    this.getServerData()
  },
  methods: {
    getServerData() {
      setTimeout(() => {
		let res1={series:[{data:[{"name":"流感","value":50},{"name":"肺炎","value":20},{"name":"水痘","value":5},{"name":"疟疾","value":15},{"name":"登革热","value":15}]}]}
		this.chartData = JSON.parse(JSON.stringify(res1));
      	this.chartsDataMap1={series:mapdata.features}

      }, 500);
    }
  }
};
</script>

<style>
.content {
  display: flex;
  flex-direction: column;
  flex: 1;
  background-color: #101940;
}
.boxtitle{
	display: flex;
	flex-direction: row;
	height: 110rpx;
}
.title-left{
	width: 20rpx;
	margin-top: 30rpx;
	margin-left: 40rpx;
	border-radius: 20rpx;
	background-color: #0075f5;
}
.title-right{
	padding-left: 20rpx;
	padding-top: 45rpx;
	width: 200rpx;
	
	color: #ffffff;
}
.dtitle{
	margin-top: 40rpx;
	text-align: center;
	font-size: 50rpx;
	color: white;
}
.charts-box1{
	margin: 20rpx;
	margin-top: 50rpx;
	background-color: #14204a;
	border-radius: 10rpx;
}
.charts-box2 {
	
	margin: 20rpx;
	background-color: #14204a;
	
	
	border-radius: 10rpx;
}
</style>
