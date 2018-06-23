<template>
  <div class="totalCarRtSmWidgetFrame">
    <div class="icon"><img src="../../assets/car/right_icons_odometer.png"></div>
    <!-- <loading :data='number'> -->
      <div class="content_mileage">
        <div class="top">
          <div class="title">{{title}}</div>
          <div class="circleButton_1"
               @click="close">
          </div>
        </div>
        <div class="bottom">
          <div class="number" v-if="number">{{qf(number['sum(total_km)'])}}</div>
          <div class="unit">{{unit}}</div>
        </div>
      </div>
    <!-- </loading> -->
    <!-- 详情弹出框 -->
    <div class="totalMileageDetailsWrap clearfix" v-drag  @mousedown="move=true" @mouseup="move=false" :style="move?'cursor:move':''">
      <slot name="totalMileageDetailsWrap"></slot>
    </div>
  </div>
</template>

<script>
export default {
  props: ['title', 'number', 'unit'],
  methods: {
    close() {
      this.$emit('close')
    },
  },
  data() {
    return {
      move: false,
    }
  },
}
</script>

<style lang="scss">
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.clearfix {
  &:before,
  &:after {
    content: "";
    display: table;
  }
  &:after {
    clear: both;
    overflow: hidden;
  }
}
.totalCarRtSmWidgetFrame {
  @include size(370px,140px);
  padding: 20px 10px;
  background: rgba(3, 139, 252, 0.2);
  box-sizing: border-box;
  position: relative;
  top: 0;
  left: 0;
  .icon {
    @include size(98px,98px);
    line-height: 98px;
    text-align: center;
    float: left;
    border: 2px solid #81d9e5;
    box-sizing: border-box;
    //  @include size(98px,98px);
    img {
      margin-top: 26px;
    }
  }
  .content_mileage {
    @include size(240px,100px);
    float: left;
    margin-left: 10px;
    .top {
      @include size(240px,30px);
      line-height: 30px;
      border-bottom: 2px solid #81d9e5;
      position: relative;
      .title {
        @include size(210px,30px);
        color: #89dddf !important;
        font-size: 18px;
        font-weight: bold;
        float: left;
      }
      .circleButton_1 {
        @include size(20px,20px);
        position: absolute;
        top: 10px;
        right: 0;
        cursor: pointer;
        background: url(~assets/car/css_sprite_car-01.png) no-repeat -640px -40px;
      }
      .circleButton_1:hover {
        background: url(~assets/car/css_sprite_car-01.png) no-repeat -700px -40px;
      }
    }
    .bottom {
      @include size(240px,60px);
      position: relative;
      margin-top: 8px;
      background: url(~assets/car/right_bg_1.png) no-repeat center center;
      background-size: 240px 60px;
      .number {
        @include size(80%,60px);
        position: absolute;
        top: 0;
        left: 0;
        font-family: digi !important;
        color: #05d0eb;
        font-size: 52px !important;
        font-weight: bold;
        line-height: 60px;
        padding-left: 10px !important;
        box-sizing: border-box;
      }
      .unit {
        @include size(25%,26px);
        line-height: 26px;
        position: absolute;
        bottom: 0;
        right: 0;
        color: #fff;
        font-size: 14px !important;
        text-align: right;
        padding-right: 2px;
        box-sizing: border-box;
      }
    }
  }
  // 详情弹出框
  .totalMileageDetailsWrap {
    width: 750px;
    position: absolute;
    top: 80px;
    right: 425px;
    z-index: 31;
  }
}
</style>
