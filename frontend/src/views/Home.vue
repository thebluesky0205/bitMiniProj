<template>
  <v-app id="inspire">
    <div class="Home">
      <div id="header" v-if="isAuthorized">
      <h1>{{ myinfo.userName }}님의 프로젝트</h1>
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
          <a href="#" v-on:click="onClickLogout">Logout</a>
        </nav>
      </div>
      <v-container fluid>
        <div class="calendar">
          <v-row :justify="justify">
            <v-col cols="12" md="6" class="mb-4">
              <v-row>
                <v-col cols="6">
                  <v-menu
                    ref="dateOpen"
                    v-model="dateOpen"
                    :close-on-content-click="false"
                    :return-value.sync="start"
                    offset-y
                  >
                  <template v-slot:activator="{ on }">
                    <v-text-field
                      v-model="start"
                      white
                      label="Start Date"
                      prepend-icon="mdi-calendar"
                      dense
                      readonly
                      outlined
                      hide-details
                      v-on="on"
                    >
                    </v-text-field>
                  </template>
                  <v-date-picker
                    dark
                    v-model="start"
                    no-title
                  >
                  <v-spacer></v-spacer>
                  <v-btn text dark color="primary" @click="dateOpen = false">Cancel</v-btn>
                  <v-btn text dark color="primary" @click="$refs.dateOpen.save(start)">OK</v-btn>
                  </v-date-picker>
                  </v-menu>
                </v-col>
                <v-col cols="6">
                  <v-select
                    v-model="type"
                    :items="typeOptions"
                    label="Type"
                    class="my-auto"
                    white
                    hide-details
                    outlined
                    dense
                  >
                  </v-select>
                </v-col>
              </v-row>
              <v-sheet height="500">
                <v-calendar>
                  ref="calendar"
                  :start="start"
                  :type="type"
                  white
                ></v-calendar>
              </v-sheet>
            </v-col>
          </v-row>
        </div>
      </v-container>
    </div>
      <div id="header" v-else>
      <div class="loginF">
        <h1>Mini_Project.ing</h1>
        <hr>
        <form>
          <router-link :to="{ name: 'LoginPage' }"
            class="nav-link">
          Login
          </router-link>
          <router-link :to="{ name: 'AdminSetupPage' }"
            class="nav-link">
          | Create
          </router-link>
        </form>
      </div>
      </div>
      <div>
        <v-footer
        app
        >
        <v-spacer></v-spacer>
        <span>&copy; LKS</span>
        </v-footer>
      </div>
    </div>
  </v-app>
</template>

<script>
/* eslint-disable no-unused-vars */
import store from '../store'
import Vue from 'vue'
import LoginForm from '@/components/LoginForm.vue'
import { mapState, mapGetters, mapActions } from 'vuex'

export default {
  name: 'Home',
  data: function () {
    return {
      alignment: 'center',
      justify: 'center',
      dateOpen: false,
      start: '',
      type: 'month',
      typeOptions: [
        { text: 'Month', value: 'month' }
      ]
    }
  },
  methods: {
    onClickLogout () {
      this.logout()
      alert('로그아웃 되었습니다.')
      this.$router.push({ name: 'LoginPage' })
    },
    ...mapActions(['logout'])
  },
  computed: {
    ...mapState(['myinfo']),
    ...mapGetters(['isAuthorized'])
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

#header {
  padding: 15px;
  margin-bottom: 15px;
  margin: 5px 5px;
}

img {
  width: auto;
  height: auto;
  max-width: 1000px;
  max-height: 350px;
  display: block;
  margin-left: auto;
  margin-right: auto;
}

#login {
  background-color: #;
  color: #;
  font-weight: bold;
}

.firstPage{
  margin:150px auto;
  width: 343px;
  height: 280px;
  border-radius:5px;
  -moz-border-radius:5px;
  -webkit-border-radius:5px;
}
.firstPage h1{
  font-family: 'Galada', cursive;
  color:#5587b4;
  letter-spacing:8px;
  text-align:center;
  padding-top:5px;
  padding-bottom:5px;
}
.firstPage hr{
  opacity:0.2;
}
form{
  margin: 0 auto;
  align: center;

}
</style>
