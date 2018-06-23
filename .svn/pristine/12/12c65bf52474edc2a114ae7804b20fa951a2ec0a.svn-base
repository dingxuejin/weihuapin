<template>
  <div class="carVehicleType">
    <div class="carVehicleType-line"></div>
    <div class="carVehicleType-title">
      车辆详细信息
    </div>
    <loading :data="cljcxxData">
      <div class="carVehicleType-content">
        <transition name="fade">
          <div class="detailes"
               v-if="detailesBoxShow===1">
            <div class="tlfTitle  numberofaxle">车轴数量
              <i></i>
            </div>
            <div class="trTitle  vehiclewheelbase">车辆轴距
              <i></i>
            </div>
            <div class="tlfdata"
                 v-if='cljcxxData'
                 :title="cljcxxData.number_of_axle">
              <div class="rotateBox"></div>{{cljcxxData.number_of_axle}}</div>
            <div class="trtData"
                 v-if='cljcxxData'
                 :title="cljcxxData.axle_distance">
              <div class="rotateBox"></div>{{cljcxxData.axle_distance}}</div>
            <div class="blfTitle  totalmass">总质量
              <i></i>
            </div>
            <div class="brtTitle   curbweight">整备质量
              <i></i>
            </div>
            <div class="blfData"
                 v-if='cljcxxData'
                 :title="cljcxxData.total_weight">
              <div class="rotateBox"></div>{{cljcxxData.total_weight}}</div>
            <div class="brtData"
                 v-if='cljcxxData'
                 :title="cljcxxData.maintenance_weight">
              <div class="rotateBox"></div>{{cljcxxData.maintenance_weight}}</div>
          </div>
        </transition>
        <transition name="fade">
          <div class="detailes"
               v-if="detailesBoxShow===2">
            <div class="tlfTitle totalqualityofquasitrailer">准拖挂车总质量
              <i></i>
            </div>
            <div class="trTitle ratedloadquality">额定载质量
              <i></i>
            </div>
            <div class="tlfdata"
                 v-if='cljcxxData'
                 :title="cljcxxData.trailers_total_weight">
              <div class="rotateBox"></div>{{cljcxxData.trailers_total_weight}}</div>
            <div class="trtData"
                 v-if='cljcxxData'
                 :title="cljcxxData.rated_contained_weight">
              <div class="rotateBox"></div>{{cljcxxData.rated_contained_weight}}</div>
            <div class="blfTitle quasimultiplicativenumber">准乘人数
              <i></i>
            </div>
            <div class="brtTitle enginemodel">发动机型号
              <i></i>
            </div>
            <div class="blfData"
                 v-if='cljcxxData'
                 :title="cljcxxData.quasi_passenger_num">
              <div class="rotateBox"></div>{{cljcxxData.quasi_passenger_num}}</div>
            <div class="brtData"
                 v-if='cljcxxData'
                 :title="cljcxxData.engine_model">
              <div class="rotateBox"></div>{{cljcxxData.engine_model}}</div>
          </div>
        </transition>
        <transition name="fade">
          <div class="detailes"
               v-if="detailesBoxShow===3">
            <div class="tlfTitle enginedisplacement">发动机排量
              <i></i>
            </div>
            <div class="trTitle enginepower">发动机功率
              <i></i>
            </div>
            <div class="tlfdata"
                 v-if='cljcxxData'
                 :title="cljcxxData.engine_displacement">
              <div class="rotateBox"></div>{{cljcxxData.engine_displacement}}</div>
            <div class="trtData"
                 v-if='cljcxxData'
                 :title="cljcxxData.engine_power">
              <div class="rotateBox"></div>{{cljcxxData.engine_power}}</div>
            <div class="blfTitle bodylength">车身长度
              <i></i>
            </div>
            <div class="brtTitle bodyheight">车身高度
              <i></i>
            </div>
            <div class="blfData"
                 v-if='cljcxxData'
                 :title="cljcxxData.length">
              <div class="rotateBox"></div>{{cljcxxData.length}}</div>
            <div class="brtData"
                 v-if='cljcxxData'
                 :title="cljcxxData.hight">
              <div class="rotateBox"></div>{{cljcxxData.hight}}</div>
          </div>
        </transition>
        <transition name="fade">
          <!-- <div class="detailes"
               v-if="detailesBoxShow===4">
            <div class="tlfTitle  numberOfTank">罐体仓数
              <i></i>
            </div>
            <div class="trTitle VehicleOwnership">车辆归属
              <i></i>
            </div>
            <div class="tlfdata"
                 v-if='cljcxxData'>
              <div class="rotateBox"></div>{{cljcxxData.tank_number}}</div>
            <div class="trtData"
                 v-if='cljcxxData'>
              <div class="rotateBox"></div>{{cljcxxData.clgs.vehicle_belong}}</div>
          </div> -->
          <div class="detailes"
               v-if="detailesBoxShow===4">
            <div class="tlfTitle bodywidth">车身宽度
              <i></i>
            </div>
            <div class="trTitle vehicleownership">车辆归属
              <i></i>
            </div>
            <div class="tlfdata"
                 v-if='cljcxxData'
                 :title="cljcxxData.width">
              <div class="rotateBox"></div>{{cljcxxData.width}}</div>
            <div class="trtData"
                 v-if='cljcxxData'
                 :title="cljcxxData.clgs.vehicle_belong">
              <div class="rotateBox"></div>{{cljcxxData.clgs.vehicle_belong}}</div>
            <!-- ************************下面的字段需要重新修改 ，i标签的小图标同时修改********************************** -->
            <div class="blfTitle  tankmanufacturingunit">罐体制造单位
              <i></i>
            </div>
            <div class="brtTitle  tankmodel">罐体型号
              <i></i>
            </div>
            <div class="blfData"
                 v-if='cljcxxData'
                 :title="cljcxxData.tank_manufacturer">
              <div class="rotateBox"></div>{{cljcxxData.tank_manufacturer}}</div>
            <div class="brtData"
                 v-if='cljcxxData'
                 :title="cljcxxData.tank_model">
              <div class="rotateBox"></div>{{cljcxxData.tank_model}}</div>
          </div>
        </transition>
        <transition name="fade">
          <div class="detailes"
               v-if="detailesBoxShow===5">
            <div class="tlfTitle  tankfactorynumber">罐体出厂编号
              <i></i>
            </div>
            <div class="trTitle tankmaterial">罐体材质
              <i></i>
            </div>
            <div class="tlfdata"
                 v-if='cljcxxData'
                 :title="cljcxxData.tank_factory_number">
              <div class="rotateBox"></div>{{cljcxxData.tank_factory_number}}</div>
            <div class="trtData"
                 v-if='cljcxxData'
                 :title="cljcxxData.tank_texture">
              <div class="rotateBox"></div>{{cljcxxData.tank_texture}}</div>
            <div class="blfTitle transportationcategory">运输品类
              <i></i>
            </div>
            <div class="brtTitle  volumeoftank">罐体容积
              <i></i>
            </div>
            <div class="blfData"
                 v-if='cljcxxData'
                 :title="cljcxxData.transport_category">
              <div class="rotateBox"></div>{{cljcxxData.transport_category}}</div>
            <div class="brtData"
                 v-if='cljcxxData'
                 :title="cljcxxData.tank_volume">
              <div class="rotateBox"></div>{{cljcxxData.tank_volume}}</div>
          </div>
        </transition>

        <transition name="fade">
          <div class="detailes"
               v-if="detailesBoxShow===6">
            <div class="tlfTitle tankwallthickness">罐体壁厚
              <i></i>
            </div>
            <div class="trTitle tanknumber">罐体仓数
              <i></i>
            </div>
            <div class="tlfdata"
                 v-if='cljcxxData'
                 :title="cljcxxData.tank_thickness">
              <div class="rotateBox"></div>{{cljcxxData.tank_thickness}}</div>
            <div class="trtData"
                 v-if='cljcxxData'
                 :title="cljcxxData.tank_number">
              <div class="rotateBox"></div>{{cljcxxData.tank_number}}</div>
            <div class="blfTitle tankshapesize">罐体外形尺寸
              <i></i>
            </div>
            <div class="blfData"
                 v-if='cljcxxData'
                 :title="cljcxxData.tank_dimensions">
              <div class="rotateBox"></div>{{cljcxxData.tank_dimensions}}</div>
          </div>
        </transition>

        <!--  新增结束-->
        <div class="prev"
             @click="scrollContent(-1)">
          <i></i>
        </div>
        <div class="next"
             @click="scrollContent(1)">
          <i></i>
        </div>
      </div>
    </loading>
  </div>
</template>

<script>
export default {
  props: ['cljcxxData'],
  name: 'car-vehicle-type',
  data() {
    return {
      detailesBoxShow: 1,
    }
  },
  methods: {
    scrollContent(i) {
      this.detailesBoxShow += 1 * i
      if (this.detailesBoxShow > 6) {
        this.detailesBoxShow = 6
      }
      if (this.detailesBoxShow < 1) {
        this.detailesBoxShow = 1
      }
    },
  },
}
</script>

<style lang="scss" scope>
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
.carVehicleType {
  @include size(368px, 210px);
  .carVehicleType-title {
    @include size(368px, 30px);
    position: relative;
    color: #89dddf;
    font-size: 18px;
    font-weight: bold;
    line-height: 30px;
    padding-left: 50px;
    box-sizing: border-box;
    background: url(~assets/car/left_header_strip_1.png) no-repeat;
  }
  .carVehicleType-line {
    height: 2px;
    margin-left: 19px;
    margin-bottom: 8px;
    background: #478294;
  }
  .carVehicleType-content {
    @include size(368px, 165px);
    // margin-left: 30px;
    position: relative;
    overflow: hidden;
    .detailes {
      @include size(280px, 165px);
      margin: 0 auto;
      margin-left: 55px;
      // font-size: 14px;
      .tlfTitle {
        @include size(134px, 30px);
        line-height: 30px;
        font-size: 14px;
        color: #89dddf;
        padding-left: 36px;
        margin-right: 10px;
        margin-top: 10px;
        float: left;
        position: relative;
        box-sizing: border-box;
        cursor: default;
        i {
          @include size(40px, 24px);
          position: absolute;
          top: 0;
          left: 0;
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -40px -84px;
          background-size:40px  24px;
        }
      }
      .trTitle {
        @extend .tlfTitle;
        margin-right: 0px;
      }
      .tlfdata {
        @extend .tlfTitle;
        @include size(134px, 30px);
        line-height: 30px;
        font-size: 14px;
        font-weight: bold;
        color: #fff;
        border: 1px solid #81d9e5;
        text-align: left;
        padding-left: 28px;
        margin-top: 5px;
        position: relative;
        background: none;
        float: left;
        box-sizing: border-box;
        .rotateBox {
          @include size(7px, 7px);
          position: absolute;
          top: 11px;
          left: 9px;
          transform: rotate(45deg);
          background: #05d0eb;
        }
      }
      .trtData {
        @extend .tlfdata;
        margin-right: 0px;
        cursor: default;
      }
      .blfTitle {
        @extend .tlfTitle;
      }
      .brtTitle {
        @extend .tlfTitle;
        margin-right: 0px;
      }
      .blfData {
        @extend .tlfdata;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
        cursor: default;
      }
      .brtData {
        @extend .tlfdata;
        margin-right: 0px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
        cursor: default;
      }
      // 增加Icon
      .numberofaxle {
        i {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -40px -84px;
        }
      }
      .vehiclewheelbase {
        i {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -100px -84px;
        }
      }
      .totalmass {
        i {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -280px -84px;
        }
      }
      .curbweight {
        i {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -220px -84px;
        }
      }
      .totalqualityofquasitrailer {
        i {
          background: url(../../assets/car/zongzhiliang.png) no-repeat 0 0;
        }
      }
      .ratedloadquality {
        i {
          background: url(../../assets/car/edingzaizhiliang.png) no-repeat 0 0;
        }
      }
      .quasimultiplicativenumber {
        i {
          background: url(../../assets/car/renshu.png) no-repeat 0 0;
        }
      }
      .enginemodel {
        i {
          background: url(../../assets/car/fadongjixinghao.png) no-repeat 0 0;
        }
      }
      .enginedisplacement {
        i {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -340px -84px;
        }
      }
      .enginepower {
        i {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -400px -84px;
        }
      }
      .bodylength {
        i {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -460px -84px;
        }
      }
      .bodyheight {
        i {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -520px -84px;
        }
      }
      .bodywidth {
        i {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -580px -84px;
        }
      }
      .vehicleownership {
        i {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -880px -84px;
        }
      }
      .tankmanufacturingunit {
        i {
          background: url(../../assets/car/zhizaoshang.png) no-repeat 0 0;
        }
      }
      .tankmodel {
        i {
          background: url(../../assets/car/xinghao.png) no-repeat 0 0;
        }
      }
      .tankfactorynumber {
        i {
          background: url(../../assets/car/guantizhizaodanwei.png) no-repeat 0 0;
        }
      }
      .tankmaterial {
        i {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -700px -84px;
        }
      }
      .transportationcategory {
        i {
          background: url(../../assets/car/xinghao.png) no-repeat 0 0;
        }
      }
      .volumeoftank {
        i {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -640px -84px;
        }
      }
      .tankwallthickness{
         i {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -760px -84px;
        }

      }
      .tanknumber{
         i {
          background: url(../../assets/car/css_sprite_car-01.png) no-repeat -820px -84px;
        }

      }
      .tankshapesize{
        i {
          background: url(../../assets/car/waiixngchicun.png) no-repeat 0 0;
        }

      }



    }
    .prev {
      @include size(25px, 130px);
      line-height: 130px;
      text-align: left;
      position: absolute;
      top: 10px;
      left: 25px;
      color: #81d9e5;
      font-size: 24px;
      font-weight: bold;
      cursor: pointer;
      i {
        @include size(15px, 24px);
        position: absolute;
        top: 50%;
        left: 5px;
        background: url(../../assets/car/css_sprite_car-01.png) no-repeat -280px -40px;
      }
    }
    .prev:hover i {
      background: url(../../assets/car/css_sprite_car-01.png) no-repeat -340px -40px;
    }
    .next {
      @include size(25px, 130px);
      line-height: 130px;
      text-align: right;
      position: absolute;
      top: 10px;
      right: 15px;
      color: #81d9e5;
      font-size: 30px;
      font-weight: bold;
      cursor: pointer;
      i {
        @include size(15px, 24px);
        position: absolute;
        top: 50%;
        right: -5px;
        background: url(../../assets/car/css_sprite_car-01.png) no-repeat -280px -40px;
        transform: rotate(180deg);
      }
    }
    .next:hover i {
      background: url(../../assets/car/css_sprite_car-01.png) no-repeat -340px -40px;

      transform: rotate(180deg);
    }
    .fade-enter-active,
    .fade-leave-active {
      transition: opacity 0.2s;
    }
    .fade-enter,
    .fade-leave-to {
      opacity: 0;
    }
  }
}
</style>
