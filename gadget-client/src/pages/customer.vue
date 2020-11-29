<template>
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
}
</script>
