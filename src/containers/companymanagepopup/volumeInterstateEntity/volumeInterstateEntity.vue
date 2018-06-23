<template>
  <div class="cargo_flow_area_bars_wrap">
    <div class="dateSelectedWrap clearfix">
      <div class="dateSelecteContent">
        <div class="title">货物类型</div>
        <div class="typeWrap">
          <key-value-select width="100px"
                            :data="cargoId_name"
                            defaultValue='天然气[含甲烷的;液化的]'
                            @select="selectCargo"></key-value-select>
        </div>
      </div>
    </div>
    <barMore chartTheme="dark"
             :data="volumeInterstateEntity"
             :dataZoom = false
             v-if = "volumeInterstateEntity"></barMore>
    <loading :data = 'volumeInterstateEntity'></loading>
  </div>
</template>
<script>
import { mapState, mapActions } from 'vuex'
import KeyValueSelect from '../../../components/KeyValueSelect'
import barMore from '../../../components/charts/barMore'


export default {
  components: {
    KeyValueSelect,
    barMore,
  },
  computed: {
    ...mapState('volumeInterstateEntity', ['volumeInterstateEntity']),
    ...mapState('companyManage', ['cargoId_name']),
  },
  mounted() {
    this.getCargoId_name()
  },
  methods: {
    ...mapActions('volumeInterstateEntity', ['getVolumeInterstateEntity']),
    ...mapActions('companyManage', ['getCargoId_name']),
    fetchData() {
      this.getVolumeInterstateEntity({
        entity_id: this.selectedEntity ? this.selectedEntity.entity_id : 1310000010000000,
        cargo_id: this.cargo_id,
      })
    },
    selectCargo(item) {
      this.cargo_id = item.value
      this.fetchData()
    },
  },
  data: () => ({
    cargo_id: '93',
  }),
}
</script>
<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.cargo_flow_area_bars_wrap {
  width: 100%;
  height: 250px;
  margin-top: 10px;
  .dateSelectedWrap {
    width: 100%;
    position: relative;
    margin-top: 10px;
    .dateSelecteContent {
      @include size(226px,25px);
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
}
</style>