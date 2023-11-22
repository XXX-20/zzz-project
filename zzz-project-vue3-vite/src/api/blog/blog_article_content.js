import request from '@/utils/request'

export function getArticleContent(id) {
    return request({
        url: '/blog-article-content/get',
        method: 'get'
    })
}