package com.j.tiimi;
// tänne tulee cucumberin testimetodeja

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.IOException;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


public class Stepdefs {
    /*
	WebDriver driver = new HtmlUnitDriver();
	String baseUrl = "http://localhost:8080";

    @Given("^user visits input form for references and chooses \"([^\"]*)\" for type$")
    public void user_visits_input_form_for_references_and_chooses_for_type(String type) throws Throwable {
		driver.get(baseUrl + "/" + type);
    }

    @When("^user inputs id \"([^\"]*)\", author \"([^\"]*)\", title \"([^\"]*)\", journal \"([^\"]*)\" and year \"([^\"]*)\"$")
    public void user_inputs_id_author_title_journal_and_year(String id, String author, String title, String journal, String year) throws Throwable {
		WebElement element = driver.findElement(By.name("identifier"));
		element.sendKeys(id);
		element = driver.findElement(By.name("author"));
                element.sendKeys(author);
                element = driver.findElement(By.name("title"));
                element.sendKeys(title);
                element = driver.findElement(By.name("journal"));
                element.sendKeys(journal);
                element = driver.findElement(By.name("year"));
                element.sendKeys(year);
    }

    @Then("^reference is not saved and error message is shown$")
    public void reference_is_not_saved_and_error_message_is_shown() throws Throwable {
        
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }*/

}
