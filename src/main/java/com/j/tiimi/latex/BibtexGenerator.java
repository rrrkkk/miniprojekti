package com.j.tiimi.latex;

import com.j.tiimi.entity.Reference;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class BibtexGenerator {

    private LatexGenerator latexgenerator;

    public BibtexGenerator() {
        latexgenerator = new LatexGenerator();
    }

    public String getBibtex(List<Reference> references) {
        StringBuilder latex = new StringBuilder();
        for (Reference reference : references) {
            latex.append(latexgenerator.generateLatex(reference));
        }
        return latex.toString();
    }

    public File getBibtexFile(List<Reference> references) {
        File bibtex = new File("bibtex.txt");
        try {
            PrintWriter writer = new PrintWriter("bibtex.txt", "UTF-8");
            for (Reference reference : references) {
                writer.write(latexgenerator.generateLatex(reference));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return bibtex;
    }
}
