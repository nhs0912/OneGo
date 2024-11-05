<script setup lang="ts">
import {useTheme} from 'vuetify'

const theme = useTheme()

function toggleTheme() {
  theme.global.name.value = theme.global.current.value.dark ? 'light' : 'dark'
}
</script>

<template>
  <v-toolbar
    dark
    prominent
    density="compact">
    <v-app-bar-nav-icon></v-app-bar-nav-icon>
    <router-link class="custom-link" to="/mainView">
      <v-toolbar-title>OneGo</v-toolbar-title>
    </router-link>
    <v-spacer></v-spacer>
    <v-btn icon>
      <v-icon>mdi-magnify</v-icon>
    </v-btn>

    <v-btn icon>
      <router-link class="custom-link" to="/appheader/boardView">
        <v-icon>mdi-heart</v-icon>
      </router-link>

    </v-btn>

    <v-btn icon>
      <v-icon>mdi-dots-vertical</v-icon>
    </v-btn>
    <v-btn icon>
      <router-link class="custom-link" to="/">
          <v-btn density="default">Login</v-btn>
<!--          <v-btn v-show="!this.store.isLogin" density="default">Logout</v-btn>-->
      </router-link>
    </v-btn>
    <!-- button uses dark theme -->
    <v-btn icon id="mode-switcher" @click="toggleTheme">
      <v-icon :color="(theme.global.current.value.dark) ? 'primary' : 'primary lighten-4'">
        {{ (theme.global.current.value.dark) ? 'mdi-weather-night' : 'mdi-weather-sunny' }}
      </v-icon>

    </v-btn>

  </v-toolbar>

</template>

<style scoped>
.custom-link {
  text-decoration: none;
  color: black;

  &:hover {
    text-decoration: none;
    color: darkgray;
  }
}
</style>
