<template>
  <div
    v-if="isError"
    class="error-dialog"
  >
    <div class="error-dialog--message">
      {{ errorMsg }}
    </div>
    <div class="error-dialog--console">
      <div
        class="error-dialog--console__confirm"
        @click="confirm"
      >
        확인
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ErrorDialog",
  props: ['errorMsg', 'isError'],
  methods: {
    confirm() {
      this.$emit('confirm')
    }
  }
}
</script>

<style scoped>

    .error-dialog {
        position: absolute;
        background-color: lightcoral;
        border-radius: 10px;
        padding: 5vh;
        font-size: 1.5rem;
        display: flex;
        flex-direction: column;
        align-items: flex-end;
        font-weight: bold;
    }

    .error-dialog--console__confirm {
        border: 1px solid;
        border-radius: 10px;
        padding: 5px 10px;
        font-weight: lighter;
        font-size: 1.2rem;
    }

    .error-dialog--message {
        margin: 5vh 0;
    }

</style>