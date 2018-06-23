<template>
  <div class="content">
    <Echarts :options="chartOption"
             :theme="chartTheme"></Echarts>
    <div class="msgCon">
      <div class="ringMore-msgTitle">

      </div>
      <div class="ringMore-msgIndex">

      </div>
    </div>
  </div>

</template>

<script type="text/javascript">
import Echarts from 'vue-echarts'

export default {
  name: 'ringSingleMore',
  props: ['chartTheme', 'data', 'color', 'radius'],
  components: {
    Echarts,
  },
  data() {
    const chartData = this.data
    const color = this.color
    const radiusData = this.radius

    const chartObj = {
      chartOption: {
        legend: {
          show: false,
          type: 'scroll',
          pageTextStyle: {
            color: '#fff',
          },
          right: '2%',
          bottom: '5%',
          orient: 'vertical',
          silent: true,
          textStyle: {
            // color:'#fff'
          },
          data: (function (data) {
            const arr = []
            data.forEach((item) => {
              arr.push(item.name)
            })
            return arr
          }(chartData)),
        },
        tooltip: {
          show: false,
        },
        series: [
          // 背景
          {
            type: 'pie',
            center: ['50%', '50%'],
            radius: radiusData[0],
            silent: true,
            hoverAnimation: false,
            label: {
              normal: {
                show: false,
              },
            },
            labelLine: {
              normal: {
                show: false,
              },
            },
            itemStyle: {
              normal: {
                color: color[0],
              },
            },
            data: [0],
          },
        ],
      },
    }

    chartData.forEach((item, i) => {
      const obj = {
        name: chartData[0].name,
        type: 'pie',
        center: ['50%', '50%'],
        radius: radiusData[i + 1],
        avoidLabelOverlap: false,
        labelLine: {
          normal: {
            show: false,
          },
        },
        hoverAnimation: false,
        data: [
          {
            name: chartData[i].name,
            value: chartData[i].value,
            itemStyle: {
              normal: {
                // color: (function () {
                //   const num = color.length
                //   return color[i % num + 1]
                // }()),
                color: (function () {
                  const num = color.length
                  const index = i % num
                  const currentIndex = index + 1
                  return color[currentIndex]
                }()),
                label: {
                  show: false,
                },
                labelLine: {
                  show: false,
                },
              },
              emphasis: {
                show: false,
              },
            },
          },
          {
            name: 'invisible',
            value: chartData[i].total - chartData[i].value,
            silent: true,
            itemStyle: {
              normal: {
                // 未完成的圆环的颜色 透明
                color: 'rgba(0,0,0,0)',
                label: {
                  show: false,
                },
                labelLine: {
                  show: false,
                },
              },
              emphasis: {
                show: false,
              },
            },
            tooltip: {
              show: false,
            },
            cursor: 'arrow',
          },
        ],
      }

      chartObj.chartOption.series.push(obj)
    })

    return chartObj
  },

  mounted() {
    // var chartData=this.$options.propsData.data;
    const chartData = this.data
    const len = chartData.length

    const msgTitle = document.getElementsByClassName('ringMore-msgTitle')[0]
    const msgIndex = document.getElementsByClassName('ringMore-msgIndex')[0]
    const data1 = chartData[len - 1].value * 100
    const data2 = chartData[len - 1].total
    const data3 = data1 / data2
    const percent = `${data3.toFixed(1)}%`

    msgTitle.innerText = chartData[len - 1].name
    msgIndex.innerText = percent

    const chart = this.$children['0'].chart
    chart.on('mouseover', (params) => {
      if (params.dataIndex !== 1) {
        // console.log(params.name,params.value,params.percent);
        msgTitle.innerText = params.name
        msgIndex.innerText = `${params.percent.toFixed(1)}%`
      }
    })

    const chartCon = this.$el
    chartCon.onmouseout = function () {
      msgTitle.innerText = chartData[len - 1].name
      msgIndex.innerText = percent
    }
  },
}
</script>

<style lang="scss" scoped>
.content {
  width: 100%;
  height: 100%;
  position: relative;

  /*background: green;*/
}

.echarts {
  width: 100%;
  height: 100%;
}

/* msgCon */
.msgCon {
  width: 30%;
  height: 20%;
  overflow: hidden;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  text-align: center;

  /*background: red;*/
  /*border:1px solid red;*/
}

.ringMore-msgTitle {
  width: 100%;
  position: absolute;
  top: 0;
  color: #b5b5b5;
  font-size: 20px;
  /*background: green;*/
}

.ringMore-msgIndex {
  width: 100%;
  position: absolute;
  bottom: 0;
  color: #fff;
  font-size: 30px;
  font-weight: bold;
  /*background: pink;*/
}
</style>