<template>
  <div class="dblist">
    <h1>{{msg}}</h1>
    <i-button>{{msg}}</i-button>
  </div>
</template>

<script>
export default {
  name: 'dblist',
  data () {
    return {
      msg: 'Database List...'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
