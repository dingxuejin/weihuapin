<template>
  <div class="selectx"
       :style="{width:width}">
    <div class="arrow"
         :class='{rotate:show}'></div>
    <div class="value"
         @click='show=!show'>{{data[num]}}</div>
    <div class="list"
         v-if='show'
         @mouseleave="closeList">
      <div v-for='(item,index) in data'
           @click='change(item,index)'
           :key='index'>{{item}}</div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['data', 'width'],
  data() {
    return {
      show: false,
      num: 0,
    }
  },
  methods: {
    change(item, index) {
      this.show = !this.show
      this.num = index
      this.$emit('up', item)
    },
    closeList() {
      this.show = false
    },
  },
}
</script>
<style lang="scss" scoped>
.selectx {
  color: #b5b5b5;
  height: 25px;
  box-sizing: border-box;
  border: 1px solid #81d9e5;
  cursor: pointer;
  text-indent: 10px;
  position: relative;
  .arrow {
    width: 15px;
    height: 8px;
    background: url("../assets/driver/select_arrow.png") no-repeat;
    position: absolute;
    top: 7px;
    right: 10px;
  }
  .rotate {
    transform: rotate(180deg);
    transition: transform 0.3s linear;
  }
  .value {
    line-height: 25px;
  }
  .list {
    width: 100%;
    height: 125px;
    overflow: hidden;
    overflow-y: scroll;
    border: 1px solid #81d9e5;
    border-top: 0px;
    background: #000000;
    position: relative;
    z-index: 1001;
  }
  .list::-webkit-scrollbar {
    display: none;
  }
  .list div:hover {
    background: rgba(129, 217, 229, 0.3);
  }
}
</style>
