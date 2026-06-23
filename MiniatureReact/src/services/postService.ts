import api from './api'
import type { Post } from '../types'

export async function getPostList(): Promise<Post[]> {
  const response = await api.get<Post[]>('/rest/posts')
  return response.data // 🌟 DEVE ESSERE .data, come nei tornei!
}