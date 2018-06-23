<template>
  <div class="trend">
    <div class="header">
      <span>事故浏览</span>
      <div class="btn"></div>
    </div>
    <div class="title">
        <div>事故时间</div>
        <div>事故等级</div>
        <div>事故地点</div>
    </div>
    <ul>
        <li v-for='(item,index) in list' :key="index">
            <div class="over">{{item.time}}</div>
            <div class="over">{{item.jb}}</div>
            <div>{{item.place}}</div>
        </li>
    </ul>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        list: [{ time: '2017-01-12', jb: '特大', place: 'area1' }, { time: '2017-01-12', jb: '特大', place: 'area1' }, { time: '2017-01-12', jb: '特大', place: 'area1' }, { time: '2017-01-12', jb: '特大', place: 'area1' }, { time: '2017-01-12', jb: '特大', place: 'area1' }, { time: '2017-01-12', jb: '特大', place: 'area1' }],
      }
    },
  }

</script>

<style lang="scss" scoped>
  .trend {
    width: 100%;
    height: 240px;
    .header {
      width: 280px;
      height: 25px;
      background: rgba(129,217,299,.3);
        position: relative;
        font-size: 16px;
        color: #89dddf;
        line-height:25px;
        text-indent:20px;
      .btn{
            float: left;
            position: absolute;
            width:20px;
            height: 6px;
            background:url('../../../assets/driver/drill_icon_on.png') no-repeat;
            top:8px;
            right:10px;
            cursor: pointer;
        }
    }
    .title{
            height: 30px;
            margin-bottom:10px;
            margin-top:10px;
            div{
                float: left;
                height:30px;
                margin-left:10px;
                box-sizing:border-box;
                text-align:center;
                line-height:28px;
                border:1px solid #81d9e5;
                color:#b5b5b5;
                font-size:16px;
            }
            div:nth-child(1){
                width: 150px;
                margin-left: 0px;
            }
            div:nth-child(2){
                width: 120px;
            }
            div:nth-child(3){
                width: 140px;
            }
        }
        ul::-webkit-scrollbar {
            background: rgba(0, 191, 229, 0.5);
            width: 6px;
        }
        ul::-webkit-scrollbar-thumb {
            background: rgba(0, 191, 229, 1);
        }
        ul{
            list-style: none;
            height:145px;
            overflow-y: scroll;
            color: #b5b5b5;
            li{
                margin-bottom:5px;
                height: 25px;
                cursor: pointer;
                div{
                    float: left;
                    height: 25px;
                    box-sizing: border-box;
                    line-height: 23px;
                    text-align: center;
                    border: 1px solid rgba(0, 191, 229, 1);
                    background: rgba(0, 191, 229, 0.2);
                }
                div:nth-child(1){
                    width:150px;
                    margin-right: 10px;
                }
                div:nth-child(2){
                    width:120px;
                    margin-right: 10px;
                }
                div:nth-child(3){
                    width: 124px;
                }
            }
            li:hover div{
                background: rgba(0, 191, 229, 0.5);
                color:#ffffff;
            }
        }

  }

</style>
