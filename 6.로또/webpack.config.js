//node는 require, vue는 import
//const VueLoaderPlugin = require('vue-loader/lib/plugin'); //구버전
const { VueLoaderPlugin } = require("vue-loader"); //신버전
const path = require("path"); //node에서 절대경로 제공

module.exports = {
  //작성했기 때문에 require 가능
  mode: "development", //배포할때는 production
  devtool: "eval", //배포할때는 hidden-source-map
  resolve: {
    extensions: [".js", ".vue"], //확장자 처리
  },
  entry: { //시작
    app: path.join(__dirname, "main.js"),
  },
  module: { //entry 실행하다 오류 처리
    rules: [
      {
        test: /\.vue$/, //정규표현식 .vue로 끝나는 파일
        use: "vue-loader", //vue-loader가 자바스크립트 파일로 내부적으로 전환 loader: "vue-loader"도 사용가능
      },
      {
        test: /\.css$/,
        use: ["vue-style-loader", "css-loader"],
      },
    ],
  },
  plugins: [ //output 나오기 전에 처리, 한번 더 가공
    new VueLoaderPlugin(),
  ],
  output: { //최종 결과물
    //filename: "[name].js",
    filename: "app.js", //vue-loader 덕분에 하나의 자바스크립트 파일로 합칠 수 있다.
    path: path.join(__dirname, "dist"),
    publicPath: "/dist", //dev-server 사용시 추가 필요
  },
  //webpack의 장점 : 어떤 파일이든 다 하나의 자바스크립트 파일로 합쳐준다.
};
