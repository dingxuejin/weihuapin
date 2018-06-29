/*eslint-disable */
const state = {
  name: "driver",
  safetyIntegral: false,
  driverHealthy: false,
  driverDetailsTag: false,
  driverDetailsInfo: false,
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
  driverWarningRemindShow: false,
  driverMileage:false,
  WaybillNumStatistics:false
};
const actions = {};
const mutations = {
  open(state, name) {
    state[name] = true;
  },
  close(state, name) {
    state[name] = false;
  }
};

export default {
  namespaced: true,
  state,
  actions,
  mutations
};
