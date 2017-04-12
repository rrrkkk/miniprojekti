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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebAppConfiguration
@SpringBootTest
@RunWith(SpringRunner.class)
public class Stepdefs {

    @Autowired
    private WebApplicationContext webAppContext;

    private MockMvc mockMvc;
    private String asd;

    @Given("^user visits input form for references and chooses \"([^\"]*)\" for type$")
    public void user_visits_input_form_for_references_and_chooses_for_type(String arg1) throws Throwable {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
        ResultActions result = mockMvc.perform(get("/" + arg1));

        // Write code here that turns the phrase above into concrete actions
    }

    @When("^inputs id \"([^\"]*)\", author \"([^\"]*)\", title \"([^\"]*)\", journal \"([^\"]*)\" and year \"([^\"]*)\"$")
    public void inputs_id_author_title_journal_and_year(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        throw new PendingException();
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^reference is not saved and error message is shown$")
    public void reference_is_not_saved_and_error_message_is_shown() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
