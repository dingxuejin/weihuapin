import * as CompanyAPI from '@/api/company'
/* eslint-disable */
const state = {
  WarningTipStatisticsData: {},
  WarningTipInfoTendencyData: [],
  HandleStatisticsData: {},
  HandlingRankingData: [],
}

const mutations = {
  setWarningTipStatistics(state, data) {
    state.WarningTipStatisticsData = data
  },
  setWarningTipInfoTendency(state, data) {
    state.WarningTipInfoTendencyData = data
  },
  setHandleStatistics(state, data) {
    state.HandleStatisticsData = data
  },
  setHandlingRanking(state, data) {
    state.HandlingRankingData = data.sort((a, b) => a.alarm_quantity_handled - b.alarm_quantity_handled)
  },
}

const actions = {
  // 预警统计
  async getWarningTipStatistics({ commit }, params) {
    const res = await CompanyAPI.getWarningTipStatistics(params)
    commit('setWarningTipStatistics', res.data)
  },
  // 报警信息变动趋势
  async getWarningTipInfoTendency({ commit }, params) {
    const res = await CompanyAPI.getWarningTipInfoTendency(params)
    commit('setWarningTipInfoTendency', res.data)
  },
  // 处理统计
  async getHandleStatistics({ commit }, params) {
    const res = await CompanyAPI.getHandleStatistics(params)
    commit('setHandleStatistics', res.data)
  },
  // 处理条数排名
  async getHandlingRanking({ commit }, params) {
    const res = await CompanyAPI.getHandlingRanking(params)
    commit('setHandlingRanking', res.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
