<template>
  <div class="popUpBox">
    <!-- slot插槽: 详细内容 -->
    <slot></slot>
    <!-- 关闭按钮 -->
    <div class="close"
         @click="close">×</div>
  </div>
</template>
<script>
export default {
  props: [''],
  data() {
    return {
      move: false,
    }
  },
  methods: {
    close() {
      this.$emit('close')
    },
  },
}
</script>
<style lang="scss" scope>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.popUpBox {
  @include size(100%,100%);
  background: rgba(9, 10, 11, 0.9);
  border: 4px solid rgba(5, 208, 235, 0.8);
  padding: 16px;
  box-sizing: border-box;
  position: relative;
  z-index:1000;
  .close {
    @include size(36px,36px);
    line-height: 28px;
    text-align: center;
    color: rgba(5, 208, 235, 0.5);
    font-size: 36px;
    // border: 2px solid rgba(5, 208, 235, 0.8);
    // background: rgba(9, 10, 11, 0.9);
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
