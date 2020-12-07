import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../pages/Home.vue'

Vue.use(VueRouter)

const routes = [
  { path: '/', name: 'Home', component: Home},
  { path: '/about', name: 'About', component: () => import(/* webpackChunkName: "about" */ '../pages/About.vue')},
 // { path: '', name: '', component: () => import('pages/Index.vue') },
  { path: '/films', name: 'Movies', component: () => import('../pages/Film.vue') },
  { path: '/stores', name: 'Stores', component: () => import('../pages/Store.vue') },
  { path: '/staffs', name: 'Staff', component: () => import('../pages/Staff.vue') },
  { path: '/rentals', name: 'Rentals', component: () => import('../pages/Rentals.vue') },
  { path: '/customers', name: 'Customers', component: () => import('../pages/Customer.vue') },
  { path: '/inventories', name: 'Inventory', component: () => import('../pages/Inventory.vue') }
]

const router = new VueRouter({
  routes
})

export default router
