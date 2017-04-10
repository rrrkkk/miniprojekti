
package com.j.tiimi.latex;

import com.j.tiimi.entity.* ;
import org.springframework.stereotype.Component;

@Component
public class LatexGenerator {

    public String generateLatex(Reference reference) {
        String latex = "";
        latex += "@" + reference.getType().toLowerCase() + "{" + reference.getIdentifier() + ",\n";
        for (Attribute attr : reference.getAttributes()) {
            latex += "\t" + attr.getKey().toLowerCase() + " = {" + attr.getValue() + "},\n";
        }
        latex += "}\n\n";
        return latex;
    }
    
}
