<template>
  <div class="carBaseInfo">
    <div class="baseInfoTitle">
      <div class="box">
        <div>车辆基础信息
          <i @click="openBaseInfoDetails"></i>
        </div>
        <i @click="close"
           class="certificateDetailsBtn"></i>
      </div>
    </div>
    <!-- 车辆基础信息弹出框详情 -->
    <div class="carBaseInfoPopup">
      <slot name="carBaseInfoPopup"></slot>
    </div>
    <div class="baseInfoDetails"
         v-if="baseInfoDetails_show">
      <loading :data="cljcxxData">
        <div class="content">
          <div class="item">
            <div class="title">车辆车牌
              <i></i>
            </div>
            <div class="details_wrap">
              {{plate_number}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="item">
            <div class="title plateColor">车牌颜色
              <i></i>
            </div>
            <div class="details_wrap">
              {{plate_color}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="item">
            <div class="title  mechanism">机构
              <i></i>
            </div>
            <div class="details_wrap" :title="entity_name">
              {{entity_name}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="item">
            <div class="title vehicleType">车辆类别
              <i></i>
            </div>
            <div class="details_wrap">
              {{vehicle_type}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="item">
            <div class="title carBrand">车辆品牌
              <i></i>
            </div>
            <div class="details_wrap">
              {{vehicle_brand}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="item">
            <div class="title carBrand">车辆VIN码
              <i></i>
            </div>
            <div class="details_wrap" :title="vin_code">
              {{vin_code}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="item">
            <div class="title carModel">车辆型号
              <i></i>
            </div>
            <div class="details_wrap"
                 :title="vehicle_model">
              {{vehicle_model}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="item">
            <div class="title fuelType">燃油类型
              <i></i>
            </div>
            <div class="details_wrap">
              {{fuel_type}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="item">
            <div class="title releaseDate">车辆出厂日期
              <i></i>
            </div>
            <div class="details_wrap">
              {{formatDate(date_of_production||'')}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="item">
            <div class="title lastTitle startDate">企业开始使用车辆时间
              <i></i>
            </div>
            <div class="details_wrap">
              {{formatDate(date_of_work||'')}}
              <div class="rotateBox"></div>
            </div>
          </div>
        </div>
      </loading>
    </div>
    <div v-show="false">{{getcljcxxData}}</div>
  </div>
</template>

<script>
export default {
  props: ['cljcxxData'],
  data() {
    return {
      baseInfoDetails_show: false,
      move: false,
      plate_number: '',
      plate_color: '',
      entity_name: '',
      vin_code: '',
      vehicle_type: '',
      vehicle_brand: '',
      vehicle_model: '',
      fuel_type: '',
      date_of_production: '',
      date_of_work: '',
    }
  },
  computed: {
    getcljcxxData() {
      if (this.cljcxxData) {
        this.plate_number = this.cljcxxData.plate_number
        if (this.cljcxxData.cpys) {
          this.plate_color = this.cljcxxData.cpys.plate_color
        }
        if (this.cljcxxData.qy_cdxx) {
          this.entity_name = this.cljcxxData.qy_cdxx.entity_name
        }
        if (this.cljcxxData.cllx) {
          this.vehicle_type = this.cljcxxData.cllx.vehicle_type
        }
        if (this.cljcxxData.clpp) {
          this.vehicle_brand = this.cljcxxData.clpp.vehicle_brand
        }
        this.vehicle_model = this.cljcxxData.vehicle_model
        if (this.cljcxxData.rllx) {
          this.fuel_type = this.cljcxxData.rllx.fuel_type
        }
        this.date_of_production = this.cljcxxData.date_of_production

        this.date_of_work = this.cljcxxData.date_of_work
        this.vin_code = this.cljcxxData.vin_code && this.cljcxxData.vin_code
      }
      return ''
    },
  },
  methods: {
    close() {
      this.$emit('close')
    },
    openBaseInfoDetails() {
      this.baseInfoDetails_show = !this.baseInfoDetails_show
    },
  },
}
</script>

<style lang="scss">
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.carBaseInfo {
  width: 100%;
  .baseInfoTitle {
    .box {
      height: 40px;
      position: relative;
      div {
        @include size(360px, 100%);
        line-height: 36px;
        text-align: center;
        color: #fff;
        font-size: 18px;
        font-weight: bold;
        border: 2px solid rgba(5, 208, 235, 0.8);
        box-sizing: border-box;
        position: relative;
        i {
          @include size(40px, 24px);
          position: absolute;
          top: 6px;
          left: 38px;
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -40px -128px;
        }
      }
      .certificateDetailsBtn {
        @include size(30px, 26px);
        position: absolute;
        top: 8px;
        right: 95px;
        background: url(../../assets/car/css_sprite_car-01.png) no-repeat -640px -128px;
      }
      .certificateDetailsBtn:hover {
        background: url(../../assets/car/css_sprite_car-01.png) no-repeat -700px -128px;
      }
    }
  }
  // 车辆基础信息弹出框详情
  .carBaseInfoPopup {
    width: 520px;
    // height:410px;
    position: absolute;
    top: 50px;
    left: 360px;
    z-index: 31;
  }
  .baseInfoDetails {
    @include size(100%, 536px);
    border: 2px solid rgba(5, 208, 235, 0.8);
    margin-top: 10px;
    box-sizing: border-box;
    background: rgba(9, 10, 11, 0.9);
    .content {
      @include size(420px, 512px);
      background: rgba(9, 122, 206, 0.2);
      margin: 8px;
      padding-top: 10px;
      padding-left: 10px;
      box-sizing: border-box;
      .item {
        @include size(400px, 40px);
        background: rgba(129, 217, 229, 0.08);
        margin-top: 10px;
        .title {
          width: 50%;
          line-height: 40px;
          font-size: 16px;
          color: #89dddf;
          padding-left: 77px;
          box-sizing: border-box;
          float: left;
          position: relative;
          i {
            @include size(40px, 24px);
            position: absolute;
            top: 8px;
            left: 20px;
            background: url(../../assets/car/css_sprite_car-01.png) no-repeat -100px -128px;
          }
        }
        .plateColor {
          position: relative;
          i {
            @include size(40px, 24px);
            position: absolute;
            top: 8px;
            left: 20px;
            background: url(../../assets/car/css_sprite_car-01.png) no-repeat -160px -128px;
          }
        }
        .mechanism {
          position: relative;
          i {
            @include size(40px, 24px);
            position: absolute;
            top: 8px;
            left: 20px;
            background: url(../../assets/car/css_sprite_car-01.png) no-repeat -220px -128px;
          }
        }
        .vehicleType {
          position: relative;
          i {
            @include size(40px, 24px);
            position: absolute;
            top: 8px;
            left: 20px;
            background: url(../../assets/car/css_sprite_car-01.png) no-repeat -280px -128px;
          }
        }
        .carBrand {
          position: relative;
          i {
            @include size(40px, 24px);
            position: absolute;
            top: 8px;
            left: 20px;
            background: url(../../assets/car/css_sprite_car-01.png) no-repeat -340px -128px;
          }
        }
        .carModel {
          position: relative;
          i {
            @include size(40px, 24px);
            position: absolute;
            top: 8px;
            left: 20px;
            background: url(../../assets/car/css_sprite_car-01.png) no-repeat -400px -128px;
          }
        }
        .fuelType {
          position: relative;
          i {
            @include size(40px, 24px);
            position: absolute;
            top: 8px;
            left: 20px;
            background: url(../../assets/car/css_sprite_car-01.png) no-repeat -460px -128px;
          }
        }
        .releaseDate {
          position: relative;
          i {
            @include size(40px, 24px);
            position: absolute;
            top: 8px;
            left: 20px;
            background: url(../../assets/car/css_sprite_car-01.png) no-repeat -520px -128px;
          }
        }
        .startDate {
          position: relative;
          i {
            @include size(40px, 24px);
            position: absolute;
            top: 8px;
            left: 20px;
            background: url(../../assets/car/css_sprite_car-01.png) no-repeat -580px -128px;
          }
        }
        .lastTitle {
          line-height: 20px;
          padding-right: 14px;
          box-sizing: border-box;
        }
        .details_wrap {
          width: 50%;
          height: 40px;
          line-height: 40px;
          color: #fff;
          font-size: 18px;
          font-weight: bold;
          padding-left: 50px;
          border: 1px solid #81d9e5;
          box-sizing: border-box;
          float: left;
          position: relative;
          background: #092133;
          overflow: hidden;
          white-space: nowrap;
          text-overflow: ellipsis;
          cursor: default;
          .rotateBox {
            @include size(7px, 7px);
            position: absolute;
            top: 16px;
            left: 19px;
            transform: rotate(45deg);
            background: #05d0eb;
          }
        }
      }
      div:first-child {
        margin-top: 0px;
      }
    }
  }
}
</style>
