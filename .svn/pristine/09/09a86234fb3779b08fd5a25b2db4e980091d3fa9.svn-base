import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  manageGoodsBh: null,
}
const mutations = {
  setManageGoodsBh(state, data) {
    state.manageGoodsBh = data
  },
}
const actions = {
  async getManageGoodsBh({ commit }, param) {
    commit('setManageGoodsBh', null)
    const manageGoodsBh = await CompanyManageAPI.getManageGoodsBh(param)
    commit('setManageGoodsBh', manageGoodsBh.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
