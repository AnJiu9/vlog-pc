import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    loginStatus: false,
    user: {}
  },
  getters: {},
  mutations: {
    // 登录成功后，用户数据存入本地存储
    login(state, user) {
      state.loginStatus = true
      state.user = user
      localStorage.setItem('user', JSON.stringify(user))
    },
    // 退出登录
    logout(state) {
      state.loginStatus = false
      state.user = {}
      localStorage.removeItem('user')
    }
  },
  actions: {}
})
