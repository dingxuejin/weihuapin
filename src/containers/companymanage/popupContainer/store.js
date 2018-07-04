

const state = {
  // 企业经营管理弹框
  cost_trend_fixed: null,
  cost_trend_turnover: null,
  cost_trend_float: null,
  waybill_statistics: null,
  waybill_trend_recently: null,
  waybill_yearonyear_this_month: null,
  turnover_by_cargo_type: null,
  volume_by_cargo_type: null,

  // 显示/隐藏状态
  detailsShow: false,
  company_manage_waybill_show: false,
  cost_ratio_trend_show: false,
  volume_by_cargo_show: false,
  turnover_by_cargo_show: false,
  volume_statistics_day_night_show: false,
  user_custom_show: true,
  route_info_show: false,
  cargo_flow_area_show: false,
  incom_ranked_show: false,
  goodstjFrame_show: false,
  waybillConditionDaily_show: false,
}
const mutations = {
  setData(state, { name, data }) {
    state[name] = data
  },
  // 触发弹框显示及隐藏
  getComDetails(state, o) {
    console.log(o)
    // 企业经营货物流向弹窗
    if (o === 'goodstjFrame') {
      state.detailsShow = true
      state.goodstjFrame_show = true
    }
    // 企业经营 排名情况
    if (o === 'incomRanked') {
      // console.log(111)
      state.detailsShow = true
      state.incom_ranked_show = true
    }
    // 成本比例变化趋势
    if (o === 'costRatio') {
      state.detailsShow = true
      state.cost_ratio_trend_show = true
    }
    // 总运量
    if (o === 'totalCounts') {
      state.detailsShow = true
      state.company_manage_waybill_show = true
    }
    // 总周转量
    if (o === 'turnOver') {
      state.detailsShow = true
      state.turnover_by_cargo_show = true
    }
    // 总货运量
    if (o === 'totalFreight') {
      state.detailsShow = true
      state.volume_by_cargo_show = true
    }
    // 货物流量流向统计
    if (o === 'goodstj') {
      state.detailsShow = true
      state.volume_statistics_day_night_show = true
    }
    // 线路排名
    if (o === 'lineRank') {
      state.detailsShow = true
      state.route_info_show = true
    }
    // 货物流量流向分析
    if (o === 'flowArea') {
      state.detailsShow = true
      state.cargo_flow_area_show = true
    }
    // 日常管理台账-->运单状况日报
    if (o === 'waybillConditionDaily') {
      state.detailsShow = true
      state.waybillConditionDaily_show = true
    }
    return true
  },
  closeComDetails(state) {
    state.detailsShow = false
    state.company_manage_waybill_show = false
    state.cost_ratio_trend_show = false
    state.volume_by_cargo_show = false
    state.turnover_by_cargo_show = false
    state.volume_statistics_day_night_show = false
    state.route_info_show = false
    state.cargo_flow_area_show = false
    state.incom_ranked_show = false
    state.goodstjFrame_show = false
    state.waybillConditionDaily_show = false
  },
  closeDayNightDetails(state) {
    state.volume_statistics_day_night_show = false
  },
}
const actions = {


}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
