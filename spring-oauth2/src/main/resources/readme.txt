





http://localhost:8080/oauth/authorize?response_type=code&client_id=client&redirect_uri=http://www.baidu.com

curl client:secret@localhost:8080/oauth/token -d grant_type=authorization_code -d client_id=client -d redirect_uri=http://www.baidu.com -d code=zf5e7N


TOKEN=dd61e631-78f1-4333-9c7b-54a542999c9d


curl -H "Authorization: Bearer $TOKEN" localhost:8080/user