import Vue from 'vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import colors from 'vuetify/lib/util/colors'

Vue.use(Vuetify)

export default new Vuetify({
  theme: {
    themes: {
      light: {
        primary: colors.purple.lighten2,
        secondary: colors.purple.lighten3,
        accent: colors.purple.lighten4,
        anchor: colors.purple.lighten2
      },
      dark: {
        primary: colors.cyan.darken3,
        secondary: colors.cyan.darken1,
        normal: colors.cyan.lighten3
      }
    }
  }
})

