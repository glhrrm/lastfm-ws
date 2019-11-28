<template>
  <div class="container">
    <div class="field is-grouped">
      <div class="control">
        <input
          class="input has-text-centered"
          type="text"
          placeholder="Your Last.fm username"
          v-model="username"
        />
      </div>
      <div class="control">
        <div class="select">
          <select v-model="period">
            <option value="overall">Overall</option>
            <option value="7day">7 days</option>
            <option value="1month">1 month</option>
            <option value="3month">3 months</option>
            <option value="6month">6 months</option>
            <option value="12month">12 months</option>
          </select>
        </div>
      </div>
      <div class="control">
        <a class="button" v-bind:href="send">
          <span class="icon is-small">
            <i class="fa fa-search"></i>
          </span>
        </a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "username",
  data() {
    return {
      username: "",
      period: ""
    };
  },
  computed: {
    send() {
      if (this.username != "" && this.period != "") {
        return (
          "http://localhost:8080/" +
          this.username +
          "/top-albums/" +
          this.period
        );
      }
    }
  }
};
</script>

<style scoped>
.control {
  border-radius: 50
}
</style>