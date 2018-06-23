<template>
  <div class="dateSelecteBox">
    <div class="title">时间选择</div>
    <!-- 年选择 -->
    <div class="yearList">
      <i></i>
      <input type="text" readonly>
    </div>
    <!-- 月选择 -->
    <div class="monthList">
      <i></i>
      <input type="text" readonly>
    </div>
    <!-- 日选择 -->
    <div class="dayList">
      <i></i>
      <input type="text" readonly>
    </div>
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
.dateSelecteBox {
  @include size(100%,100%);
  .title {
    @include size(92px,25px);
    line-height: 25px;
    color:#b5b5b5;
    font-size: 14px;
    text-align: center;
    float: left;
  }
  .yearList {
    position: relative;
    @include size(100px,25px);
    line-height: 25px;
    text-align: center;
    float: left;
    i{
       @include size(14px,25px);
      background: url(~assets/car/right_icons_arrow_down.png)no-repeat center center;
      position: absolute;
      top:0px;
      right:10px;
    }
    input {
      @include size(100px,25px);
      line-height: 25px;
      display: inline-block;
      color:#b5b5b5;
      padding:5px;
      border: 1px solid rgba(24,87,122,0.6);
      outline:0;
      background: #0b263c;
      box-sizing: border-box; 
    }
    input:focus{
      outline: 1px  solid rgba(129,217,229,0.6);
      background:#090a0b;
      box-sizing: border-box;
    }
  }
  .monthList {
    @extend .yearList;
    margin-left: 5px;
  }
  .dayList {
    @extend .yearList;
    margin-left: 5px;
  }
}
</style>
