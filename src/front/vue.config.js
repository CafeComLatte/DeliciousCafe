const path = require('path');
const { defineConfig } = require('@vue/cli-service');
const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin
//const UglifyJsPlugin = require('uglifyjs-webpack-plugin');
module.exports = defineConfig({
  configureWebpack:{
    plugins : [new BundleAnalyzerPlugin()]  
  },
  filenameHashing: true,
  transpileDependencies: true,
  productionSourceMap: false,
  outputDir: path.resolve(__dirname, '../main/resources/static'),
  chainWebpack(config) { //빌드 시 빌드되어 나오는 js파일을 js폴더 아래로 묶어 빌드한다
	//config.output.filename = 'js/[name].[contenthash:8].min.js'
	//config.output.chunkFilename = 'js/[name].[contenthash:8].min.js'
  },
  
  devServer: {
    proxy: {
		
      '/api': {
        // '/api' 로 들어오면 포트 8081(스프링 서버)로 보낸다
        target: 'http://localhost:8080',
        changeOrigin: true, // cross origin 허용
        secure : false 
      }
    }
  },
  
})
