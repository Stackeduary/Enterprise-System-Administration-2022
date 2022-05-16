<template>
    <div>
        <h1>Please log your ass in</h1>
        <form @submit.prevent="Login">
            <input v-model="username" placeholder="username">
            <input v-model="password" type="password" placeholder="password">
            <button @click="login">Log In</button>
        </form>
    </div>    
</template>

<script>
export default {
    name: 'Login',
    props: {
        msg: String,
    },
    data: () => {
        return {
            username: '',
            password: '',
        }
    },
    methods: {
        login() {
            this.$emit('login', {
                username: this.username,
                password: this.password,
            })
        }
    }
}
</script>

<style scoped>

</style>