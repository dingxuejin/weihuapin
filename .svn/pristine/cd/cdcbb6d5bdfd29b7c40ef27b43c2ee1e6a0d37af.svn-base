<template>
  <div class="dreward">
    <div class='dreward_navbtn fl'
         :class='[isReward?"dreward_navbtn-on":"dreward_navbtn-off"]'
         @click='nav'>培训信息</div>
    <div class='dreward_navbtn fl'
         :class='[isReward?"dreward_navbtn-off":"dreward_navbtn-on"]'
         @click='nav'>奖惩信息</div>

    <ul class="dreward_subnav">
      <li class="dreward_subnavitem"
          v-for="(item,index) in (isReward?reward.items:train.items)"
          :class='[(isReward?reward.selected:train.selected) === item ? "dreward_subnavitem-on" : "dreward_subnavitem-off" ]'
          @click="subnav(item)"
          :key="index">{{item}}</li>
    </ul>

    <ul class="dreward_trainacc"
        v-if="isReward">
      <li class="dreward_trainitem">
        <div class='dreward_trainkey'>累计培训次数</div>
        <div class='dreward_trainvalue'></div>
      </li>
      <li class="dreward_trainitem">
        <div class='dreward_trainkey'>累计培训时长</div>
        <div class='dreward_trainvalue'></div>
      </li>
      <li class="dreward_trainitem">
        <div class='dreward_trainkey'>培训通过率</div>
        <div class='dreward_trainvalue'></div>
      </li>
      <li class="dreward_trainitem">
        <div class='dreward_trainkey'>最近一次培训时间</div>
        <div class='dreward_trainvalue'></div>
      </li>
    </ul>

    <ul class="dreward_trainacc"
        v-else>
      <li class="dreward_trainitem">
        <div class="dreward_trainkey">累计{{train.selected}}次数</div>
        <div class="dreward_trainvalue"></div>
      </li>
      <li class="dreward_trainitem">
        <div class="dreward_trainkey">累计{{train.selected}}金额</div>
        <div class="dreward_trainvalue"></div>
      </li>
      <li class="dreward_trainitem">
        <div class="dreward_trainkey">最近一次{{train.selected}}时间</div>
        <div class="dreward_trainvalue"></div>
      </li>
      <li class="dreward_trainitem">
        <div class="dreward_trainkey">最近一次{{train.selected}}金额</div>
        <div class="dreward_trainvalue"></div>
      </li>
    </ul>

    <div class="dreward_detail">
      统计信息
    </div>

  </div>
</template>
<script>
export default {
  methods: {
    nav() {
      this.isReward = !this.isReward
      const type = this.isReward ? 'reward' : 'train'
      // reset
      this[type].selected = this[type].items[0]
    },
    subnav(item) {
      const type = this.isReward ? 'reward' : 'train'
      this[type].selected = item
    },
  },
  data: () => ({
    isReward: false,
    reward: {
      selected: '安全生产',
      items: ['安全生产', '职业道德', '业务知识', '操作规程'],
    },
    train: {
      selected: '奖励',
      items: ['奖励', '惩罚'],
    },
  }),
}
</script>
<style lang="scss" scoped>
.dreward {
  width: 790px;
  &_navbtn {
    text-align: center;
    vertical-align: middle;
    line-height: 30px;
    height: 30px;
    width: 165px;
    color: #89dddf;
    font-size: 18px;
    font-weight: bold;
    margin-right: 20px;
    &-on {
      background-color: rgba(129, 217, 229, 0.3);
    }
    &-off {
      background-color: rgba(129, 217, 229, 0.1);
    }
  }
  &_subnav {
    display: inline-block;
    width: 790px;
    margin-top: 20px;
  }
  &_subnavitem {
    float: left;
    width: 142px;
    height: 30px;
    box-sizing: border-box;
    font-size: 16px;
    line-height: 28px;
    text-align: center;
    vertical-align: middle;
    margin-right: 20px;
    &-on {
      color: #ffffff;
      background-color: rgba(5, 208, 235, 0.5);
      border: 1px solid rgba(5, 208, 235, 0.6);
    }
    &-off {
      color: #b5b5b5;
      background-color: rgba(5, 208, 235, 0.4);
      border: 1px solid rgba(5, 208, 235, 0.2);
    }
  }
  &_trainacc {
    margin-top: 20px;
    margin-right: -20px;
    display: inline-block;
  }
  &_trainitem {
    float: left;
    margin-right: 20px;
  }
  &_trainkey {
    width: 180px;
    color: #81d9e5;
    text-align: center;
    vertical-align: middle;
    line-height: 18px;
  }
  &_trainvalue {
    margin-top: 23px;
    width: 180px;
    line-height: 40px;
    height: 40px;
    text-align: center;
    vertical-align: middle;
    color: #ffffff;
    font-size: 22px;
    background-color: rgba(3, 139, 252, 0.4);
  }
  &_detail {
    
    color: #81d9e5;
    font-size: 16px;
    text-align: center;
    margin: 20px auto;
    width: 140px;
    height: 40px;
    background: url("../../../assets/driver/center_frame_down.png");
  }
}
</style>
