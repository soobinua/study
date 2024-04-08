/** @format */

import { createApp } from "vue";
import { createPinia } from "pinia";
// import App from "./App1.vue";
import App from "./App2.vue";

const pinia = createPinia();
createApp(App).use(pinia).mount("#app");
