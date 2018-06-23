<template>
  <div class="trend">
    <div class="header">
      <span>事故区域分布</span>
      <div class="btn"
           @click='openDetailaccidentArea'></div>
    </div>
    <div class="change">
      <div>统计周期</div>
      <div>
        <key-value-select width='116px'
                          :data='yearOption'
                          @select='selectYear'></key-value-select>
      </div>
      <div>
        <key-value-select width='111px'
                          :data='monthOption'
                          @select='selectMonth'></key-value-select>
      </div>
      <div>区域分布</div>
      <div>
        <key-value-select width='215px'
                          :data='regionOption'
                          @select='selectRegion'></key-value-select>
      </div>
    </div>
    <div class="echart">
      <loading :data='driverAccidentAreaCount'>
        <bar chartTheme="dark"
             :data="driverAccidentAreaCount"
             yaxisName="数量（次）"></bar>
      </loading>
    </div>
  </div>
</template>

<script>
/*eslint-disable */
import { mapState, mapActions, mapMutations } from "vuex";
import htitle from "../../../components/companysecure/title";
import KeyValueSelect from "../../../components/KeyValueSelect";
import bar from "../../../components/charts/bar";
import Dictionary from "../../../util/dictionary";

const { date: { year, month }, regionCode } = Dictionary;
export default {
  components: {
    htitle,
    KeyValueSelect,
    bar
  },
  computed: {
    ...mapState("accidentArea", ["driverAccidentAreaCount"]),
    ...mapState("secureMain", ["entity_id"]),
    fetchData() {
      return {
        entity_id: this.entity_id,
        year: this.year,
        month: this.month,
        region_code: this.region
      };
    }
  },
  methods: {
    ...mapMutations("popupSecContainer", ["getComDetails"]),
    ...mapMutations("popupSecContainer", [
      "setaccidentDistributeTrendArea_show"
      // "setillegalDistributeTrendArea_show",
      // "setillegalDistributeTrendInterval_show"
    ]),
    openDetailaccidentArea() {
      // this.setillegalDistributeTrendArea_show(true);
      this.setaccidentDistributeTrendArea_show(true);
    },
    openDetail(item) {
      this.getComDetails(item);
    },
    ...mapActions("accidentArea", ["getDriverAccidentAreaCount"]),
    selectYear(item) {
      this.year = item.value;
      this.getDriverAccidentAreaCount(this.fetchData);
    },
    selectMonth(item) {
      this.month = item.value;
      this.getDriverAccidentAreaCount(this.fetchData);
    },
    selectRegion(item) {
      this.region = item.value;
      this.getDriverAccidentAreaCount(this.fetchData);
    }
  },
  data: () => ({
    yearOption: [{ label: "全部", value: null }, ...year],
    monthOption: [{ label: "全部", value: null }, ...month],
    regionOption: [{ label: "全部", value: null }, ...regionCode],
    // year: 2017,
    // month: 11,
    // region: 440000,
    year: null,
    month: null,
    region: null
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
  .change {
    margin-top: 10px;
    margin-bottom: 10px;
    height: 35.4px;
    float: right;
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
      width: 111px;
    }
    div:nth-child(4) {
      line-height: 25px;
      margin-left: 18px;
    }
    div:nth-child(5) {
      margin-left: 10px;
    }
  }
  .echart {
    // clear: both;
    height: 170px;
    margin-top: 40px;
    // background: lightblue;
  }
}
</style>
