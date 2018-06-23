<template>
  <div class="carDetails_warp clearfix">
  <car-details-close @close="carDetailsClosePopup">
    <div class="carDetails_warp_content_title">
      <div class="carDetails_warp_content_title_left">
        <div class="carDetails_warp_content_title_left_carpic" @click='$router.push("/car")'>
          <img src="../../assets/car/right_icons_cars1.png" alt="">
        </div>
        车辆详情
      </div>
    </div>
    <div class="carDetails_warp_content_carLeft">
      <div class="carDetails_warp_content_carLeft1" v-for="(item,index) in carDetailstitle" :key="index">
        <div class="carDetails_title_warp">
          {{item.name}}
        </div>
        <div class="carDetails_content_warp">
          <div class="carDetails_content"></div> 
          <div class="carDetails_content_zi">
            {{item.content}}
          </div>
        </div>
      </div>
    </div>
    <div class="carDetails_warp_content_carRight" v-if="key===1">
      <div class="carDetails_pic_title">车辆照片</div>
      <div class="carDetails_content_pic">
          <img src="../../assets/guanche.jpg" alt="">
      </div>
      <div class="carDetails_content_add">
        <div class="carDetails_content_add1" v-for="(item,index) in carPic" :key="index">
          <div class="add_content1">+</div>
          <span>{{item.name}}</span>
        </div>
        <div class="carDetails_content_smLeftSwitch">
          <img src="../../assets/car/center_icons_arrow_left.png" alt="">
        </div>
        <div class="carDetails_content_smRightSwitch">
          <img src="../../assets/car/center_icons_arrow_right.png" alt="">
        </div>
      </div>
    </div>
    <div class="carDetails_warp_content_carRight" v-if="key===2">
      <div class="carDetails_pic_title">车辆音频</div>
      <div class="carDetails_content_pic">
          <img src="../../assets/car/circleButton.png" alt="">
      </div>
      <div class="carDetails_content_add">
        <div class="carDetails_content_add1" v-for="(item,index) in carPic" :key="index">
          <div class="add_content1">+</div>
          <span>{{item.name}}</span>
        </div>
        <div class="carDetails_content_smLeftSwitch">
          <img src="../../assets/car/center_icons_arrow_left.png" alt="">
        </div>
        <div class="carDetails_content_smRightSwitch">
          <img src="../../assets/car/center_icons_arrow_right.png" alt="">
        </div>
      </div>
    </div>
    <div class="carDetails_warp_content_carRight" v-if="key===3">
      <div class="carDetails_pic_title">ADAS/DMS数据展示</div>
      <div class="carDetails_adas_warp">
        <div class="carDetails_adas_warp1">
          <div class="carDetails_adas" v-for="(item,index) in adadDataList" :key="index">
          <div class="carDetails_title_warp">
            {{item.name}}
          </div>
          <div class="carDetails_content_warp">
            <div class="carDetails_content"></div> 
            <div class="carDetails_content_zi">
              {{item.content}}
            </div>
          </div>
        </div>
        <div class="carDetails_adas_warp1_leftSwitch" @click="SwitchAdas('last')"  v-show='adasCurPage>0'>
          <img src="../../assets/car/center_icons_arrow_left.png" alt="">
        </div>
        <div class="carDetails_adas_warp1_rightSwitch" @click="SwitchAdas('!last')" v-show="adasCurPage<adaspageCount-1">
          <img src="../../assets/car/center_icons_arrow_right.png" alt="">
        </div>
        </div> 
      </div>
    </div>
    <div class="carDetails_warp_content_carRight" v-if="key===4">
      <div class="carDetails_pic_title">驾驶员状态</div>
      <div class="carDetails_adas_warp">
        <div class="carDetails_adas_warp1">
          <div class="carDetails_adas" v-for="(item,index) in driverStateData" :key="index">
          <div class="carDetails_title_warp">
            {{item.name}}
          </div>
          <div class="carDetails_content_warp">
            <div class="carDetails_content"></div> 
            <div class="carDetails_content_zi">
              {{item.content}}
            </div>
          </div>
        </div>
        <div class="carDetails_adas_warp1_leftSwitch" @click="SwitchDriver('last')"  v-show='driverCurPage>0'>
            <img src="../../assets/car/center_icons_arrow_left.png" alt="">
          </div>
          <div class="carDetails_adas_warp1_rightSwitch" @click="SwitchDriver('!last')" v-show="driverCurPage<driverpageCount-1">
            <img src="../../assets/car/center_icons_arrow_right.png" alt="">
          </div>
        </div> 
      </div>
    </div>
    <div class="carDetails_warp_content_carRight" v-if="key===5">
      <div class="carDetails_pic_title">传感器数据显示</div>
      <div class="carDetails_adas_warp">
        <div class="carDetails_adas_warp1">
          <div class="carDetails_adas" v-for="(item,index) in sensorDataList" :key="index">
          <div class="carDetails_title_warp">
            {{item.name}}
          </div>
          <div class="carDetails_content_warp">
            <div class="carDetails_content"></div> 
            <div class="carDetails_content_zi">
              {{item.content}}
            </div>
          </div>
        </div>
        <div class="carDetails_adas_warp1_leftSwitch" @click="SwitchSensor('last')"  v-show='sensorCurPage>0'>
          <img src="../../assets/car/center_icons_arrow_left.png" alt="">
        </div>
        <div class="carDetails_adas_warp1_rightSwitch" @click="SwitchSensor('!last')" v-show="sensorCurPage<sensorpageCount-1">
          <img src="../../assets/car/center_icons_arrow_right.png" alt="">
        </div>
        <!-- <div class="carDetails_adas_warp1_leftSwitch" @click="SwitchLeftAdas()">
          <img src="../../assets/car/center_icons_arrow_left.png" alt="">
        </div>
        <div class="carDetails_adas_warp1_rightSwitch" @click="SwitchRightAdas()">
          <img src="../../assets/car/center_icons_arrow_right.png" alt="">
        </div> -->
        </div> 
      </div>
    </div>
    <div class="carDetails_warp_content_carRight" v-if="key===6">
      <div class="carDetails_pic_title">CAN/OBD数据显示</div>
      <div class="carDetails_adas_warp">
        <div class="carDetails_adas_warp1">
          <div class="carDetails_adas" v-for="(item,index) in cadDataList" :key="index">
          <div class="carDetails_title_warp">
            {{item.name}}
          </div>
          <div class="carDetails_content_warp">
            <div class="carDetails_content"></div> 
            <div class="carDetails_content_zi">
              {{item.content}}
            </div>
          </div>
        </div>
        <div class="carDetails_adas_warp1_leftSwitch" @click="SwitchCad('last')"  v-show='cadCurPage>0'>
          <img src="../../assets/car/center_icons_arrow_left.png" alt="">
        </div>
        <div class="carDetails_adas_warp1_rightSwitch" @click="SwitchCad('!last')" v-show="cadCurPage<cadpageCount-1">
          <img src="../../assets/car/center_icons_arrow_right.png" alt="">
        </div>
        </div> 
      </div>
    </div>
    <div class="carDetails_warp_content_bgLeftSwitch" @click="SwitchLeft()">
      <img src="../../assets/car/center_icons_arrow_left.png" alt="">
    </div>
    <div class="carDetails_warp_content_bgRightSwitch" @click="SwitchRight()">
      <img src="../../assets/car/center_icons_arrow_right.png" alt="">
    </div>
    <div v-show="false">{{getInstantCarDetailsVal}}</div>
  </car-details-close>
  </div>
</template>

<script>
// import Dictionary from '../../util/dictionary'

// const { provinces } = Dictionary

import { mapState, mapMutations } from 'vuex'
import carDetailsClose from '../index/popupframe'

export default {
  name: '',
  components: {
    carDetailsClose,
  },
  data() {
    return {
      carDetailstitle: [
        { name: '车辆车牌', content: '苏E.80808' },
        { name: '车辆颜色', content: '黄色' },
        { name: '所属企业', content: '北京程盛新泰燃气有限公司' },
        { name: '接入的运营商平台', content: '北京中航天泰科技有限公司' },
        { name: '接入时间', content: '2018-02-12' },
        { name: '实时位置', content: '望京西' },
        { name: '车速', content: '32km/h' },
        { name: '定位时间', content: '2018-05-17 15:49' },
        { name: '当日报警条数', content: '10' },
        { name: '已处理条数', content: '8' },
      ],
      carPic: [
        { name: '倾斜车顶', content: '' },
        { name: '活动车顶', content: '' },
        { name: '车门框', content: '' },
        { name: '轮胎', content: '' },
        { name: '门饰板', content: '' },
        { name: '车身内测板', content: '' },
        { name: '内磁闭锁', content: '' },
        { name: '密封条', content: '' },
      ],
      adadPageSize: 7,
      adasCurPage: 0,
      cadCurPage: 0,
      sensorCurPage: 0,
      driverCurPage: 0,
      adaspageCount: '',
      cadpageCount: '',
      sensorpageCount: '',
      driverpageCount: '',
      pageCount: '',
      key: 1,
      // ADAS/DMS数据展示
      adadData: [
        { name: '车道偏离预警(LDW)', content: '2' },
        { name: '前向碰撞预警(FCW)', content: '1' },
        { name: '城市前碰撞(UFCW)', content: '1' },
        { name: '虚拟保险杠(VB)', content: '2' },
        { name: '车距检测(HM)', content: '1' },
        { name: '限速标志识别(SLI)', content: '2' },
        { name: '行人碰撞预警(PCW )', content: '3' },
        { name: '急加速报警', content: '1' },
        { name: '急减速报警', content: '2' },
        { name: '急转弯报警', content: '1' },
      ],
      adadDataList: [],
      // 驾驶员状态
      driverStateData: [
        { name: '分身', content: '1' },
        { name: '遮挡', content: '2' },
        { name: '离岗', content: '1' },
        { name: '左顾右盼', content: '1' },
        { name: '抽烟', content: '2' },
        { name: '打电话', content: '2' },
        { name: '打哈欠', content: '3' },
      ],
      driverStateDataList: [],
      // 传感器数据显示
      sensorData: [
        { name: '温度', content: '25.3℃' },
        { name: '湿度', content: '56.4' },
        { name: '油耗', content: '10L/公里' },
        { name: '货物状态', content: '无' },
      ],
      sensorDataList: [],
      // CAN/OBD数据显示
      cadData: [
        { name: '车辆诊断数据', content: '无' },
        { name: '车速', content: '无' },
        { name: '仪表盘数据', content: '无' },
        { name: '转向灯数据', content: '无' },
        { name: '刹车', content: '无' },
        { name: '雨刷', content: '无' },
        { name: '油箱油量数据', content: '无' },
        { name: '方向盘扭矩', content: '无' },
        { name: '远光灯状态', content: '无' },
        { name: '电动门状态', content: '无' },
        { name: '车内照', content: '无' },
      ],
      cadDataList: [],
    }
  },
  created() {

  },
  computed: {
    ...mapState('index', ['carDetailsShow', 'CompanyName']),
    getInstantCarDetailsVal() {
      this.carDetailsVal1()
      return ''
    },
  },
  methods: {
    ...mapMutations('index', ['getCarDetailsInfoShow']),
    SwitchLeft() {
      this.key = this.key - 1
      if (this.key === 0) {
        this.key = 6
      }
    },
    SwitchRight() {
      this.key = this.key + 1
      if (this.key === 7) {
        this.key = 1
      }
    },
    SwitchAdas(el) {
      if (el === 'last') {
        this.adasCurPage = this.adasCurPage - 1
      } else {
        this.adasCurPage = this.adasCurPage + 1
      }
      const curtotal = this.adasCurPage * this.adadPageSize
      const tiaoshu = curtotal + this.adadPageSize
      this.adadDataList = this.adadData.slice(curtotal, tiaoshu)
    },
    SwitchDriver(el) {
      if (el === 'last') {
        this.driverCurPage = this.driverCurPage - 1
      } else {
        this.driverCurPage = this.driverCurPage + 1
      }
      const curtotal = this.driverCurPage * this.adadPageSize
      const tiaoshu = curtotal + this.adadPageSize
      this.driverStateDataList = this.driverStateData.slice(curtotal, tiaoshu)
    },
    SwitchSensor(el) {
      if (el === 'last') {
        this.sensorCurPage = this.sensorCurPage - 1
      } else {
        this.sensorCurPage = this.sensorCurPage + 1
      }
      const curtotal = this.sensorCurPage * this.adadPageSize
      const tiaoshu = curtotal + this.adadPageSize
      this.sensorDataList = this.sensorData.slice(curtotal, tiaoshu)
    },
    SwitchCad(el) {
      if (el === 'last') {
        this.cadCurPage = this.cadCurPage - 1
      } else {
        this.cadCurPage = this.cadCurPage + 1
      }
      const curtotal = this.cadCurPage * this.adadPageSize
      const tiaoshu = curtotal + this.adadPageSize
      this.cadDataList = this.cadData.slice(curtotal, tiaoshu)
    },
    fanye() {
      if (this.adadData && this.cadData && this.sensorData && this.cadData) {
        this.adaspageCount = Math.ceil(this.adadData.length / this.adadPageSize)
        this.cadpageCount = Math.ceil(this.cadData.length / this.adadPageSize)
        this.sensorpageCount = Math.ceil(this.sensorData.length / this.adadPageSize)
        this.driverpageCount = Math.ceil(this.driverStateData.length / this.adadPageSize)
        for (let i = 0; i < this.adadPageSize; i += 1) {
          if (this.adadData[i] && this.driverStateData[i]) {
            this.adadDataList.push(this.adadData[i])
            this.driverStateDataList.push(this.driverStateData[i])
          }
          if (this.sensorData[i] && this.cadData[i]) {
            this.sensorDataList.push(this.sensorData[i])
            this.cadDataList.push(this.cadData[i])
          }
        }
      }
    },
    carDetailsVal1() {
      this.carDetailstitle[0].content = this.CompanyName
    },
    carDetailsClosePopup() {
      this.getCarDetailsInfoShow({
        state: false,
      })
    },
  },
  mounted() {
    this.fanye()
  },
}
</script>
<style lang="scss" scoped>
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.carDetails_warp{
  @include size(100%,100%);
  position: absolute;
  top:0;
  left:0;
  &_content_title{
    @include size(853px,40px);
    position: absolute;
    top:21px;
    left:5px;
    background: #144C7A;
    z-index: 10;
    &_left{
      @include size(360px,100%);
      position: absolute;
      top:0px;
      left:0px;
      background: #144C7A;
      font-size: 18px;
      color: #fff;
      text-align: center;
      line-height:36px;
      box-sizing:border-box;
      border: 2px solid #05D0EB; 
      z-index: 12;
      &_carpic{
        @include size(37px,24px);
        position: absolute;
        top:8px;
        left:40px;
        cursor: pointer;
        user-select: none;
         img{
           display: block;
           @include size(100%,100%);
         }
      }
    }
  }
  &_content_carLeft{
    @include size(420px,506px);
    position: absolute;
    top:81px;
    left:14px;
    background: #1C3345;
    &1{
      @include size(400px,40px);
      background: #244052;
      margin-top:10px;
      margin-left:10px;
      .carDetails_title_warp{
        @include size(170px,40px);
        background: #244052;
        font-size: 16px;
        color:#89DDDF;
        text-align: left;
        line-height:40px;
        box-sizing:border-box;
        padding-left: 23px;
        float: left; 
      }
      .carDetails_content_warp{
        @include size(230px,40px);
        background: #1C3345;
        font-size: 18px;
        color:#fff;
        text-align: left;
        line-height:36px;
        box-sizing:border-box;
        border: 2px solid #05D0EB;
        float: right;
        .carDetails_content{
          @include size(10px,10px);
          margin-top:12px;
          margin-left:15px;
          background: url('../../assets/car/icons_icon1_block.png') no-repeat center center;
          background-size: 100% 100%;
        } 
        .carDetails_content_zi{
          @include size(190px,40px);
          margin-left: 40px;
          margin-top: -22px;
          font-size: 18px;
          color:#fff;
          text-align: left;
          line-height:36px;
        }
      }
    }
  }
  &_content_carRight{
    @include size(400px,506px);
    position: absolute;
    top:81px;
    right:21px;
    // background: #1C3345;
    .carDetails_pic_title{
      @include size(400px,40px);
      box-sizing:border-box;
      border: 2px solid #05D0EB; 
      background: #0B0C0D;
      font-size: 18px;
      color:#fff;
      padding-left: 22px;
      text-align: left;
      line-height:36px;
    }
    .carDetails_content_pic{
      @include size(348px,232px);
      margin-top:15px;
      margin-left:26px; 
      box-sizing:border-box;
      border: 2px solid #05D0EB;
      position: absolute;
      img{
        display: block;
        @include size(100%,100%);
      }
    }
    .carDetails_content_add{
      @include size(400px,122px);
      position: absolute;
      bottom:81px;
      right:0px;
      background: #1C3345;
      &1{
        @include size(64px,44px);
        box-sizing: border-box;
        border: 1px dashed #3286BA;
        background: #1C3345;
        margin-top:12px;
        margin-left: 28px;
        float: left;
        font-size: 12px;
        color: #fff;
        text-align: center;
        .add_content1{
          font-size: 30px;
          color: #3286BA;
          text-align: center;
          line-height: 25px;
        }
        span{
          font-size: 12px;
          color: #fff;
          text-align: center;
          margin-top:-12px;
        }
      }
      .carDetails_content_smLeftSwitch{
        @include size(9px,15px);
        position: absolute;
        left:7px;
        top:52px;
        img{
          display: block;
          @include size(100%,100%);
        }
      }
      .carDetails_content_smRightSwitch{
        @include size(9px,15px);
        position: absolute;
        right:7px;
        top:52px;
        img{
          display: block;
          @include size(100%,100%);
        }
      }
    }
    .carDetails_adas_warp{
      @include size(400px,387px);
      box-sizing: border-box;
      border: 2px solid #05D0EB;
      margin-top:10px;
      position: absolute;
      &1{
        @include size(378px,363px);
        margin-top:12px;
        margin-left:10px;
        background: #1C3345;
        box-sizing: border-box;
        padding-top:1px;
        .carDetails_adas{
          @include size(355px,40px);
          background: #244052;
          margin-top:10px;
          margin-left:10px;
          .carDetails_title_warp{
            @include size(190px,40px);
            background: #244052;
            font-size: 16px;
            color:#89DDDF;
            text-align: left;
            line-height:40px;
            box-sizing:border-box;
            padding-left: 23px;
            float: left; 
          }
          .carDetails_content_warp{
            @include size(165px,40px);
            background: #1C3345;
            font-size: 18px;
            color:#fff;
            text-align: left;
            line-height:36px;
            box-sizing:border-box;
            border: 2px solid #05D0EB;
            float: right;
            .carDetails_content{
              @include size(10px,10px);
              margin-top:12px;
              margin-left:15px;
              background: url('../../assets/car/icons_icon1_block.png') no-repeat center center;
              background-size: 100% 100%;
            } 
            .carDetails_content_zi{
              @include size(155px,40px);
              margin-left: 40px;
              margin-top: -22px;
              font-size: 18px;
              color:#fff;
              text-align: left;
              line-height:36px;
            }
          }
        }
      }
      &1_leftSwitch{
        @include size(20px,101px);
        position: absolute;
        top:142px;
        left:0px;
        cursor: pointer;
        user-select: none;
        img{
          display: block;
          @include size(9px,15px);
          position: absolute;
          left:7px;
          top:43px;
        }
      }
      &1_rightSwitch{
        @include size(20px,101px);
        position: absolute;
        top:142px;
        right:0px;
        cursor: pointer;
        user-select: none;
        img{
          display: block;
          @include size(9px,15px);
          position: absolute;
          right:7px;
          top:43px;
        }
      }
    }
  }
  &_content_bgLeftSwitch{
    @include size(150px,75px);
    position: absolute;
    bottom:0;
    right:271px;
    cursor: pointer;
    user-select: none;
    img{
      display: block;
      @include size(27px,44px);
      position: absolute;
      bottom:18px;
      left:75px;
    }
  }
  &_content_bgRightSwitch{
    @include size(150px,75px);
    position: absolute;
    right:46px;
    bottom:0px;
    cursor: pointer;
    user-select: none;
    img{
      display: block;
      @include size(27px,44px);
      position: absolute;
      bottom:18px;
      left:75px;
    }
  }
}
</style>
