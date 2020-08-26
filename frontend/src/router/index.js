import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test2 from '../views/Test2.vue'

// For Login System
import LoginPage from '../views/LoginPage.vue'
import AdminSetupPage from '../views/AdminSetupPage.vue'

// For Menu
import Memo from '../views/Memo.vue'
import Weather from '../views/Weather.vue'
import Attendance from '../views/Attendance.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/LoginPage',
    name: 'LoginPage',
    components: {
      default: LoginPage
    }
  },
  {
    path: '/AdminSetupPage',
    name: 'AdminSetupPage',
    components: {
      default: AdminSetupPage
    }
  },
  {
    path: '/Memo',
    name: 'Memo',
    components: {
      default: Memo
    }
  },
  {
    path: '/Weather',
    name: 'Weather',
    components: {
      default: Weather
    }
  },
  {
    path: '/Attendance',
    name: 'Attendance',
    components: {
      default: Attendance
    }
  },
  {
    path: '/Test2',
    name: 'Test2',
    components: {
      default: Test2
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
