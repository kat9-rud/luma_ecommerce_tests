package config;

import org.aeonbits.owner.Config;

//@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/${env}.properties",
//        "system:properties"
})
public interface WebDriverConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();
    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();
    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();
    @Key("remoteUrl")
    @DefaultValue("")
    String getRemoteUrl();
    @Key("remoteLogin")
    @DefaultValue("")
    String getRemoteLogin();
    @Key("remotePass")
    @DefaultValue("")
    String getRemotePass();
}
