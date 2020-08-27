import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test2 from '../views/Test2.vue'

// For Cafe Board
import BoardListPage from '../views/BoardListPage.vue'
import BoardRegisterPage from '../views/BoardRegisterPage.vue'
import BoardModifyPage from '../views/BoardModifyPage.vue'
import BoardReadPage from '../views/BoardReadPage.vue'

// For Login System
import LoginPage from '../views/LoginPage.vue'
import AdminSetupPage from '../views/AdminSetupPage.vue'

// For Menu
import Memo from '../views/Memo.vue'
import Weather from '../views/Weather.vue'
import Attendance from '../views/Attendance.vue'

// Vuetify
import VuetifyBoard from '../views/VuetifyBoard.vue'

// Vuetify Board List
import VuetifyBoardListPage from '../views/VuetifyBoardListPage.vue'

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
  },
  {
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    path: '/board/create',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
  {
    path: '/board/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/board/:boardNo/edit',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      // 이 옵션을 설정하면 route.params가 컴포넌트의 props에 자동 설정됨
      default: true
    }
  },
  {
    path: '/VuetifyBoard',
    name: 'VuetifyBoard',
    components: {
      default: VuetifyBoard
    }
  },
  {
    path: '/VuetifyBoardListPage',
    name: 'VuetifyBoardListPage',
    components: {
      default: VuetifyBoardListPage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
