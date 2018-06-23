<template>
    <div class="normal">
        <div class="line"></div>
        <h4>处理条数排名</h4>
        <div class="line"></div>
        <div class="date_select">
            <span>统计周期</span>
            <div>
                <key-value-select width="100px" :data="yearData" defaultValue="2017年" @select='select("year",$event)'>
                </key-value-select>
            </div>
            <div>
                <key-value-select width='80px' :data='monthData' @select='select("month",$event)'> 
                </key-value-select>
            </div>
            <div>
                <key-value-select width='80px' :data='dayData' @select='select("day",$event)'> 
                </key-value-select>
            </div>
        </div>
        <header>
            <div style="width:60px">姓名</div>
            <div style="width:270px">处理单数</div>
        </header>
        <ul class="list">
            <li>
                <div class="list_name">哈哈哈</div>
                <div></div>
            </li>
        </ul>
    </div>
</template>
<script>
import KeyValueSelect from '@/components/KeyValueSelect'
import Dictionary from '@/util/dictionary'

const { date: { year, month, day } } = Dictionary
export default {
  components: {
    KeyValueSelect,
  },
  data() {
    return {
      yearData: year,
      monthData: [{ label: '全年', value: null }, ...month],
      dayData: [{ label: '全部', value: null }, ...day],
    }
  },
  methods: {
    select() {

    },
  },
}
</script>
<style lang="scss" scoped>
.normal{
    position: absolute;
    bottom:0px;
    left: 10px;
    right: 10px;
    h4{
        padding:5px 10px ;
    }
    header{
        display: table;
        > div{
            display: table-cell;
            border: 1px solid #81D9E5;
            height: 30px;
            line-height: 30px;
            text-align: center;
        }
    }
    .list{
        height: 220px;
        overflow-y: auto;
    }
}
.list::-webkit-scrollbar{
    width: 0px;
}
.date_select{
    display: table;
    > div{
        display: table-cell;
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
