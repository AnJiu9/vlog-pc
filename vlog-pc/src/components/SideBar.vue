<template>
  <v-card min-width="320">
      <v-img :src="user.avatar" height="300px" dark>
          <v-row>
              <v-card-title>
                  <v-btn dark icon>
                      <v-icon>mdi-chevron-left</v-icon>
                  </v-btn>

                  <v-spacer></v-spacer>

                  <v-btn dark icon class="mr-4" @click="$router.push('/my/userinfo')">
                      <v-icon>mdi-pencil</v-icon>
                  </v-btn>

                  <v-btn dark icon color="black">
                      <v-icon>mdi-dots-vertical</v-icon>
                  </v-btn>
              </v-card-title>

              <v-spacer></v-spacer>

              <v-card-title class="black--text ml-16 mt-16">
                  <div class="display-2 pl-12 pt-16">
                      {{user.nickname}}
                  </div>
              </v-card-title>
          </v-row>
      </v-img>

      <v-list two-line>
        <v-list-item>
            <v-list-item-icon>
                <v-icon color="grey">
                    mdi-phone
                </v-icon>
            </v-list-item-icon>

            <v-list-item-content>
                <v-list-item-title>{{user.phone}}</v-list-item-title>
                <v-list-item-subtitle>{{ gender }}</v-list-item-subtitle>
            </v-list-item-content>

            <v-list-item-icon>
                <v-icon>
                    mdi-message-text
                </v-icon>
            </v-list-item-icon>
        </v-list-item>

        <v-divider inset></v-divider>

        <v-list-item>
            <v-list-item-icon>
                <v-icon color="grey">
                    mdi-map-marker
                </v-icon>
            </v-list-item-icon>
            <v-list-item-content>
                <v-list-item-title>{{user.address}}</v-list-item-title>
            </v-list-item-content>
        </v-list-item>

        <v-divider inset></v-divider>

        <v-list-item @click="$router.push('/my/usersafe')">
            <v-list-item-icon>
                <v-icon color="grey">
                    mdi-account
                </v-icon>
            </v-list-item-icon>

             <v-list-item-content>
                <v-list-item-title>账户安全</v-list-item-title>
            </v-list-item-content>
        </v-list-item>

        <v-divider inset></v-divider>

        <v-list-item @click="$router.push('/my/health')">
            <v-list-item-icon>
                <v-icon color="grey">
                    mdi-account-heart-outline
                </v-icon>
            </v-list-item-icon>

             <v-list-item-content>
                <v-list-item-title>个人健康</v-list-item-title>
            </v-list-item-content>
        </v-list-item>

        <v-divider inset></v-divider>

        <v-list-item @click="$router.push('/my/about')">
            <v-list-item-icon>
                <v-icon color="grey">
                    mdi-home
                </v-icon>
            </v-list-item-icon>

             <v-list-item-content>
                <v-list-item-title>关于</v-list-item-title>
            </v-list-item-content>
        </v-list-item>
      </v-list>
  </v-card>
</template>

<script>
import {mapState} from 'vuex'
export default {
    data:() =>({
        gender: '',
        selectedItem: 0,
        items: [
            {text:'资料编辑', icon: 'mdi-folder', path: '/my/userinfo'},
            {text:'账户安全', icon: 'mdi-account-mutiple', path: '/my/usersafe'},
            {text:'个人健康', icon: 'mdi-star', path: '/my/health'},
            // {text:'意见反馈', icon: 'mdi-star', path: '/my/feedback'},
            {text:'关于', icon: 'mdi-history', path: '/my/about'}
        ]
    }),
    created() {
        switch (this.user.gender){
            case 0:
                this.gender = '保密'
                break
            case 1:
                this.gender = '男'
                break
            case 2:
                this.gender = '女'
                break
        }
    },
    computed: {
        ...mapState({
            loginStatus: (state) => state.loginStatus,
            user: (state) => state.user
        })
    }

}
</script>
<style lang="scss">
a:link{
    text-decoration: none;
}
* {
    font-size: 16px;
}
</style>