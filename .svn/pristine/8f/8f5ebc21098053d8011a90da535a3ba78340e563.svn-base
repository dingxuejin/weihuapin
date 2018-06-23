<template>
  <!-- <total-mileage title="行驶里程"
                 :number="clxslcData"
                 unit="公里"
                 @close="openTotalMileageDetails"> -->
  <!-- 详情弹出框 -->
  <div class="totalMileageDetailsPopupWrap clearfix"
       slot="totalMileageDetailsWrap"
       v-if="totalMileageDetailsShow">
    <pop-up-frame @close='closeTotalMileageDetails'>
      <pop-up-widget title="所有车辆行驶里程统计"
                     :detailsBtnShow='false'></pop-up-widget>
      <!-- 详情弹出内容 -->
      <div class="totalMileageDetails clearfix">
        <!-- 日期选择 -->
        <div class="dateSelectedWrap clearfix">
          <div class="dateSelecteContent">
            <div class="dateTypeTitle">统计周期</div>
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
          </div>
        </div>
        <!-- 车辆行驶里程图表 -->
        <div class="mileageBarChartWrap">
          <bar-hor-zoom chartTheme="dark"
                        :data="carMileageStatisticsData.list[0].data"
                        :color="barHorZoomColor"
                        v-if="carMileageStatisticsData"></bar-hor-zoom>
          <loading :data="carMileageStatisticsData"></loading>
        </div>
        <div class="mileageRatioChartWrap">
          <div class="mileageRatioChart">
            <div class="barImg"></div>
            <div class="ratioData"
                 v-if="carMileageStatisticsData.order">{{carMileageStatisticsData.order}}</div>
            <div class="title">本车辆/所有车辆排名</div>
          </div>
        </div>
      </div>
    </pop-up-frame>
  </div>
  <!-- </total-mileage> -->
</template>
<script>
/*eslint-disable */
import BarHorZoom from "@/components/charts/BarHorZoom";
import ringSingle from "@/components/charts/ringSingle";
import { mapActions, mapState, mapMutations } from "vuex";
import TotalMileage from "@/components/car/TotalMileage";
import PopUpFrame from "@/components/PopUpFrame";
import PopUpWidget from "@/components/PopUpWidget";
import KeyValueSelect from "@/components/KeyValueSelect";
import xxx from "../../../util/dictionary";

export default {
  components: {
    TotalMileage,
    PopUpFrame,
    PopUpWidget,
    BarHorZoom,
    ringSingle,
    KeyValueSelect
  },
  data() {
    return {
      barHorZoomColor: ["#05d0eb"],
      yearValue: null,
      monthValue: null,
      dayValue: null,
      years: [{ label: "全部", value: null }, ...xxx.date.year],
      months: [{ label: "全部", value: null }, ...xxx.date.month],
      days: [{ label: "全部", value: null }, ...xxx.date.day]
    };
  },
  computed: {
    ...mapState("totalMileageContainer", [
      "clxslcData",
      "carMileageStatisticsData"
    ]),
    ...mapState("carModelsSearchContainer", ["cljcxxData", "vehicle_id"]),
    ...mapState("mileagemiscinfoWrapContainer", ["totalMileageDetailsShow"]),
    getQueryParams() {
      return {
        vehicleId: this.cljcxxData.vehicle_id,
        year: this.yearValue,
        month: this.monthValue,
        day: this.dayValue
      };
    }
  },
  methods: {
    ...mapActions("totalMileageContainer", ["getCarMileageStatistics"]),
    ...mapMutations("mileagemiscinfoWrapContainer", [
      "settotalMileageDetailsShow"
    ]),
    // openTotalMileageDetails() {
    //   this.getCarMileageStatistics({ vehicleId: this.vehicle_id })
    //   this.totalMileageDetailsShow = !this.totalMileageDetailsShow
    // },
    closeTotalMileageDetails() {
      this.settotalMileageDetailsShow(false);
    },
    selectYear(item) {
      this.yearValue = item;
      this.getCarMileageStatistics(this.getQueryParams);
    },
    selectMonth(item) {
      this.monthValue = item;
      this.getCarMileageStatistics(this.getQueryParams);
    },
    selectDay(item) {
      this.dayValue = item;
      this.getCarMileageStatistics(this.getQueryParams);
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
.totalMileageDetailsPopupWrap {
  .totalMileageDetails {
    width: 100%;
    .dateSelectedWrap {
      width: 100%;
      position: relative;
      .dateSelecteContent {
        @include size(426px, 25px);
        float: right;
        .dateTypeTitle {
          width: 100px;
          text-align: center;
          line-height: 25px;
          float: left;
          color: #b5b5b5;
          font-size: 14px;
          margin-right: 10px;
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
      }
    }
    .mileageBarChartWrap {
      height: 270px;
    }
    .mileageRatioChartWrap {
      height: 120px;
      position: absolute;
      bottom: 20px;
      right: 260px;
      .mileageRatioChart {
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
