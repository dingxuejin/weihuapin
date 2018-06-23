<template>
    <div class="title">
        <span>{{title}}</span>
        <div class="title_col1"></div>
        <div class="title_col2"></div>
    </div>
</template>
<script>
export default {
  props: {
    title: {
      type: String,
      default: '企业数量统计',
    },
  },
}
</script>
<style lang="scss" scoped>
.title{
    height: 30px;
    background-color:rgba(3,139,252,0.4);
    line-height: 30px;
    box-sizing: border-box;
    // margin-left: 10px;
    // margin-top: 7px;
    padding-left: 50px;
    font-size: 18px;
    color: #89dddf;
    position: relative;
    &_col1 {
      width: 4px;
      height: 30px;
      position: absolute;
      top: 0;
      left: 0;
      background: rgba(129, 217, 229, 0.3);
    }
    &_col2 {
      width: 10px;
      height: 30px;
      position: absolute;
      top: 0;
      left: 16px;
      background: rgba(129, 217, 229, 0.5);
    }
}
</style>
