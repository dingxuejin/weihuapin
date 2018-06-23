<template>
  <div class="companyInfoPopup clearfix">
    <popupframe @close="close">
      <div class="companyInfoPopup_title">
        <div class="companyInfoPopup_title_text"
             @click='toCompany'>企业信息</div>
      </div>
      <div class="companyInfoPopup_left fl">
        <div class="companyInfoPopup_left_itemBox clearfix"
             v-for="(item, index) in companyInfo_left"
             :key="index">
          <div class="companyInfoPopup_left_itemBox_title fl">
            {{item.name}}
          </div>
          <div class="companyInfoPopup_left_itemBox_value fl">
            <div class="companyInfoPopup_left_itemBox_value_rotateBox"></div>
            <div class="companyInfoPopup_left_itemBox_value_text"
                 :title="item.value">
              {{item.value}}
            </div>
          </div>
        </div>
      </div>
      <div class="companyInfoPopup_right fr">
        <div class="companyInfoPopup_right_itemBox clearfix"
             v-for="(item, index) in companyInfo_right"
             :key="index">
          <div class="companyInfoPopup_right_itemBox_title fl">
            {{item.name}}
          </div>
          <div class="companyInfoPopup_right_itemBox_value fl">
            <div class="companyInfoPopup_right_itemBox_value_rotateBox"></div>
            <div class="companyInfoPopup_right_itemBox_value_text">
              {{item.value}}
            </div>
          </div>
        </div>
      </div>
      <div v-show="false">{{getPopupComInfo}}</div>
    </popupframe>
  </div>
</template>

<script>
import { mapMutations, mapState } from 'vuex'
import Popupframe from '../../containers/index/popupframe'

export default {
  name: 'companyInfoPopup',
  components: {
    Popupframe,
  },
  data() {
    return {
      companyInfo_left: [
        {
          name: '企业名称',
          value: 'XXXXXX',
        },
        {
          name: '注册地址',
          value: 'XXXXXX',
        },
        {
          name: '注册时间',
          value: '2015-06-12',
        },
        {
          name: '经营范围',
          value: 'XXXXXX',
        },
        {
          name: '接入时间',
          value: '2017-02-15',
        },
        {
          name: '接入车辆',
          value: '64',
        },
      ],
      companyInfo_right: [
        {
          name: '企业当日ADAS上线率',
          value: '62.3',
        },
        {
          name: '企业当月车机上线率',
          value: '74.3',
        },
        {
          name: '报警数量',
          value: '15',
        },
        {
          name: '已处理的报警数量',
          value: '10',
        },
      ],
    }
  },
  computed: {
    ...mapState('index', ['indexPopupComInfo']),
    getPopupComInfo() {
      if (this.indexPopupComInfo) {
        this.companyInfo_left = [
          {
            name: '企业名称',
            value: this.indexPopupComInfo[0].name,
          },
          {
            name: '注册地址',
            value: this.indexPopupComInfo[0].RegisteredAdd,
          },
          {
            name: '注册时间',
            value: this.indexPopupComInfo[0].RegisteredDate,
          },
          {
            name: '经营范围',
            value: this.indexPopupComInfo[0].BusinessScope,
          },
          {
            name: '接入时间',
            value: this.indexPopupComInfo[0].AccessDate,
          },
          {
            name: '接入车辆',
            value: this.indexPopupComInfo[0].AccessCars,
          },
        ]
        this.companyInfo_right = [
          {
            name: '企业当日ADAS上线率',
            value: this.indexPopupComInfo[0].adasOnlineRatio,
          },
          {
            name: '企业当月车机上线率',
            value: this.indexPopupComInfo[0].carOnlineRatio,
          },
          {
            name: '报警数量',
            value: this.indexPopupComInfo[0].alarm_quantity,
          },
          {
            name: '已处理的报警数量',
            value: this.indexPopupComInfo[0].alarm_doneQuantity,
          },
        ]
      }

      return ''
    },
  },
  methods: {
    ...mapMutations('index', ['getCompanyInfoShow']),
    close() {
      this.getCompanyInfoShow(false)
    },
    toCompany() {
      const comName = this.indexPopupComInfo[0].name
      this.$router.push({
        path: '/company',
        query: { leftHeaderTitle: comName },
      })
    },
  },
  mounted() {},
}
</script>
<style lang="scss" scoped>
.companyInfoPopup {
  width: 820px;
  height: 402px;
  &_title {
    width: 807px;
    height: 40px;
    background: rgba(3, 139, 252, 0.4);
    margin-top: 23px;
    &_text {
      width: 360px;
      height: 40px;
      line-height: 40px;
      color: #fff;
      text-align: center;
      background: url(../../assets/zonghe.png) no-repeat 50px center;
      background-size: 29.5px 28px;
      border: 1px solid #05d0eb;
      box-sizing: border-box;
    }
  }
  &_left {
    width: 387px;
    height: 310px;
    background: rgba(9, 122, 206, 0.2);
    margin-top: 20px;
    margin-left: 10px;
    padding: 10px;
    box-sizing: border-box;
    &_itemBox {
      width: 368px;
      height: 40px;
      margin-bottom: 10px;
      &_title {
        width: 110px;
        height: 40px;
        color: #89dddf;
        line-height: 40px;
        text-align: center;
        background: rgba(129, 217, 229, 0.08);
      }
      &_value {
        width: 257px;
        height: 40px;
        line-height: 40px;
        // text-align: center;

        text-indent: 10px;
        border: 1px solid #81d9e5;
        box-sizing: border-box;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        &_rotateBox {
          display: inline-block;
          width: 10px;
          height: 10px;
          background: #05d0eb;
          transform: rotate(45deg);
          margin-top: 15px;
          margin-left: 10px;
        }
        &_text {
          display: inline-block;
          width: 182px;
          height: 40px;
          color: #fff;
          line-height: 40px;
          //   margin-left: 10px;
        }
      }
    }
  }
  &_right {
    width: 387px;
    height: 310px;
    background: rgba(9, 122, 206, 0.2);
    margin-top: 20px;
    margin-left: 10px;
    padding: 10px;
    box-sizing: border-box;
    margin-right: 10px;
    &_itemBox {
      width: 368px;
      height: 40px;
      margin-bottom: 10px;
      &_title {
        width: 179px;
        height: 40px;
        color: #89dddf;
        line-height: 40px;
        text-align: center;
        background: rgba(129, 217, 229, 0.08);
      }
      &_value {
        width: 188px;
        height: 40px;
        line-height: 40px;
        text-indent: 10px;
        border: 1px solid #81d9e5;
        box-sizing: border-box;
        &_rotateBox {
          display: inline-block;
          width: 10px;
          height: 10px;
          background: #05d0eb;
          transform: rotate(45deg);
          margin-top: 15px;
          margin-left: 10px;
        }
        &_text {
          display: inline-block;
          width: 100px;
          height: 40px;
          color: #fff;
          line-height: 40px;
          //   margin-left: 10px;
        }
      }
    }
  }
}
</style>

