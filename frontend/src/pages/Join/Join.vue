<template>
    <div class="auth-page">
        <b-container>
            <h5 class="auth-logo">
                <i class="fa fa-circle text-primary"></i>
                QAS
                <i class="fa fa-circle text-danger"></i>
            </h5>
            <Widget class="widget-auth mx-auto" title="<h3 class='mt-0'>JOIN</h3>" customHeader>
                <form class="mt" @submit="join">
                    <div class="form-group">
                        <input v-model="userEmail" style="width: 78%; float: left;" class="form-control no-border"
                               ref="email" required type="email" id="userEmail" placeholder="Email"/>
                    </div>
                    <b-button style="width: 20%; float: right;" type="submit" size="sm" class="auth-btn mb-3"
                              variant="inverse" @submit.prevent="authEmail">인증
                    </b-button>
                    <div class="form-group">
                        <input v-model="userPassword" class="form-control no-border" ref="password" required
                               type="password" id="password" placeholder="Password" @keyup.enter="moveToId"/>
                    </div>
                    <div class="form-group">
                        <input v-model="userId" style="width: 78%; float: left;" class="form-control no-border"
                               ref="id" required type="text" id="userId" placeholder="ID"/>
                    </div>
                    <b-button style="width: 20%; float: right;" type="submit" size="sm" class="auth-btn mb-3"
                              variant="inverse" @submit.prevent="authId">인증
                    </b-button>
                    <b-button type="submit" size="sm" class="auth-btn mb-3" variant="inverse">
                        Join
                    </b-button>
                    <b-button size="sm" class="auth-btn mb-3" variant="inverse" v-on:click="cancel">
                        Cancel
                    </b-button>
                </form>
            </Widget>
        </b-container>
        <footer class="auth-footer">
            Quality And Satisfy
        </footer>
    </div>
</template>

<script>
    import Widget from '@/components/Widget/Widget';

    export default {
        components: {Widget},
        data() {
            return {
                userId: '',
                userEmail: '',
                userPassword: '',
                role: 'USER'
            }
        },
        methods: {
            join() {
                this.$store.dispatch('join/joinProcess', {
                    userId: this.userId,
                    userEmail: this.userEmail,
                    userPassword: this.userPassword
                })
                this.clearForm()
//                this.router.push('/login')
            },
            authEmail() {
                this.$store.dispatch('join/authEmails', this.userEmail)
            },
            authId() {
                this.$store.dispatch('join/authIds', this.userId)
            },
            moveToId() {
                document.getElementById('userId').focus()
            },
            clearForm() {
                this.userId = null
                this.userEmail = null
                this.userPassword = null
            },
            cancel() {
                this.$router.push({name: 'Login'})
            }
        }
    }
</script>