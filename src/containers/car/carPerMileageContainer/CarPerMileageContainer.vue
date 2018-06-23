<template>
  <!-- 周转量******详情弹出框 -->
  <div class="turnoverVolumePopupWrap clearfix"
       slot="TurnoverVolume"
       v-if="carPerDetailsShow"
       v-drag
       @mousedown="move=true"
       @mouseup="move=false"
       :style="move?'cursor:move':''">
    <pop-up-frame @close='closecarPerDetailsShow'>
      <pop-up-widget title="所有车辆周转量统计"
                     :detailsBtnShow='false'></pop-up-widget>
      <!-- 详情弹出内容 -->
      <div class="turnoverVolumeWrap clearfix">
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
        <div class="turnoverVolumeBarChartWrap">
          <bar-hor-zoom chartTheme="dark"
                        :data="carPerMileageStatisticsData.list[0].data"
                        :color="barHorZoomColor"
                        v-if="carPerMileageStatisticsData"></bar-hor-zoom>
          <loading :data="carPerMileageStatisticsData"></loading>
        </div>
        <div class="turnoverVolumeChartWrap">
          <div class="turnoverVolumeChart">
            <div class="barImg"></div>
            <div class="ratioData"
                 v-if="carPerMileageStatisticsData.order">{{carPerMileageStatisticsData.order}}</div>
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
import CarPerMileage from "../../../components/car/CarPerMileage";
import BarHorZoom from "../../../components/charts/BarHorZoom";
import PopUpFrame from "../../../components/PopUpFrame";
import PopUpWidget from "../../../components/PopUpWidget";
import SelectDate from "../../../components/Select";
import KeyValueSelect from "../../../components/KeyValueSelect";
import xxx from "../../../util/dictionary";

export default {
  components: {
    BarHorZoom,
    PopUpFrame,
    SelectDate,
    PopUpWidget,
    KeyValueSelect,
    xxx,
    CarPerMileage
  },
  data() {
    return {
      move: false,
      // carPerDetailsShow: false,
      // barhor data
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
    ...mapState("carPerMileageContainer", ["clzzlData"]),
    ...mapState("carModelsSearchContainer", ["cljcxxData", "vehicle_id"]),
    ...mapState("carPerMileageContainer", ["carPerMileageStatisticsData"]),
    ...mapState("mileagemiscinfoWrapContainer", ["carPerDetailsShow"]),
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
    ...mapActions("carPerMileageContainer", ["getCarPerMileageStatistics"]),
    ...mapMutations("mileagemiscinfoWrapContainer", ["setcarPerDetailsShow"]),
    closecarPerDetailsShow() {
      this.setcarPerDetailsShow(false);
    },
    selectYear(item) {
      this.yearValue = item;
      this.getCarPerMileageStatistics(this.getQueryParams);
    },
    selectMonth(item) {
      this.monthValue = item;
      this.getCarPerMileageStatistics(this.getQueryParams);
    },
    selectDay(item) {
      this.dayValue = item;
      this.getCarPerMileageStatistics(this.getQueryParams);
    },
    selectType(item) {
      this.cargoTypeCodeValue = item;
      this.getCarPerMileageStatistics(this.getQueryParams);
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
.turnoverVolumePopupWrap {
  width: 100%;
  .turnoverVolumeWrap {
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
    .turnoverVolumeBarChartWrap {
      height: 270px;
    }
    .turnoverVolumeChartWrap {
      height: 120px;
      position: absolute;
      bottom: 20px;
      right: 260px;
      .turnoverVolumeChart {
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
