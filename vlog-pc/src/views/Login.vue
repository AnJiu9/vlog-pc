<template>
  <div class="bg row">
    <v-form ref="form" v-model="valid" lazy-validation class="col">
      <v-text-field v-model="name" :counter="10" :rules="nameRules" label="Name" required></v-text-field>

      <v-text-field v-model="email" :rules="emailRules" label="E-mail" required></v-text-field>

      <v-select
        v-model="select"
        :items="items"
        :rules="[(v) => !!v || 'Item is required']"
        label="Item"
        required
      ></v-select>

      <v-checkbox
        v-model="checkbox"
        :rules="[(v) => !!v || 'You must agree to continue!']"
        label="Do you agree?"
        required
      ></v-checkbox>

      <v-btn :disabled="!valid" color="success" class="mr-4" @click="validate">
        Validate
      </v-btn>

      <v-btn color="error" class="mr-4" @click="reset">
        Reset Form
      </v-btn>

      <v-btn color="warning" @click="resetValidation">
        Reset Validation
      </v-btn>
    </v-form>
    <v-overlay absolute  z-index="5" class="mask"></v-overlay>
  </div>
</template>
<script>
export default {
  name: 'Login',
  data: () => ({
    valid: true,
    name: '',
    nameRules: [
      (v) => !!v || 'Name is required',
      (v) => (v && v.length <= 10) || 'Name must be less than 10 characters'
    ],
    email: '',
    emailRules: [(v) => !!v || 'E-mail is required', (v) => /.+@.+\..+/.test(v) || 'E-mail must be valid'],
    select: null,
    items: ['Item 1', 'Item 2', 'Item 3', 'Item 4'],
    checkbox: false
  }),

  methods: {
    validate() {
      this.$refs.form.validate()
    },
    reset() {
      this.$refs.form.reset()
    },
    resetValidation() {
      this.$refs.form.resetValidation()
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
