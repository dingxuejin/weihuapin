<template>
  <div class="lineRanking">

    <div class="flex-between">
      <div @click="active=0">
        <run-real-title title='里程分布'
                        :isDian='false'
                        width='240px'
                        class="point"
                        :isActive='active==0'></run-real-title>
      </div>

      <div @click="active=1">
        <run-real-title title='最高里程车辆'
                        :isDian='false'
                        width='150px'
                        class="point"
                        :isActive='active==1'></run-real-title>
      </div>
    </div>

    <!-- <div class="title">
      <span>里程分布</span>
    </div> -->
    <div class="left" v-if='active==0'>
      <div class="flex-between">
        <div class="lc"
             :class="{'selected':level1==='里程统计'}"
             @click='selectLevel1("里程统计")'>里程统计</div>
        <div class="lc"
             :class="{'selected':level1==='里程变化趋势'}"
             @click='selectLevel1("里程变化趋势")'>里程变化趋势</div>
        <div class="lc"
             :class="{'selected':level1==='里程分布比例'}"
             @click='selectLevel1("里程分布比例")'>里程分布比例</div>

      </div>

      <div class="change flex-between">
        <div>统计周期</div>
     
          <key-value-select 
                            :data='yearOption'
                            :defaultValue='yearLabel'
                            @select='selectYear'></key-value-select>
        
  
          <key-value-select 
                            :data='monthOption'
                            :defaultValue='monthLabel'
                            @select='selectMonth'></key-value-select>
    
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
    <div class="right"
         v-if='active==1'>
      <!-- <div class="lcTitle">最高里程车辆TOP10</div> -->
      <div class="listTitle flex-between">
        <div v-for='(item,index) in listTitle'
             :key='index'>{{item}}</div>
      </div>
      <ul>
        <li v-for="(item,index) in topMileage"
        class="flex-between"
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
import RunRealTitle from '../../../components/companymanage/RunRealTitle'

const { date } = Dictionary
export default {
  components: {
    KeyValueSelect,
    lineDoubleAxis,
    RunRealTitle,
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
    active: 0,
    month: Dictionary.nowMonth,
  }),
}
</script>

<style lang="scss" scoped>
.lineRanking {
  overflow: hidden;
  width: 400px;
  height: 270px;
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
    margin-top: 10px;
    .lc {
      width: 33.3%;
      height: 25px;
      box-sizing: border-box;
      color: #b5b5b5;
      font-size: 14px;
      border: 1px solid rgba(0, 191, 229, 1);
      background: rgba(0, 191, 229, 0.2);
      cursor: pointer;
      line-height: 23px;
      text-align: center;
      margin-bottom: 10px;

      &.selected {
        background: rgba(0, 191, 229, 0.5);
        color: #ffffff;
      }
    }

    // .lc:hover {
    //   background: rgba(0, 191, 229, 0.5);
    //   color: #ffffff;
    // }
    .change {
      margin-bottom: 10px;
      height: 25px;
      div {
        height: 25px;
        color: #b5b5b5;
      }
      div:nth-child(1) {
        line-height: 25px;
    
      }
      div:nth-child(2) {
        margin-left: 10px;
        margin-right: 5px;
            flex:1;
      }
      div:nth-child(3) {
            flex:1;
      }
    }
    .mileageDistributionEchart {
      height: 150px;
      // background: lightblue;
    }
  }
  .right {
    height: 220px;
    .listTitle {
      margin-top:10px;
      height: 30px;
      margin-bottom: 10px;
      div {
        height: 30px;
        box-sizing: border-box;
        text-align: center;
        line-height: 28px;
        border: 1px solid #81d9e5;
        color: #b5b5b5;
        font-size: 16px;
        width: 90px;
      }
      div:nth-child(1) {
        width: 80px;
      }
      div:nth-child(2) {
        width: 170px;
      }
      div:nth-child(3) {
        width: 136px;
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
      height: 180px;
      overflow-y: scroll;
      color: #b5b5b5;
      li {
        margin-bottom: 5px;
        height: 25px;
        cursor: pointer;
        div {
          height: 25px;
          box-sizing: border-box;
          line-height: 23px;
          text-align: center;
          border: 1px solid rgba(0, 191, 229, 1);
          background: rgba(0, 191, 229, 0.2);
          width: 90px;
          overflow: hidden;
          white-space: nowrap;
          text-overflow: ellipsis;
        }
        div:nth-child(1) {
          width: 80px;
        }
        div:nth-child(2) {
          width: 170px;
        }
        div:last-child {
          width: 130px;
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