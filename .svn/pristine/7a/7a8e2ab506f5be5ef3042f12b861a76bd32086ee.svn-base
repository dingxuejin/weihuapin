<template>
    <div class="home">
        <div class="home_top clearfix">
            <div class="home_top_title fl">
                <div class="home_top_title_list fl"></div>
                <title-view title="安全评分及排名"></title-view>
            </div>
            <!-- 安全评分及排名左表格 -->
            <div class="home_top_qysl fl">
                <securityscore-table></securityscore-table>
            </div>
            <!-- 企业/所有企业排名 -->        
            <div class="home_top_clsl fl">
                <enterprise-rank></enterprise-rank>
            </div>                   
        </div>
        <div class="home_bottom clearfix">
            <div class="home_bottom_title fl">
                <div class="home_bottom_title_list fl"></div>
                <title-view title="联网联控考核评分"></title-view>
            </div>
            <!-- 月度评分部分 -->
            <div class="home_bottom_left">
                <monthly-score></monthly-score>
            </div>
            <!-- 历史评分部分 -->
            <div class="home_bottom_mian">
                <history-score></history-score>
            </div> 
            <!-- 排名变化趋势部分 -->
            <div class="home_bottom_right">
                <change-trend></change-trend>
            </div>
            <div class="home_bottom_line"></div>
        </div>
    </div>
</template>
<script>
/* eslint-disable */
import TitleView from '../kanban/TitleView'
import SecurityscoreTable from '../services/SecurityScoreTable'
import EnterpriseRank from '../services/EnterpriseRank.vue'
import MonthlyScore from '../services/MonthlyScore.vue'
import HistoryScore from '../services/HistoryScore.vue'
import ChangeTrend from '../services/ChangeTrend.vue'
export default {
    components:{
        TitleView,
        SecurityscoreTable,
        EnterpriseRank,
        MonthlyScore,
        HistoryScore,
        ChangeTrend
    }
}
</script>
<style lang="scss" scoped>
.home{
    width:1861px;
    height:954px;
    margin: 15px;
    // box-sizing: border-box;
    background:rgba(3,139,252,0.2);
    &_top{
        height: 448px;
        &_title{
            width:100%;
            margin-top:24px;
            position: relative;
            &_list{
                background: rgba(3, 139, 252, 0.4);
                height:2px;
                width:1845px;
                margin-left:16px;
                margin-top:-12px;
            }
        }
        &_qysl{
            width: 1207px;
            height: 100%;
            // background:pink;
        }
        &_clsl{
            width: 654px;
            height: 100%;
            // background: bisque;
        }
    }
    &_bottom{
        height:516px;
        position: relative;
        margin-top:-15px;
        &_title{
            width:100%;
            position: absolute;
            top:24px;
            &_list{
                background: rgba(3, 139, 252, 0.4);
                height:2px;
                width:1845px;
                margin-left:16px;
                margin-top:-12px;
            }
        }
        &_left{
            width: 631px;
            height: 100%;
            position: absolute;
            top:0;
            left:0;
        }
        &_mian{
            width: 613px;
            height: 100%;
            position: absolute;
            top:0;
            left:631px;
        }
        &_right{
            width: 617px;
            height: 100%;
            position: absolute;
            top:0;
            right:0;
        }
        &_line{
            background: rgba(3, 139, 252, 0.4);
            height:2px;
            width:1824px;
            position: absolute;
            left: 37px;
            bottom: 5px;
        }
    }
}
</style>
