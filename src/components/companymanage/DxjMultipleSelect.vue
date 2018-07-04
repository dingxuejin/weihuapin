<template>
  <div class="multipleSelect"
       :style="{width,height}">
    <div class="flex-between multiple-result-container"
         @click.stop="show=!show"
         :title="result">
      <div class="multiple-result">
        {{result?result:'未选择'}}
      </div>
      <div class="arrow"
           :class='{rotate:show}'></div>
    </div>
    <transition name="fade">
      <div class="multiple-options"
           v-if="show">
        <div class="flex-start multiple-label"
             :style="{height}"
             v-for="(item,key) in multipleMonthOption"
             :key="key"
             @click="change(item,key)"
             :title="item.label">
          <div class="checked"
               v-if="item.checked"></div>
          <div class="unchecked"
               v-if="!item.checked"></div>
          <div>{{item.label}}</div>
        </div>
      </div>
    </transition>

  </div>
</template>
<script>
export default {
  name: 'DxjMultipleSelect',
  //   data：格式[{label:'aaa',value:'111'},{label:'bbb',value:'222'}]
  // width:格式 100px
  // height:格式 100px
//   multipleSelect返回选择中的value 格式["01","02"]
  props: ['data', 'width', 'height'],
  data() {
    return {
      show: false,
      resultOptions: null,
    }
  },
  methods: {
    change(item, index) {
      const options = this.data
      options[index].checked = !item.checked
      this.resultOptions = null
      this.resultOptions = options
      if (options && options.length > 0) {
        const valueArr = options
          .filter(val => val.checked === true)
          .map(val => val.value)
        this.$emit('multipleSelect', valueArr)
      }
    },
  },
  computed: {
    multipleMonthOption() {
      let monthOptions
      if (this.resultOptions) {
        monthOptions = this.resultOptions
      } else {
        monthOptions = this.data
      }
      if (monthOptions && monthOptions.length > 0) {
        const newMonthOptions = monthOptions.map((val) => {
          const newVal = val
          if (newVal.checked === true) {
            newVal.checked = true
          } else {
            newVal.checked = false
          }
          return newVal
        })
        return newMonthOptions
      }
      return []
    },
    result() {
      let options
      if (this.resultOptions) {
        options = this.resultOptions
      } else {
        options = this.data
      }
      const newResult = options
        .filter(val => val.checked === true)
        .map(val => val.label)
      const result = newResult.join('、')
      return result
    },
  },
}
</script>
<style scoped>
.fade-enter {
  transform: translateY(-30px);
  opacity: 0;
}
.fade-enter-active {
  transition: all 500ms ease;
}
.multipleSelect {
  width: 100px;
  height: 30px;
  position: relative;
}

.multiple-result-container {
  border: 1px solid #81d9e5;
  box-sizing: border-box;
  width: 100%;
  height: 100%;
  padding: 0 10px;
}
.multiple-result {
  width: calc(100% - 20px);
  color: #fff;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.multiple-options {
  width: 100%;
}
.multiple-label {
  background: #000;
  box-sizing: border-box;
  border: 1px solid #81d9e5;
  margin: 2px 0;
  height: 30px;
  font-size: 14px;
  color: #fff;
}

.unchecked,
.checked {
  width: 15px;
  height: 15px;
  border: 1px solid #fff;
  box-sizing: border-box;
  margin: 0 10px;
}
.checked {
  background: #fff;
}
.arrow {
  width: 15px;
  height: 8px;
  background: url("../../assets/driver/select_arrow.png") no-repeat;
  top: 7px;
  right: 10px;
  pointer-events: none;
}
.rotate {
  transform: rotate(180deg);
  transition: transform 0.3s linear;
}
</style>



