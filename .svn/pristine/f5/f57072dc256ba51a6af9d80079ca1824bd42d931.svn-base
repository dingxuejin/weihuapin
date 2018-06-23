<template>
  <div class="box">
    <div class="chart">
      <slot></slot>
    </div>
    <div v-for='(item,index) in data' class="line" :key="index">
        <div class="icon"></div>
        <div class="font">{{item}}</div>
        <div class="num">{{datanum[index]}}</div>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        data: ['跨省线路', '省内线路', '跨市线路', '市内线路'],
        datanum: [329, 260, 180, 80],
      }
    },
  }

</script>
<style lang="scss" scoped>
.box{
    margin-left: 30px;
    width: 530px;
    height: 203px;
    .chart{
        height: 125px;
        // width:170px;
        background:lightblue;
        margin-bottom: 10px;
    }
    .line{
        height: 30px;
        float: left;
        width: 260px;
        margin-bottom: 5px;
        div{
            float: left;
        }
        .icon{
            width: 15px;
            height: 5px;
            background-color: #05d0eb;
            margin-top: 12px;
        }
        .font{
            line-height: 30px;
            margin: 0 10px;
        }
        .num{
            width: 160px;
            height: 30px;
            background: url('../assets/company/number_bg.png');
            line-height: 30px;
            text-align: center;
        }
    }
    .line:nth-of-type(odd){
        margin-left: 10px;
    }
}
</style>