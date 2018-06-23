<template>
  <div class="content">
    <Echarst :options="newOption"
             :theme="chartTheme"></Echarst>

    <div class="infobox">
      <div class="msgTitle"></div>
      <div class="msgIndex"></div>
    </div>
  </div>

</template>

<script type="text/javascript">
import Echarst from 'vue-echarts'

export default {
  name: 'barInfobox',
  props: ['chartTheme', 'data', 'color', 'yaxisName'],
  components: {
    Echarst,
  },
  computed: {
    newOption() {
      const option = this.chartOption
      option.color = this.color
      option.yAxis.name = this.yaxisName
      option.xAxis.data = this.data.map(item => item.name)
      option.series.data = this.data.map(item => item.value)

      return option
    },
  },
  data() {
    return {
      chartOption: {
        tooltip: {
          formatter(params) {
            return (
              `${'<div class="barInfoboxToolTip">' +
              '<p class="title">'}${params.name}</p>` +
              '<div class="itemsBorder clearfix"><div></div><div></div><div></div></div>' +
              `<p class="index">${Number(params.value).toFixed(2)}</p>` +
              '</div>'
            )
          },
        },
        grid: {
          left: '4%',
          right: '3%',
          top: 60,
          bottom: 0,
          containLabel: true,
        },
        xAxis: {
          type: 'category',
          axisTick: {
            show: false,
          },
          axisLine: {
            show: false,
          },
          axisLabel: {
            fontSize: 14,
          },
          splitLine: {
            show: false,
          },
          data: [],
        },
        yAxis: [
          {
            type: 'value',
            nameTextStyle: {
              fontSize: 16,
            },
            boundaryGap: ['0%', '50%'],
            axisTick: {
              show: false,
            },
            axisLine: {
              show: false,
            },
            axisLabel: {
              fontSize: 14,
            },
          },
        ],
        series: {
          type: 'bar',
          barWidth: '40%',
          data: [],
        },
      },
    }
  },

  mounted() {
    const chartData = this.data
    const chart = this.$children[0].chart
    const chartCon = this.$el
    const msgTitle = document.getElementsByClassName('msgTitle')[0]
    const msgIndex = document.getElementsByClassName('msgIndex')[0]

    // 默认触发
    chart.dispatchAction({
      type: 'showTip',
      seriesIndex: 0,
      dataIndex: 0,
    })

    // infobox
    msgTitle.innerText = `${chartData[0].name}总油耗`
    msgIndex.innerText = chartData[0].total

    chart.on('mouseover', (params) => {
      const index = params.dataIndex

      msgTitle.innerText = `${params.name}总油耗`
      msgIndex.innerText = chartData[index].total
    })

    chartCon.onmouseout = function () {
      chart.dispatchAction({
        type: 'showTip',
        seriesIndex: 0,
        dataIndex: 0,
      })

      msgTitle.innerText = `${chartData[0].name}总油耗`
      msgIndex.innerText = chartData[0].total
    }
  },
}
</script>

<style lang="scss">
.content {
  width: 100%;
  height: 100%;
  position: relative;
}
.echarts {
  width: 100%;
  height: 100%;
}
// tooltip 样式
.barInfoboxToolTip {
  min-width: 100px;
  min-height: 10px;
  padding: 10px;
  overflow: hidden;
  border: 2px solid rgba(5, 208, 235, 0.78);
  background: rgba(9, 10, 11, 0.9);
  color: #fff;
  font-size: 14px;

  // 间隔线
  .itemsBorder {
    width:100%;
    height: 2px;
    margin-top:10px;
    // background: orange;
    div:nth-child(odd) {
      width: 10px;
      height: 100%;
      overflow: hidden;
      float: left;
      background: #81d9e5;
    }
    div:nth-child(even) {
      width: calc(100% - 20px);
      height: 100%;
      overflow: hidden;
      float: left;
      background: rgba(129, 217, 229, 0.5);
    }
  }
  // 图表数据
  .index{
    margin-top:10px;
  }
}

/* infobox */
.infobox {
  min-width: 150px;
  /*height:40px;*/
  position: absolute;
  top: 50px;
  right: 30px;
  padding: 5px 10px;
  color: #fff;
  text-indent: 10px;
  /*background: pink;*/
  border: 1px solid cyan;
}

.msgTitle {
  width: 100%;
  color: #b5b5b5;
  font-size: 14px;
  text-align: left;
  /*padding: 10px 0px 10px 10`px;*/
  padding-bottom: 5px;
  border-bottom: 1px solid cyan;
  /*background: pink;*/
}
.msgIndex {
  width: 100%;
  color: #fff;
  font-size: 24px;
  font-weight: bold;
  padding-top: 5px;
  text-align: right;
  /*background: green;*/
}
</style>
