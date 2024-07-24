<template>
  <div>
    <el-card>
      <div v-show="isShowTable">
        
        <el-table :data="tableData" style="width: 100%" stripe>
          <el-table-column type="index" prop="prop" label="#">
          </el-table-column>
          <el-table-column prop="title" label="投诉信息" align="left">
          </el-table-column>
          <el-table-column prop="operate" label="操作" align="left">
            <template>
              <el-button
                size="mini"
                icon="el-icon-edit"
                @click="
                  isShowTable = false;
                  dialogTitle = '编辑';
                "
                >处理</el-button
              >
              <el-button
                size="mini"
                icon="el-icon-delete"
                type="danger"
                @click="open"
                >删除</el-button
              >
            </template>
          </el-table-column>
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
      </div>
      <div v-show="!isShowTable">
        <my-editor v-model="article.content" />
        <el-button type="primary" @click="isShowTable = true">保存</el-button>
        <el-button @click="isShowTable = true">取消</el-button>
      </div>
    </el-card>
  </div>
</template>

<script>
import MyEditor from "@/components/myEditor.vue";
export default {
  components: {
    MyEditor,
  },
  data() {
    return {
      tableData: [
        { title: "这个药都快过期了" },
        { title: "商家态度不是特别好" },
        { title: "一般般啦" },
      ],
      // 分页器当前页码
      page: 1,
      // 分页器每一页数量
      limit: 5,
      // 元素总数
      total: 0,
      // 表单的显示与隐藏
      isShowTable: true,
      // 文本编辑器
      article: {
        content: "",
      },
    };
  },
  methods: {
    handleCurrentChange(pager) {
      this.page = pager;
    },
    open() {
      this.$confirm("此操作将永久删除该文章, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.$message({
            type: "success",
            message: "删除成功!",
          });
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
.el-table {
  font-size: 18px;
  font-weight: bold;
}
</style>