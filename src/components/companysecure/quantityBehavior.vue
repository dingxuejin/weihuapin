<template>
  <div class="trend">
    <div class="header">
      <htitle :data='name'></htitle>
    </div>
    <div class="change">
      <div>统计周期</div>
      <div>
        <hselect width='100px' :data='["2017年","2016年","2015年","2014年"]'></hselect>
      </div>
      <div>
        <hselect width='70px' :data='["-","1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"]'></hselect>
      </div>
    </div>
    <div class="echart">
      <slot></slot>
    </div>
  </div>
</template>

<script>
  import htitle from './title'
  import hselect from './select'

  export default {
    props: ['name'],
    components: {
      htitle,
      hselect,
    },
  }

</script>

<style lang="scss" scoped>
  .trend {
    width: 100%;
    height: 240px;
    .header {
      width: 280px;
      height: 25px;
    }
    .change {
      margin-top: 10px;
      margin-bottom: 10px;
      height: 25px;
      float:right;
      div {
        float: left;
        height: 25px;
        color: #b5b5b5;
      }
      div:nth-child(1) {
        line-height: 25px;
      }
      div:nth-child(2) {
        width: 100px;
        margin-left: 10px;
        margin-right: 5px;
      }
      div:nth-child(3) {
        width: 70px;
      }
    }
    .echart {
      clear: both;
      height: 170px;
      background: lightblue;
    }
  }

</style>
