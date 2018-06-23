import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  illegalAreaDistribute: null,
  illegalIntervalDistribute: null,
}
const mutations = {
  setAreaData(state, data) {
    state.illegalAreaDistribute = data
  },
  setIntervalData(state, data) {
    state.illegalIntervalDistribute = data
  },
}
const actions = {
  async getIllegalAreaDistribute({ commit }, param) {
    commit('setAreaData', null)
    const illegalAreaDistribute = await CompanySecureAPI.getIllegalAreaDistribute(
      param,
    )
    commit('setAreaData', illegalAreaDistribute.data)
  },
  async getIllegalIntervalDistribute({ commit }, param) {
    commit('setIntervalData', null)
    const illegalIntervalDistribute = await CompanySecureAPI.getIllegalIntervalDistribute(
      param,
    )
    commit('setIntervalData', illegalIntervalDistribute.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
