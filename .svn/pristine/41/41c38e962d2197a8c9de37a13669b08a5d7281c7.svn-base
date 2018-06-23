<template>
  <!-- car页面详情页面:内容 -->
  <div class="carDetailsLayoutFrame-content clearfix">
    <slot name="carDetails"></slot>
  </div>
</template>

<script>
export default {
  name: 'car-details-layout-frame',
}
</script>

<style lang="scss" scoped>
/*清除浮动*/
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
.carDetailsLayoutFrame-content {
  @include size(2460px, 910px);
}
</style>
