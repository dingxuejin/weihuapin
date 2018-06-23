<template>
    <div class="home">
        <div class="home_top clearfix">
            <!-- 企业数量统计 -->
            <div class="home_top_qysl fl">
                <CompanyCountStatistics></CompanyCountStatistics>
            </div>
            <!-- 车辆数量统计 -->
            <div class="home_top_clsl fl">
                <CarCountStatistics></CarCountStatistics>
            </div>
            <!-- 数据统计 -->
            <div class="home_top_sjtj fl">
                <DataTransferStatistics></DataTransferStatistics>
            </div>
        </div>
        <div class="home_main clearfix">
            <div class="home_main_left fl">
                <!-- 上线统计部分 -->
                <div class="home_main_left_item">
                    <OnlineStatistics></OnlineStatistics>
                </div>
                <!-- 预警统计部分 -->
                <div class="home_main_left_item">
                    <WarningStatistics></WarningStatistics>
                </div>
                <!-- 跨域统计部分 -->
                <div class="home_main_left_item  " style="height:230px">
                    <CrossStatistics></CrossStatistics>
                </div>
            </div>
            <div class="home_main_right fl">
                <!-- 维度统计部分 -->
                <div class="home_main_right_item">
                    <VeidooStatistics></VeidooStatistics>
                </div>
                <!-- 异地经营统计部分 -->
                <div class="home_main_right_bottom">
                    <RemoteStatistics></RemoteStatistics>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
/* eslint-disable */
import CompanyCountStatistics from './CompanyCountStatistics.vue'
import CarCountStatistics from './CarCountStatistics.vue'
import DataTransferStatistics from './DataTransferStatistics.vue'
import OnlineStatistics from './OnlineStatistics.vue'
import WarningStatistics from './WarningStatistics.vue'
import CrossStatistics from './CrossStatistics.vue'
import VeidooStatistics from './VeidooStatistics.vue'
import RemoteStatistics from './RemoteStatistics.vue'
export default {
    components:{
        CompanyCountStatistics,
        CarCountStatistics,
        DataTransferStatistics,
        OnlineStatistics,
        WarningStatistics,
        CrossStatistics,
        VeidooStatistics,
        RemoteStatistics
    }
}
</script>
<style lang="scss" scoped>
.home{
    // width: 1920px;
    // height: 980px;
    padding-top: 10px;
    &_top{
        height: 240px;
        &_qysl{
            width: 390px;
            height: 100%;
        }
        &_clsl{
            width: 390px;
            height: 100%;
        }
        &_sjtj{
            width: 1140px;
            height: 100%;
        }
    }
    &_main{
        // height:740px;
        &_left{
            width: 1140px;
            height: 100%;
            &_item:nth-child(1){
                height: 240px;
            }
           &_item:nth-child(2){
                height: 240px;
            }
            &_item:nth-child(3){
                height: 230px;
            }
        }
        &_right{
            width: 780px;
            height: 100%;
            &_item{
                height: 240px;
            }
            &_bottom{
                height: 480px;
            }
        }
    }
}
</style>
