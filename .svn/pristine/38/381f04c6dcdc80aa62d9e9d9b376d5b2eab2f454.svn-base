<template>
  <div class="box">
    <div class="content">
        <div v-for='(o,index) in dataNum'
             class="left"
             :key="index">
          <span>{{o.name}}</span>
          <div>{{o.value}}</div>
        </div>
    </div>
    <div class="boxChart">
      <slot></slot>
    </div>
    <!-- <div v-for='(item,index) in dataNum' :key='index'
         class="line" :class="(index===0||index===1)?'topLine':''">
      <div class="icon"></div>
      <div class="font">{{item.name}}</div>
      <div class="num">{{parseInt(item.value)}}</div>
    </div> -->

  </div>
</template>

<script>
export default {
  props: ['dataNum'],
  data() {
    return {
      data: ['跨省线路', '省内线路', '跨市线路', '市内线路'],
    }
  },
}
</script>
<style lang="scss" scoped>
.content {
  height: 240px;
  overflow-y: auto;
  clear: both;
}
.content::-webkit-scrollbar {
  width: 0px;
}
.box {
  margin-left: 30px;
  width: 370px;
  height: 250px;
  position: relative;
  .boxChart {
    position: absolute;
    top: 0px;
    right: 0px;
    width: 250px;
    height: 250px;
  }
  .line {
    height: 30px;
    float: left;
    width: 180px;
    margin-top:5px;
    margin-bottom: 5px;
    div {
      float: left;
    }
    .icon {
      width: 15px;
      height: 5px;
      background-color: #05d0eb;
      margin-top: 12px;
    }
    .font {
      line-height: 30px;
      margin: 0 10px;
      color: #89dddf;
    }
    .num {
      width: 80px;
      height: 30px;
      background: url("../../assets/company/number_bg.png") no-repeat;
      background-size:80px 30px;
      line-height: 30px;
      text-align: center;
      font-size: 24px;
      font-weight: bold;
      color: #05d0eb;
    }
  }
  // .topLine{
  //   margin-top:10px;
  // }
  .line:nth-of-type(odd) {
    margin-left: 10px;
  }
  .left {
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
      background: rgba(3, 139, 252, 0.4);
      font-weight: bold;
      color: #05d0eb;
      text-align: center;
      line-height: 20px;
    }
  }
}
</style>