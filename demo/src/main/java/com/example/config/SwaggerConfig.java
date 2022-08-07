package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket Api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(Info()).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo")).paths(PathSelectors.any()).build()
				.pathMapping("/");
	}
	@SuppressWarnings("deprecation")
	public ApiInfo Info() {
		return new ApiInfo( "API's", "rest api description.", "1.0", "test@gmail.com", "karthikeyan", "license", "www.license.co.in");
	}

	/*
	 * @Bean public static BeanPostProcessor
	 * springfoxHandlerProviderBeanPostProcessor() { return new BeanPostProcessor()
	 * {
	 * 
	 * @Override public Object postProcessAfterInitialization(Object bean, String
	 * beanName) throws BeansException { if (bean instanceof
	 * WebMvcRequestHandlerProvider ) {
	 * customizeSpringfoxHandlerMappings(getHandlerMappings(bean)); } return bean; }
	 * 
	 * private <T extends RequestMappingInfoHandlerMapping> void
	 * customizeSpringfoxHandlerMappings(List<T> mappings) { List<T> copy =
	 * mappings.stream() .filter(mapping -> mapping.getPatternParser() == null)
	 * .collect(Collectors.toList()); mappings.clear(); mappings.addAll(copy); }
	 * 
	 * @SuppressWarnings("unchecked") private List<RequestMappingInfoHandlerMapping>
	 * getHandlerMappings(Object bean) { try { Field field =
	 * ReflectionUtils.findField(bean.getClass(), "handlerMappings");
	 * field.setAccessible(true); return (List<RequestMappingInfoHandlerMapping>)
	 * field.get(bean); } catch (IllegalArgumentException | IllegalAccessException
	 * e) { throw new IllegalStateException(e); } } }; }
	 * 
	 */


}
