import Vuex from 'vuex'

const cookieparser = process.server ? require('cookieparser') : undefined

const createStore = () => {
  return new Vuex.Store({
    state: () => ({
      theme: ['255, 255, 255', '45,45,45'],
      auth: null
    }),

    mutations: {
      setTheme: (state, theme) => state.theme = theme,
      setAuth(state, auth) {
        state.auth = auth
      }
    },
    actions: {
      nuxtServerInit({commit}, {req}) {
        let auth = null
        if (req.headers.cookie) {
          const parsed = cookieparser.parse(req.headers.cookie)
          try {
            auth = JSON.parse(parsed.auth)
          } catch (err) {
            // No valid cookie found
          }
        }
        commit('setAuth', auth)
      }
    }
  })
}
export default createStore