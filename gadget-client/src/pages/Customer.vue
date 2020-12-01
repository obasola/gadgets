<template>
  
  <q-list>
    
      <div>
        <CustomerSearch />
      </div>
    
   
      <div>
        <CustomerList/>
      </div>
    
      <div>
        <CustomerEdit/>
      </div>
    
  </q-list>
</template>

<style lang="css"></style>

<script>
import CustomerEdit from '../components/CustomerEdit.vue'
import CustomerList from '../components/CustomerList.vue'
import CustomerSearch from '../components/CustomerSearch.vue'
import QCollapsible from 'quasar'

export default {
  components: { CustomerList, CustomerEdit, CustomerSearch },
  data() {
    return {
      customer: {}
    }
  },
  methods: {
     
  }
}
</script>
