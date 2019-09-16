const path = require('path');
const merge = require('webpack-merge');
const devConfig = require('./config');

module.exports = {
    mode: 'development',
    entry: require('./parts/webpack.entries.config'),
    output: require('./parts/webpack.output.config'),
    module: {
        rules: require('./parts/webpack.module.config')
    },
    plugins: Object.values(require('./parts/webpack.plugins.config')),
    resolve: require('./parts/webpack.resolve.config'),
    devServer: require('./parts/webpack.devserver.config')
}