<template>
  <div>
    <!-- 客户运量统计 -->
    <div class="flex-between">
      <div class="flex-between">
        <div class="title">客户</div>
        <div class="margin-select">
          <dxj-select :data='yearOpton'
                      width='100px'
                      height='25px'></dxj-select>
        </div>
      </div>
      <div class="flex-between">
        <div class="title">统计周期</div>
        <div class="margin-select">
          <dxj-select :data='yearOpton'
                      width='100px'
                      height='25px'></dxj-select>
        </div>
        <div>
          <dxj-select :data='monthOpton'
                      width='80px'
                      height='25px'></dxj-select>
        </div>
      </div>
      <div class="zidingyi"
      :class="{zidingyiactive:show}"
           @click="clickShow()">自定义</div>
    </div>
    <div style="height:500px;">
      <!-- <cargo-line></cargo-line> -->
    </div>
    <user-custom :isShow.sync="show"
                 @close='show=false'
                 left='1200px'
                 top='300px'>
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
import { mapState } from 'vuex'
import dictionary from '@/util/dictionary'
import cargoLine from '../../../components/charts/cargo_line'
import DxjSelect from '../../../components/companymanage/DxjSelect'
import DxjMultipleSelect from '../../../components/companymanage/DxjMultipleSelect'
import userCustom from '../userCustom/userCustom'

export default {
  mounted() {},
  data() {
    return {
      show: false,
      yearOpton: dictionary.date.year,
      monthOpton: [{ label: '全部', value: null }, ...dictionary.date.month],
      monthMultipleOpton: dictionary.date.month,
    }
  },
  methods: {
    multipleSelect(data) {
      console.log(data)
    },
    clickShow() {
      this.show = !this.show
    },
  },
  computed: {
    ...mapState('companyManage', ['cargoId_name']),
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
.cargo-type{
    width:300px;
    margin: 10px 10px 10px 0;
}
</style>


