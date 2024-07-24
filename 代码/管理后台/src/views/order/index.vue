<template>
  <div>
    <el-card style="margin: 10px 0">
      <span style="font-size: 18px; margin-right: 20px">筛选订单状态</span>
      <el-select v-model="selectValue" filterable placeholder="全部">
        <el-option v-for="item in List" :key="item" :label="item" :value="item">
        </el-option>
      </el-select>
      <span style="font-size: 18px; margin-right: 20px; margin-left: 50px"
        >搜索</span
      >
      <el-input placeholder="请输入订单编号" style="width: 240px">
        <el-button slot="append" icon="el-icon-search"></el-button>
      </el-input>
    </el-card>
    <el-card>
      <div>
        <!-- 添加按钮 -->
        <el-button type="primary" icon="el-icon-plus">添加订单</el-button>
        <!-- 列表 -->
        <el-table :data="tableData" stripe style="width: 100%">
          <el-table-column
            type="index"
            label="序号"
            width="100"
            align="center"
          ></el-table-column>
          <el-table-column prop="id" label="订单编号"></el-table-column>
          <el-table-column prop="statu" label="订单状态" align="center">
            <template slot-scope="{ row }">
              <el-tag size="medium" v-if="row.statu === 0">已完成</el-tag>
              <el-tag size="medium" type="info" v-if="row.statu === 1"
                >运输中</el-tag
              >
              <el-tag size="medium" type="danger" v-if="row.statu === 2"
                >已取消</el-tag
              >
            </template>
          </el-table-column>
          <el-table-column prop="price" label="售价"></el-table-column>
          <el-table-column prop="operate" label="操作">
            <template>
              <el-tooltip
                content="编辑"
                effect="light"
                placement="bottom-start"
              >
                <el-button size="mini" icon="el-icon-edit"></el-button>
              </el-tooltip>
              <el-tooltip
                content="详情"
                effect="light"
                placement="bottom-start"
              >
                <el-button
                  size="mini"
                  icon="el-icon-location-outline"
                  type="info"
                  @click="getInf(row)"
                ></el-button>
              </el-tooltip>
            </template>
          </el-table-column>
        </el-table>
        <!-- 分页器 -->
        <el-pagination
          layout="prev, pager, next"
          :total="total"
          style="margin-top: 20px; text-align: center"
          :ide-on-single-page="true"
          :current-page="page"
          :page-size="limit"
          @current-change="handleCurrentChange"
        >
        </el-pagination>
        <!-- 抽屉 -->
        <el-drawer :visible.sync="showDrawer" :show-close="false" size="50%">
          <el-row>
            <el-col :span="4">订单状态：</el-col>
            <el-col :span="16">已完成</el-col>
          </el-row>
          <el-timeline :reverse="reverse" style="margin-top: 20px">
            <el-timeline-item
              v-for="(activity, index) in activities"
              :key="index"
              :timestamp="activity.timestamp"
            >
              {{ activity.content }}
            </el-timeline-item>
          </el-timeline>
        </el-drawer>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectValue: "",
      // 抽屉
      showDrawer: false,
      // 选择
      List: ["全部", "已完成"],
      // 分页器当前页码
      page: 1,
      // 分页器每一页数量
      limit: 4,
      // 分页器元素总数
      total: 0,
      // 时间线
      reverse: true,
      activities: [
        {
          content: "商品已从xxx发出",
          timestamp: "2022-11-15",
        },
        {
          content: "商品已到达xxx",
          timestamp: "2022-11-17",
        },
        {
          content: "商品已到达xxx",
          timestamp: "2022-11-18",
        },
        {
          content: "商品已到达xxx",
          timestamp: "2022-11-20",
        },
        {
          content: "商品已到达xxx",
          timestamp: "2022-11-22",
        },
      ],
      tableData: [
        {
          id: "D11111",
          statu: 0,
          price: 100,
        },
        {
          id: "D22222",
          statu: 1,
          price: 110,
        },
        {
          id: "D33333",
          statu: 2,
          price: 200,
        },
        {
          id: "D44444",
          statu: 0,
          price: 400,
        },
        {
          id: "D55555",
          statu: 2,
          price: 100,
        },
      ],
      // 订单状态
      statu: "已完成",
    };
  },
  methods: {
    handleCurrentChange(pager) {
      this.page = pager;
      this.getPageList();
    },
    // 获取订单详情
    async getInf(row) {
      this.showDrawer = true;
    },
  },
};
</script>

<style scoped>
.el-row .el-col-4 {
  font-size: 18px;
  text-align: right;
  font-weight: bolder;
}
.el-col {
  font-size: 18px;
  margin: 30px 10px;
}
</style>

