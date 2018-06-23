import * as DriverAPI from '@/api/driver'

const state = {
  illegalBehaviorProportionCount: null,
}
const mutations = {
  setIllegalBehaviorProportionCount(state, data) {
    state.illegalBehaviorProportionCount = data
  },
}
const actions = {
  async getIllegalBehaviorProportionCount({ commit }, param) {
    commit('setIllegalBehaviorProportionCount', null)
    const illegalBehaviorProportionCount = await DriverAPI.getIllegalBehaviorProportionCount(
      param,
    )
    // console.log('违法行为占比统计', illegalBehaviorProportionCount.data)
    commit(
      'setIllegalBehaviorProportionCount',
      illegalBehaviorProportionCount.data,
    )
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}
