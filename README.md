mybatis dynamic multiple data sources

```shell
$ curl -XGET "localhost:8080/default"
[{"id":1,"name":"Hanmeimei","age":19,"gender":0}]

$ curl -XGET "localhost:8080/master"
[{"id":1,"name":"Hanmeimei","age":19,"gender":0}]

$ curl -XGET "localhost:8080/slave"
[{"id":1,"name":"LiLei","age":18,"gender":0}]
```