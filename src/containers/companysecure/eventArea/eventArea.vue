<template>
  <div class="trend">
    <div class="header">
      <span>事故区域分布</span>
      <div class="btn"></div>
    </div>
    <div class="change">
      <div>统计周期</div>
      <div>
        <hselect width='100px'
                 :data='["2017年","2016年","2015年","2014年"]'></hselect>
      </div>
      <div>
        <hselect width='70px'
                 :data='["-","1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"]'></hselect>
      </div>
      <div>区域分布</div>
      <div>
        <hselect width='100px'
                 :data='["area1","area2","area3"]'></hselect>
      </div>
    </div>
    <div class="echart">
      <slot></slot>
    </div>
  </div>
</template>

<script>
import htitle from '../../../components/companysecure/title'
import hselect from '../../../components/companysecure/select'

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
    background: rgba(129, 217, 299, 0.3);
    position: relative;
    font-size: 16px;
    color: #89dddf;
    line-height: 25px;
    text-indent: 20px;
    .btn {
      float: left;
      position: absolute;
      width: 20px;
      height: 20px;
      background: url("../../../assets/driver/drill_icon_off.png") no-repeat
        center center;
      top: 4px;
      right: 10px;
      cursor: pointer;
    }
    .btn:hover{
       background: url("../../../assets/driver/drill_icon_on.png") no-repeat center center;
    }
  }
  .change {
    margin-top: 10px;
    margin-bottom: 10px;
    height: 25px;
    float: right;
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
    div:nth-child(4) {
      line-height: 25px;
      margin: 0 8px;
    }
    div:nth-child(5) {
      width: 100px;
    }
  }
  .echart {
    clear: both;
    height: 170px;
    background: lightblue;
  }
}
</style>
