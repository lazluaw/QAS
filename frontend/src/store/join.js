import axios from 'axios'

const state = {
    context: 'http://localhost:4000',
    user: {}, //왜?
    isAuth: true,
    isJoin: true,
    isJoinError: false
}

const mutations = {
    JOIN_SUCCESS(state, payload) {
        state.isJoin = true
        state.isJoinError = false
        state.user = payload.user
        localStorage.setItem('token', payload.token)
        localStorage.setItem('userId', payload.user.userId)
        localStorage.setItem('userEmail', payload.user.userEmail)
        localStorage.setItem('userPassword', payload.user.userPassword)
    },
    JOIN_ERROR(state) {
        state.isJoin = false
        state.isJoinError = true
        alert('회원가입에 실패하였습니다.')
    },
    AUTH_EMAIL_SUCCESS(state, payload) {
        state.userEmail = payload
        state.isAuth = true
        alert('가입 가능한 이메일입니다.')
    },
    AUTH_ID_SUCCESS(state, userId) {
        state.userId = userId
        state.isAuth = true
    },
    AUTH_ERROR(state) {
        state.isAuth = false
        alert('이미 존재합니다.')
    }
}

const actions = {
    async joinProcess({commit}, payload) {
        const url = state.context + '/users/joinProcess'
        const headers = {
            authorization: 'JWT fefege..',
            Accept: 'application/json',
            'Content-Type': 'application/json'
        }
        axios
            .post(url, payload, headers)
            .then(({data}) => {
                if (data.result) {
                    alert('success')
                    commit('JOIN_SUCCESS', data)
                } else {
                    alert('error')
                    commit('JOIN_ERROR')
                }
            })
            .catch(() => {
                alert('서버 통신 실패')
                commit('JOIN_ERROR')
            })
    },
    async authEmails({commit}, payload) {
        axios
            .get(state.context)
            .then(data => {
                if (data.result) {
                    alert(data.result)
                    commit('AUTH_EMAIL_SUCCESS', payload)
                } else {
                    alert('error')
                    commit('AUTH_ERROR')
                }
            })
            .catch(() => {
                alert('서버 통신 실패')
            })
    },
    async authIds({commit}, userId) {
        axios
            .get(state.context)
            .then(data => {
                if (data.result) {
                    commit('AUTH_ID_SUCCESS', userId)
                } else {
                    commit('AUTH_ERROR')
                }
            })
            .catch(() => {
                alert('서버 통신 실패')
            })
    }
}

export default {
    name: 'join',
    namespaced: true,
    state,
    actions,
    mutations
}
