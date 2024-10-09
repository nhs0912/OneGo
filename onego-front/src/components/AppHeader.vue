<script setup lang="ts">
import {useTheme} from 'vuetify'

const theme = useTheme()

function toggleTheme() {
  theme.global.name.value = theme.global.current.value.dark ? 'light' : 'dark'
}
</script>

<template>
  <v-toolbar flat>
    <v-toolbar-title>OneGo</v-toolbar-title>
    <v-spacer></v-spacer>
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
