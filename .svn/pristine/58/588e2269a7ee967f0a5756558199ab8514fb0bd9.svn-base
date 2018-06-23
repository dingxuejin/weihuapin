import * as DriverAPI from '@/api/driver'

const state = {
  illegalBehaviorDetailsInfo: null,
}
const mutations = {
  setIllegalBehaviorDetailsInfo(state, data) {
    state.illegalBehaviorDetailsInfo = data
  },
}
const actions = {
  async getIllegalBehaviorDetailsInfo({ commit }, param) {
    commit('setIllegalBehaviorDetailsInfo', null)
    const illegalBehaviorDetailsInfo = await DriverAPI.getIllegalBehaviorDetailsInfo(
      param,
    )
    commit('setIllegalBehaviorDetailsInfo', illegalBehaviorDetailsInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
