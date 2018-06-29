<template>
  <div class="trainCondition_contend">
      <table></table>
      <!-- 切换部分 -->
      <div class="switch_part">
        <!-- 切换时间 年和月 -->
        <div class="statisticTime">
          <div class="staText">统计时间</div>
          <!-- 年 -->
          <div class="switch_years">
               <KeyValueSelect :data="years"
                            width="98px"
                            height="24px"></KeyValueSelect>
          </div>
          <!-- 月 -->
          <div class="switch_months">
            <KeyValueSelect :data="months"
                            width="75px"
                            height="24px"></KeyValueSelect>
          </div>
        </div>
        <!-- 切换培训类型 -->
        <div class="trainType">
          <div class="traText">培训类型</div>
          <div class="trainType_List">
            <KeyValueSelect :data="tarinTypes"
                            width="100px"
                            height="24px"></KeyValueSelect>
          </div>
        </div>
      </div>
      <!-- 下部分 echart图 -->
      <div class="bottom_Part">
        <!-- 左边echarts图 -->
        <div class="leftPart">
          <rosePieTrainTime></rosePieTrainTime>
        </div>
        <!-- 右边echarts图 -->
        <div class="rightPart">
          <div class="title">
            <div>6h以上</div>
            <div>30人</div>
          </div>
          <div class="content_echart">
            <barTransverse :data="rightData" gridWidth="90%" height="124"></barTransverse>
          </div>
        </div>
      </div>
  </div>
</template>

<script type="text/javascript">
import KeyValueSelect from './../../../../components/KeyValueSelect'
import barTransverse from './../../../../components/charts/barTransverse'
import rosePieTrainTime from './../../../../components/charts/rosePieTrainTime'

export default {
  name: '',
  components: {
    KeyValueSelect,
    barTransverse,
    rosePieTrainTime,
  },
  computed: {},
  methods: {

  },
  data() {
    return {
      years: [
        { label: '2017年', value: '2017年' },
        { label: '2016年', value: '2016年' },
        { label: '2015年', value: '2015年' },
        { label: '2014年', value: '2014年' },
      ],
      months: [
        { label: '月', value: '月' },
        { label: '1月', value: '1月' },
        { label: '2月', value: '2月' },
        { label: '3月', value: '3月' },
        { label: '4月', value: '4月' },
        { label: '5月', value: '5月' },
        { label: '6月', value: '6月' },
        { label: '7月', value: '7月' },
        { label: '8月', value: '8月' },
        { label: '9月', value: '9月' },
        { label: '10月', value: '10月' },
        { label: '11月', value: '11月' },
        { label: '12月', value: '12月' },
      ],
      tarinTypes: [
        { label: '安全生产', value: '安全生产' },
        { label: '安全生产', value: '安全生产' },
        { label: '安全生产', value: '安全生产' },
        { label: '安全生产', value: '安全生产' },
      ],
      rightData: [
        { label: '张三', value: 6 },
        { label: '李四', value: 8 },
        { label: '王二', value: 10 },
        { label: '麻子', value: 12 },
        { label: '张龙', value: 14 },
      ],
    }
  },
}
</script>

<style lang="scss" scoped>
.trainCondition_contend{
    width: 100%;
    height:100%;
    // background: blue;
    .switch_part{
      width: 100%;
      height:24px;
      margin-top: 5px;
      font-size: 14px;
      color: #b5b5b5;
      .statisticTime{
        width: 264px;
        height:24px;
        float: left;
        div{
          float: left;
        }
        .staText{
          width: 84px;
          height:24px;
          text-align: center;
          line-height: 24px;
        }
        .switch_years{
          width: 102px;
          height:24px;
        }
        .switch_months{
          width: 75px;
          height:24px;
        }
      }
      .trainType{
        width: 194px;
        height:24px;
        float: right;
        div{
          float: left;
        }
        .traText{
          width: 80px;
          height:24px;
          text-align: center;
          line-height: 24px;
        }
        .trainType_List{
          width: 114px;
          height:24px;
        }
      }
    }
    .bottom_Part{
      width: 100%;
      height:160px;
      // background: red;
      display: flex;
      .leftPart{
        width: 100%;
        height:160px;
        flex: 1;
      }
      .rightPart{
        width: 259px;
        height:156px;
        margin-top: 2px;
        border: solid 1px #81D9E5 ;
        .title{
          width:100%;
          height:31px;
          border-bottom:solid 2px rgba(129,217,229,0.50);
          position: relative;
          font-size: 14px;
          color: #fff;
          div{
            text-align: center;
            line-height: 29px;
          }
          div:nth-child(1){
            width:74px;
            height:31px;
            float: left;
          }
          div:nth-child(2){
            width:60px;
            height:31px;
            float: right;
          }
        }
        .title::before{
          content: "";
          width: 15px;
          height: 2px;
          position: absolute;
          background-color: #81D9E5;
          left: 0;
          bottom: -2px;
        }
        .title::after{
          content: "";
          width: 15px;
          height: 2px;
          position: absolute;
          background-color: #81D9E5;
          right: 0;
          bottom: -2px;
        }
        .content_echart{
          width:100%;
          height:124px;
          overflow-y: auto;
      }
        .content_echart::-webkit-scrollbar {
          background: #69A3B1;
          width: 4px;
        }
        .content_echart::-webkit-scrollbar-thumb {
          background: #05D0EB ;
        }
      }
    }
}
</style>