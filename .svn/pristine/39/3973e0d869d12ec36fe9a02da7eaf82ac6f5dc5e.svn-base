<template>
    <div class="pop" v-drag  @mousedown="move=true" @mouseup="move=false" :style="move?'cursor:move':''">
         <PopUpFrame @close='up'>
            <PopUpWidget :title='data.entity_name'>
                <div class="box">
                    <ul class="list">
                        <li>
                            <div>负责人</div>
                            <div>{{data.manager}}</div>
                        </li>
                        <li>
                            <div>联系方式</div>
                            <div>{{data.phone_number}}</div>
                        </li>
                        <li>
                            <div>业务范围</div>
                            <div class="over" :title="data.cdjyfw">{{data.cdjyfw}}</div>
                        </li>
                        <li>
                            <div>业务区域</div>
                            <div class="over" :title="data.cdjyqy.join('，')">{{data.cdjyqy.join('，')}}</div>
                        </li>
                    </ul>
                    <div class="echartsbox">
                        <div class="echarts_content">
                            <Echarts :options="Options"></Echarts>
                        </div>
                    </div>
                </div>
            </PopUpWidget>
        </PopUpFrame>
    </div>
</template>
<script>
import Echarts from 'vue-echarts'
import PopUpFrame from '@/components/PopUpFrame'
import PopUpWidget from '@/components/PopUpWidget'

export default {
  components: {
    PopUpFrame,
    PopUpWidget,
    Echarts,
  },
  props: ['data'],
  data() {
    return {
      move: false,
      Options: {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow',
          },
          formatter(params) {
            const arr = params.filter(item => item.value !== 0)
            return `${arr[0].seriesName}: ${arr[0].value || 0}`
          },
        },
        textStyle: {
          color: '#fff',
        },
        legend: {
          textStyle: {
            color: '#fff',
          },
          data: ['从业人员（人）', '车辆（辆）'],
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true,
        },
        yAxis: [
          {
            type: 'category',
            data: ['车辆', '从业人员'],
          },
        ],
        xAxis: {
          show: false,
        },
        color: ['#05D0EB', '#077FEA'],
        series: [
          {
            name: '从业人员（人）',
            type: 'bar',
            stack: '总量',
            data: [0, 2332],
          },
          {
            name: '车辆（辆）',
            type: 'bar',
            stack: '总量',
            data: [2121, 0],
          },
        ],
      },
    }
  },
  methods: {
    up() {
      this.$emit('upx')
    },
    changeData() {
      this.Options.series[0].data = [0, this.data.pepople_count]
      this.Options.series[1].data = [this.data.car_count, 0]
    },
  },
  watch: {
    data(v) {
      this.Options.series[0].data = [0, v.pepople_count]
      this.Options.series[1].data = [v.car_count, 0]
    },
  },
  created() {
    this.changeData()
  },
}
</script>
<style lang="scss" scoped>
.pop{
    left: -140px;
    top: -40px;
    .box{
        display:table;
        .echartsbox{
            display:table-cell;
            width: 230px;
            position: relative;
            .echarts_content{
                position: absolute;
                top: 0px;
                left: 0px;
                width: 230px;
                height: 160px;
            }
        }
        .list{
            display:table-cell;
            width: 250px;
            li{
                margin: 8px 0;
                div{
                     display:table-cell;
                     height: 28px;
                     line-height: 28px;
                }
                div:first-child{
                    width: 80px;
                    text-align: center;
                    color: #81D9E5 ;
                }
                div:last-child{
                    width: 150px;
                    max-width: 150px;
                    background-color: rgba(3,139,252,0.4);
                    border-radius: 3px;
                    padding: 0 5px;
                    color: #fff;
                }
            }
        }
    }
}
</style>

