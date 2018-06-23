<template>
  <div class="pop" v-drag @mousedown="move=true" @mouseup="move=false" :style="move?'cursor:move':''">
    <PopUpFrame @close='up'>
      <PopUpWidget title='线路详细信息'>
        <div class="list">
          <list-component :listData="lineDetail" :titlesData='data' v-if="lineDetail"></list-component>
          <!-- <loading :data='lineDetail'></loading> -->
        </div>
      </PopUpWidget>
    </PopUpFrame>
  </div>
</template>
    
<script>
import { mapState } from 'vuex'
import PopUpFrame from '@/components/PopUpFrame'
import PopUpWidget from '@/components/PopUpWidget'
import ListComponent from '../../../components/ListComponent'

export default {
  components: {
    PopUpFrame,
    PopUpWidget,
    ListComponent,
  },
  computed: {
    ...mapState('linePopup', ['lineDetail']),
  },
  methods: {
    up() {
      this.$emit('upx')
    },
  },
  data() {
    return {
      move: false,
      data: [
        // { name: 'id', key: 'route_id', width: 200 },
        // { name: '线路', key: 'route_id', width: 200 },
        { name: '线路名称', key: 'route_name', width: 250 },
        { name: '货源地', key: 'qy_dbxx_source_db_id.name', width: 250 },
        { name: '目的地', key: 'qy_dbxx_destination_db_id.name', width: 250 },
        { name: '场站', key: 'qy_dbxx_station_name.name', width: 250 },
        { name: '线路类型', key: 'xllx_route_type_code.route_type', width: 250 },
        { name: '里程', key: 'km', width: 100 },
        { name: '高速里程', key: 'highway_km', width: 100 },
        { name: '预计用时', key: 'plan_time', width: 100 },
        { name: '标准油耗', key: 'standard_oil_use', width: 100 },
        { name: '标准气耗', key: 'standard_gas_use', width: 100 },
        { name: '风险点数量', key: 'total_risk_location', width: 100 },
        { name: '是否跨省线路', key: 'if_interprovince', width: 100 },
        { name: '机构', key: 'entity_id', width: 250 },
        { name: '线路状态', key: 'xlzt_route_status_code.route_status', width: 100 },
        { name: '创建时间', key: 'create_time', width: 250 },
      ],
    }
  },
}
</script>
    
    <style lang="scss" scoped>
.pop {
  width: 750px;
}
.list {
  height: 275px;
  overflow-x: scroll;
  overflow-y: hidden;
  height: 275px;
  border: 1px solid #91d9e5;
  box-sizing: border-box;
  .header {
    width: 1600px;
    div {
      font-size: 16px;
      color: #89dddf;
      height: 25px;
      line-height: 25px;
      text-align: center;
      width: 80px;
      float: left;
      background: rgba(5, 208, 235, 0.2);
      margin-top: 10px;
    }
    div:nth-child(1) {
      width: 60px;
    }
    div:nth-child(2) {
      width: 240px;
    }
    div:nth-child(3),
    div:nth-child(4) {
      width: 130px;
    }
    div:nth-child(5) {
      width: 100px;
    }
    div:nth-child(13),
    div:nth-child(15) {
      width: 110px;
    }
  }
  ul {
    list-style: none;
    overflow-y: auto;
    width: 1600px;
    height: 240px;
    li {
      height: 20px;
      margin-top: 5px;
      background: rgba(129, 217, 229, 0.1);
      div {
        line-height: 20px;
        font-size: 14px;
        color: #b5b5b5;
        float: left;
        width: 80px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        text-align: center;
      }
      div:nth-child(1) {
        width: 60px;
      }
      div:nth-child(2) {
        width: 240px;
      }
      div:nth-child(3),
      div:nth-child(4) {
        width: 130px;
      }
      div:nth-child(5) {
        width: 100px;
      }
      div:nth-child(13) {
        width: 110px;
      }
      div:nth-child(15) {
        width: 100px;
      }
    }
    li:hover {
      background: rgba(129, 217, 229, 0.5);
      cursor: pointer;
      div {
        color: #ffffff;
      }
    }
  }
  ul::-webkit-scrollbar {
    width: 5px;
    background: #69a3b1;
  }
  ul::-webkit-scrollbar-thumb {
    background: #05d0eb;
  }
}
.list::-webkit-scrollbar {
  height: 5px;
  background: #69a3b1;
}
.list::-webkit-scrollbar-thumb {
  background: #05d0eb;
}
</style>