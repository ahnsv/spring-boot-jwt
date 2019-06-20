<template>
    <div class="sidebar">
        <div class="sidebar--logo">Logo</div>
        <div class="sidebar--content">
            <div class="sidebar--content__menu">
                <div class="sidebar--content__menu--block"
                     v-for="(block, index) in ['test1', 'test2', 'test3']"
                     :key="index"
                >
                    <div class="sidebar--content__menu--title">
                        {{block}}
                    </div>
                    <div v-for="(item, idx) in [0,1,2,3,4,5]"
                         :key="idx" class="sidebar--content__menu--row"
                         :class="{active: activeContent === idx+(index*6)}"
                         @click="activeContent = idx+(index*6)"
                    >
                        <div class="menu--row__indicator"></div>
                        <div class="menu--row__name">{{item}}</div>
                    </div>
                </div>
            </div>
            <div class="sidebar--content__contact">
                Contact
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "sidebar",
        data() {
            return {
                activeContent: 0
            }
        }
    }
</script>

<style scoped>
    .sidebar {
        display: flex;
        flex-direction: column;
        min-width: 15vw;
    }


    .sidebar--content {
        flex: 1;
        display: flex;
        flex-direction: column;
        padding: 0 5%;
    }

    .sidebar--logo {
        min-height: 7vh;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .sidebar--content__menu {
        display: flex;
        flex-direction: column;
        max-height: 90vh;
        overflow-y: auto;
    }

    .sidebar--content__menu--title {
        height: 50px;
        font-size: 1.3rem;
    }

    .sidebar--content__menu--row {
        display: flex;
        flex-direction: row;
    }

    .sidebar--content__menu--row > div:first-child {
        width: 5px;
        transition: all 300ms linear;
    }

    .sidebar--content__menu--row.active > div:first-child {
        background-color: palevioletred;
        transition: all 300ms linear 300ms;
    }

    .sidebar--content__menu--row > div:last-child {
        height: 40px;
        display: flex;
        align-items: center;
        justify-content: flex-start;
        flex: 1;
        transition: all 300ms linear;
        padding: 0 10%;
    }

    .sidebar--content__menu--row.active > div:last-child {
        font-weight: bold;
        transition: all 300ms linear 300ms;
    }

    .sidebar--content__contact {
        margin-top: auto;
    }

</style>