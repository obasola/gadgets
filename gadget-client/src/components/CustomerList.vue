<template>

  <div>
  <h2>Customer List</h2>
   <table>
      <tr class="light-blue-6">
        <th>First Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Active</th>
      </tr>
      <tr v-for="cust in  customers" :key="cust.id">
        <td>{{cust.firstName}}</td>
        <td>{{cust.lastname}}</td>
        <td>{{cust.email}}</td>
        <td>{{cust.active}}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'CustomerList',
  data () {
    return {
      customers: []
    }
  },
  mounted() {
    this.$axios.defaults.headers.common['Content-Type'] = 'application/x-www-form-urlencoded';
    this.$axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
    this.$axios.get("http://localhost:8080/customers/")
    .then(response => {
      this.customers = response.data.results
    })
  }
}
</script>
