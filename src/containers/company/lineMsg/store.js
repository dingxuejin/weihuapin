import * as CompanyAPI from '@/api/company'

const state = {
  lineMsg: null,
}
const mutations = {
  setData(state, data) {
    state.lineMsg = data
  },
}
const actions = {
  async getLineMsg({ commit }, param) {
    commit('setData', null)
    const lineMsg = await CompanyAPI.getLineMsg(param)
    commit('setData', lineMsg.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
