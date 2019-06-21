<template>
    <div class="tabbar">
        <div class="tabbar--col"
             v-for="(item, index) in ['test1', 'test2', 'test3', 'test4']"
             :key="index"
             :class="{ active: activeContent === index}"
        >
            <div class="tabbar--content" @click="activeContent = index">{{item}}</div>
            <div class="tabbar--indicator"></div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "tabbar",
        data() {
            return {
                activeContent: 0
            }
        }
    }
</script>

<style scoped>
    .tabbar {
        display: flex;
        flex-direction: row;
        font-size: 1.2rem;
    }

    .tabbar--col {
        display: flex;
        flex-direction: column;
        margin-right: 1%;
        transition: all 300ms linear;
    }

    .tabbar--indicator {
        height: 3px;
    }

    .tabbar--content {
        color: inherit;
        padding: 10px;
        cursor: pointer;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        border-radius: 5px;
    }

    .tabbar--content:hover {
        background-color: #656565;
        transition: all 200ms ease-in;
    }

    .tabbar--col.active > .tabbar--indicator {
        background-color: #00C48D;
        transition: all 300ms linear;
    }

    .tabbar--col.active > .tabbar--content {
        color: inherit;
        font-weight: bold;
        transition: color 300ms linear;
    }
</style>