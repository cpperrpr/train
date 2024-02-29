const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
    devServer: {

      port: 8000 // 此处修改你想要的端口号
    }
})
// module.exports = {
//   devServer: {
//
//     port: 9000 // 此处修改你想要的端口号
//
//   }
//
// }
