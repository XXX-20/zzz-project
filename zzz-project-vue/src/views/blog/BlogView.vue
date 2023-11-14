<template>
    <div id="home">
        <div id="left-side">
            <h1>我是做侧边栏</h1>
            12
        </div>
        <div id="main">
            <div id="main-content">
                <!--走马灯（轮播图）-->
                <div class="carousel">
                    <el-carousel :interval="3000" type="card" height="300px" autoplay>
                        <el-carousel-item v-for="url in urls" :key="url">
                            <el-image :src="url"/>
                        </el-carousel-item>
                        <div class="carousel-blur"></div>
                    </el-carousel>
                </div>
                <!--文章部分-->
                <div class="for-flow">
                    <div id="article">
                        <div class="article-title">
                            <h1>我是标题</h1>
                        </div>
                        <div class="article-content">
                            <demo-md class="markdown-body"></demo-md>
                        </div>
                        <div class="article-desc">
                            <p>我是文章相关数据信息</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div id="right-side">
            <nav id="catalog">
                <h3>目录</h3>
                <ul>
                    <li></li>
                </ul>
            </nav>
        </div>
    </div>
  <!--    个性化工具拓展栏-->
    <div id="custom-toolbar extend">

    </div>
</template>


<script setup>
import DemoMd from '../../../public/md/test.md'

const urls = [
    require('@/assets/carousel_img/1.jpeg'),
    require('@/assets/carousel_img/2.jpeg'),
    require('@/assets/carousel_img/3.jpg'),
    require('@/assets/carousel_img/4.jpeg')]

</script>

<style scoped>


#home {
    display: grid;
    grid-template-columns: 14vw 1fr 19vw;
    grid-template-rows: 1fr 1fr 1fr;
    /*三行三列，宽度对应grid-template-rows， 长度对应grid-template-columns，在浏览器的devTools看的更直观*/
    grid-template-areas:
        "left main right"
        "left main right"
        "left main right";
    height: 100vh;
}

#main {
    grid-area: main;
    display: grid;
    grid-template-rows: 1fr;
    grid-template-columns: 1fr;
}

#main-content {
    position: relative;
    padding: 20px;
    background-color: #f2f3f5;
    overflow: auto;
}

.carousel {
    position: relative;
    z-index: 3;
}

.carousel-blur {
    background-color: #090909;
    left: 0;
    top: 0;
    margin: 0;
    width: 100%;
    position: absolute;
    height: 100%;
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center;
    opacity: .9;
    z-index: -1;
    filter: blur(50px);
}

.el-carousel__item h3 {
    color: #475669;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
    text-align: center;
}

.for-flow {
    z-index: 2;
}

#article {
    margin-top: 10px;
    padding: 16px 16px 0;
    animation: content-in .5s ease-in 0s;
    border-radius: 4px;
    /*background-color: #f7f8fa;*/
    overflow: hidden;
}

#article .article-title {

}

#article .article-title h1 {
    font-size: 36px;
    line-height: 1.389;
    font-weight: 700;
    color: #262626;
    display: inline;
}

#article .article-content {

}


/*滚动条显示样式*/
::-webkit-scrollbar-thumb {
    background-color: #73ff6e; /*更改喜欢的十六进制颜色*/
    height: 50px;
    outline-offset: -2px;
    outline: 2px solid #fff;
    -webkit-border-radius: 4px;
    border: 2px solid #fff;
}

/*滚动条大小*/
::-webkit-scrollbar {
    width: 10px;
    height: 10px;
}

/*滚动框背景样式*/
::-webkit-scrollbar-track-piece {
    background-color: #fff;
    -webkit-border-radius: 0;
}

</style>