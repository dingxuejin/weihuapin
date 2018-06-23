import * as DriverAPI from '@/api/driver'

const state = {
  irregalarityBehaviorDetailsInfo: null,
}
const mutations = {
  setIrregalarityBehaviorDetailsInfo(state, data) {
    state.irregalarityBehaviorDetailsInfo = data
  },
}
const actions = {
  async getIrregalarityBehaviorDetailsInfo({ commit }, param) {
    commit('setIrregalarityBehaviorDetailsInfo', null)
    const irregalarityBehaviorDetailsInfo = await DriverAPI.getIrregalarityBehaviorDetailsInfo(
      param,
    )
    // console.log('驾驶违规行为详细信息', irregalarityBehaviorDetailsInfo.data)
    commit(
      'setIrregalarityBehaviorDetailsInfo',
      irregalarityBehaviorDetailsInfo.data,
    )
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
