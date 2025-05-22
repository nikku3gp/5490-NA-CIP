package uacs.cip.nutrient.supplement.config;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiKeyProperties {
    private static final String API_KEY = "";

    public String getApiKey(){
        return API_KEY;
    }
}
