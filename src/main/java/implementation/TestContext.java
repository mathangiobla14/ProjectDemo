package implementation;

public class TestContext {

	private PageObjectManager pageObjectManager;
	private WebdriverManager webdriverManager;

	public TestContext() {
		webdriverManager = new WebdriverManager();
		pageObjectManager = new PageObjectManager(webdriverManager.getDriver());
	}

	public WebdriverManager getWebdriverManager() {
		return webdriverManager;

	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}
