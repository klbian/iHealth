import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '首页', icon: 'el-icon-house' }
    }]
  },

  {
    path: '/project',
    component: Layout,
    redirect: '/project/showGoods',
    name: 'Project',
    meta: { title: '药品管理', icon: 'el-icon-shopping-bag-1' },
    children: [
      {
        path: 'showGoods',
        name: 'ShowGoods',
        component: () => import('@/views/project/showGoods/index'),
        meta: { title: '药品展示' }
      },
      {
        path: 'addVariety',
        name: 'AddVariety',
        component: () => import('@/views/project/addVariety/index'),
        meta: { title: '分类管理' }
      }
    ]
  },

  {
    path: '/order',
    component: Layout,
    children: [
      {
        path: 'index',
        name: 'Order',
        component: () => import('@/views/order/index'),
        meta: { title: '订单管理', icon: 'el-icon-shopping-cart-full' }
      }
    ]
  },

  {
    path: '/data',
    component: Layout,
    redirect: '/data/daliy',
    name: 'Data',
    meta: {
      title: '数据查看',
      icon: 'el-icon-data-line'
    },
    children: [
      {
        path: 'daliy',
        name: 'Daliy',
        component: () => import('@/views/data/daliy/index'),
        meta: { title: '日报表' }
      },
      {
        path: 'monthly',
        name: 'Monthly',
        component: () => import('@/views/data/monthly/index'),
        meta: { title: '月报表' }
      },
      {
        path: 'annual',
        name: 'Annual',
        component: () => import('@/views/data/annual/index'),
        meta: { title: '年报表' }
      },
      {
        path: 'statement',
        name: 'Statement',
        component: () => import('@/views/data/statement/index'),
        meta: { title: '对账表' }
      }
    ]
  },
  {
    path: '/information',
    component: Layout,
    redirect: '/information/article',
    meta: { title: '信息处理', icon: 'el-icon-shopping-cart-full' },
    children: [
      {
        path: 'article',
        name: 'Article',
        component: () => import('@/views/information/Article/index'),
        meta: { title: '信息处理' }
      }
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
