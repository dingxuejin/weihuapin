<template>
    <div class="lineRank">
        <div class="lineRank-titleCon clearfix">
            <div class="lineRank-title lineRank-rank fl">排名</div>
            <div class="lineRank-title lineRank-car fl">车次</div>
            <div class="lineRank-title lineRank-order fl">运单数量</div>
            <div class="lineRank-title lineRank-sum fl">金额</div>           
            <div class="lineRank-title lineRank-line fl">线路</div>
        </div>

        <div class="lineRank-content">
            <div class="lineRank-itemConCon eleScrollBar">
                <div v-for="(item,index) in data" class="lineRank-itemCon">
                    <div class="lineRank-item fl">{{'#'}}{{index<9 ? '0'+(index+1) : (index+1)}}</div>
                    <div class="lineRank-item fl">{{item.carNum}}</div>
                    <div class="lineRank-item fl">{{item.order_num}}</div>
                    <div class="lineRank-item fl">{{item.sum}}</div>
                    <div class="lineRank-item fl">{{item.lineName}}</div>
                </div>
            </div>
            
        </div>

    </div>
</template>

<script type="text/javascript">
export default {
  name: 'lineRank',
  components: {},
  props: ['data'],
  data() {
    return {}
  },
}
</script>

<style lang="scss" scoped>
    .lineRank{
        width:530px;
        height: 125px;
        overflow: hidden;

        // background: green;
    }
    .lineRank-titleCon{
        height: 30px;
        box-sizing: border-box;
        text-align: center;
        // background: pink;
    }
    .lineRank-title{
        width:60px;
        height: 30px;
        overflow: hidden;
        box-sizing: border-box;
        border:1px solid #81d9e5;
        color:#b5b5b5;
        font-size: 16px;
        line-height: 28px;
    }
    .lineRank-title:nth-child(n+2){
        margin-left:10px;
    }

    // 表格部分
    .lineRank-content{
        height: 85px;
        overflow: hidden;
        margin-top:10px;
        // background: blue;
    }
    .lineRank-car{
        width:100px;
    }
    .lineRank-order{
        width:110px;
    }
    .lineRank-sum{
        width:100px;
    }
    .lineRank-line{
        width:120px;
    }

    // 表格内容
    .lineRank-itemConCon{
        width:100%;
        height: 100%;
        overflow-y: auto;
        // background: cyan;
    }
    .lineRank-itemCon{
        width:520px;
        height: 25px;
        overflow: hidden;
        // background: green;
    }
    .lineRank-itemCon:nth-child(n+2){
        margin-top:5px;
    }

    // 定义滚动条
    .eleScrollBar::-webkit-scrollbar{
        width: 5px;
        height: 100%;
        // border: 1px solid grey;
        background:url('../../../assets/company/strip_scrollbg.png');
    }

    .eleScrollBar::-webkit-scrollbar-thumb{
        background:#05d0eb;
    }

    .lineRank-item{
        width:60px;
        height: 25px;
        overflow: hidden;
        box-sizing: border-box;
        color:#fff;
        font-size: 14px;
        text-align:center;
        line-height: 23px;
        border:1px solid #81d9e5;
        background: rgba(5,208,235,0.5);
        
    }
    .lineRank-item:nth-child(n+2){
        margin-left:10px;
    }
    .lineRank-item:nth-child(2){
        width:100px;
    }
    .lineRank-item:nth-child(3){
        width:110px;
    }
    .lineRank-item:nth-child(4){
        width:100px;
    }
    .lineRank-item:nth-child(5){
        width:110px;
    }

    // 第二行样式
    .lineRank-itemCon:nth-child(n+2) .lineRank-item{
        border:1px solid #81d9e5;
        background: rgba(5,208,235,0.2);
    }


</style>