<template>
  <div class="select">
    <select v-model="period">
      <option value="overall">Overall</option>
      <option value="7days">7 days</option>
      <option value="1month">1 month</option>
      <option value="3months">3 months</option>
      <option value="6months">6 months</option>
      <option value="12months">12 months</option>
    </select>
  </div>
</template>

<script>
export default {
  name: "period",
  data() {
    return {
      period: "overall"
    };
  }
};
</script>

<style scoped>
.select {
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