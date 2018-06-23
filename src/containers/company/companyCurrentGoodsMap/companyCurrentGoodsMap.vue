<template>
  <div id="companyCurrentGoodsMap">
  </div>
</template>

<script>
/* eslint-disable */
import 'echarts/extension/bmap/bmap'
import bmapStyle from '../../../assets/mapStyle/mapStyle.json'

export default {
  name: 'companyCurrentGoodsMap',
  props: ['data'],
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
      const myChart = this.$echarts.init(document.getElementById('companyCurrentGoodsMap'))
      const option = {
        tooltip: {
          show: true,
          showContent: true,
          confine: true,
          formatter(params) {
            return (
              `${'<div class="tooltipContainer"><div class="tooltipContent">' +
              '<div class="items"><div class="itemsTitleContent">'}${
              params.data.source
              }--${
              params.data.target
              }</div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">运单号</div><div class="itemIndex">${
              params.data.orderNum
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">货源地</div><div class="itemIndex">${
              params.data.source
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">目的地</div><div class="itemIndex">${
              params.data.target
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">车队</div><div class="itemIndex">${
              params.data.carCategory
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              // test
              `<div class="items"><div class="itemsContent"><div class="itemTitle">货物类型</div><div class="itemIndex">${
              params.data.goodsType
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">货物量</div><div class="itemIndex itemOrderNum">${
              params.data.goodsAmount
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">车牌号</div><div class="itemIndex">${
              params.data.carCode || ''
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              `<div class="items"><div class="itemsContent"><div class="itemTitle">车辆类型</div><div class="itemIndex">${
              params.data.carType || ''
              }</div></div><div class="itemsBorder clearfix"><div></div><div></div><div></div></div></div>` +
              '</div></div>'
            )
          },
        },
        bmap: {
          center: [110, 40],
          zoom: 5,
          roam: true,
          mapStyle: {
            styleJson: bmapStyle,
          },
        },
        series: [
          {
            name: '地点',
            type: 'effectScatter',
            coordinateSystem: 'bmap',
            zlevel: 2,
            rippleEffect: {
              brushType: 'stroke',
            },
            label: {
              emphasis: {
                show: false,
                position: 'right',
                formatter: '{b}',
              },
            },
            symbolSize: 2,
            showEffectOn: 'render',
            itemStyle: {
              normal: {
                color: '#46bee9',
              },
            },
            data:[] ,//this.data.citys,
            tooltip: { show: false },
          },
          {
            name: '线路',
            type: 'lines',
            coordinateSystem: 'bmap',
            zlevel: 2,
            large: true,
            effect: {
              show: true,
              constantSpeed: 30,
              symbol: 'pin',
              symbolSize: 3,
              trailLength: 0,
            },
            lineStyle: {
              normal: {
                width: 3,
                curveness: 0.1,
                color: {
                  type: 'linear',
                  x: 0,
                  y: 0,
                  x2: 0,
                  y2: 1,
                  colorStops: [
                    {
                      offset: 0,
                      color: '#05d0eb',
                    },
                    {
                      offset: 1,
                      color: '#e75029',
                    },
                  ],
                  globalCoord: false,
                },
              },
              emphasis: {
                color: 'red',
              },
            },
            data: this.data,
          },
        ],
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
#companyCurrentGoodsMap {
  width: 100%;
  height: 100%;
  overflow: hidden;
  /* border: 1px solid red; */
  .tooltipContainer {
    width: 500px;
    // height: 350px;
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
          .trafficMileageUnit {
            position: absolute;
            right: 0px;
            top: 15px;
            color: #05d0eb;
            font-size: 16px;
            font-weight: bold;
            line-height: 30px;
            // background: red;
          }
          .orderNumUnit {
            position: absolute;
            left: 180px;
            top: 10px;
            color: #05d0eb;
            font-size: 16px;
            font-weight: bold;
            line-height: 30px;
            // background: red;
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
}
</style>
