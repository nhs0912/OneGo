<template>
  <v-app>

    <app-header/>
    <v-main>
      <router-view/>
    </v-main>
    <app-footer/>
  </v-app>
</template>

<script lang="ts" setup>

import AppHeader from "@/components/AppHeader.vue";
</script>
