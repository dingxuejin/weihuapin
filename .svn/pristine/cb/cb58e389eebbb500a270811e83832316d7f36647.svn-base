import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  cargoFlow: null,
}
const mutations = {
  setData(state, data) {
    state.cargoFlow = data
  },
}
const actions = {
  async getCargoFlow({ commit }, param) {
    commit('setData', null)
    const cargoFlow = await CompanyManageAPI.getCargoFlow(param)
    commit('setData', cargoFlow.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
