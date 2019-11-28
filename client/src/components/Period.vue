<template>
  <select id="select" v-model="period" @change="submit">
    <option disabled selected>Choose a period</option>
    <option value="overall">Overall</option>
    <option value="7day">7 days</option>
    <option value="1month">1 month</option>
    <option value="3month">3 months</option>
    <option value="6month">6 months</option>
    <option value="12month">12 months</option>
  </select>
</template>

<script>
export default {
  name: "period",
  data() {
    return {
      period: ""
    };
  },
  methods: {
    submit: function() {
      this.$emit("inputData", this.period);
    }
  }
};
</script>

<style scoped>
#select {
  border: none;
  padding: 10px;
  text-align: center;
  font-size: 16px;
  margin: 10px;
  width: 200px;
  border-radius: 10px;
  border: 1.5px solid #aaa;
  color: #ccc;
  background-color: transparent;
}

#select option {
  color: #ccc;
  background-color: #111;
  margin: 10px;
  font-weight: 700;
}

#select:focus {
  outline: none;
}
</style>