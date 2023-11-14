import { createRouter, createWebHistory } from 'vue-router'
import IndexView from "@/views/home/IndexView.vue";
import DamageCalculatorView from "@/views/genshen/DamageCalculatorView.vue";
import BlogView from "@/views/blog/BlogView.vue";

const routes = [
  {
    path: '/',
    name: 'index',
    component: IndexView
  },
  {
    path: '/genshinDmgCal',
    name: 'genshinDmgCal',
    component: DamageCalculatorView
  },
  {
    path: '/blog',
    name: 'blog',
    component: BlogView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
