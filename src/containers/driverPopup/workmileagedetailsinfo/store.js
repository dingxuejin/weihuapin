import * as DriverAPI from '@/api/driver'

const state = {
  workMileageDetailsInfo: null,
}
const mutations = {
  setWorkMileageDetailsInfo(state, data) {
    state.workMileageDetailsInfo = data
  },
}
const actions = {
  async getWorkMileageDetailsInfo({ commit }, param) {
    commit('setWorkMileageDetailsInfo', null)
    const workMileageDetailsInfo = await DriverAPI.getWorkMileageDetailsInfo(
      param,
    )
    // console.log('行驶里程详细信息', workMileageDetailsInfo.data)
    commit('setWorkMileageDetailsInfo', workMileageDetailsInfo.data)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
