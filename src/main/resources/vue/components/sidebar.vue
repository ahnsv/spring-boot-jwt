<template>
  <div class="sidebar">
    <div class="sidebar--logo">
      <NuxtLink to="/">
        Logo
      </NuxtLink>
    </div>
    <div class="sidebar--content">
      <div class="sidebar--content__menu">
        <div
          v-for="(block, index) in tree"
          :key="index"
          class="sidebar--content__menu--block"
        >
          <div class="sidebar--content__menu--title">
            {{ block.menu }}
          </div>
          <div
            v-for="(item, idx) in block.children"
            :key="idx"
            class="sidebar--content__menu--row"
            :class="{active: activeContent === idx+(block.children.length)}"
            @click="activeContent = idx+(block.children.length)"
          >
            <div class="menu--row__indicator" />
            <div class="menu--row__name">
              {{ item }}
            </div>
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
  name: "Sidebar",
  props: ['tree'],
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
        transition: all 250ms;
        background-color: rgb(var(--background-color));
        color: rgb(var(--color));
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

    .sidebar--logo > a {
        text-decoration: none;
        color: white;
        width: 50px;
        height: 50px;
        border-radius: 100%;
        display: flex;
        align-items: center;
        justify-content: center;
        background-color: #2E495E;
    }

    .sidebar--content__menu {
        display: flex;
        flex-direction: column;
        max-height: 85vh;
        overflow-y: auto;
    }

    .sidebar--content__menu--title {
        height: 50px;
        font-size: 1.3rem;
    }

    .sidebar--content__menu--row {
        display: flex;
        flex-direction: row;
        cursor: pointer;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        border-radius: 5px;
    }

    .sidebar--content__menu--row:hover {
        background-color: #656565;
        transition: all 200ms ease-in;
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