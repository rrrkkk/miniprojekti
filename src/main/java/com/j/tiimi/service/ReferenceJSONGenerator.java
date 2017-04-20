package com.j.tiimi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j.tiimi.entity.Reference;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ReferenceJSONGenerator {

    //Ei tule vielä nättinä ulos, pitää hinkata...
    public String writeListToJsonArray(List<Reference> references) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(references);
        } catch (JsonProcessingException ex) {
            return ex.toString();
        }
    }
    
    /*try (StringWriter writer = new StringWriter()) {
            mapper.writerWithDefaultPrettyPrinter().writeValue(writer, references);
            return writer.toString(); //use toString() to convert to JSON
            } catch (IOException ex) {
            System.err.println(ex);
            return null;
            }*/
}
