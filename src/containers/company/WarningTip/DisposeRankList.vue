<template>
    <div class="normal">
        <div class="line"></div>
        <h4>处理条数排名</h4>
        <div class="line"></div>
        <div class="date_select">
            <span>统计周期</span>
            <div>
                <key-value-select width="100px" :data="yearData" defaultValue="2018年" @select='select("year",$event)'>
                </key-value-select>
            </div>
            <div>
                <key-value-select width='80px' :data='monthData' @select='select("month",$event)'> 
                </key-value-select>
            </div>
            <!-- <div v-if="selectParams.month!=null">
                <key-value-select width='80px' :data='dayData' @select='select("day",$event)'> 
                </key-value-select>
            </div> -->
        </div>
        <header>
            <div style="width:80px">姓名</div>
            <div style="width:270px">处理单数</div>
        </header>
        <ul class="list">
            <li v-for="(item,index) in HandlingRankingData" :key="index">
                <div class="list_name" style="width:80px">{{item.monitor}}</div>
                <div class="list_progress over">
                    <p :style="{width:(item.alarm_quantity_handled/max)*200+'px'}"></p>
                    <span :title="item.alarm_quantity_handled">{{item.alarm_quantity_handled}}</span>
                </div>
            </li>
        </ul>
    </div>
</template>
<script>
/* eslint-disable */
import {mapState,mapActions} from 'vuex'
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
        monthData: [{ label: '全部', value: null }, ...month],
        dayData: [{ label: '全部', value: null }, ...day],
        selectParams:{
            year:2018,
            month:null,
            day:null
        },
        max:0,
        data:[],
    }
  },
  computed:{
      ...mapState('WarningTipStore',['HandlingRankingData']),
      ...mapState('headerMsgStore',['selectedEntity']),
  },
  methods: {
    ...mapActions('WarningTipStore',['getHandlingRanking']),
    select(e,v) {
        this.selectParams[e]=v.value
        let arg={
            entity_id:this.selectedEntity,
            year:this.selectParams.year
        }
        if(e=='month' && v!=null){
            arg.month=v.value
        }else if(e=='year' && v!=null){
            arg.month=this.selectParams.month
        }
        this.getHandlingRanking(arg)
    },
    updateHandlingRankingData(){
      let max=0
      this.HandlingRankingData.map(o=>{
          if(o.alarm_quantity_handled){
              max=o.alarm_quantity_handled
          }
      })
      this.max=max
    }
  },
  watch:{
      HandlingRankingData(){
        this.updateHandlingRankingData()
      }
  },
  created(){
      this.updateHandlingRankingData()
  }
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
        height: 160px;
        overflow-y: auto;
        li{
            display: flex;
            justify-content: flex-start;
            color: #92bac0;
            height: 24px;
            line-height: 24px;
            div{
                border: 1px solid #05D0EB ;
                background-color: #095471;
                box-sizing: border-box;
            }
            .list_name{
                text-align: center;
                margin: 0 5px;
            }
            .list_progress{
                width:258px;
                p{
                    display: inline-block;
                    height: 10px;
                    width: 30px;
                    background-color: #6fdae1;
                    border-radius: 2px;
                    margin: 0 3px;
                    margin-bottom: 2px;
                }
            }
        }
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
