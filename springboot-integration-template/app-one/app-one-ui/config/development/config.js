/**
 * 开发环境配置项
 *
 * @type {module:path}
 */
const path = require('path');
const merge = require('webpack-merge');


const rootPath = path.resolve(process.cwd());
const srcPath = path.resolve(rootPath, 'src');
const distPath = path.resolve(rootPath, 'dist');
const pagesPath = path.resolve(srcPath, 'pages');
const assetsPath = path.resolve(srcPath, 'assets');
const dllSrcPath = path.resolve(srcPath, 'dll');
const assetDistPath = path.resolve(distPath, 'assets');

module.exports = {
    rootPath,
    srcPath,
    distPath,
    pagesPath,
    assetsPath,
    dllSrcPath,
    assetDistPath,

    // dll资源文件
    dllAssets: [
        path.join(dllSrcPath, 'vendor.dll.js'),
        path.join(dllSrcPath, 'vendor.dll.css'),
        path.join(dllSrcPath, 'vue.dll.js')
    ],

    // 服务器端口
    port: 9999
};

