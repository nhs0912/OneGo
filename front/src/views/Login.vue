<script setup lang="ts">
// import TheWelcome from '../components/TheWelcome.vue'
</script>

<template>
  <h1>Login</h1>
  <main>
    <form>
      <div className="form-group">
        <label htmlFor="exampleInputEmail1">Email address</label>
        <input type="text" className="form-control" id="employeeId" aria-describedby="emailHelp" placeholder="Enter id">
        <small id="emailHelp" className="form-text text-muted">사번을 입력해주세요(ex : MTXXXXX)</small>
      </div>
      <div className="form-group">
        <label htmlFor="exampleInputPassword1">Password</label>
        <input type="password" className="form-control" id="exampleInputPassword1" placeholder="Password">
      </div>
      <div className="form-group form-check">
        <input type="checkbox" className="form-check-input" id="exampleCheck1">
        <label className="form-check-label" htmlFor="exampleCheck1">Check me out</label>
      </div>
      <button type="submit" className="btn btn-primary">Submit</button>
    </form>
  </main>
    <router-link to="/signUp" ><button className="btn btn-primary">SignUp</button></router-link>

  <RouterView/>
</template>

<script>


</script>
