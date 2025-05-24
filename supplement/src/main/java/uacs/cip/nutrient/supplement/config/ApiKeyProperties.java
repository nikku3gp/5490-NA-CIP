package uacs.cip.nutrient.supplement.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiKeyProperties {

    @Value("${app.api.key}")
    private String API_KEY;

    public String getApiKey(){
        return API_KEY;
    }
}
