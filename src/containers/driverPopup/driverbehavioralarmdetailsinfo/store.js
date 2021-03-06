import * as DriverAPI from '@/api/driver'

const state = {
  driverBehaviorAlarmDetailsInfo: null,
}
const mutations = {
  setDriverBehaviorAlarmDetailsInfo(state, data) {
    state.driverBehaviorAlarmDetailsInfo = data
  },
}
const actions = {
  async getDriverBehaviorAlarmDetailsInfo({ commit }, param) {
    commit('setDriverBehaviorAlarmDetailsInfo', null)
    const driverBehaviorAlarmDetailsInfo = await DriverAPI.getDriverBehaviorAlarmDetailsInfo(
      param,
    )
    commit(
      'setDriverBehaviorAlarmDetailsInfo',
      driverBehaviorAlarmDetailsInfo.data,
    )
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
