<template>
  <div class="boxx">
    <div class="header">
      <htitle data='机构得分变化趋势' style="height: 30px;line-height: 30px;"></htitle>
    </div>
    <div class="select">
      <div>统计周期</div>
      <div>
        <key-value-select width='339px'
                          :data='yearOption'
                          defaultValue="2017年"
                          @select='select'></key-value-select>
      </div>
    </div>
    <div>
      <loading :data="getChartData">
        <lineDoubleAxis chartTheme="dark"
                        :data="getChartData"
                        :color=color
                        ataZoom=false
                        :property='property'
                        yaxisNameL="分数(分)"></lineDoubleAxis>
        <!-- <loading :data='entityScoreTrend'></loading> -->
      </loading>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
import htitle from '../../../components/companysecure/title'
import keyValueSelect from '../../../components/KeyValueSelect'
// import Dictionary from '../../../util/dictionary'
import lineDoubleAxis from '../../../components/charts/lineDoubleAxis'
import xxx from '../../../util/dictionary'

// const { date } = Dictionary

export default {
  components: {
    htitle,
    keyValueSelect,
    lineDoubleAxis,
  },
  data: () => ({
    yearOption: [...xxx.date.year],
    color: ['#05d0eb', '#81d9e5', '#f6ffcb', '#e75029', '#038bfc', '#006a55'],
    yearValue: 2017,
    // entity_id: 1310000010010000,
    // entity_id: this.selectedEntity.entity_id || 1310000010010000,
  }),
  computed: {
    ...mapState('insitutionChange', ['entityScoreTrend']),
    ...mapState('secureMain', ['entity_id']),
    property() {
      return [
        {
          name: '得分',
          type: 'line',
          axis: 0,
        },
      ]
    },
    // 获取chart数据
    getChartData() {
      if (this.entityScoreTrend) {
        return this.entityScoreTrend
      }
      return null
    },
    // 设置参数
    getQueryParams() {
      return {
        // entity_id: this.entity_id,
        entity_id: 1310000010010000,
        year: this.yearValue,
      }
    },
  },
  methods: {
    ...mapActions('insitutionChange', ['getEntityScoreTrend']),
    select(item) {
      this.yearValue = item.value
      this.getEntityScoreTrend(this.getQueryParams)
    },
  },
  mounted() {
    this.getEntityScoreTrend(this.getQueryParams)
  },
}
</script>

<style lang="scss" scoped>
.boxx {
  width: 413px;
  height: 295px;
  margin-left: 17px;
  margin-top: 10px;
  .header {
    width: 413px;
    height: 30px;
    font-size: 14px;
  }
  .select {
    margin-top: 10px;
   // float: right;
    div {
      float: left;
      margin-bottom: 10px;
    }
    div:nth-child(1) {
      line-height: 25px;
      margin-right: 10px;
      color: #b5b5b5;
    }
    div:nth-child(2) {
      width: 160px;
      height: 25px;
    }
  }
  div:nth-child(3) {
    width: 100%;
    height: 225px;
    // background: lightblue;
    clear: both;
  }
}
</style>
