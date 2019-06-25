<template>
  <div class="index">
    <div v-if="$store.state.auth">
      <h1>공군 위탁교육생 체계</h1>
      <tabbar />
      <board-preview />
      <div @click="logout">
        Logout
      </div>
    </div>
    <p v-else>
      Please
      <NuxtLink to="/login">
        login
      </NuxtLink>
    </p>
  </div>
</template>

<script>
import tabbar from "../components/tabbar"
import BoardPreview from "../components/boardPreview"
const Cookie = process.client ? require('js-cookie') : undefined

export default {
  components: {BoardPreview, tabbar},
  methods: {
    logout() {
      Cookie.remove('auth')
      this.$store.commit('setAuth', null)
    }
  },
  layout: 'mainView',
  middleware: 'authenticated'
}
</script>

<style scoped>

    .index {
        flex: 1;
    }

</style>
