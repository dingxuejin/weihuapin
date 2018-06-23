import * as CompanySecureAPI from '@/api/companysecure'

const state = {
  irregularityAreaDistribute: null,
  irregularityIntervalDistribtue: null,
}
const mutations = {
  setAreaData(state, data) {
    state.irregularityAreaDistribute = data
  },
  setIntervalData(state, data) {
    state.irregularityIntervalDistribtue = data
  },
}
const actions = {
  async getIrregularityAreaDistribute({ commit }, param) {
    commit('setAreaData', null)
    const irregularityAreaDistribute = await CompanySecureAPI.getIrregularityAreaDistribute(
      param,
    )
    commit('setAreaData', irregularityAreaDistribute.data)
  },
  async getIrregularityIntervalDistribute({ commit }, param) {
    commit('setIntervalData', null)
    const irregularityIntervalDistribtue = await CompanySecureAPI.getIrregularityIntervalDistribute(
      param,
    )
    commit('setIntervalData', irregularityIntervalDistribtue.data)
  },
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
}
