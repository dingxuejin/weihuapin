<template>
  <div class="assetState_contend">
    <div class="top_part">
      <div>区域总运力</div> <div><div> </div>115</div>
    </div>
    <div class="bottom_part">
      <div>
        <div>正常</div>
        <div class="normalText"><div></div>正常运行</div>
      </div>
      <div>
        <div>数目（台）</div>
        <div class="amount"><div></div>{{distribution.normal_vehicle_number}}</div>
      </div>
      <div>
        <div>异常状态</div>
        <div class="abnormalState ">
          <div><div></div>维修停驶</div>
          <div><div></div>无人停驶</div>
          <div><div></div>无业务停驶</div>
          <div><div></div>车辆检验停驶</div>
          <div title="其他原因停驶(车号明细中表明原因)"><div></div>其他原因停驶(车号明细中表明原因)</div>
        </div>
      </div>
      <div>
        <div>数目（台）</div>
        <div class="amount">
          <div><div></div>{{distribution.repaired_vehicle_number}}</div>
          <div><div></div>{{distribution.unattended_vehicle_number}}</div>
          <div><div></div>{{distribution.idle_vehicle_number}}</div>
          <div><div></div>{{distribution.test_vehicle_number}}</div>
          <div><div></div>{{distribution.other_vehicle_number}}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script type="text/javascript">
import { mapState } from 'vuex'

export default {
  name: '',
  components: {
  },
  computed: {
    ...mapState('DailyManageLedger', ['distribution']),
  },
  methods: {

  },
  data() {
    return {

    }
  },
}
</script>

<style lang="scss" scoped>
.assetState_contend{
    width: 100%;
    height: 100%;
    .top_part{
      width: 100%;
      height: 50px;
      background: rgba(9,122,206,0.20);
      box-sizing: border-box;
      div{float: left;}
      div:nth-child(1){
          width: 169px;
          height: 50px; 
          text-align: center;
          line-height: 50px;
          font-size: 16px;
          color: #89DDDF;
            }
      div:nth-child(2){
        margin-top: 6px;
        width: 198px;
        height: 40px;
        border: solid 1px  #05D0EB;
        padding: 13px 9px;
        box-sizing: border-box;
        font-size: 12px;
        color: #fff;
        div{
            display: inline-block;
            width: 10px;
            height: 10px;
            transform: rotate(45deg);
            background: #05D0EB;
            margin-right: 6px;
          }
        }
    }
    .bottom_part{
      width: 100%;
      height: 161px;
      margin-top: 4px;
      div{
        float: left;
        background: rgba(9,122,206,0.20);
        padding: 3px;
        box-sizing: border-box;
        div:nth-child(1){
          width: 100%;
          height: 49px;
          text-align: center;
          line-height: 49px;
          font-size: 16px;
          color: #89DDDF;
        }
      }
      div:nth-child(n+2){
        margin-left: 2px;
      }
      div:nth-child(1){
        width: 84px;
        height: 161px;
        .normalText{
          width: 100%;
          height: 107px;
          font-size: 12px;
          color: #fff;
          padding: 33px 2px;
          border: solid 1px  #05D0EB;
          box-sizing: border-box;
          margin: 0;
          div{
            display: inline-block;
            width: 8px;
            height: 8px;
            transform: rotate(45deg);
            background: #05D0EB;
            margin-top: 2px;
            margin-right: 2px;
          }
        }
      }
      div:nth-child(2){
        width: 137px;
        height: 161px;
        .amount{
          width: 100%;
          height: 107px;
          font-size: 12px;
          color: #fff;
          padding: 33px 4px;
          border: solid 1px  #05D0EB;
          box-sizing: border-box;
          margin: 0;
          div{
            display: inline-block;
            width: 8px;
            height: 8px;
            transform: rotate(45deg);
            background: #05D0EB;
            margin-top: 2px;
            margin-right: 2px;
          }
        }
      }
      div:nth-child(3){
        width: 173px;
        height: 161px;
        .abnormalState{
          width: 100%;
          height: 107px;
          padding: 0 2px;
          box-sizing: border-box;
          margin: 0;
          div:nth-child(5){
            overflow: hidden;
            text-overflow:ellipsis;
          }
          div{
            width: 100%;
            height: 21px;
            padding: 0;
            margin: 0;
            color: #fff;
            text-align: left;
            line-height: 21px;
            font-size: 12px;
            border: solid 1px  #05D0EB;
            box-sizing: border-box;
            div{
              display: inline-block;
              width: 8px;
              height: 8px;
              transform: rotate(45deg);
              background: #05D0EB;
              margin:6px 4px 0 4px;
            }
          }
        }
      }
      div:nth-child(4){
        width: 142px;
        height: 161px;
        .amount{
          width: 100%;
          height: 107px;
          padding: 0 2px;
          box-sizing: border-box;
          margin: 0;
          div{
            width: 100%;
            height: 21px;
            padding: 0;
            margin: 0;
            color: #fff;
            text-align: left;
            line-height: 21px;
            font-size: 12px;
            border: solid 1px  #05D0EB;
            box-sizing: border-box;
            div{
              display: inline-block;
              width: 8px;
              height: 8px;
              transform: rotate(45deg);
              background: #05D0EB;
              margin:6px 4px 0 4px;
            }
          }
        }
      }
      div:nth-child(5){
        width: 146px;
        height: 161px;
        .carNumberDetail{
          width: 100%;
          height: 107px;
          padding: 0 2px;
          box-sizing: border-box;
          margin: 0;
          div{
            width: 100%;
            height: 21px;
            padding: 0;
            margin: 0;
            color: #fff;
            text-align: left;
            line-height: 21px;
            font-size: 12px;
            border: solid 1px  #05D0EB;
            box-sizing: border-box;
            div{
              display: inline-block;
              width: 8px;
              height: 8px;
              transform: rotate(45deg);
              background: #05D0EB;
              margin:6px 4px 0 4px;
            }
          }
        }
      }
    }
}
</style>