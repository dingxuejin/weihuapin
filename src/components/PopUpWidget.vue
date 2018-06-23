<template>
  <div class="PopUpWidget">
    <!-- 标题及border Line -->
    <div class="title">
      {{title}}
      <div class="popUpdetailsBtn" @click="popUpdetailsBtn" v-if="detailsBtnShow"></div>
      <div class="topLine">
        <div class="topLineLeft"></div>
        <div class="topLineRight"></div>
      </div>
      <div class="bottomLine">
        <div class="bottomLineLeft"></div>
        <div class="bottomLineRight"></div>
      </div>
    </div>
    <!-- 插入内容 -->
    <slot></slot>
  </div>
</template>
<script>
export default {
  props: ['title', 'detailsBtnShow'],
  methods: {
    popUpdetailsBtn() {
      this.$emit('popUpdetailsBtn')
    },
  },
}
</script>
<style lang="scss" scope>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.PopUpWidget {
  .title {
    @include size(100%,30px);
    line-height: 30px;
    padding-left: 30px;
    margin-bottom: 10px;
    color: #89dddf;
    font-size: 16px;
    font-weight: bold;
    box-sizing: border-box;
    position: relative;
    top: 0;
    left: 0;
    .popUpdetailsBtn {
      @include size(20px,20px);
      position: absolute;
      top: 12px;
      right: 10px;
      cursor: pointer;
      background: url(~assets/car/css_sprite_car-01.png) no-repeat -640px -40px;
    }
    .popUpdetailsBtn:hover {
      background: url(~assets/car/css_sprite_car-01.png) no-repeat -700px -40px;
    }
    .topLine {
      @include size(100%,2px);
      position: absolute;
      top: 0 !important;
      left: 0 !important;
      background: rgba(129, 217, 229, 0.5);
      .topLineLeft {
        @include size(20px,2px);
        background: #81d9e5;
        position: absolute;
        top: 0px;
        left: 0;
      }
      .topLineRight {
        @include size(20px,2px);
        background: #81d9e5;
        position: absolute;
        top: 0px;
        right: 0;
      }
    }
    .bottomLine {
      @include size(100%,2px);
      position: absolute;
      bottom: 0 !important;
      left: 0 !important;
      background: rgba(129, 217, 229, 0.5);
      .bottomLineLeft {
        @include size(20px,2px);
        background: #81d9e5;
        position: absolute;
        top: 0px;
        left: 0;
      }
      .bottomLineRight {
        @include size(20px,2px);
        background: #81d9e5;
        position: absolute;
        top: 0px;
        right: 0;
      }
    }
  }
}
</style>
