<template>
  <q-page padding>
    <h1>Movies</h1>
    <table>
      <tr class="light-blue-6">
        <th>Title</th>
        <th>description</th>
        <th>Year</th>
        <th>Rating</th>
        <th>Rental Rate</th>
      </tr>
      <tr v-for="film in  films" :key="film.id">
        <td>{{film.title}}</td>
        <td>{{film.description}}</td>
        <td>{{film.releaseYear}}</td>
        <td>{{film.rating}}</td>
        <td>{{film.rentalRate}}</td>
      </tr>
    </table>
  </q-page>
</template>

<script>

export default {
    props: ['task', 'id'],
    
    data() {
        return {
            confirm: false,
            showEditTask: false,
            films: [
              {id: 1, title: "Aliens", description: "They are among us...", year: "1991", rating: "PG-13", rental: "5.95"},
              {id: 3, title: "Avengers", description: "Marvell blockbuster 1...", year: "2003", rating: "NC-17", rental: "9.95"},
              {id: 5, title: "Black Panther", description: "Marvell blockbuster 2...", year: "2018", rating: "PG", rental: "11.95"}
            ]
        }
    },
    mounted() {
      this.$axios.defaults.headers.common['Content-Type'] = 'application/x-www-form-urlencoded';
      this.$axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
      this.$axios.get("http://localhost:8080/films/")
      .then(response => {
        this.films = response.data._embedded.films;
      })
    }
}
</script>
