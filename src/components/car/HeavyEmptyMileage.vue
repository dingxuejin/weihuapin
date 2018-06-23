<template>
  <div class="heavyEmptyMileage">
    <!-- <loading :data="clxslcData"> -->
      <div class="left">
        <div class="title">重车行驶里程</div>
        <div class="line"></div>
        <div class="number"
             v-if="clxslcData">{{qf(clxslcData['sum(loaded_km)'])}}
          <span>公里</span>
        </div>
        <div class="title">空车行驶里程</div>
        <div class="line"></div>
        <div class="number"
             v-if="clxslcData">{{qf(clxslcData['sum(empty_km)'])}}
          <span>公里</span>
        </div>
      </div>
      <div class="right">
        <div class="title">重车行驶里程占比</div>
        <div class="echartsWidget">
          <!-- Echarts图表位置 -->
          <div class="echartsShow"
               v-if="clxslcData">
            <ringSingle :data='ringSingleData'
                        color="#05d0eb"
                        borderColor="#05d0eb"
                        chartTheme="dark"></ringSingle>
          </div>
          <div class="circleButton_5"
               @click="close"></div>
          <div class="text">重车／总行驶里程比</div>
        </div>
      </div>
    <!-- </loading> -->
    <!-- 详情弹出框 -->
    <div class="heavyEmptyMileageDetailsWrap clearfix">
      <slot name="heavyEmptyMileageDetails"></slot>
    </div>
  </div>
</template>

<script>
// echarts组件
import ringSingle from '@/components/charts/ringSingleBackup'

export default {
  props: ['clxslcData'],
  components: {
    ringSingle,
  },
  computed: {
    ringSingleData() {
      if (this.clxslcData) {
        return {
          total: this.clxslcData['sum(total_km)'],
          value: this.clxslcData['sum(loaded_km)'],
        }
      }
      return null
    },
  },
  methods: {
    close() {
      this.$emit('close')
    },
  },
}
</script>

<style lang="scss">
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.heavyEmptyMileage {
  @include size(370px,200px);
  margin-top:10px;
  position: relative;
  .left {
    @include size(180px,200px);
    float: left;
    .title {
      @include size(180px,30px);
      line-height: 30px;
     text-align: center;
      color: #89dddf;
      font-size: 16px;
      font-weight: bold;
      background: rgba(129, 217, 229, 0.3);
      box-sizing: border-box;
    }
    .line {
      @include size(180px,2px);
      background: #81d9e5;
      margin: 5px auto;
    }
    .number {
      @include size(180px,50px);
      line-height: 50px;
      font-family: digi;
      color: #89ddff;
      font-size: 36px;
      text-align: center;
      border: 2px solid #81d9e5;
      box-sizing: border-box;
      position: relative;
      span {
        width: 36px;
        height: 36px;
        color: #fff;
        font-size: 14px;
        position: absolute;
        bottom: 2px;
        right: 2px;
      }
    }
    div:nth-child(4) {
      background: rgba(231, 80, 41, 0.5);
      margin-top: 10px;
    }
  }
  .right {
    @include size(180px,200px);
    float: left;
    margin-left: 10px;
    .title {
      @include size(180px,30px);
      line-height: 30px;
      padding-left: 20px;
      color: #89dddf;
      font-size: 16px;
      font-weight: bold;
      background: rgba(129, 217, 229, 0.3);
      box-sizing: border-box;
    }
    .echartsWidget {
      @include size(180px,165px);
      position: relative;
      .echartsShow {
        @include size(105px,100px);
        position: absolute;
        top: 20px;
        right: 44px;
        z-index: 11px;
      }
      .circleButton_5 {
        @include size(20px,20px);
        position: absolute;
        top: 10px;
        right: 0px;
        cursor: pointer;
        background: url(~assets/car/css_sprite_car-01.png) no-repeat -640px -40px;
      }
      .circleButton_5:hover {
        background: url(~assets/car/css_sprite_car-01.png) no-repeat -700px -40px;
      }
      .text {
        position: absolute;
        bottom: 10px;
        right: 0px;
        color: #89dddf;
        font-size: 14px;
        text-align: center;
        @include size(180px,20px);
        line-height: 20px;
      }
    }
  }
  // 详情弹出框
  .heavyEmptyMileageDetailsWrap {
    width: 750px;
    position: absolute;
    top: 5px;
    right: 450px;
    z-index: 31;
  }
}
</style>
