import org.junit.Test;
import play.libs.F;
import play.test.TestBrowser;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.*;
import static play.test.Helpers.HTMLUNIT;

/**
 * @author Manuel de la Peña
 */
public class TaskApplicationIntegrationTest {

	/**
	 * add your integration test here
	 * in this example we just check if the welcome page is being shown
	 */
	@Test
	public void testAll() {
		running(
			testServer(
				3333, fakeApplication(inMemoryDatabase())), HTMLUNIT,
			new F.Callback<TestBrowser>() {

				public void invoke(TestBrowser browser) {
					browser.goTo("http://localhost:3333/tasks/all");

					assertThat(
						browser.pageSource()
					).contains("Tasks in the DB");
				}
			}
		);
	}

}