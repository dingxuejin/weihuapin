<template>
  <div class="aCarPeoplebox_wrap">
    <KeyValueSelect :data="newData()" width="100%" @select="change"></KeyValueSelect>
    <!-- <div class="nav"
         :class='{hover:num===index}'
         v-for='(item,index) in data'
         :key='index'
         @click='change(index)'>{{item}}</div> -->
    <div class="content">
      <loading :data="data1">
        <div v-for='(o,index) in data1'
             class="left"
             :key="index">
          <span>{{o.name}}</span>
          <div>{{o.value}}</div>
        </div>
      </loading>
    </div>
    <div class="chart_wrap">
      <slot></slot>
    </div>
  </div>
</template>
<script>
/* eslint-disable */
import KeyValueSelect from "../KeyValueSelect.vue"

export default {
  components: {
    KeyValueSelect,
  },
  props: ['data', 'data1'],
  data() {
    return {
      num: 0,
    }
  },
  methods: {
    change(item,x) {
      this.num = x
      this.$emit('up', x)
    },
    newData(){
      let arr=[]
      this.data && this.data.map((item,index)=>{
        arr.push({
          label:item,
          value:index
        }) 
      })
      return arr
    }
  }
  // mounted() {
  //   this.getPeople()
  //   console.log('从业人员信息', this.data1)
  // },
}
</script>
<style lang="scss" scoped>
.content {
  height: 182px;
  overflow-y: auto;
  clear: both;
}
.content::-webkit-scrollbar {
  width: 0px;
}
.aCarPeoplebox_wrap {
  height: 198px;
  position: relative;
  margin-left: 35px;
  .nav {
    float: left;
    width: 60px;
    height: 30px;
    box-sizing: border-box;
    border: 1px solid rgba(1, 191, 229, 1);
    background: rgba(1, 191, 299, 0.2);
    font-size: 14px;
    color: #b5b5b5;
    text-align: center;
    line-height: 30px;
    margin-left: 2px;
    cursor: pointer;
    margin-bottom: 10px;
  }
  .nav:nth-child(1) {
    margin-left: 30px;
  }
  .hover {
    background: rgba(1, 191, 299, 0.5);
    color: #ffffff;
  }
  .left {
    margin-top: 5px;
    clear: both;
    font-size: 16px;
    span {
      color: #89dddf;
    }
    div {
      margin-top: 5px;
      width: 120px;
      height: 20px;
      background: rgba(3, 139, 252, 0.4);
      font-weight: bold;
      color: #05d0eb;
      text-align: center;
      line-height: 20px;
    }
  }
  .chart_wrap {
    position: absolute;
    height: 180px;
    width: 180px;
    right: 20px;
    top: 40px;
  }
}
</style>
