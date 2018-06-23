<template>
  <div class="terminalConfiguration">
    <div class="terminalConfiguration-line"></div>
    <div class="terminalConfiguration-title">
      终端配置信息
    </div>
    <div class="terminalConfiguration-content">
      <div class="terminalSafe terminalBox"
           @click="showBox(1)"
           :class="{disabledStyle:!safeData,box_on:nowIndex===1}">主动安全设备</div>
      <div class="terminalLocate terminalBox"
           @click="showBox(2)"
           :class="{disabledStyle:!loacateData,box_on:nowIndex===2}">卫星定位设备</div>
      <div class="terminalVideo terminalBox"
           @click="showBox(3)"
           disabled="disabled:videoData"
           :class="{disabledStyle:!videoData,box_on:nowIndex===3}">视频终端</div>
      <div class="goodDetects terminalBox"
           @click="showBox(4)"
           disabled="disabled:goodDetectsData"
           :class="{disabledStyle:!goodDetectsData,box_on:nowIndex===4}">货物监测设备</div>
      <div class="statusDetects terminalBox"
           @click="showBox(5)"
           disabled="disabled:statusDetectsData"
           :class="{disabledStyle:!statusDetectsData,box_on:nowIndex===5}">车辆状况监测设备</div>
      <div class="tirePressureDetects terminalBox"
           @click="showBox(6)"
           disabled="disabled:tireDetectsData"
           :class="{disabledStyle:!tireDetectsData,box_on:nowIndex===6}">胎压监测设备</div>
    </div>
    <div class="rotateCircle"
         :style="{transform:'rotate('+AngleParameter+'deg)'}">
      <div></div>
    </div>
    <!-- 弹出框信息 -->
    <!-- 弹出：车辆主动安全设施 -->
    <div class="popUpBoxMsgWrap position_1"
         v-if="nowIndex===1&&safeData"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-box title="主动安全设备"
                  :isItOnline="safeData.terminal_state"
                  @close='close(0)'>
        <!-- 插槽内容 -->
        <div class="popUpBoxContent"
             slot="popUpBoxContent">
          <div class="itemWrap">
            <div class="subTitle">终端类型</div>
            <div class="content">主动安全设备
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap clearMarginRight">
            <div class="subTitle">终端厂家</div>
            <div class="content"
                 v-if="safeData">{{safeData.manufacturer ||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap">
            <div class="subTitle">终端品牌</div>
            <div class="content"
                 v-if="safeData">{{safeData.terminal_brand||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap clearMarginRight">
            <div class="subTitle">终端型号</div>
            <div class="content"
                 v-if="safeData">{{safeData.terminal_model||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap">
            <div class="subTitle">设备数量</div>
            <div class="content"
                 v-if="safeData">{{safeData.terminal_quantity||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap clearMarginRight">
            <div class="subTitle">终端安装日期</div>
            <div class="content"
                 v-if="safeData">{{safeData.install_date||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap">
            <div class="subTitle">未处理报警数</div>
            <div class="content"
                 v-if="safeData">{{safeData.unhandled_alert_count||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap clearMarginRight">
            <div class="subTitle">终端质保期</div>
            <div class="content"
                 :class="changeAlertColor1"
                 v-if="safeData">{{safeData.warranty_period||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
        </div>
      </pop-up-box>
    </div>
    <!-- 弹出：卫星定位设备 -->
    <div class="popUpBoxMsgWrap position_2"
         v-if="nowIndex===2&&loacateData"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-box title="卫星定位设备"
                  :isItOnline="loacateData.terminal_state"
                  @close='close(0)'>
        <div class="popUpBoxContent"
             slot="popUpBoxContent">
          <div class="itemWrap">
            <div class="subTitle">终端类型</div>
            <div class="content">卫星定位设备
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap clearMarginRight">
            <div class="subTitle">终端厂家</div>
            <div class="content"
                 v-if="loacateData">{{loacateData.manufacturer||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap">
            <div class="subTitle">终端品牌</div>
            <div class="content"
                 v-if="loacateData">{{loacateData.terminal_brand||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap clearMarginRight">
            <div class="subTitle">终端型号</div>
            <div class="content"
                 v-if="loacateData">{{loacateData.terminal_model||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap">
            <div class="subTitle">设备数量</div>
            <div class="content"
                 v-if="loacateData">{{loacateData.terminal_quantity||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap clearMarginRight">
            <div class="subTitle">终端安装日期</div>
            <div class="content"
                 v-if="loacateData">{{loacateData.install_date||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap">
            <div class="subTitle">终端质保期</div>
            <div class="content"
                 :class="changeAlertColor2"
                 v-if="loacateData">{{loacateData.warranty_period||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap clearMarginRight  vehiclePositioning">
            <div class="content"
                 @click="vehiclePosiPop">车辆定位</div>
          </div>
        </div>
      </pop-up-box>
    </div>
    <!-- 弹出：视频终端 -->
    <div class="popUpBoxMsgWrap position_3"
         v-if="nowIndex===3&&videoData"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-box title="视频终端"
                  :isItOnline="videoData.terminal_state"
                  @close='close(0)'>
        <div class="popUpBoxContent"
             slot="popUpBoxContent">
          <div class="itemWrap">
            <div class="subTitle">终端类型</div>
            <div class="content">
              视频终端
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap clearMarginRight">
            <div class="subTitle">终端厂家</div>
            <div class="content"
                 v-if="videoData">{{videoData.manufacturer||''}}
              <!-- 小明卫星定位有限公司 -->
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap">
            <div class="subTitle">终端品牌</div>
            <div class="content"
                 v-if="videoData">{{videoData.terminal_brand||''}}
              <!-- 米其林 -->
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap clearMarginRight">
            <div class="subTitle">终端型号</div>
            <div class="content"
                 v-if="videoData">{{videoData.terminal_model||''}}
              <!-- 型号001 -->
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap">
            <div class="subTitle">设备数量</div>
            <div class="content"
                 v-if="videoData">{{videoData.terminal_quantity||''}}
              <!-- 25 -->
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap clearMarginRight">
            <div class="subTitle">终端安装日期</div>
            <div class="content"
                 v-if="videoData">{{videoData.install_date||''}}
              <!-- 2027-10-25 -->
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap">
            <div class="subTitle">终端质保期</div>
            <div class="content"
                 :class="changeAlertColor3"
                 v-if="videoData">{{videoData.warranty_period||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap clearMarginRight  videoCall">
            <div class="content"
                 @click="videoCallPop">视频调用</div>
          </div>

        </div>
      </pop-up-box>
    </div>
    <!-- 弹出：货物检测设备 -->
    <div v-if="nowIndex===4 &&goodDetectsData"
         class="popUpBoxMsgWrap position_4"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-box title="货物监测设备"
                  :isItOnline="goodDetectsData.device_info.terminal_state"
                  @close='close(0)'>
        <div class="popUpBoxContent"
             slot="popUpBoxContent">
          <div class="btnWrap clearfix">
            <div class="title"
                 :class="{box_off:MonitoringDetailsShow}"
                 @click="getMonitoringType">检测类型</div>
            <div class="title"
                 :class="{box_off:!MonitoringDetailsShow}"
                 @click="getEquipmentInformation">设备信息</div>
          </div>
          <div class="detailWrap"
               v-if="MonitoringDetailsShow">
            <ul>
              <li>
                <div class="itemWrap">
                  <div class="subTitle">罐体阀门监测</div>
                  <div class="content"
                       v-if="goodDetectsData">{{goodDetectsData.detects_type.tank_valve_testing||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
                <div class="itemWrap  clearMarginRight">
                  <div class="subTitle">油压泵</div>
                  <div class="content"
                       v-if="goodDetectsData">{{goodDetectsData.detects_type.oil_pressure_pump||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
              </li>
              <li>
                <div class="itemWrap">
                  <div class="subTitle">温度检测器</div>
                  <div class="content"
                       v-if="goodDetectsData">{{goodDetectsData.detects_type.temperature_sensor||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
                <div class="itemWrap  clearMarginRight">
                  <div class="subTitle">气压检测器</div>
                  <div class="content"
                       v-if="goodDetectsData">{{goodDetectsData.detects_type.pressure_detector||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
              </li>
              <li>
                <div class="itemWrap">
                  <div class="subTitle">液压检测器</div>
                  <div class="content"
                       v-if="goodDetectsData">{{goodDetectsData.detects_type.hydraulic_test_device||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
                <div class="itemWrap  clearMarginRight">
                  <div class="subTitle">湿度检测器</div>
                  <div class="content"
                       v-if="goodDetectsData">{{goodDetectsData.detects_type.moisture_detector||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
              </li>
              <li>
                <div class="itemWrap">
                  <div class="subTitle">罐体液位检测器</div>
                  <div class="content"
                       v-if="goodDetectsData">{{goodDetectsData.detects_type.tank_hydraulic_detector||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
              </li>
            </ul>

          </div>
          <div class="detailWrap"
               v-if="!MonitoringDetailsShow">
            <ul>
              <li>
                <div class="itemWrap">
                  <div class="subTitle">终端类型</div>
                  <div class="content">货物监测设备
                    <div class="rotateBox"></div>
                  </div>
                </div>
                <div class="itemWrap  clearMarginRight">
                  <div class="subTitle">终端厂家</div>
                  <div class="content"
                       v-if="goodDetectsData">{{goodDetectsData.device_info.manufacturer||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
              </li>
              <li>
                <div class="itemWrap">
                  <div class="subTitle">终端品牌</div>
                  <div class="content"
                       v-if="goodDetectsData">{{goodDetectsData.device_info.terminal_brand||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
                <div class="itemWrap  clearMarginRight">
                  <div class="subTitle">终端型号</div>
                  <div class="content"
                       v-if="goodDetectsData">{{goodDetectsData.device_info.terminal_model||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
              </li>
              <li>
                <div class="itemWrap">
                  <div class="subTitle">设备数量</div>
                  <div class="content"
                       v-if="goodDetectsData">{{goodDetectsData.device_info.terminal_quantity||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
                <div class="itemWrap  clearMarginRight">
                  <div class="subTitle">终端安装日期</div>
                  <div class="content"
                       v-if="goodDetectsData">{{goodDetectsData.device_info.install_date||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
              </li>
              <li>
                <div class="itemWrap">
                  <div class="subTitle">终端质保期</div>
                  <div class="content"
                       :class="changeAlertColor4"
                       v-if="goodDetectsData">{{goodDetectsData.device_info.warranty_period||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
                <div class="itemWrap  clearMarginRight">
                  <div class="subTitle">液位</div>
                  <div class="content"
                       v-if="goodDetectsData">{{goodDetectsData.device_info.moisture_detector||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
              </li>
              <li>
                <div class="itemWrap">
                  <div class="subTitle">压力</div>
                  <div class="content"
                       v-if="goodDetectsData">{{goodDetectsData.device_info.pressure||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
                <div class="itemWrap  clearMarginRight">
                  <div class="subTitle">温度</div>
                  <div class="content"
                       v-if="goodDetectsData">{{goodDetectsData.device_info.temperature||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
              </li>
            </ul>
          </div>

        </div>
      </pop-up-box>
    </div>
    <!-- 弹出：车辆状况检测设备 -->
    <div class="popUpBoxMsgWrap position_5"
         v-if="nowIndex===5&&statusDetectsData"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-box title="车辆状况监测设备"
                  :isItOnline="statusDetectsData.terminal_state || ''"
                  @close='close(0)'>
        <div class="popUpBoxContent"
             slot="popUpBoxContent">
          <div class="itemWrap">
            <div class="subTitle">终端类型</div>
            <div class="content">
              车辆状况监测设备
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap clearMarginRight">
            <div class="subTitle">终端厂家</div>
            <div class="content"
                 v-if="statusDetectsData">{{statusDetectsData.manufacturer||''}}
              <!-- 小明卫星定位有限公司 -->
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap">
            <div class="subTitle">终端品牌</div>
            <div class="content"
                 v-if="statusDetectsData">{{statusDetectsData.terminal_brand||''}}
              <!-- 米其林 -->
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap clearMarginRight">
            <div class="subTitle">终端型号</div>
            <div class="content"
                 v-if="statusDetectsData">{{statusDetectsData.terminal_model||''}}
              <!-- 型号001 -->
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap">
            <div class="subTitle">设备数量</div>
            <div class="content"
                 v-if="statusDetectsData">{{statusDetectsData.terminal_quantity||''}}
              <!-- 25 -->
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap clearMarginRight">
            <div class="subTitle">终端安装日期</div>
            <div class="content"
                 v-if="statusDetectsData">{{statusDetectsData.install_date||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap">
            <div class="subTitle">终端质保期</div>
            <div class="content"
                 :class="changeAlertColor5"
                 v-if="statusDetectsData">{{statusDetectsData.warranty_period||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
          <div class="itemWrap  clearMarginRight">
            <div class="subTitle">车辆异常信息</div>
            <div class="content"
                 v-if="statusDetectsData">{{statusDetectsData.car_abnormal_info||''}}
              <div class="rotateBox"></div>
            </div>
          </div>
        </div>
      </pop-up-box>
    </div>

    <!-- 弹出：胎压检测设备 -->
    <div v-if="nowIndex===6&&tireDetectsData"
         class="popUpBoxMsgWrap position_6"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-box title="胎压监测设备"
                  :isItOnline="tireDetectsData.terminal_state || ''"
                  @close='close(0)'>
        <div class="popUpBoxContent"
             slot="popUpBoxContent">
          <!-- ********************** -->
          <div class="btnWrap clearfix">
            <div class="title"
                 :class="{box_off:MonitoringDetailsShow}"
                 @click="getMonitoringType">设备信息</div>
            <div class="title"
                 :class="{box_off:!MonitoringDetailsShow}"
                 @click="getEquipmentInformation">胎压信息</div>
          </div>
          <div class="detailWrap"
               v-if="MonitoringDetailsShow">
            <ul>
              <li>
                <div class="itemWrap">
                  <div class="subTitle">终端类型</div>
                  <div class="content">胎压检测设备
                    <div class="rotateBox"></div>
                  </div>
                </div>
                <div class="itemWrap  clearMarginRight">
                  <div class="subTitle">终端厂家</div>
                  <div class="content"
                       v-if="tireDetectsData">{{tireDetectsData.device_info.manufacturer||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
              </li>
              <li>
                <div class="itemWrap">
                  <div class="subTitle">终端品牌</div>
                  <div class="content"
                       v-if="tireDetectsData">{{tireDetectsData.device_info.terminal_brand||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
                <div class="itemWrap  clearMarginRight">
                  <div class="subTitle">终端型号</div>
                  <div class="content"
                       v-if="tireDetectsData">{{tireDetectsData.device_info.terminal_model||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
              </li>
              <li>
                <div class="itemWrap">
                  <div class="subTitle">设备数量</div>
                  <div class="content"
                       v-if="tireDetectsData">{{tireDetectsData.device_info.terminal_quantity||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
                <div class="itemWrap  clearMarginRight">
                  <div class="subTitle">终端安装日期</div>
                  <div class="content"
                       v-if="tireDetectsData">{{tireDetectsData.device_info.install_date||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
              </li>
              <li>
                <div class="itemWrap">
                  <div class="subTitle">终端质保期</div>
                  <div class="content"
                       :class="changeAlertColor6"
                       v-if="tireDetectsData">{{tireDetectsData.device_info.warranty_period||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
              </li>
            </ul>

          </div>
          <div class="detailWrap"
               v-if="!MonitoringDetailsShow">
            <ul v-if="tireDetectsData">
              <li v-for="(item,index) in tireDetectsData.tire_pressure_info"
                  :key="index">
                <div class="itemWrap">
                  <div class="subTitle">轮胎位置</div>
                  <div class="content">{{item.tire_position||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
                <div class="itemWrap  clearMarginRight">
                  <div class="subTitle">胎压</div>
                  <div class="content">{{item.tire_pressure||''}}
                    <div class="rotateBox"></div>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </pop-up-box>
    </div>
    <div v-show='false'>{{getTerminalInfo}}</div>
    <!-- <div v-show='false'>{{changeAlertColor}}</div> -->
    <!-- 视频弹出二级弹窗 -->
    <div class="videoCallPopWrap clearfix"
         v-if="videoCallPopShow"
         v-drag
         @mousedown="move=true"
         @mouseup="move=false"
         :style="move?'cursor:move':''">
      <pop-up-box title="视频展示"
                  @close='closepop()'>
        <div class="popUpBoxContent"
             slot="popUpBoxContent">
          <div class="rect1 clearfix">
            <div class="rectImg clearfix">

            </div>
            <div class="rectTit clearfix">车内1</div>
          </div>
          <div class="rect2  clearfix">
            <div class="rectImg  clearfix">

            </div>
            <div class="rectTit  clearfix">车内2</div>
          </div>
          <div class="rect3  clearfix">
            <div class="rectImg  clearfix">

            </div>
            <div class="rectTit  clearfix">车内3</div>
          </div>
          <div class="rect4  clearfix">
            <div class="rectImg  clearfix">

            </div>
            <div class="rectTit  clearfix">车外1</div>
          </div>
          <div class="rect5  clearfix">
            <div class="rectImg  clearfix">

            </div>
            <div class="rectTit  clearfix">车外2</div>
          </div>
          <div class="rect6  clearfix">
            <div class="rectImg  clearfix">

            </div>
            <div class="rectTit clearfix">车外3</div>
          </div>
        </div>

      </pop-up-box>
    </div>
  </div>
</template>

<script>
/* eslint-disable */
// import _ from 'lodash'
import { mapState, mapMutations,mapActions } from "vuex";
import popUpBox from "@/components/car/PopUpBox";

export default {
  name: "terminal-configuration",
  components: {
    popUpBox
  },
  props: ["czzdxxData"],
  data() {
    return {
      nowIndex: 0,
      AngleParameter: 0,
      // 确认每个按钮弹窗数据
      safeData: null,
      loacateData: null,
      videoData: null,
      goodDetectsData: null,
      statusDetectsData: null,
      tireDetectsData: null,
      move: false,
      MonitoringDetailsShow: true,
      warranty_period: "",
      videoCallPopShow: false
    };
  },
  computed: {
    ...mapState("carModelsSearchContainer", ["vehicle_id"]),
    // 小于3月状态改变
    // 车辆主动安全设施
    changeAlertColor1() {
      if (
        this.czzdxxData &&
        this.czzdxxData !== undefined &&
        this.czzdxxData !== null
      ) {
        let difDate = "";
        let timestamp = "";

        const one_month = 30 * 24 * 60 * 60 * 1000;
        const three_month = 30 * 24 * 60 * 60 * 1000 * 3;

        if (
          this.czzdxxData.active_safety_devices &&
          this.czzdxxData.active_safety_devices.warranty_period
        ) {
          this.warranty_period = this.czzdxxData.active_safety_devices.warranty_period;
          timestamp = new Date(this.warranty_period).getTime(); // 毫秒值
          const nowDate = new Date(); // 毫秒值
          difDate = Number(timestamp - nowDate);
          if (difDate >= 0) {
            if (difDate < one_month) {
              return "box_red";
            } else if (difDate < three_month) {
              return "box_yellow";
            }
            return "box_green";
          }
          return "box_green";
        }
      }
      return "box_green";
    },
    // 卫星定位设备
    changeAlertColor2() {
      if (
        this.czzdxxData &&
        this.czzdxxData !== undefined &&
        this.czzdxxData !== null
      ) {
        // 1
        // const difDate = ''
        let difDate = "";
        let timestamp = "";

        const one_month = 30 * 24 * 60 * 60 * 1000;
        const three_month = 30 * 24 * 60 * 60 * 1000 * 3;

        // 2
        if (
          this.czzdxxData.GPS_GNSS &&
          this.czzdxxData.GPS_GNSS.warranty_period
        ) {
          this.warranty_period = this.czzdxxData.GPS_GNSS.warranty_period;
          timestamp = new Date(this.warranty_period).getTime(); // 毫秒值
          const nowDate = new Date(); // 毫秒值
          difDate = Number(timestamp - nowDate);
          if (difDate >= 0) {
            if (difDate < one_month) {
              return "box_red";
            } else if (difDate < three_month) {
              return "box_yellow";
            }
            return "box_green";
          }
          return "box_green";
        }
      }
      return "box_green";
    },
    // 视频终端
    changeAlertColor3() {
      if (
        this.czzdxxData &&
        this.czzdxxData !== undefined &&
        this.czzdxxData !== null
      ) {
        // 1
        // const difDate = ''
        let difDate = "";
        let timestamp = "";

        const one_month = 30 * 24 * 60 * 60 * 1000;
        const three_month = 30 * 24 * 60 * 60 * 1000 * 3;

        // 3
        if (
          this.czzdxxData.video_terminal &&
          this.czzdxxData.video_terminal.warranty_period
        ) {
          this.warranty_period = this.czzdxxData.video_terminal.warranty_period;
          timestamp = new Date(this.warranty_period).getTime(); // 毫秒值
          const nowDate = new Date(); // 毫秒值
          difDate = Number(timestamp - nowDate);
          if (difDate >= 0) {
            if (difDate < one_month) {
              return "box_red";
            } else if (difDate < three_month) {
              return "box_yellow";
            }
            return "box_green";
          }
          return "box_green";
        }
      }
      return "box_green";
    },
    // 货物监测设备
    changeAlertColor4() {
      if (
        this.czzdxxData &&
        this.czzdxxData !== undefined &&
        this.czzdxxData !== null
      ) {
        let difDate = "";
        let timestamp = "";

        const one_month = 30 * 24 * 60 * 60 * 1000;
        const three_month = 30 * 24 * 60 * 60 * 1000 * 3;

        if (
          this.czzdxxData.goods_detects &&
          this.czzdxxData.goods_detects.device_info &&
          this.czzdxxData.goods_detects.device_info.warranty_period
        ) {
          this.warranty_period = this.czzdxxData.goods_detects.device_info.warranty_period;
          timestamp = new Date(this.warranty_period).getTime(); // 毫秒
          const nowDate = new Date(); // 毫秒值
          difDate = Number(timestamp - nowDate);
          if (difDate >= 0) {
            if (difDate < one_month) {
              return "box_red";
            } else if (difDate < three_month) {
              return "box_yellow";
            }
            return "box_green";
          }
          return "box_green";
        }
      }
      return "box_green";
    },
    // 车辆状况检测设备
    changeAlertColor5() {
      if (
        this.czzdxxData &&
        this.czzdxxData !== undefined &&
        this.czzdxxData !== null
      ) {
        // 1
        // const difDate = ''
        let difDate = "";
        let timestamp = "";

        const one_month = 30 * 24 * 60 * 60 * 1000;
        const three_month = 30 * 24 * 60 * 60 * 1000 * 3;

        // 5
        if (
          this.czzdxxData.car_status_detects &&
          this.czzdxxData.car_status_detects.warranty_period
        ) {
          this.warranty_period = this.czzdxxData.car_status_detects.warranty_period;
          timestamp = new Date(this.warranty_period).getTime(); // 毫秒值
          const nowDate = new Date(); // 毫秒值
          difDate = Number(timestamp - nowDate);
          if (difDate >= 0) {
            if (difDate < one_month) {
              return "box_red";
            } else if (difDate < three_month) {
              return "box_yellow";
            }
            return "box_green";
          }
          return "box_green";
        }
      }
      return "box_green";
    },
    // 胎压检测设备
    changeAlertColor6() {
      if (
        this.czzdxxData &&
        this.czzdxxData !== undefined &&
        this.czzdxxData !== null
      ) {
        let difDate = "";
        let timestamp = "";

        const one_month = 30 * 24 * 60 * 60 * 1000;
        const three_month = 30 * 24 * 60 * 60 * 1000 * 3;

        if (
          this.czzdxxData.tire_detects &&
          this.czzdxxData.tire_detects.device_info &&
          this.czzdxxData.tire_detects.device_info.warranty_period
        ) {
          this.warranty_period = this.czzdxxData.tire_detects.device_info.warranty_period;
          timestamp = new Date(this.warranty_period).getTime(); // 毫秒值
          const nowDate = new Date(); // 毫秒值
          difDate = Number(timestamp - nowDate);
          if (difDate >= 0) {
            if (difDate < one_month) {
              return "box_red";
            } else if (difDate < three_month) {
              return "box_yellow";
            }
            return "box_green";
          }
          return "box_green";
        }
      }
      return "box_green";
    },
    getTerminalInfo() {
      if (this.czzdxxData) {
        this.safeData = this.czzdxxData.active_safety_devices;
        this.loacateData = this.czzdxxData.GPS_GNSS;
        this.videoData = this.czzdxxData.video_terminal;
        this.goodDetectsData = this.czzdxxData.goods_detects;
        this.statusDetectsData = this.czzdxxData.car_status_detects;
        this.tireDetectsData = this.czzdxxData.tire_detects;
        return true;
      }
      return null;
    }
  },
  methods: {
    ...mapMutations("CarRealtimeMap", ["setShowRealtimeMap"]),
    ...mapActions('CarRealtimeMap',['getCarLocationInfo']),
    closepop() {
      this.videoCallPopShow = false;
    },
    showBox(i) {
      if (this.nowIndex === i) {
        this.nowIndex = 0;
      } else {
        this.nowIndex = i;
        if (i === 1) {
          // 车辆主动安全设施
          this.AngleParameter = 0;
          // this.selectedBox = 1
        } else if (i === 2) {
          // 卫星定位设备
          this.AngleParameter = 60;
          // this.selectedBox = 0
        } else if (i === 3) {
          // 视频终端
          this.AngleParameter = 95;
          // this.selectedBox = 3
        } else if (i === 4) {
          // 货物检测设备
          this.AngleParameter = 140;
          // this.selectedBox = 4
        } else if (i === 5) {
          // 车辆状况检测设备
          this.AngleParameter = 230;
          // this.selectedBox = 5
        } else if (i === 6) {
          // 胎压检测设备
          this.AngleParameter = 300;
          // this.selectedBox = 2
        }
      }
    },
    close(index) {
      this.nowIndex = index;
      this.setShowRealtimeMap(false);
    },
    getMonitoringType() {
      this.MonitoringDetailsShow = true;
    },
    getEquipmentInformation() {
      this.MonitoringDetailsShow = false;
    },
    videoCallPop() {
      this.videoCallPopShow = true;
    },
    vehiclePosiPop() {
      const arg={
        vehicle_id:this.vehicle_id
      }
      this.getCarLocationInfo(arg);
    }
  }
};
</script>

<style lang="scss" scope>
.clearfix {
  &:before,
  &:after {
    content: "";
    display: table;
  }
  &:after {
    clear: both;
    overflow: hidden;
  }
}
@mixin size($width, $height) {
  width: $width;
  height: $height;
}
.terminalConfiguration {
  @include size(100%, 100%);
  position: relative;
  .terminalConfiguration-title {
    @include size(100%, 30px);
    position: relative;
    color: #89dddf;
    font-size: 18px;
    font-weight: bold;
    line-height: 30px;
    padding-left: 50px;
    box-sizing: border-box;
    background: url(~assets/car/left_header_strip_1.png) no-repeat;
  }
  .terminalConfiguration-line {
    width: 349px;
    height: 2px;
    margin-left: 19px;
    margin-bottom: 15px;
    background: #478294;
  }
  .terminalConfiguration-content {
    @include size(368px, 150px);
    background: url(~assets/car/left_icons_circle.png) no-repeat center center;
    background-size: 101px 101px;
    background-position: 57% 32%;
    position: relative;
    .terminalBox {
      @include size(120px, 23.5px);
      line-height: 23.5px;
      color: #b5b5b5;
      font-size: 12px;
      text-align: center;
      border: 1px solid #00bfe5;
      background: rgba(0, 191, 229, 0.2);
      box-sizing: border-box;
      cursor: pointer;
    }
    .terminalBox:hover {
      color: #fff;
    }
    .terminalSafe {
      position: absolute;
      top: 14px;
      left: 30px;
      z-index: 3;
    }
    .terminalLocate {
      width: 105px;
      position: absolute;
      top: 55px;
      right: 0px;
      z-index: 3;
    }
    .terminalVideo {
      position: absolute;
      top: 14px;
      right: 0px;
      z-index: 3;
    }
    .goodDetects {
      width: 120px;
      position: absolute;
      bottom: 28px;
      right: 0px;
      z-index: 3;
    }
    .statusDetects {
      width: 120px;
      position: absolute;
      left: 30px;
      bottom: 30px;
      z-index: 3;
    }
    .tirePressureDetects {
      position: absolute;
      top: 54px;
      left: 30px;
      z-index: 3;
    }
    .terminalNothing {
      background: rgba(181, 181, 181, 0.4);
    }
    .box_on {
      background: rgba(0, 191, 229, 0.5);
      // box-shadow: 0px 0px 1px #00bfe5;
      color: #fff;
    }
    .disabledStyle {
      color: #b5b5b5;
      background: rgba(181, 181, 181, 0.4);
      border: none;
    }
    .badEQStyle {
      color: #b5b5b5;
      background: rgba(226, 212, 7, 0.5);
      border: none;
    }
  }
  .rotateCircle {
    @include size(101px, 101px);
    position: absolute;
    top: 60px;
    left: 150px;
    transform: rotate(90deg);
    transition: all 0.2s ease-out;
    -moz-transition: all 0.2s ease-out; /* Firefox 4 */
    -webkit-transition: all 0.2s ease-out; /* Safari 和 Chrome */
    -o-transition: all 0.2s ease-out; /* Opera */
    div {
      @include size(12px, 12px);
      position: absolute;
      top: 10px;
      left: 59px;
      border-radius: 50%;
      background: #00bfe5;
    }
  }
  .popUpBoxMsgWrap {
    @include size(750px, 230px);
    position: absolute;
    top: 100px;
    left: 370px;
    z-index: 21;
    .popUpBoxContent {
      @include size(100%, 100%);
      // margin: 16px;

      position: relative;
      overflow: hidden;

      .itemWrap {
        @include size(350px, 30px);
        line-height: 30px;
        margin-bottom: 10px;
        margin-right: 10px;
        float: left;
        .subTitle {
          @include size(110px, 30px);
          line-height: 30px;
          text-align: left;
          color: #89dddf;
          font-size: 14px;
          float: left;
        }
        .content {
          @include size(240px, 30px);
          line-height: 30px;
          padding-left: 30px;
          color: #fff;
          font-size: 14px;
          font-weight: bold;
          border: 1px solid #89dddf;
          float: left;
          position: relative;
          box-sizing: border-box;
          .rotateBox {
            @include size(7px, 7px);
            position: absolute;
            top: 11px;
            left: 10px;
            transform: rotate(45deg);
            background: #05d0eb;
          }
        }
      }
      .remindRed {
        .content {
          background: rgba(231, 80, 41, 0.4);
          border: 1px solid rgba(231, 80, 41, 1);
          .rotateBox {
            background: rgba(231, 80, 41, 1);
          }
        }
      }
      .remindYellow {
        .content {
          background: rgba(255, 185, 46, 0.4);
          border: 1px solid rgba(255, 185, 46, 1);
          .rotateBox {
            background: rgba(255, 185, 46, 1);
          }
        }
      }
      .remindGreen {
        .content {
          background: rgba(5, 208, 235, 0.4);
          border: 1px solid rgba(5, 208, 235, 1);
          .rotateBox {
            background: rgba(5, 208, 235, 1);
          }
        }
      }

      .clearMarginRight {
        margin-right: 0;
      }
    }
  }
  .position_2 {
    position: absolute;
    top: 160px;
    left: 380px;
    .vehiclePositioning {
      cursor: pointer;
      .content {
        width: 240px;
        float: right;
        text-align: center;
        // width: 240px;
        height: 30px;
        line-height: 30px;
        margin-left: 110px;
        background: rgba(5, 208, 235, 0.5) url("../../assets/car/dingwei.png")
          no-repeat 14px 2px;
      }
    }
  }
  .position_3 {
    position: absolute;
    top: 100px;
    left: 390px;
    .videoCall {
      cursor: pointer;
      .content {
        width: 240px;
        float: right;
        text-align: center;
        // width: 240px;
        height: 30px;
        line-height: 30px;
        margin-left: 110px;
        background: rgba(5, 208, 235, 0.5) url("../../assets/car/shipin.png")
          no-repeat 14px 5px;
      }
    }
  }
  .position_4 {
    position: absolute;
    top: 270px;
    left: 526px;
    .popUpBoxContent {
      .btnWrap {
        .title {
          width: 220px;
          height: 30px;
          line-height: 30px;
          background: rgba(5, 208, 235, 0.2);
          border: 1px solid rgba(5, 208, 235, 0.5);
          box-sizing: border-box;
          color: #ffffff;
          float: left;
          margin-left: 170px;
          text-align: center;
          cursor: pointer;
        }
        .title:nth-child(2) {
          margin-left: 10px;
        }
        .box_off {
          background: rgba(5, 208, 235, 0.5);
          border: 1px solid rgba(5, 208, 235, 0.5);
        }
      }
      .detailWrap {
        margin-top: 10px;
        ul {
          height: 120px;
          list-style: none;
          overflow-y: scroll;
          li {
            overflow: hidden;
            .itemWrap {
              @include size(340px, 30px);
              line-height: 30px;
              margin-bottom: 10px;
              margin-right: 10px;
              float: left;
              .subTitle {
                @include size(100px, 30px);
                line-height: 30px;
                text-align: left;
                color: #89dddf;
                font-size: 14px;
                float: left;
              }
              .content {
                @include size(200px, 30px);
                line-height: 30px;
                padding-left: 30px;
                color: #fff;
                font-size: 14px;
                font-weight: bold;
                border: 1px solid #89dddf;
                float: left;
                position: relative;
                box-sizing: border-box;
                .rotateBox {
                  @include size(7px, 7px);
                  position: absolute;
                  top: 11px;
                  left: 10px;
                  transform: rotate(45deg);
                  background: #05d0eb;
                }
              }
            }
          }
        }
        ul::-webkit-scrollbar {
          background: #69a3b1;
          width: 6px;
        }
        ul::-webkit-scrollbar-thumb {
          background: #05d0eb;
        }
      }
    }
  }
  .position_5 {
    position: absolute;
    top: 260px;
    left: 200px;
  }
  .position_6 {
    position: absolute;
    top: 160px;
    left: 190px;
    .popUpBoxContent {
      .btnWrap {
        .title {
          width: 220px;
          height: 30px;
          line-height: 30px;
          background: rgba(5, 208, 235, 0.2);
          border: 1px solid rgba(5, 208, 235, 0.5);
          box-sizing: border-box;
          color: #ffffff;
          float: left;
          margin-left: 170px;
          text-align: center;
          cursor: pointer;
        }
        .title:nth-child(2) {
          margin-left: 10px;
        }
        .box_off {
          background: rgba(5, 208, 235, 0.5);
          border: 1px solid rgba(5, 208, 235, 0.5);
        }
      }
      .detailWrap {
        margin-top: 10px;
        ul {
          height: 120px;
          list-style: none;
          overflow-y: scroll;
          li {
            overflow: hidden;
            .itemWrap {
              @include size(340px, 30px);
              line-height: 30px;
              margin-bottom: 10px;
              margin-right: 10px;
              float: left;
              .subTitle {
                @include size(100px, 30px);
                line-height: 30px;
                text-align: left;
                color: #89dddf;
                font-size: 14px;
                float: left;
              }
              .content {
                @include size(200px, 30px);
                line-height: 30px;
                padding-left: 30px;
                color: #fff;
                font-size: 14px;
                font-weight: bold;
                border: 1px solid #89dddf;
                float: left;
                position: relative;
                box-sizing: border-box;
                .rotateBox {
                  @include size(7px, 7px);
                  position: absolute;
                  top: 11px;
                  left: 10px;
                  transform: rotate(45deg);
                  background: #05d0eb;
                }
              }
            }
          }
        }
        ul::-webkit-scrollbar {
          background: #69a3b1;
          width: 6px;
        }
        ul::-webkit-scrollbar-thumb {
          background: #05d0eb;
        }
      }
    }
  }
  .videoCallPopWrap {
    @include size(773px, 469px);
    position: absolute;
    top: 360px;
    left: 390px;
    z-index: 21;
    .popUpBoxContent {
      @include size(688px, 368px);
      margin: 0 auto;
      margin-top: 50px;
      border: 2px solid #81d9e5;
      box-sizing: border-box;
      overflow: hidden;
      .rect1 {
        width: 224px;
        height: 184px;
        float: left;
        .rectImg {
          width: 202px;
          height: 116px;
          border: 2px solid #81d9e5;
          box-sizing: border-box;
          margin-top: 16px;
          margin-left: 18px;
        }
        .rectTit {
          width: 100px;
          height: 30px;
          line-height: 30px;
          text-align: center;
          color: #fff;
          background: rgba(0, 191, 229, 0.5);
          margin-top: 10px;
          margin-left: 69px;
        }
      }
      .rect2 {
        width: 224px;
        height: 184px;
        float: left;
        .rectImg {
          width: 202px;
          height: 116px;
          border: 2px solid #81d9e5;
          box-sizing: border-box;
          margin-top: 16px;
          margin-left: 18px;
        }
        .rectTit {
          width: 100px;
          height: 30px;
          line-height: 30px;
          text-align: center;
          color: #fff;
          background: rgba(0, 191, 229, 0.5);
          margin-top: 10px;
          margin-left: 69px;
        }
      }
      .rect3 {
        width: 224px;
        height: 184px;
        float: left;
        .rectImg {
          width: 202px;
          height: 116px;
          border: 2px solid #81d9e5;
          box-sizing: border-box;
          margin-top: 16px;
          margin-left: 18px;
        }
        .rectTit {
          width: 100px;
          height: 30px;
          line-height: 30px;
          text-align: center;
          color: #fff;
          background: rgba(0, 191, 229, 0.5);
          margin-top: 10px;
          margin-left: 69px;
        }
      }
      .rect4 {
        width: 224px;
        height: 184px;
        float: left;
        .rectImg {
          width: 202px;
          height: 116px;
          border: 2px solid #81d9e5;
          box-sizing: border-box;
          margin-top: 12px;
          margin-left: 18px;
        }
        .rectTit {
          width: 100px;
          height: 30px;
          line-height: 30px;
          text-align: center;
          color: #fff;
          background: rgba(0, 191, 229, 0.5);
          margin-top: 10px;
          margin-left: 69px;
        }
      }
      .rect5 {
        width: 224px;
        height: 184px;
        float: left;
        .rectImg {
          width: 202px;
          height: 116px;
          border: 2px solid #81d9e5;
          box-sizing: border-box;
          margin-top: 12px;
          margin-left: 18px;
        }
        .rectTit {
          width: 100px;
          height: 30px;
          line-height: 30px;
          text-align: center;
          color: #fff;
          background: rgba(0, 191, 229, 0.5);
          margin-top: 10px;
          margin-left: 69px;
        }
      }
      .rect6 {
        width: 224px;
        height: 184px;
        float: left;
        .rectImg {
          width: 202px;
          height: 116px;
          border: 2px solid #81d9e5;
          box-sizing: border-box;
          margin-top: 12px;
          margin-left: 18px;
        }
        .rectTit {
          width: 100px;
          height: 30px;
          line-height: 30px;
          text-align: center;
          color: #fff;
          background: rgba(0, 191, 229, 0.5);
          margin-top: 10px;
          margin-left: 69px;
        }
      }
    }
  }
  .fade-enter-active,
  .fade-leave-active {
    transition: opacity 0.5s;
  }
  .fade-enter,
  .fade-leave-to {
    opacity: 0;
  }
}
</style>