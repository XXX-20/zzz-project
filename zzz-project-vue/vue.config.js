const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // 会接收一个基于 webpack-chain 的 ChainableConfig 实例。
  // 允许对内部的 webpack 配置进行更细粒度的修改。
  chainWebpack: (config) => {
    config.module
        .rule("md")
        .test(/\.md/)
        .use("vue-loader")
        .loader("vue-loader")
        .end()
        .use("vue-markdown-loader")
        .loader("vue-markdown-loader/lib/markdown-compiler")
        .options({
          raw: true,
        });
  },
})
