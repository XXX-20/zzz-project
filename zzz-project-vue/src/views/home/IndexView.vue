<template>
    <div id="app-container">
        <div class="operation">
            <el-button @click="redirectToGenshinDmgCalPage">
                redirectToGenshinDmgCalPage
            </el-button>
            <el-button @click="redirectToBlogPage">
                redirectToBlogPage
            </el-button>
        </div>
    </div>
</template>

<script>
export default {
    name: "IndexView",
    methods: {
        redirectToGenshinDmgCalPage() {
            // 使用 router.push 导航到目标页面
            this.$router.push('/genshinDmgCal'); // '/target' 是目标页面的路由路径
        },
        redirectToBlogPage() {
            this.$router.push('/blog')
        }

    }
}
</script>

<style scoped>
#app-container {
    /*background-color: #15bd0f;*/
    /*height: 100vh;*/
}

.operation {
    /*height: 100px;*/
    /*width: 300px;*/
    /*background-color: #42b983;*/
}
</style>