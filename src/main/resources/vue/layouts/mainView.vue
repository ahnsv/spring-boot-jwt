<template>
    <div class="main">
        <sidebar/>
        <Nuxt class="main--content"/>
    </div>
</template>

<script>
    import Sidebar from "../components/sidebar";

    export default {
        name: "mainView",
        components: {Sidebar},
        transitions: 'default'
    }
</script>

<style scoped>
    .main {
        display: flex;
        flex-direction: row;
        height: 100vh;
    }

    .main--content {
        padding: 10px;
    }

</style>