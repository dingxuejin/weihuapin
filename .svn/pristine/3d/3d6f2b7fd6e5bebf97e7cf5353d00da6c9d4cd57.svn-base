<template>
  <div>
    <div class="dateSelectedWrap clearfix">
      <div class="dateSelecteContent">
        <div class="title">统计周期1</div>
        <div class="yearWrap">
          <key-value-select width="100px"
                            :defaultValue='yearLabel'
                            :data="yearOption"
                            @select="selectYear"></key-value-select>
        </div>
        <div class="monthWrap">
          <key-value-select width="100px"
                            :defaultValue=' monthLabel'
                            :data="monthOption"
                            @select="selectMonth"></key-value-select>
        </div>
        <div class="title">货物类型</div>
        <div class="typeWrap">
          <key-value-select width="100px"
                            :defaultValue='cargo_label'
                            :data="cargoId_name"
                            @select="selectCargo"></key-value-select>
        </div>
      </div>
    </div>
    <!-- bar图 -->
    <div class="volume_by_cargo_type_bar_wrap">
      <barMore chartTheme="dark"
               :data="volumeByCargoType"
               :dataZoom=true></barMore>
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
  data: () => ({
    yearOption: year,
    monthOption: [{ label: '全年', value: null }, ...month],
    year: Dictionary.nowYear,
    month: Dictionary.nowMonth,
    cargo_id: '93',
  }),
  mounted() {
    this.fetchData()
    this.getCargoId_name()
  },
  computed: {
    ...mapState('cargoVolume', ['volumeByCargoType']),
    ...mapState('maintitlemsg', ['selectedEntity']),
    ...mapState('companyManage', ['cargoId_name']),
    cargo_label() {
      const defaultLabel = keyGetValue(
        'value',
        this.cargo_id,
        'label',
        this.cargoId_name,
      )
      return defaultLabel[0]
    },
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
  },
  methods: {
    ...mapActions('cargoVolume', ['getVolumeByCargoType']),
    ...mapActions('companyManage', ['getCargoId_name']),
    fetchData() {
      this.getVolumeByCargoType({
        // entity_id: this.selectedEntity.entity_id,
        entity_id: this.selectedEntity,
        year: this.year,
        month: this.month,
        cargo_id: this.cargo_id,
      })
    },
    selectYear(item) {
      this.year = item.value
      this.fetchData()
    },
    selectMonth(item) {
      this.month = item.value
      this.fetchData()
    },
    selectCargo(item) {
      this.cargo_id = item.value
      this.fetchData()
    },
  },
}
</script>
<style lang="scss" scoped>
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.dateSelectedWrap {
  width: 100%;
  position: relative;
  margin-top: 10px;
  .dateSelecteContent {
    @include size(556px, 25px);
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
.volume_by_cargo_type_bar_wrap {
  width: 100%;
  height: 200px;
  margin-top: 10px;
}
</style>
