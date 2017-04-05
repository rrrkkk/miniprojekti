package com.j.tiimi;

import com.j.tiimi.entity.Attribute;
import com.j.tiimi.entity.Reference;
import com.j.tiimi.latex.LatexGenerator;
import com.j.tiimi.service.ReferenceService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class App {

    public static void main(String[] args) {
        //SpringApplication.run(App.class, args);

        makeLatex();
    }
    
    public static void makeLatex() {
        ReferenceService service = new ReferenceService();
        Reference reference = new Reference();
        reference.setIdentifier("asd");
        reference.setType("Book");
        ArrayList<Attribute> attributes = new ArrayList();
        attributes.add(new Attribute().setAttributes("Author", "Matti Lokki"));
        attributes.add(new Attribute().setAttributes("Year", "1998"));
        attributes.add(new Attribute().setAttributes("MAmbo", "Jambo"));
        attributes.add(new Attribute().setAttributes("Kirja", "on se"));
        reference.setAttributes(attributes);
        List<Reference> list = new ArrayList<Reference>();
        list.add(reference);
        System.out.println(new LatexGenerator().getString(list));
    }
}
