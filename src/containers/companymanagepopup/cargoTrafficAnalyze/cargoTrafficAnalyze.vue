<template>
  <div>
    <!-- 货物流量区域分析 -->
    <div class="flex-between">
      <div class="flex-between">
        <div class="title">统计周期</div>
        <div class="margin-select">
          <dxj-select :data='yearOpton'
                      width='120px'
                      height='25px'></dxj-select>
        </div>

      </div>
   
      <div class="flex-between">
        <div class="title">货物类型</div>
        <div class="margin-select">
          <dxj-select :data='cargoId_name'
                      width='150px'
                      height='25px'></dxj-select>
        </div>

      </div>

    </div>
    <div style="height:200px;">
      <!-- <cargo-line></cargo-line> -->
    </div>
  </div>
</template>
<script>
import { mapState } from 'vuex'
import dictionary from '@/util/dictionary'
import cargoLine from '../../../components/charts/cargo_line'
import DxjSelect from '../../../components/companymanage/DxjSelect'

export default {
  mounted() {},
  data() {
    return {
      yearOpton: dictionary.date.year,
      monthOpton: dictionary.date.month,
    }
  },
  computed: {
    ...mapState('companyManage', ['cargoId_name']),
    ...mapState('routeInfo', ['routeInfo']),
    routeOption() {
      console.log(this.routeInfo)
      if (this.routeInfo && this.routeInfo.length > 0) {
        const routeOption = this.routeInfo.map(val => ({
          label: val.route_name,
          value: val.route_name,
        }))
        console.log(routeOption)
        return routeOption
      }
      return []
    },
  },
  components: { DxjSelect, cargoLine },
}
</script>
<style scoped>
.title {
  font-size: 16px;
  color: #b5b5b5;
}
.margin-select {
  margin: 0 10px;
}
</style>


