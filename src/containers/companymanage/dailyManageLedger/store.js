import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  wallbill: null,
  distribution: null,
  seletedWallbill: null,
  selectedYear: 2017,
  selectedMonth: 10,
  selectedDay: 20,
}
const mutations = {
  setWallbill(state, data) {
    state.wallbill = data
  },
  setDistribution(state, data) {
    state.distribution = data
  },
  setSeletedWallbill(state, data) {
    state.seletedWallbill = data
  },
  setSelectedYear(state, data) {
    state.selectedYear = data
  },
  setSelectedMonth(state, data) {
    state.selectedMonth = data
  },
  setSelectedDay(state, data) {
    state.selectedDay = data
  },
}
const actions = {
  async getDailyManageLedger({ commit }, param) {
    const dailyManageLedger = await CompanyManageAPI.getDailyManageLedger(param)
    // console.log('dailyManageLedger', dailyManageLedger.data)
    // 运单状况日报
    commit('setWallbill', dailyManageLedger.data.wallbill)
    // 配送工作日报
    commit('setDistribution', dailyManageLedger.data.distribution)
  },
  // 弹筐里的运单状况日报
  async setSeletedWallbill({ commit }, param) {
    commit('setSeletedWallbill', param)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
