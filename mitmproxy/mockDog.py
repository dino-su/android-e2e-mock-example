from mitmproxy import http

mockResponse = """{"message":[
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg",
    "https:\/\/imgur.com\/qG6YmC0.jpg"],
    "status":"success"}"""

def request(flow: http.HTTPFlow):
    # redirect to different host
    if flow.request.pretty_url == 'https://dog.ceo/api/breeds/image/random/50':
        print('hello world')
        flow.response = http.HTTPResponse.make(
                200,
                mockResponse
        )
