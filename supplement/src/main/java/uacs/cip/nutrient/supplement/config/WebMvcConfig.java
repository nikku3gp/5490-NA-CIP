package uacs.cip.nutrient.supplement.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);
    private final ApiKeyInterceptor apiKeyInterceptor;

    public WebMvcConfig(ApiKeyInterceptor apiKeyInterceptor){
        this.apiKeyInterceptor = apiKeyInterceptor;
        logger.info("API key interceptor configured for all controller endpoints");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(apiKeyInterceptor)
                .addPathPatterns("/supplements/**")
                .excludePathPatterns("/h2-console/**")
                .excludePathPatterns("/error");
        logger.info("API Key interception paths configured");
    }
}
