<template>
  <div id="driverHistoryLine">
  </div>
</template>

<script>
import 'echarts/extension/bmap/bmap'
import bmapStyle from '../../../assets/mapStyle/mapStyle.json'

const provinceCoord = {
  北京: [116.395645, 39.929986],
  天津: [117.210813, 39.14393],
  河北: [114.522082, 38.048958],
  山西: [112.550864, 37.890277],
  内蒙古: [111.660351, 40.828319],
  辽宁: [123.432791, 41.808645],
  吉林: [125.3222, 43.816],
  黑龙江: [126.657717, 45.773225],
  上海: [121.4788, 31.2303],
  江苏: [118.778074, 32.057236],
  浙江: [120.219375, 30.259244],
  安徽: [117.282699, 31.866942],
  福建: [119.330221, 26.047125],
  江西: [115.893528, 28.689578],
  山东: [117.024967, 36.682785],
  河南: [113.649644, 34.75661],
  湖南: [112.979353, 28.213478],
  湖北: [114.3162, 30.581084],
  广东: [113.30765, 23.120049],
  广西: [108.297234, 22.806493],
  海南: [110.330802, 20.022071],
  重庆: [106.55, 29.5647],
  四川: [104.0648, 30.57],
  贵州: [106.709177, 26.629907],
  云南: [102.714601, 24.882],
  西藏: [91.111891, 29.662557],
  陕西: [108.939, 34.342],
  甘肃: [103.823305, 36.064226],
  青海: [101.767921, 36.640739],
  宁夏: [106.206479, 38.502621],
  新疆: [87.564988, 43.84038],
  香港: [114.15, 22.15],
  澳门: [113.5, 22.2],
  台湾: [121.5365, 25.0192],
}

export default {
  name: 'driverHistoryLine',
  props: ['data', 'color'],
  data() {
    return {}
  },
  watch: {
    data: {
      handler() {
        this.drawchart()
      },
      deep: true,
    },
  },
  methods: {
    drawchart() {
      const myChart = this.$echarts.init(
        document.getElementById('driverHistoryLine'),
      )

      const option = {
        tooltip: {
          show: true,
          // 改scatter 改scatter 开启下一行
          formatter(params) {
            console.log('scatter tooltip', params)
            return `${params.name}<br/>${params.value[2]}`
          },
        },
        bmap: {
          center: [110, 39],
          zoom: 5,
          roam: true,
          mapStyle: {
            styleJson: bmapStyle,
          },
        },
        visualMap: {
          left: 10,
          bottom: 60,
          splitNumber: 3,
          hoverLink: false,
          color: this.color,
          textStyle: {
            color: '#fff',
            fontSize: 12,
          },
          pieces: [{
            min: 0,
            max: 50000000,
            color: '#759aa0',
          }, {
            min: 50010000,
            max: 100000000,
            color: '#73b9bc',
          }, {
            min: 100010000,
            max: 200000000,
            color: '#8dc1a9',
          },
          // , {
          //   min: 200010000,
          //   color: '#dd6b66',
          // }
          ],
          max: (function (data) {
            const arr = []
            for (let i = 0; i < data.length; i += 1) {
              arr.push(data[i].value)
            }

            return Math.max.apply(null, arr)
          }(this.data)),

          min: (function (data) {
            const arr = []
            for (let i = 0; i < data.length; i += 1) {
              arr.push(data[i].value)
            }

            return Math.min.apply(null, arr)
          }(this.data)),

          formatter(value1, value2) {
            const v1 = value1.toString().slice(0, -4)
            const v2 = value2.toString().slice(0, -4)
            return `${v1 === '' ? '0' : `${v1}万`} --- ${`${v2}万`}`
            // return `${value.toFixed(0)} --- ${value2.toFixed(0)}`
          },
        },
        series: {
          // type: 'heatmap',
          // 改scatter 改scatter 开启下一行
          type: 'scatter',
          z: 10,
          coordinateSystem: 'bmap',
          // data: this.data
          data: this.data.map(item => ({
            name: item.name,
            value: [...provinceCoord[item.name], item.value],
            // 改scatter 开启下一行
            symbolSize: item.value / 5000000,
          })),
        },
      }

      myChart.setOption(option)
    },
  },

  mounted() {
    this.drawchart()
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss">
#driverHistoryLine {
  width: 100%;
  height: 100%;
  overflow: hidden;
  /* border: 1px solid red; */
  .tooltipContainer {
    width: 500px;
    height: 250px;
    overflow: hidden;
    border: 2px solid #05d0eb;
    background: rgba(9, 10, 11, 0.9);
    // 内容部分
    .tooltipContent {
      width: calc(100% - 20px);
      height: 100%;
      overflow: hidden;
      margin-left: 10px;
      // border:1px solid red;
      // background:pink;
      //items
      .items {
        width: 100%;
        height: 50px;
        overflow: hidden;
        // background:green;
        // itemsTitleContent
        .itemsTitleContent {
          // height:48px;
          height: calc(100% - 2px);
          overflow: hidden;
          font-size: 24px;
          color: #fff;
          line-height: 48px;
        }
        .itemsContent {
          // height:48px;
          height: calc(100% - 2px);
          overflow: hidden;
          font-size: 16px;
          color: #fff;
          line-height: 48px;
          position: relative;
          // title
          .itemTitle {
            float: left;
            // background: red;
          }
          // index
          .itemIndex {
            position: absolute;
            left: 130px;
            top: 0;
            color: #05d0eb;
            font-size: 24px;
            font-weight: bold;
            // background: green;
          }
          .itemOrderNum {
            font-size: 20px;
            font-weight: normal;
          }
          // unit
          .mileageUnit {
            position: absolute;
            left: 220px;
            top: 12px;
            color: #05d0eb;
            font-size: 16px;
            font-weight: bold;
            line-height: 30px;
            // background: red;
          }
          .speedUnit {
            position: absolute;
            left: 190px;
            top: 12px;
            color: #05d0eb;
            font-size: 16px;
            font-weight: bold;
            line-height: 30px;
          }
          .timeUnit {
            position: absolute;
            left: 200px;
            top: 0px;
            color: #05d0eb;
            font-size: 24px;
            font-weight: bold;
            line-height: 48px;
          }
        }
        .itemsBorder {
          height: 2px;
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
      }
    }
  }
  .lineTooltipContainer {
    height: 350px;
  }
}
</style>
