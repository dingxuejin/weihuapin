<template>
  <div class="popUpBox">
    <!-- 标题 -->
    <div class="popUpTitle">
      {{title}}
      <div class="topLine">
        <div></div>
        <div></div>
      </div>
      <div class="bottomLine">
        <div></div>
        <div></div>
      </div>
      <div class="isOnline">
        {{isItOnline}}
      </div>
    </div>
    <!-- slot插槽内容 -->
    <slot name="popUpBoxContent"></slot>
    <!-- 关闭按钮 -->
    <div class="close"
         @click="close"></div>
  </div>
</template>
<script>
export default {
  props: ['title', 'isItOnline'],
  data() {
    return { move: false }
  },
  methods: {
    close() {
      this.$emit('close')
    },
  },
}
</script>
<style lang="scss" scope>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.popUpBox {
  @include size(100%, 100%);
  background: rgba(9, 10, 11, 0.9);
  border: 4px solid rgba(5, 208, 235, 0.8);
  padding: 16px;
  box-sizing: border-box;
  position: relative;
  .popUpTitle {
    @include size(100%, 30px);
    line-height: 30px;
    padding-left: 30px;
    margin-bottom: 10px;
    color: #89dddf;
    font-size: 16px;
    font-weight: bold;
    box-sizing: border-box;
    float: left;
    position: relative;
    top: 0;
    left: 0;
    .topLine {
      @include size(100%, 2px);
      position: absolute;
      top: 0;
      left: 0;
      background: rgba(129, 217, 229, 0.5);
      div:first-child {
        @include size(20px, 2px);
        background: #81d9e5;
        position: absolute;
        top: 0px;
        left: 0;
      }
      div:last-child {
        @include size(20px, 2px);
        background: #81d9e5;
        position: absolute;
        top: 0px;
        right: 0;
      }
    }
    .bottomLine {
      @include size(100%, 2px);
      position: absolute;
      bottom: 0;
      left: 0;
      background: rgba(129, 217, 229, 0.5);
      div:first-child {
        @include size(20px, 2px);
        background: #81d9e5;
        position: absolute;
        top: 0px;
        left: 0;
      }
      div:last-child {
        @include size(20px, 2px);
        background: #81d9e5;
        position: absolute;
        top: 0px;
        right: 0;
      }
    }
    .isOnline {
      position: absolute;
      top: 0px;
      right: 40px;
      color: #89dddf;
      font-size: 16px;
      z-index: 30;
    }
  }
  .close {
    @include size(36px, 36px);
    line-height: 28px;
    text-align: center;
    color: rgba(5, 208, 235, 0.5);
    font-size: 36px;
    // border: 4px solid rgba(5, 208, 235, 0.8);
    // background: rgba(9, 10, 11, 0.9);
    // background: url("../assets/car/guanbi.png") no-repeat 0 0;
    background: url("../../assets/car/guanbi.png") no-repeat 0 0;
    box-sizing: border-box;
    box-sizing: border-box;
    position: absolute;
    top: -22px;
    right: -22px;
    cursor: pointer;
  }
  .close:hover {
    color: rgba(5, 208, 235, 1);
  }
}
</style>
