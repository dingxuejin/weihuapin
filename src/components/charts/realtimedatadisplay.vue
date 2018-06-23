<template>
  <Echarts :options="newOption"
           :theme="chartTheme"></Echarts>
</template>

<script type="text/javascript">
import Echarts from 'vue-echarts'

export default {
  /*eslint-disable */
  name: 'pieRose',
  props: ['chartTheme', 'data', 'color'],
  components: {
    Echarts,
  },
  computed: {
    newOption() {
      const newOption = this.option
      const mydata = this.data
      newOption.series[0].data =
        mydata &&
        mydata.map(item => ({
          value: item.value,
          name: `${item.name}`,
          label: {
            normal: {
              show: true,
              color: '#fff',
              formatter:'{b}\n{c}'
              // formatter(e) {
              //   // console.log(e)
              //   const strsData = e.data.name+e.data.value 
              //   console.log('strsData',strsData) 
              //   const  strs=strsData.split('') // 字符串数组
              //     console.log('strs',strs) 
              //   let str = ''
              //   for (var i = 0, s; (s = strs[i++]);) {
              //     // 遍历字符串数组
              //     str += s
              //     if (!(i % 2)) str += '\n' // 按需要求余
              //   }
              //   console.log('str',str) 
              //   return str
              // },
            },
          },
          labelLine: {
            normal: {
              length: 10,
              length2: 5,
              show: true,
              lineStyle: {
                color: '#f6ffcb',
              },
            },
          },
        }))
      newOption.legend.data = mydata && mydata.map(item => `${item.name}`)
      // console.log(newOption)
      return newOption
    },
  },
  data() {
    return {
      option: {
        tooltip: {
          show: false,
          trigger: 'item',
          textStyle: {
            fontSize: 14,
          },
          formatter: '{b}<br/>{d}%',
        },
        // grid: {
        //   // width: '80%',
        //   // height: '60%',
        //   left: '10%',
        //   right: '10%',
        //   top: '25%',
        //   bottom: '2%',
        //   containLabel: true,
        // },
        color: this.color,
        legend: {
          show: true,
          // type: 'scroll',
          // orient: 'vertical',
          // left: 'right',
          // top: 'bottom',
          right: '6px',
          bottom: '8px',
          data: [],
          textStyle: {
            color: '#A7ADAF',
            fontSize: 12,
          },
          width: 134,
          height: 85,
          padding: 0,
          itemGap: 5,
          itemWidth: 15,
          itemHeight: 8,
        },
        series: [
          {
            type: 'pie',
            // radius: 'radius',
            radius: '63%',
            center: ['40%', '50%'],
            label: {
              normal: {
                show: true,
                color: '#fff',
              },
            },
            labelLine: {
              normal: {
                length: 10,
                length2: 5,
                show: true,
                lineStyle: {
                  color: '#f6ffcb',
                },
              },
            },
            data: [],
          },
        ],
      },
    }
  },
}
</script>

<style lang="scss" scoped>
.echarts {
  width: 100%;
  height: 100%;
}
</style>
