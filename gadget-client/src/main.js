
import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import router from './router'
import store from './store'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

// Install BootstrapVue
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)
Vue.use(VueAxios, axios)


Vue.config.productionTip = false

Vue.filter('capitalize', function (string) { 
  var capitalFirst = string.charAt(0).toUpperCase() 
  var noCaseTail = string.slice(1, string.length) 
    return capitalFirst + noCaseTail 
}) 
        
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
