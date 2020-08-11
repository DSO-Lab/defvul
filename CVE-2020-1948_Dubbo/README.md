# Apache Dubbo CVE-2020-1948 测试环境

## 引子

在这个漏洞出现之初，为了验证该漏洞的危害，我们从互联网上搜寻了很多人整理的例子，发现没有一个能够顺利验证该漏洞，故自己搞了一个，放在这里供大家参考，欢迎交流！

本环境基于 Apache Dubbo 官方示例环境改造而来，纠正了官方示例程序中几处编译中报错问题。例如：

- 官方示例代码中应用的 DubboService 类，实际应该 Service。

## 编译

```
cd src
mvn package
```

编译成功后会在 `src/target` 目录生成 `dubbo.jar` 文件。

## 运行

```
java -jar target/dubbo.jar
```

运行成功后，监听 12345 端口，可以使用 `telnet` 命令连接测试。

```
telnet x.x.x.x 12345
# dubbo> ls -l
# PROVIDER:
#     org.apache.dubbo.spring.boot.sample.consumer.DemoService:1.0.0 ->  published: N
```

## 容器化

```
# 构建
docker build -t dsolab/dubbo:cve-2020-1948 .

# 运行
docker run -p 12345:12345 dsolab/dubbo:cve-2020-1948 -d
或
docker-compose up -d

# 访问
telnet x.x.x.x 12345
```

只想快速使用环境（懒得编译环境）的小朋友可以用下面的命令启动我们提供的镜像环境：

```
# 需要安装 Docker 和 docker-compose
docker-compose up -d
```

## 漏洞验证

参见 [Apache Dubbo CVE-2020-1948 反序列化漏洞验证方法](https://github.com/DSO-Lab/Dubbo-CVE-2020-1948/wiki)

## 参考链接

- Dubbo Spring Boot Project

https://github.com/apache/dubbo-spring-boot-project/

- Dubbo Pull Request

https://github.com/apache/dubbo/pull/6374

- Dubbo Mail Archive

https://www.mail-archive.com/dev@dubbo.apache.org/msg06544.html
