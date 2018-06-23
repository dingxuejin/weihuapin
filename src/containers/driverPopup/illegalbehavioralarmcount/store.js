import * as DriverAPI from '@/api/driver'

const state = {
  illegalBehaviorAlarmCount: null,
}
const mutations = {
  setIllegalBehaviorAlarmCount(state, data) {
    state.illegalBehaviorAlarmCount = data
  },
}
const actions = {
  async getIllegalBehaviorAlarmCount({ commit }, param) {
    commit('setIllegalBehaviorAlarmCount', null)
    const illegalBehaviorAlarmCount = await DriverAPI.getIllegalBehaviorAlarmCount(
      param,
    )
    commit('setIllegalBehaviorAlarmCount', illegalBehaviorAlarmCount.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
