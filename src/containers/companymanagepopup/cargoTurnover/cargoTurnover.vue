<template>
  <div>
    <!-- 日期选择 -->
    <div class="dateSelectedWrap clearfix">
      <div class="dateSelecteContent">
        <div class="title">统计周期</div>
        <div class="yearWrap">
          <key-value-select width="100px"
                            :data="yearOption"
                            :defaultValue='yearLabel'
                            @select="select('year',$event)"></key-value-select>
        </div>
        <div class="monthWrap">
          <key-value-select width="100px"
                            :data="monthOption"
                            :defaultValue='monthLabel'
                            @select="select('month',$event)"></key-value-select>
        </div>
        <div class="title">货物类型</div>
        <div class="typeWrap">
          <key-value-select width="100px"
                            :data="cargoId_name"
                            :defaultValue='cargo_label'
                            @select="select('cargo_id',$event)"></key-value-select>
        </div>
      </div>
    </div>
    <!-- bar图 -->
    <div class="turnover_by_cargo_type_bar_wrap">
      <barMore chartTheme="dark"
               :data="cargoTurnover"
               :dataZoom = true
               :color = "barMoreColor"></barMore>
    </div>
  </div>
</template>
<script>
import { mapState, mapActions } from 'vuex'
import KeyValueSelect from '../../../components/KeyValueSelect'
import barMore from '../../../components/charts/barMore'
import Dictionary from '../../../util/dictionary'
import keyGetValue from '../../../util/keyGetValue'

const { date: { year, month } } = Dictionary
export default {
  components: {
    KeyValueSelect,
    barMore,
  },
  mounted() {
    this.fetchData()
  },
  data: () => ({
    yearOption: year,
    monthOption: [{ label: '全年', value: null }, ...month],
    year: Dictionary.nowYear,
    month: Dictionary.nowMonth,
    cargo_id: '93',
    barMoreColor: [
      '#05d0eb',
      '#81d9e5',
      '#f6ffcb',
      '#e75029',
      '#038bfc',
      '#006a55',
    ],
  }),
  computed: {
    ...mapState('maintitlemsg', ['selectedEntity']),
    ...mapState('cargoTurnover', ['cargoTurnover']),
    ...mapState('companyManage', ['cargoId_name']),
    yearLabel() {
      const defaultYear = keyGetValue('value', this.year, 'label', this.yearOption)
      return defaultYear[0]
    },
    monthLabel() {
      const defaultMonth = keyGetValue('value', this.month, 'label', this.monthOption)
      return defaultMonth[0]
    },
    cargo_label() {
      const defaultLabel = keyGetValue('value', this.cargo_id, 'label', this.cargoId_name)
      return defaultLabel[0]
    },
  },
  methods: {
    ...mapActions('cargoTurnover', ['getTurnoverByCargoType']),
    ...mapActions('companyManage', ['getCargoId_name']),
    fetchData() {
      this.getTurnoverByCargoType({
        entity_id: this.selectedEntity,
        year: this.year,
        month: this.month,
        cargo_id: this.cargo_id,
      })
    },
    select(name, item) {
      // console.log('nian', item.value)
      this[name] = item.value
      this.fetchData()
    },
    // selectMonth(item) {
    //   this.month = item.value
    //   this.fetchData()
    // },
    // selectCargo(item) {
    //   this.cargo_type_code = item.value
    //   this.fetchData()
    // },
  },
  // mounted() {
  //   console.log('turnover 数据', this.cargoTurnover)
  // },

}
</script>
<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.dateSelectedWrap {
  width: 100%;
  position: relative;
  margin-top: 10px;
  .dateSelecteContent {
    @include size(556px,25px);
    float: right;
    .title {
      width: 100px;
      text-align: center;
      line-height: 25px;
      float: left;
      color: #b5b5b5;
      font-size: 14px;
      margin-right: 10px;
      margin-left: 10px;
    }
    .yearWrap {
      width: 100px;
      height: 25px;
      float: left;
      margin-right: 5px;
    }
    .monthWrap {
      width: 100px;
      height: 25px;
      float: left;
      margin-right: 5px;
    }
    .typeWrap {
      width: 100px;
      height: 25px;
      float: left;
      margin-right: 5px;
    }
  }
}
.turnover_by_cargo_type_bar_wrap {
  width: 100%;
  height: 200px;
  margin-top: 10px;
}
</style>
