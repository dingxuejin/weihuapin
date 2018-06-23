<template>
    <div class="normal">
        <header>
            <div>
                证书名称
            </div>
            <div class="header_select">
                <p>剩余时间</p>
                <key-value-select width='100px' :data="selectData" @select='select($event)'> 
                </key-value-select>
            </div>
        </header>
        <ul class="list">
            <li v-for="(item,index) in dataList" :key="index">
                <div class="list_item">
                    <div class="over">{{item.certificate_type}}</div>
                    <div v-if="item.expiry_reminder_days_code==1" class="item_red">小于10天</div>
                    <div v-else-if="item.expiry_reminder_days_code==2" class="item_yellow">小于15天</div>
                    <div v-else-if="item.expiry_reminder_days_code==3" class="item_yellow">小于20天</div>
                    <div v-else-if="item.expiry_reminder_days_code==4" class="item_yellow">小于30天</div>
                    <div v-else-if="item.expiry_reminder_days_code==5" class="item_green">小于90天</div>
                    <div v-else-if="item.expiry_reminder_days_code==6" class="item_green">大于90天</div>
                </div>
                <div class="line"></div>
            </li>
        </ul>
    </div>
</template>
<script>
import KeyValueSelect from '@/components/KeyValueSelect'

export default {
  components: {
    KeyValueSelect,
  },
  props: ['data'],
  data() {
    return {
      selectData: [{
        value: 0,
        label: '全部',
      }, {
        value: 1,
        label: '小于10天',
      }, {
        value: 2,
        label: '小于15天',
      }, {
        value: 3,
        label: '小于20天',
      }, {
        value: 4,
        label: '小于30天',
      }, {
        value: 5,
        label: '小于90天',
      }, {
        value: 6,
        label: '大于90天',
      }],
      dataList: this.data,
    }
  },
  watch: {
    data() {
      this.dataList = this.data
    },
  },
  methods: {
    select(v) {
        /* eslint-disable */
      if (v.value != 0) {
        this.dataList = this.data.filter(o => o.expiry_reminder_days_code == v.value)
      } else {
        this.dataList = this.data
      }
    },
  },
}
</script>
<style lang="scss" scoped>
.list::-webkit-scrollbar{
    width: 0px;
}
.list{
    max-height: 300px;
    overflow-y: auto;
}
.normal{
    header{
        display: flex;
        justify-content: space-between;
        padding-top: 10px;
        div{
            width: 165px;
            height: 28px;
            line-height: 28px;
            border: 1px solid rgba(5,208,235,0.50);
            // box-sizing: border-box;
            padding: 3px 5px;
        }
        div:first-child{
            text-align: center;
            margin-right: 10px;
        }
        .header_select{
            width: 200px;
            display: flex;
            justify-content: space-between;
        }
    }
}
.list_item{
    display: flex;
    width: 100%;
    justify-content: space-between;
    div{
        width: 165px;
        height: 24px;
        line-height: 24px;
        margin: 5px 0;
        text-align: center;
        padding: 0 10px;
        box-sizing: border-box;
        background-color: rgba(81,81,81,0.50);
    }
    div:first-child{
        background-color:  rgba(5,208,235,0.20);
        margin-right: 10px;
    }
    div:last-child{
        width: 200px;
    }
    .item_green{
        background-color: rgba(10,160,2,0.50);
    }
    .item_red{
        background-color: rgba(196,2,39,0.50);
    }
    .item_yellow{
        background-color:  rgba(196,191,5,0.50);;
    }
}
.line{
    height: 2px;
    background-color:rgba(129,217,229,0.5) ;
    position: relative;
}
.line:after{
    content: "";
    display: block;
    position: absolute;
    width: 20px;
    height: 2px;
    left: 0px;
    background-color: #81D9E5 ;
}
.line:before{
    content: "";
    display: block;
    position: absolute;
    width: 20px;
    height: 2px;
    right: 0px;
    background-color: #81D9E5 ;
}
</style>
