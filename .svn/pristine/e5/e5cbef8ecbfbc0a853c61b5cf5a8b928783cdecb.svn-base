import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  volumeStatisticsDayNight: null,
}
const mutations = {
  setData(state, data) {
    state.volumeStatisticsDayNight = data
  },
}
const actions = {
  async getVolumeStatisticDayNight({
    commit,
  }, param) {
    commit('setData', null)
    const volumeStatisticsDayNight = await CompanyManageAPI.getVolumeStatisticDayNight(
      param,
    )
    commit('setData', volumeStatisticsDayNight.data)
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
