import Vue from 'vue'
import Router from 'vue-router'


Vue.use(Router)

function load(component) {
  // '@' is aliased to src/components
  // return () => import(`@/${component}.vue`)
  return () => import(`./${component}.vue`)
}


export default new Router({
  routes: [
    // {
    //   path: '/',
    //   component: load('index'),
    // },
    // {
    //   path: '/index',
    //   component: load('index'),
    // },

    {
      path: '/kanban',
      component: load('kanban'),
    },
    {
      path: '/services',
      component: load('services'),
    },
    {
      path: '/car',
      component: load('Car'),
      children: [
        {
          path: '',
          component: load('CarHome'),
        },
        {
          path: 'detail',
          component: load('CarDetail'),
        },
      ],
    },
    {
      path: '/',
      component: load('Company'),
      children: [
        {
          path: '',
          component: load('CompanyHome'),
        },
        // {
        //   path: 'detail',
        //   component: load('CompanyDetail'),
        // },
        {
          path: 'manage',
          component: load('CompanyManage'),
        },
        {
          path: 'secure',
          component: load('CompanySecure'),
        },
      ],
    },
    {
      path: '/driver',
      component: load('Driver'),
      children: [
        {
          path: '',
          component: load('DriverHome'),
        },
        {
          path: 'detail',
          component: load('DriverDetail'),
        },
      ],
    },
  ],
})
