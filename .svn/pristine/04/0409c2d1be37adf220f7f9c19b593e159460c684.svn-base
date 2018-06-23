<template>
    <div class="pop">
        <PopUpFrame @close='up'>
            <PopUpWidget title='车辆基本信息'>
                <div class="carMsg">
                    <div><centerCarPop name='车辆车牌' :value="carBaseInfo.plate_number"></centerCarPop></div>
                    <div><centerCarPop name='车牌颜色' :value="carBaseInfo.plate_color"></centerCarPop></div>
                    <div><centerCarPop name='机构'  :value="carBaseInfo.entity_name"></centerCarPop></div>
                    <div><centerCarPop name='车辆类别'  :value="carBaseInfo.vehicle_category"></centerCarPop></div>
                    <div><centerCarPop name='车辆品牌'  :value="carBaseInfo.vehicle_brand"></centerCarPop></div>
                    <div><centerCarPop name='车辆型号'  :value="carBaseInfo.vehicle_model"></centerCarPop></div>
                    <div><centerCarPop name='燃油类型'  :value="carBaseInfo.fuel_type"></centerCarPop></div>
                    <div><centerCarPop name='车辆出厂日期'  :value="carBaseInfo.date_of_production"></centerCarPop></div>
                    <div><centerCarPop name='机构使用时间'  :value="carBaseInfo.date_of_work"></centerCarPop></div>
                </div>
            </PopUpWidget>
        </PopUpFrame>
    </div>
</template>

<script>
import { mapState } from 'vuex'
import PopUpFrame from '@/components/PopUpFrame'
import PopUpWidget from '@/components/PopUpWidget'
import centerCarPop from '../../../components/company/centerCarPop'

export default{
  components: {
    PopUpFrame,
    PopUpWidget,
    centerCarPop,
  },
  computed: {
    ...mapState('centerPopup', ['carBaseInfo']),
  },
  methods: {
    up() {
      this.$emit('upx')
    },
  },
}
</script>

<style lang="scss" scoped>
.pop{
    width:750px;
}
.carMsg{
    height: 190px;
    div{
        width:350px;
        height: 30px;
        float: left;
        margin-bottom:10px;
    }
    div:nth-child(odd){
        margin-right: 10px;
    }
}
</style>