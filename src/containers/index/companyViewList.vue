<template>
  <div class="companyViewList clearfix">

    <!-- 企业列表: start-->
    <div class="companyViewList_title">
      <div class="companyViewList_title_topLine fl"></div>
      <div class="companyViewList_title_box fl">
        <div class="companyViewList_title_box_verticalLine_1 fl"></div>
        <div class="companyViewList_title_box_verticalLine_2 fl"></div>
        <div class="companyViewList_title_box_text fl">{{companyViewList_title}}</div>
      </div>
    </div>

    <!-- 搜索框 -->
    <div class="companyViewList_search">
      <el-input size="medium"
                placeholder="输入企业查询"
                suffix-icon="el-icon-search"
                v-model="searchInput">
      </el-input>
    </div>

    <!-- 面包屑导航 -->
    <div class="companyViewList_nav">
      <!-- 导航内容 -->
      <div class="companyViewList_nav_link">
        <span class="province_nav fl"
              @click="navLink('province_nav')">{{province_nav}}
          <i class="fr"
             v-if="province_nav"></i>
        </span>
        <span class="operator_nav fl"
              @click="navLink('operator_nav')">{{operator_nav}}
          <i class="fr"
             v-if="operator_nav"></i>
        </span>
        <span class="company_nav fl">{{company_nav}}</span>
      </div>
      <!-- 省份展示-->
      <div class="companyViewList_nav_provices">
        <div class="companyViewList_nav_provices_itemProvices fl"
             v-for="(item,index) in Province"
             :key="index"
             @click="getBreadcrumbInfo(item)"
             v-if="provicesShow">
          {{item.province}}
        </div>
        <!-- 运营商-->
        <div class="companyViewList_nav_provices_itemSp fl"
             v-for="(item,index) in SpName"
             :key="index"
             @click="getBreadcrumbInfo(item,'sp')"
             v-if="spShow">
          <div class="over fl"
               :title="item.sp_name">{{item.sp_name}}</div>{{'('+item.establishment_date+")"}}
        </div>
        <!-- 企业-->
        <div class="companyViewList_nav_provices_itemCompany fl"
             v-for="(item,index) in CompanyNameList"
             :key="index"
             @click="getBreadcrumbInfo(item,'company')"
             v-if="companyShow">
          <div class="over fl"
               :title="item.company_name"
               @click="getCompanyInfoPopup(item.company_name)">{{item.company_name}}</div>{{'('+item.economic_type_code+")"}}
        </div>
      </div>

    </div>
    <!-- 车辆详情对应list -->
    <div class="companyViewList_carlist">
      <!-- 头部 -->
      <div class="companyViewList_carlist_header">
        <div class="companyViewList_carlist_header_title title_1">车牌号</div>
        <div class="companyViewList_carlist_header_title title_2">轨迹</div>
        <div class="companyViewList_carlist_header_title title_3">详情</div>
      </div>
      <!-- 内容 -->
      <div class="companyViewList_carlist_details">
        <div class="companyViewList_carlist_details_col"
             v-for="(o,index) in carDetailsDefault"
             :key="index">
          <div class="companyViewList_carlist_details_col_td td1">{{o.name}}</div>
          <div class="companyViewList_carlist_details_col_td td2"
               @click="getTrajectoryInfoPopup(o.name)">轨迹</div>
          <div class="companyViewList_carlist_details_col_td td3"
               @click="getDetails(o.name)">详情</div>
        </div>
      </div>
    </div>
    <!-- 企业列表: end-->
  </div>
</template>

<script>
import { mapMutations, mapState, mapActions } from 'vuex'
// import Dictionary from '../../util/dictionary'

// const { provinces } = Dictionary

export default {
  name: 'companyViewList',
  components: {},
  data() {
    return {
      companyViewList_title: '企业列表',
      searchInput: '',
      province_nav: '',
      operator_nav: '',
      company_nav: '',
      // 面包屑导航详细信息
      breadcrumbInfo: [],
      // 省份
      provincesNum: [
        {
          name: '北京',
        },
        {
          name: '江苏',
        },
        {
          name: '山东',
        },
        {
          name: '浙江',
        },
        {
          name: '河南',
        },
        {
          name: '四川',
        },
        {
          name: '湖北',
        },
        {
          name: '上海',
        },
        {
          name: '湖南',
        },
        {
          name: '河北',
        },
        {
          name: '福建',
        },
        {
          name: '广东',
        },
        {
          name: '安徽',
        },
        {
          name: '辽宁',
        },
        {
          name: '江西',
        },
        {
          name: '陕西',
        },
        {
          name: '天津',
        },
        {
          name: '重庆',
        },
        {
          name: '广西',
        },
        {
          name: '云南',
        },
        {
          name: '内蒙古',
        },
        {
          name: '山西',
        },
        {
          name: '黑龙江',
        },
        {
          name: '贵州',
        },
        {
          name: '吉林',
        },
        {
          name: '新疆',
        },
        {
          name: '甘肃',
        },
        {
          name: '海南',
        },
        {
          name: '宁夏',
        },
        {
          name: '青海',
        },
        {
          name: '西藏',
        },
        {
          name: '香港',
        },
        {
          name: '澳门',
        },
        {
          name: '台湾',
        },
      ],
      companyNum: [],
      // 运营商
      spNums: [
        {
          name: '北京中航天泰科技有限公司',
          province: '北京',
          AccessCars: 1967,
          type: 'sp',
        },
      ],
      spNum: [],
      provicesShow: true, // 省份展示
      spShow: false, // 运营商展示
      companyShow: false, // 企业展示
      // 车辆明细
      carDetails: [
        {
          company: '亿顺凯危货运输有限公司',
          data: [
            {
              name: '冀R85326',
            },
            {
              name: '冀R70623',
            },
            {
              name: '冀R62370',
            },
            {
              name: '京AT0899',
            },
            {
              name: '冀R70546',
            },
            {
              name: '冀R70541',
            },
            {
              name: '冀R70542',
            },
            {
              name: '冀R70543',
            },
            {
              name: '冀R70544',
            },
            {
              name: '冀R70547',
            },
            {
              name: '冀R70546',
            },
            {
              name: '冀R70541',
            },
            {
              name: '冀R70542',
            },
          ],
        },
        {
          company: '京东物流',
          data: [
            {
              name: '冀R70543',
            },
            {
              name: '冀R70544',
            },
            {
              name: '冀R70547',
            },
            {
              name: '冀R70546',
            },
            {
              name: '冀R70541',
            },
            {
              name: '冀R70542',
            },
            {
              name: '冀R70543',
            },
            {
              name: '冀R70544',
            },
            {
              name: '冀R70547',
            },
          ],
        },
      ],
      // 展示车辆信息
      carDetailsDefault: [],
      carsDetails: [// 首页车辆信息
        {
          name: '京AAF905',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AAG152',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AAG170',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AAG182',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AAG218',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京ACY173',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京ACY271',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京ADC072',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京ADC075',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京ADC116',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AE9680',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AH2715',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AH8552',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AK2961',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AK3016',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AL8287',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AN1054',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AN1650',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AR7513',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AR7583',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AR7589',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AR7609',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京AR7616',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京P52D86',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京P52D89',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京P52D91',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京P52D92',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京P5DB81',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京PM5625',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京PM5661',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京Q5EE95',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京QAS295',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京YCN720',
          belongToCom: '北京程盛新泰燃气有限公司',
        },
        {
          name: '京ADN312',
          belongToCom: '北京市今日阳光燃气发展有限公司',
        },
        {
          name: '京ADN318',
          belongToCom: '北京市今日阳光燃气发展有限公司',
        },
        {
          name: '京ADN319',
          belongToCom: '北京市今日阳光燃气发展有限公司',
        },
        {
          name: '京ADN322',
          belongToCom: '北京市今日阳光燃气发展有限公司',
        },
        {
          name: '京AN2254',
          belongToCom: '北京市今日阳光燃气发展有限公司',
        },
        {
          name: '京AN8375',
          belongToCom: '北京市今日阳光燃气发展有限公司',
        },
        {
          name: '京G70944',
          belongToCom: '北京市今日阳光燃气发展有限公司',
        },
        {
          name: '京ADX130',
          belongToCom: '北京新亚特物流有限公司',
        },
        {
          name: '京AEA650',
          belongToCom: '北京新亚特物流有限公司',
        },
        {
          name: '京AEB615',
          belongToCom: '北京新亚特物流有限公司',
        },
        {
          name: '京AEM152',
          belongToCom: '北京新亚特物流有限公司',
        },
        {
          name: '京AEP227',
          belongToCom: '北京新亚特物流有限公司',
        },
        {
          name: '京AEU203',
          belongToCom: '北京新亚特物流有限公司',
        },
        {
          name: '京AH4704',
          belongToCom: '北京新亚特物流有限公司',
        },
        {
          name: '京AJ8205',
          belongToCom: '北京新亚特物流有限公司',
        },
        {
          name: '京AJ8227',
          belongToCom: '北京新亚特物流有限公司',
        },
        {
          name: '京AJ8236',
          belongToCom: '北京新亚特物流有限公司',
        },
      ],
    }
  },
  computed: {
    ...mapState('index', ['companyInfos', 'Province', 'SpName', 'CompanyNameList']),
  },
  methods: {
    ...mapMutations('index', [
      'getCompanyInfoShow',
      'getTrajectoryShow',
      'getCarDetailsInfoShow',
      'setProvinceName',
    ]),
    ...mapActions('index', [
      'getListqueryProvince',
      'getListquerySpName',
      'getListqueryCompanyName',
    ]),
    getCompanyInfoPopup(name) {
      // 显示企业信息弹框
      this.getCompanyInfoShow({
        name,
        state: true,
      })
    },
    getTrajectoryInfoPopup(name) {
      // 显示轨迹信息弹框
      this.getTrajectoryShow({
        name,
        state: true,
      })
    },
    // 显示详情信息弹框
    getDetails(name) {
      this.getCarDetailsInfoShow({
        name,
        state: true,
      })
    },
    getBreadcrumbInfo(item, type) {
      // 获取面包屑导航信息
      if (item) {
        if (type === undefined) {
          this.province_nav = item.province
          this.provicesShow = false
          this.spShow = true
          this.getListquerySpName({ province_code: item.province_code })
        } else if (type === 'sp') {
          this.operator_nav = item.sp_name
          this.provicesShow = false
          this.spShow = false
          this.companyShow = true
          this.getListqueryCompanyName({ sp_id: item.sp_id })
        } else if (type === 'company') {
          this.company_nav = ''
          this.company_nav = item.name
          this.carDetailsDefault =
          this.carsDetails && this.carsDetails.filter(o => o.belongToCom === item.name)
        }
      }
    },

    navLink(item) {
      // 面包屑导航信息点击信息展示
      if (item === 'province_nav') {
        this.province_nav = ''
        this.operator_nav = ''
        this.company_nav = ''
        this.provicesShow = true
        this.companyShow = false
        this.spShow = false
        this.carDetailsDefault = this.carsDetails
      } else if (item === 'operator_nav') {
        // this.operator_nav = true
        this.company_nav = ''
        this.spShow = true
        this.provicesShow = false
        this.companyShow = false
        this.carDetailsDefault = this.carsDetails
      }
    },
  },
  mounted() {
    this.carDetailsDefault = this.carsDetails
  },
  created() {
    this.getListqueryProvince()
  },
}
</script>
<style lang="scss" scoped>
.companyViewList {
  width: 100%;
  height: 100%;
  //企业列表
  &_title {
    width: 585px;
    height: 60px;
    margin-left: 7px;
    &_topLine {
      width: 548px;
      height: 2px;
      background: rgba(129, 217, 229, 0.5);
      margin-top: 5px;
      margin-left: 37px;
    }
    &_box {
      width: 585px;
      height: 40px;
      background: rgba(3, 139, 252, 0.2);
      margin-top: 10px;
      &_verticalLine_1 {
        width: 7.5px;
        height: 40px;
        background: rgba(129, 217, 229, 0.3);
      }
      &_verticalLine_2 {
        width: 18.5px;
        height: 40px;
        background: rgba(129, 217, 229, 0.3);
        margin-left: 30px;
      }
      &_text {
        width: 112px;
        height: 40px;
        line-height: 40px;
        text-align: center;
        font-family: "MicrosoftYaHei";
        font-size: 28px;
        color: #89dddf;
        margin-left: 30px;
      }
    }
  }
  &_search {
    width: 460px;
    height: 40px;
    margin: 15px auto;
    // background:rgba(3, 139, 252,0.2);
    // border: 2px solid rgba(3, 139, 252,0.2);
  }
  &_nav {
    width: 465px;
    height: 346px;
    padding: 10px 0 0;
    box-sizing: border-box;
    margin: 15px auto 0;
    background: rgba(38, 99, 130, 0.22);
    &_link {
      width: 450px;
      height: 30px;
      line-height: 30px;
      text-indent: 5px;
      margin: 0 auto;
      background: rgba(3, 139, 252, 0.2);
      font-size: 16px;
      color: #838484;
      overflow: hidden;
      span {
        margin: 0;
        padding: 0;
        display: inline-block;
        height: 30px;
        line-height: 30px;
        i {
          margin: 0;
          padding: 0;
          display: inline-block;
          width: 15px;
          height: 30px;
          background: url(../../assets/zhishijiantou.png) no-repeat center 7.5px;
        }
        cursor: pointer;
      }
      span:last-child {
        width:180px;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
        color: #fafafc;
      }
    }
    &_provices {
      height: 280px;
      width: 435px;
      margin: 12px auto 0;
      overflow: hidden;
      overflow-y: scroll;
      padding-right: 5px;
      box-sizing: border-box;
      &_itemProvices {
        width: 130px;
        height: 30px;
        line-height: 30px;
        text-align: center;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        border: 1px solid #81d9e5;
        color: #b5b5b5;
        cursor: pointer;
        margin-bottom: 10px;
        box-sizing: border-box;
        margin-left: 15px;
        div {
          margin: 0;
          padding: 0;
          display: inline-block;
          width: 30px;
          line-height: 30px;
        }
      }
      &_itemProvices:nth-child(3n + 1) {
        margin-left: 0;
      }
      &_itemProvices:hover {
        color: #fff;
      }

      // 显示用营商
      &_itemSp {
        width: 197px;
        height: 30px;
        line-height: 30px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        border: 1px solid #81d9e5;
        color: #b5b5b5;
        cursor: pointer;
        margin-bottom: 10px;
        box-sizing: border-box;
        margin-left: 15px;
        div {
          margin: 0;
          padding: 0;
          display: inline-block;
          width: 135px;
          line-height: 30px;
          text-indent: 2px;
        }
      }
      &_itemSp:hover {
        color: #fff;
      }

      // 显示企业
      &_itemCompany {
        width: 197px;
        height: 30px;
        line-height: 30px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        border: 1px solid #81d9e5;
        color: #b5b5b5;
        cursor: pointer;
        margin-bottom: 10px;
        box-sizing: border-box;
        margin-left: 15px;
        div {
          margin: 0;
          padding: 0;
          display: inline-block;
          width: 135px;
          line-height: 30px;
          text-indent: 2px;
        }
      }
      &_itemCompany:hover {
        color: #fff;
      }
    }
    &_provices::-webkit-scrollbar {
      width: 5px;
      background: #69a3b1;
    }
    &_provices::-webkit-scrollbar-thumb {
      width: 5px;
      background: #05d0eb;
    }
  }
  &_carlist {
    width: 465px;
    height: 458px;
    padding-top: 5px;
    box-sizing: border-box;
    background: rgba(38, 99, 130, 0.22);
    margin: 13px auto 0;
    &_header {
      width: 100%;
      height: 30px;
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      &_title {
        width: 145.5px;
        height: 30px;
        line-height: 26px;
        border: 2px solid #05d0eb;
        background: rgba(3, 139, 252, 0.4);
        color: #fafbfc;
        text-align: center;
        box-sizing: border-box;
      }
      .title_2 {
        width: 130px;
      }
      .title_3 {
        width: 155.5px;
      }
    }
    &_details {
      width: 435px;
      height: 415px;
      color: #b5b5b5;
      font-size: 12px;
      padding-right: 5px;
      // padding-left: 10px;
      margin: 10px auto 0;
      box-sizing: border-box;
      overflow: hidden;
      overflow-y: scroll;
      &_col {
        width: 425px;
        height: 25px;
        margin-bottom: 10px;
        margin-right: 5px;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
        &_td {
          width: 130px;
          height: 25px;
          line-height: 23px;
          text-align: center;
          border: 1px solid #81d9e5;
          box-sizing: border-box;
        }
        .td2,
        .td3 {
          background: #031528;
          cursor: pointer;
        }
        .td2:hover,
        .td3:hover {
          background: #06e5fc;
          color: #fff;
        }
      }
    }
    &_details::-webkit-scrollbar {
      width: 5px;
      background: #69a3b1;
    }
    &_details::-webkit-scrollbar-thumb {
      width: 5px;
      background: #05d0eb;
    }
  }
}
</style>
