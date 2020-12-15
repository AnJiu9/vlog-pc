<template>
  <v-app>
    <!-- 顶部导航，父组件定位提供容器，引入封装的导航组件 -->
    <v-app-bar height="56px" elevation="0" fixed class="nav-transparent">
      <nav-bar></nav-bar>
    </v-app-bar>
    <!-- 主体内容 -->
    <v-main>
      <v-carousel cycle height="800" hide-delimiter-background show-arrows-on-hover>
        <v-carousel-item v-for="(slide, i) in slides" :key="i">
          <v-sheet height="100%">
            <v-row class="fill-height">
              <img :src="slide.src" class="slider-img" width="100%" height="100%" style="opacity:0.5"/>
            </v-row>
          </v-sheet>
        </v-carousel-item>
      </v-carousel>

      <v-row style="width: 80%; margin:0 auto; margin-top:-10px;">
        <v-col cols="12" md = "6" v-for="(article, index) in indexList" :key="index">
          <v-card class="rounded-lg" elevation="12" height="500">
            <v-img class="white--text" :src="article.cover" height="100%" style="text-align:center;">
              <h4 class="light-grey--text my-12">{{article.category}}</h4>
              <h1 class="my-12">{{article.title}}</h1>
              <p class="text-md-h6 light-grey--text mt-6 px-12">{{article.summary}}</p>
              <v-btn rounded dark elevation="12" class="mt-6 px-12 py-6 green-btn">
                <h3>阅读更多</h3>
              </v-btn>
            </v-img>
          </v-card>
        </v-col>
      </v-row>

      <v-row style="width:80%; margin:0 auto;margin-top:10px;">
        <v-col cols="12" md="4" v-for="(article, index) in otherList" :key="index">
          <v-card class="rounded-lg" elevation="12" height="550">
            <v-img class="white--text align-end" height="55%" :src="article.cover"> 
              <h2 class="px-3 mb-6">{{article.title}}</h2>
            </v-img>
            <v-card-text class="text--primary">
              <div class="grey--text text-md-h6 display">
                {{article.summary}}
              </div>
              <v-row justify="space-between" class="px-3 mt-5 text-md-h6 font-weight-regular">
                <span>{{article.publishDate}}</span>
                <div>
                  <v-icon color="#38485C">
                    mdi-bookmark
                  </v-icon>
                  <span>{{article.category}}</span>
                </div>
              </v-row>
            </v-card-text>
            <v-card-actions>
              <v-btn class="bg-color" text v-for="(tag, index) in article.tagList" :key="index">
                {{tag.tagName}}
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-main>
    <my-footer></my-footer>
  </v-app>
</template>

<script>
import { mapState } from 'vuex'
import NavBar from '../components/NavBar'
import MyFooter from '../components/MyFooter'
export default {
  name: 'Index',
  data: () => ({
    articles: [],   //所有文章数组
    indexList: [],  //推荐文章数组
    otherList: [],  //其他文章数组
    slides: [
      {
        src: 'https://share--app.oss-cn-hangzhou.aliyuncs.com/bg/20201214163901.jpeg'
      },
      {
        src: 'https://share--app.oss-cn-hangzhou.aliyuncs.com/bg/20201214164702.jpeg'
      },
      {
        src: 'https://share--app.oss-cn-hangzhou.aliyuncs.com/bg/20201214164910.png'
      },
      {
        src: 'https://share--app.oss-cn-hangzhou.aliyuncs.com/bg/20201214165036.jpeg'
      },
    ]
  }),
  components: {
    NavBar,
    MyFooter
  },
  computed: {
    ...mapState({
      loginStatus: (state) => state.loginStatus,
      user: (state) => state.user
    })
  },
  created() {
    this.axios.get('/article/all').then((res) => {
      console.log(res.data.data.length)
      this.articles = res.data.data
      this.indexList = this.articles.filter(this.recommended) //过滤数组
      this.otherList = this.articles.filter(this.other)
    })
  },
  methods:{
    //根据是否有发布日期过滤出推荐文章
    recommended(element){
      return element.publishDate === null
    },
    //过滤其他文章
    other(element){
      return element.publishDate != null
    }
  }
}
</script>
<style lang="scss" scoped>
//推荐文章的卡片上的“阅读更多”按钮样式
.green-btn{
  width: 140px;
  height: 80px;
  background: linear-gradient(to right, #77b489 0%, #c2c46c 100%);
}
//导航条透明样式
.nav-transparent{
  background-color: transparent !important;
  background-image: none;
  box-shadow: none;
}
//文章摘要内容限制3行
.display{
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
}
</style>
