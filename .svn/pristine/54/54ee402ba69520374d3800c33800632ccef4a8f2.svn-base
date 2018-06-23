<template>
  <div>
    <pop-up-widget title="违法行为详细信息"></pop-up-widget>
    <div class="illegalBehaviorDetailsInfoCon">
      <!-- 筛选框 -->
      <div class="filterCon clearfix">
        <div class="itemWrap fl">
          <div class="subTitle">姓名</div>
          <div class="content">王明
            <div class="rotateBox"></div>
          </div>
        </div>
        <div class="itemWrap fl">
          <div class="subTitle">机构</div>
          <div class="content">机构1
            <div class="rotateBox"></div>
          </div>
        </div>
      </div>

      <!-- 内容部分 -->
      <div class="rewardListCon eleScrollBar">
        <list-component :listData="listData"
                        :titlesData="titlesData"></list-component>
      </div>
    </div>
  </div>
</template>

<script type="text/javascript">
import PopUpWidget from '../../../components/PopUpWidget'
import KeyValueSelect from '../../../components/KeyValueSelect'
// 列表组件
import ListComponent from '../../../components/ListComponent'
import Dictionary from '../../../util/dictionary'

const { date: { year, month, day } } = Dictionary

export default {
  name: 'driverBehaviorAlarmDetailsInfo',
  components: {
    PopUpWidget,
    KeyValueSelect,
    ListComponent,
    Dictionary,
  },
  computed: {
    contentWidth() {
      return (
        this.titlesData.reduce((total, curr) => total + curr.width, 0) + 10
      )
    },
  },
  data() {
    return {
      cycleYeardata: year,
      cycleMonthdata: month,
      cycleDatedata: day,
      listData: [
        {
          a: '#0251',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0252',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0251',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0252',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0251',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0252',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0251',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0252',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0251',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0252',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0251',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0252',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0251',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0252',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0251',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0252',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0251',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0252',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0251',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0252',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0251',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0252',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0251',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
        {
          a: '#0252',
          b: '#5201',
          c: '左顾右盼',
          d: 20,
          e: '南北',
          f: '2017-11-25',
          g: '125°',
          h: '256°',
        },
      ],
      titlesData: [
        { name: '车辆ID', key: 'a', width: 100 },
        { name: '线路ID', key: 'b', width: 100 },
        { name: '报警类型', key: 'c', width: 100 },
        { name: '速度', key: 'd', width: 65 },
        { name: '方向', key: 'e', width: 65 },
        { name: '报警时间', key: 'f', width: 100 },
        { name: '纬度', key: 'g', width: 80 },
        { name: '经度', key: 'h', width: 80 },
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
.illegalBehaviorDetailsInfoCon {
  // @include size(100%,);
  width: 100%;
  min-height: 200px;
  // background:green;

  // 筛选框
  .filterCon {
    @include size(100%,25px);
    // background: green;
    .itemWrap {
      @include size(350px,100%);
      line-height: 25px;
      float: left;
      .subTitle {
        @include size(110px,100%);
        line-height: 25px;
        text-align: left;
        color: #89dddf;
        font-size: 14px;
        float: left;
      }
      .content {
        @include size(240px,100%);
        line-height: 23px;
        padding-left: 30px;
        color: #fff;
        font-size: 14px;
        font-weight: bold;
        border: 1px solid #89dddf;
        float: left;
        position: relative;
        box-sizing: border-box;
        .rotateBox {
          @include size(7px,7px);
          position: absolute;
          top: 11px;
          left: 10px;
          transform: rotate(45deg);
          background: #05d0eb;
        }
      }
    }
    .itemWrap:nth-child(n + 2) {
      margin-left: 10px;
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