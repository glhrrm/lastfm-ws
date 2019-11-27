<template>
  <div class="row">
    <div class="columns">
      <div class="column is-half is-offset-one-quarter">
        <div class="field is-grouped">
          <p class="control is-exformanded">
            <input
              class="input is-primary has-text-centered"
              type="text"
              placeholder="Your Last.fm username"
              v-model="username"
              v-bind:href="serverSelected"
            />
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { serverBus } from '../main'

export default {
  name: "username",
  data() {
    return {
      username: ""
    };
  },
  methods: {
      serverSelected() {
          serverBus.$emit("serverSelected", this.server)
      }
  }
};
</script>

<style scoped>
.input {
  border-left: 0;
  border-right: 0;
  border-top: 0;
  border-radius: 0;
  outline: none;
  box-shadow: none;
}
.input.is-primary:focus {
  box-shadow: none;
}
.add-button {
  border-radius: 50%;
}
</style>