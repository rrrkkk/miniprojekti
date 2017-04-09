package com.j.tiimi.latex;

import java.util.ArrayList;
import com.j.tiimi.service.ReferenceService;
import com.j.tiimi.entity.*;
import com.j.tiimi.latex.BibtexGenerator;
import java.io.IOException;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LatexGeneratorTest {

    @Autowired
    private ReferenceService service;
    Reference reference;
    BibtexGenerator generator;
    String latex;

    @Before
    public void initialize() {
        reference = new Reference();
        reference.setType("Book");
        reference.setIdentifier("Martin09");
        ArrayList<Attribute> attributes = new ArrayList();
        attributes.add(new Attribute().setAttributes("author", "Martin, Robert"));
        attributes.add(new Attribute().setAttributes("title", "Clean Code: A Handbook of Agile Software Craftsmanship"));
        attributes.add(new Attribute().setAttributes("year", "2008"));
        attributes.add(new Attribute().setAttributes("publisher", "Prentice Hall"));
        reference.setAttributes(attributes);
        generator = new BibtexGenerator();

        latex = "@book{Martin09,\nauthor = {Martin, Robert},\ntitle = {Clean Code: A Handbook of Agile Software Craftsmanship},\n"
                + "year = {2008},\npublisher = {Prentice Hall},\n}\n\n";
    }

    @Test
    public void getLatexStringTest1() {
        ArrayList<Reference> reflist = new ArrayList();
        reflist.add(reference);
        assertEquals(generator.getBibtex(reflist), latex);
    }

    @Test
    public void getLatexFileTest1() {
        ArrayList<Reference> reflist = new ArrayList();
        reflist.add(reference);
        try {
            assertEquals(readFile(reflist), latex);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private String readFile(ArrayList<Reference> reflist) throws IOException {
        Scanner reader = new Scanner(generator.getBibtexFile(reflist));
        StringBuilder sb = new StringBuilder();

        while (reader.hasNextLine()) {
            sb.append(reader.nextLine());
        }
        reader.close();
        return sb.toString();
    }

}
