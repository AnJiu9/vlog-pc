<template>
  <v-card class="overflow-hidden">
    <v-app-bar
      absolute
      color="#fcb69f"
      dark
      shrink-on-scroll
      src="../assets/images/bg.jpg"
      scroll-target="#scrolling-techniques-2"
    >
      <template v-slot:img="{ props }">
        <v-img v-bind="props" gradient="to top right, rgba(191,48,172,0.7), rgba(15,157,88,0.9)"></v-img>
      </template>

      <v-app-bar-nav-icon @click="$router.push('/')"></v-app-bar-nav-icon>

      <v-toolbar-title>
        <div>
          {{user.nickname}}
        </div>
      </v-toolbar-title>

      <v-btn value="recent" class="primary" @click="$router.push('/news')">
        <span>动态</span>
        <v-icon>mdi-exclamation-thick</v-icon>
      </v-btn>

      <v-btn value="favorites" class="secondary" @click="$router.push('/message')">
        <span>消息</span>
        <v-icon>mdi-message-processing-outline</v-icon>
      </v-btn>

      <v-btn value="nearby" class="accent" @click="$router.push('/my')">
        <span>我的</span>
        <v-icon>mdi-home-circle-outline</v-icon>
      </v-btn>

      <v-spacer></v-spacer>
      <v-avatar>
        <v-img :src="user.avatar"></v-img>
      </v-avatar>

      <v-btn icon>
        <v-icon>mdi-magnify</v-icon>
      </v-btn>

      <v-btn icon>
        <v-icon>mdi-heart</v-icon>
      </v-btn>

      <v-menu bottom left>
        <template v-slot:activator="{ on, attrs }">
          <v-btn icon color="pur" v-bind="attrs" v-on="on">
            <v-icon>mdi-dots-vertical</v-icon>
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
