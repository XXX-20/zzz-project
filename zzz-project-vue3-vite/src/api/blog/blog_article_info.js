import request from '@/utils/request'

export function getArticleInfo(id) {
    return request({
        url: '/blog-article-info/get',
        method: 'get'
    })
}