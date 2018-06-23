<template>
  <div class="driverLineRealtimeAlarmInfoCon">
    <pop-up-widget title="当日实时报警统计"></pop-up-widget>
    
    <div class="content clearfix">
      <!-- <div class="itemCon">
        <div class="title">机构</div>
        <div class="index">{{driverLineRealtimeAlarmInfo.qy_cdxx.entity_name}}</div>
      </div>
      <div class="itemCon">
        <div class="title">车辆ID</div>
        <div class="index">{{driverLineRealtimeAlarmInfo.vehicle_id}}</div>
      </div>
      <div class="itemCon">
        <div class="title">线路ID</div>
        <div class="index">{{driverLineRealtimeAlarmInfo.route_id}}</div>
      </div>
      <div class="itemCon">
        <div class="title">报警类型</div>
        <div class="index">{{driverLineRealtimeAlarmInfo.jssjlx.drive_event_type}}</div>
      </div>
      <div class="itemCon">
        <div class="title">速度</div>
        <div class="index">{{driverLineRealtimeAlarmInfo.speed}}</div>
      </div>
      <div class="itemCon">
        <div class="title">方向</div>
        <div class="index">{{driverLineRealtimeAlarmInfo.direction}}</div>
      </div>
      <div class="itemCon">
        <div class="title">报警时间</div>
        <div class="index">{{driverLineRealtimeAlarmInfo.alarm_time}}</div>
      </div>
      <div class="itemCon">
        <div class="title">经度</div>
        <div class="index">{{driverLineRealtimeAlarmInfo.longitude}}</div>
      </div>
      <div class="itemCon">
        <div class="title">维度</div>
        <div class="index">{{driverLineRealtimeAlarmInfo.latitude}}</div>
      </div> -->
       <list-component :listData="driverLineRealtimeAlarmInfo"
                    v-if="driverLineRealtimeAlarmInfo"
                    :titlesData="format"></list-component>
    </div>

   

  </div>
</template>

<script type="text/javascript">
import { mapState } from 'vuex'
import PopUpWidget from '../../../components/PopUpWidget'
import ListComponent from '../../../components/ListComponent'

export default {
  name: '',
  components: {
    PopUpWidget,
    ListComponent,
  },
  computed: {
    ...mapState('driverlinerealtimealarminfo', [
      'driverLineRealtimeAlarmInfo',
      'type',
    ]),
    ...mapState('driverbase', ['ryjb']),
    format() {
      const fs = {
        驾驶行为: [
          {
            name: '机构',
            key: 'entity_id',
            width: 200,
          },
          {
            name: '车辆ID',
            key: 'vehicle_id',
            width: 200,
          },
          {
            name: '线路ID',
            key: 'route_id',
            width: 200,
          },
          {
            name: '报警类型',
            key: 'jssjlx.drive_event_type',
            width: 200,
          },
          {
            name: '速度',
            key: 'speed',
            width: 200,
          },
          {
            name: '方向',
            key: 'direction',
            width: 200,
          },
          {
            name: '报警时间',
            key: 'alarm_time',
            width: 200,
          },
          {
            name: '经度',
            key: 'longitude',
            width: 200,
          },
          {
            name: '维度',
            key: 'latitude',
            width: 200,
          },
        ],
        违规行为: [
          {
            name: '机构',
            key: 'entity_id',
            width: 200,
          },
          {
            name: '车辆ID',
            key: 'vehicle_id',
            width: 200,
          },
          {
            name: '线路ID',
            key: 'route_id',
            width: 200,
          },
          {
            name: '报警类型',
            key: 'jssjlx.drive_event_type',
            width: 200,
          },
          {
            name: '速度',
            key: 'speed',
            width: 200,
          },
          {
            name: '方向',
            key: 'direction',
            width: 200,
          },
          {
            name: '报警时间',
            key: 'irregularity_time',
            width: 200,
          },
          {
            name: '经度',
            key: 'longitude',
            width: 200,
          },
          {
            name: '维度',
            key: 'latitude',
            width: 200,
          },
        ],
        违法行为: [
          {
            name: '机构',
            key: 'entity_id',
            width: 200,
          },
          {
            name: '车辆ID',
            key: 'vehicle_id',
            width: 200,
          },
          {
            name: '线路ID',
            key: 'route_id',
            width: 200,
          },
          {
            name: '报警类型',
            key: 'jssjlx.drive_event_type',
            width: 200,
          },
          {
            name: '速度',
            key: 'speed',
            width: 200,
          },
          {
            name: '方向',
            key: 'direction',
            width: 200,
          },
          {
            name: '报警时间',
            key: 'illegaltype_time',
            width: 200,
          },
          {
            name: '经度',
            key: 'longitude',
            width: 200,
          },
          {
            name: '维度',
            key: 'latitude',
            width: 200,
          },
        ],
        有责事故: [
          {
            name: '机构',
            key: 'entity_id',
            width: 200,
          },
          {
            name: '车辆ID',
            key: 'vehicle_id',
            width: 200,
          },
          {
            name: '报警时间',
            key: 'accidenttype_time',
            width: 200,
          },
          {
            name: '经度',
            key: 'longitude',
            width: 200,
          },
          {
            name: '维度',
            key: 'latitude',
            width: 200,
          },
          {
            name: '事故等级',
            key: 'latitude',
            width: 200,
          },
          {
            name: '事故责任',
            key: 'latitude',
            width: 200,
          },
          {
            name: '是否泄露',
            key: 'latitude',
            width: 200,
          },
          {
            name: '事故状态',
            key: 'accident_status',
            width: 200,
          },
          {
            name: '事故损失',
            key: 'accident_loss',
            width: 200,
          },
          {
            name: '事故原因',
            key: 'accident_cause',
            width: 200,
          },
        ],
      }
      // console.log(fs[this.type])

      return fs[this.type]
    },
    contentCell() {
      return function (item, key) {
        let result = item
        key.split('.').forEach((k) => {
          result = result[k]
        })

        return result
      }
    },
  },
  data() {
    return {}
  },
}
</script>



<style lang="scss" scoped>
@mixin size($w,$h) {
  width: $w;
  height: $h;
}
.driverLineRealtimeAlarmInfoCon {
  width: 100%;
  min-height: 100px;
  //   background: red;
  .content {
    // width: 100%;
    width: 1690px;
    height: 200px;
    // min-height: 100px;
    // background: green;
    .itemCon {
      @include size(200px,100%);
      // height:60px;
      overflow: hidden;
      float: left;
      // background: pink;
      text-align: center;
      .title {
        font-size: 18px;
        color: #89dddf;
        line-height: 18px;
        // background: red;
      }
      .index {
        @include size(100%,40px);
        font-size: 22px;
        color: #fff;
        line-height: 40px;
        margin-top: 10px;
        background: rgba(3, 139, 252, 0.4);
      }
    }

    .itemCon:nth-child(n + 2) {
      margin-left: 10px;
    }
    .itemCon:nth-child(2) {
      width: 150px;
    }
    .itemCon:nth-child(3) {
      width: 280px;
    }
    .itemCon:nth-child(4) {
      width: 200px;
    }
    .itemCon:nth-child(5) {
      width: 100px;
    }
    .itemCon:nth-child(6) {
      width: 100px;
    }
    .itemCon:nth-child(7) {
      width: 280px;
    }
    .itemCon:nth-child(8) {
      width: 150px;
    }
    .itemCon:nth-child(9) {
      width: 150px;
    }
  }
}
</style>