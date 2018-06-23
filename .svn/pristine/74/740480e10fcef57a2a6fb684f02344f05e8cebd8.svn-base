import * as CompanyAPI from '@/api/company'

const state = {
  lineDetail: null,
}
const mutations = {
  setData(state, data) {
    state.lineDetail = data
  },
}
const actions = {
  async getLineDetail({ commit }, param) {
    commit('setData', null)
    const lineDetail = await CompanyAPI.getLineDetail(param)
    commit('setData', lineDetail.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
