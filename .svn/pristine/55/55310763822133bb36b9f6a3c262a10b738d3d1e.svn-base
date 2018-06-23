import * as DriverAPI from '@/api/driver'

const state = {
  driverBehaviorAlarmCountInfo: null,
}

const mutations = {
  setDriverBehaviorAlarmCountInfo(state, data) {
    state.driverBehaviorAlarmCountInfo = data
  },
}

const actions = {
  async getDriverBehaviorAlarmCountInfo({ commit }, param) {
    commit('setDriverBehaviorAlarmCountInfo', null)
    const driverBehaviorAlarmCountInfo = await DriverAPI.getDriverBehaviorAlarmCountInfo(
      param,
    )

    // console.log('报警统计数据', driverBehaviorAlarmCountInfo.data)

    commit(
      'setDriverBehaviorAlarmCountInfo',
      driverBehaviorAlarmCountInfo.data,
    )
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
