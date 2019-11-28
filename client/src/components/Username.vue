<template>
  <input
    id="input"
    class="input has-text-centered"
    type="text"
    placeholder="Your Last.fm username"
    v-model="username"
    @input="submit"
  />
</template>

<script>
export default {
  name: "username",
  data() {
    return {
      username: ""
    };
  },
  methods: {
    submit: function() {
      this.$emit("inputData", this.username);
    }
  }
};
</script>

<style scoped>
#input {
  border: none;
  padding: 10px;
  text-align: center;
  font-size: 16px;
  margin: 10px;
  width: 300px;
  border-radius: 10px;
  border: 1.5px solid #aaa;
  color: #ccc;
  background-color: transparent;
}

#input::placeholder {
  color: #aaa;
}

#input:focus {
  outline: none;
  border-color: crimson;
  text-decoration: none;
}
</style>