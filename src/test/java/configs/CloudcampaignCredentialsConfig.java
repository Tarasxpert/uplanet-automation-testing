package configs;

public final class CloudcampaignCredentialsConfig extends BaseConfig {
    private final static String URL_KEY = "cloudcampaign.url";
    private final static String EMAIL_KEY = "cloudcampaign.email";
    private final static String PASSWORD_KEY = "cloudcampaign.password";

    public final String url;
    public final String email;
    public final String password;

    CloudcampaignCredentialsConfig(String fileName) {
        super(fileName);
        url = getProperty(URL_KEY);
        email = getProperty(EMAIL_KEY);
        password = getProperty(PASSWORD_KEY);
    }
}