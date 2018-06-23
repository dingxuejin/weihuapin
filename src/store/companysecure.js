const state = {
  name: 'driver',
  quantityDriver: false,
  qualifyDetailInfo: false,
  trainDetailInfo: false,
  rewardInfo: false,
  punishInfo: false,
  workCountInfo: false,
  driverBehavior: false,
  irregalarityBehavior: false,
  illegalBehavior: false,
  blameAccident: false,
  driverLineRealtimeAlarm: false,
}
const actions = {}
const mutations = {
  openSecure(state, name) {
    // console.log(name)
    state[name] = true
  },
  closeSecure(state, name) {
    state[name] = false
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
