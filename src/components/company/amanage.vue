<template>
  <div class="box">
    <div class="title">
      <div :class="{hover:show}"
           @click='toggleShow("y")'>运单量</div>
      <div :class="{hover:!show}"
           @click='toggleShow("z")'>周转量</div>
    </div>
    <div class="select">
      <!-- <key-value-select :data='monthOption'
                        width='100px'
                        @select='selectMonth'></key-value-select> -->
      <key-value-select :data='yearOption'
                        width='100px'
                        @select='selectYear'></key-value-select>
      <div>统计周期</div>
    </div>
    <div class="chart">
      <slot name='turnover'
            v-if="!show"></slot>
      <slot name='waybill'
            v-if="show"></slot>
    </div>
  </div>
</template>
<script>
import KeyValueSelect from '../../components/KeyValueSelect'
import Dictionary from '../../util/dictionary'

const { date: { year } } = Dictionary
export default {
  components: {
    KeyValueSelect,
  },
  methods: {
    selectYear(item) {
      this.year = item.value
      this.$emit('select', {
        year: this.year,
        // month: this.month,
        type: 'Y',
      })
    },
    // selectMonth(item) {
    //   this.month = item.value
    //   this.$emit('select', {
    //     // year: this.year,
    //     month: this.month,
    //     type: 'M',
    //   })
    // },
    toggleShow(type) {
      // console.log('type:', type)
      if (type === 'y') {
        this.show = true
      } else {
        this.show = false
      }
    },
  },
  data() {
    return {
      show: true,
      yearOption: [{ label: '全部', value: null }, ...year],
      // monthOption: [{ label: '全部', value: null }, ...month],
      year: '',
      // month: '',
    }
  },
}
</script>

<style lang="scss" scoped>
.box {
  margin-left: 30px;
  height: 238px;
  .title {
    height: 25px;
    div {
      width: 180px;
      height: 25px;
      line-height: 23px;
      text-align: center;
      float: left;
      box-sizing: border-box;
      font-size: 14px;
      color: #b5b5b5;
      border: 1px solid rgba(0, 191, 229, 1);
      background-color: rgba(0, 191, 229, 0.2);
      cursor: pointer;
    }
    .hover {
      background-color: rgba(0, 191, 229, 0.5);
      color: #ffffff;
    }
    div:nth-child(1) {
      margin-right: 10px;
    }
  }
  .select {
    height: 26px;
    width: 370px;
    margin-top: 10px;
    div {
      float: right;
      line-height: 26px;
      margin-right: 10px;
    }
    select {
      float: right;
      height: 26px;
      width: 80px;
      box-sizing: border-box;
      outline: none;
      border: 1px solid rgba(0, 191, 229, 1);
      background: #000000;
      color: #d5d5d5;
      appearance: none;
      -moz-appearance: none;
      -webkit-appearance: none;
      background: url("../../assets/driver/select_arrow.png") no-repeat scroll
        calc(100% - 5px) center #000000;
      padding-left: 3px;
    }
    select:nth-child(2) {
      margin-right: 10px;
    }
  }
  .chart {
    width: 370px;
    height: 170px;
    // background: lightblue;
    margin-top: 10px;
  }
}
</style>
