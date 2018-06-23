import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  volumeStatisticsEntity: null,
}
const mutations = {
  setData(state, data) {
    state.volumeStatisticsEntity = data
  },
}
const actions = {
  async getVolumeStatisticsEntity({ commit }, param) {
    commit('setData', null)
    const volumeStatisticsEntity = await CompanyManageAPI.getVolumeStatisticsEntity(
      param,
    )
    commit('setData', volumeStatisticsEntity.data)
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
