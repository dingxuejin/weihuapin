<template>
  <div class="companyMsg-con">
    <div class="titleCon">
      企业基本信息
    </div>
    <div class="companyMsg clearfix">
      <div class="left fl">
        <div class="imgCon"></div>
      </div>
      <div class="right fl">
        <div class="item"> 
          <p class="title">企业名称</p>
          <p class="msg">朝阳光达化工有限公司</p>
        </div>
        <div class="item">
          <p class="title">经营许可有效期</p>
          <p class="msg">2026-12-25</p>
        </div>
        <div class="item">
          <p class="title">承运人责任险剩余时间</p>
          <!-- <p class="title">{{data}}</p> -->
          <p class="msg">2029-12-25</p>
        </div>
      </div>
    </div>
  </div>

</template>

<script type="text/javascript">
import { mapActions, mapState } from 'vuex'

export default {
  name: 'companyMsg',
  components: {},
  data() {
    return {}
  },
  computed: {
    ...mapState('companyMsgStore', ['data']),
  },
  methods: {
    ...mapActions('companyMsgStore', ['getCompanyMsg']),
  },
  created() {
    this.getCompanyMsg()
  },
}
</script>

<style lang="scss" scoped>
$h30: 30px;
$l20: 20px;
//main-layout
.companyMsg-con {
  width: 100%;
  height: 100%;
  overflow: hidden;
  // background: purple;
}
//title-container
.titleCon {
  width: 560px;
  height: $h30;
  overflow: hidden;
  margin-left: $l20;
  text-indent: 50px;
  line-height: 30px;
  background: url("../../../assets/company/left_header_strip.png");
}

//conpany-content
.companyMsg {
  width: 530px;
  height: 230px;
  overflow: hidden;
  margin: 10px 0px 0px 50px;
  // background: red
}
//conpany-left
.left {
  width: 230px;
  height: 230px;
  overflow: hidden;
  box-sizing: border-box;
  border: 1px solid rgb(129, 217, 229);
}
// background: cyan;
.imgCon {
  width: 218px;
  height: 218px;
  overflow: hidden;
  margin: 5px 0px 0px 5px;
  background: url("../../../assets/company/picture_enterprise.png");
}

// conpany-right
.right {
  width: 280px;
  height: 230px;
  overflow: hidden;
  margin-left: $l20;
  // background: blue;
}

.item {
  width: 100%;
  // height: 50px;
  overflow: hidden;
  // background: #000;
  .title {
    color: #69a3b1;
    font-size: 16px;
  }
  .msg {
    height: 40px;
    margin-top: 6px;
    box-sizing: border-box;
    border: 1px solid #05d0eb;
    color: #fff;
    font-weight: bold;
    text-align: center;
    line-height: 38px;
    background: rgba(5, 208, 235, 0.4);
  }
}
.item:nth-child(n + 2) {
  margin-top: 15px;
}
.item:nth-child(3) .msg {
  border: 1px solid #e75029;
  background: rgba(231, 80, 41, 0.4);
}
</style>