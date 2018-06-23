<template>
  <div class="carLayoutWidget clearfix">
    <!-- 页头 -->
    <div class="carLayoutWidget-header clearfix">
      <slot name="carHeader"></slot>
    </div>
    <!-- 内容 -->
    <div class="carLayoutWidget-content clearfix">
      <slot name="car-router-view-content"></slot>
    </div>
    <!-- 页脚 -->
    <!-- <div class="carLayoutWidget-footer">
      <slot name="carFooter"></slot>
    </div> -->
  </div>
</template>

<script>
export default {
  name: 'car-layout-widget',
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
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.carLayoutWidget {
  @include size(1920px, 1080px); // 201805修改分辨率
  margin: 0;
  // padding: 20px 15px;
  padding-top: 20px;
  padding-bottom: 15px;
  box-sizing: border-box;
  background: url(~assets/car/bg_car.png) no-repeat center center;
  // background-size:1920px 1080px;
  .carLayoutWidget-header {
    @include size(100%, 77.5px);
  }
  .carLayoutWidget-content {
    @include size(100%, 950px);
    margin-top: 15.5px;
    // background: url(../../assets/cardetails.png) no-repeat center center;
    // background-size:1920px 950px;
  }
  .carLayoutWidget-footer {
    @include size(1920px, 10px);
    margin-top: 20px;
  }
}
// .carLayoutWidget{
//   transform: scale(0.75,1);
// }
</style>
