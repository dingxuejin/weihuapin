<template>
  <div class="carHeader clearfix">
    <div class="content clearfix">
      <div class="carHeader-name" @click='$router.push("/")'>亿顺凯危货运输有限公司</div>
      <!-- <div class="carHeader-title"
           :class="{carSwitchBgColor: active}"
           @click="toCar()">危货运输车辆管理</div> -->

      <div class="carHeader-title">危货运输车辆管理</div>
      <div class="carHeader-date">
        <car-header-date/>
      </div>
    </div>
  </div>
</template>

<script>
import CarHeaderDate from '@/components/car/CarHeaderDate'

export default {
  name: 'car-header',
  data() {
    return {
      active: false,
    }
  },
  components: {
    CarHeaderDate,
  },
  methods: {
    toCar() {
      const hashValue = String(location.hash.slice(1))
      if (hashValue === '/' || hashValue === '/car') {
        this.$router.push('/car/detail')
        this.active = true
      } else {
        this.$router.push('/car')
        this.active = false
      }
    },
  },
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
.carHeader {
  @include size(100%,100%);
  background: url(~assets/car/header_bg.png) no-repeat;
  .content {
    margin: 8px 0 5px 0;
    .carHeader-name {
      @include size(476px,58px);
      background: url(~assets/car/header_name.png) no-repeat center center;
      background-size:476px 58px;
      line-height: 58px;
      color: #81d9e5;
      font-size: 30px;
      font-weight: bold;
      padding-left: 40px;
      box-sizing: border-box;
      float: left;
      cursor: pointer;
    }
    .carHeader-title {
      @include size(495px,58px);
      background: url(~assets/car/car_bg_on.png) no-repeat center center;
      background-size:495px 58px;
      line-height: 58px;
      color: #81d9e5;
      font-size: 24px;
      font-weight: bold;
      padding-left: 193px;
      box-sizing: border-box;
      margin: 0 240px;
      float: left;
    }
    .carHeader-date {
      @include size(400px,60px);
      background: url(~assets/car/header_time.png) no-repeat center center;
       background-size:398px 58px;
      line-height: 60px;
      text-align: center;
      float: right;
    }
    //路由切换按钮下沉变化
    .carSwitchBgColor {
      background: url(~assets/car/car_bg_on.png) no-repeat center center;
    }
  }
}
</style>
