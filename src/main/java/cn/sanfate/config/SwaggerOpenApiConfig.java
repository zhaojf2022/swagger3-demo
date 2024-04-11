package cn.sanfate.config;

// 注解配置方式的引入类
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringBootConfiguration;

// 类对象配置方式的引入类
//import java.util.HashMap;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.Paths;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;

/**
 * Swagger的配置
 * @author Anhui OuYang
 * @version 1.0
 **/

//使用注解的方式实现
@SpringBootConfiguration
@OpenAPIDefinition(
    // API的基本信息，包括标题、版本号、描述、联系人等
    info = @Info(
            title = "Swagger3.0 (Open API) 框架学习示例文档",       // Api接口文档标题（必填）
            description = "学习Swagger框架而用来定义测试的文档",      // Api接口文档描述
            version = "1.2.1",                                   // Api接口版本
            termsOfService = "https://example.com/",             // Api接口的服务条款地址
            contact = @Contact(
                    name = "蚂蚁小哥",                            // 作者名称
                    email = "xiaofeng@qq.com",                  // 作者邮箱
                    url = "https://www.cnblogs.com/antLaddie/"  // 介绍作者的URL地址
            ),
            license = @License(                                                // 设置联系人信息
                    name = "Apache 2.0",                                       // 授权名称
                    url = "https://www.apache.org/licenses/LICENSE-2.0.html"   // 授权信息
            )
    ),
    security = @SecurityRequirement(name = "JWT-test"),
    // 表示服务器地址或者URL模板列表，多个服务地址随时切换（只不过是有多台IP有当前的服务API）
    servers = {
            @Server(url = "http://localhost/demo/", description = "本地测试"),
            @Server(url = "http://106.14.68.165/demo/", description = "服务器部署"),
    },
    externalDocs = @ExternalDocumentation(description = "更多内容请查看该链接", url = "xxx"))
@SecurityScheme(
    name = "JWT-test",                   // 认证方案名称
    type = SecuritySchemeType.HTTP,      // 认证类型，当前为http认证
    description = "这是一个认证的描述详细",  // 描述信息
    in = SecuritySchemeIn.HEADER,        // 代表在http请求头部
    scheme = "bearer",                   // 认证方案，如：Authorization: bearer token信息
    bearerFormat = "JWT")                // 表示使用 JWT 格式作为 Bearer Token 的格式
@SecurityScheme(
    name = "X-API-KEY",
    type = SecuritySchemeType.APIKEY,
    description = "这是一个认证的描述详细",
    in = SecuritySchemeIn.HEADER,
    scheme = "bearer")

//@Configuration
public class SwaggerOpenApiConfig {
//
//// 使用代码的方式实现
//    @Bean
//    public OpenAPI customOpenApi() {
//
//        // 联系人信息(contact)，构建API的联系人信息，用于描述API开发者的联系信息，包括名称、URL、邮箱等
//        // name：文档的发布者名称 url：文档发布者的网站地址，一般为企业网站 email：文档发布者的电子邮箱
//        Contact contact = new Contact()
//                .name("蚂蚁小哥")
//                .email("xiaofeng@qq.com")
//                .url("https://www.cnblogs.com/antLaddie/")
//                .extensions(new HashMap<>());
//
//        // 授权许可信息(license)，用于描述API的授权许可信息，包括名称、URL等；假设当前的授权信息为Apache 2.0的开源标准
//        License license = new License()
//                .name("Apache 2.0")
//                .url("https://www.apache.org/licenses/LICENSE-2.0.html")
//                .identifier("Apache-2.0")
//                .extensions(new HashMap<>());
//
//        //创建Api帮助文档的描述信息、联系人信息(contact)、授权许可信息(license)
//        Info info = new Info()
//                // Api接口文档标题（必填）
//                .title("Open API(Swagger3.0)框架学习示例文档")
//                .description("测试文档")
//                .version("1.2.1")
//                .termsOfService("https://example.sanfate.cn/")
//                .license(license)
//                .contact(contact);
//
//        //通过Paths可以配置多组接口信息(Paths接收PathItem，这里的每个PathItem我抽取方式出去了)
//        Paths paths = new Paths();
//        paths.put("根据传入的老师信息进行数据保存", InterfaceDescriptionConfig.addTeacher());
//
//        // 返回信息
//        return new OpenAPI()
//                .openapi("3.0.1")
//                .paths(paths)
//                .info(info);
//    }
}
