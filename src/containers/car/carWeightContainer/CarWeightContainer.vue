<template>

  <!-- 运输量***详情弹出框 -->
  <div class="carWeightDetailsPopupWrap clearfix"
       slot="CarWeightDetails"
       v-if="carWeightDetailsShow"
       v-drag
       @mousedown="move=true"
       @mouseup="move=false"
       :style="move?'cursor:move':''">
    <pop-up-frame @close='closeCarWeightDetailsShow'>
      <pop-up-widget title="所有车辆运输量统计"
                     :detailsBtnShow='false'></pop-up-widget>
      <!-- 详情弹出内容 -->
      <div class="carWeightDetailsWrap clearfix">
        <!-- 日期选择 -->
        <div class="dateSelectedWrap clearfix">
          <div class="dateSelecteContent">
            <div class="title">统计周期</div>
            <div class="yearWrap">
              <key-value-select width="100px"
                                :data="years"
                                @up="selectYear"></key-value-select>
            </div>
            <div class="monthWrap">
              <key-value-select width="100px"
                                :data="months"
                                @up="selectMonth"></key-value-select>
            </div>
            <div class="dayWrap">
              <key-value-select width="100px"
                                :data="days"
                                @up="selectDay"></key-value-select>
            </div>
            <div class="title">货物类型</div>
            <div class="typeWrap">
              <key-value-select width="100px"
                                :data="cargoTypeCode"
                                @up="selectType"></key-value-select>

            </div>
          </div>
        </div>
        <!-- 车辆行驶里程图表 -->
        <div class="carWeightBarChartWrap">
          <bar-hor-zoom chartTheme="dark"
                        :data="mileageVolumeStatisticsData.list[0].data"
                        :color="barHorZoomColor"
                        v-if="mileageVolumeStatisticsData"></bar-hor-zoom>
          <loading :data="mileageVolumeStatisticsData"></loading>
        </div>
        <div class="carWeightRatioChartWrap">
          <div class="carWeightRatioChart">
            <div class="barImg"></div>
            <div class="ratioData"
                 v-if="mileageVolumeStatisticsData.order">{{mileageVolumeStatisticsData.order}}</div>
            <div class="title">本车辆/所有车辆排名</div>
          </div>
        </div>
      </div>
    </pop-up-frame>
  </div>

</template>
<script>
/*eslint-disable */
import { mapActions, mapState, mapMutations } from "vuex";
import CarWeight from "@/components/car/CarWeight";
import BarHorZoom from "@/components/charts/BarHorZoom";
import PopUpFrame from "@/components/PopUpFrame";
import PopUpWidget from "@/components/PopUpWidget";
import SelectDate from "@/components/Select";
import KeyValueSelect from "@/components/KeyValueSelect";
import xxx from "../../../util/dictionary";

export default {
  components: {
    CarWeight,
    BarHorZoom,
    PopUpFrame,
    SelectDate,
    PopUpWidget,
    KeyValueSelect,
    xxx
  },
  data() {
    return {
      move: false,
      barHorZoomColor: ["#05d0eb"],
      yearValue: null,
      monthValue: null,
      dayValue: null,
      cargoTypeCodeValue: null,
      years: [{ label: "全部", value: null }, ...xxx.date.year],
      months: [{ label: "全部", value: null }, ...xxx.date.month],
      days: [{ label: "全部", value: null }, ...xxx.date.day],
      cargoTypeCode: [{ label: "全部", value: null }, ...xxx.cargoTypeCode]
    };
  },
  computed: {
    ...mapState("carWeightContainer", ["clylData"]),
    ...mapState("carModelsSearchContainer", ["cljcxxData", "vehicle_id"]),
    ...mapState("carWeightContainer", ["mileageVolumeStatisticsData"]),
    ...mapState("mileagemiscinfoWrapContainer", ["carWeightDetailsShow"]),
    getQueryParams() {
      return {
        vehicleId: this.cljcxxData.vehicle_id,
        year: this.yearValue,
        month: this.monthValue,
        day: this.dayValue,
        cargoTypeCode: this.cargoTypeCodeValue
      };
    }
  },
  methods: {
    ...mapActions("carWeightContainer", ["getcarMileageVolumeStatistics"]),
    ...mapMutations("mileagemiscinfoWrapContainer", [
      "setcarWeightDetailsShow"
    ]),
    // openCarWeightDetails() {
    //   this.getcarMileageVolumeStatistics({ vehicleId: this.vehicle_id });
    //   this.carWeightDetailsShow = !this.carWeightDetailsShow;
    // },
    closeCarWeightDetailsShow() {
      this.setcarWeightDetailsShow(false);
    },
    selectYear(item) {
      this.yearValue = item;
      this.getcarMileageVolumeStatistics(this.getQueryParams);
    },
    selectMonth(item) {
      this.monthValue = item;
      this.getcarMileageVolumeStatistics(this.getQueryParams);
    },
    selectDay(item) {
      this.dayValue = item;
      this.getcarMileageVolumeStatistics(this.getQueryParams);
    },
    selectType(item) {
      this.cargoTypeCodeValue = item;
      this.getcarMileageVolumeStatistics(this.getQueryParams);
    }
  }
};
</script>
<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
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
.carWeightDetailsPopupWrap {
  width: 100%;
  .carWeightDetailsWrap {
    width: 100%;
    .dateSelectedWrap {
      width: 100%;
      position: relative;
      .dateSelecteContent {
        @include size(660px, 25px);
        float: right;
        .title {
          width: 100px;
          text-align: center;
          line-height: 25px;
          float: left;
          color: #b5b5b5;
          font-size: 14px;
          margin-right: 10px;
          margin-left: 10px;
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
          margin-right: 5px;
        }
        .dayWrap {
          width: 100px;
          height: 25px;
          float: left;
          margin-right: 5px;
        }
        .typeWrap {
          width: 100px;
          height: 25px;
          float: left;
          margin-right: 5px;
        }
      }
    }
    .carWeightBarChartWrap {
      height: 270px;
    }
    .carWeightRatioChartWrap {
      height: 120px;
      position: absolute;
      bottom: 20px;
      right: 260px;
      .carWeightRatioChart {
        width: 150px;
        height: 150px;
        margin: 0 auto;
        .barImg {
          width: 150px;
          height: 70px;
          background: url(../../../assets/car/rank_3.png) no-repeat center
            center;
        }
        .ratioData {
          width: 150px;
          height: 30px;
          line-height: 30px;
          text-align: center;
          border: 1px solid #81d9e5;
          background: #090a0b;
          color: #ff9999;
          font-size: 24px;
          font-weight: bold;
        }
        .title {
          line-height: 14px;
          font-size: 14px;
          color: #89dddf;
          text-align: center;
          margin-top: 10px;
        }
      }
    }
  }
}
</style>
