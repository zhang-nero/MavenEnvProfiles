# MavenEnvProfiles
## SpringBoot使用Maven pom.xml配置不同环境参数

运行测试环境命令:
mvn clean spring-boot:run -P dev

打包生产环境包命令:
mvn clean package -P pro -Dmaven.test.skip=true 
