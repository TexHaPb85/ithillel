package edu.ithillel.io.eScanner;

import edu.ithillel.io._constants.InputOutputConstants;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ScannerFileReadingExample {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(InputOutputConstants.IRREGULAR_VERBS_FILE)))) {
            StringBuilder stringBuilder = new StringBuilder();
            List<IrregularVerb> irregularVerbs = new ArrayList<>();
            while (scanner.hasNext()) {
                String nextLine = scanner.nextLine();
                String[] separateWord = nextLine.split(" ");
                IrregularVerb irregularVerb = new IrregularVerb(separateWord[0], separateWord[1], separateWord[2]);
                irregularVerbs.add(irregularVerb);
                stringBuilder.append(irregularVerb.toString()).append("\n");
            }
            System.out.println(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Error during reading file with scanner: " + e.getMessage());
        }
    }
}

class IrregularVerb {
    private String infinitiveForm;
    private String pastForm;
    private String pastParticipleForm;

    public IrregularVerb(String infinitiveForm, String pastForm, String pastParticipleForm) {
        this.infinitiveForm = infinitiveForm;
        this.pastForm = pastForm;
        this.pastParticipleForm = pastParticipleForm;
    }

    @Override
    public String toString() {
        return infinitiveForm + " - " + pastForm + " - " + pastParticipleForm;
    }
}
