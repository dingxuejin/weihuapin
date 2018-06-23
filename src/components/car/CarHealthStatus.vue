<template>
  <div class="carHealthStatusInfo">
      车辆技术健康状况
  </div>
</template>

<script>
export default {}
</script>

<style lang="scss">
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.carHealthStatusInfo {
  @include size(100%,40px);
  color: #fff;
  font-size: 24px;
  line-height: 40px;
  padding-left: 95px;
  box-sizing: border-box;
  background: url(~assets/car/left_icons_car_healthy1.png)no-repeat center center;
}
</style>
