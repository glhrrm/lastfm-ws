<template>
  <a v-bind:href="submit" target="_blank">
    <button id="get-json-button">
      Get Json
    </button>
  </a>
</template>

<script>
export default {
  props: {
    username: String,
    period: String
  },
  computed: {
    submit() {
      if (this.username != "" && this.period != "") {
        return `http://localhost:8080/${this.username}/top-albums/${this.period}`;
      }
      return null;
    }
  }
};
</script>

<style>
* {
  font: inherit;
}

#get-json-button {
  border: none;
  padding: 10px;
  margin: 10px;
  text-align: center;
  border-radius: 10px;
  display: unset;
  border: 1.5px solid #aaa;
  color: #ccc;
  background-color: transparent;
  font-weight: 700;
  width: 100px;
  cursor: pointer;
}

#get-json-button:hover {
  background-color: darkred;
}

a {
  text-decoration: none;
}
</style>