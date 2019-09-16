/**
 * webpack输出项
 *
 * @author chenzw
 * @type {module:path}
 */

const path = require('path');
const merge = require('webpack-merge');
const devConfig = require('../config');

module.exports = {
    path: devConfig.distPath,
    filename: 'assets/[name]/js/[name].js',
    chunkFilename: 'assets/[name]/js/[id].[chunkhash].bundle.js',

    // 使用绝对路径
    publicPath: '/'
}