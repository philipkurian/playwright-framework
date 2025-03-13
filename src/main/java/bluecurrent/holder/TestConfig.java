package bluecurrent.holder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = {"nz.co.vector.bluecurrent*"})
@PropertySource("classpath:application.properties")
public class TestConfig {
    private final String clientId;
    private final String clientSecret;
    private final String apiBaseUri;
    private final String apiKey;
    private final String homePageUrl;

    public TestConfig(@Value("${api.base.uri}") String apiBaseUri,
                      @Value("${oauth.client.id:xyz}") String clientId,
                      @Value("${oauth.client.secret}") String clientSecret,
                      @Value("${oauth.api.key}") String apiKey,
                      @Value("${home.page.url}") String homePageUrl) {

        this.apiBaseUri = apiBaseUri;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.apiKey = apiKey;
        this.homePageUrl = homePageUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getApiBaseUri() {
        return apiBaseUri;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }
}


