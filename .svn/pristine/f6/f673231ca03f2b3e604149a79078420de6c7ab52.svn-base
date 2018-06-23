<template>
  <div class="box">
    <div class="title">
      <div :class="{hover:show}" @click='show=!show'>运单量</div>
      <div :class="{hover:!show}" @click='show=!show'>周转量</div>
    </div>
    <div class="select">
      <select>
        <option value="" v-for='(item,index) in month' :key='index'>{{item}}</option>
      </select>
      <select>
        <option value="" v-for='(item,index) in year' :key='index'>{{item}}</option>
      </select>
      <div>统计周期</div>
    </div>
    <div class="chart">
      <slot></slot>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        show: true,
        year: ['2017年', '2016年', '2015年', '2014年', '2013年'],
        month: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
      }
    },
  }

</script>

<style lang="scss" scoped>
  .box {
    margin-left: 30px;
    height: 238px;
    .title {
      height: 25px;
      div {
        width: 180px;
        height: 25px;
        line-height: 23px;
        text-align: center;
        float: left;
        box-sizing: border-box;
        font-size: 14px;
        color: #b5b5b5;
        border: 1px solid rgba(0, 191, 229, 1);
        background-color: rgba(0, 191, 229, 0.2);
        cursor: pointer;
      }
      .hover{
        background-color: rgba(0, 191, 229, 0.5);
        color:#ffffff;
      }
      div:nth-child(1){
          margin-right: 10px;
      }
    }
    .select{
        height: 26px;
        width: 370px;
        margin-top: 10px;
        div{
            float: right;
            line-height:26px;
            margin-right:10px;
        }
        select{
            float:right;
            height: 26px;
            width: 80px;
            box-sizing: border-box;
            outline: none;
            border: 1px solid rgba(0, 191, 229, 1);
            background: #000000;
            color: #d5d5d5;
        }
        select:nth-child(2){
            margin-right: 10px;
        }
    }
    .chart{
        width: 370px;
        height: 170px;
        background: lightblue;
        margin-top: 10px;
    }
  }

</style>
