import * as DriverAPI from '@/api/driver'

const state = {
  blameAccidentNumCountInfo: null,
}
const mutations = {
  setBlameAccidentNumCountInfo(state, data) {
    state.blameAccidentNumCountInfo = data
  },
}
const actions = {
  async getBlameAccidentNumCountInfo({ commit }, param) {
    commit('setBlameAccidentNumCountInfo', null)
    const blameAccidentNumCountInfo = await DriverAPI.getBlameAccidentNumCountInfo(
      param,
    )
    // console.log('有责任事故统计', blameAccidentNumCountInfo.data)
    commit('setBlameAccidentNumCountInfo', blameAccidentNumCountInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
