<template>
  <div align="center">
    <admin-setup-form @submit="onSubmit"/>
  </div>
</template>

<script>
import axios from 'axios'
import AdminSetupForm from '@/components/AdminSetupForm.vue'
export default {
  name: 'AdminSetupPage',
  components: {
    AdminSetupForm
  },
  methods: {
    onSubmit (payload) {
      console.log('payload: ' + payload.userId +
                  ', ' + payload.userName +
                  ', ' + payload.userBorn +
                  ', ' + payload.userEmail +
                  ', ' + payload.userPhone)
      const { userId, userName, userPw, userBorn, userEmail, userPhone } = payload
      axios.post('http://localhost:7777/users/setup',
        { userId, userName, userPw, userBorn, userEmail, userPhone })
        .then(res => {
          alert('가입되었으니 로그인 해주세요.')
          this.$router.push({
            name: 'LoginPage'
          })
        })
        .catch(err => {
          alert(err.response.data)
        })
    }
  }
}
</script>
