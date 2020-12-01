<template>
<<<<<<< HEAD
  <q-page padding>
    <!-- content -->
    <h1>Customers</h1>
  </q-page>
</template>

<script>
export default {
  // name: 'PageName',
=======
  <Search />
</template>

<style lang="css"></style>

<script>
export default {
  data: {

  },
  methods: {
      loadData () {
    this.$axios.get('/api/backend')
      .then((response) => {
        this.data = response.data
      })
      .catch(() => {
        this.$q.notify({
          color: 'negative',
          position: 'top',
          message: 'Loading failed',
          icon: 'report_problem'
        })
      })
  }
>>>>>>> master
}
</script>
