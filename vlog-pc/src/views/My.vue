<template>
  <v-card class="mx-auto" max-width="400">
    <v-card dark flat>
      <v-btn absolute bottom color="blue" right fab>
        <v-icon>mdi-plus</v-icon>
      </v-btn>
      <v-card-title class="pa-2 blue lighten-3">
        <v-btn icon>
          <v-icon>mdi-menu</v-icon>
        </v-btn>
        <h3 class="title font-weight-light text-center grow">
          个人中心
        </h3>
        <v-avatar>
          <v-img src="https://share--app.oss-cn-hangzhou.aliyuncs.com/avatar/20201205181922.jpg"></v-img>
        </v-avatar>
      </v-card-title>
      <v-img
        src="https://cdn.vuetifyjs.com/images/cards/forest.jpg"
        gradient="to top, rgba(0,0,0,.44), rgba(0,0,0,.44)"
      >
        <v-container class="fill-height">
          <v-row align="center">
            <strong class="display-4 font-weight-regular mr-6">8</strong>
            <v-row justify="end">
              <div class="headline font-weight-light">
                Monday
              </div>
              <div class="text-uppercase font-weight-light">
                February 2020
              </div>
            </v-row>
          </v-row>
        </v-container>
      </v-img>
    </v-card>
    <v-card-text class="py-0">
      <v-timeline align-top dense>
        <v-timeline-item color="orange" small>
          <v-row class="pt-1">
            <v-col cols="3">
              <strong>5pm</strong>
            </v-col>
            <v-col>
              <strong>New Icon</strong>
              <div class="caption">
                Mobile App
              </div>
            </v-col>
          </v-row>
        </v-timeline-item>

        <v-timeline-item color="teal lighten-3" small>
          <v-row class="pt-1">
            <v-col cols="3">
              <strong>3-4pm</strong>
            </v-col>
            <v-col>
              <strong>Design Stand Up</strong>
              <div class="caption mb-2">
                Hangouts
              </div>
              <v-avatar>
                <v-img src="https://share--app.oss-cn-hangzhou.aliyuncs.com/avatar/20201205181922.jpg"></v-img>
              </v-avatar>
              <v-avatar>
                <v-img src="https://share--app.oss-cn-hangzhou.aliyuncs.com/avatar/20201205181922.jpg"></v-img>
              </v-avatar>
              <v-avatar>
                <v-img src="https://share--app.oss-cn-hangzhou.aliyuncs.com/avatar/20201205181922.jpg"></v-img>
              </v-avatar>
            </v-col>
          </v-row>
        </v-timeline-item>

        <v-timeline-item color="purple" small>
          <v-row class="pt-1">
            <v-col cols="3">
              <strong>12pm</strong>
            </v-col>
            <v-col>
              <strong>Lunch break</strong>
            </v-col>
          </v-row>
        </v-timeline-item>

        <v-timeline-item color="teal lighten-3" small>
          <v-row class="pt-1">
            <v-col cols="3">
              <strong>9-11am</strong>
            </v-col>
            <v-col>
              <strong>Finish Home Screen</strong>
              <div class="caption">
                Web App
              </div>
            </v-col>
          </v-row>
        </v-timeline-item>
      </v-timeline>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  name: 'My',
  data() {
    return {}
  },
  created() {},
  methods: {}
}
</script>
