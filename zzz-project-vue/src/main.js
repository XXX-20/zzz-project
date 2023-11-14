import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'


import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

// markdown样式
import "github-markdown-css";
// 代码高亮
import "highlight.js/styles/github.css"; //默认样式

createApp(App).use(store).use(router).use(ElementPlus).mount('#app')