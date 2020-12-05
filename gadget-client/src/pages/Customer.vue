<template>
  <q-page padding>
    <!-- content -->
    <h1>Customers</h1>
  </q-page>
</template>


<style lang="css"></style>

<script>
export default {
  data() {
    return {
      customers: []
    }
  },
  methods: {
     
  },
  mounted() {
    axios.get("http://localhost:3000/api/backend/customers")
    .then(response => {
      this.customers = response.data.results
    })
  }
}
</script>