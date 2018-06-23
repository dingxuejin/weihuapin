<template>
  <!-- <heavy-empty-mileage :clxslcData="clxslcData"
                       @close="openHeavyEmptyMileageDetails"> -->
  <!-- 空车重车行驶***详情弹出框 -->
  <div class="heavyEmptyMileageDetailsPopupWrap clearfix"
       slot="heavyEmptyMileageDetails"
       v-if="heavyEmptyMileageDetailsShow"
       v-drag
       @mousedown="move=true"
       @mouseup="move=false"
       :style="move?'cursor:move':''">
    <pop-up-frame @close='closeHeavyEmptyMileageShow'>
      <pop-up-widget title="所有车辆重车行驶里程占比统计"
                     :detailsBtnShow='false'></pop-up-widget>
      <!-- 详情弹出内容 -->
      <div class="heavyEmptyMileageDetails clearfix">
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
          </div>
        </div>
        <!-- 车辆行驶里程图表 -->
        <div class="heavyEmptyMileageWrap">
          <bar-hor-zoom chartTheme="dark"
                        :data="getStatisticsRatioData"
                        :color="barHorZoomColor"
                        v-if="mileageStatisticsRatioData"></bar-hor-zoom>
          <loading :data="mileageStatisticsRatioData"></loading>
        </div>
        <div class="heavyEmptyMileageChartWrap">
          <div class="heavyEmptyMileageRatioChart">
            <div class="barImg"></div>
            <div class="ratioData"
                 v-if="mileageStatisticsRatioData">{{getStatisticsRatioOrder}}</div>
            <div class="title">本车辆/所有车辆排名</div>
          </div>
        </div>
      </div>
    </pop-up-frame>
  </div>
  <!-- </heavy-empty-mileage> -->
</template>
<script>
/*eslint-disable */
import BarHorZoom from "@/components/charts/BarHorZoom";
import { mapActions, mapState, mapMutations } from "vuex";
import HeavyEmptyMileage from "@/components/car/HeavyEmptyMileage";
import PopUpFrame from "@/components/PopUpFrame";
import PopUpWidget from "@/components/PopUpWidget";
import KeyValueSelect from "@/components/KeyValueSelect";
import xxx from "../../../util/dictionary";

export default {
  components: {
    HeavyEmptyMileage,
    BarHorZoom,
    PopUpFrame,
    PopUpWidget,
    KeyValueSelect
  },
  data() {
    return {
      move: false,
      // barhor data
      barHorZoomData: [
        {
          name: "数据一",
          value: 10
        },
        {
          name: "数据二",
          value: 9
        },
        {
          name: "数据三",
          value: 8
        },
        {
          name: "数据四",
          value: 7
        },
        {
          name: "数据五",
          value: 6
        },
        {
          name: "数据六",
          value: 5
        },
        {
          name: "数据七",
          value: 4
        },
        {
          name: "数据八",
          value: 3
        },
        {
          name: "数据九",
          value: 2
        },
        {
          name: "数据十",
          value: 1
        }
      ],
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
    ...mapState("totalMileageContainer", ["clxslcData"]),
    ...mapState("carModelsSearchContainer", ["cljcxxData", "vehicle_id"]),
    ...mapState("heavyEmptyMileageContainer", ["mileageStatisticsRatioData"]),
    ...mapState("mileagemiscinfoWrapContainer", [
      "heavyEmptyMileageDetailsShow"
    ]),
    getQueryParams() {
      return {
        vehicleId: this.cljcxxData.vehicle_id,
        year: this.yearValue,
        month: this.monthValue,
        day: this.dayValue
      };
    },
    getStatisticsRatioData() {
      if (this.mileageStatisticsRatioData) {
        const newData = this.mileageStatisticsRatioData.list[0].data.map(
          item => ({
            name: item.name,
            value: `${item.value.toFixed(2)}`
          })
        );
        return newData;
      }
      return null;
    },
    getStatisticsRatioOrder() {
      if (
        this.mileageStatisticsRatioData &&
        this.mileageStatisticsRatioData !== undefined &&
        this.mileageStatisticsRatioData !== null
      ) {
        const order = this.mileageStatisticsRatioData.order;
        return order;
      }
      return "";
    }
  },
  methods: {
    ...mapActions("heavyEmptyMileageContainer", [
      "getcarMileageStatisticsRatio"
    ]),
    ...mapMutations("mileagemiscinfoWrapContainer", [
      "setheavyEmptyMileageDetailsShow"
    ]),
    closeHeavyEmptyMileageShow() {
      this.setheavyEmptyMileageDetailsShow(false);
    },
    selectYear(item) {
      this.yearValue = item;
      this.getcarMileageStatisticsRatio(this.getQueryParams);
    },
    selectMonth(item) {
      this.monthValue = item;
      this.getcarMileageStatisticsRatio(this.getQueryParams);
    },
    selectDay(item) {
      this.dayValue = item;
      this.getcarMileageStatisticsRatio(this.getQueryParams);
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
.heavyEmptyMileageDetailsPopupWrap {
  width: 100%;
  .heavyEmptyMileageDetails {
    width: 100%;
    .dateSelectedWrap {
      width: 100%;
      position: relative;
      .dateSelecteContent {
        @include size(426px, 25px);
        float: right;
        .title {
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
    .heavyEmptyMileageWrap {
      height: 270px;
      .heavyEmptyMileageChart {
        height: 270px;
        overflow: hidden;
        overflow-y: scroll;
      }
      .heavyEmptyMileageChart::-webkit-scrollbar {
        display: none;
      }
    }
    .heavyEmptyMileageChartWrap {
      height: 120px;
      position: absolute;
      bottom: 20px;
      right: 260px;
      .heavyEmptyMileageRatioChart {
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
