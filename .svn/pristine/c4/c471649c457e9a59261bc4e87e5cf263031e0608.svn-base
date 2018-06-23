import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  yearCostTrendFixed: null,
  yearCostTrendTurnover: null,
  yearCostTrendFloat: null,
}
const mutations = {
  setFixedData(state, data) {
    state.yearCostTrendFixed = data
  },
  setTurnoverData(state, data) {
    state.yearCostTrendTurnover = data
  },
  setFloatData(state, data) {
    state.yearCostTrendFloat = data
  },
}
const actions = {
  async getYearCostTrendFixed({ commit }, param) {
    commit('setFixedData', null)
    const yearCostTrendFixed = await CompanyManageAPI.getYearCostTrendFixed(
      param,
    )
    // console.log(yearCostTrendFixed)

    commit('setFixedData', yearCostTrendFixed.data)
  },
  async getYearCostTrendTurnover({ commit }, param) {
    commit('setTurnoverData', null)
    const yearCostTrendTurnover = await CompanyManageAPI.getYearCostTrendTurnover(
      param,
    )
    commit('setTurnoverData', yearCostTrendTurnover.data)
  },
  async getYearCostTrendFloat({ commit }, param) {
    commit('setFloatData', null)
    const yearCostTrendFloat = await CompanyManageAPI.getYearCostTrendFloat(
      param,
    )
    commit('setFloatData', yearCostTrendFloat.data)
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
