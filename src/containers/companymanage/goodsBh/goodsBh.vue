<template>
  <div class="lineRanking">
    <div class="title">货物流量流向变化趋势</div>
    <div class="change">
      <key-value-select :data='yearOption'
                        width="100px"
                        @select='select("year",$event)'></key-value-select>
    </div>
    <div class="label">统计周期</div>
    <div class="type">
      <key-value-select :data='cargoId_name'
                        width="100px"
                        defaultValue='天然气[含甲烷的;液化的]'
                        @select='select("cargo_type_code",$event)'></key-value-select>
    </div>
    <div class="labeltype">货物类型</div>
    <div class="year"
         v-if="manageGoodsBh">
      <key-value-select :data='manageGoodsBh.options' :defaultValue='route'  @select='select("route",$event)'></key-value-select>
    </div>
    <div class="labelyear">线路选择</div>
    <div class="goodsBhEchart">
      <lineDoubleAxis v-if="manageGoodsBh"
                      chartTheme="dark"
                      :data="manageGoodsBh.data"
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
                      yaxisNameL="货物量(吨)"
                      yaxisNameR="百分比(%)"></lineDoubleAxis>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import lineDoubleAxis from '../../../components/charts/lineDoubleAxis'

import KeyValueSelect from '../../../components/KeyValueSelect'
import Dictionary from '../../../util/dictionary'

const { date: { year } } = Dictionary
export default {
  components: {
    KeyValueSelect,
    lineDoubleAxis,
  },
  data: () => ({
    yearOption: year.reverse(),
    entity_id: this.selectedEntity, // 1310000010000000,
    cargo_id: '93', // '93',
    year: 2018,
    route: '揭阳渔湖站-潮州英利宝站',
  }),
  mounted() {
    this.getCargoId_name()
  },
  computed: {
    ...mapState('managegoodsbh', ['manageGoodsBh']),
    // ...mapState('driverbase', ['ryjb']),
    ...mapState('maintitlemsg', ['selectedEntity']),
    ...mapState('companyManage', ['cargoId_name']),
    property() {
      const p = [
        {
          name: '货物量',
          type: 'bar',
          axis: 0,
        },
        {
          name: '货物量环比',
          type: 'line',
          axis: 1,
        },
        {
          name: '货物量同比',
          type: 'line',
          axis: 1,
        },
      ]
      return p
    },
  },
  methods: {
    ...mapActions('managegoodsbh', ['getManageGoodsBh']),
    ...mapActions('companyManage', ['getCargoId_name']),
    fetch() {
      this.getManageGoodsBh({
        entity_id: this.selectedEntity && this.selectedEntity,
        year: this.year,
        cargo_id: this.cargo_type_code,
        route: this.route,
      })
    },

    select(name, item) {
      this[name] = item.value
      this.fetch()
    },

  },
}
</script>

<style lang="scss" scoped>
.lineRanking {
  width: 100%;
  height: 100%;
  .title {
    width: 568px;
    height: 25px;
    margin-bottom: 10px;
    line-height: 25px;
    background: rgba(129, 217, 229, 0.3);
    text-indent: 20px;
    font-size: 16px;
    color: #89dddf;
    float: left;
  }
  .change {
    float: right;
    width: 104px;
    height: 25px;
    color: #b5b5b5;
    margin-bottom: 10px;
    margin-right:6px;
  }
  .label {
    line-height: 25px;
    float: right;
    margin-right: 10px;
    color: #b5b5b5;
  }
  .type,
  .year {
    float: right;
    width: 105px;
    height: 25px;
    color: #b5b5b5;
    margin-bottom: 10px;
  }
  .type {
    width: 107px;
  }
  .labeltype,
  .labelyear {
    width:70px;
    height:20px;
    float: right;
    line-height: 20px;
    margin: 0 10px;
    color: #b5b5b5;
  }
  .labelyear{
     margin: 0 10px 0 0;
  }
  .goodsBhEchart {
    height: 138px;
    clear: both;
    // background: lightblue;
  }
}
</style>