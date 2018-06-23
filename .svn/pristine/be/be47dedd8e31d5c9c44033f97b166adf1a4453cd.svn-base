<template>
    <div class="enterPriseRank">
      <!-- <div class="enterPriseRank_Wrap"> -->
        <!-- 车辆行驶里程图表 -->
          <div class="mileageBarChartWrap">
            <bar-hor-zoom chartTheme="dark"
                          :data="carMileageStatisticsData"
                          :color="barHorZoomColor"
                          v-if="carMileageStatisticsData"></bar-hor-zoom>
            <!-- <loading :data="carMileageStatisticsData"></loading> -->
          </div>
          <div class="mileageRatioChartWrap">
            <div class="mileageRatioChart">
              <div class="barImg"></div>
              <div class="ratioData">4/4</div>
              <div class="title">企业/所有企业排名</div>
            </div>
          </div>
      <!-- </div> -->
    </div>
</template>
<script>
/* eslint-disable */

import BarHorZoom from '@/components/charts/BarHorZoom'
export default {
  components: {
    BarHorZoom
  },
  data() {
    return {
      carMileageStatisticsData:[
        {name:'北京乘胜',value:100},
        {name:'北京阳光',value:80},
        {name:'北京新雅特物流',value:60},
        {name:'新雅特物流',value:40},
      ],
      barHorZoomColor: ['#05d0eb'],
    };
  },
  methods:{
  }
};
</script>
<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.enterPriseRank{
  @include size(567px, 336px);
  margin-left:30px;
  margin-top:24px;
  background: url('../../assets/qiyeceping.png') no-repeat center center;
  background-size: 100% 100%;
  position: relative;
  .mileageBarChartWrap {
    height: 270px;
    position: absolute;
    top: 24px;
    left: 0px;
    width:567px;
  }
    .mileageRatioChartWrap {
      height: 120px;
      position: absolute;
      bottom: 20px;
      right: 15px;
      .mileageRatioChart {
        width: 150px;
        height: 150px;
        margin: 0 auto;
        .barImg {
          width: 150px;
          height: 70px;
          background: url('../../assets/car/rank_3.png') no-repeat center center;
        }
        .ratioData {
          width: 150px;
          height: 30px;
          line-height: 30px;
          text-align: center;
          border: 1px solid #81d9e5;
          background: #090a0b;
          // color: #FF9999;
          color:#fff;
          font-size: 24px;
          font-weight: bold;
        }
        .title {
          line-height: 14px;
          font-size: 14px;
          color: #89dddf;
          text-align: center;
          margin-top: 10px;
        }
      }
    }
}
</style>
