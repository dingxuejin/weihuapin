<template>
      <Echarts :options="newOption"
           :theme="chartTheme"></Echarts>
</template>
<script>
import Echarts from 'vue-echarts'

export default {
  name: 'RealTimeRadar',
  components: { Echarts },
  props: ['chartTheme', 'data', 'color'],
  data() {
    return {
      option: {
        tooltip: {
          axisPointer: {
            type: 'shadow',
          },
          hideDelay: 300,
          transitionDuration: 0.5,
          padding: 0,
          backgroundColor: 'rgba(0,0,0,0)',
          position: 'bottom',
        },
        radar: {
          shape: 'circle',
          name: {
            show: false,
            formatter: '{value}',
          },
          splitArea: {
            areaStyle: {
              color: ['rgba(8,79,137, 0.1)', 'rgba(8,79,137, 0)'],
            },
          },
          splitLine: {
            lineStyle: {
              color: '#234A5F',
            },
          },
          axisLine: {
            show: true,
            lineStyle: {
              color: '#234A5F',
            },
          },
          indicator: [
          ],

        },
        series: [
          {
            type: 'radar',
            lineStyle: {
              color: '#0CA1BA',
            },
            itemStyle: {
              borderColor: '#0CA1BA',
            },
            areaStyle: {
              color: '#10758C',
            },
            data: [{ symbolSize: 2 }],
          },
        ],
      },
    }
  },
  computed: {
    newOption() {
      const option = this.option
      const data = this.data
      if (data && data.length > 0) {
        let dataArr = ''


        const allValue = data.map(val => val.value)
        const max = Math.max(...allValue)
        const indicator = data.map((val) => {
          dataArr += `  <div class='flex-between'>
              <div class='flex-start'>
                <div class='yuandian'></div>
                <div class='dataStyle'>${val.name}</div>
                </div>
              <div>${val.value}</div>
            </div>`

          const indicatorValue = {}
          indicatorValue.name = val.name
          indicatorValue.max = max * 1.1
          return indicatorValue
        })
        const formatter = `<div class="real-time-radar">
            <div>服务1</div>
            <div class='br'>
              <div class='br1'></div>       
              <div class='br2'></div>
            </div>
          ${dataArr}
           
            </div>`
        option.tooltip.formatter = formatter
        option.series[0].data[0].value = data.map(val => val.value)
        option.radar.indicator = indicator
        return option
      }
      return option
    },
  },
}
</script>
<style>
.real-time-radar{
  min-width:150px;
  padding:10px;
  border:2px solid #0695A9;
  border-radius: 3px;
  background: rgba(0, 0, 0, 0.8)
}
 .real-time-radar .br{
  height: 2px;
  position: relative;
  margin: 10px 0;
  background: #3C636B;
}
.yuandian{
  width:5px;
  height: 5px;
  border-radius: 50%;
  background: #05D0EB;
}
.dataStyle{
  margin:0 10px 0 5px;
}
.real-time-radar .br1,.real-time-radar .br2{
  position: absolute;
  width:10px;
  height: 2px;
  background: #71BFCA;
  top:0;
}
.real-time-radar .br1{
  left: 0px;
}
.real-time-radar .br2{
  right: 0px;
}
</style>


