<template>
  <div class="trend">
    <div class="header">
      <htitle data='不同周期高危驾驶行为数量'></htitle>
    </div>
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
  </div>
</template>
<script>
import { mapState, mapActions } from 'vuex'
import htitle from '../../../components/companysecure/title'
import KeyValueSelect from '../../../components/KeyValueSelect'
import BarStack from '../../../components/charts/BarStack'
import Dictionary from '../../../util/dictionary'

const { date: { year, month } } = Dictionary
export default {
  components: {
    htitle,
    KeyValueSelect,
    BarStack,
  },
  computed: {
    ...mapState('quantityDriver', ['driverDangerCount']),
    ...mapState('secureMain', ['selectedEntity']),
  },
  methods: {
    ...mapActions('quantityDriver', ['getDriverDangerCount']),
    selectYear(item) {
      this.year = item.value
      this.fetchData()
    },
    selectMonth(item) {
      this.month = item.value
      this.fetchData()
    },
    fetchData() {
      this.getDriverDangerCount({
        entity_id: this.selectedEntity.entity_id,
        year: this.year,
        month: this.month,
      })
    },
  },
  data: () => ({
    yearOption: [{ label: '全部', value: null }, ...year],
    monthOption: [{ label: '全部', value: null }, ...month],
    year: 2017,
    month: 11,
  }),
}
</script>
<style lang="scss" scoped>
.trend {
  width: 100%;
  height: 240px;
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
