<template>
  <v-app>
    <app-header/>
      <router-view/>
    <app-footer/>
  </v-app>
</template>

<script lang="ts" setup>
  import {useAppStore} from "@/stores/app";

  const store = useAppStore();




</script>
