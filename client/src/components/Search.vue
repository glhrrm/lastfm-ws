<template>
  <a v-bind:href="submit" target="_blank">
    <div id="search-button">
      <i class="fa fa-code"></i>
    </div>
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
    }
  }
};
</script>

<style>
#search-button {
  border: none;
  padding: 10px;
  margin: 10px;
  text-align: center;
  border-radius: 10px;
  display: unset;
  border: 1.5px solid #aaa;
  color: #ccc;
  background-color: transparent;
}

#search-button a {
  color: #ccc;
}

#search-button:hover {
  background-color: darkred;
}
</style>