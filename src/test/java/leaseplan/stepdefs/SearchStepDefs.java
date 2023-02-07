package leaseplan.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchStepDefs {

    SoftAssert softAssertion = new SoftAssert();

    @When("I call the search product endpoint (.*)")
    public void iCallTheSearchProductEndpointProduct(String product) {
        SerenityRest.given().get("https://waarkoop-server.herokuapp.com/api/v1/search/test/" + product);
    }

    @Then("^I verify that (.*) should be in the search results$")
    public void iVerifyProductShouldBeInSearchResults(String productToVerify) {
        List<HashMap<String, Object>> products = lastResponse().jsonPath().getList("$");
        softAssertion.assertTrue((products).contains(productToVerify));
        assertThat(products).anyMatch(product -> product.get("title").toString().contains(productToVerify));
    }

    @And("the schema should match with the specification defined in (.*)")
    public void theSchemaShouldMatchWithTheSpecificationDefinedIn(String schema) {
        then().body(matchesJsonSchemaInClasspath("schema/" + schema));
    }

    @Then("I verify that a not found error should be displayed in search results")
    public void iVerifyThatANotFoundErrorShouldBeDisplayedInSearchResults() {
        then().statusCode(404).body("detail.error", is(true));
    }

    @Then("I verify that an unauthorized error should be displayed in search result")
    public void iVerifyThatAnUnauthorizedErrorShouldBeDisplayedInSearchResult() {
        then().statusCode(401).body("detail", is("Not authenticated"));
    }

    @Given("I get a {int} from the product endpoint")
    public void iGetAFromTheProductEndpoint(int statusCode) {
        SerenityRest.given().when().get("https://waarkoop-server.herokuapp.com/api/v1/search/test/").then().statusCode(statusCode);
    }
}


