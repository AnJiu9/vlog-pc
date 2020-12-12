import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    loginStatus: false,
    avatar: '',
    user: {}
  },
  getters: {},
  mutations: {
    // 登录成功后，用户数据存入本地存储
    login(state, user) {
      state.loginStatus = true
      state.user = user
      state.avatar = user.avatar
      localStorage.setItem('user', JSON.stringify(user))
    },
    // 退出登录
    logout(state) {
      state.loginStatus = false
      state.user = {}
      state.avatar = ''
      localStorage.removeItem('user')
    },
    setAvatar(state, data) {
      state.avatar = data
    },
    // 修改资料
    editUserInfo(state, obj) {
      if (state.user) {
        state.user.nickname = obj.nickname
        state.user.password = obj.password
        state.user.avatar = obj.avatar
        state.user.gender = obj.gender
        state.user.birthday = obj.birthday
        state.user.address = obj.address
        localStorage.setItem('user', JSON.stringify(state.user))
      }
    }
  },
  actions: {}
})