<template>
  <v-row align="start">
    <v-col cols="20" md="3">
    </v-col>
    <v-col cols="20" md="8">
        <v-card
            class="mx-auto"
            max-width="500"
            tile>
            <v-list rounded>
            <v-subheader>HEALTH</v-subheader>
            <v-list-item-group
                v-model="selectedItem"
                color="primary">
                <v-list-item
                v-for="(item, i) in items"
                :key="i">
                <v-list-item-icon>
                    <v-icon v-text="item.icon"></v-icon>
                </v-list-item-icon>
                <v-list-item-content>
                    <v-list-item-title v-text="item.text"></v-list-item-title>
                </v-list-item-content>
                </v-list-item>
            </v-list-item-group>
        </v-list>
    </v-card>
  </v-col>
  <v-col cols="20" md="9" class="ml-12">
       <v-sparkline></v-sparkline>
    </v-col>
  </v-row>
</template>
<script>
import Sparklines from '../components/Sparklines'
export default {
  name: 'Health',
  components:{
    'v-sparkline':Sparklines
  },
  data: () => ({
      selectedItem: 1,
      items: [
        { text: '身高', icon: 'mdi-human' },
        { text: '体重', icon: 'mdi-food-drumstick-off' },
        { text: '步数', icon: 'mdi-shoe-print' },
        { text: '牙齿健康', icon: 'mdi-tooth' },
        { text: '吃药', icon: 'mdi-pill' },
        { text: '正念分钟数', icon: 'mdi-head-lightbulb-outline' },
      ],
    }),
  created() {},
  methods: {}
}
</script>