<template>
  <div>
    <el-card style="margin: 10px 0">
      <span style="font-size: 18px; margin-right: 20px">分类</span>
      <el-select
        v-model="value"
        filterable
        placeholder="请选择"
        @change="getList"
      >
        <el-option
          v-for="item in varietyList"
          :key="item.code"
          :label="item.name"
          :value="item.code"
        >
        </el-option>
      </el-select>
    </el-card>
    <el-card>
      <div v-show="isShowTable">
        <!-- 添加按钮 -->
        <el-button
          type="primary"
          icon="el-icon-plus"
          :disabled="variety === ''"
          @click="isShowTable = false"
          >添加商品</el-button
        >
        <!-- 列表 -->
        <el-table :data="tableData" stripe style="width: 100%">
          <el-table-column
            type="index"
            label="序号"
            width="100"
            align="center"
          ></el-table-column>
          <el-table-column prop="name" label="商品名称"></el-table-column>
          <el-table-column prop="promote" label="状态" align="center">
            <template slot-scope="{ row }">
              <el-tag size="medium" v-if="row.promote === 1">推荐</el-tag>
              <el-tag size="medium" v-if="row.promote === 0" type="info"
                >普通</el-tag
              >
            </template>
          </el-table-column>
          <el-table-column prop="icon" label="图标" width="140">
            <!-- <template slot-scope="{ row }">
              <img
                :src="'http://111.229.3.64:8442/goodsInfo/getGoodImages?code=' +getGoodsImgList(row)"
                alt=""
                width="60px"
                height="60px"
              /> -->
              <template slot-scope=scope>
              <img
                :src="scope.row.icon"
                alt=""
                width="60px"
                height="60px"
              />
            </template>
          </el-table-column>
          <el-table-column
            prop="retail"
            label="售价"
            width="120"
          ></el-table-column>
          <el-table-column prop="operate" label="操作" width="300">
            <template slot-scope="{ row }">
              <el-tooltip
                content="上架"
                effect="light"
                placement="bottom-start"
                v-if="row.isSale === 0"
              >
                <el-button
                  size="mini"
                  icon="el-icon-sort-up"
                  type="success"
                  @click="sale"
                ></el-button>
              </el-tooltip>
              <el-tooltip
                content="下架"
                effect="light"
                placement="bottom-start"
                v-else
              >
                <el-button
                  size="mini"
                  icon="el-icon-sort-down"
                  type="success"
                  @click="cancle"
                ></el-button>
              </el-tooltip>
              <el-tooltip
                content="编辑"
                effect="light"
                placement="bottom-start"
              >
                <el-button
                  size="mini"
                  icon="el-icon-edit"
                  type="primary"
                  @click="isShowTable = false"
                ></el-button>
              </el-tooltip>
              <el-tooltip
                content="详情"
                effect="light"
                placement="bottom-start"
              >
                <el-button
                  size="mini"
                  icon="el-icon-info"
                  type="info"
                  @click="getInf(row)"
                ></el-button>
              </el-tooltip>
              <el-tooltip
                content="删除"
                effect="light"
                placement="bottom-start"
              >
                <el-button
                  size="mini"
                  icon="el-icon-delete"
                  type="danger"
                  @click="open(row)"
                ></el-button>
              </el-tooltip> </template
          ></el-table-column>
        </el-table>
        <img :src="goodsLogo" alt="" srcset="" />
        <!-- 分页器 -->
        <el-pagination
          layout="prev, pager, next"
          :total="total"
          style="margin-top: 20px; text-align: center"
          :hideOnSinglePage="true"
          :current-page="page"
          :page-size="limit"
          @current-change="handleCurrentChange"
        >
        </el-pagination>
      </div>
      <div v-show="!isShowTable">
        <el-form ref="form" label-width="80px">
          <el-form-item label="品种">
            <el-select
              placeholder="请选择品种"
              v-model="form.category"
              filterable
            >
              <el-option
                v-for="item in varietyList"
                :key="item.code"
                :label="item.name"
                :value="item.code"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="商品名称">
            <el-input
              placeholder="请输入商品名称"
              v-model="form.name"
            ></el-input>
          </el-form-item>
          <el-form-item label="成本">
            <el-input placeholder="请输入成本价" v-model="form.cost"></el-input>
          </el-form-item>
          <el-form-item label="售价">
            <el-input
              placeholder="请输入销售价"
              v-model="form.retail"
            ></el-input>
          </el-form-item>
          <el-form-item label="规格">
            <el-input placeholder="请输入规格" v-model="form.specs"></el-input>
          </el-form-item>
          <el-form-item label="库存">
            <el-input
              placeholder="请输入库存"
              v-model="form.inventory"
            ></el-input>
          </el-form-item>
          <el-form-item label="推荐">
            <el-switch
              active-value="1"
              inactive-value="0"
              v-model="form.promote"
            ></el-switch>
          </el-form-item>
          <el-form-item label="描述">
            <el-input type="textarea" rows="4" v-model="form.detail"></el-input>
          </el-form-item>
          <el-form-item label="图片">
            <el-upload
              action="https://jsonplaceholder.typicode.com/posts/"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove"
            >
              <i class="el-icon-plus"></i>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible">
              <img width="100%" :src="dialogImageUrl" alt="" />
            </el-dialog>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="addGoods">保存</el-button>
            <el-button @click="isShowTable = true">取消</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-card>
    <!-- 抽屉 -->
    <el-drawer :visible.sync="showDrawer" :show-close="false" size="50%">
      <el-row>
        <el-col :span="5">商品名称</el-col>
        <el-col :span="16">{{ goodsDetail.name }}</el-col>
      </el-row>
      <el-row>
        <el-col :span="5">成本价</el-col>
        <el-col :span="16">{{ goodsDetail.cost }}</el-col>
      </el-row>
      <el-row>
        <el-col :span="5">销售价</el-col>
        <el-col :span="16">{{ goodsDetail.retail }}</el-col>
      </el-row>
      <el-row>
        <el-col :span="5">规格</el-col>
        <el-col :span="16">{{ goodsDetail.specs }}</el-col>
      </el-row>
      <el-row>
        <el-col :span="5">描述</el-col>
        <el-col :span="16">{{ goodsDetail.detail }}</el-col>
      </el-row>
      <el-row>
        <el-col :span="5">商品图片</el-col>
        <el-col :span="16">
          <el-carousel height="150px">
            <el-carousel-item v-for="item in 4" :key="item">
              <h3 class="small">{{ item }}</h3>
            </el-carousel-item>
          </el-carousel></el-col
        >
      </el-row>
    </el-drawer>
  </div>
</template>

<script>
import { getGoodsImgList } from "@/api/project/showGoods";
export default {
  data() {
    return {
      // 抽屉
      showDrawer: false,
      // 当前品种
      variety: "1",
      varietyList: [
        {
          code:1,
          name:'心脑血管'
        },
        {
          code:2,
          name:'女性健康'
        },
        {
          code:3,
          name:'儿童用药'
        },
        {
          code:4,
          name:'呼吸哮喘'
        },
        {
          code:4,
          name:'养生保健'
        },
        {
          code:4,
          name:'男性健康'
        },
        {
          code:4,
          name:'肠胃用药'
        },
        {
          code:4,
          name:'皮肤用药'
        },

      ],
      value: "",
      goodsList: [
      ],
      // 分页器当前页码
      page: 1,
      // 分页器每一页数量
      limit: 4,
      // 分页器元素总数
      total: 0,
      tableData: [
        {
          name:'999感冒灵',
          promote:1,
          icon: require('@/static/1.jpg'),
          retail: 30,
        },
        {
          name:'川贝枇杷糖浆',
          promote:1,
          icon: require('@/static/2.jpg'),
          retail: 23,
        },
        {
          name:'小柴胡颗粒',
          promote:1,
          icon: require('@/static/3.jpg'),
          retail: 19,
        },







      ],
      // 表单的显示与隐藏
      isShowTable: true,
      // 上传图片相关属性
      dialogImageUrl: "",
      dialogVisible: false,
      // 商品详情
      goodsDetail: { },
      goodsLogo: "",
      // 添加商品表单
      form: {
        category: "",
        city: "",
        code: "",
        cost: null,
        detail: "",
        inventory: null,
        name: "",
        promote: null,
        retail: null,
        salesmethod: null,
        specs: "",
        supplier: "",
      },
      // 商品图片
      goodsImg: [],
    };
  },
  mounted() {
    this.getVariety();
  },
  methods: {
    // 获取品种
    async getVariety() {
      let result = await this.$API.addVariety.reqVarietyList();
      for (var i = 0; i < result.data.length; i++)
        this.varietyList.push(result.data[i]);
    },
    getPageList() {
      let l = (this.page - 1) * this.limit;
      let r = l + this.limit;
      this.tableData = this.goodsList.slice(l, r);
    },
    // 获取商品列表
    async getList(val) {
      this.variety = val;
      let result = await this.$API.showGoods.reqGoodsList(val);
      if (result.code === "1") {
        this.goodsList = result.data;
        this.total = this.goodsList.length;
        this.getPageList();
      }
    },
    // 获取商品图片
    async getGoodsImgList(row) {
      let result = await this.$API.addGoods.getGoodsImgList(row.code);
      if (result.code === "1") {
        this.goodsImg = result.data;
        return this.goodsImg[0];
      }
    },

    // 添加商品
    async addGoods() {
      this.isShowTable = true;
      let result = await this.$API.showGoods.addGoods(this.form);
      if (result.code === "1") {
        this.getList(this.variety);
        this.$message({
          type: "success",
          message: "添加成功!",
        });
      }
    },
    handleCurrentChange(pager) {
      this.page = pager;
      this.getPageList();
    },
    async sale() {
      this.isSale = 1;
      this.$message({ type: "success", message: "上架成功" });
    },
    async cancle() {
      this.isSale = 0;
      this.$message({ type: "success", message: "下架成功" });
    },
    // 上传图片相关方法
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    // 获取商品详情
    async getInf(row) {
      console.log(row);
      let result = await this.$API.showGoods.reqDetial(row.code);
      if (result.code === "1") {
        this.goodsDetail = result.data;
      }
      this.showDrawer = true;
    },
    open(row) {
      this.$confirm("此操作将永久删除该商品, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(async () => {
          let result = await this.$API.showGoods.delGoods(row.code);
          if (result.code === "1") {
            this.getList(this.variety);
            this.$message({
              type: "success",
              message: "删除成功!",
            });
          }
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
  },
};
</script>

<style>
.el-row .el-col-5 {
  font-size: 18px;
  text-align: right;
  font-weight: bolder;
}
.el-col {
  margin: 30px 10px;
}
/* 轮播器样式 */
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>