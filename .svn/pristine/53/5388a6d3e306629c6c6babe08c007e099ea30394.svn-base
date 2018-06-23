import * as CompanyAPI from '@/api/company'

const state = {
  manageStateWaybill: null,
  // 运单量
  manageStateTurnover: null,
  // 周转量
}
const mutations = {
  setWaybill(state, data) {
    state.manageStateWaybill = data
  },
  setTurnover(state, data) {
    state.manageStateTurnover = data
  },
}
const actions = {
  async getManageStateWaybill({ commit }, param) {
    commit('setWaybill', null)
    const manageStateWaybill = await CompanyAPI.getManageStateWaybill(param)
    commit('setWaybill', manageStateWaybill.data)
  },
  async getMangeStateTurnover({ commit }, param) {
    commit('setTurnover', null)
    const manageStateTurnover = await CompanyAPI.getMangeStateTurnover(param)
    commit('setTurnover', manageStateTurnover.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
