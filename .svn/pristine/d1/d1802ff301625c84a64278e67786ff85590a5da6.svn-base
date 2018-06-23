<template>
  <div class="trajectoryInfoPopup clearfix">
    <popupframe @close="close">
      <!-- 头部 -->
      <div class="trajectoryInfoPopup_title">
        轨迹信息
        <div class="trajectoryInfoPopup_title_lineToplf"></div>
        <div class="trajectoryInfoPopup_title_lineToprt"></div>
        <div class="trajectoryInfoPopup_title_linebtlf"></div>
        <div class="trajectoryInfoPopup_title_linebtrt"></div>
      </div>
      <!-- 选择项 -->
      <div class="trajectoryInfoPopup_select">
        <div class="trajectoryInfoPopup_select_com fl">
          <el-date-picker v-model="value4"
                          type="datetimerange"
                          range-separator="至"
                          start-placeholder="开始日期"
                          end-placeholder="结束日期">
          </el-date-picker>
        </div>
        <div class="trajectoryInfoPopup_select_speed fl">
          <div class="trajectoryInfoPopup_select_speed_title">自定义速度</div>
          <div class="trajectoryInfoPopup_select_speed_sel">
            <el-select v-model="value"
                       placeholder="请选择">
              <el-option v-for="item in speedOptions"
                         :key="item.value"
                         :label="item.label"
                         :value="item.value">
              </el-option>
            </el-select>
          </div>
        </div>
      </div>
      <!-- 各项内容 -->
      <div class="trajectoryInfoPopup_trajectoryDetails">
        <div class="trajectoryInfoPopup_trajectoryDetails_item fl">
          <div class="trajectoryInfoPopup_trajectoryDetails_item_title fl">起点-终点</div>
          <div class="trajectoryInfoPopup_trajectoryDetails_item_content fl">
            <div class="trajectoryInfoPopup_trajectoryDetails_item_content_rotateBox fl"></div>
            <div class="trajectoryInfoPopup_trajectoryDetails_item_content_text fl">{{trajectory.lineName}}</div>
          </div>
        </div>
        <div class="trajectoryInfoPopup_trajectoryDetails_item fl">
          <div class="trajectoryInfoPopup_trajectoryDetails_item_title fl">停车时间</div>
          <div class="trajectoryInfoPopup_trajectoryDetails_item_content fl">
            <div class="trajectoryInfoPopup_trajectoryDetails_item_content_rotateBox fl"></div>
            <div class="trajectoryInfoPopup_trajectoryDetails_item_content_text fl">{{trajectory.stopDate}}</div>
          </div>
        </div>
        <div class="trajectoryInfoPopup_trajectoryDetails_item fl">
          <div class="trajectoryInfoPopup_trajectoryDetails_item_title fl">停车位置</div>
          <div class="trajectoryInfoPopup_trajectoryDetails_item_content fl">
            <div class="trajectoryInfoPopup_trajectoryDetails_item_content_rotateBox fl"></div>
            <div class="trajectoryInfoPopup_trajectoryDetails_item_content_text fl">{{trajectory.stopPosition}}</div>
          </div>
        </div>
        <div class="trajectoryInfoPopup_trajectoryDetails_item fl">
          <div class="trajectoryInfoPopup_trajectoryDetails_item_title fl">车辆异常数据</div>
          <div class="trajectoryInfoPopup_trajectoryDetails_item_content fl">
            <div class="trajectoryInfoPopup_trajectoryDetails_item_content_rotateBox fl"></div>
            <div class="trajectoryInfoPopup_trajectoryDetails_item_content_text fl">{{trajectory.abnormalData}}</div>
          </div>
        </div>
      </div>
      <!-- 导出按钮 -->
      <div class="trajectoryInfoPopup_btnExport">
        <span @click="startPlay">播放轨迹</span>
        <span>导出</span>
      </div>
    </popupframe>
  </div>
</template>

<script>
import { mapMutations } from 'vuex'
import Popupframe from '../../containers/index/popupframe'

export default {
  name: 'trajectoryInfoPopup',
  components: {
    Popupframe,
  },
  data() {
    return {
      speedOptions: [
        {
          value: '选项1',
          label: '10倍速度',
        },
        {
          value: '选项2',
          label: '20倍速度',
        },
        {
          value: '选项3',
          label: '50倍速度',
        },
      ], // 速度选择：选择条件
      value: '', // // 速度选择：显示条件
      trajectory: {// 轨迹信息
        lineName: '延庆-望京',
        stopDate: '2018-05-17 12:30',
        stopPosition: '霍营',
        abnormalData: '无',
      },
      value4: '',
    }
  },
  methods: {
    ...mapMutations('index', ['getTrajectoryShow', 'startPlayPath']),
    close() {
      this.getTrajectoryShow(false)
    },
    startPlay() {
      const arg = {
        startAddress: '延庆',
        endAddress: '望京A',
        play: 'start',
      }
      this.startPlayPath(arg)
    },
  },
  mounted() {},
}
</script>
<style lang="scss" scoped>
.trajectoryInfoPopup {
  width: 100%;
  height: 100%;
  &_title {
    width: 710px;
    height: 28px;
    line-height: 26px;
    border-top: 1px solid rgba(128, 217, 228, 0.5);
    border-bottom: 1px solid rgba(128, 217, 228, 0.5);
    box-sizing: border-box;
    position: relative;
    margin: 20px auto;
    color: #fff;
    text-indent: 30px;
    &_lineToprt {
      width: 20px;
      height: 1px;
      background: #81d9e5;
      position: absolute;
      top: -1px;
      left: 0;
    }
    &_lineToplf {
      width: 20px;
      height: 1px;
      background: #81d9e5;
      position: absolute;
      top: -1px;
      right: 0;
    }
    &_linebtlf {
      width: 20px;
      height: 1px;
      background: #81d9e5;
      position: absolute;
      bottom: -1px;
      left: 0;
    }
    &_linebtrt {
      width: 20px;
      height: 1px;
      background: #81d9e5;
      position: absolute;
      bottom: -1px;
      right: 0;
    }
  }
  &_select {
    width: 710px;
    height: 53px;
    line-height: 53px;
    margin: 22px auto;
    &_com {
      width: 502px;
      height: 53px;
    }
    &_speed {
      width: 208px;
      height: 53px;
      &_title {
        width: 100%;
        height: 26.5px;
        line-height: 26.5px;
        text-align: center;
        font-size: 14px;
        color: #b5b5b5;
      }
      &_sel {
        width: 100%;
        height: 26.5px;
        line-height: 26.5px;
        font-size: 14px;
      }
    }
  }
  &_trajectoryDetails {
    width: 710px;
    height: 70px;
    &_item {
      width: 348px;
      height: 50px;
      &_title {
        width: 108px;
        height: 30px;
        line-height: 30px;
        color: #89dddf;
        font-size: 14px;
        text-align: center;
      }
      &_content {
        width: 240px;
        height: 30px;
        border: 1px solid #81d9e5;
        box-sizing: border-box;
        &_rotateBox {
          width: 10px;
          height: 10px;
          background: #05d0eb;
          transform: rotate(45deg);
          margin: 8px 10px 0 10px;
        }
        &_text {
          width: 200px;
          height: 28px;
          line-height: 28px;
          color: #fff;
          font-size: 14px;
        }
      }
    }
  }
  &_btnExport {
    position: absolute;
    right:10px;
    bottom:10px;
    span{
      display: inline-block;
      padding: 0 30px;
      height: 42px;
      line-height: 42px;
      text-align: center;
      color:#89DDDF;
      font-size:24px;
      background: rgba(3, 139, 252, 0.4);
      cursor: pointer;
    }
  }
  &_btnExport:hover{
    color:#fff;
    box-shadow: 0 0 1px rgba(3, 139, 252, 0.4);
  }
}
</style>

