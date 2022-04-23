# RESTful microPoS 


请参考spring-petclinic-rest/spring-petclinic-microserivces 将aw04的webpos项目改为rest风格的微服务架构
（至少包含产品管理服务pos-products和购物车管理服务pos-carts以及discovery/gateway等微服务架构下需要的基础设施服务）。具体要求包括：

1. 请使用OpenAPI的定义每个服务的rest接口（参考pos-products）
2. 请使用ehcache管理缓存；
3. 请注意使用断路器等机制；
4. 有兴趣的同学可自学一些reactjs或vuejs等为microPoS开发一个前端。



------

此次作业实现了pos-discovery、pos-gateway、pos-products与pos-carts四个微服务，均以OpenAPI定义了上述服务的接口。

pos-gateway端口8081，调用pos-products与pos-carts服务。

pos-products端口8083，拥有查看所有物品与查看特定id 的物品功能，并通过ehcache框架实现缓存，其接口分别为`/api/products`,`/api/products/{productId}`。

pos-carts端口8084，拥有查看购物车与添加购物车的功能，添加购物车功能配置有断路器，在发生错误时能够直接返回错误信息，其接口分别为`/api/cart`,`/api/cart/add/{productId}`。

