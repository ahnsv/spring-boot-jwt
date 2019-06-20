<template>
    <Nuxt class="main--login"/>
</template>

<script>
    export default {
        name: "loginView",
        transitions: 'default'
    }
</script>

<style scoped>
    .main--login {
        height: 100vh;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        background-color: #2E495E;
        color: white;
    }
</style>