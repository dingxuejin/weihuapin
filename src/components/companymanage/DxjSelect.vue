<template>
  <div class="selectx"
       :style="{width,height}"
       v-if="data[num]">
    <div class="value flex-between height-full"
         @click='show=!show'>
      <div class="value-label height-full flex-start"
           :title="defaultValue1 || data[num].label">
        <div> {{defaultValue1 || data[num].label}}</div>
      </div>
      <div class="arrow"
           :class='{rotate:show}'></div>
    </div>

    <div class="list"
         :style="{top}"
         v-if='show'
         @mouseleave="closeList">
      <div v-for='(item,index) in data'
           @click='change(item,index)'
           :key='index'
           :title="item.label">{{item.label}}</div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    data: {},
    width: { default: '100%' },
    defaultValue: {},
    height: { default: '100%' },
  },
  computed: {
    top() {
      const topValue = `calc( ${this.height} + 2px )`
      return topValue
    },
  },
  data() {
    return {
      show: false,
      num: 0,
      defaultValue1: this.defaultValue,
    }
  },
  methods: {
    change(item, index) {
      this.defaultValue1 = null
      this.show = !this.show
      this.num = index
      this.$emit('up', item.value)
      this.$emit('select', item, index)
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

  .rotate {
    transform: rotate(180deg);
    transition: transform 0.3s linear;
  }
  .value {
    padding: 0 5px;
    .arrow {
      width: 15px;
      height: 8px;
      background: url("../../assets/driver/select_arrow.png") no-repeat;
      top: 7px;
      right: 10px;
      pointer-events: none;
    }
    .value-label {
      width: calc(100% - 20px);
      div {
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
      }
    }
  }
  .list {
    width: 100%;
    max-height: 125px;
    overflow: hidden;
    overflow-y: scroll;
    border: 1px solid #81d9e5;
    border-top: 0px;
    background: #000000;
    position: absolute;
    left: -1px;
    z-index: 1001;
    padding-bottom: 5px;
    div {
      overflow: hidden;
      white-space: nowrap;
      text-overflow: ellipsis;
      line-height: 25px;
    }
  }
  .list::-webkit-scrollbar {
    display: none;
  }
  .list div:hover {
    background: rgba(129, 217, 229, 0.3);
  }
  .height-full {
    height: 100%;
  }
}
</style>
