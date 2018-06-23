<template>
  <div class="trend">
    <div class="header">
      <span>事故时段分布</span>
      <div class="btn"></div>
    </div>
    <div class="time">
        <div>时段占比</div>
        <div>事故变化趋势</div>
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
      background: rgba(129,217,299,.3);
        position: relative;
        font-size: 16px;
        color: #89dddf;
        line-height:25px;
        text-indent:20px;
      .btn{
            float: left;
            position: absolute;
            width:20px;
            height: 6px;
            background:url('../../../assets/driver/drill_icon_on.png') no-repeat;
            top:8px;
            right:10px;
            cursor: pointer;
        }
    }
    .time{
        height: 25px;
        margin-top: 10px;
        float: right;
        div{
            float: left;
            width:150px;
            color:#b5b5b5;
            text-align:center;
            height: 25px;
            box-sizing:border-box;
            border:1px solid rgba(0,191,229,1);
            background:rgba(0,191,229,.2);
            line-height:23px;
            cursor: pointer;
        }
        div:nth-child(1){
            margin-right: 10px;
        }
        div:hover{
            background: rgba(0,191,229,.5);
            color:#ffffff;
        }
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
      height: 155px;
      background: lightblue;
    }
  }

</style>
