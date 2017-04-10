package com.j.tiimi.controller;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReferenceControllerTest {

    @Autowired
    WebApplicationContext webAppContext;

    private MockMvc mockMvc;
    private String jsonBody;

    private String bookJson;
    private String invalidBookJson;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
        jsonBody = "{\n" +
                "\t\"type\": \"Book\",\n" +
                "\t\"attributes\": [\n" +
                "\t\t\t{ \"key\": \"author\", \"value\": \"Seppo\" }\n" +
                "\t\t]\n" +
                "}";

        bookJson = "{\n" +
                "\t\"type\": \"Book\",\n" +
                "\t\"attributes\": [\n" +
                "\t\t\t{ \"key\": \"author\", \"value\": \"Seppo\" },\n" +
                "\t\t\t{ \"key\": \"title\", \"value\": \"Sepon seikkailut\" },\n" +
                "\t\t\t{ \"key\": \"publisher\", \"value\": \"ACM\" },\n" +
                "\t\t\t{ \"key\": \"year\", \"value\": \"1977\" }\n" +
                "\t\t]\n" +
                "}";

        invalidBookJson = "{\n" +
                "\t\"type\": \"Book\",\n" +
                "\t\"attributes\": [\n" +
                "\t\t\t{ \"key\": \"author\", \"value\": \"Seppo\" },\n" +
                "\t\t\t{ \"key\": \"title\", \"value\": \"Sepon seikkailut\" },\n" +
                "\t\t\t{ \"key\": \"publisher\", \"value\": \"ACM\" },\n" +
                "\t\t\t{ \"key\": \"asdf\", \"value\": \"1977\" }\n" +
                "]}";

    }

    @Test
    public void statusOk() throws Exception {
        mockMvc.perform(get("/reference"))
                .andExpect(status().isOk());
    }

    @Test
    public void postTest() throws Exception {
        // tää on validoinnin jälkeen bad request koska ei kaikkia attribuutteja pyynnössä
        try {
            mockMvc.perform(post("/reference")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonBody)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            Assert.fail("Fail: " + e);
        }
    }

    @Test
    public void postFailsWithWrongJson() {
        try {
            mockMvc.perform(post("/reference")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("INVALID JSON")
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

    public Reference generateReference() {
        Reference reference = new Reference();
        reference.setType("Book");
        Attribute attribute = new Attribute();
        attribute.setKey("Author");
        attribute.setValue("Lollero Pallero");
        reference.addAttribute(attribute);

        return reference;
    }
}
