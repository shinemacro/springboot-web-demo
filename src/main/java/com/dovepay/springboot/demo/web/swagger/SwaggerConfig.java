package com.dovepay.springboot.demo.web.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration	// 该注解就是告诉Spring这个是一个配置文件类，这里配置的Bean要交给Spring去管理。这个就是用来取代Beans.xml这种文件的。
@EnableSwagger2	// 启用 Swagger
public class SwaggerConfig {
  @Bean
  public Docket createRestApi() {
    Predicate<RequestHandler> predicate = input -> true;
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .useDefaultResponseMessages(false)
        .select()
        .apis(predicate)
        .build();
  }
  
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("springboot demo 服务API文档")//大标题
        .version("0.0.1")//版本
        .build();
  }
  
//  /**
//   * 这个地方要重新注入一下资源文件，不然不会注入资源的，也没有注入requestHandlerMappping,相当于xml配置的
//   *  <!--swagger资源配置-->
//   *  <mvc:resources location="classpath:/META-INF/resources/" mapping="swagger-ui.html"/>
//   *  <mvc:resources location="classpath:/META-INF/resources/webjars/" mapping="/webjars/**"/>
//   *  不知道为什么，这也是spring boot的一个缺点（菜鸟觉得的）
//   * @param registry
//   */
//   @Override
//   public void addResourceHandlers(ResourceHandlerRegistry registry) {
//       registry.addResourceHandler("swagger-ui.html")
//       .addResourceLocations("classpath:/META-INF/resources/");
//       registry.addResourceHandler("/webjars*")
//       .addResourceLocations("classpath:/META-INF/resources/webjars/");
//   }
//  //可以注入多个doket，也就是多个版本的api，可以在看到有三个版本groupName不能是重复的，v1和v2是ant风格匹配，配置文件
//  @Bean
//  public Docket api() {
//      //可以添加多个header或参数
//      ParameterBuilder aParameterBuilder = new ParameterBuilder();
//      aParameterBuilder
//              .parameterType("header") //参数类型支持header, cookie, body, query etc
//              .name("token") //参数名
//              .defaultValue("token") //默认值
//              .description("header中token字段测试")
//              .modelRef(new ModelRef("string"))//指定参数值的类型
//              .required(false).build(); //非必需，这里是全局配置，然而在登陆的时候是不用验证的
//      List<Parameter> aParameters = new ArrayList<Parameter>();
//      aParameters.add(aParameterBuilder.build());
//      return new Docket(DocumentationType.SWAGGER_2).groupName("v1").select().apis(RequestHandlerSelectors.any())
//              .paths(PathSelectors.ant("/api/v1/**")).build().apiInfo(apiInfo1()).globalOperationParameters(aParameters);
//  }
//
//
//  private ApiInfo apiInfo1() {
//      return new ApiInfoBuilder()
//              .title("exampleApi 0.01")
//              .termsOfServiceUrl("www.example.com")
//              .contact(new Contact("liumei","http://blog.csdn.net/pc_gad","hilin2333@gmail.com"))
//              .version("v0.01")
//              .build();
//  }
  
}