<template>
  <div class="workOrderDetailsInfoCon">
    <pop-up-widget title="运单详细信息"></pop-up-widget>
    <div class="workOrderDetailsinfo">
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
        <!-- <list-component :listData="listData" -->
        <list-component :listData="workOrderDetailsInfo"
                        v-if="workOrderDetailsInfo"
                        :titlesData="titlesData"></list-component>
      </div>
    </div>
  </div>
</template>

<script type="text/javascript">
import { mapState, mapActions } from 'vuex'
import PopUpWidget from '../../../components/PopUpWidget'
import KeyValueSelect from '../../../components/KeyValueSelect'
import Dictionary from '../../../util/dictionary'
// 列表组件
import ListComponent from '../../../components/ListComponent'

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
    ...mapState('workorderdetailsinfo', ['workOrderDetailsInfo']),
    ...mapState('driverbase', ['ryjb']),
    // result() {
    //   return this.workOrderDetailsInfo
    // },
    contentWidth() {
      return (
        this.titlesData.reduce((total, curr) => total + curr.width, 0) + 10
      )
    },
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
    ...mapActions('workorderdetailsinfo', ['getWorkOrderDetailsInfo']),
    select(name, item) {
      this[name] = item.value
      this.getWorkOrderDetailsInfo(this.fetchData)
    },
  },
  data() {
    return {
      nowYear: `${new Date().getFullYear()}年`,
      nowMonth: `${new Date().getMonth() + 1}月`,
      cycleYeardata: year,
      cycleMonthdata: [{ label: '全年', value: null }, ...month],
      cycleDatedata: [{ label: '全月', value: null }, ...day],
      year: `${new Date().getFullYear()}`,
      month: null,
      day: null,
      listData: [
        {
          a: '#0251',
          b: '#520124',
          c: '货车',
          d: '爆炸品',
          e: '货物1',
          f: 105,
          g: '2018-01-20',
          h: '260',
        },
        {
          a: '#0252',
          b: '#520125',
          c: '货车',
          d: '气体',
          e: '货物1',
          f: 85,
          g: '2018-01-20',
          h: '280',
        },
        {
          a: '#0251',
          b: '#520124',
          c: '货车',
          d: '爆炸品',
          e: '货物1',
          f: 105,
          g: '2018-01-20',
          h: '260',
        },
        {
          a: '#0252',
          b: '#520125',
          c: '货车',
          d: '气体',
          e: '货物1',
          f: 85,
          g: '2018-01-20',
          h: '280',
        },
        {
          a: '#0251',
          b: '#520124',
          c: '货车',
          d: '爆炸品',
          e: '货物1',
          f: 105,
          g: '2018-01-20',
          h: '260',
        },
        {
          a: '#0252',
          b: '#520125',
          c: '货车',
          d: '气体',
          e: '货物1',
          f: 85,
          g: '2018-01-20',
          h: '280',
        },
        {
          a: '#0251',
          b: '#520124',
          c: '货车',
          d: '爆炸品',
          e: '货物1',
          f: 105,
          g: '2018-01-20',
          h: '260',
        },
        {
          a: '#0252',
          b: '#520125',
          c: '货车',
          d: '气体',
          e: '货物1',
          f: 85,
          g: '2018-01-20',
          h: '280',
        },
        {
          a: '#0251',
          b: '#520124',
          c: '货车',
          d: '爆炸品',
          e: '货物1',
          f: 105,
          g: '2018-01-20',
          h: '260',
        },
        {
          a: '#0252',
          b: '#520125',
          c: '货车',
          d: '气体',
          e: '货物1',
          f: 85,
          g: '2018-01-20',
          h: '280',
        },
        {
          a: '#0251',
          b: '#520124',
          c: '货车',
          d: '爆炸品',
          e: '货物1',
          f: 105,
          g: '2018-01-20',
          h: '260',
        },
        {
          a: '#0252',
          b: '#520125',
          c: '货车',
          d: '气体',
          e: '货物1',
          f: 85,
          g: '2018-01-20',
          h: '280',
        },
        {
          a: '#0251',
          b: '#520124',
          c: '货车',
          d: '爆炸品',
          e: '货物1',
          f: 105,
          g: '2018-01-20',
          h: '260',
        },
        {
          a: '#0252',
          b: '#520125',
          c: '货车',
          d: '气体',
          e: '货物1',
          f: 85,
          g: '2018-01-20',
          h: '280',
        },
        {
          a: '#0251',
          b: '#520124',
          c: '货车',
          d: '爆炸品',
          e: '货物1',
          f: 105,
          g: '2018-01-20',
          h: '260',
        },
        {
          a: '#0252',
          b: '#520125',
          c: '货车',
          d: '气体',
          e: '货物1',
          f: 85,
          g: '2018-01-20',
          h: '280',
        },
        {
          a: '#0251',
          b: '#520124',
          c: '货车',
          d: '爆炸品',
          e: '货物1',
          f: 105,
          g: '2018-01-20',
          h: '260',
        },
        {
          a: '#0252',
          b: '#520125',
          c: '货车',
          d: '气体',
          e: '货物1',
          f: 85,
          g: '2018-01-20',
          h: '280',
        },
        {
          a: '#0251',
          b: '#520124',
          c: '货车',
          d: '爆炸品',
          e: '货物1',
          f: 105,
          g: '2018-01-20',
          h: '260',
        },
        {
          a: '#0252',
          b: '#520125',
          c: '货车',
          d: '气体',
          e: '货物1',
          f: 85,
          g: '2018-01-20',
          h: '280',
        },
        {
          a: '#0251',
          b: '#520124',
          c: '货车',
          d: '爆炸品',
          e: '货物1',
          f: 105,
          g: '2018-01-20',
          h: '260',
        },
        {
          a: '#0252',
          b: '#520125',
          c: '货车',
          d: '气体',
          e: '货物1',
          f: 85,
          g: '2018-01-20',
          h: '280',
        },
        {
          a: '#0251',
          b: '#520124',
          c: '货车',
          d: '爆炸品',
          e: '货物1',
          f: 105,
          g: '2018-01-20',
          h: '260',
        },
        {
          a: '#0252',
          b: '#520125',
          c: '货车',
          d: '气体',
          e: '货物1',
          f: 85,
          g: '2018-01-20',
          h: '280',
        },
      ],
      titlesData: [
        { name: '运单编号', key: 'waybill_id', width: 180 },
        { name: '线路代号', key: 'vehicle_id', width: 120 },
        { name: '车辆', key: 'qy_dzyd.qy_xlxx.route_name', width: 180 },
        { name: '货物类型', key: 'qy_dzyd.cjhwfl.cargo_name', width: 200 },
        { name: '货物名称', key: 'qy_dzyd.cjhwfl.hwlx.cargo_type', width: 180 },
        // { name: '货物量', key: '', width: 80 },
        { name: '出发时间', key: 'start_time', width: 180 },
        { name: '出发里程', key: 'start_km', width: 180 },
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
.workOrderDetailsinfo {
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