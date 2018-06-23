import * as DriverAPI from '@/api/driver'

const state = {
  irregalarityBehaviorCountInfo: null,
}
const mutations = {
  setIrregalarityBehaviorCountInfo(state, data) {
    state.irregalarityBehaviorCountInfo = data
  },
}
const actions = {
  async getIrregalarityBehaviorCountInfo({ commit }, param) {
    commit('setIrregalarityBehaviorCountInfo', null)
    const irregalarityBehaviorCountInfo = await DriverAPI.getIrregalarityBehaviorCountInfo(
      param,
    )
    commit(
      'setIrregalarityBehaviorCountInfo',
      irregalarityBehaviorCountInfo.data,
    )
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
