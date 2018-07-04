<template>
  <div>
    <!-- 运单数和周转统计 -->
    <div class="flex-between">
      <div class="flex-between">
        <div class="title">统计周期</div>
        <div class="margin-select">
          <dxj-select :data='yearOpton'
                      width='120px'
                      height='25px'></dxj-select>
        </div>
        <div>
          <dxj-select :data='monthOpton'
                      width='120px'
                      height='25px'></dxj-select>
        </div>
      </div>
      <div class="zidingyi"
           :class="{zidingyiactive:show}"
           @click="clickShow()">自定义</div>
    </div>
    <div style="height:200px;">
      <!-- <cargo-line></cargo-line> -->
    </div>
      <user-custom :isShow.sync="show"
                   @close='show=false'
                   left='1200px'
                   top='150px'>
        <div class="flex-between">
          <div class="flex-start">
            <div class="title">
              统计周期
            </div>
            <div class="margin-select">
              <dxj-select :data='yearOpton'
                          width='100px'
                          height='30px'></dxj-select>
            </div>
          </div>
          <div>
            <dxj-multiple-select width='120px'
                                 height='30px'
                                 :data.sync='monthMultipleOpton'
                                 @multipleSelect="multipleSelect"></dxj-multiple-select>
          </div>
        </div>
      </user-custom>
    </div>
</template>
<script>
import { mapState, mapActions } from 'vuex'
import dictionary from '@/util/dictionary'
import cargoLine from '../../../components/charts/cargo_line'
import DxjSelect from '../../../components/companymanage/DxjSelect'
import DxjMultipleSelect from '../../../components/companymanage/DxjMultipleSelect'
import userCustom from '../userCustom/userCustom'

export default {
  mounted() {
    this.requireFetch()
  },
  data() {
    return {
      show: false,
      yearOpton: dictionary.date.year,
      monthMultipleOpton: dictionary.date.month,
      monthOpton: [{ label: '全部', value: null }, ...dictionary.date.month],
    }
  },
  computed: {
    ...mapState('companyManage', ['cargoId_name']),
    ...mapState('maintitlemsg', ['selectedEntity']),
  },
  methods: {
    ...mapActions('waybillAndTurnoverStatistics', ['requireTbSubjectQyMYRydAndHwzzl']),
    multipleSelect(data) {
      console.log(data)
    },
    requireFetch() {
      this.requireTbSubjectQyMYRydAndHwzzl({
        entity_id: this.selectedEntity,
        // entity_id: this.selectedEntity,
      })
    },
    clickShow() {
      this.show = !this.show
    },
  },
  components: { DxjSelect, cargoLine, DxjMultipleSelect, userCustom },
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
.zidingyi {
  color: #afb0b1;
  background: #2d484c;
  font-size: 14px;
  padding: 5px 30px;
}
.zidingyiactive {
  color: #54d0df;
  background: #093254;
  font-size: 14px;
  padding: 5px 30px;
}
</style>


