<script setup lang="ts">
// import TheWelcome from '../components/TheWelcome.vue'
</script>

<template>
    <h1>SignUp</h1>
    <main>
        <form>
            <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input type="text" class="form-control" id="employeeId" aria-describedby="emailHelp" placeholder="Enter id">
                <small id="emailHelp" class="form-text text-muted">사번을 입력해주세요(ex : MTXXXXX)</small>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
<!--            <div class="form-group form-check">-->
<!--                <input type="checkbox" class="form-check-input" id="exampleCheck1">-->
<!--                <label class="form-check-label" for="exampleCheck1">Check me out</label>-->
<!--            </div>-->
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </main>
</template>

<script>


</script>
