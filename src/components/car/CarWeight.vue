<template>
  <div class="weightCarRtSmWidgetFrame">
    <div class="icon"><img src="../../assets/car/right_icons_cars2.png"></div>
    <loading :data="clylData">
      <div class="content_trafficAmount">
        <div class="top">
          <div class="title">{{title}}</div>
          <div class="circleButton_2"
               @click="close">
          </div>
        </div>
        <div class="bottom">
          <div class="number"
               v-if="clylData">{{qf(clylData['sum(month_volume)'])}}</div>
          <div class="unit">吨</div>
        </div>
      </div>
    </loading>
    <!-- 详情弹出框 -->
    <div class="CarWeightDetailsWrap clearfix">
      <slot name="CarWeightDetails"></slot>
    </div>
  </div>
</template>

<script>
export default {
  props: ['title', 'clylData', 'unit'],
  methods: {
    close() {
      this.$emit('close')
    },
  },
}
</script>

<style lang="scss">
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
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.weightCarRtSmWidgetFrame {
  @include size(370px,140px);
  padding: 10px;
  background: rgba(3, 139, 252, 0.2);
  box-sizing: border-box;
  position: relative;
  .icon {
    @include size(98px,98px);
    line-height: 98px;
    text-align: center;
    float: left;
    border: 2px solid #81d9e5;
    box-sizing: border-box;
    img {
      margin-top: 26px;
    }
  }
  .content_trafficAmount {
    @include size(240px,100px);
    float: left;
    margin-left: 10px;
    position: relative;
    .top {
      @include size(240px,30px);
      line-height: 30px;
      border-bottom: 2px solid #81d9e5;
      .title {
        @include size(88%,30px);
        color: #fff;
        font-size: 18px;
        float: left;
      }
      .circleButton_2 {
        @include size(20px,20px);
        position: absolute;
        top: 10px;
        right: 2px;
        cursor: pointer;
        background: url(~assets/car/css_sprite_car-01.png) no-repeat -640px -40px;
      }
      .circleButton_2:hover {
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
        font-family: "digi";
        color: #05d0eb;
        font-size: 52px;
        font-weight:bold;
        line-height: 60px;
        padding-left: 17px;
        box-sizing: border-box;
      }
      .unit {
        @include size(25%,26px);
        line-height: 26px;
        position: absolute;
        bottom: 0;
        right: 0;
        color: #fff;
        font-size: 18px;
        text-align: right;
        padding-right: 2px;
        box-sizing: border-box;
      }
    }
  }
  // 详情弹出框
  .CarWeightDetailsWrap {
    width: 750px;
    position: absolute;
    top: -255px;
    right: 445px;
    z-index: 31;
  }
}
</style>
