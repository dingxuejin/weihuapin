<template>
  <div class="waybillConditionDailyPopup_content">
      <div class="title_part">
        <div class="title_text">运单状况日报</div>
        <div class="leading_out"><a :href="leadOutUrl" download="运单状况日报.xlsx">导出</a></div>
      </div>
      <div class="institution">
        <div class="institution_text">所属机构</div>
        <div class="institution_belong"><div></div>{{seletedWallbill.entity_name}}</div>
      </div>
      <div class="detailContent">
        <div class="secondTitle_one">运单基本信息</div>
        <div class="waybillBasicInfo">
          <div class="waybillBasicInfo_left">
            <div class="oneItem" v-for="(item,index) in waybillBasicInfo_left_items" :key="index">
              <div class="itemName">{{item.name}}</div>
              <div class="itemValue" :title="item.value"><div></div>{{item.value||'空'}}</div>
            </div>
          </div>
          <div class="waybillBasicInfo_right">
            <div class="oneItem" v-for="(item,index) in waybillBasicInfo_right_items" :key="index">
              <div class="itemName">{{item.name}}</div>
              <div class="itemValue" :title="item.value"><div></div>{{item.value||'空'}}</div>
            </div>
          </div>
        </div>
        <div class="secondTitle_two">派车信息</div>
        <div class="dispatchInfo">
          <div class="dispatchInfo_left">
            <div class="oneItem" v-for="(item,index) in dispatchInfo_left_items" :key="index">
              <div class="itemName">{{item.name}}</div>
              <div class="itemValue" :title="item.value"><div></div>{{item.value||'空'}}</div>
            </div>
          </div>
          <div class="dispatchInfo_right">
            <div class="oneItem" v-for="(item,index) in dispatchInfo_right_items" :key="index">
              <div class="itemName">{{item.name}}</div>
              <div class="itemValue" :title="item.value"><div></div>{{item.value||'空'}}</div>
            </div>
          </div>
        </div>
      </div>
  </div>
</template>

<script type="text/javascript">
import { mapState } from 'vuex'

export default {
  name: '',
  components: {
  },
  computed: {
    ...mapState('DailyManageLedger', ['seletedWallbill', 'selectedYear', 'selectedMonth', 'selectedDay']),
    ...mapState('maintitlemsg', ['selectedEntity']),
    waybillBasicInfo_left_items() {
      const waybillBasicInfo_left_items = [
        { name: '运单编号', value: this.seletedWallbill.waybill_id },
        { name: '货物量', value: this.seletedWallbill.volume },
        { name: '客户名称', value: this.seletedWallbill.partner_name },
        { name: '客户联系电话', value: this.seletedWallbill.phone_number },
        { name: '提货地联系人', value: this.seletedWallbill.source_name },
        { name: '要求到提货时间', value: this.seletedWallbill.arrival_source_time },
        { name: '送货地', value: this.seletedWallbill.destination_db_name },
        { name: '送货地联系电话', value: this.seletedWallbill.destination_phone_number },
        { name: '实际到送货地时间', value: this.seletedWallbill.actual_destination_time },
        { name: '实际路桥费', value: this.seletedWallbill.actual_toll_cost },
        { name: '人员成本（元）', value: this.seletedWallbill.employee_cost },
        { name: '接单时间', value: this.seletedWallbill.create_time },
      ]
      // console.log('人员成本（元）', this.seletedWallbill.employee_cost)
      return waybillBasicInfo_left_items
    },
    waybillBasicInfo_right_items() {
      const waybillBasicInfo_right_items = [
        { name: '货物名称', value: this.seletedWallbill.cargo_common_name },
        { name: '运单金额', value: this.seletedWallbill.money },
        { name: '客户联系人', value: this.seletedWallbill.contact_name },
        { name: '提货地', value: this.seletedWallbill.source_db_name },
        { name: '提货地联系电话', value: this.seletedWallbill.source_phone_number },
        { name: '实际到提货地时间', value: this.seletedWallbill.actual_source_time },
        { name: '送货地联系人', value: this.seletedWallbill.destination_name },
        { name: '要求到送货地时间', value: this.seletedWallbill.arrival_destination_time },
        { name: '实际耗油量（升）', value: this.seletedWallbill.actual_fuel_cost },
        { name: '运单状态', value: this.seletedWallbill.ydzt.waybill_status },
        { name: '完成时间', value: this.seletedWallbill.finish_time },
      ]
      return waybillBasicInfo_right_items
    },
    dispatchInfo_left_items() {
      const dispatchInfo_left_items = [
        { name: '驾驶员', value: this.seletedWallbill.driver_name },
        { name: '牵引车', value: this.seletedWallbill.tractor },
        { name: '押运员', value: this.seletedWallbill.supercargo_name },
        { name: '指定线路', value: this.seletedWallbill.route_name },
        { name: '标准重车里程', value: this.seletedWallbill.heavy_km },
      ]
      return dispatchInfo_left_items
    },
    dispatchInfo_right_items() {
      const dispatchInfo_right_items = [
        { name: '驾驶员电话', value: this.seletedWallbill.driver_phone_number },
        { name: '挂车', value: this.seletedWallbill.trailer },
        { name: '押运员电话', value: this.seletedWallbill.supercargo_phone_number },
        { name: '里程(km)', value: this.seletedWallbill.km },
      ]
      return dispatchInfo_right_items
    },
  },
  methods: {
  },
  data() {
    return {
      leadOutUrl: `http://172.30.7.103:3033/company_manage_day_accounts?entity_id=${this.selectedEntity}&year=${this.selectedYear}&month=${this.selectedMonth}&day=${this.selectedDay}&exportxlsx=运单`,
    }
  },
}
</script>

<style lang="scss" scoped>
.waybillConditionDailyPopup_content{
    width: 571px;
    height: 588px;
    background: rgba(3,139,252,0.10);
    border: 1px solid #89DDDF;
    .title_part{
      width: 100%;
      height: 39px;
      background: rgba(3,139,252,0.4);
      margin-top: 20px;
      .title_text{
        width: 360px;
        height: 39px;
        border: solid 2px rgba(5,208,235,1);
        text-align: center;
        padding: 0 5px;
        box-sizing: border-box;
        font-size: 18px;
        color: #fff;
        overflow: hidden;
        text-overflow: ellipsis;
        line-height: 39px;
        float: left;
      }
      .leading_out{
        width: 80px;
        height: 25px; 
        float: right;
        margin-right: 15px;
        margin-top: 7px;
        background: #05D0EB;
        text-align: center;
        line-height: 25px;
        font-size: 14px;
        cursor: pointer;
        a{
          text-decoration: none;
          color: #fff;
          display: block;
          width: 100%;
          height: 100%;
        }
      }
    }
    .institution{
      width: 348px;
      height: 50px;
      margin-left: 10px;
      background: rgba(9,122,206,0.2);
      margin-top: 9px;
      div{
        float: left;
      }
      .institution_text{
        width: 109px;
        height: 100%;
        text-align: center;
        line-height: 50px;
        font-size: 16px;
        color: #89DDDF;
      }
      .institution_belong{
        width: 198px;
        height: 40px;
        border: solid 1px rgba(5,208,235,1);
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        margin-top: 5px;
        padding: 12px 0 0 8px;
        font-size: 12px;
        color: #fff;
          div{
            display: inline-block;
            width: 8px;
            height: 8px;
            transform: rotate(45deg);
            background: #05D0EB;
            margin-top: 2px;
            margin-right: 4px;
          }
      }
    }
    .detailContent{
      width: 551px;
      height: 460px;
      margin: 0 auto;
      margin-top: 10px;
      overflow-y: scroll;
      .secondTitle_one{
        width: 100%;
        height: 35px;
        background-color: rgba(129,217,229,0.08);
        text-align: center;
        line-height: 35px;
        font-size: 16px;
        color: #89DDDF;
      }
      .waybillBasicInfo{
        width: 100%;
        height: 611px;
        margin-top: 5px;
        div{
          float: left;
        }
        .waybillBasicInfo_left{
          width: 270px;
          height: 611px;
          background-color: rgba(9,122,206,0.2);
          padding: 11px 8px;
          box-sizing: border-box;
          div:nth-child(n+2){
            margin-top: 10px;
          }
          .oneItem{
            width: 100%;
            height: 40px;
            div{
              float: left;
            }
            .itemName{
              width: 102px;
              height: 40px;
              color: #89DDDF;
              font-size: 16px;
              text-align: center;
              padding-top:10px;
              box-sizing: border-box;
            }
            .itemValue{
              width: 148px;
              height: 40px;
              margin-left: 2px;
              border: solid 1px rgba(5,208,235,1);
              box-sizing: border-box;
              margin: 0;
              padding: 0;
              margin-top: 5px;
              padding: 12px 0 0 8px;
              font-size: 12px;
              color: #fff;
              overflow: hidden;
              text-overflow: ellipsis;
              white-space: nowrap;
                div{
                  display: inline-block;
                  width: 8px;
                  height: 8px;
                  transform: rotate(45deg);
                  background: #05D0EB;
                  margin-top: 2px;
                  margin-right: 4px;
                }
            }
          }
        }
        .waybillBasicInfo_right{
          width: 270px;
          height: 611px;
          margin-left: 3px;
          background-color: rgba(9,122,206,0.2);
          padding: 11px 8px;
          box-sizing: border-box;
          div:nth-child(n+2){
            margin-top: 10px;
          }
          .oneItem{
            width: 100%;
            height: 40px;
            div{
              float: left;
            }
            .itemName{
              width: 102px;
              height: 40px;
              color: #89DDDF;
              font-size: 16px;
              text-align: center;
              padding-top:10px;
              box-sizing: border-box;
            }
            .itemValue{
              width: 148px;
              height: 40px;
              margin-left: 2px;
              border: solid 1px rgba(5,208,235,1);
              box-sizing: border-box;
              margin: 0;
              padding: 0;
              margin-top: 5px;
              padding: 12px 0 0 8px;
              font-size: 12px;
              color: #fff;
              overflow: hidden;
              text-overflow: ellipsis;
              white-space: nowrap;
                div{
                  display: inline-block;
                  width: 8px;
                  height: 8px;
                  transform: rotate(45deg);
                  background: #05D0EB;
                  margin-top: 2px;
                  margin-right: 4px;
                }
            }
          }
        }
      }
      .secondTitle_two{
        width: 100%;
        height: 35px;
        background-color: rgba(129,217,229,0.08);
        text-align: center;
        line-height: 35px;
        font-size: 16px;
        color: #89DDDF;
      }
      .dispatchInfo{
        width: 100%;
        height: 269px;
        margin-top: 5px;
        div{
          float: left;
        }
        .dispatchInfo_left{
          width: 270px;
          height: 269px;
          background-color: rgba(9,122,206,0.2);
          padding: 11px 8px;
          box-sizing: border-box;
          div:nth-child(n+2){
            margin-top: 10px;
          }
          .oneItem{
            width: 100%;
            height: 40px;
            div{
              float: left;
            }
            .itemName{
              width: 102px;
              height: 40px;
              color: #89DDDF;
              font-size: 16px;
              text-align: center;
              padding-top:10px;
              box-sizing: border-box;
            }
            .itemValue{
              width: 148px;
              height: 40px;
              margin-left: 2px;
              border: solid 1px rgba(5,208,235,1);
              box-sizing: border-box;
              margin: 0;
              padding: 0;
              margin-top: 5px;
              padding: 12px 0 0 8px;
              font-size: 12px;
              color: #fff;
              overflow: hidden;
              text-overflow: ellipsis;
              white-space: nowrap;
                div{
                  display: inline-block;
                  width: 8px;
                  height: 8px;
                  transform: rotate(45deg);
                  background: #05D0EB;
                  margin-top: 2px;
                  margin-right: 4px;
                }
            }
          }
        }
        .dispatchInfo_right{
          width: 270px;
          height: 269px;
          margin-left: 3px;
          background-color: rgba(9,122,206,0.2);
          padding: 11px 8px;
          box-sizing: border-box;
          div:nth-child(n+2){
            margin-top: 10px;
          }
          .oneItem{
            width: 100%;
            height: 40px;
            div{
              float: left;
            }
            .itemName{
              width: 102px;
              height: 40px;
              color: #89DDDF;
              font-size: 16px;
              text-align: center;
              padding-top:10px;
              box-sizing: border-box;
            }
            .itemValue{
              width: 148px;
              height: 40px;
              margin-left: 2px;
              border: solid 1px rgba(5,208,235,1);
              box-sizing: border-box;
              margin: 0;
              padding: 0;
              margin-top: 5px;
              padding: 12px 0 0 8px;
              font-size: 12px;
              color: #fff;
              overflow: hidden;
              text-overflow: ellipsis;
              white-space: nowrap;
                div{
                  display: inline-block;
                  width: 8px;
                  height: 8px;
                  transform: rotate(45deg);
                  background: #05D0EB;
                  margin-top: 2px;
                  margin-right: 4px;
                }
            }
          }
        }
      }
    }
    .detailContent::-webkit-scrollbar {
        background: #69A3B1;
        width: 5px;
    }
    .detailContent::-webkit-scrollbar-thumb {
        background: #05D0EB ;
    }
}
</style>