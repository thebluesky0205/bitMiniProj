<template>
  <div class="setUpF">
    <h1>Create Page</h1>
    <hr>
    <form @submit.prevent="submit">
      <table>
        <tr>
          <td>Id</td>
          <td><input type="text" placeholder="Your Id."  v-model="userId"></td>
        </tr>
        <tr>
          <td>Pw</td>
          <td><input type="password" placeholder="Your Password." v-model="userPw"></td>
        </tr>
        <tr>
          <td>Name</td>
          <td><input type="text" placeholder="ex) 홍길동"  v-model="userName"></td>
        </tr>
        <tr>
          <td>Live In</td>
          <td><input type="text" placeholder="ex) Busan" v-model="userBorn"></td>
        </tr>
        <tr>
          <td>E-mail</td>
          <td><input type="text"  placeholder="ex) 123@gmail.com"  v-model="userEmail"></td>
        </tr>
        <tr>
          <td>Phone</td>
          <td><input type="text" v-model="userPhone"></td>
        </tr>
      </table>
      <div>
        <button type="submit">Create</button>
      </div>
    </form>
  </div>
</template>

<script>

import { mapActions } from 'vuex'

export default {
  name: 'AdminSetupForm',
  data () {
    return {
      userId: '',
      userName: '',
      userPw: '',
      userBorn: '',
      userEmail: '',
      userPhone: ''
    }
  },
  methods: {
    submit () {
      console.log('this: ' + this.userId +
                  ', ' + this.userName +
                  ', ' + this.userPw +
                  ', ' + this.userBorn +
                  ', ' + this.userEmail +
                  ', ' + this.userPhone)
      const { userId, userName, userPw, userBorn, userEmail, userPhone } = this
      this.$emit('submit', { userId, userName, userPw, userBorn, userEmail, userPhone })
    },
    onSubmit (payload) {
      console.log('loginPage onSubmit()')
      this.login(payload).then(res => {
        alert('로그인 하셨습니다.')
        this.$router.push({ name: 'Home' })
      }).catch(err => {
        // alert(err.response.data.message)
        alert('Something Fail: ', err)
      })
    },
    ...mapActions(['login'])
  }
}
</script>

<style>
/*Fonts*/
@import 'https://fonts.googleapis.com/css?family=Open+Sans';
@import 'https://fonts.googleapis.com/css?family=Galada';

::selection {
  background: #ffb7b7; /* WebKit/Blink Browsers */
}
::-moz-selection {
  background: #ffb7b7; /* Gecko Browsers */
}
* {
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}
:focus {outline:none}
/*Reset*/
body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6,
pre, form, fieldset, input, textarea, p, blockquote, th, td {
  padding:0;
  margin:0;}
body,input{
  font-family:'Open sans',sans-serif;
  font-size:18px;
  color:#4c4c4c;
}
body{
  background-color:#FFFFFF;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
form{
  margin: 10px 35px;
}
input{
  border:none;
}
a{
    text-decoration: none;
    color: rgb(255, 255, 255);

}
a:hover{
  color: rgba(255, 152, 0, 0.79);
  text-decoration: underline;

}
input[type=text], input[type=password] {
  width: 200px;
  height: 38px;
  border:1px solid #cbc9c9;
  padding-left:5px;
  margin-left:5px;
  margin-top:3px;
  border-radius:0px 3px 3px 0px;
  -webkit-border-radius:0px 3px 3px 0px;
  -moz-border-radius:0px 3px 3px 0px;
}
input[type=submit]{
  width: 237px;
  height: 40px;
  margin-left:17px;
  border-radius:3px;
  background-color:#757575;
  color:#f8f8f8;
  border-radius:2px 2px 12px 12px;
  -webkit-border-radius:2px 2px 12px 12px;
  -moz-border-radius:2px 2px 12px 12px;

}
input[type=submit]:hover{
  background-color:#5587b4;
  color:#f8f8f8;
  cursor:pointer;

}
.setUpF{
  margin:150px auto;
  width: 343px;
  height: 280px;
  border-radius:5px;
  -moz-border-radius:5px;
  -webkit-border-radius:5px;
}
.setUpF h1{
  font-family: 'Galada', cursive;
  color:#5587b4;
  letter-spacing:8px;
  text-align:center;
  padding-top:5px;
  padding-bottom:5px;
}
.setUpF hr{
  opacity:0.2;
}
#firstPage {
  text-align:center;
}
</style>
