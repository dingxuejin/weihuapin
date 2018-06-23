<template>
  <div class="carCertificateInfo">
    <div class="certificateInfo">
      <div class="imgBox"
           v-if="imgBoxShow==1"><img src="~assets/car/testUse_1.jpg"></div>
      <div class="imgBox"
           v-if="imgBoxShow==2"><img src="~assets/car/testUse_2.png"></div>
           <div class="imgBox"
           v-if="imgBoxShow==3"><img src="~assets/car/testUse_3.png"></div>
    </div>
    <div class="prevButton" @click="scrollContent(-1)"></div>
    <div class="nextButton" @click="scrollContent(1)"></div>
  </div>
</template>

<script>
export default {
  name: 'carCertificateInfo',
  data() {
    return {
      imgBoxShow: 1,
    }
  },
  methods: {
    scrollContent(i) {
      this.imgBoxShow += 1 * i
      if (this.imgBoxShow > 3) {
        this.imgBoxShow = 3
      }
      if (this.imgBoxShow < 1) {
        this.imgBoxShow = 1
      }
    },
  },
}
</script>

<style lang="scss">
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.carCertificateInfo {
  @include size(320px,140px);
  position: relative;
  top: 0px;
  left: 0px;
  z-index: 11;
  .certificateInfo {
    @include size(250px,140px);
    position: relative;
    margin: 0 auto;
    padding: 5px;
    border: 2px solid #81d9e5;
    box-sizing: border-box;
    overflow: hidden;
    z-index: 12;
    overflow: hidden;
    .imgBox {
      @include size(236px,126px);
      position: absolute;
      top: 5px;
      left: 5px;
      img {
        @include size(236px,126px);
      }
    }
  }
  .prevButton {
    @include size(30px,30px);
    position: absolute;
    top: 55px;
    left: 0;
    background: url(~assets/car/center_icons_arrow_left.png) no-repeat center
      center;
    cursor: pointer;
  }
  .nextButton {
    @include size(30px,30px);
    position: absolute;
    top: 55px;
    right: 0;
    background: url(~assets/car/center_icons_arrow_right.png) no-repeat center
      center;
    cursor: pointer;
  }
}
#adaptiveWidth {
  width: 100%;
  height: 122px;
  list-style: none;
  display: inline-block;
  margin: 0;
  padding: 0;
  li {
    @include size(232px,122px);
    line-height: 122px;
    display: inline-block;
    margin: 0;
    padding: 0;
    img {
      @include size(232px,122px);
      vertical-align: bottom;
      background: pink;
    }
  }
}
</style>
