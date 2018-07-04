<template>
  <div class="DistributionWorkDaily_contend">
    <!-- 一级标题部分 -->
      <div class="title_part">
        <div class="title_text">配送中心工作日报</div>
        <div class="leading_out"><a :href="leadOutUrl" download="配送中心工作日报.xlsx">导出</a></div>
      </div>
      <!-- 滚动部分 -->
      <div class="scroll_content">
        <!-- 二级标题 -->
        <div class="secondTitle">计划完成进度</div>
        <div class="scheduleProgress"><ScheduleProgress></ScheduleProgress></div>
        <!-- 二级标题 -->
        <div class="secondTitle">资产状态</div>
        <div class="assetState"><AssetState></AssetState></div>
        <!-- 二级标题 -->
        <div class="secondTitle">人员状态</div>
        <div class="personState"><PersonState></PersonState></div>
      </div>
  </div>
</template>

<script type="text/javascript">
import { mapState } from 'vuex'
import ScheduleProgress from './scheduleProgress/ScheduleProgress'
import AssetState from './assetState/AssetState'
import PersonState from './personState/PersonState'

export default {
  name: '',
  components: {
    ScheduleProgress,
    AssetState,
    PersonState,
  },
  computed: {
    ...mapState('maintitlemsg', ['selectedEntity']),
    ...mapState('DailyManageLedger', ['selectedYear', 'selectedMonth', 'selectedDay']),
  },
  methods: {

  },
  data() {
    return {
      leadOutUrl: `http://172.30.7.103:3033/company_manage_day_accounts?entity_id=${this.selectedEntity}&year=${this.selectedYear}&month=${this.selectedMonth}&day=${this.selectedDay}&exportxlsx=配送`,
    }
  },
}
</script>

<style lang="scss" scoped>
.DistributionWorkDaily_contend{
    width: 100%;
    height: 100%;
    .title_part{
      width: 100%;
      height: 39px;
      background: rgba(3,139,252,0.4);
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
          width: 100%;
          height: 100%; 
        }
      }
    }
    .scroll_content{
      width: 546px;
      height: 266px;
      margin: 0 auto;
      margin-top: 8px;
      overflow-y: scroll;
      div{
        margin-top: 3px;
      }
      .secondTitle{
        width: 541px;
        height: 35px;
        background:rgba(129,217,229,0.08);
        margin: 0 auto;
        text-align: center;
        line-height: 35px;
        color: #89DDDF;
        font-size: 16px;
        margin-top: 3px;
      }
      .scheduleProgress{
        width: 100%;
        height: 461px;
      }
      .assetState{
        width: 100%;
        height: 217px;
      }
      .personState{
        width: 100%;
        height: 280px;
      }
    }
    .scroll_content::-webkit-scrollbar {
        background: #69A3B1;
        width: 4px;
    }
    .scroll_content::-webkit-scrollbar-thumb {
        background: #05D0EB ;
    }
}
</style>