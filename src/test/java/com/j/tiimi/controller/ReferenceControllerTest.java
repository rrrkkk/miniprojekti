package com.j.tiimi.controller;

import com.j.tiimi.entity.Attribute;
import com.j.tiimi.entity.Reference;
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

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
        jsonBody = "{\n" +
                "\t\"type\": \"Book\",\n" +
                "\t\"attributes\": [\n" +
                "\t\t\t{ \"key\": \"author\", \"value\": \"Seppo\" }\n" +
                "\t\t]\n" +
                "}";
    }

    @Test
    public void statusOk() throws Exception {
        mockMvc.perform(get("/reference"))
                .andExpect(status().isOk());
    }

    @Test
    public void postTest() {
        try {
            mockMvc.perform(post("/reference")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonBody)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
