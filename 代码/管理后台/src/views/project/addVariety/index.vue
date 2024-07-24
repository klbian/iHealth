<template>
  <div>
    <!-- 添加按钮 -->
    <el-button
      type="primary"
      icon="el-icon-plus"
      @click="
        dialogFormVisible = true;
        dialogTitle = '添加品种';
        dialogClick = addVariety;
        form = {};
      "
      >添加</el-button
    >
    <!-- 列表 -->
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column type="index" prop="code" label="#"></el-table-column>
      <el-table-column prop="name" label="品种名称"></el-table-column>
      <el-table-column prop="icon" label="图标">
        <template slot-scope="scope">
          <img :src="scope.row.icon" alt="" width="60px" height="60px" />
        </template>
      </el-table-column>
      <el-table-column prop="operate" label="操作">
        <template slot-scope="{ row }">
          <el-button
            size="mini"
            icon="el-icon-edit"
            type="primary"
            @click="editVariety(row)"
            >编辑</el-button
          >
          <el-button
            size="mini"
            icon="el-icon-delete"
            type="danger"
            @click="del(row)"
            >删除</el-button
          >
        </template></el-table-column
      >
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
    <!-- 对话框 -->
    <el-dialog :title="dialogTitle" :visible.sync="dialogFormVisible">
      <el-form :model="form" style="width: 80%" :inline="true">
        <el-form-item label="序号" :label-width="formLabelWidth">
          <el-input v-model="form.sortby" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="分类号" :label-width="formLabelWidth">
          <el-input v-model="form.code" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="品种名称" :label-width="formLabelWidth">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="上传图片" :label-width="formLabelWidth">
          <el-upload
            class="avatar-uploader"
            action="https://jsonplaceholder.typicode.com/posts/"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload"
          >
            <img v-if="form.imageUrl" :src="form.imageUrl" class="avatar" />
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            <div slot="tip" class="el-upload__tip">
              只能上传jpg/png文件，且不超过500kb
            </div>
          </el-upload>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogClick">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { addVariety } from "@/api/project/addVariety";
export default {
  data() {
    return {
      // 分页器当前页码
      page: 1,
      // 分页器每一页数量
      limit: 5,
      // 对话框是否显示
      dialogFormVisible: false,
      // 对话框的标题
      dialogTitle: "",
      dialogClick: null,
      form: {
        code: "",
        // 品种名称
        name: "",
        // 图片属性
        imageUrl: "",
        // 序号
        sortby: "",
      },
      formLabelWidth: "120px",
      tableData: [
        {
          name:'心脑血管',
          icon:require('@/static/心脑.png')
        },
        {
          name:'女性健康',
          icon:require('@/static/女性.png')
        },
        {
          name:'儿童用药',
          icon:require('@/static/儿童.png')
        },
        {
          name:'呼吸哮喘',
          icon:require('@/static/呼吸.png')
        },
        {
          name:'养生保健',
          icon:require('@/static/养生.png')
        },
        {
          name:'男性健康',
          icon:require('@/static/男性.png')
        },
        {
          name:'肠胃用药',
          icon:require('@/static/肠胃.png')
        },
        {
          name:'皮肤用药',
          icon:require('@/static/皮肤.png')
        },
        {
          name:'风湿骨科',
          icon:require('@/static/骨科.png')
        }


      ],
      // 元素总数
      total: 0,
      list: [],
    };
  },
  mounted() {
    this.getList();
  },
  methods: {
    // 上传图片回调函数
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error("上传头像图片只能是 JPG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 2MB!");
      }
      return isJPG && isLt2M;
    },
    getPageList() {
      let l = (this.page - 1) * this.limit;
      let r = l + this.limit;
      this.tableData = this.list.slice(l, r);
    },
    async getList() {
      let result = await this.$API.addVariety.reqVarietyList();
      if (result.code === "1") {
        this.list = result.data;
        this.total = this.list.length;
        this.getPageList();
      }
    },
    handleCurrentChange(pager) {
      this.page = pager;
      this.getPageList();
    },
    // 编辑
    editVariety(row) {
      this.dialogFormVisible = true;
      this.dialogTitle = "编辑";
      this.form.code = row.code;
      this.form.name = row.name;
      this.form.sortby = row.sortby;
      this.dialogClick = this.subEditVariety;
    },
    async subEditVariety() {
      let result = await this.$API.addVariety.editVariety(
        this.form.code,
        this.form.name,
        this.form.sortby
      );
      if (result.code == "0") {
        this.dialogFormVisible = false;
        this.$message({
          type: "success",
          message: "修改成功!",
        });
        //再次获取品牌列表数据
        this.getList();
      }
      this.form = {};
    },
    // 添加品种
    async addVariety() {
      let result = await this.$API.addVariety.addVariety(
        this.form.code,
        this.form.name,
        this.form.sortby
      );
      if (result.code == "0") {
        this.dialogFormVisible = false;
        this.form = {};
        this.$message({
          type: "success",
          message: "添加成功!",
        });
        //再次获取品牌列表数据
        this.getList();
      }
    },
    // 删除品种
    del(e) {
      //弹框
      this.$confirm(`你确定删除${e.name}?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(async () => {
          //当用户点击确定按钮的时候会出发
          //向服务器发请求
          let result = await this.$API.addVariety.delVariety(e.code);
          //如果删除成功
          if (result.code == "1") {
            this.$message({
              type: "success",
              message: "删除成功!",
            });
            //再次获取品牌列表数据
            this.getList();
          }
        })
        .catch(() => {
          //当用户点击取消按钮的时候会触发
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
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #018581;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>