import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  cargoFlowArea: null,
}
const mutations = {
  setData(state, data) {
    state.cargoFlowArea = data
  },
}
const actions = {
  async getCargoFlowArea({ commit }, param) {
    commit('setData', null)
    const cargoFlowArea = await CompanyManageAPI.getCargoFlowArea(param)
    commit('setData', cargoFlowArea.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
