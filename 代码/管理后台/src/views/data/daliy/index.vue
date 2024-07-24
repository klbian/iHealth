<template>
  <div>
    <el-card style="margin: 10px 0">
      <span class="label">时间选择</span>
      <el-date-picker v-model="dataValue" type="date" placeholder="选择日期">
      </el-date-picker>
    </el-card>
    <el-card>
      <!-- 列表 -->
      <el-table :data="tableData" stripe style="width: 100%">
        <el-table-column
          type="index"
          label="序号"
          width="100"
          align="center"
        ></el-table-column>
        <el-table-column prop="name" label="商品名称"></el-table-column>
        <el-table-column prop="promote" label="单位"> </el-table-column>
        <el-table-column prop="price" label="本日销量"></el-table-column>
        <el-table-column prop="price" label="本日结存"></el-table-column>
        <el-table-column prop="price" label="本日销售额"></el-table-column>
      </el-table>
      <!-- 分页器 -->
      <el-pagination
        layout="prev, pager, next"
        :total="total"
        style="margin-top: 20px; text-align: center"
        :hide-on-single-page="true"
        :current-page="page"
        :page-size="limit"
        @current-change="handleCurrentChange"
      >
      </el-pagination>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dataValue: "",
      tableData: [],
      // 分页器当前页码
      page: 1,
      // 分页器每一页数量
      limit: 4,
      // 分页器元素总数
      total: 10,
    };
  },
  methods: {
    handleCurrentChange(pager) {
      this.page = pager;
      this.getPageList();
    },
  },
};
</script>

<style>
.label {
  font-size: 16px;
  margin-right: 20px;
}
</style>