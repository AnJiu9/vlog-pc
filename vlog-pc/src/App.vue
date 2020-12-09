<template>
  <v-app id="app">
    <v-content>
      <router-view />
    </v-content>
  </v-app>
</template>
<style lang="scss">
.move {
  animation-duration: 0.6s;
  animation-delay: 0.2s;
}
</style>

<script>
// import HelloWorld from './components/HelloWorld'

export default {
  name: 'App',

  // components: {
  //   HelloWorld
  // },

  data: () => ({
    //
  })
}
</script>
