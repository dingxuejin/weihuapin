<template>
  <div class="boxy" v-if="overview">
    <div class="title">安全情况总览</div>
    <div class="logo"></div>
    <div class="year">
      <div class="score">本年总得分</div>
      <div class="num" v-if="overview">{{overview.y[0]&&overview.y[0].score}}</div>
    </div>
    <div class="year">
      <div class="score">本月总得分</div>
      <div class="num month" v-if="overview">{{overview.m[0]&&overview.m[0].score}}</div>
    </div>
    <!-- <div v-show="false">{{getOverviewData}}</div> -->
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  computed: {
    ...mapState('securityOverview', ['overview']),
  },
}

</script>

<style lang="scss" scoped>
.boxy{
    width: 413px;
    height: 140px;
    margin-left: 17px;
    color: #89dddf;
    font-size: 16px;
    .title{
        width: 413px;
        height:50px;
        background:url('../../../assets/companysecure/bg_font.png') no-repeat;
        line-height:50px;
        text-indent:20px;
        font-weight:bold;
        margin-bottom:10px;
    }
    .logo{
        width: 105.8px;
        height: 80px;
        background:url('../../../assets/companysecure/safty_icon.png') no-repeat center center;
        float: left;
        border-left: 2px solid #81d9e5;
        border-right: 2px solid #81d9e5;
        box-sizing: border-box;
    }
    .year{
        width: 138px;
        height: 80px;
        float: left;
        margin-left: 15px;
        .score{
            width: 100%;
            height: 25px;
            background:#004668;
            text-align:center;
            line-height:25px;
        }
        .num{
            margin-top:5px;
            height: 50px;
            box-sizing: border-box;
            border:2px solid #81d9e5;
            line-height: 46px;
            text-align: center;
            font-size: 48px;
            font-weight: bold;
            font-family: 'digi'
        }
        .month{
            color:#efca0f;
        }
    }
}
</style>
