<template>
  <div>
    <h1>Movies</h1>
    <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      first-text="First"
      prev-text="Prev"
      next-text="Next"
      last-text="Last"
    ></b-pagination>
     <b-table striped hover :items="films" :fields="fields" :sticky-header="false">
       <!-- A custom formatted column -->
        <template #cell(title)="data">
        <i>{{ data.item.title | capitalize}}</i>
      </template>

     </b-table>
  </div>
</template>

<script>

export default {
    props: ['task', 'id'],
    
    data() {
        return {
            confirm: false,
            showEditTask: false,
            rows: 100,
            perPage: 10,
            currentPage: 1,
            films: [],
            fields: [
              {key: 'title', label: 'Title', sortable: true},
              {key: 'description', label: 'Description', sortable: true},
              {key: 'releaseYear', label: 'Release Year', sortable: true},
              {key: 'rating', label: 'Rated', sortable: true},
              {key: 'rentalRate', label: 'Rental Rate', sortable: true},
            ]
            
        }
    },
    mounted() {
      this.axios.defaults.headers.common['Content-Type'] = 'application/x-www-form-urlencoded';
      this.axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
      this.axios.get("http://localhost:8080/films/")
      .then(response => {
        this.films = response.data._embedded.films;
      })
    }
}
</script>
