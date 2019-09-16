/**
 * webpack dll配置
 *
 * @author chenzw
 * @type {module:path}
 */
const path = require('path');
const webpack = require('webpack');
const merge = require('webpack-merge');
const DllPlugin = webpack.DllPlugin;
const devConfig = require('./config');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');

const dllLibraryName = '_dll_[name]';

module.exports = {
    mode: 'development',
    entry: {
        vue: ['vue', 'vuex', 'axios'],
        vendor: ['jquery', 'element-ui', 'normalize.css', 'element-ui/lib/theme-chalk/index.css', 'font-awesome/css/font-awesome.css']
    },
    output: {
        filename: '[name].dll.js',
        path: devConfig.dllSrcPath,
        library: dllLibraryName
    },

    module: {
        rules: require('./parts/webpack.module.config')
    },

    plugins: [
        new DllPlugin({
            context: devConfig.srcPath,
            name: dllLibraryName,
            path: path.join(devConfig.dllSrcPath, '[name].manifest.json')
        }),
        new MiniCssExtractPlugin({
            filename: `[name].dll.css`,
            ignoreOrder: false
        })
    ]
}