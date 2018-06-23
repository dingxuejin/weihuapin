<template>
    <div class="trend">
        <div class="header">
            <div :class="{hover:show}" @click='change'>
                <span>{{name1}}</span>
                <!-- <div @click=''></div> -->
            </div>
            <div :class="{hover:!show}" @click='change'>
                <span>{{name2}}</span>
                <!-- <div @click=''></div> -->
            </div>
        </div>
        <div class="change">
            <div>统计周期</div>
            <div>
                <hselect width='100px' :data='["2017年","2016年","2015年","2014年"]' ></hselect>
            </div>
            <div>
                <hselect width='70px' :data='["-","1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"]' ></hselect>
            </div>
            <div>{{header}}</div>
            <div>
                <hselect width='100px' :data='["area1","area2","area3"]' ></hselect>
            </div>
        </div>
        <div class="echart">
            <slot></slot>
        </div>
    </div>
</template>

<script>
    import htitle from './title'
    import hselect from './select'

    export default{
      props: ['name1', 'name2'],
      components: {
        htitle,
        hselect,
      },
      data() {
        return {
          show: true,
          header: '区域选择',
        }
      },
      methods: {
        change() {
          this.show = !this.show
          if (this.show) {
            this.header = '区域选择'
          } else {
            this.header = '时段选择'
          }
        },
      },
    }

</script>

<style lang="scss" scoped>
    .trend{
        width: 100%;
        height: 240px;
        .header{
            height: 25px;
            div:nth-child(1){
                margin-right: 10px;
            }
            div{
                width: 210px;
                text-indent: 20px;
                height: 25px;
                line-height: 25px;
                float: left;
                background: rgba(129,217,299,.1);
                position: relative;
                font-size: 16px;
                color: #89dddf;
                cursor: pointer;
                div{
                    position: absolute;
                    width:20px;
                    height: 6px;
                    background:url('../../assets/driver/drill_icon_on.png') no-repeat;
                    top:8px;
                    right:10px;
                    cursor: pointer;
                }
            }
            .hover{
                background: rgba(129,217,299,.3);
            }
        }
        .change{
            margin-top: 10px;
            margin-bottom: 10px;
            height: 25px;
            div{
                float: left;
                height:25px;
                color:#b5b5b5;
            }
            div:nth-child(1){
                line-height: 25px;
            }
            div:nth-child(2){
                width: 100px;
                margin-left: 10px;
                margin-right: 5px;
            }
            div:nth-child(3){
                width: 70px;
            }
            div:nth-child(4){
                line-height: 25px;
                margin: 0 8px;
            }
            div:nth-child(5){
                width: 100px;
            }
        }
        .echart{
            clear: both;
            height: 170px;
            background: lightblue;
        }
    }
</style>