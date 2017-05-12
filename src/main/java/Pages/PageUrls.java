package Pages;

import specification.TestConfig;

/**
 * System under test page locators are stored here.
 * in order the possibility the web driver to go directly to the
 * specified page location (not "getting the base url->clicking links" to reach the needed page)
 * is present.
 */
public final class PageUrls {

    public final String BASE_URL = new TestConfig().getSystemUnderTestBaseUrl();
}
