/** @format */
import { defineStore } from "pinia";
import { reactive, computed } from "vue";

//옵션 API 방식의 todoList1 스토어
export const useTodoList1Store = defineStore("todoList1", {
  state: () => ({
    todoList: [
      { id: 1, todo: "ES6 Study", done: false },
      { id: 2, todo: "React Study", done: false },
      { id: 3, todo: "Vue Study", done: false },
      { id: 4, todo: "swimming", done: true },
    ],
  }),
  getters: {
    doneCount: (state) => {
      return state.todoList.filter((todoItem) => todoItem.done === true).length;
    },
  },
  actions: {
    addTodo(todo) {
      this.todoList.push({ id: new Date().getTime(), todo, done: false });
    },
    deleteTodo(id) {
      this.todoList = this.todoList.filter((item) => item.id !== id);
      // let index = this.todoList.findIndex((todo) => todo.id === id);
      // this.todoList.splice(index, 1);
    },
    toggleDone(id) {
      let index = this.todoList.findIndex((todo) => todo.id === id);
      this.todoList[index].done = !this.todoList[index].done;
    },
  },
});

//컴포지션 API 방식의 todoList2 스토어
export const useTodoList2Store = defineStore("todoList2", () => {
  const state = reactive({
    todoList: [
      { id: 1, todo: "ES6 Study", done: false },
      { id: 2, todo: "React Study", done: false },
      { id: 3, todo: "Vue Study", done: false },
      { id: 4, todo: "swimming", done: true },
    ],
  });
  const addTodo = (todo) => {
    state.todoList.push({ id: new Date().getTime(), todo, done: false });
  };
  const deleteTodo = (id) => {
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList.splice(index, 1);
  };
  const toggleDone = (id) => {
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList[index].done = !state.todoList[index].done;
  };
  const doneCount = computed(() => {
    return state.todoList.filter((todoItem) => todoItem.done === true).length;
  });
  const todoList = computed(() => state.todoList);

  return { todoList, doneCount, addTodo, deleteTodo, toggleDone };
});
