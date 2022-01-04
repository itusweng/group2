const state = {
  activeTraining: {}
};

const getters = {
  activeTraining(state) {
    return state.activeTraining;
  }
};

const mutations = {
  setTraining(state, activeTraining) {
    state.activeTraining = activeTraining;
  }
};

export default {
  state,
  mutations,
  getters
};
