<template>
  <div class="lineRanking">
    <div class="title">
      <span>里程分布</span>
    </div>
    <div class="left">
      <div class="lc"
           :class="{'selected':level1==='里程统计'}"
           @click='selectLevel1("里程统计")'>里程统计</div>
      <div class="lc"
           :class="{'selected':level1==='里程变化趋势'}"
           @click='selectLevel1("里程变化趋势")'>里程变化趋势</div>
      <div class="lc bl"
           :class="{'selected':level1==='里程分布比例'}"
           @click='selectLevel1("里程分布比例")'>里程分布比例</div>
      <div class="change">
        <div>统计周期</div>
        <!-- <div> -->
        <key-value-select width='100px'
                          :data='yearOption'
                          :defaultValue='yearLabel'
                          @select='selectYear'></key-value-select>
        <!-- </div> -->
        <!-- <div> -->
        <key-value-select width='100px'
                          :data='monthOption'
                          :defaultValue='monthLabel'
                          @select='selectMonth'></key-value-select>
        <!-- </div> -->
      </div>
      <div class="mileageDistributionEchart"
           v-if="level1==='里程统计'&&mileageStatistics">
        <loading :data='mileageStatistics'>
          <bar-more chartTheme="dark"
                    :data="mileageStatistics"
                    :color="[
                        '#05d0eb',
                        '#81d9e5',
                        '#f6ffcb',
                        '#e75029',
                        '#038bfc',
                        '#006a55',
                      ]"
                    :dataZoom=true
                    yaxisNameL="里程(公里)">
          </bar-more>
        </loading>
      </div>
      <div class="mileageDistributionEchart"
           v-if="level1==='里程变化趋势'&&mileageTrend">
        <loading :data='mileageTrend'>
          <lineDoubleAxis chartTheme="dark"
                          :data="mileageTrend"
                          :color="[
                        '#05d0eb',
                        '#81d9e5',
                        '#f6ffcb',
                        '#e75029',
                        '#038bfc',
                        '#006a55',
                      ]"
                          dataZoom=false
                          :property='property'
                          yaxisNameL="费用(万元)"
                          yaxisNameR="数量(次)"></lineDoubleAxis>
        </loading>
      </div>
      <div class="mileageDistributionEchart"
           v-if="level1==='里程分布比例'&&mileageRatio">
        <loading :data='mileageRatio'>
          <pie-rose chartTheme="dark"
                    :data='mileageRatio'></pie-rose>
        </loading>
      </div>
    </div>
    <div class="right">
      <div class="lcTitle">最高里程车辆TOP10</div>
      <div class="listTitle">
        <div v-for='(item,index) in listTitle'
             :key='index'>{{item}}</div>
      </div>
      <ul>
        <li v-for="(item,index) in topMileage"
            :key='index'>
          <div :title="item.ranking">{{item.ranking}}</div>
          <div :title="item.cljcxx&&item.cljcxx.plate_number">{{item.cljcxx&&item.cljcxx.plate_number}}</div>
          <!-- <div :title="item.qy_cdxx.entity_name">{{item.qy_cdxx.entity_name}}</div> -->
          <div :title="item.total_km">{{item.total_km}}</div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import KeyValueSelect from '../../../components/KeyValueSelect'
import Dictionary from '../../../util/dictionary'
import lineDoubleAxis from '../../../components/charts/mileageLineDoubleAxis'
import pieRose from '../../../components/charts/pieRose'
import barMore from '../../../components/charts/barMore'
import keyGetValue from '../../../util/keyGetValue'

const { date } = Dictionary
export default {
  components: {
    KeyValueSelect,
    lineDoubleAxis,
    pieRose,
    barMore,
  },
  computed: {
    ...mapState('maintitlemsg', ['selectedEntity']),
    ...mapState('manageMileageDistribution', [
      'mileageStatistics',
      'mileageTrend',
      'mileageRatio',
      'topMileage',
    ]),
    yearLabel() {
      const defaultYear = keyGetValue(
        'value',
        this.year,
        'label',
        this.yearOption,
      )
      return defaultYear[0]
    },
    monthLabel() {
      const defaultMonth = keyGetValue(
        'value',
        this.month,
        'label',
        this.monthOption,
      )
      return defaultMonth[0]
    },
    property() {
      const p = [
        {
          name: '平均里程',
          type: 'line',
          axis: 1,
        },
        {
          name: '总里程',
          type: 'line',
          axis: 0,
        },
      ]
      return p
    },
  },
  mounted() {
    this.fetchData()
    this.getHighestVehicleMileage({
      entity_id: this.selectedEntity,
      year: this.year,
      month: this.month,
    })
  },
  methods: {
    ...mapActions('manageMileageDistribution', [
      'getMileageStatistics',
      'getMileageTrend',
      'getHighestVehicleMileage',
      'getMileageRatio',
    ]),

    fetchData() {
      const action = {
        里程统计: () => {
          this.getMileageStatistics({
            entity_id: this.selectedEntity,
            // entity_id: '1310000010010000',
            year: this.year,
            month: this.month,
          })
        },
        里程变化趋势: () => {
          this.getMileageTrend({
            entity_id: this.selectedEntity,
            // entity_id: '1310000010010000',
            year: this.year,
            month: this.month,
          })
        },
        里程分布比例: () => {
          this.getMileageRatio({
            entity_id: this.selectedEntity,
            // entity_id: '1310000010010000',
            year: this.year,
            month: this.month,
          })
        },
      }
      action[this.level1]()
    },
    selectLevel1(item) {
      this.level1 = item
      this.fetchData()
    },
    selectYear(item) {
      this.year = item.value
      this.fetchData()
    },
    selectMonth(item) {
      this.month = item.value
      this.fetchData()
    },
  },

  data: () => ({
    // listTitle: ['排名', '车牌号', '车队', '里程数'],
    listTitle: ['排名', '车牌号', '里程数'],
    yearOption: [{ label: '全部', value: null }, ...date.year],
    monthOption: [{ label: '全部', value: null }, ...date.month],
    level1: '里程分布比例',
    year: Dictionary.nowYear,
    month: Dictionary.nowMonth,
  }),
}
</script>

<style lang="scss" scoped>
.lineRanking {
  width: 100%;
  height: 100%;
  .title,
  .lcTitle {
    width: 568px;
    height: 25px;
    margin-bottom: 10px;
    line-height: 25px;
    background: rgba(129, 217, 229, 0.3);
    text-indent: 20px;
    font-size: 16px;
    color: #89dddf;
  }
  .lcTitle {
    width: 200px;
  }
  .left {
    float: left;
    width: 284px;
    margin-right: 5px;
    height: 220px;
    .lc {
      width: 90px;
      height: 25px;
      box-sizing: border-box;
      color: #b5b5b5;
      font-size: 14px;
      border: 1px solid rgba(0, 191, 229, 1);
      background: rgba(0, 191, 229, 0.2);
      float: left;
      cursor: pointer;
      margin-right: 2px;
      line-height: 23px;
      text-align: center;
      margin-bottom: 10px;

      &.selected {
        background: rgba(0, 191, 229, 0.5);
        color: #ffffff;
      }
    }
    .bl {
      margin-right: 0;
    }
    // .lc:hover {
    //   background: rgba(0, 191, 229, 0.5);
    //   color: #ffffff;
    // }
    .change {
      margin-bottom: 10px;
      height: 25px;
      float: right;
      div {
        float: left;
        height: 25px;
        color: #b5b5b5;
      }
      div:nth-child(1) {
        line-height: 25px;
      }
      div:nth-child(2) {
        width: 100px;
        margin-left: 10px;
        margin-right: 5px;
      }
      div:nth-child(3) {
        width: 70px;
      }
    }
    .mileageDistributionEchart {
      clear: both;
      height: 130px;
      // background: lightblue;
    }
  }
  .right {
    float: left;
    width: 279px;
    height: 220px;
    .listTitle {
      clear: both;
      height: 25px;
      margin-bottom: 10px;
      div {
        float: left;
        height: 25px;
        margin-left: 10px;
        box-sizing: border-box;
        text-align: center;
        line-height: 22px;
        border: 1px solid #81d9e5;
        color: #b5b5b5;
        font-size: 16px;
        width: 90px;
      }
      div:nth-child(1) {
        margin-left: 0px;
        width: 60px;
      }
      div:nth-child(4) {
        width: 100px;
      }
    }
    ul::-webkit-scrollbar {
      background: rgba(0, 191, 229, 0.5);
      width: 6px;
    }
    ul::-webkit-scrollbar-thumb {
      background: rgba(0, 191, 229, 1);
    }
    ul {
      list-style: none;
      height: 145px;
      overflow-y: scroll;
      color: #b5b5b5;
      li {
        margin-bottom: 5px;
        height: 25px;
        cursor: pointer;
        div {
          float: left;
          height: 25px;
          box-sizing: border-box;
          line-height: 23px;
          text-align: center;
          border: 1px solid rgba(0, 191, 229, 1);
          background: rgba(0, 191, 229, 0.2);
          width: 90px;
          margin-left: 10px;
          overflow: hidden;
          white-space: nowrap;
          text-overflow: ellipsis;
        }
        div:nth-child(1) {
          width: 60px;
          margin-left: 0;
        }
        div:last-child {
          width: 84px;
        }
      }
      li:hover div {
        background: rgba(0, 191, 229, 0.5);
        color: #ffffff;
      }
    }
  }
}
</style>