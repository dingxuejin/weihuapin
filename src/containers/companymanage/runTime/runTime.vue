<template>
  <div class="trend">
    <div class="header">
      <htitle data='运输时段运行车辆次数分布'></htitle>
    </div>
    <div class="change">
      <div>统计周期</div>
      <div>
        <!-- <hselect width='100px' :data='["2017年","2016年","2015年","2014年"]'></hselect> -->
        <key-value-select width="160px"
                          :data="yearData"
                          :defaultValue="yearLabel"
                          @select='select("year",$event)'></key-value-select>
      </div>
      <div>
        <!-- <hselect width='70px' :data='["-","1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"]'></hselect> -->
        <key-value-select width='160px'
                          :data='monthData'
                           :defaultValue="monthLabel"
                          @select='select("month",$event)'></key-value-select>
      </div>
    </div>
    <div class="runTimeEchart" >
      <radar v-if="vehicleQuantity" :data='vehicleQuantity' chartTheme="dark" ></radar>
      <loading :data='vehicleQuantity'></loading>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import htitle from '../../../components/companysecure/title'
import KeyValueSelect from '../../../components/KeyValueSelect'
import Radar from '../../../components/charts/runTimeRadar'
import Dictionary from '../../../util/dictionary'
import keyGetValue from '../../../util/keyGetValue'

const { date: { year, month } } = Dictionary
export default {
  components: {
    htitle,
    KeyValueSelect,
    Radar,
  },
  mounted() {
    this.fetchData()
  },
  data() {
    return {
      yearData: year,
      monthData: [{ label: '全年', value: null }, ...month],
      year: Dictionary.nowYear,
      month: Dictionary.nowMonth,
    }
  },
  computed: {
    ...mapState('manageRunTime', ['vehicleQuantity']),
    ...mapState('maintitlemsg', ['selectedEntity']),
    yearLabel() {
      const defaultYear = keyGetValue('value', this.year, 'label', this.yearOption)
      return defaultYear[0]
    },
    monthLabel() {
      const defaultMonth = keyGetValue('value', this.month, 'label', this.monthData)
      return defaultMonth[0]
    },
  },
  methods: {
    ...mapActions('manageRunTime', ['getVehicleQuantity']),
    fetchData() {
      this.getVehicleQuantity({
        entity_id: this.selectedEntity,
        year: this.year,
        month: this.month,
      })
    },

    // 筛选方法
    select(name, item) {
      this[name] = item.value
      // console.log('时间段 select', item)
      this.fetchData()
    },
  },

}
</script>

<style lang="scss" scoped>
.trend {
  width: 100%;
  height: 265px;
  .header {
    width: 403px;
    height: 25px;
  }
  .change {
    margin-top: 10px;
    margin-bottom: 10px;
    height: 25px;
    float: left;
    div {
      float: left;
      height: 25px;
      color: #b5b5b5;
    }
    div:nth-child(1) {
      line-height: 25px;
        // width:160px;
    }
    div:nth-child(2) {
      width: 160px;
      margin-left: 10px;
      margin-right: 5px;
    }
    div:nth-child(3) {
      width: 160px;
    }
  }
  .runTimeEchart {
    clear: both;
    height: 190px;
    // background: lightblue;
  }
}
</style>
