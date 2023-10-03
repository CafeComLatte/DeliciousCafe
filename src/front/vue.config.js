const path = require('path');
const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  
  transpileDependencies: true,
  outputDir: path.resolve(__dirname, '../main/resources/static'),
  chainWebpack(config) { //빌드 시 빌드되어 나오는 js파일을 js폴더 아래로 묶어 빌드한다

    config.output.filename("js/[name].js"); 
    
    
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
