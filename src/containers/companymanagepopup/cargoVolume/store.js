import * as CompanyManageAPI from '@/api/companymanage'

const state = {
  volumeByCargoType: null,
}
const mutations = {
  setData(state, data) {
    state.volumeByCargoType = data
  },
}
const actions = {
  async getVolumeByCargoType({ commit }, param) {
    commit('setData', null)
    const volumeByCargoType = await CompanyManageAPI.getVolumeByCargoType(
      param,
    )
    // console.log('货运量统计 - 数据', volumeByCargoType.data)
    commit('setData', volumeByCargoType.data)
  },
}

export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
