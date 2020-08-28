//header.vue

<template>
  <div>
  <h1>WEATHER PAGE</h1>
    <div id="mainNavigation">
      <nav v-on:click.prevent>
        <router-link :to="{ name: 'Home' }"
          class="nav-link">
        Home
        </router-link>
        <router-link :to="{ name: 'Attendance' }"
          class="nav-link">
        Attendance
        </router-link>
        <router-link :to="{ name: 'Weather' }"
          class="nav-link">
        Weather
        </router-link>
        <router-link :to="{ name: 'Memo' }"
          class="nav-link">
        Todo
        </router-link>
      </nav>
    </div>
    <v-simple-table>
      <template v-slot:default>
        <thead>
          <tr>
            <v-btn @click="start()" text color="black">[ 서울 주간 날씨 ]</v-btn>
          </tr>
        </thead>
        <tbody>
          <tr v-for="list of lists" :key="list.title">
            <td><a @click="clickWeather(list.weatherNo)">
            {{ list.dday }} ||
            강수확률(오전/오후) -- {{ list.mrr }} /
            {{ list.arr }}% ||
            온도(최저/최) -- {{ list.temp }}
            </a></td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
    <div>
      <v-footer
      app
      >
      <v-spacer></v-spacer>
      <span>&copy; LKS</span>
      </v-footer>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  computed: {
    ...mapState({
      lists: state => state.lists
    })
  },
  methods: {
    clickWeather (weatherNo) {
      console.log('clickWeather: ' + weatherNo)
      this.$store.dispatch('crawlFindOne', weatherNo)
    },
    start () {
      this.$store.dispatch('crawlFind')
    }
  }
}
</script>
<style>
// Nav Style
nav,
p b {
    border-radius: 2px
}

nav a,
p b {
    text-transform: uppercase
}
* {
    margin: 0;
    padding: 0
}
body {
    font: 14px/1.3 'Open Sans', sans-serif;
    color: #5e6b56;
    text-align: center
}
nav a,
p {
    font-weight: 700
}
a,
a:visited {
    outline: 0;
    color: #389dc1
}
a:hover {
    text-decoration: none
}
aside,
footer,
header,
nav,
section {
    display: block
}
nav,
nav a,
p b {
    display: inline-block
}
nav {
    margin: 60px auto 44px;
    background-color: #5587b4;
    box-shadow: 0 1px 1px #ccb
}
nav a {
    padding: 17px 30px;
    color: #fff!important;
    font-size: 16px;
    text-decoration: none!important;
    line-height: 1;
    background-color: transparent;
    -webkit-transition: background-color .25s;
    -moz-transition: background-color .25s;
    transition: background-color .25s
}
nav a:first-child {
    border-radius: 2px 0 0 2px
}
nav a:last-child {
    border-radius: 0 2px 2px 0
}
nav.contact_page .contact_page,
nav.home_page .home_page,
nav.projects_page .projects_page,
nav.services_page .services_page {
    background-color: #e35885
}
p {
    font-size: 22px;
    color: #7d9988
}
p b {
    color: #fff;
    padding: 6px 11px;
    background-color: #c4d7e0;
    font-size: 15px
}
.resource {
    margin: 20px 0
}
</style>
