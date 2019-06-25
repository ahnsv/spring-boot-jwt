<template>
    <div class="board-preview">
        <table class="board-preview--table">
            <tbody>
            <tr>
                <th v-for="(item, id) in cols" :key="id">{{item}}</th>
            </tr>
            <tr>
                <td v-for="(d, key) in data" :key="key">{{d}}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {
        name: "boardPreview",
        data() {
            return {
                cols: ['A', 'B', 'C', 'D'],
                data: ['E', 'F', 'G', 'H']
            }
        }
    }
</script>

<style scoped>
.board-preview--table {
    width: 100%;
    text-align: center;
}
</style>