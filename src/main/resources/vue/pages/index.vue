<template>
    <div class="index">
        <div v-if="$store.state.auth">
            <h1>공군 위탁교육생 체계</h1>
            <h5>공군 위탁교육생 체계는 멋집니다. 마! 이게 UI다!</h5>
            <tabbar/>
            <div @click="logout">Logout</div>
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
    import Tabbar from "../components/tabbar";
    const Cookie = process.client ? require('js-cookie') : undefined

    export default {
        components: {Tabbar},
        methods: {
            logout() {
                Cookie.remove('auth')
                this.$store.commit('setAuth', null)
            },
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
