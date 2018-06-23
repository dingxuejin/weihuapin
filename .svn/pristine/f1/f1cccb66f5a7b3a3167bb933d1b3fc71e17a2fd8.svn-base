<template>
  <div class="carModelShowInfo">
    <loading :data="cljcxxData">
      <div class="carImgShow clearfix"
           v-if="cljcxxData">
        <i class="qcar"
           v-if="qcar===cljcxxData.cllx.vehicle_category"></i>
        <i class="hcar"
           v-if="hcar===cljcxxData.cllx.vehicle_category"></i>
        <i class="bcar"
           v-if="bcar===cljcxxData.cllx.vehicle_category"></i>
      </div>
    </loading>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'car-model-show-info',
  data() {
    return {
      hcar: '货车',
      qcar: '牵引车',
      bcar: '半挂车',
    }
  },
  computed: {
    ...mapState('carModelsSearchContainer', ['cljcxxData']),
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
.carModelShowInfo {
  @include size(100%,100%);
  background-size: 85% 45%;
  position: relative;
  .carImgShow {
    .hcar {
      @include size(750px,440px);
      position: absolute;
      top: 10px;
      left: 120px;
      background: url(../../assets/car/css_sprite_car-01.png) no-repeat -1100px -40px;
    }
    .qcar {
      @include size(500px,440px);
      position: absolute;
      top: 10px;
      left: 150px;
      background: url(../../assets/car/css_sprite_car-01.png) no-repeat -1100px -592px;
    }
    .bcar {
      @include size(828px,300px);
      position: absolute;
      top: 100px;
      left: 50px;
      background: url(../../assets/car/css_sprite_car-01.png) no-repeat -40px -592px;
    }
  }
}
</style>
