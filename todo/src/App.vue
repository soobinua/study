<template>
  <div id="app" class="container">
    <h1 class="text-center">Todo App</h1>
    <input
      v-model="todoText"
      type="text"
      class="w-100 p-2"
      placeholder="Type todo"
      @keyup.enter="addTodo"
    />
    <hr />
    <ToDo
      v-for="todo in todos"
      :key="todo.id"
      :todo="todo"
      @toggle-checkbox="toggleCheckbox"
      @click-delete="deleteTodo"
    />
    {{ todos }}
  </div>
</template>

<script>
import ToDo from "./components/ToDo.vue";

export default {
  components: {
    ToDo,
  },
  data() {
    return {
      todoText: "",
      todos: [
        { id: 1, text: "learn vue", checked: true },
        { id: 2, text: "learn java", checked: false },
      ],
    };
  },
  methods: {
    addTodo(e) {
      this.todos.push({
        id: Math.random(),
        text: e.target.value,
        checked: false,
      });
      this.todoText = "";
    },
    toggleCheckbox({ id, checked }) { //자식 컴포넌트에서 보낸 값
      const index = this.todos.findIndex((todo) => {
        return todo.id === id;
      });
      this.todos[index].checked = checked;
    },
    deleteTodo(id) {
      // case1.
      // const index = this.todos.findIndex((todo) => {
      //   return todo.id === id;
      // });
      // this.todos.splice(index, 1);
      // case 2.
      this.todos = this.todos.filter((todo) => todo.id !== id);
    },
  },
};
</script>
