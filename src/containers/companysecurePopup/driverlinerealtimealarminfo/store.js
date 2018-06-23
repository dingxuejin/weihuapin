import * as DriverAPI from '@/api/driver'

const state = {
  driverLineRealtimeAlarmInfo: null,
  type: '驾驶行为',
}
const mutations = {
  setDriverLineRealtimeAlarmInfo(state, data) {
    state.driverLineRealtimeAlarmInfo = data
  },
  setBehaviorType(state, type) {
    state.type = type
  },
}
const actions = {
  async getDriverLineRealtimeAlarmInfo({ commit }, param) {
    commit('setDriverLineRealtimeAlarmInfo', null)
    const driverLineRealtimeAlarmInfo = await DriverAPI.getDriverLineRealtimeAlarmInfo(
      param,
    )
    commit('setDriverLineRealtimeAlarmInfo', driverLineRealtimeAlarmInfo.data)
  },
  async setType({ commit, dispatch }, { driver_id, type }) {
    commit('setBehaviorType', type)
    dispatch('getDriverLineRealtimeAlarmInfo', {
      driver_id,
      year: 2017,
      month: 11,
      day: 22,
      type,
    })
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
