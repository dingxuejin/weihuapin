/*eslint-disable */
import * as CarAPI from "@/api/car";

const state = {
  DataJgxxsl: "",
  carAlertPopUpShow: false,
  carAlertInftData: null
};
const mutations = {
  setDataJgxxsl(state, data) {
    state.DataJgxxsl = data;
  },
  setcarAlertPopUpShow(state, data) {
    state.carAlertPopUpShow = data;
  },
  setcarAlertInftData(state, data) {
    state.carAlertInftData = data;
  }
};
const actions = {
  getJgxxsl({ commit }) {
    CarAPI.getJgxxsl()
      .then(data => {
        commit("setDataJgxxsl", data.data);
      })
      .catch(error => {
        console.log(error);
      });
  },
  async getAlertInfo({ commit }, params) {
    const CarAlertInftData = await CarAPI.getAlertInfo(params);
    commit("setcarAlertInftData", CarAlertInftData.data);
  }
};
export default {
  namespaced: true,
  state,
  actions,
  mutations
};
