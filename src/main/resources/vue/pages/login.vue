<template>
  <div class="login">
    <div class="login--plz">
      <div class="login--plz--logo">
        Logo
      </div>
      <div class="login--plz--content">
        공군 위탁교육생 체계에 로그인해주십시오
      </div>
    </div>
    <form
      action=""
      class="login--form"
    >
      <div class="login--form--username">
        <label class="login--form--username__label">군번</label>
        <input
          id="username"
          v-model="sn"
          type="text"
          class="login--form--username__input"
        >
      </div>
      <div class="login--form--password">
        <label class="login--form--password__label">비밀번호</label>
        <input
          id="password"
          v-model="pw"
          type="password"
          class="login--form--password__input"
          @keypress.enter="loginReq"
        >
      </div>
    </form>

    <transition name="fade">
      <error-dialog
        :error-msg="error.errorMsg"
        :is-error="error.isError"
        @confirm="error.isError = false"
      />
    </transition>
  </div>
</template>

<script>
import ErrorDialog from "../components/errorDialog"

const Cookie = process.client ? require('js-cookie') : undefined
import {signIn} from '../api'

export default {
  components: {ErrorDialog},
  middleware: 'notAuthenticated',
  data() {
    return {
      sn: '',
      pw: '',
      error: {
        isError: false,
        errorMsg: ''
      }
    }
  },
  methods: {
    async loginReq() {
      await signIn(this.sn, this.pw)
        .catch(err => {
          this.error = {
            isError: true,
            errorMsg: err
          }
        })
        .then((auth) => {
          this.$store.commit('setAuth', auth) // mutating to store for client rendering
          Cookie.set('auth', auth) // saving token in cookie for server rendering
          this.$router.push('/')
        })
    }
  },
  layout: 'loginView'
}
</script>

<style scoped>

    .login--plz, .login--form {
        color: white;
    }

    .login--plz {
        min-height: 25vh;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        max-width: 300px;
        word-break: keep-all;
        text-align: center;
    }

    form.login--form {
        min-height: 20vh;
        display: flex;
        flex-direction: column;
    }

    form.login--form > div {
        display: flex;
        flex-direction: column;
        margin: 5% 0;
    }

    .login--plz--logo {
        font-size: 2rem;
        font-weight: 700;
        width: 100px;
        height: 100px;
        border-radius: 100%;
        background-color: white;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .login--plz--content {
        font-size: 1.5rem;
        font-weight: lighter;
    }

    form.login--form input {
        border: none;
        border-radius: 10px;
        min-height: 40px;
        box-shadow: 3px 3px 3px #00000020;
        font-size: 1.3rem;
        padding-left: 10px;
    }

    form.login--form input:focus {
        outline: none;
    }

    form.login--form label {
        font-size: 1.5rem;
        font-weight: 500;
    }

    .fade-enter-active, .fade-leave-active {
        transition: opacity .5s;
    }

    .fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */
    {
        opacity: 0;
    }
</style>
