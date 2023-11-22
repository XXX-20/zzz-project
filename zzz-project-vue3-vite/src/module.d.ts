//这个声明将告诉TypeScript如何处理.vue文件的导入。它使用了Vue的DefineComponent类型来声明.vue文件的组件类型。
declare module '*.vue' {
    import { DefineComponent } from 'vue';
    const component: DefineComponent<{}, {}, any>;
    export default component;
}

