
package com.j.tiimi.latex;

import com.j.tiimi.entity.* ;
import java.util.List;

public class LatexGenerator {

    public String getString(List<Reference> references) {
        StringBuilder latex = new StringBuilder();
        for (Reference reference : references) {
            latex.append(generateLatex(reference));
        }
        return latex.toString();
    }

    public String generateLatex(Reference reference) {
        String latex = "";
        latex += "@" + reference.getType().toLowerCase() + "{" + reference.getIdentifier() + ",\n";
        for (Attribute attr : reference.getAttributes()) {
            latex += attr.getKey().toLowerCase() + " = {" + attr.getValue() + "},\n";
        }
        latex += "}\n\n";
        return latex;
    }
}
