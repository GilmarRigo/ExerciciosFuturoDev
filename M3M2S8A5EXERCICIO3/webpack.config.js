const HtmlWebpackPlugin = require('html-webpack-plugin')
const path = require('path');

module.exports = {
  entry: './src/index.js',
  output: {
    path: path.resolve(__dirname + '/dist'),
    filename: 'main.js'
  }, 
  plugins:[
    new HtmlWebpackPlugin({
        filename: "index.html",
        template: "./src/index.html"
    })
  ]
};