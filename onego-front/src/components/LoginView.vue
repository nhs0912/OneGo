<template>
  <div>
    <!-- <v-img
      class="mx-auto my-6"
      max-width="228"
      src="@/assets/image/onego_logo.png"
    /> -->
    <!--    :src="require(`@/assets/image/vuetify_logo.svg`)"-->
    <v-card
      class="mx-auto pa-12 pb-8"
      elevation="8"
      max-width="448"
      rounded="lg"
    >
      <div class="text-subtitle-1 text-medium-emphasis">Account</div>

      <v-text-field
        density="compact"
        placeholder="Email address"
        prepend-inner-icon="mdi-email-outline"
        variant="outlined"
      />

      <div class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
        Password
        <a
          class="text-caption text-decoration-none text-blue"
          href="#"
          rel="noopener noreferrer"
          target="_blank"
        >
          Forgot login password?</a>
      </div>

      <v-text-field
        :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
        density="compact"
        placeholder="Enter your password"
        prepend-inner-icon="mdi-lock-outline"
        :type="visible ? 'text' : 'password'"
        variant="outlined"
        @click:append-inner="visible = !visible"
      />

      <v-card
        class="mb-12"
        color="surface-variant"
        variant="tonal"
      >
        <!--        <v-card-text class="text-medium-emphasis text-caption">-->
        <!--          Warning: After 3 consecutive failed login attempts, you account will be temporarily locked for three hours. If you must login now, you can also click "Forgot login password?" below to reset the login password.-->
        <!--        </v-card-text>-->
      </v-card>
      <router-link to="/mainView">
        <v-btn
          block
          class="mb-8"
          color="blue"
          :loading="loading"
          size="large"
          variant="tonal"
          @click="isLogin = !isLogin"
        >
          Log In
        </v-btn>
      </router-link>

      <v-card-text class="text-center">
        <router-link to="/login/signupView">
          <a
            class="text-blue text-decoration-none"
            rel="noopener noreferrer"
          >
            Sign up now
            <v-icon icon="mdi-chevron-right" />
          </a>
        </router-link>
      </v-card-text>
    </v-card>
  </div>
</template>
<script>
// import {ref, computed} from 'vue';
// import {useStore} from 'vuex';

  import { useAppStore } from '@/stores/app'

  const store = useAppStore()

  export default {
    data: () => ({
      visible: true,
      isLogin: store.isLogin,
    }),
  }
</script>
