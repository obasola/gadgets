
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Index.vue') },
      { path: '/films', component: () => import('pages/Film.vue') },
      { path: '/stores', component: () => import('pages/Store.vue') },
      { path: '/staffs', component: () => import('pages/Staff.vue') },
      { path: '/rentals', component: () => import('pages/Rentals.vue') },
      { path: '/customers', component: () => import('pages/Customer.vue') },
      { path: '/inventories', component: () => import('pages/Inventory.vue') }
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '*',
    component: () => import('pages/Error404.vue')
  }
]

export default routes
