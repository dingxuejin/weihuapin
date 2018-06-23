<template>
  <Echart :options="newOption"
          class="sourceNetClassificationRatioPie"></Echart>
</template>

<script>
import Echart from 'vue-echarts'

export default {
  /* eslint-disable */
  // props: ['seriesData'],
  components: {
    Echart
  },
  data() {
    return {
      seriesData: [
        { name: "100辆以上的企业数", value: 50 },
        { name: "50-99辆的企业数", value: 25 },
        { name: "10-49辆的企业数", value: 50 },
        { name: "5-9辆的企业数", value: 40 },
        { name: "5辆以下的企业数", value: 96 }
      ],
      option: {
        grid: {
          // width: '80%',
          // height: '60%',
          left: "10%",
          // right: '10%',
          top: "0%",
          bottom: "2%",
          containLabel: true
        },
        tooltip: {
          trigger: "item",
          axisPointer: {
            type: "shadow"
          },
          position: ['40%', '30%'],
          backgroundColor: "rgba(0,0,0,0)",
          formatter(params) {
            return (
              `${'<div class="barHorToolTip">' + '<p class="title">'}${
                params.name
              }</p>` +
              '<div class="itemsBorder clearfix"><div></div><div></div><div></div></div>' +
              `<p class="index">${Number(params.value).toFixed(2)}</p>` +
              "</div>"
            );
          }
          // position(p) {
          // console.log('charts pointer', p)
          // return [p[0], p[1]]
          // },
        },
        legend: {
          show: true,
          // icon: 'none',
          left: "30px",
          bottom: "4px",
          // itemGap: 22,
          textStyle: {
            color: "#A7ADAF",
            fontSize: 12
          },
          width: 134,
          height: 85,
          padding: 0,
          itemGap: 5,
          itemWidth: 15,
          itemHeight: 8
        },
        toolbox: {
          show: false
        },
        series: []
      }
    };
  },
  computed: {
    newOption() {
      const newOption = this.option;
      const data = this.seriesData;
      const seriesObjs = [];
      //   let r = 200
      const color = ["#81D9E5", "#F6FFCB ", "#E75029", "#038BFC", "#006AA5"];
      const placeHolderStyle = {
        normal: {
          label: {
            show: false,
            position: "center"
          },
          labelLine: {
            show: false
          },
          color: "rgba(0, 0, 0, 0)",
          borderColor: "rgba(0, 0, 0, 0)",
          borderWidth: 0
        }
      };
      const maxData = data && data.map(o => o.value);
      // console.log('maxData', maxData)
      let sum = 0;

      for (let i = 0; i < maxData.length; i++) {
        sum += maxData[i];
      }
      // console.log('sum', sum)
      for (let i = 0; i < data.length; i++) {
        const seriesObj = {
          name: `${data[i].name}`,
          type: "pie",
          clockWise: true,
          hoverAnimation: false,
          hoverOffset: 0,
          selectedOffset: 0,
          center: ["68%", "50%"],
          animation: false,
          radius: [`${`${74}` - i * 10}%`, `${`${69}` - i * 10}%`],
          itemStyle: {
            normal: {
              label: {
                show: false,
                position: "center"
              },
              color: color[i],
              labelLine: {
                show: false
              },
              // borderWidth: 12,
              borderColor: color[i]
            }
          },
          data: [
            {
              name: `${data[i].name}`,
              value: data[i].value
            },
            {
              value: sum - data[i].value,
              itemStyle: placeHolderStyle
            }
          ]
        };
        seriesObjs.push(seriesObj);
      }
      newOption.series = seriesObjs;
      return newOption;
    }
  }
};
</script>

<style lang="scss">
.sourceNetClassificationRatioPie {
  width: 100% !important;
  height: 100% !important;
}
/* tooltip 样式 */
.lineDataZoomTooltip {
  min-width: 142px;
  min-height: 40px;
  padding: 5px;
  overflow: hidden;
  border: 2px solid rgba(5, 208, 235, 0.78);
  background: rgba(9, 10, 11, 0.9);
  color: #fff;
  font-size: 14px;
  line-height: 20px;

  /* /间隔线 */
  .itemsBorder {
    width: 100%;
    height: 2px;
    margin-top: 10px;
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
</style>

