<template>
  <div>
    <div class="dateSelectedWrap clearfix">
      <div class="dateSelecteContent">
        <div class="title">统计周期</div>
        <div class="yearWrap">
          <key-value-select width="100px"
                            :data="yearOption"
                            @select="selectYear"></key-value-select>
        </div>
        <div class="title">区域选择</div>
        <div class="monthWrap">
          <key-value-select width="100px"
                            :data="regionOption"
                            @select="selectRegion"></key-value-select>
        </div>
        <div class="title">货物类型</div>
        <div class="typeWrap">
          <key-value-select width="100px"
                            :data="cargoId_name"
                            @select="selectCargo"
                            defaultValue='天然气[含甲烷的;液化的]'></key-value-select>
        </div>
      </div>
    </div>z
    <!-- bar图 -->
    <div class="cargo_flow_area_bar_wrap">
      <barMore chartTheme="dark"
               :data="volumeStatisticsEntity"
               :dataZoom=false></barMore>
      <loading :data='volumeStatisticsEntity'></loading>
    </div>
  </div>
</template>
<script>
import { mapState, mapActions } from 'vuex'
import barMore from '../../../components/charts/barMore'
import KeyValueSelect from '../../../components/KeyValueSelect'
import Dictionary from '../../../util/dictionary'

const { date: { year }, regionCode } = Dictionary
export default {
  components: {
    barMore,
    KeyValueSelect,
  },
  computed: {
    ...mapState('volumeStatisticsEntity', ['volumeStatisticsEntity']),
    ...mapState('maintitlemsg', ['selectedEntity']),
    ...mapState('companyManage', ['cargoId_name']),
  },
  mounted() {
    this.fetchData()
    this.getCargoId_name()
  },
  data: () => ({
    yearOption: year,
    regionOption: regionCode,
    year: 2018,
    region_scope_code: 411381,
    cargo_id: '93',
  }),
  methods: {
    ...mapActions('volumeStatisticsEntity', ['getVolumeStatisticsEntity']),
    ...mapActions('companyManage', ['getCargoId_name']),
    fetchData() {
      this.getVolumeStatisticsEntity({
        year: this.year,
        region_scope_code: this.region_scope_code,
        cargo_id: this.cargo_id,
        entity_id: this.selectedEntity,
      })
    },
    selectYear(item) {
      this.year = item.value
      this.fetchData()
    },
    selectRegion(item) {
      this.region_scope_code = item.value
      this.fetchData()
    },
    selectCargo(item) {
      this.cargo_type_code = item.value
      this.fetchData()
    },
  },

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
    @include size(100%,25px);
    float: right;
    .title {
      width: 80px;
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
.cargo_flow_area_bar_wrap {
  width: 100%;
  height: 200px;
  margin-top: 10px;
  margin-bottom: 10px;
}
</style>
