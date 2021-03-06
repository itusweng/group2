import ApiService from '@/core/services/api.service';
import JwtService from '@/core/services/jwt.service';
import UserService from '@/core/services/user.service';
import jwt from 'jsonwebtoken';

// action types
export const VERIFY_AUTH = 'verifyAuth';
export const LOGIN = 'login';
export const LOGOUT = 'logout';
export const REGISTER = 'register';
export const UPDATE_PASSWORD = 'updateUser';

// mutation types
export const PURGE_AUTH = 'logOut';
export const SET_AUTH = 'setUser';
export const SET_PASSWORD = 'setPassword';
export const SET_ERROR = 'setError';

const state = {
  errors: null,
  user: UserService.getUser(),
  isAuthenticated: !!JwtService.getToken()
};

const getters = {
  currentUser(state) {
    return state.user;
  },
  isAuthenticated(state) {
    return state.isAuthenticated;
  }
};

const actions = {
  [LOGIN](context, credentials) {
    return new Promise((resolve, reject) => {
      ApiService.post('user/login', credentials)
        .then(({ data }) => {
          // console.log("Here what post returns", data);
          context.commit(SET_AUTH, data);
          resolve(data);
        })
        .catch(e => {
          reject(e);
        });
    });
  },
  [LOGOUT](context) {
    context.commit(PURGE_AUTH);
  },
  [REGISTER](context, credentials) {
    return new Promise(resolve => {
      ApiService.post('login', credentials)
        .then(({ data }) => {
          context.commit(SET_AUTH, data);
          resolve(data);
        })
        .catch(({ response }) => {
          context.commit(SET_ERROR, response.data.errors);
        });
    });
  },
  [VERIFY_AUTH](context) {
    if (JwtService.getToken()) {
      ApiService.setToken();
      ApiService.get('verify')
        .then(({ data }) => {
          context.commit(SET_AUTH, data);
        })
        .catch(({ response }) => {
          context.commit(SET_ERROR, response.data.errors);
        });
    } else {
      context.commit(PURGE_AUTH);
    }
  },
  [UPDATE_PASSWORD](context, payload) {
    const password = payload;

    return ApiService.put('password', password).then(({ data }) => {
      context.commit(SET_PASSWORD, data);
      return data;
    });
  }
};

const mutations = {
  [SET_ERROR](state, error) {
    state.errors = error;
  },
  [SET_AUTH](state, data) {
    state.isAuthenticated = true;
    const decoded = jwt.decode(data.token.access_token);

    const newUser = {
      ...data.user,
      isManager: decoded.realm_access.roles.includes('MANAGER')
    };
    state.user = newUser;
    state.errors = {};

    UserService.saveUser(newUser);
    JwtService.saveToken(data.token.access_token);
    ApiService.setToken();
  },
  setUser(state, user) {
    const newUser = {
      ...state.user,
      ...user
    };
    state.user = newUser;
    state.errors = {};

    UserService.saveUser(newUser);
  },
  [SET_PASSWORD](state, password) {
    state.user.password = password;
  },
  [PURGE_AUTH](state) {
    state.isAuthenticated = false;
    state.user = {};
    state.errors = {};
    UserService.destroyUser();
    JwtService.destroyToken();
    ApiService.removeToken();
  }
};

export default {
  state,
  actions,
  mutations,
  getters
};
