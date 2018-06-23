<template>
  <Echarts :options="newOption"
           :theme="chartTheme"></Echarts>
</template>

<script type="text/javascript">
import Echarts from 'vue-echarts'

export default {
  name: 'sunburst',
  components: {
    Echarts,
  },
  props: ['data', 'chartTheme', 'color'],
  computed: {
    newOption() {
      const option = this.chartOption
      option.color = this.color
      option.series.data = this.data
      return option
    },
  },
  data() {
    return {
      chartOption: {
        tooltip: {
          // show: 'false',
          // trigger: 'none',
        },
        textStyle: {
          color: 'rgb(255, 255, 0)',
          // fontWeight: 'bold',
          // fontFamily: 'Microsoft YaHei',
          fontSize: '13',
        },
        series: {
          type: 'sunburst',
          highlightPolicy: 'descendant',
          nodeClick: 'rootToNode',
          label: {
            rotate: 'radial',
            show: false,
            color: 'red',
          },
          emphasis: {
            itemStyle: {
              color: 'red',
            },
            label: {
              show: true,
              color: 'yellow',
            },
          },
          highlight: {
            itemStyle: {
              color: 'green',
            },
          },
          downplay: {
            itemStyle: {
              color: '#ccc',
            },
          },
          radius: ['50%', '80%'],
          data: [],
        },
      },
    }
  },
}
</script>

<style lang="scss" scoped>

</style>
