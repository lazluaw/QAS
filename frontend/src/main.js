// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import BootstrapVue from 'bootstrap-vue';
import * as VueGoogleMaps from 'vue2-google-maps';
import VueTouch from 'vue-touch';
import Trend from 'vuetrend';
import Toasted from 'vue-toasted';
import VueApexCharts from 'vue-apexcharts';
import Vuex from 'vuex'
import axios from 'axios'

import InfiniteLoading from "vue-infinite-loading";

import store from './store';
import router from './Routes';
import App from './App';
import layoutMixin from './mixins/layout';
import Widget from './components/Widget/Widget';

Vue.prototype.$http = axios;
Vue.use(BootstrapVue);
Vue.use(VueTouch);
Vue.use(Trend);
Vue.use(Vuex);
Vue.use(InfiniteLoading);
Vue.component('Widget', Widget);
Vue.use(VueGoogleMaps, {
    load: {
        key: 'AIzaSyB7OXmzfQYua_1LEhRdqsoYzyJOPh9hGLg',
    },
});
Vue.component('apexchart', VueApexCharts);
Vue.mixin(layoutMixin);
Vue.use(Toasted, {duration: 10000});

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
    el: '#app',
    store,
    router,
    Vuex,
    axios,
    render: h => h(App),
});