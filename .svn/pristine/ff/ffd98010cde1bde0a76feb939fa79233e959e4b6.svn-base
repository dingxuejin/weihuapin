<template>
  <div class="alarmEventRankIrregularities">
    <div class="header">
      <span>报警事件排名（风险因素排名）</span>
    </div>
    <div class="alarmEventRankIrregularities_title">{{title}}</div>
    <div class="alarmEventRankIrregularities_select">
      <div :class='{show:period=="y"}'
           @click='showtoggle("y")'>当年</div>
      <div :class='{show:period=="m"}'
           @click='showtoggle("m")'>当月</div>
    </div>
    <div class="alarmEventRankIrregularities_content"
         v-if="period=='y'&&Irregularities&&Irregularities!==null">
      <barhor chartTheme="dark"
              v-if="getIrregularitiesYearData"
              :data="getIrregularitiesYearData"
              :color="barhorColor"></barhor>
    </div>
    <div class="alarmEventRankIrregularities_content"
         v-if="period=='m'&&Irregularities&&Irregularities!==null">
      <barhor chartTheme="dark"
              v-if="getIrregularitiesMonthData"
              :data="getIrregularitiesMonthData"
              :color="barhorColor"></barhor>
    </div>
    <!-- <div class="alarmEventRankIrregularities_content">
      <barhor chartTheme="dark"
              v-if="barhorData"
              :data="barhorData"
              :color="barhorColor"></barhor>
    </div> -->
  </div>
</template>

<script>
/*eslint-disable*/
import { mapState, mapActions } from "vuex";

import barhor from "../../../components/charts/barhor";

export default {
  components: {
    barhor
  },
  data: () => ({
    title: "高频违规行为",
    barhorData: [
      {
        data: [
          {
            name: "左顾右盼",
            value: 114
          },
          {
            name: "分身提醒",
            value: 60
          },
          {
            name: "变道频次",
            value: 20
          },
          {
            name: "急加速",
            value: 30
          },
          {
            name: "车距过近",
            value: 15
          }
        ]
      }
    ],
    barhorColor: ["#05d0eb", "#81d9e5", "#f6ffcb", "#e75029", "#038bfc"],
    period: "y",
    year: 2017,
    month: 11
  }),
  computed: {
    ...mapState("alarmEventRankIrregularities", ["Irregularities"]),
    ...mapState("secureMain", ["entity_id"]),
    getIrregularitiesYearData() {
      return [
        {
          data: this.Irregularities.thisYear
            .map(item => ({
              name: item.jssjlx.drive_event_type,
              value: item.total_irregularity_drive
            }))
            .sort((a, b) => Number(b.value) - Number(a.value))
        }
      ];
    },
    getIrregularitiesMonthData() {
      return [
        {
          data: this.Irregularities.thisMonth
            .map(item => ({
              name: item.jssjlx.drive_event_type,
              value: item.total_irregularity_drive
            }))
            .sort((a, b) => Number(b.value) - Number(a.value))
        }
      ];
    },
    fetchYear() {
      return {
        entity_id: this.entity_id,
        year: this.year
      };
    },
    fetchMonth() {
      return {
        entity_id: this.entity_id,
        year: this.year,
        month: this.month
      };
    }
  },
  methods: {
    ...mapActions("alarmEventRankIrregularities", ["getIrregularities"]),
    showtoggle(item) {
      this.period = item;
      if (item === "y") {
        this.getIrregularities(this.fetchYear);
      } else if (item === "m") {
        this.getIrregularities(this.fetchMonth);
      }
    }
  },
  mounted() {
    // console.log(this.Irregularities)
  }
};
</script>

<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.alarmEventRankIrregularities {
  @include size(100%, 240px);
  .header {
    @include size(100%, 25px);
    background: rgba(129, 217, 299, 0.3);
    position: relative;
    font-size: 16px;
    color: #89dddf;
    line-height: 25px;
    text-indent: 20px;
  }
  &_title {
    @include size(200px, 25px);
    line-height: 25px;
    background: rgba(231, 80, 41, 0.3);
    color: #e75029;
    font-size: 16px;
    text-align: center;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    margin-left: 21px;
    margin-top: 12px;
    float: left;
  }
  &_select {
    @include size(200px, 25px);
    float: right;
    margin-top: 12px;
    div {
      @include size(100px, 25px);
      box-sizing: border-box;
      color: #b5b5b5;
      text-align: center;
      line-height: 23px;
      background: rgba(0, 191, 229, 0.2);
      border: 1px solid rgba(0, 191, 229, 1);
      cursor: pointer;
      float: left;
    }
    .show {
      color: #ffffff;
      background: rgba(0, 191, 229, 0.5);
    }
  }
  &_content {
    // @include size(100%, 185px);
    @include size(100%, 285px);
    float: left;
    .echarts {
      width: 100%;
    }
  }
}
</style>
