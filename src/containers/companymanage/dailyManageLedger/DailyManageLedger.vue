<template>
  <div class="DailyManageLedger_contend">
      <!-- 标题部分 -->
      <div class="title_part">
          <div class="title_icon"></div>
          <div class="title_text">日常管理台账</div>
      </div>
      <!-- 下拉切换部分 -->
      <div class="dropdown_switch">
          <div class="statisticCircle">统计日期</div>
          <!-- 切换年 -->
          <div class="years">
               <KeyValueSelect :data="years"
                            width="100px"
                            height="25px"
                            defaultValue="2017年"
                            @select="selectYear"></KeyValueSelect>
          </div>
          <div class="months">
              <KeyValueSelect :data="months"
                            width="100px"
                            height="25px"
                            defaultValue="10月"
                            @select="selectMonth"></KeyValueSelect>
          </div>
          <div class="days">
              <KeyValueSelect :data="days"
                            width="100px"
                            height="25px"
                            defaultValue="20日"
                            @select="selectDay"></KeyValueSelect>
          </div>
      </div>
      <!-- 在 运单状况日报 和 配送工作日报 之间切换 -->
      <div class="switch_btn">
          <div class="waybill">
              <div :class="{active:waybillOrdistri==='waybill'}"
              @click='waybillOrdistri="waybill"'>运单状况日报</div>
          </div>
          <div class="distribution">
              <div :class="{active:waybillOrdistri==='distribution'}"
              @click='waybillOrdistri="distribution"'>配送工作日报</div>
          </div>
      </div>
      <!-- 切换的内容 -->
      <div class="switch_content">
          <div v-if="waybillOrdistri==='waybill'"><WaybillConditionDaily></WaybillConditionDaily></div>
          <div v-if="waybillOrdistri==='distribution'"><DistributionWorkDaily></DistributionWorkDaily></div>
      </div>
  </div>
</template>

<script type="text/javascript">
import { mapState, mapMutations, mapActions } from 'vuex'
import KeyValueSelect from './../../../components/KeyValueSelect'
import WaybillConditionDaily from './waybillConditionDaily/WaybillConditionDaily'
import DistributionWorkDaily from './distributionWorkDaily/DistributionWorkDaily'
import Dictionary from '../../../util/dictionary'

const { date } = Dictionary
export default {
  name: '',
  components: {
    KeyValueSelect,
    WaybillConditionDaily,
    DistributionWorkDaily,
  },
  computed: {
    ...mapState('DailyManageLedger', ['selectedYear', 'selectedMonth', 'selectedDay']),
    ...mapState('maintitlemsg', ['selectedEntity']),
  },
  methods: {
      /* eslint-disable */ 
    ...mapActions('DailyManageLedger', ['getDailyManageLedger']),
    ...mapMutations('DailyManageLedger', ['setSelectedYear','setSelectedMonth','setSelectedDay']),
    selectYear(item) {
      this.getDailyManageLedger({ entity_id: this.selectedEntity, year: item.value, month: this.selectedMonth, day: this.selectedDay })
      this.setSelectedYear(item.value)
    },
    selectMonth(item) {
      this.getDailyManageLedger({ entity_id: this.selectedEntity, year: this.selectedYear, month: item.value, day: this.selectedDay })
      this.setSelectedMonth(item.value)
    },
    selectDay(item) {
      this.getDailyManageLedger({ entity_id: this.selectedEntity, year: this.selectedYear, month: this.selectedMonth, day: item.value })
      this.setSelectedDay(item.value)
    },
  },
  data() {
    return {
      years: date.year.reverse(),
      months: date.month,
      days: date.day,
      waybillOrdistri: 'waybill',
    }
  },
}
</script>

<style lang="scss" scoped>
.DailyManageLedger_contend{
    width: 100%;
    height:100%;
    .title_part{
        width: 100%;
        height: 30px;
        background-color: rgba(3,139,252,0.2);
        .title_icon{
            width: 16px;
            height: 30px;
            float: left;
            border-left: solid 4px rgba(129,217,229,0.3);
            border-right: solid 10px rgba(129,217,229,0.5);
        }
        .title_text{
            height: 30px;
            float: left;
            margin-left: 20px;
            color: #89DDDF;
            font-size: 18px;
            line-height: 30px;
            display: inline-block;
        }
    }
    .dropdown_switch{
        width: 100%;
        height: 25px;
        margin-top: 8px;
        div{
            float: left;
            color: #B5B5B5;
            font-size: 14px;
            line-height: 25px;
            text-align: center;
        }
        .statisticCircle{
            width: 80px;
            height: 100%;
        }
        .years{
            width: 116px;
            height: 100%;
        }
        .months{
            width: 116px;
            height: 100%;
        }
        .days{
            width: 100px;
            height: 100%;
        }
    }
    .switch_btn{
        width: 100%;
        height: 25px;
        margin-top: 11px;
        display: flex;
        div{
            flex:1;
            height: 25px;
            div{
                width: 250px;
                height: 25px;
                margin: 0 auto;
                background: rgba(5, 208, 235, 0.6);
                text-align: center;
                line-height: 25px;
                color: #fff;
                font-size: 14px;
                border: 1px solid #05d0eb;
                box-sizing: border-box;
                cursor: pointer;
            }
            .active{
                background-color: rgba(5, 208, 235, 0.2);
                color: #b5b5b5;
            }
        }
    }
    .switch_content{
        width: 100%;
        height: 305px;
        margin-top: 11px;
        div{
            width: 100%;
            height:100%;
        }
    }
}
</style>