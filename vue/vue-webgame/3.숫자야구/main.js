import Vue from "vue"; //package.json 에 설치한 Vue 가져오는 것
//import NumberBaseball from "./NumberBaseball.vue"; //기존
import NumberBaseball from "./NumberBaseball"; //webpack.config > resolve > extensions 작성 시 작성한 .vue 확장자 제거 가능

new Vue(NumberBaseball).$mount("#root"); //el 역할
