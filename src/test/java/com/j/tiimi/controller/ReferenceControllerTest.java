package com.j.tiimi.controller;

import com.google.gson.Gson;
import com.j.tiimi.entity.Attribute;
import com.j.tiimi.entity.Reference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReferenceControllerTest {

    @Autowired
    WebApplicationContext webAppContext;

    private MockMvc mockMvc;
    private Gson gson;
    private String bookJson;
    private String invalidBookJson;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
        gson = new Gson();

        bookJson = gson.toJson(generateBookReference(
                "Seppo", "Sepon Seikkaulut", "ACM", "1977", "SS1977"));
        invalidBookJson = gson.toJson(generateBookReference(
                "Seppo", "Sepon Seikkaulut", "ACM", "", ""));
    }

    // TODO Testaus incopreecedings ja article tyypeille

    @Test
    public void statusOk() throws Exception {
        mockMvc.perform(get("/reference"))
                .andExpect(status().isOk());
    }

    @Test
    public void postFailsWithNoJsonBody() {
        try {
            mockMvc.perform(post("/reference")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            Assert.fail("Fail: " + e);
        }
    }

    @Test
    public void postSucceedsWithValidBookReference() {
        try {
            mockMvc.perform(post("/reference")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(bookJson)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            Assert.fail("Fail: " + e);
        }
    }

    @Test
    public void postFailsWithInvalidBookReference() {
        try {
            mockMvc.perform(post("/reference")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(invalidBookJson)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            Assert.fail("Fail " + e);
        }
    }

    public Reference generateBookReference(String... values) {
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("author", values[0]));
        attributes.add(new Attribute("title", values[1]));
        attributes.add(new Attribute("publisher", values[2]));
        attributes.add(new Attribute("year", values[3]));

        return new Reference("Book", values[4], attributes);
    }
}
