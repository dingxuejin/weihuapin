<template>
  <div class="trend">
    <div class="header">
      <div :class="{hover:page===1}"
           @click='selectPage(1)'>
        <span>高驾行为区域分布</span>
        <div @click='openDetailareaDistri'></div>
      </div>
      <div :class="{hover:page===2}"
           @click='selectPage(2)'>
        <span>高驾行为时段分布</span>
        <div @click='openDetailtimeDistri'></div>
      </div>
    </div>
    <!-- 高驾行为区域分布 -->
    <template v-if="page === 1">
      <div class="change">
        <div>统计周期</div>
        <div>
          <key-value-select :data="yearOption"
                            width="116px"
                            @select='selectArea("areaYear",$event)'></key-value-select>
        </div>
        <div>
          <key-value-select :data="monthOption"
                            width="111px"
                            @select='selectArea("areaMonth",$event)'></key-value-select>
        </div>
        <div>区域选择</div>
        <div>
          <key-value-select :data="regionOption"
                            width="236px"
                            @select='selectArea("areaRegionCode",$event)'></key-value-select>
        </div>
      </div>

      <div class="echart_radar">
        <loading :data='driverAreaDistribute'>
          <bar v-if="driverAreaDistribute"
               chartTheme="dark"
               :data="driverAreaDistribute"
               yaxisName="数量（次）"></bar>
        </loading>
      </div>
    </template>
    <!-- 高驾行为时段分布 -->
    <template v-if="page === 2">
      <div class="change">
        <div>统计周期</div>
        <div>
          <key-value-select :data="yearOption"
                            width="116px"
                            @select='selectInterval("intervalYear",$event)'></key-value-select>
        </div>
        <div>
          <key-value-select :data="monthOption"
                            width="111px"
                            @select='selectInterval("intervalMonth",$event)'></key-value-select>
        </div>
      </div>
      <div class="echart_radar">
        <loading :data="driverIntervalDistribute">
          <radar :data='driverIntervalDistribute'
                 chartTheme="dark"></radar>
        </loading>
      </div>
    </template>

  </div>
</template>

<script>
/*eslint-disable */
import { mapState, mapActions, mapMutations } from "vuex";
import htitle from "../../../components/companysecure/title";
import KeyValueSelect from "../../../components/KeyValueSelect";
import Bar from "../../../components/charts/bar";
import Radar from "../../../components/charts/Radar";
import Dictionary from "../../../util/dictionary";

const { date: { year, month }, regionCode } = Dictionary;
export default {
  components: {
    htitle,
    KeyValueSelect,
    Bar,
    Radar
  },
  computed: {
    ...mapState("areaDistributionDriver", [
      "driverAreaDistribute",
      "driverIntervalDistribute"
    ]),
    ...mapState("secureMain", ["entity_id"]),
    fetchAreaData() {
      return {
        entity_id: this.entity_id,
        year: this.areaYear,
        month: this.areaMonth,
        region_code: this.areaRegionCode
      };
    },
    fetchIntervalData() {
      return {
        entity_id: this.entity_id,
        year: this.intervalYear,
        month: this.intervalMonth
      };
    }
  },
  methods: {
    ...mapActions("areaDistributionDriver", [
      "getDriverAreaDistribute",
      "getDriverIntervalDistribute"
    ]),
    ...mapMutations("popupSecContainer", ["getComDetails"]),
    ...mapMutations("popupSecContainer", [
      "setdistributeTrendArea_show",
      "setdistributeTrendTime_show"
    ]),
    openDetailareaDistri() {
      this.setdistributeTrendArea_show(true);
    },
    openDetailtimeDistri() {
      this.setdistributeTrendTime_show(true);
    },
    openDetail(item) {
      this.getComDetails(item);
    },
    selectArea(name, item) {
      this[name] = item.value;
      this.getDriverAreaDistribute(this.fetchAreaData);
    },
    selectInterval(name, item) {
      this[name] = item.value;
      this.getDriverIntervalDistribute(this.fetchIntervalData);
    },
    selectPage(value) {
      this.page = value;
      this.areaYear = null;
      this.areaMonth = null;
      this.areaRegionCode = null;
      this.intervalYear = null;
      this.intervalMonth = null;
      if (value === 2) {
        this.getDriverIntervalDistribute(this.fetchIntervalData);
      } else if (value === 1) {
        this.getDriverAreaDistribute(this.fetchAreaData);
      }
    }
  },
  data: () => ({
    page: 1,
    yearOption: [{ label: "全部", value: null }, ...year],
    monthOption: [{ label: "全部", value: null }, ...month],
    regionOption: regionCode,
    areaYear: null,
    areaMonth: null,
    areaRegionCode: 411381,
    intervalYear: null,
    intervalMonth: null
  })
};
</script>

<style lang="scss" scoped>
.trend {
  width: 100%;
  height: 240px;
  .header {
    width: 100%;
    height: 25px;
    div:nth-child(1) {
      //margin-right: 10px;
    }
    div {
      width: 160px;
      //text-indent: 20px;
      height: 25px;
      line-height: 25px;
      float: left;
      background: rgba(129, 217, 299, 0.1);
      position: relative;
      font-size: 16px;
      color: #89dddf;
      cursor: pointer;
      &:nth-child(1) {
        margin-right: 295px;
      }
      div {
        position: absolute;
        width: 20px;
        height: 20px;
        background: url("../../../assets/driver/drill_icon_off.png") no-repeat
          center center;
        top: 2px;
        right: 5px;
        cursor: pointer;
      }
      div:hover {
        background: url("../../../assets/driver/drill_icon_on.png") no-repeat
          center center;
      }
    }
    .hover {
      background: rgba(129, 217, 299, 0.3);
    }
  }
  .change {
    margin-top: 10px;
    margin-bottom: 10px;
    height: 25.4px;
    font-size: 14px;
    div {
      float: left;
      height: 25px;
      color: #b5b5b5;
    }
    div:nth-child(1) {
      line-height: 25px;
    }
    div:nth-child(2) {
      width: 116px;
      margin-left: 15.6px;
      margin-right: 9px;
    }
    div:nth-child(3) {
      float: left;
      width: 111px;
    }
    div:nth-child(4) {
      // clear: both;
      line-height: 25px;
      margin-left: 6px;
      // margin-right: 15.6px;
      // margin-top: 5.4px;
      //float: left;
    }
    div:nth-child(5) {
      margin-left: 9.4px;
      // float: left;
      // margin-top: 5.4px;
      width: 236px;
    }
  }
  .echart_radar {
    clear: both;
    height: 170px;
    // background: lightblue;
  }
}
</style>