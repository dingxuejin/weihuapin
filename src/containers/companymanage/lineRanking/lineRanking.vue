<template>
  <div class="lineRanking">
    <!-- <div class="title">
      <span>线路排名</span>
      <div class="btn"
           @click="getDetails"></div>
    </div> -->
    <div class="flex-between" style="marginTop:10px;">
      <div class="label">统计周期</div>
      <div class="change">
        <key-value-select :data='options'
                          @select='select'></key-value-select>
      </div>
    </div>

    <div class="listTitle flex-between">
      <div v-for='(item,index) in listTitle'
           :key='index'
           @click="onClickTitle(item)">{{item}}</div>
    </div>
    <ul>
      <li v-for='(item,index) in routeOrder'
          :key='index' class="flex-between">
        <div :title="item&&item.ranking">{{index+1}}</div>
        <div :title="item&&item.qy_xlxx && item.qy_xlxx.route_name">{{item && item.qy_xlxx && item.qy_xlxx.route_name}}</div>
        <div :title="item&&item.waybill_quantity">{{item.waybill_quantity}}</div>
        <div :title="item&&item.turnover">{{item.turnover}}</div>
        <div>
          <nav :class='[changeCode[item.ranking_change_code]]'></nav>
        </div>
      </li>
    </ul>
  </div>

</template>

<script>
import { mapState, mapActions, mapMutations } from 'vuex'
import KeyValueSelect from '../../../components/KeyValueSelect'
import Dictionary from '../../../util/dictionary'

export default {
  components: {
    KeyValueSelect,
  },
  computed: {
    ...mapState('maintitlemsg', ['selectedEntity']),
    ...mapState('manageLineRanking', ['routeOrder']),
  },

  methods: {
    ...mapActions('manageLineRanking', ['getRouteOrder']),
    ...mapMutations('manageLineRanking', ['setData']),
    ...mapMutations('popupContainer', ['getComDetails']),
    routeOrderData() {
      if (
        this.routeOrder &&
        this.routeOrder !== undefined &&
        this.routeOrder !== null
      ) {
        return true
      }
      return null
    },
    // getDetails() {
    //   this.getComDetails('lineRank')
    // },
    select(item) {
      this.getRouteOrder({
        entity_id: this.selectedEntity,
        year: Dictionary.nowYear,
        month: Dictionary.nowMonth,
        period: item.value,
      })
    },
    onClickTitle(info) {
      let list = this.routeOrder
      if (info === '运单数量') {
        // 运单数量排序
        if (this.waybillOrder) {
          list = this.routeOrder.sort(
            (a, b) => a.waybill_quantity - b.waybill_quantity,
          )
        } else {
          list = this.routeOrder.sort(
            (a, b) => b.waybill_quantity - a.waybill_quantity,
          )
        }
        this.waybillOrder = !this.waybillOrder
      } else if (info === '周转量') {
        // 周转量排序
        if (this.turnoverOrder) {
          list = this.routeOrder.sort((a, b) => a.turnover - b.turnover)
        } else {
          list = this.routeOrder.sort((a, b) => b.turnover - a.turnover)
        }
        this.turnoverOrder = !this.turnoverOrder
      }
      this.setData(list)
    },
  },
  data: () => ({
    waybillOrder: true,
    turnoverOrder: true,
    listTitle: ['排名', '线路', '运单数量', '周转量', '上升或下降'],
    options: [
      {
        label: '本年',
        value: 'year',
      },
      {
        label: '本月',
        value: 'month',
      },
    ],
    changeCode: {
      1: '',
      2: 'up',
      3: 'down',
    },
  }),
}
</script>

<style lang="scss" scoped>
.lineRanking {
  width: 400px;
  height: 225px;
  // .title {
  //   width: 403px;
  //   height: 25px;
  //   margin-bottom: 10px;
  //   line-height: 25px;
  //   background: rgba(129, 217, 229, 0.3);
  //   text-indent: 20px;
  //   font-size: 16px;
  //   color: #89dddf;
  //   position: relative;
  //   float: left;
  //   .btn {
  //     position: absolute;
  //     width: 20px;
  //     height: 6px;
  //     background: url("../../../assets/driver/drill_icon_on.png") no-repeat;
  //     top: 10px;
  //     right: 10px;
  //     cursor: pointer;
  //   }
  // }
  .change {
    flex: 1;
    height: 25px;
    color: #b5b5b5;
  }
  .label {
    line-height: 25px;
    float: right;
    margin-right: 10px;
    color: #b5b5b5;
  }
  .listTitle {
    height: 30px;
    margin-bottom: 5px;
    margin-top: 10px;
    div {
      height: 30px;
      box-sizing: border-box;
      text-align: center;
      line-height: 28px;
      border: 1px solid #81d9e5;
      color: #b5b5b5;
      font-size: 16px;
      width: 90px;
      cursor: pointer;
    }
    div:nth-child(1) {
      width: 46px;
    }
    div:nth-child(2) {
      width: 46px;
    }
    div:nth-child(3) {
      width: 90px;
    }
  }
  ul::-webkit-scrollbar {
    background: rgba(0, 191, 229, 0.5);
    width: 6px;
  }
  ul::-webkit-scrollbar-thumb {
    background: rgba(0, 191, 229, 1);
  }
  ul {
    height: 150px;
    list-style: none;
    overflow-y: scroll;
    color: #b5b5b5;
    li {
      margin-bottom: 5px;
      height: 25px;
      cursor: pointer;
      div {
        height: 25px;
        box-sizing: border-box;
        line-height: 23px;
        text-align: center;
        border: 1px solid rgba(0, 191, 229, 1);
        background: rgba(0, 191, 229, 0.2);
        width: 89px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
      }
      div:nth-child(1) {
        width: 46px;
        // overflow: hidden;
        // text-overflow:ellipsis;
        // white-space: nowrap;
      }
      div:nth-child(2) {
        width: 46px;
        overflow: hidden;
      }
      div:nth-child(3) {
        width: 90px;
        overflow: hidden;
      }
      div:last-child {
        width: 84px;
        nav {
          width: 20px;
          height: 3px;
          margin: 10px auto;
          background: url("../../../assets/companymanage/same_blue.png")
            no-repeat;
        }
        .down {
          width: 6px;
          height: 20px;
          margin: 1px auto;
          background: url("../../../assets/companymanage/down_icon.png")
            no-repeat;
        }
        .up {
          width: 6px;
          height: 20px;
          margin: 1px auto;
          background: url("../../../assets/companymanage/up_icon.png") no-repeat;
        }
      }
    }
    li:hover div {
      background: rgba(0, 191, 229, 0.5);
      color: #ffffff;
    }
  }
}
</style>