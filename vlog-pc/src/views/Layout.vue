<template>
  <v-card class="overflow-hidden">
    <v-app-bar
      absolute
      color="#fcb69f"
      dark
      shrink-on-scroll
      src="../assets/images/bz.jpg"
      scroll-target="#scrolling-techniques-2"
    >    
      <template v-slot:img="{ props }">
        <v-img v-bind="props" gradient="to top right, rgb(67, 198, 172,0.5), rgb(248, 255, 174,0.7)"></v-img>
      </template>

      <v-app-bar-nav-icon @click="$router.push('/')" color="teal darken-4"></v-app-bar-nav-icon>
    
    <v-row>
      <v-col>
      <v-toolbar-title>
        <div align="center">
          {{user.nickname}}的个人博客
        </div>
      </v-toolbar-title>
      </v-col>
   

      <v-btn value="recent" class="primary" @click="$router.push('/news')" rounded>
        <span>动态</span>
        <v-icon>mdi-exclamation-thick</v-icon>
      </v-btn>

      <v-btn value="favorites" class="secondary" @click="$router.push('/message')" rounded>
        <span>消息</span>
        <v-icon>mdi-message-processing-outline</v-icon>
      </v-btn>

      <v-btn value="nearby" class="accent" @click="$router.push('/my')" rounded>
        <span>我的</span>
        <v-icon>mdi-home-circle-outline</v-icon>
      </v-btn>
    </v-row>    
      <v-spacer></v-spacer>

      <v-avatar>
        <v-img :src="user.avatar"></v-img>
      </v-avatar>

      <v-btn icon>
        <v-icon color="yellow lighten-4">mdi-magnify</v-icon>
      </v-btn>

      <v-btn icon>
        <v-icon color="yellow darken-1">mdi-heart</v-icon>
      </v-btn>

      <v-menu bottom left>
        <template v-slot:activator="{ on, attrs }">
          <v-btn icon color="pur" v-bind="attrs" v-on="on">
            <v-icon color="yellow darken-3">mdi-dots-vertical</v-icon>
          </v-btn>
        </template>

        <v-list>
          <v-list-item @click="$router.push('/')">
            <v-list-item-title>系统设置</v-list-item-title>
          </v-list-item>
          <v-list-item @click="$router.push('/')">
            <v-list-item-title>主题设置</v-list-item-title>
          </v-list-item>
          <v-list-item @click="$router.push('/login')">
            <v-list-item-title>退出登录</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </v-app-bar>
    <v-sheet id="scrolling-techniques-2" class="overflow-y-auto">
      <v-container style="margin-top:150px;">
        <router-view />
      </v-container>
    </v-sheet>
  </v-card>
</template>
<script>
import {mapState} from 'vuex'
export default {
  data: () => ({
    show: true
  }),
  computed: {
        ...mapState({
            loginStatus: (state) => state.loginStatus,
            user: (state) => state.user
        })
    }
}
</script>
