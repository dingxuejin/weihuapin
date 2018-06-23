<template>
  <div class="rewardCountInfoContent">
    <pop-up-widget title="奖励统计信息"
                   detailsBtnShow="true"
                   @popUpdetailsBtn="popRewarddetail = true"></pop-up-widget>

    <!-- 内容部分 -->
    
    <div class="rewardCon">
      <!-- 标题 -->
      <div class="selectCon clearfix">
        <div class="itemCon fr clearfix">
          <div class="fl">统计周期</div>
          <div class="fl">
            <key-value-select width="120px"
                              :data="yearOption"
                              @select='selectYear'
                              :defaultValue="nowYear"></key-value-select>
          </div>
          <div class="fl">
            <key-value-select width="120px"
                            :data="monthOption"
                            @select="selectMonth"></key-value-select>
                            <!-- :defaultValue="nowMonth" -->
          </div>
        </div>
        <div class="itemCon fr clearfix">
          <div class="fl">类型主题</div>
          <div class="fl">
            <key-value-select width="120px"
                              @select="selectReward"
                              :data="rewardThemeData"></key-value-select>
          </div>
        </div>
      </div>

      <!-- 数据类型 -->
      <div class="dataTypeCon clearfix">
        <div :class="{dataTypeActive:currentDataTypeIndex === 1}"
             @click="dataTypeActive(1)">奖励金额</div>
        <div :class="{dataTypeActive:currentDataTypeIndex === 0}"
             @click="dataTypeActive(0)">奖励次数</div>
      </div>

      <!-- 图表 -->
      <div class="chartsCon">
        <line-chart chartTheme="dark"
                    :data="rewardCountInfo"
                    :color="lineChartColor"
                    :yaxisName="yaxisName"
                    v-if="rewardCountInfo"></line-chart>
      </div>

    </div>

    <!-- 三级弹窗 -->
    <div class="rewardDetailsInfoContainer" v-if="popRewarddetail">
        <pop-up-frame @close="popRewarddetail = false">
            <reward-details-info></reward-details-info>
        </pop-up-frame>
    </div>
  </div>
</template>

<script type="text/javascript">
import { mapState, mapActions } from 'vuex'
import PopUpFrame from '../../../components/PopUpFrame'
import PopUpWidget from '../../../components/PopUpWidget'
import KeyValueSelect from '../../../components/KeyValueSelect'
import LineChart from '../../../components/charts/lineChart'

// 三级弹窗
import RewardDetailsInfo from '../../driverPopup/rewarddetailsinfo/RewardDetailsInfo'
import Dictionary from '../../../util/dictionary'

const { date: { year, month }, rewardEvent } = Dictionary

export default {
  name: 'TrainCountInfo',
  components: {
    PopUpFrame,
    PopUpWidget,
    KeyValueSelect,
    LineChart,
    RewardDetailsInfo,
  },
  computed: {
    ...mapState('rewardcountinfo', ['rewardCountInfo']),
    ...mapState('driverbase', ['ryjb']),
    fetchData() {
      return {
        driver_id: this.ryjb.driver_id,
        year: this.year,
        month: this.month,
        reward_type_code: this.reward_type_code,
        type: ['奖励次数', '奖励金额'][this.currentDataTypeIndex],
      }
    },
  },
  data() {
    return {
      yearOption: year,
      monthOption: [{ label: '全年', value: null }, ...month],
      rewardThemeData: rewardEvent,
      currentDataTypeIndex: 0,
      currentDataType: '奖励次数',
      lineChartColor: [
        '#05d0eb',
        '#81d9e5',
        '#f6ffcb',
        '#e75029',
        '#038bfc',
        '#006a55',
      ],
      // 三级开关
      popRewarddetail: false,
      reward_type_code: 3,
      year: `${new Date().getFullYear()}`,
      month: null,
      nowYear: `${new Date().getFullYear()}年`,
      nowMonth: `${new Date().getMonth() + 1}月`,
      yaxisName: '次',
    }
  },
  methods: {
    ...mapActions('rewardcountinfo', ['getRewardCountInfo']),
    selectYear(item) {
      this.year = item.value
      this.getRewardCountInfo(this.fetchData)
    },
    selectMonth(item) {
      this.month = item.value
      this.getRewardCountInfo(this.fetchData)
    },
    selectReward(item) {
      this.reward_type_code = item.value
      this.getRewardCountInfo(this.fetchData)
    },
    dataTypeActive(index) {
      this.currentDataTypeIndex = index
      if (index === 0) {
        this.yaxisName = '次'
      } else if (index === 1) {
        this.yaxisName = '元'
      }
      this.getRewardCountInfo(this.fetchData)
    },
  },
}
</script>

<style lang="scss" scoped>
// 公用样式
@mixin size($w,$h) {
  width: $w;
  height: $h;
}

// 组件包裹
.rewardCountInfoContent {
    position: relative;
  // 内容包裹
  .rewardCon {
    position: relative;
    // 下拉框包裹
    .selectCon {
      @include size(100%,25px);
      color: #b5b5b5;
      font-size: 14px;
      line-height: 25px;
      .itemCon {
        div:nth-child(2) {
          margin-left: 10px;
        }
        div:nth-child(3) {
          margin-left: 10px;
        }
      }
      //   .itemCon:nth-child(1) {
      //     margin-left: 132px;
      //   }
      .itemCon:nth-child(n + 2) {
        margin-right: 10px;
      }
    }

    // 切换数据
    .dataTypeCon {
      @include size(100%,25px);
      margin-top: 10px;
      // background: green;
      div {
        @include size(160px,25px);
        box-sizing: border-box;
        text-align: center;
        line-height: 23px;
        color: #b5b5b5;
        float: right;
        background: rgba(0, 191, 229, 0.2);
        cursor: pointer;
      }
      .dataTypeActive {
        color: #fff;
        background: rgba(0, 191, 229, 0.5);
      }
      div:nth-child(2) {
        margin-right: 10px;
      }
      div:nth-child(n + 2) {
        margin-left: 10px;
      }
    }

    // 图表包裹
    .chartsCon {
      @include size(100%,200px);
      overflow: hidden;
      margin-top: 10px;
      // background:green;
    }
  }

  // 三级弹窗
  .rewardDetailsInfoContainer {
    // @include size(750px,350px);
    // overflow: hidden;
    width: 750px;
    min-height:200px;
    background: green;
    position: absolute;
    top: 0px;
    left: 780px;
  }
}
</style>