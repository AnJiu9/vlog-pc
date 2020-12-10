<template>
  <v-row>
    <v-col cols="12" md = "4" v-for="(card, index) in cards" :key="index">
      <v-card class="mx-auto" max-width="400">
        <v-img class="white--text align-end" height="400px" :src="card.bgImg">
          <v-card-title>{{card.title}}</v-card-title>
        </v-img>
        <v-card-text class="text--primary"> 
          <div>{{card.content}}</div>
        </v-card-text>
        <v-card-actions>
          <v-btn color="orange" text>
            Share
          </v-btn>
          <v-btn color="orange" text>
            Explore
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name: 'Index',
  data: () => ({
    cards: []
  }),
  created() {
    this.axios.get('/cards').then((res) => {
      console.log(res.data.data)
      this.cards = res.data.data
    })
  }
}
</script>
<style scoped>
</style>
