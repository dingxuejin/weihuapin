<template>
  <div class="indexLayout clearfix" @mousemove="onMousemove">
    <!-- header -->
    <div class="indexLayout_header clearfix fl">
      <common-header :headerTitle="headerTitle" :leftHeaderTitle="leftHeaderTitle"></common-header>
    </div>
    <!-- content-left -->
    <div class="indexLayout_content_listView fl">
      <company-view-list></company-view-list>
    </div>
    <!-- content-right -->
    <div class="indexLayout_content_map fr">
      <index-map></index-map>
    </div>
    <!-- popup：start -->
    <!-- 1. 企业信息 -->
    <div class="indexLayout_content_popup_comInfo" v-if="companyInfoShow">
      <company-info-popup></company-info-popup>
    </div>
    <!-- 2.轨迹信息 -->
    <div class="indexLayout_content_popup_trajectoryInfo" v-if="trajectoryShow">
      <trajectory-info-popup></trajectory-info-popup>
    </div>
    <!-- 3、车辆详情信息 -->
    <div class="indexLayout_content_popup_detailsInfo" v-if="carDetailsShow">
      <car-details-popup></car-details-popup>
    </div>
    <!-- popup：end -->
    <div class="indexLayout_btn" v-show="showRoute">
      <img src="../../assets/qiehuanyou.png" @click='$router.push("/kanban")' />
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import CommonHeader from '../../components/commonHeader'
import CompanyViewList from '../../containers/index/companyViewList'
import IndexMap from '../../containers/index/indexMap'
import CompanyInfoPopup from '../../containers/index/companyInfoPopup'
import TrajectoryInfoPopup from '../../containers/index/trajectoryInfoPopup'
import carDetailsPopup from '../../containers/index//carDetailsPopup'

export default {
  name: 'company',
  components: {
    CommonHeader,
    CompanyViewList,
    IndexMap,
    CompanyInfoPopup,
    TrajectoryInfoPopup,
    carDetailsPopup,
  },
  data() {
    return {
      headerTitle: '企业信息查询',
      leftHeaderTitle: '首页',
      showRoute: true,
    }
  },
  computed: {
    ...mapState('index', ['trajectoryShow', 'companyInfoShow', 'carDetailsShow']),
  },
  methods: {
    onMousemove() {
      // this.showRoute = true
      // setTimeout(() => {
      //   this.showRoute = false
      // }, 3000)
    },
  },
  mounted() {},
}
</script>
<style lang="scss" scoped>
// 企业页布局
.indexLayout {
  width: 1920px;
  height: 1080px;
  overflow: hidden;
  background: url("../../assets/index/bg_index_01.png");
  background-size: 100% 100%;
  // header
  &_header {
    width: 100%;
    height: 80px;
    margin-top: 20px;
    // background: pink;
  }
  //左侧查询list
  &_content_listView {
    width: 593px;
    height: 950px;
    margin-top: 15px;
    margin-left: 15px;
    background: #031528;
  }
  // 地图
  &_content_map {
    width: 1280px;
    height: 950px;
    margin-top: 15px;
    margin-right: 15px;
    border: 4px solid rgba(40, 165, 249, 0.5);
    box-sizing: border-box;
  }
  // 弹出框:企业信息
  &_content_popup_comInfo {
    width: 820px;
    height: 402px;
    position: absolute;
    top: 310px;
    left: 660px;
    z-index: 11;
    background:#000;
  }
  // 弹出框：轨迹信息
  &_content_popup_trajectoryInfo {
    width: 750px;
    height: 290px;
    position: absolute;
    top: 610px;
    left: 660px;
    z-index: 11;
    background:#000;
  }
  // 弹出框：详情信息
  &_content_popup_detailsInfo{
    width: 877px;
    height: 598px;
    position: absolute;
    top: 300px;
    left: 660px;
    z-index: 11;
    background:#212223;
  }
  &_btn{
    position:fixed;
    right:5px;
    top:45%;
    z-index: 111;
    img{
      cursor: pointer;
    }
  }
}
</style>
