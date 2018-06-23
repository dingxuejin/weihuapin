const state = {
  count: 0,
}

const mutations = {
  addCount(state) {
    state.count += 1
  },
}
const actions = {
  startCount({ commit, rootstate }) {
    // console.log(rootstate)
    setInterval(() => {
      commit('addCount')
    }, 1000)
  },
}
export default {
  namespaced: true,
  state,
  actions,
  mutations,
}

