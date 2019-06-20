<template>
    <div class="index">
        <div v-if="$store.state.auth">
            <button @click="logout">
                Logout
            </button>
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
    const Cookie = process.client ? require('js-cookie') : undefined

    export default {
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
