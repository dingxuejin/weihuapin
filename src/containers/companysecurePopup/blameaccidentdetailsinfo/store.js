import * as DriverAPI from '@/api/driver'

const state = {
  blameAccidentDetailsInfo: null,
}
const mutations = {
  setBlameAccidentDetailsInfo(state, data) {
    state.blameAccidentDetailsInfo = data
  },
}
const actions = {
  async getBlameAccidentDetailsInfo({ commit }, param) {
    commit('setBlameAccidentDetailsInfo', null)
    const blameAccidentDetailsInfo = await DriverAPI.getBlameAccidentDetailsInfo(
      param,
    )
    // console.log('有责事故详细信息', blameAccidentDetailsInfo.data)
    commit('setBlameAccidentDetailsInfo', blameAccidentDetailsInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
