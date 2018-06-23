<template>
  <div class="trend">
    <div class="header">
      <span>事故时段分布</span>
      <div class="btn"
           @click='openDetailaccidentInterval'></div>
    </div>
    <div class="time">
      <div :class="{show: level1==='时段占比'}"
           @click="selectLevel('时段占比')">时段占比</div>
      <div :class="{show: level1==='事故变化趋势'}"
           @click="selectLevel('事故变化趋势')">事故变化趋势</div>
    </div>
    <div class="change">
      <div>统计周期</div>
      <div>
        <KeyValueSelect width='128px'
                        :data='yearOption'
                        @select='selectYear'></KeyValueSelect>
      </div>
      <div>
        <KeyValueSelect width='110px'
                        :data='monthOption'
                        @select='selectMonth'></KeyValueSelect>
      </div>
      <template v-if="level1==='时段占比'">
        <div>事故等級</div>
        <div>
          <KeyValueSelect width='215px'
                          :data='codeOption'
                          @select='selectCode'></KeyValueSelect>
        </div>
      </template>

    </div>

    <div class="echart"
         v-if="level1==='时段占比'">
      <loading :data="driverAccidentTrend">
        <radar :data='driverAccidentTrend'
               chartTheme="dark"></radar>
      </loading>
    </div>
    <div class="echart"
         v-if=" level1==='事故变化趋势'">
      <loading :data='driverAccidentTrend'>
        <lineChart v-if="driverAccidentTrend&&driverAccidentTrend.length>0"
                   chartTheme="dark"
                   :data="driverAccidentTrend"
                   :color="[
                        '#05d0eb',
                        '#81d9e5',
                        '#f6ffcb',
                        '#e75029',
                        '#038bfc',
                        '#006a55',
                      ]"
                   yaxisName="line"></lineChart>
      </loading>
    </div>
  </div>
</template>

<script>
/*eslint-disable */
import { mapState, mapActions, mapMutations } from "vuex";
import htitle from "../../../components/companysecure/title";
import KeyValueSelect from "../../../components/KeyValueSelect";
import Radar from "../../../components/charts/Radar";
import lineChart from "../../../components/charts/lineChart";
import Dictionary from "../../../util/dictionary";

const { accidentLevelCode, date: { year, month } } = Dictionary;
export default {
  props: ["name"],
  components: {
    htitle,
    KeyValueSelect,
    Radar,
    lineChart
  },
  computed: {
    ...mapState("accidentTime", ["driverAccidentTrend"]),
    ...mapState("secureMain", ["selectedEntity"]),
    ...mapState("secureMain", ["entity_id"]),
    property() {
      return this.driverAccidentTrend.map(i => ({
        name: i.name,
        type: "line",
        axis: 0
      }));
    },
    fetchData() {
      return {
        entity_id: this.entity_id,
        year: this.year,
        month: this.month,
        accident_level_code: this.code,
        type: this.level1
      };
      // this.getDriverAccidentTrend({
      // entity_id: this.selectedEntity.entity_id,
      // })
    }
  },
  methods: {
    ...mapMutations("popupSecContainer", ["getComDetails"]),
    ...mapMutations("popupSecContainer", [
      "setaccidentDistributeTrendInterval_show"
      // "setillegalDistributeTrendArea_show",
      // "setillegalDistributeTrendInterval_show"
    ]),
    openDetailaccidentInterval() {
      // this.setillegalDistributeTrendArea_show(true);
      this.setaccidentDistributeTrendInterval_show(true);
    },
    openDetail(item) {
      this.getComDetails(item);
    },
    ...mapActions("accidentTime", ["getDriverAccidentTrend"]),
    selectYear(item) {
      this.year = item.value;
      this.getDriverAccidentTrend(this.fetchData);
    },
    selectMonth(item) {
      this.month = item.value;
      this.getDriverAccidentTrend(this.fetchData);
    },
    selectCode(item) {
      this.code = item.value;
      this.getDriverAccidentTrend(this.fetchData);
    },
    selectLevel(item) {
      this.level1 = item;
      this.getDriverAccidentTrend(this.fetchData);
    }
  },
  data: () => ({
    level1: "时段占比",
    yearOption: [{ label: "全部", value: null }, ...year],
    monthOption: [{ label: "全部", value: null }, ...month],
    codeOption: [{ label: "全部", value: null }, ...accidentLevelCode],
    // codeOption: accidentLevelCode,
    year: null,
    month: null,
    code: null
  })
};
</script>

<style lang="scss" scoped>
.trend {
  width: 100%;
  height: 240px;
  .header {
    // width: 330px;
    width: 100%;
    height: 25px;
    background: rgba(129, 217, 299, 0.3);
    position: relative;
    font-size: 16px;
    color: #89dddf;
    line-height: 25px;
    text-indent: 20px;
    .btn {
      float: left;
      position: absolute;
      width: 20px;
      height: 20px;
      background: url("../../../assets/driver/drill_icon_off.png") no-repeat
        center center;
      top: 4px;
      right: 10px;
      cursor: pointer;
    }
    .btn:hover {
      background: url("../../../assets/driver/drill_icon_on.png") no-repeat
        center center;
    }
  }
  .time {
    width: 100%;
    height: 25px;
    margin: 10px 0px;
    float: left;
    div {
      float: left;
      width: 160px;
      color: #b5b5b5;
      text-align: center;
      height: 25px;
      box-sizing: border-box;
      border: 1px solid rgba(0, 191, 229, 1);
      background: rgba(0, 191, 229, 0.2);
      line-height: 23px;
      cursor: pointer;

      &.show {
        background: rgba(0, 191, 229, 0.5);
        color: #ffffff;
      }
    }
    div:nth-child(1) {
      //margin-right: 10px;
    }
    // div:hover {
    //   background: rgba(0, 191, 229, 0.5);
    //   color: #ffffff;
    // }
  }
  .change {
    // clear: both;
    //margin-top: 10px;
    //margin-bottom: 10px;
    height: 56.4px;
    //float: right;
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
      width: 128px;
      margin-left: 16px;
      margin-right: 10px;
    }
    div:nth-child(3) {
      width: 110px;
    }
    div:nth-child(4) {
      line-height: 25px;
      margin-left: 18px;
      // margin-top: 6.4px;
    }
    div:nth-child(5) {
      margin-left: 10px;
      // margin-top: 6.4px;
    }
  }
  .echart {
    // clear: both;
    margin-top: 20px;
    height: 143px;
    // background: lightblue;
  }
}
</style>
