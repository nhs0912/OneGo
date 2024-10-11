<script setup lang="ts">
import {useTheme} from 'vuetify'

const theme = useTheme()

function toggleTheme() {
  theme.global.name.value = theme.global.current.value.dark ? 'light' : 'dark'
}
</script>

<template>
<!--  <v-card-->
<!--      color="grey-lighten-4"-->
<!--      height="200px"-->
<!--      rounded="0"-->
<!--      flat-->
<!--  >-->
  <v-toolbar
      image="https://cdn.vuetifyjs.com/images/backgrounds/vbanner.jpg"
      dark
      prominent
      density="compact">
    <v-app-bar-nav-icon></v-app-bar-nav-icon>
    <v-toolbar-title>OneGo</v-toolbar-title>
    <v-spacer></v-spacer>
    <v-btn icon>
      <v-icon>mdi-magnify</v-icon>
    </v-btn>

    <v-btn icon>
      <v-icon>mdi-heart</v-icon>
    </v-btn>

    <v-btn icon>
      <v-icon>mdi-dots-vertical</v-icon>
    </v-btn>
      <!-- button uses dark theme -->
      <v-btn icon id="mode-switcher" @click="toggleTheme">
        <v-icon :color="(theme.global.current.value.dark) ? 'primary' : 'primary lighten-4'">
          {{ (theme.global.current.value.dark) ? 'mdi-weather-night' : 'mdi-weather-sunny' }}
        </v-icon>

      </v-btn>
  </v-toolbar>

</template>

<style scoped lang="sass">

</style>
