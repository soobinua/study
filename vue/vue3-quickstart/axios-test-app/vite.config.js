/** @format */

import { fileURLToPath, URL } from "node:url";

import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      "@": fileURLToPath(new URL("./src", import.meta.url)),
    },
  },
  // 크로스 오리진 : 프록시를 이용한 우회로 해결하기
  server: {
    proxy: {
      "/api": {
        //요청 경로가 /api로 시작하는 경우 프록시를 통해 target경로로 전달
        target: "http://localhost:8000",
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, ""),
        //정규식 : 최초 요청 경로에서 "/api"부분을 찾아 빈문자열로 변경하고( /api문자열 제거) 나머지 부분만 경로로 덧붙여 요청 전달
      },
    },
  },
  //최초 요청 경로 : /api/todolist/gdhong
  //타깃 : http://localhost:8000
  //최종 전달 경로 : http://localhost:8000/todolist/gdhond
});
