## 从零搭建springboot3.0框架

### 代码生成
1. 配置 application.yml 中的数据库地址
2. 启动项目访问下面地址，选择要生成的表即可生成相关功能到项目中：
    ```
    http://localhost:8888/light/generate/index
    ```
   选择要生成的表，点击 **提交并生成代码** 即会在项目的`com.light`目录下生成`business`目录，以及其下面对应的`controller`、`service`等全套代码，对应生成规则配置在`com.light.common.generate.Config`文件中（如表有修改选择重新生成会覆盖PO，不会覆盖`controller`等），对应生成的模板在`resources/beetl-back-end`内。生成完build下即有对应表的完整的CURD功能
3. 常用生成配置中，缺省数据库字段名为 `deleted` 为逻辑删除字段 1/0

### 日志
1. 在类上使用 `@Slf4j` 注解，使用的是`lombok`，所以 `IDE` 要先配置其可以使用
2. 使用：`log.error()`
3. 日志打印配置：`resources/logback.xml`
4. 输出配置：`application.yml`中，路径：`log.path`；等级：`log.level`，可选值：`log|debug|info`，文件名：`log.fileName`

### 异常
1. `com.light.common.exception`下，使用：
   ```java
   //在 BusinessExceptionErrorEnum中定义一个枚举
   TEST_ERROR(1001, "test error")
   //在方法中使用
   throw new BusinessException(BusinessExceptionErrorEnum.TEST_ERROR)

### 验权
1. 配置在 `application.yml` 中的 `auth` 下，项目只实现了简易验权，如需要结合`redis`缓存可以修改 `com.light.common.config.interceptor.AuthFilter` 方法
   ```java
   open: true/false  打开/关闭 验权
   tokenName: string 读取 header 中的令牌的名称
   passPaths: string, string  不验权的路径，多个以英文逗号分割，如： /user/login, /user/register
2. 登录，在 `com.light.test.LoginController` 简单的搭配了一个登录接口，来配置验权功能，实际开发登录后删除此控制器即可，具体如下：
   ```java
   @RequestMapping(value="/sys")
   public class LoginController {
      @Data
      public static class SysUser {
         private String name;
         private String password;
      }
   
      @RequestMapping(value="/login", method= RequestMethod.POST)
      public Object login(
              @RequestBody SysUser user) {
   
         if (user.getName() != null && user.getName().equals("admin")
                 && user.getPassword() != null && user.getPassword().equals("123456")
         ) {
            return TokenUtil.createToken(1);
         }
   
         throw new BusinessException(BusinessExceptionErrorEnum.USER_NAME_OR_PASSWORD_ERROR);
      }
   }
   
### 跨域配置
1. 在 `com.light.config.WebConfig` 文件中的 `addCorsMappings` 方法中可以自行修改，缺省允许任何域访问

### 返回的数据结构（ResponseData）

1. `com.light.common.response`下，会将 `com.light.common.business`下返回的数据封装为 `ResponseData`对象:
   ```java
   private Integer code;
   private String message;
   private T data;
  
2. 使用，`com.light.common.business` 的 `controller` 方法中：
   ```java
   @RequestMapping(value="/testResponse", method=RequestMethod.GET)
   public Object testResponse() { 
        return "hello";
   }
   //前端接收到的数据：{"code":0,"message":"调用成功！","data":"hello"}
   //异常返回直接抛异常即可
   throw new BusinessException(BusinessExceptionErrorEnum.TEST_ERROR)
  
