<template>
  <div>
    <form>
      <!-- <v-img
        class="mx-auto my-6"
        max-width="228"
        src="@/assets/image/onego_logo.png"
      /> -->
      <v-card
        class="mx-auto pa-12 pb-10"
        elevation="10"
        max-width="448"
        rounded="lg"
      >
        <div class="text-subtitle-1 text-medium-emphasis">Account</div>

        <v-text-field
          v-model="state.email"
          density="compact"
          :error-messages="v$.email.$errors.map(e => e.$message)"
          placeholder="Email address"
          prepend-inner-icon="mdi-email-outline"
          :type="visible ? 'text' : 'account'"
          variant="outlined"
          @blur="v$.email.$touch"
          @input="v$.email.$touch"
        />

        <div class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
          Password              </div>
        <v-text-field
          v-model="state.password"
          :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
          density="compact"
          :error-messages="v$.password.$errors.map(e => e.$message)"
          placeholder="Enter your password"
          prepend-inner-icon="mdi-lock-outline"
          :type="visible ? 'text' : 'password'"
          variant="outlined"
          @blur="v$.password.$touch"
          @click:append-inner="visible = !visible"
          @input="v$.password.$touch"
        />
        <div class="text-subtitle-1 text-medium-emphasis">Name</div>
        <v-text-field
          v-model="state.name"
          :counter="10"
          density="compact"
          :error-messages="v$.name.$errors.map(e => e.$message)"
          label="Name"
          placeholder="Enter your name"
          prepend-inner-icon="mdi-pencil-outline"
          required
          variant="outlined"
          @blur="v$.name.$touch"
          @input="v$.name.$touch"
        />
        <div class="text-subtitle-1 text-medium-emphasis">Team</div>
        <v-select
          v-model="state.select"
          density="compact"
          :error-messages="v$.select.$errors.map(e => e.$message)"
          :items="teams"
          label="Team"
          placeholder="Enter your Team"
          prepend-inner-icon="mdi-pencil-outline"
          required
          variant="outlined"
          @blur="v$.select.$touch"
          @change="v$.select.$touch"
        />

        <v-checkbox
          v-model="state.checkbox"
          :error-messages="v$.checkbox.$errors.map(e => e.$message)"
          label="Do you agree?"
          required
          @blur="v$.checkbox.$touch"
          @change="v$.checkbox.$touch"
        />
        <v-btn
          class="me-4"
          @click="v$.$validate"
        >
          submit
        </v-btn>
        <v-btn @click="$router.go(-1)">
          back
        </v-btn>
      </v-card>
    </form>
  </div>
</template>
<script setup>
  import { reactive } from 'vue'
  import { useVuelidate } from '@vuelidate/core'
  import { email, required } from '@vuelidate/validators'

  const initialState = {
    name: '',
    email: '',
    select: null,
    checkbox: null,
    password: '',
  }

  const state = reactive({
    ...initialState,
  })

  const teams = [
    'FO',
    'BO',
    'Common',
    'etc',
  ]

  const rules = {
    name: { required },
    email: { required, email },
    select: { required },
    teams: { required },
    checkbox: { required },
    password: { required },
  }

  const v$ = useVuelidate(rules, state)

  function clear () {
    v$.value.$reset()

    for (const [key, value] of Object.entries(initialState)) {
      state[key] = value
    }
  }

  function back () {
    router.go(-1)
  }
</script>
