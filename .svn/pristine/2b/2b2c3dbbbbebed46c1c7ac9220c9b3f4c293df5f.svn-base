<template>
  <div class="carCenterTopMarquee">
    <div class="alertList"
         @click="getCarouselDetails({title:item.title,type:item.type})"
         v-for="(item,index) in getLatestAlertList" :key='index'>
      <span>{{item.title}}</span><span>{{item.endDate}}</span>到期
    </div>

    <div v-show="false">{{getLatestAlertList}}</div>
  </div>
</template>

<script>
import { mapMutations } from '../../../node_modules/_vuex@3.0.1@vuex'

export default {
  props: ['carAlertList'],
  data() {
    return {
    }
  },
  computed: {
    getLatestAlertList() {
      // console.log('carAlertList', this.carAlertList)
      return this.carAlertList.filter((o) => {
        const nowDate = new Date()
        const endDate = new Date(o.endDate)
        return endDate - nowDate >= 0
      })
    },
  },
  methods: {
    ...mapMutations('warningCarouselpopupContainer', ['warningDetails']),
    getCarouselDetails(params) {
      this.warningDetails(params)
    },
  },
}
</script>

<style lang="scss">
@mixin size($width,$height) {
  width: $width;
  height: $height;
}
.carCenterTopMarquee {
  @include size(500%,40px);
  line-height: 40px;
  color: #e75029;
  font-size: 16px;
  border-top: 1px solid #81d9e5;
  border-bottom: 1px solid #81d9e5;
  border-right: 2px solid #004668;
  background: rgba(12, 12, 12, 0.8);
  box-sizing: border-box;
  overflow: hidden;
  position: relative;
  .alertList {
    @include size(350px,40px);
    line-height: 40px;
    text-align: center;
    display: inline-block;
    margin-right: 25px;
    overflow: hidden;
    white-space: nowrap;
    cursor: pointer;
    span{
      display: inline-block;
      height:40px;
      line-height:40px;
      text-align: center;
      padding:0;
      margin:0;

    }
    span:last-child {
      font-size: 24px;
      font-weight: bold;
    }
    // 动画
    position: relative;
    -webkit-animation: marquee 180s linear infinite;
    -moz-animation: marquee 180s linear infinite;
    -ms-animation: marquee 180s linear infinite;
    -o-animation: marquee 180s linear infinite;
    animation: marquee 180s linear infinite;
  }
}
// 跑马灯动画
@-webkit-keyframes marquee {
  from {
    left: 18%;
  }
  to {
    left: -70%;
  }
}
/* Firefox */

@-moz-keyframes marquee {
  from {
    left: 18%;
  }
  to {
    left: -70%;
  }
}

// /* MIS */
@-ms-keyframes marquee {
  from {
    left: 18%;
  }
  to {
    left: -70%;
  }
}
// /* Opera */

@-o-keyframes marquee {
  from {
    left: 18%;
  }
  to {
    left: -70%;
  }
}

@keyframes marquee {
  from {
    left: 18%;
  }
  to {
    left: -70%;
  }
}
</style>
