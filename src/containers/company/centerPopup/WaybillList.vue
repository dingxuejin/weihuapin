<template>
    <div class="normal">
        <div class="headerBtn" @click="showList=!showList">
            <p>运单进度列表</p>
        </div>
        <div class="content" v-if="showList">
            <header>
                <p>运单编号</p>
                <p>运单进度</p>
            </header>
            <ul class="list">
                <li v-for="(v,k) in WaybillProgressListData" :key="k">
                    <div class="over" :title="v.waybill_id">{{v.waybill_id}}</div>
                    <div class="list_step">
                        <span 
                            :class="item.waybill_status_code<=v.waybill_status_code?'reach':''" 
                            v-for="(item,index) in WaybillProgressList" :key="index">
                            {{item.waybill_status}}
                        </span>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</template>
<script>
import { mapState } from 'vuex'

export default {
  data() {
    return {
      showList: false,
    }
  },
  computed: {
    ...mapState('centerPopup', ['WaybillProgressList', 'WaybillProgressListData']),
  },
}
</script>
<style lang="scss" scoped>
.normal{
    position: absolute;
    bottom: 260px;
    right: 35px;
    .headerBtn{
        width: 160px;
        padding: 10px;
        background-color: #000;
        border: 2px solid rgba(5, 208, 235, 0.8);
        cursor: pointer;
        p{
            padding: 3px 0px;
            background-color:rgba(5, 208, 235, 0.6);
            text-align: center;
        }
    }
    .content{
        padding: 10px;
        background-color: #000;
        border: 2px solid rgba(5, 208, 235, 0.8);
        margin-top: 5px;
        header{
            display: flex;
            justify-content:space-between;
            p{
                border: 1px solid #81D9E5;
                height: 30px;
                line-height: 30px;
                text-align: center;
                padding: 0 4px;
            }
            p:first-child{
                flex: 0 0 150px;
                margin: 0 5px;

            }
            p:last-child{
                width:100%;
                min-width: 200px;
            }
        }
    }
    .list{
        max-height: 200px;
        min-width: 390px;
        overflow-y: auto;
        li{
            display: flex;
            justify-content:space-between;
            height: 30px;
            padding-top: 10px;
            > div{
                background-color: #073137;
                height: 28px;
                line-height: 28px;
                padding: 3px 5px;
                text-align: center;
            }
            div:first-child{
                flex: 0 0 150px;
                margin: 0 5px;
            }
            .list_step{
                height: 28px;
                width: 100%;
                min-width: 200px;
                span{
                    padding: 0px 5px;
                    background-color: #89dddf;
                    margin: 0 3px;
                    border-radius: 5px;
                }
                .reach{
                    background-color: #e75029;
                }
            }
            .list_step::-webkit-scrollbar{
                width: 0px;
            }
        }
    }
    .list::-webkit-scrollbar {
        width: 5px;
        background: rgba(0,0,0,0);
    }
    .list::-webkit-scrollbar-thumb {
        background:  #05D0EB;
        border-radius: 5px;
    }
}
</style>
