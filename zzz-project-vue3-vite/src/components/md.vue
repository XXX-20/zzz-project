<script setup lang='ts'>
import {ref, reactive, onMounted, useAttrs} from 'vue'
import {getArticleContent} from '../api/blog/blog_article_content.js'

const mdTxt = ref()
getData()

function getData() {
    getArticleContent(1).then((response: { data: { content: string; }; }) => {
        mdTxt.value = response.data.content
    })
}

function save() {
    console.log(mdTxt)
    // 后面将数据从后端获取，并将数据返回到后端，就实现了在线文档。
}
</script>

<template>
    <v-md-editor v-model="mdTxt" height="400px" default-fullscreen @save="save"></v-md-editor>
</template>

<style scoped>
/* .md{
  width: 1000px;
} */
</style>