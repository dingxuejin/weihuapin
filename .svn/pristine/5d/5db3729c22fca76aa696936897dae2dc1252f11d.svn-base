<template>
  <div class="companyIndex-con">
    <div class="company-indexCon-item clearfix">
      <div class="item fl">
        <div class="item-left fl">
          <p class="item-left-title">在班人员</p>
          <div class="item-index">{{zbryData[1].value}}</div>
          <p class="item-unit">人</p>
        </div>
        <div class="item-right fr">
          <div class="ringSingle-chartCon">
            <ringSingle :data="zbryData"
                  color="#05d0eb"
                  borderColor="#058c96"
                  chartTheme="dark"></ringSingle>
          </div>
          <p class="ringSingle-chartCon-title">在班人员占比</p>
        </div>
      </div>
      <div class="item fl">
        <div class="item-left fl">
          <p class="item-left-title">工作车辆</p>
          <div class="item-index">
            <div class="carIndex">
              <p class="car-title fl">空车数</p>
              <p class="car-index fr">辆</p>
              <p class="car-unit fr">{{kcsData[0].value}}</p>
            </div>
            <div class="carIndex">
              <p class="car-title fl">重车数</p>
              <p class="car-index fr">辆</p>
              <p class="car-unit fr">{{kcsData[1].value}}</p>
            </div>
          </div>
        </div>
        <div class="item-right fr">
          <div class="ringSingle-chartCon">
            <ringSingle :data="kcsData"
                  color="#81d9e5"
                  borderColor="#498c91"
                  chartTheme="dark"></ringSingle>
          </div>
          <p class="ringSingle-chartCon-title">空车占比</p>
        </div>
      </div>
    </div>

    <div class="company-indexCon-item clearfix">
      <div class="item fl">
        <div class="item-left fl">
          <p class="item-left-title">当日行驶里程</p>
          <div class="item-index">{{xslcData[1].value}}</div>
          <p class="item-unit">公里</p>
        </div>
        <div class="item-right fr">
          <div class="ringSingle-chartCon">
            <ringSingle :data="xslcData"
                  color="#e75029"
                  borderColor="#991f07"
                  chartTheme="dark"></ringSingle>
          </div>
          <p class="ringSingle-chartCon-title">当日行驶里程占比</p>
        </div>
        <div class="companyIndex-btn">
        </div>
      </div>
      <div class="item fl">
        <div class="item-left fl">
          <p class="item-left-title">活跃运单数</p>
          <div class="item-index">{{orderData[1].value}}</div>
          <p class="item-unit">单</p>
        </div>
        <div class="item-right fr">
          <div class="ringSingle-chartCon">
            <ringSingle :data="orderData"
                  color="#f6ffcb"
                  borderColor="#8e934c"
                  chartTheme="dark"></ringSingle>
          </div>
          <p class="ringSingle-chartCon-title">活跃运单数占比</p>
        </div>
        <div class="companyIndex-btn">
        </div>
      </div>
    </div>

    <div class="company-indexCon-item clearfix">
      <div class="item fl">
        <div class="item-left fl">
          <p class="item-left-title">当日货运量</p>
          <div class="item-index">{{hylData[1].value}}</div>
          <p class="item-unit">吨</p>
        </div>
        <div class="item-right fr">
          <div class="ringSingle-chartCon">
            <ringSingle :data="hylData"
                  color="#81d9e5"
                  borderColor="#498c91"
                  chartTheme="dark"></ringSingle>
          </div>
          <p class="ringSingle-chartCon-title">当日货运量占比</p>
        </div>
        <div class="companyIndex-btn">
        </div>
      </div>
      <div class="item fl">
        <div class="item-left fl">
          <p class="item-left-title">当日周转量</p>
          <div class="item-index">{{zzlData[1].value}}</div>
          <p class="item-unit">吨公里</p>
        </div>
        <div class="item-right fr">
          <div class="ringSingle-chartCon">
            <ringSingle :data="zzlData"
                  color="#05d0eb"
                  borderColor="#058c96"
                  chartTheme="dark"></ringSingle>
          </div>
          <p class="ringSingle-chartCon-title">当日周转量占比</p>
        </div>
        <div class="companyIndex-btn">
        </div>
      </div>
    </div>

  </div>
</template>

<script type="text/javascript">
import ringSingle from '../../../components/charts/ringSingle'

export default {
  name: 'companyIndex',
  components: {
    ringSingle,
  },
  data() {
    return {
      zbryData: [
        {
          name: '总人数',
          value: 353,
        },
        {
          name: '在班人数',
          value: 145,
        },
      ],
      kcsData: [
        {
          name: '总车数',
          value: 388,
        },
        {
          name: '空车数',
          value: 145,
        },
      ],
      xslcData: [
        {
          name: '总里程数',
          value: 400,
        },
        {
          name: '当日里程数',
          value: 145,
        },
      ],
      orderData: [
        {
          name: '总里程数',
          value: 400,
        },
        {
          name: '当日里程数',
          value: 245,
        },
      ],
      hylData: [
        {
          name: '总货运量',
          value: 400,
        },
        {
          name: '当日货运量',
          value: 200,
        },
      ],
      zzlData: [
        {
          name: '总周转量',
          value: 400,
        },
        {
          name: '当日周转量',
          value: 166,
        },
      ],
    }
  },
}
</script>

<style lang="scss" scoped>
.companyIndex-con {
  width: 530px;
  height: 280px;
  overflow: hidden;
}
.company-indexCon-item {
  width: 100%;
  height: 80px;
  overflow: hidden;
  // background: green;
}
.company-indexCon-item:nth-child(n + 2) {
  margin-top: 20px;
}

.item {
  width: 255px;
  height: 80px;
  overflow: hidden;
  position: relative;
  // background: cyan;
}
.item:nth-child(2) {
  margin-left: 20px;
}

.item-left,
.item-right {
  width: 140px;
  height: 80px;
  overflow: hidden;
  position: relative;
  // background: yellow;
}
.item-left-title {
  width: 100%;
  height: 20px;
  overflow: hidden;
  color: #81d9e5;
  font-size: 16px;
  text-align: center;
  line-height: 20px;
  background: rgba(3, 193, 252, 0.3);
}
.item-index {
  height: 50px;
  overflow: hidden;
  margin-top: 10px;
  box-sizing: border-box;
  border: 1px solid #81d9e5;
  color: #81d9e5;
  font-size: 24px;
  font-weight: bold;
  text-align: center;
  line-height: 48px;
  // background: green;
}
.item-unit {
  color: #81d9e5;
  font-size: 14px;
  position: absolute;
  right: 2px;
  bottom: 5px;
  // background: purple;
}

.item-right {
  width: 115px;
  // background: blue;
}
.ringSingle-chartCon {
  height: 60px;
  // background: pink;
}
.ringSingle-chartCon-title {
  height: 20px;
  color: #81d9e5;
  font-size: 14px;
  text-align: center;
  line-height: 20px;
  // background: cyan;
}

//车辆单独样式
.carIndex {
  color: #81d9e5;
  font-size: 14px;
  font-weight: normal;
  width: 100%;
  height: 24px;
  overflow: hidden;
  line-height: 24px;
  // background: #81d9e5;
}
.car-title {
  margin-left: 10px;
}
.car-unit {
  margin-right: 5px;
}
.car-index {
  margin-right: 10px;
}

// 弹窗按钮
.companyIndex-btn {
  width: 20px;
  height: 5px;
  overflow: hidden;
  position: absolute;
  top: 0;
  right: 0;
  background: url("../../../assets/company/icons_more.png");
  cursor: pointer;
}
</style>