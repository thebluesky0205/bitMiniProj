<template>
    <section class="container">
      <div class="heading">
        <img class="heading__img" src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/756881/laptop.svg">
        <h1 class="heading__title">오늘 뭐하지 ?</h1>
      </div>
      <form class="form">
        <div>
          <label class="form__label" for="todo"> 오늘은 </label>
          <input class="form__input"
           type="text"
           id="todo"
           name="to-do"
           size="30"
           required>
            <div>
            ...
            <button class="button"><span>추가하기!</span></button>
           </div>
        </div>
      </form>
      <div>
        <ul class="toDoList">
        </ul>
      </div>
      <div class="wrap">
         <div class="search">
            <input type="text" class="searchTerm" placeholder="서치서치서치">
            <button type="submit" class="searchButton">
           </button>
         </div>
      </div>
    </section>
</template>
<script>

</script>
