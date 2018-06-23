<template>
  <div>
    <pop-up-widget title="驾驶时段信息"></pop-up-widget>
    <div class="trainDetailsInfoCon">
      <!-- 筛选框 -->
      <div class="filterCon clearfix">
        <div class="itemCon fr clearfix">
          <div>统计周期</div>
          <div>
            <key-value-select :data="cycleYeardata"
                              width="100px"
                              @select='select("year",$event)'
                              :defaultValue="nowYear"></key-value-select>
          </div>
          <div>
            <key-value-select :data="cycleMonthdata"
                              width="100px"
                              @select='select("month",$event)'></key-value-select>
          </div>
          <div>
            <key-value-select :data="cycleDatedata"
                              width="100px"
                              @select='select("day",$event)'></key-value-select>
          </div>
        </div>
      </div>

      <!-- 内容部分 -->
      <div class="rewardListCon eleScrollBar">
        <list-component :listData="workStrengthDetailsInfo"
                        :titlesData="titlesData"
                        v-if="workStrengthDetailsInfo"></list-component>
      </div>
    </div>
  </div>
</template>

<script type="text/javascript">
import { mapState, mapActions } from 'vuex'
import PopUpWidget from '../../../components/PopUpWidget'
import KeyValueSelect from '../../../components/KeyValueSelect'
// 列表组件
import ListComponent from '../../../components/ListComponent'
import Dictionary from '../../../util/dictionary'

const { date: { year, month, day } } = Dictionary

export default {
  name: '',
  components: {
    PopUpWidget,
    KeyValueSelect,
    ListComponent,
    Dictionary,
  },
  computed: {
    ...mapState('workstrengthdetailsinfo', ['workStrengthDetailsInfo']),
    ...mapState('driverbase', ['ryjb']),
    // contentWidth() {
    //   return (
    //     this.titlesData.reduce((total, curr) => total + curr.width, 0) + 10
    //   )
    // },
    fetchData() {
      return {
        driver_id: this.ryjb.driver_id,
        year: this.year,
        month: this.month,
        day: this.day,
      }
    },
  },
  methods: {
    ...mapActions('workstrengthdetailsinfo', ['getWorkStrengthDetailsInfo']),
    select(name, item) {
      this[name] = item.value
      this.getWorkStrengthDetailsInfo(this.fetchData)
    },
  },
  data() {
    return {
      nowYear: `${new Date().getFullYear()}年`,
      nowMonth: `${new Date().getMonth() + 1}月`,
      cycleYeardata: year,
      // cycleMonthdata: month,
      // cycleDatedata: day,
      cycleMonthdata: [{ label: '全年', value: null }, ...month],
      cycleDatedata: [{ label: '全月', value: null }, ...day],
      year: `${new Date().getFullYear()}`,
      month: null,
      day: null,
      titlesData: [
        { name: '车辆ID', key: 'vehicle_id', width: 120 },
        { name: '运单编号', key: 'waybill_id', width: 250 },
        { name: '开始时间', key: 'start_time', width: 160 },
        { name: '结束时间', key: 'stop_time', width: 160 },
      ],
    }
  },
}
</script>

<style lang="scss" scoped>
// 公用样式
@mixin size($w,$h) {
  width: $w;
  height: $h;
}

// 自定义滚动条
.eleScrollBar::-webkit-scrollbar {
  @include size(5px,5px);
  background: url("../../../assets/driver/scroll.png") no-repeat center center;
  // position: relative;
  // right: 10px;
  // top: 5px;
  background-size: 100% 100%;
}
.eleScrollBar::-webkit-scrollbar-thumb {
  background: rgba(5, 208, 235, 1);
}

// 三级菜单内容
.trainDetailsInfoCon {
  // @include size(100%,);
  width: 100%;
  min-height: 200px;
  // background:green;

  // 筛选框
  .filterCon {
    @include size(100%,25px);
    // background: pink;
    // 筛选条件
    .itemCon {
      min-width: 100px;
      height: 100%;
      line-height: 25px;
      color: #b5b5b5;
      font-size: 14px;
      // background: #000;

      div {
        float: left;
        // background: cyan;
      }
      div:nth-child(2) {
        margin-left: 10px;
      }
      div:nth-child(n + 3) {
        margin-left: 5px;
      }
    }
    .itemCon:nth-child(n + 2) {
      margin-right: 10px;
    }
  }

  // 内容部分
  .rewardListCon {
    width: 100%;
    height: 290px;
    box-sizing: border-box;
    border: 1px solid #81d9e5;
    position: relative;
    padding-top: 10px;
    padding-bottom: 5px;
    margin-top: 10px;
    // overflow-x: auto;
    // overflow-y: hidden;
  }
}
</style>