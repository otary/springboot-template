/**
 * webpack entry配置
 *
 * @author chenzw
 * @type {module:path}
 */
const path = require('path');
const merge = require('webpack-merge');
const devConfig = require('../config');

const webpackPluginsConfig = require('./webpack.plugins.config');


// 多页面entry
module.exports = webpackPluginsConfig.autoWebPlugin.entry({});