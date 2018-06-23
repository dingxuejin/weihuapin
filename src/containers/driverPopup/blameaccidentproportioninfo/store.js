import * as DriverAPI from '@/api/driver'

const state = {
  blameAccidentProportionInfo: null,
}
const mutations = {
  setBlameAccidentProportionInfo(state, data) {
    state.blameAccidentProportionInfo = data
  },
}
const actions = {
  async getBlameAccidentProportionInfo({ commit }, param) {
    commit('setBlameAccidentProportionInfo', null)
    const blameAccidentProportionInfo = await DriverAPI.getBlameAccidentProportionInfo(
      param,
    )
    // console.log('有责事故占比统计', blameAccidentProportionInfo.data)
    commit('setBlameAccidentProportionInfo', blameAccidentProportionInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
