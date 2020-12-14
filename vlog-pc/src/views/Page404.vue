<template>
  <div class="bg">
      <v-row>
        <v-col cols="12" md="12" justify="center" align="center">
          <h1>404</h1>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="12" md="12" justify="center" align="center">
          <h1 class="h1">Dispeared～</h1>
        </v-col>
      </v-row>
    <v-overlay absolute  z-index="5" class="mask"></v-overlay>
  </div>
</template>

<script>
export default {
  name: 'Page404',
  components:{
  },
  data() {
    return {}
  },
  created() {},
  methods: {}
}
</script>
<style lang="scss">
.bg {
  // width: 100%;
  height: 100vh;
  background: url('https://share--app.oss-cn-hangzhou.aliyuncs.com/bg/20201210231200.jpg');
  background-color: #666666;
  background-size: cover;
  background-image: fixed;
}
.mask {
  background-image: linear-gradient(to right, rgb(201, 214, 255), rgb(226, 226, 226));
  opacity: 0.45;
  z-index: 5;
}
.h1{
  color: #FFFF00;
  font-family:'Courier New';  
  font-size: 50px;
}
</style>
