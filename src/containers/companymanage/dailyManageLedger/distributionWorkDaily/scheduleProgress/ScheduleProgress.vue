<template>
  <div class="scheduleProgress_contend">
      <div class="topPart">
          <div class="date">
              <div>日期</div>
              <div>
                  <div></div>
                  {{selectedYear}}/{{selectedMonth}}/{{selectedDay}}
              </div>
          </div>
          <div class="statisticTerm">
              <div>统计周期</div>
              <div>
                  <div></div>
                  {{distribution.stat_start_date}}-{{distribution.stat_end_date}}
              </div>
          </div>
          <div class="charger">
              <div>负责人</div>
              <div>
                  <div></div>
                  {{distribution.manager}}
              </div>
          </div>
      </div>
      <div class="bottomPart">
          <div class="bottom_left"><div>运营情况</div></div>
          <div class="bottom_right">
              <div class="bottom_right_top">
                  <div class="bottom_right_top_left">
                      <div><div>当日业务趟次（趟）</div> <div><div> </div>{{distribution.day_times}}</div></div>
                      <div><div>明日计划趟次（趟）</div> <div><div> </div>{{distribution.next_day_times}}</div></div>
                      <div><div>单车平均运营趟次（趟）</div> <div><div> </div>{{distribution.average_times}}</div></div>
                      <div><div>单车月度趟次指标（趟）</div> <div><div> </div>{{distribution.average_month_plan_times}}</div></div>
                      <div><div>单车平均重驶里程（公里）</div> <div><div> </div>{{distribution.average_heavy_km}}</div></div>
                      <div><div>单车平均重驶里程指标（公里）</div> <div><div> </div>{{distribution.average_month_plan_heavy_km}}</div></div>
                  </div>
                  <div class="bottom_right_top_right">
                      <div><div>当月累计业务趟次（趟）</div> <div><div> </div>{{distribution.month_total_times}}</div></div>
                      <div><div>当月计划业务趟次（趟）</div> <div><div> </div>{{distribution.month_plan_times}}</div></div>
                      <div><div>单车趟次完成百分比（%）</div> <div><div> </div>{{distribution.average_finished_percentage}}</div></div>
                      <div><div>单车重驶完成百分比（%）</div> <div><div> </div>{{distribution.average_finished_heavy_percentage}}</div></div>
                  </div>
              </div>
              <div class="bottom_right_bottom">
                <div>当日业务<br>描述</div>
                <div>
                    <div></div>
                    {{distribution.business_remark}}
                </div>
              </div>
          </div>
      </div>
  </div>
</template>

<script type="text/javascript">
import { mapState } from 'vuex'

export default {
  name: '',
  components: {
  },
  computed: {
    ...mapState('DailyManageLedger', ['distribution', 'selectedYear', 'selectedMonth', 'selectedDay']),
  },
  methods: {

  },
  data() {
    return {

    }
  },
}
</script>

<style lang="scss" scoped>
.scheduleProgress_contend{
    width: 100%;
    height: 100%;
    .topPart{
        width: 100%;
        height: 53px;
        div{
            float: left;
            background: rgba(9,122,206,0.2)
        }
        .date{
            width: 163px;
            height: 100%; 
            padding: 6px 0;
            box-sizing: border-box;
            div{float: left;}
            div:nth-child(1){
                width: 45px;
                height: 100%; 
                text-align: center;
                line-height: 45px;
                font-size: 16px;
                color: #89DDDF;
            }
            div:nth-child(2){
                width: 114px;
                height: 40px;
                border: solid 1px  #05D0EB;
                padding: 13px 9px;
                box-sizing: border-box;
                font-size: 12px;
                color: #fff;
                div{
                    display: inline-block;
                    width: 10px;
                    height: 10px;
                    transform: rotate(45deg);
                    background: #05D0EB;
                    margin-right: 6px;
                }
            }
        }
        .statisticTerm{
            width: 226px;
            height: 100%; 
            margin-left: 2px;
            padding: 6px 0;
            box-sizing: border-box;
            div{float: left;}
            div:nth-child(1){
                width: 71px;
                height: 100%; 
                text-align: center;
                line-height: 45px;
                font-size: 16px;
                color: #89DDDF;
            }
            div:nth-child(2){
                width: 147px;
                height: 40px;
                border: solid 1px  #05D0EB;
                padding: 13px 9px;
                box-sizing: border-box;
                font-size: 12px;
                color: #fff;
                div{
                    display: inline-block;
                    width: 10px;
                    height: 10px;
                    transform: rotate(45deg);
                    background: #05D0EB;
                    margin-right: 6px;
                }
            }
        }
        .charger{
            width: 149px;
            height: 100%; 
            margin-left: 2px;
            padding: 6px 0;
            box-sizing: border-box;
            div{float: left;}
            div:nth-child(1){
                width: 57px;
                height: 100%; 
                text-align: center;
                line-height: 45px;
                font-size: 16px;
                color: #89DDDF;
            }
            div:nth-child(2){
                width: 88px;
                height: 40px;
                border: solid 1px  #05D0EB;
                padding: 13px 9px;
                box-sizing: border-box;
                font-size: 12px;
                color: #fff;
                div{
                    display: inline-block;
                    width: 10px;
                    height: 10px;
                    transform: rotate(45deg);
                    background: #05D0EB;
                    margin-right: 6px;
                }
            }
        }
    }
    .bottomPart{
        width: 100%;
        height: 403px;
        margin-top: 3px;
        div{
            float: left;
        }
        .bottom_left{
            width: 47px;
            height: 100%;
            margin-right: 4px;
            background: rgba(9,122,206,0.2);
            padding: 157px 15px;
            box-sizing: border-box;
            div{
                width: 16px;
                height: 88px;   
                font-size: 16px;
                color: #89DDDF;
            }
        }
        .bottom_right{
            width: 488px;
            height: 100%;
            .bottom_right_top{
                width: 100%;
                height: 318px;
                div{
                    float: left;
                    background: rgba(9, 122, 206, 0.1);
                }
                .bottom_right_top_left{
                    width: 244px;
                    height: 100%;
                    div{
                        width: 100%;
                        height: 53px;
                        padding: 6px 0;
                        box-sizing: border-box;
                        div{float: left;}
                        div:nth-child(1){
                            width: 131px;
                            height: 100%; 
                            padding: 0;
                            text-align: center;
                            font-size: 16px;
                            color: #89DDDF;
                        }
                        div:nth-child(2){
                            width: 106px;
                            height: 40px;
                            border: solid 1px  #05D0EB;
                            padding: 13px 9px;
                            box-sizing: border-box;
                            font-size: 12px;
                            color: #fff;
                            div{
                                display: inline-block;
                                width: 10px;
                                height: 10px;
                                transform: rotate(45deg);
                                background: #05D0EB;
                                margin-right: 6px;
                            }
                        }
                    }
                }
                .bottom_right_top_right{
                    width: 240px;
                    height: 100%;
                    margin-left: 4px;
                    div:nth-child(1),div:nth-child(2){
                        width: 100%;
                        height: 53px;
                        padding: 6px 0;
                        box-sizing: border-box;
                        div{float: left;}
                        div:nth-child(1){
                            width: 131px;
                            height: 100%; 
                            padding: 0;
                            text-align: center;
                            font-size: 16px;
                            color: #89DDDF;
                        }
                        div:nth-child(2){
                            width: 97px;
                            height: 40px;
                            border: solid 1px  #05D0EB;
                            padding: 13px 9px;
                            box-sizing: border-box;
                            font-size: 12px;
                            color: #fff;
                            div{
                                display: inline-block;
                                width: 10px;
                                height: 10px;
                                transform: rotate(45deg);
                                background: #05D0EB;
                                margin-right: 6px;
                            }
                        }
                    }
                    div:nth-child(3),div:nth-child(4){
                        width: 100%;
                        height: 106px;
                        padding: 6px 0;
                        box-sizing: border-box;
                        div{float: left;}
                        div:nth-child(1){
                            width: 131px;
                            height: 100%; 
                            padding: 0;
                            text-align: center;
                            font-size: 16px;
                            color: #89DDDF;
                        }
                        div:nth-child(2){
                            width: 97px;
                            height: 97px;
                            border: solid 1px  #05D0EB;
                            padding: 36px 9px;
                            box-sizing: border-box;
                            font-size: 12px;
                            color: #fff;
                            div{
                                display: inline-block;
                                width: 10px;
                                height: 10px;
                                transform: rotate(45deg);
                                background: #05D0EB;
                                margin-right: 6px;
                            }
                        }
                    }
                }
            }
            .bottom_right_bottom{
                width: 100%;
                height: 79px;
                background: rgba(9,122,206,0.2);
                margin-top: 6px;
                padding: 6px 0;
                box-sizing: border-box;
                div{float: left;}
                div:nth-child(1){
                    width: 82px;
                    height: 100%; 
                    text-align: center;
                    font-size: 16px;
                    color: #89DDDF;
                    line-height: 30px;
                    box-sizing: border-box;
                }
                div:nth-child(2){
                    width: 404px;
                    height: 67px;
                    border: solid 1px  #05D0EB;
                    padding: 25px 9px;
                    box-sizing: border-box;
                    font-size: 12px;
                    color: #fff;
                    div{
                        display: inline-block;
                        width: 10px;
                        height: 10px;
                        transform: rotate(45deg);
                        background: #05D0EB;
                        margin-right: 6px;
                    }
                }
            }
        }
    }
}
</style>