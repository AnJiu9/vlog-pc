<template>
  <div class="bg row">
    <v-form ref="form" v-model="valid" lazy-validation class="col" v-if="!flag">
      <v-text-field v-model="phone" :counter="11" :rules="phoneRules" label="Phone" required></v-text-field>

      <v-text-field v-model="password" :rules="passRules" label="Password" required></v-text-field>

      <v-checkbox
        v-model="checkbox"
        :rules="[(v) => !!v || '同意才能继续!']"
        label="同意社区协议?"
        required
      ></v-checkbox>

      <v-btn :disabled="!valid" color="success" class="mr-4" @click="validate">
        验证
      </v-btn>

      <v-btn color="primary" class="mr-4" @click="submit">
        登录
      </v-btn>

      <v-btn color="warning" @click="reset">
        重置
      </v-btn>
    </v-form>

    <v-dialog v-model="flag" max-width="500" v-else>
      <v-card>
        <v-card-title class="headline grey lighten-2">
          登录成功
        </v-card-title>
        <v-img height="250" src="https://share--app.oss-cn-hangzhou.aliyuncs.com/avatar/20201205181922.jpg"></v-img>
        <v-card-text>
          现在进入我的博客
        </v-card-text>

        <v-divider></v-divider>

        <v-card-actions>
          <v-spaver></v-spaver>
          <v-btn color="primary" text @click="flag = false">
            I accept
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
    <v-overlay absolute  z-index="5" class="mask"></v-overlay>
  </div>
</template>
<script>
export default {
  name: 'Login',
  data: () => ({
    flag: false,
    valid: true,
    phone: '',
    phoneRules: [
      (v) => !!v || '手机号不能为空',
      (v) => (v && v.length === 11) || '手机号必须为11位'
    ],
    password: '',
    passRules: [(v) => !!v || '密码不能为空', (v) => (v.length >=6 && v.length <= 10) || '密码必须在6到10位之间'],
    checkbox: false
  }),

  created(){},

  methods: {
    validate() {
      this.$refs.form.validate()
    },
    reset() {
      this.$refs.form.reset()
    },
    submit(){
      this.axios({
        method: 'POST',
        url: '/user/login',
        data: {
          phone: this.phone,
          password: this.password
        }
      }).then((res) => {
        if(res.data.code === 1){
          this.flag = true
          this.$store.commit('login', res.data.data);
          this.$router.push('/')
        }
      })
    }
  }
}
</script>
<style lang="scss">
.row {
  display: flex;
  align-items: center;
  justify-content: center;
  .col {
    flex: 0 0 40%;
    background-color: #eee;
    border-radius: 10px;
    z-index: 10;
  }
}
.bg {
  width: 100%;
  height: 100vh;
  background: url('https://student-management-img.oss-cn-hangzhou.aliyuncs.com/bk-image/20201209234242.jpeg');
}
.mask {
  background-image: linear-gradient(to right, #bf30ac 0%, #0f9d58 100%);
  opacity: 0.45;
  z-index: 5;
}
</style>
