package bluecurrent.holder;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static io.restassured.RestAssured.given;

public class TestContext {
    private static TestConfig config = null;
    private static Page page = null;
    static final private Logger logger = LoggerFactory.getLogger(TestContext.class);

    public static TestConfig getConfig() {
        if (config == null) {
            try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class)) {
                config = context.getBean(TestConfig.class);
            }
        }
        return config;
    }

    public static String getAccessToken() {
        return given()
                .formParam("grant_type", "client_credentials").log().all()
                .queryParam("client_id", config.getClientId())
                .queryParam("client_secret", config.getClientSecret())
                .when()
                .post(config.getApiBaseUri() + "/service/security/oauth2/token")
                .then()
                .statusCode(200)
                .extract()
                .response().asString();
    }

    public static Page getPlaywright() {
        if (page == null) {
            logger.info("Configuring Playwright instance");
            Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setChannel("chrome"));
            page = browser.newPage();
        }
        return page;
    }
}

