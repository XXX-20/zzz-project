<template>
    <div class="my-container">
        <div class="upper-half">
            <div class="title">{{ articleInfo.title }}</div>
            <div class="original-status">{{ articleInfo.originalStatus }}</div>
            <div class="create-time">{{ articleInfo.createTime }}</div>

        </div>
        <div class="under-half">
            <div class="type">{{ articleInfo.type }}</div>
            <div class="update-time">{{ articleInfo.updateTime }}</div>
        </div>
    </div>
</template>

<script setup>

const articleInfo = {
    title: "我是标题君",
    author: "作者君是我",
    // 日期的显示可以显示几分钟前，刚刚，几小时前，具体日期那种。
    createTime: "创立时间",
    updateTime: "更新日期",
    type: "文章分类",
    originalStatus: "是否原创"
}

</script>

<style scoped>
.my-container {
    width: 900px;
    height: 70px;
    background-color: white;
    border: 1px solid black;
    border-bottom: 2px solid black;
    display: grid;
    grid-template-columns: 100%;
    grid-template-rows: 1fr 1fr;
}

.upper-half {
    /*background-color: #6dc55f;*/
    /*通过flex布局使文本垂直居中*/
    display:flex;
    align-items:center;

}

.under-half {
    /*background-color: #d5a3d5;*/
    display:flex;
    align-items:center;
}

.title {
    width: 70%;
    float: left;
    font-size: 20px;
}

.original-status {
    width: 10%;
    float: left;
    font-size: 16px;
    text-align: right;
}

.create-time {
    width: 20%;
    float: right;
    font-size: 16px;
    text-align: right;
}

.type {
    width: 80%;
    float: left;
    font-size: 16px;
}

.update-time {
    width: 20%;
    float: right;
    font-size: 16px;
    text-align: right;
}

</style>