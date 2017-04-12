/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package com.j.tiimi;

import com.j.tiimi.entity.Attribute;
import com.j.tiimi.entity.Reference;
import com.j.tiimi.service.ReferenceService;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import org.springframework.util.Assert;

/**
 *
 * @author jaro
 */
public class bibtexGenerationStepDefs {

    private ReferenceService service;
    private Reference reference;

    @Given("^there are saved references in the system$")
    public void there_are_saved_references_in_the_system() throws Throwable {
        reference = new Reference();
        reference.setType("Book");
        reference.setIdentifier("Martin09");
        ArrayList<Attribute> attributes = new ArrayList();
        attributes.add(new Attribute().setAttributes("author", "Martin, Robert"));
        attributes.add(new Attribute().setAttributes("title", "Clean Code: A Handbook of Agile Software Craftsmanship"));
        attributes.add(new Attribute().setAttributes("year", "2008"));
        attributes.add(new Attribute().setAttributes("publisher", "Prentice Hall"));
        reference.setAttributes(attributes);
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^user tries to download the references$")
    public void user_tries_to_download_the_references() throws Throwable {
        
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^correct file is served for the user to download$")
    public void correct_file_is_served_for_the_user_to_download() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
