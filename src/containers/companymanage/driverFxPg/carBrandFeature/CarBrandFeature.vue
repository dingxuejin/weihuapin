<template>
  <div class="CarBrandFeature_contend">
    <!-- 切换部分 -->
    <table></table>
    <div class="switchCase">
      <!-- 切换 不同人或品牌 不同年份 -->
      <div class="switch_people_Brand_time">
        <!-- 切换 不同人或品牌  -->
        <div class="switch_people_Brand">
          <div class="driverOrBrand">{{chooseType==='brand'?'驾驶员':'车辆品牌'}}</div>
          <div class="dOcDropdown">
            <KeyValueSelect :data="chooseType==='brand'?drivers:brands"
                            width="91px"
                            height="24px"></KeyValueSelect>
          </div>
        </div>
        <!-- 切换 不同年份  -->
        <div class="switch_time">
          <div class="statisticTime">统计时间</div>
          <div class="timeDropdown">
            <KeyValueSelect :data="years"
                            width="97px"
                            height="24px"></KeyValueSelect>
          </div>
        </div>
      </div>
      <!-- 切换人或品牌类型 -->
      <div class="switch_peopleType">
        <div class="driver"
             :class='{active:chooseType==="driver"}'
             @click='chooseType="driver"'>驾驶员</div>
        <div class="brand"
             :class='{active:chooseType==="brand"}'
             @click='chooseType="brand"'>车辆品牌</div>
      </div>
    </div>
    <!-- echart图部分 -->
    <div class="echart_part">
      <barTransverse :data="data" gridWidth="60%" height="144"></barTransverse>
      </div>
  </div>
</template>

<script type="text/javascript">
import KeyValueSelect from './../../../../components/KeyValueSelect'
import barTransverse from './../../../../components/charts/barTransverse'

export default {
  name: '',
  components: {
    KeyValueSelect,
    barTransverse,
  },
  computed: {},
  methods: {},
  data() {
    return {
      chooseType: 'brand',
      drivers: [
        { label: '张三', value: '张三' },
        { label: '李四', value: '李四' },
        { label: '王二', value: '王二' },
        { label: '麻子', value: '麻子' },
      ],
      brands: [
        { label: '一汽', value: '一汽' },
        { label: '本田', value: '本田' },
        { label: '解放', value: '解放' },
        { label: '奔驰', value: '奔驰' },
      ],
      years: [
        { label: '2017年', value: '2017年' },
        { label: '2016年', value: '2016年' },
        { label: '2015年', value: '2015年' },
        { label: '2014年', value: '2014年' },
      ],
      data: [
        { label: '张三', value: 6 },
        { label: '李四', value: 8 },
        { label: '王二', value: 10 },
        { label: '麻子', value: 12 },
        { label: '张龙', value: 14 },
        { label: '赵虎', value: 16 },
        { label: '王朝', value: 18 },
        { label: '马汉', value: 20 },
      ],
    }
  },
}
</script>

<style lang="scss" scoped>
.CarBrandFeature_contend {
  width: 100%;
  height: 100%;
  // background: pink;
  .switchCase {
    width: 100%;
    height: 30px;
    margin-top: 15px;
    // background: cyan;
    display: flex;
    .switch_people_Brand_time {
      height: 100%;
      flex: 1;
      display: flex;
      padding: 0 14px;
      box-sizing: border-box;
      div {
        height: 100%;
        flex: 1;
      }
      .switch_people_Brand {
        margin-right: 2px;
        width: 160px;
        div {
          float: left;
        }
        .driverOrBrand {
          width: 56px;
          height: 100%;
          text-align: center;
          line-height: 30px;
          font-size: 14px;
          color: #b5b5b5;
        }
        .dOcDropdown {
          height: 100%;
          padding: 3px 0 3px 10px;
          box-sizing: border-box;
        }
      }
      .switch_time {
        width: 160px;
        div {
          float: left;
        }
        .statisticTime {
          width: 58px;
          height: 100%;
          text-align: center;
          line-height: 30px;
          font-size: 14px;
          color: #b5b5b5;
          margin-right: 3px;
          margin-left: 2px;
          position: relative;
          right: 5px;
        }
        .timeDropdown {
          height: 100%;
          padding: 3px 0;
          box-sizing: border-box;
        }
      }
    }
    .switch_peopleType {
      width: 225px;
      height: 100%;
      display: flex;
      padding: 0 10px;
      box-sizing: border-box;
      div {
        height: 100%;
        flex: 1;
        background-color: rgba(5, 208, 235, 0.6);
        text-align: center;
        line-height: 30px;
        color: #fff;
        font-size: 14px;
        border: 1px solid #05d0eb;
        box-sizing: border-box;
        cursor: pointer;
      }
      .driver {
        margin-right: 2px;
      }
      .active {
        background-color: rgba(5, 208, 235, 0.2);
        border: 1px solid #05d0eb;
        box-sizing: border-box;
        color: #b5b5b5;
      }
    }
  }
  .echart_part {
    clear: both;
    width: 100%;
    height: 144px;
    overflow-y: auto;
  }
    .echart_part::-webkit-scrollbar {
      background: #69A3B1;
      width: 4px;
    }
    .echart_part::-webkit-scrollbar-thumb {
      background: #05D0EB ;
    }
}
</style>