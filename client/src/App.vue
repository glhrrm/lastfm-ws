<template>
  <div id="app">
    <div class="inline">
      <Logo />
    </div>
    <div class="inline">
      <Username v-on:inputData="updateUsername" />
    </div>
    <div class="inline">
      <Period v-on:inputData="updatePeriod" />
      <Search v-bind:username="username" v-bind:period="period" />
    </div>
    <div class="inline">
      <AlbumList v-bind:username="username" v-bind:period="period" />
    </div>
  </div>
</template>

<script>
import Logo from "./components/Logo";
import Username from "./components/Username";
import Period from "./components/Period";
import Search from "./components/Search";
import AlbumList from "./components/AlbumList";

export default {
  components: {
    Logo,
    Username,
    Period,
    AlbumList,
    Search
  },
  data() {
    return {
      username: "",
      period: "",
      topAlbums: ""
    };
  },
  methods: {
    updateUsername(variable) {
      this.username = variable;
    },
    updatePeriod(variable) {
      this.period = variable;
    }
  }
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css?family=IBM+Plex+Sans:400,700&display=swap");

* {
  box-sizing: border-box;
  font-family: "IBM Plex Sans", sans-serif;
}

#app {
  background-color: #111;
  background-image: url("./assets/background.png");
  height: 100%;
  padding: 50px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.inline {
  display: inline-block;
}
</style>