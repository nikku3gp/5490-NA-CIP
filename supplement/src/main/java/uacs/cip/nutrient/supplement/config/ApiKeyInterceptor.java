package uacs.cip.nutrient.supplement.config;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ApiKeyInterceptor.class);
    private static final String API_KEY_HEADER = "";

    private final ApiKeyProperties apiKeyProperties;

    public ApiKeyInterceptor(ApiKeyProperties apiKeyProperties){
        this.apiKeyProperties = apiKeyProperties;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String method = request.getMethod();
        String path = request.getRequestURI();

        String apiKey = request.getHeader(API_KEY_HEADER);

        if(apiKey == null || !apiKey.equals(apiKeyProperties.getApiKey())){
            logger.warn("Unauthorized access attempt: {} {} - invalid or missing API key", method, path);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Invalid or missing API key");
            return false;
        }

        logger.debug("API key authentication successful for: {} {}", method, path);
        return true;
    }
}
