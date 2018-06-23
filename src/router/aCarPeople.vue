<template>
  <div class="box">
    <div class="nav" :class='{hover:num===index}' v-for='(item,index) in data' :key='index' @click='num=index'>{{item}}</div>
    <div v-for='(item,index) in data1' class="left">
      <span>{{item}}</span>
      <div>{{data2[index]}}</div>
    </div>
    <div class="chart">
      <slot></slot>
    </div>
  </div>
</template>
<script>
  export default {
    props: ['data', 'data1', 'data2'],
    data() {
      return {
        num: 0,
      }
    },
  }

</script>
<style lang="scss" scoped>
  .box {
    height: 198px;
    position: relative;
    .nav {
      float: left;
      width: 80px;
      height: 30px;
      box-sizing: border-box;
      border: 1px solid rgba(1, 191, 229, 1);
      background: rgba(1, 191, 299, 0.2);
      font-size: 14px;
      color: #b5b5b5;
      text-align: center;
      line-height: 30px;
      margin-left: 10px;
      cursor: pointer;
      margin-bottom: 10px;
    }
    .nav:nth-child(1) {
      margin-left: 30px;
    }
    .hover {
      background: rgba(1, 191, 299, 0.5);
      color: #ffffff;
    }
    .left {
      margin-left: 30px;
      margin-top: 5px;
      clear: both;
      font-size: 16px;
      span {
        color: #89dddf;
      }
      div {
        margin-top: 5px;
        width: 120px;
        height: 20px;
        background: rgba(3, 139, 252, .4);
        font-weight: bold;
        color: #05d0eb;
        text-align: center;
        line-height: 20px;
      }
    }
    .chart {
      position: absolute;
      height: 165px;
      width: 165px;
      left: 235px;
      bottom: 0px;
      background-color: lightblue;
    }
  }

</style>
