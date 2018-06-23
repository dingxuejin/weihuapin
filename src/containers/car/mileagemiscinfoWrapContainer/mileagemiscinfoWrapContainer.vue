<template>
  <div class="mileagemiscinfoWrapContainer">
    <!-- 横线 -->
    <div class="mileagemiscinfoTopLine"></div>
    <!-- 日期选择 -->
    <div class="dateSelectedWrap ">
      <div class="dateSelecteContent  clearfix">
        <div class="title">统计周期</div>
        <div class="yearWrap">
          <key-value-select width="100px"
                            :defaultValue="yearValue"
                            :data="years"
                            @up="selectYear"></key-value-select>
        </div>
        <div class="monthWrap">
          <key-value-select width="100px"
                            :data="months"
                            :defaultValue="monthValue"
                            @up="selectMonth"></key-value-select>
        </div>
      </div>
    </div>
    <!--1.行驶里程 -->
    <div class="totalCarRtSmWidgetFrame">
      <div class="icon">
        <img src="../../../assets/car/right_icons_odometer.png">
      </div>
      <!-- <loading :data='rightPartData'> -->
      <div class="content_mileage">
        <div class="top">
          <div class="title">行驶里程</div>
          <div class="circleButton_1"
               @click="openTotalMileageDetails">
          </div>
        </div>
        <div class="bottom">
          <div class="number"
               v-if="rightPartData">{{qf(rightPartData.total_km)}}</div>
          <div class="unit">公里</div>
        </div>
      </div>
      <!-- </loading> -->
      <!-- 详情弹出框 -->
      <div class="totalMileageDetailsWrap clearfix"
           v-drag
           @mousedown="move=true"
           @mouseup="move=false"
           :style="move?'cursor:move':''">
        <slot name="totalMileageDetailsWrap"></slot>
      </div>
    </div>
    <!-- 2.重车/空车行驶里程 -->
    <div class="heavyEmptyMileage">
      <!-- <loading :data="rightPartData"> -->
      <div class="left">
        <div class="title">重车行驶里程</div>
        <div class="line"></div>
        <div class="number"
             v-if="rightPartData">{{qf(rightPartData.loaded_km)}}
          <span>公里</span>
        </div>
        <div class="title">空车行驶里程</div>
        <div class="line"></div>
        <div class="number"
             v-if="rightPartData">{{qf(rightPartData.empty_km)}}
          <span>公里</span>
        </div>
      </div>
      <div class="right">
        <div class="title">重车行驶里程占比</div>
        <div class="echartsWidget">
          <!-- Echarts图表位置 -->
          <div class="echartsShow">
            <ringSingle :data='ringSingleData'
                        color="#05d0eb"
                        borderColor="#05d0eb"
                        chartTheme="dark"></ringSingle>
          </div>
          <div class="circleButton_2"
               @click="openHeavyEmptyMileageDetails"></div>
          <div class="text">重车／总行驶里程比</div>
        </div>
      </div>
      <!-- </loading> -->
      <!-- 详情弹出框 -->
      <div class="heavyEmptyMileageDetailsWrap clearfix">
        <slot name="heavyEmptyMileageDetails"></slot>
      </div>

    </div>
    <!-- 3.运输量 -->
    <div class="weightCarRtSmWidgetFrame">
      <div class="icon"><img src="../../../assets/car/right_icons_cars2.png"></div>
      <!-- <loading :data="rightPartData"> -->
      <div class="content_trafficAmount">
        <div class="top">
          <div class="title">运输量</div>
          <div class="circleButton_3"
               @click="openCarWeightDetails">
          </div>
        </div>
        <div class="bottom">
          <div class="number"
               v-if="rightPartData">{{qf(rightPartData.volume)}}</div>
          <div class="unit">吨</div>
        </div>
      </div>
      <!-- </loading> -->
      <!-- 详情弹出框 -->
      <div class="CarWeightDetailsWrap clearfix">
        <slot name="CarWeightDetails"></slot>
      </div>
    </div>
    <!--4. 周转量 -->
    <div class="perCarRtSmWidgetFrame">
      <div class="icon"><img src="../../../assets/car/right_icons_cars1.png"></div>
      <!-- <loading :data="rightPartData"> -->
      <div class="content_turnoverVolume">
        <div class="top">
          <div class="title">周转量</div>
          <div class="circleButton_4"
               @click="opencarPerDetailsShow">
          </div>
        </div>
        <div class="bottom">
          <div class="number"
               v-if="rightPartData">{{qf(rightPartData.cargo_turnover)}}</div>
          <div class="unit">吨公里</div>
        </div>
      </div>
      <!-- </loading> -->
      <!-- 详情弹出框 -->
      <div class="totalTurnoverVolumeWrap clearfix"
           v-drag
           @mousedown="move=true"
           @mouseup="move=false"
           :style="move?'cursor:move':''">
        <slot name="TurnoverVolume"></slot>
      </div>
    </div>
    <!-- 5.运单数 -->
    <div class="totalCountCarRtSmWidgetFrame">
      <div class="icon"><img src="../../../assets/car/right_icons_order.png"></div>
      <!-- <loading :data="rightPartData"> -->
      <div class="content_totalCount">
        <div class="top clearfix">
          <div class="title">运单数</div>
          <div class="circleButton_5"
               @click="openTotalCountDetails">
          </div>
        </div>
        <div class="bottom">
          <div class="number"
               v-if="rightPartData">{{qf(rightPartData.waybill_quantity)}}</div>
          <div class="unit">单</div>
        </div>
      </div>
      <!-- </loading> -->
      <!-- 详情弹出框 -->
      <div class="carTotalCountDetailsWrap clearfix">
        <slot name="totalCountDetails"></slot>
      </div>
    </div>
    <!-- 横线 -->
    <div class="mileagemiscinfoLine"></div>
  </div>
</template>
<script>
/*eslint-disable */
import { mapMutations, mapState, mapActions } from "vuex";
import KeyValueSelect from "../../../components/KeyValueSelect";
import xxx from "../../../util/dictionary";
// echarts组件
import ringSingle from "../../../components/charts/ringSingleBackup.vue";
export default {
  components: {
    KeyValueSelect,
    xxx,
    ringSingle
  },
  data() {
    return {
      yearValue: new Date().getFullYear() + "年",
      monthValue: new Date().getMonth() + 1 + "月",
      years: [...xxx.date.year],
      months: [...xxx.date.month],
      move: false
    };
  },
  computed: {
    ...mapState("carModelsSearchContainer", ["cljcxxData", "vehicle_id"]),
    ...mapState("mileagemiscinfoWrapContainer", ["rightPartData"]),
    getQueryParams() {
      return {
        vehicle_id: this.cljcxxData.vehicle_id,
        year: this.yearValue,
        month: this.monthValue
      };
    },
    ringSingleData() {
      if (this.rightPartData) {
        return {
          total: this.rightPartData.total_km,
          value: this.rightPartData.loaded_km
        };
      }
      return null;
    }
  },
  methods: {
    ...mapActions("mileagemiscinfoWrapContainer", ["getrightPartData"]),

    /************  设置弹窗的显示隐藏 ********************** */
    //1.行驶里程
    ...mapMutations("mileagemiscinfoWrapContainer", [
      "settotalMileageDetailsShow"
    ]),

    //2.重车/空车行驶里程
    ...mapMutations("mileagemiscinfoWrapContainer", [
      "setheavyEmptyMileageDetailsShow"
    ]),

    //3.运输量
    ...mapMutations("mileagemiscinfoWrapContainer", [
      "setcarWeightDetailsShow"
    ]),

    //4. 周转量
    ...mapMutations("mileagemiscinfoWrapContainer", ["setcarPerDetailsShow"]),

    //5.运单数
    ...mapMutations("mileagemiscinfoWrapContainer", [
      "settotalCountDetailsShow"
    ]),

    /**********   获取点击弹出弹窗后的数据      ********** */
    //1.行驶里程
    ...mapActions("totalMileageContainer", ["getCarMileageStatistics"]),
    //2.重车/空车行驶里程
    ...mapActions("heavyEmptyMileageContainer", [
      "getcarMileageStatisticsRatio"
    ]),
    //3.运输量
    ...mapActions("carWeightContainer", ["getcarMileageVolumeStatistics"]),
    //4. 周转量
    ...mapActions("carPerMileageContainer", ["getCarPerMileageStatistics"]),
    //5.运单数
    ...mapActions("carTotalCountContainer", ["getcarMileageWaybillStatistics"]),

    selectYear(item) {
      this.yearValue = item;
      this.monthValue = parseInt(this.monthValue);
      this.getrightPartData(this.getQueryParams);
    },
    selectMonth(item) {
      this.yearValue = parseInt(this.yearValue);
      this.monthValue = item;
      this.getrightPartData(this.getQueryParams);
    },
    //点击弹窗后加载信息  以及显示隐藏
    openTotalMileageDetails() {
      //  1.行驶里程
      this.getCarMileageStatistics({ vehicleId: this.vehicle_id });
      this.settotalMileageDetailsShow(true);
      //   alert("111");
    },
    openHeavyEmptyMileageDetails() {
      //2.重车/空车行驶里程
      this.getcarMileageStatisticsRatio({ vehicleId: this.vehicle_id });
      this.setheavyEmptyMileageDetailsShow(true);
      //   alert("222");
    },
    openCarWeightDetails() {
      // 3.运输量
      this.getcarMileageVolumeStatistics({ vehicleId: this.vehicle_id });
      this.setcarWeightDetailsShow(true);
      //   alert("333");
    },
    opencarPerDetailsShow() {
      //4. 周转量
      this.getCarPerMileageStatistics({ vehicleId: this.vehicle_id });
      this.setcarPerDetailsShow(true);
    },
    openTotalCountDetails() {
      //5.运单数
      this.getcarMileageWaybillStatistics({ vehicleId: this.vehicle_id });
      this.settotalCountDetailsShow(true);
      //   alert("555");
    }
  },
  created() {
    const params = {
      vehicle_id: 20170652,
      year: "",
      month: ""
    };
    // this.getrightPartData(params);
  }
};
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
.mileagemiscinfoWrapContainer {
  @include size(400px, 950px);
  padding: 15px;
  padding-top: 20px;
  box-sizing: border-box;
  color: #fff;
  .mileagemiscinfoTopLine {
    width: 370px;
    height: 2px;
    margin-top: 0px;
    background: #478294;
  }
  .dateSelectedWrap {
    width: 100%;
    position: relative;
    margin-top: 12px;
    .dateSelecteContent {
      height: 25px;
      .title {
        text-align: center;
        line-height: 25px;
        float: left;
        color: #b5b5b5;
        font-size: 14px;
        margin-right: 15px;
        margin-left: 80px;
      }
      .yearWrap {
        width: 100px;
        height: 25px;
        float: left;
        margin-right: 5px;
      }
      .monthWrap {
        width: 100px;
        height: 25px;
        float: left;
      }
    }
  }
  .totalCarRtSmWidgetFrame {
    @include size(370px, 140px);
    padding: 20px 10px;
    margin-top: 15px;
    background: rgba(3, 139, 252, 0.2);
    box-sizing: border-box;
    position: relative;
    top: 0;
    left: 0;
    .icon {
      @include size(98px, 98px);
      line-height: 98px;
      text-align: center;
      float: left;
      border: 2px solid #81d9e5;
      box-sizing: border-box;
      //  @include size(98px,98px);
      img {
        margin-top: 26px;
      }
    }
    .content_mileage {
      @include size(240px, 100px);
      float: left;
      margin-left: 10px;
      .top {
        @include size(240px, 30px);
        line-height: 30px;
        border-bottom: 2px solid #81d9e5;
        position: relative;
        .title {
          @include size(210px, 30px);
          color: #89dddf !important;
          font-size: 18px;
          font-weight: bold;
          float: left;
        }
        .circleButton_1 {
          @include size(20px, 20px);
          position: absolute;
          top: 10px;
          right: 0;
          cursor: pointer;
          background: url(~assets/car/css_sprite_car-01.png) no-repeat -640px -40px;
        }
        .circleButton_1:hover {
          background: url(~assets/car/css_sprite_car-01.png) no-repeat -700px -40px;
        }
      }
      .bottom {
        @include size(240px, 60px);
        position: relative;
        margin-top: 8px;
        background: url(~assets/car/right_bg_1.png) no-repeat center center;
        background-size: 240px 60px;
        .number {
          @include size(80%, 60px);
          position: absolute;
          top: 0;
          left: 0;
          font-family: digi !important;
          color: #05d0eb;
          font-size: 52px !important;
          font-weight: bold;
          line-height: 60px;
          padding-left: 10px !important;
          box-sizing: border-box;
        }
        .unit {
          @include size(25%, 26px);
          line-height: 26px;
          position: absolute;
          bottom: 0;
          right: 0;
          color: #fff;
          font-size: 14px !important;
          text-align: right;
          padding-right: 2px;
          box-sizing: border-box;
        }
      }
    }
    // 详情弹出框
    .totalMileageDetailsWrap {
      width: 750px;
      position: absolute;
      top: 80px;
      right: 425px;
      z-index: 31;
    }
  }
  .heavyEmptyMileage {
    @include size(370px, 200px);
    margin-top: 20px;
    position: relative;
    .left {
      @include size(180px, 200px);
      float: left;
      .title {
        @include size(180px, 30px);
        line-height: 30px;
        text-align: center;
        color: #89dddf;
        font-size: 16px;
        font-weight: bold;
        background: rgba(129, 217, 229, 0.3);
        box-sizing: border-box;
      }
      .line {
        @include size(180px, 2px);
        background: #81d9e5;
        margin: 5px auto;
      }
      .number {
        @include size(180px, 50px);
        line-height: 50px;
        font-family: digi;
        color: #89ddff;
        font-size: 36px;
        text-align: center;
        border: 2px solid #81d9e5;
        box-sizing: border-box;
        position: relative;
        span {
          width: 36px;
          height: 36px;
          color: #fff;
          font-size: 14px;
          position: absolute;
          bottom: 2px;
          right: 2px;
        }
      }
      div:nth-child(4) {
        background: rgba(231, 80, 41, 0.5);
        margin-top: 10px;
      }
    }
    .right {
      @include size(180px, 200px);
      float: left;
      margin-left: 10px;
      .title {
        @include size(180px, 30px);
        line-height: 30px;
        padding-left: 20px;
        color: #89dddf;
        font-size: 16px;
        font-weight: bold;
        background: rgba(129, 217, 229, 0.3);
        box-sizing: border-box;
      }
      .echartsWidget {
        @include size(180px, 165px);
        position: relative;
        .echartsShow {
          @include size(105px, 100px);
          position: absolute;
          top: 20px;
          right: 44px;
          z-index: 11px;
        }
        .circleButton_2 {
          @include size(20px, 20px);
          position: absolute;
          top: 10px;
          right: 0px;
          cursor: pointer;
          background: url(~assets/car/css_sprite_car-01.png) no-repeat -640px -40px;
        }
        .circleButton_2:hover {
          background: url(~assets/car/css_sprite_car-01.png) no-repeat -700px -40px;
        }
        .text {
          position: absolute;
          bottom: 10px;
          right: 0px;
          color: #89dddf;
          font-size: 14px;
          text-align: center;
          @include size(180px, 20px);
          line-height: 20px;
        }
      }
    }
    // 详情弹出框
    .heavyEmptyMileageDetailsWrap {
      width: 750px;
      position: absolute;
      top: 5px;
      right: 450px;
      z-index: 31;
    }
  }
  .weightCarRtSmWidgetFrame {
    @include size(370px, 140px);
    padding: 10px;
    margin-top: 25px;
    background: rgba(3, 139, 252, 0.2);
    box-sizing: border-box;
    position: relative;
    .icon {
      @include size(98px, 98px);
      line-height: 98px;
      text-align: center;
      float: left;
      border: 2px solid #81d9e5;
      box-sizing: border-box;
      img {
        margin-top: 26px;
      }
    }
    .content_trafficAmount {
      @include size(240px, 100px);
      float: left;
      margin-left: 10px;
      position: relative;
      .top {
        @include size(240px, 30px);
        line-height: 30px;
        border-bottom: 2px solid #81d9e5;
        .title {
          @include size(88%, 30px);
          color: #fff;
          font-size: 18px;
          float: left;
        }
        .circleButton_3 {
          @include size(20px, 20px);
          position: absolute;
          top: 10px;
          right: 2px;
          cursor: pointer;
          background: url(~assets/car/css_sprite_car-01.png) no-repeat -640px -40px;
        }
        .circleButton_3:hover {
          background: url(~assets/car/css_sprite_car-01.png) no-repeat -700px -40px;
        }
      }
      .bottom {
        @include size(240px, 60px);
        position: relative;
        margin-top: 8px;
        background: url(~assets/car/right_bg_1.png) no-repeat center center;
        background-size: 240px 60px;
        .number {
          @include size(80%, 60px);
          position: absolute;
          top: 0;
          left: 0;
          font-family: "digi";
          color: #05d0eb;
          font-size: 52px;
          font-weight: bold;
          line-height: 60px;
          padding-left: 17px;
          box-sizing: border-box;
        }
        .unit {
          @include size(25%, 26px);
          line-height: 26px;
          position: absolute;
          bottom: 0;
          right: 0;
          color: #fff;
          font-size: 18px;
          text-align: right;
          padding-right: 2px;
          box-sizing: border-box;
        }
      }
    }
    // 详情弹出框
    .CarWeightDetailsWrap {
      width: 750px;
      position: absolute;
      top: -255px;
      right: 445px;
      z-index: 31;
    }
  }
  .perCarRtSmWidgetFrame {
    @include size(370px, 140px);
    padding: 10px;
    margin-top: 25px;
    background: rgba(3, 139, 252, 0.2);
    box-sizing: border-box;
    // margin-top:38px;
    .icon {
      @include size(98px, 98px);
      line-height: 98px;
      text-align: center;
      float: left;
      border: 2px solid #81d9e5;
      box-sizing: border-box;
      img {
        margin-top: 26px;
      }
    }
    .content_turnoverVolume {
      @include size(240px, 100px);
      float: left;
      margin-left: 10px;
      position: relative;
      .top {
        @include size(240px, 30px);
        line-height: 30px;
        border-bottom: 2px solid #81d9e5;
        .title {
          @include size(88%, 30px);
          color: #fff;
          font-size: 18px;
          float: left;
        }
        .circleButton_4 {
          @include size(20px, 20px);
          position: absolute;
          top: 10px;
          right: 2px;
          cursor: pointer;
          background: url(~assets/car/css_sprite_car-01.png) no-repeat -640px -40px;
        }
        .circleButton_4:hover {
          background: url(~assets/car/css_sprite_car-01.png) no-repeat -700px -40px;
        }
      }
      .bottom {
        @include size(240px, 60px);
        position: relative;
        margin-top: 8px;
        background: url(~assets/car/right_bg_1.png) no-repeat center center;
        background-size: 270px 60px;
        .number {
          @include size(80%, 60px);
          position: absolute;
          top: 0;
          left: 0;
          font-family: "digi";
          color: #05d0eb;
          font-size: 52px;
          font-weight: bold;
          line-height: 60px;
          padding-left: 17px;
          box-sizing: border-box;
        }
        .unit {
          @include size(25%, 26px);
          line-height: 26px;
          position: absolute;
          bottom: 0;
          right: 0;
          color: #fff;
          font-size: 18px;
          text-align: right;
          padding-right: 2px;
          box-sizing: border-box;
        }
      }
    }
    // 详情弹出框
    .totalTurnoverVolumeWrap {
      width: 750px;
      position: absolute;
      top: 255px;
      right: 445px;
      z-index: 31;
    }
  }
  .totalCountCarRtSmWidgetFrame {
    @include size(370px, 140px);
    padding: 20px 10px;
    margin-top: 25px;
    background: rgba(3, 139, 252, 0.2);
    box-sizing: border-box;
    // margin-top:38px;
    .icon {
      @include size(98px, 98px);
      line-height: 98px;
      text-align: center;
      float: left;
      border: 2px solid #81d9e5;
      box-sizing: border-box;
      img {
        margin-top: 26px;
      }
    }
    .content_totalCount {
      @include size(240px, 100px);
      float: left;
      margin-left: 10px;
      .top {
        @include size(240px, 30px);
        line-height: 30px;
        border-bottom: 2px solid #81d9e5;
        .title {
          @include size(88%, 30px);
          color: #fff;
          font-size: 18px;
          float: left;
        }
        .circleButton_5 {
          @include size(20px, 20px);
          //   position: absolute;
          //   top: 10px;
          //   right: 2px;
          float: left;

          cursor: pointer;
          background: url(~assets/car/css_sprite_car-01.png) no-repeat -640px -28px;
        }
        .circleButton_5:hover {
          background: url(~assets/car/css_sprite_car-01.png) no-repeat -700px -28px;
        }
      }
      .bottom {
        @include size(240px, 60px);
        position: relative;
        margin-top: 8px;
        background: url(~assets/car/right_bg_1.png) no-repeat center center;
        background-size: 240px 60px;
        .number {
          @include size(80%, 60px);
          position: absolute;
          top: 0;
          left: 0;
          font-family: "digi";
          color: #05d0eb;
          font-size: 52px;
          font-weight: bold;
          line-height: 60px;
          padding-left: 17px;
          box-sizing: border-box;
        }
        .unit {
          @include size(25%, 26px);
          line-height: 26px;
          position: absolute;
          bottom: 0;
          right: 0;
          color: #fff;
          font-size: 18px;
          text-align: right;
          padding-right: 2px;
          box-sizing: border-box;
        }
      }
    }
    // 详情弹出框
    .carTotalCountDetailsWrap {
      width: 750px;
      position: absolute;
      top: -272px;
      right: 445px;
      z-index: 31;
    }
  }
  .mileagemiscinfoLine {
    width: 370px;
    height: 2px;
    margin-top: 10px;
    background: #478294;
  }
}
</style>
