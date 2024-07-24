<template>
	<view>
		
		<view id="_drag_button" class="drag" :style="{top:top+'px',left:left+'px',opacity:firstIn?1:0}"
			@touchstart="touchstart" @touchmove.stop.prevent="touchmove" @touchend="touchend"
			@click.stop.prevent="click" :class="{transition: isDock && !isMove }">
			<button class="btn" open-type="contact" style="border: none;padding: 0;margin: 0;">
				<image class="img"
					src="../static/右.png">
				</image>
			</button>
		</view>
	</view>
</template>

<script>
	export default {
		name: 'drag-button',
		props: {
			isDock: {
				type: Boolean,
				default: false
			},
			existTabBar: {
				type: Boolean,
				default: false
			}
		},
		data() {
			return {
				top: 0,
				left: 0,
				width: 0,
				height: 0,
				offsetWidth: 0,
				offsetHeight: 0,
				windowWidth: 0,
				windowHeight: 0,
				isMove: true,
				edge: 10,
				text: ' ',
				firstIn: false
			}
		},
		onShow() {
			//获取手机信息配置接口
			const sys = uni.getSystemInfoSync();
			//屏幕的宽高
			this.windowWidth = sys.windowWidth;
			this.windowHeight = sys.windowHeight;
			// #ifdef APP-PLUS
			this.existTabBar && (this.windowHeight -= 50);
			// #endif
			if (sys.windowTop) {
				this.windowHeight += sys.windowTop;
			}
			//获取元素
			const query = uni.createSelectorQuery().in(this);
			query.select('#_drag_button').boundingClientRect(data => {
				console.log(data);
				this.width = data.width;
				this.height = data.height;
				this.offsetWidth = data.width / 2;
				this.offsetHeight = data.height / 2;
				// this.left = this.windowWidth - this.width - this.edge;
				// this.top = this.windowHeight - this.height - this.edge;
				this.left = uni.getStorageSync('left')
				this.top=uni.getStorageSync('top')
				this.$nextTick(() => {
					this.firstIn = true
				})
			}).exec();
		},
		methods: {
			click() {
				this.$emit('btnClick');
			},
			touchstart(e) {
				this.$emit('btnTouchstart');
			},
			touchmove(e) {
				// 单指触摸
				if (e.touches.length !== 1) {
					return false;
				}
				console.log('移动',e);
				this.isMove = true;

				this.left = e.touches[0].clientX - this.offsetWidth;

				let clientY = e.touches[0].clientY - this.offsetHeight;
				// #ifdef H5
				clientY += this.height;
				// #endif
				let edgeBottom = this.windowHeight - this.height - this.edge;

				// 上下触及边界
				if (clientY < this.edge) {
					this.top = this.edge;
				} else if (clientY > edgeBottom) {
					this.top = edgeBottom;
				} else {
					this.top = clientY
				}
				 uni.setStorageSync("top", this.top);

			},
			touchend(e) {
				if (this.isDock) {
					let edgeRigth = this.windowWidth - this.width - this.edge;

					if (this.left < this.windowWidth / 2 - this.offsetWidth) {
						this.left = this.edge;
					} else {
						this.left = edgeRigth;
					}

				}
				 uni.setStorageSync("left", this.left);
				this.isMove = false;

				this.$emit('btnTouchend');
			},
		}
	}
</script>

<style lang="scss">
	.drag {
		
		justify-content: center;
		align-items: center;
		width: 180rpx;
		height: 135rpx;
		border-radius: 50%;
		font-size: $uni-font-size-sm;
		position: fixed;
		z-index: 999999;
background-color: blue;
		&.transition {
			transition: left .3s ease, top .3s ease;
		}
	}

	.btn {
		// background-color: transparent;
		width: 135rpx;
		height: 130rpx;
		border-radius: 50%;
		z-index: 9999;
	}

	button::after {
		border: none;
	}

	.img {
		border-radius: 50%;
		height: 100%;
		width: 100%;
	}
</style>

