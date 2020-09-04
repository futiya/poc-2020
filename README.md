# poc-2020
## postgre db connection:
- host: 9.112.160.82
- port: 54320
- db: homework
- user: postgres
- password: 123456789

目前有一个表，users
'''
CREATE TABLE public.users (
	id serial NOT NULL,
	email varchar(70) NULL,
	"name" varchar(70) NULL,
	"managerId" int4 NULL,
	"createdAt" timestamptz NOT NULL,
	"updatedAt" timestamptz NOT NULL
);
'''
## 实现
### GET /api/v1/users
返回所有用户
### POST /api/v1/users
创建新用户
### GET /api/v1/users/{id}
读取指定用户信息
### PUT /api/v1/users/{id}
更新指定用户信息
### DELETE /api/vi/users/{id}
删除指定用户
## 技术
* java: spring boot + spring JPA or mybatis
