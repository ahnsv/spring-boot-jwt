<template>
    <div class="main">
        <sidebar :style="theme"/>
        <Nuxt class="main--content" :style="theme"/>
        <div class="dark-mode" @click="vantaBlack">button</div>
    </div>
</template>

<script>
    import Sidebar from "../components/sidebar";

    export default {
        name: "mainView",
        components: {Sidebar},
        transitions: 'default',
        computed: {
            theme() {
                const [color, backgroundColor] = this.$store.state.theme
                return {
                    '--color': color,
                    '--background-color': backgroundColor
                }
            }
        },
        created() {
            this.$nuxt.$on('toggle', (data) => {
                console.log(data);
                this.vantaBlack();
            })
        },
        methods: {
            // https://en.wikipedia.org/wiki/Vantablack
            vantaBlack() {
                let [color, backgroundColor] = this.$store.state.theme
                this.$store.commit('setTheme', [color, backgroundColor] = [backgroundColor, color])
            }
        }
    }
</script>

<style scoped>
    #__nuxt {
        transition: all 250ms;
        background-color: rgb(var(--background-color));
        color: rgb(var(--color));
    }

    .main {
        display: flex;
        flex-direction: row;
        height: 100vh;
    }

    .main--content {
        padding: 10px;
        transition: all 250ms;
        background-color: rgb(var(--background-color));
        color: rgb(var(--color));
    }

    .dark-mode {
        position: absolute;
        top: 0;
        background-color: rgb(var(--color));
        color: rgb(var(--background-color));
        right: 0;
        cursor: pointer;
        border-radius: 10px;
        padding: 2%;
    }

</style>