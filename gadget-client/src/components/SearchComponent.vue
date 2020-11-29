<template>
  <div class="row">
    <form>
      <input type="text" title="Search" name="searchFld" />
      <button type="submit" @click="searchClicked">Search</button>
    </form>
  </div>
</template>

<script>
export default {
  data: {
    searchFld: ''
  }
  methods: {
    searchClicked: function() {
      console.log("search  btn clicked");
    }
  }
}
</script>