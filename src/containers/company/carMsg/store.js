import * as CompanyAPI from '@/api/company'

const state = {
  carMsg: null,
}
const mutations = {
  setData(state, data) {
    state.carMsg = data
  },
}
const actions = {
  async getCarMsg({ commit }, param) {
    commit('setData', null)
    const carMsg = await CompanyAPI.getCarMsg(param)
    commit('setData', carMsg.data)
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
