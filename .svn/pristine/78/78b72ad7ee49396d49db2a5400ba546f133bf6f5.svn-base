<template>
  <div class="lineRanking">
    <div class="title">
      <span>货物流量流向分析</span>
      <div class="btn"
           @click="getDetails"></div>
    </div>
    <div class="type">
      <key-value-select :data='cargoId_name'
                        @select='selectType'
                        defaultValue='天然气[含甲烷的;液化的]'></key-value-select>
    </div>
    <div class="labeltype">货物类型</div>
    <div class="year">
      <key-value-select :data='yearOption'
                        @select='selectYear'></key-value-select>
    </div>
    <div class="labelyear">统计周期</div>
    <div class="goodsFxechart">
      <lineDoubleAxis v-if="cargoFlowArea"
                      chartTheme="dark"
                      :data="cargoFlowArea"
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
      <loading :data='cargoFlowArea'></loading>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from 'vuex'
import KeyValueSelect from '../../../components/KeyValueSelect'
import lineDoubleAxis from '../../../components/charts/lineDoubleAxis'
import Dictionary from '../../../util/dictionary'

const { date } = Dictionary
export default {
  components: {
    KeyValueSelect,
    lineDoubleAxis,
  },
  computed: {
    ...mapState('manageGoodsFx', ['cargoFlowArea']),
    ...mapState('maintitlemsg', ['selectedEntity']),
    ...mapState('companyManage', ['cargoId_name']),
    property() {
      const p = [
        {
          name: '货物量',
          type: 'bar',
          axis: 0,
        },
      ]
      return p
    },
  },
  mounted() {
    this.getCargoId_name()
  },
  methods: {
    ...mapActions('manageGoodsFx', ['getCargoFlowArea']),
    ...mapMutations('popupContainer', ['getComDetails']),
    ...mapActions('companyManage', ['getCargoId_name']),
    getDetails() {
      this.getComDetails('flowArea')
    },
    selectYear(item) {
      this.year = item.value
      this.requestCargoFlowArea()
    },
    selectType(item) {
      this.type = item.value
      this.requestCargoFlowArea()
    },
    requestCargoFlowArea() {
      this.getCargoFlowArea({
        // entity_id: this.selectedEntity ? this.selectedEntity.entity_id : 1310000010000000,
        entity_id: this.selectedEntity && this.selectedEntity,
        year: this.year,
        cargo_id: this.type,
      })
    },
  },
  data: () => ({
    yearOption: date.year,
    year: 2018,
    type: '93',
  }),
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
    position: relative;
    .btn {
      position: absolute;
      width: 20px;
      height: 6px;
      background: url("../../../assets/driver/drill_icon_on.png") no-repeat;
      top: 10px;
      right: 10px;
      cursor: pointer;
    }
  }
  .type,
  .year {
    float: right;
    width: 200px;
    height: 25px;
    color: #b5b5b5;
    margin-bottom: 10px;
  }
  .type {
    width: 196px;
  }
  .labeltype,
  .labelyear {
    width: 70px;
    height: 20px;
    float: right;
    line-height: 20px;
    margin: 0 10px 0 0;
    color: #b5b5b5;
  }
  .labeltype {
    margin: 0 10px 0 10px;
  }
  .goodsFxechart {
    height: 138px;
    clear: both;
    // background: lightblue;
  }
}
</style>