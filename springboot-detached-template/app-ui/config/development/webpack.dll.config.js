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
        rules: [
            {
                test: /\.(sa|sc|c)ss$/,
                use: [{
                    loader: MiniCssExtractPlugin.loader,
                    options: {
                        hmr: false,
                    },
                }, 'css-loader', 'postcss-loader', 'sass-loader']
            }, {
                test: /\.(js|jsx)$/,
                use: [{
                    loader: 'babel-loader'
                }],

                // 排除 node_modules 目录下的文件（node_modules 目录下的文件都是采用的 ES5 语法，没必要再通过 Babel 去转换）
                exclude: /node_modules/
            }, {
                test: /\.(gif|png|jpe?g|pdf)$/,
                use: ['file-loader']
            }, {
                test: /\.(mp4|webm|ogg|mp3|wav|flac|aac)(\?.*)?$/,
                loader: 'url-loader',
                options: {
                    limit: 10000,
                    name: 'assets/media/[name].[hash:7].[ext]'
                }
            }, {
                test: /\.(woff2?|eot|ttf|otf)(\?.*)?$/,
                use: [{
                    loader: 'url-loader',
                    options: {
                        name: 'assets/fonts/[name].[hash:8].[ext]',
                        limit: 10000
                    }
                }]
            }, {
                test: /\.svg(\?v=\d+\.\d+\.\d+)?$/,
                use: [{
                    loader: 'url-loader',
                    options: {
                        limit: 10000,
                        mimeType: 'image/svg+xml',
                        name: 'assets/imgs/[name].[hash:8].[ext]'
                    }
                }]
            }, {
                test: /\.vue$/,
                use: ['vue-loader'],
                exclude: /node_modules/
            }
        ]
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