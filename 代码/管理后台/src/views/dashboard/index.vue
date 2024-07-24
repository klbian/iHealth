<template>
  <div class="dashboard-container">
    <div class="dashboard-text">用户: {{ name }}</div>
    <br>
    <div class="dashboard-text">欢迎来到商家管理平台</div>
  </div>

</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'kyire',
  computed: {
    ...mapGetters([
      'name'
    ])
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
