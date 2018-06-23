/*eslint-disable */
import { getCompany } from "api/company";

const state = {
  count: 0
};

const mutations = {
  addCount(state) {
    state.count += 1;
  }
};
const actions = {
  startCount({ dispatch, commit, rootState }) {
    console.log(rootState);

    setInterval(() => {
      commit("addCount");
      dispatch("mysecondcontainer/startcount", null, { root: true });
    }, 1000);
  },
  async getCompany() {
    getCompany().then(data => console.log(data));
  }
};
export default {
  namespaced: true,
  state,
  actions,
  mutations
};
