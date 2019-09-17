/**
 * webpack插件配置
 * @author chenzw
 * @type {module:path}
 */
const path = require('path');
const webpack = require('webpack');
const devConfig = require('../config');

const {AutoWebPlugin} = require('web-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const VueLoaderPlugin = require('vue-loader/lib/plugin');
const CopyWebpackPlugin = require("copy-webpack-plugin");


const autoWebPlugin = new AutoWebPlugin(devConfig.pagesPath, {

    // 模版页
    template: (pageName) => {
        return path.resolve(devConfig.pagesPath, pageName, 'template.html');
    },

    // 生成的文件名
    filename: (pageName) => {
        return path.join('views', pageName, 'index');
    },
    // 生成pagemap.json
    outputPagemap: true,
    hash: true,

    // 引入其它chunk
    requires: devConfig.dllAssets
});

module.exports = {
    // 将src的dll文件拷贝到dist目录
    copyWebpackPlugin: new CopyWebpackPlugin([{
        from: devConfig.dllSrcPath,
        to: devConfig.distPath
    }]),

    providePlugin: new webpack.ProvidePlugin({
        'window.jQuery': 'jquery',
        $: 'jquery',
        Vue: ['vue']
    }),
    autoWebPlugin,
    vueLoaderPlugin: new VueLoaderPlugin(),

    // 提取CSS文件
    miniCssExtractPlugin: new MiniCssExtractPlugin({
        filename: `assets/[name]/css/[name].css`,
        ignoreOrder: false
    }),

    hotModuleReplacementPlugin: new webpack.HotModuleReplacementPlugin(),

    vendorDllReferencePlugin: new webpack.DllReferencePlugin({
        context: devConfig.srcPath,
        manifest: require(path.join(devConfig.dllSrcPath, 'vendor.manifest.json'))
    }),
    vueDllReferencePlugin: new webpack.DllReferencePlugin({
        context: devConfig.srcPath,
        manifest: require(path.join(devConfig.dllSrcPath, 'vue.manifest.json'))
    })

}