<template>
  <div class="trend"
       v-if="differentDateTrend_show">
    <div class="company_secure_driver_danger_outframe_wrap"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-frame @close='closeDetails'>
        <pop-up-widget title="不同周期高危驾驶行为数量"></pop-up-widget>
        <div class="change">
          <div>统计周期</div>
          <div>
            <key-value-select width='117px'
                              :data='yearOption'
                              @select='selectYear'></key-value-select>
          </div>
          <div>
            <key-value-select width='108px'
                              :data='monthOption'
                              @select='selectMonth'></key-value-select>
          </div>
        </div>
        <div class="echart">
          <loading :data='driverDangerCount'>
            <bar-stack chartTheme="dark"
                       :data='driverDangerCount'></bar-stack>
          </loading>
        </div>
        <!-- </popup-out-frame> -->
      </pop-up-frame>
    </div>
  </div>
</template>
<script>
/*eslint-disable */
import { mapState, mapActions, mapMutations } from "vuex";
import htitle from "../../../components/companysecure/title";
import KeyValueSelect from "../../../components/KeyValueSelect";
import BarStack from "../../../components/charts/BarStack";
import Dictionary from "../../../util/dictionary";
import PopUpFrame from "@/components/PopUpFrame";
import PopUpWidget from "@/components/PopUpWidget";
import PopupOutFrame from "./PopupOutFrame";

const { date: { year, month } } = Dictionary;
export default {
  components: {
    htitle,
    KeyValueSelect,
    BarStack,
    PopupOutFrame,
    PopUpWidget,
    PopUpFrame
  },
  computed: {
    ...mapState("secureMain", ["selectedEntity"]),
    ...mapState("popupSecContainer", ["differentDateTrend_show",'driverDangerCount'])
  },
  methods: {
    ...mapActions("popupSecContainer", ["getDriverDangerCount"]),
    ...mapMutations("popupSecContainer", ["setdifferentDateTrend_show"]),
    closeDetails() {
      // this.setillegalDistributeTrendInterval_show(false);
      this.setdifferentDateTrend_show(false);
    },
    selectYear(item) {
      this.year = item.value;
      this.fetchData();
    },
    selectMonth(item) {
      this.month = item.value;
      this.fetchData();
    },
    fetchData() {
      this.getDriverDangerCount({
        entity_id: this.selectedEntity,
        year: this.year,
        month: this.month
      });
    }
  },
  data: () => ({
    move: false,
    yearOption: [{ label: "全部", value: null }, ...year],
    monthOption: [{ label: "全部", value: null }, ...month],
    year: null,
    month: null
  })
};
</script>
<style lang="scss" scoped>
.trend {
  // width: 750px;
  // min-height: 200px;
  // position: absolute;
  // top: 500px;
  // left: 420px;
  width: 100%;
  min-height: 200px;
  .company_secure_driver_danger_outframe_wrap{
    width: 500px;
  }
  .header {
    width: 330px;
    height: 25px;
  }
  .change {
    font-size: 14px;
    margin-top: 10px;
    margin-bottom: 10px;
    height: 25px;
    //float: right;
    div {
      float: left;
      height: 25px;
      color: #b5b5b5;
    }
    div:nth-child(1) {
      line-height: 25px;
    }
    div:nth-child(2) {
      //width: 100px;
      margin-left: 16.8px;
      margin-right: 9.9px;
    }
    div:nth-child(3) {
      // width: 70px;
    }
  }
  .echart {
    clear: both;
    height: 170px;
    // background: lightblue;
  }
}
</style>
