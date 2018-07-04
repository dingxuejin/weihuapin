<template>
  <div class="WaybillConditionDaily_contend">
      <div class="title_part">
          <div>运单编号</div>
          <div>货物名称</div>
          <div>货物量</div>
          <div>客户</div>
          <div>运单状态</div>
      </div>
      <!-- 循环遍历部分 -->
    <div class="ergodic_container">
      <div class="loop_ergodic_part" v-for="(item,index) in wallbill" :key="index">
        <div :title="item.waybill_id" @click="clickthis(index,item.waybill_id)" :class='{active:selectedOne===index}'>{{item.waybill_id}}</div>
        <div :title="item.cargo_common_name" :class='{active:selectedOne===index}'>{{item.cargo_common_name}}</div>
        <div :title="item.volume" :class='{active:selectedOne===index}'>{{item.volume}}</div>
        <div :title="item.partner_name" :class='{active:selectedOne===index}'>{{item.partner_name}}</div>
        <div :title="item.ydzt.waybill_status" :class='{active:selectedOne===index}'>{{item.ydzt.waybill_status}}</div> 
      </div>
    </div>
  </div>
</template>

<script type="text/javascript">
import { mapState, mapMutations, mapActions } from 'vuex'

export default {
  name: '',
  components: {
  },
  computed: {
    ...mapState('DailyManageLedger', ['wallbill']),
  },
  methods: {
    ...mapMutations('popupContainer', ['getComDetails']),
    ...mapActions('DailyManageLedger', ['setSeletedWallbill']),
    clickthis(index, waybillId) {
      this.selectedOne = index
      this.getComDetails('waybillConditionDaily')
      const selectedWallbillArr = this.wallbill.filter(item => waybillId === item.waybill_id)
      this.setSeletedWallbill(selectedWallbillArr[0])
    },
  },
  data() {
    return {
      selectedOne: 0,
    }
  },
}
</script>

<style lang="scss" scoped>
.WaybillConditionDaily_contend{
    width: 100%;
    height: 100%;
    .title_part{
        width: 100%;
        height: 29px;
        div{
            float: left;
            height: 29px;
            border: 1px solid #81D9E5;
            text-align: center;
            line-height: 27px;
            color: #B5B5B5 ;
            font-size: 16px;
            box-sizing: border-box;
        }
        div:nth-child(n+2){
            margin-left: 10px;
        }
        div:nth-child(1){
            width: 128px;
        }
        div:nth-child(2){
            width: 89px;
        }
        div:nth-child(3){
            width: 77px;
        }
        div:nth-child(4){
            width: 116px;
        }
        div:nth-child(5){
            width: 98px; 
        }
    }
    .ergodic_container{
        height: 265px;
        width: 100%;
        overflow-y: auto;
        margin-top: 11px;
        .loop_ergodic_part:nth-child(n+2){
            margin-top: 11px;
        }
        .loop_ergodic_part{
        width: 100%;
        height: 24px;
        .active{
            background: rgba(5,208,235,0.20);
        }
        div{
            float: left;
            height: 24px;
            border: 1px solid #81D9E5;
            background: rgba(5,208,235,0.50);
            text-align: center;
            line-height: 24px;
            color: #fff ;
            font-size: 14px;
            overflow: hidden;
            white-space: nowrap;
            text-overflow: ellipsis;
            padding: 0 5px;
            box-sizing: border-box;
        }
        div:nth-child(n+2){
            margin-left: 10px;
        }
        div:nth-child(1){
            width: 128px;
            cursor: pointer;
        }
        div:nth-child(2){
            width: 89px;
        }
        div:nth-child(3){
            width: 77px;
        }
        div:nth-child(4){
            width: 116px;
        }
        div:nth-child(5){
            width: 98px; 
        }
    }
    }
    .ergodic_container::-webkit-scrollbar {
        background: #69A3B1;
        width: 2px;
    }
    .ergodic_container::-webkit-scrollbar-thumb {
        background: #05D0EB ;
        width: 4px;
    }
}
</style>