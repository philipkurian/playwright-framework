package bluecurrent.pages;


import bluecurrent.holder.TestConfig;
import bluecurrent.holder.TestContext;
import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage {
    static final private Logger log = LoggerFactory.getLogger(HomePage.class);
    private final Page playwright;
    private final TestConfig config;

    public HomePage() {
        this.config = TestContext.getConfig();
        this.playwright = TestContext.getPlaywright();
    }

    public void navigateToBlueCurrentHomePage() {
        playwright.navigate(config.getHomePageUrl());
    }
}
