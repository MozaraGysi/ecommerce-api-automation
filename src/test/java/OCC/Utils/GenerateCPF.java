package OCC.Utils;

import java.util.ArrayList;
import javax.swing.text.MaskFormatter;

public class GenerateCPF {
    private ArrayList<Integer> listRandom = new ArrayList<Integer>();
    private ArrayList<Integer> listNumberMulti = null;

    public int numberRandom() {
        int numero = (int) (Math.random() * 10);
        return numero;
    }

    public ArrayList<Integer> cpfPartial() {
        for (int i = 0; i < 9; i++) {
            listRandom.add(numberRandom());
        }
        return listRandom;
    }

    public ArrayList<Integer> cpfFirstDigit() {
        listNumberMulti = new ArrayList<Integer>();
        int firstDigit;
        int sumTotal = 0;
        int remainderDivision;
        int weight = 10;

        for (int item : listRandom) {
            listNumberMulti.add(item * weight);
            weight--;
        }

        for (int item : listNumberMulti) {
            sumTotal += item;
        }

        remainderDivision = (sumTotal % 11);

        if (remainderDivision < 2) {
            firstDigit = 0;
        } else {
            firstDigit = 11 - remainderDivision;
        }

        listRandom.add(firstDigit);
        return listRandom;
    }

    public ArrayList<Integer> cpfSecondDigit() {
        listNumberMulti = new ArrayList<Integer>();
        int secondDigit;
        int sumTotal = 0;
        int remainderDivision;
        int weight = 11;

        for (int item : listRandom) {
            listNumberMulti.add(item * weight);
            weight--;
        }

        for (int item : listNumberMulti) {
            sumTotal += item;
        }

        remainderDivision = (sumTotal % 11);

        if (remainderDivision < 2) {
            secondDigit = 0;
        } else {
            secondDigit = 11 - remainderDivision;
        }

        listRandom.add(secondDigit);
        return listRandom;
    }

    public String cpfFinal() {
        cpfPartial();
        cpfFirstDigit();
        cpfSecondDigit();

        String cpf = "";
        String text = "";

        for (int item : listRandom) {
            text += item;
        }

        try {
            MaskFormatter mf = new MaskFormatter("###.###.###-##");
            mf.setValueContainsLiteralCharacters(false);
            cpf = mf.valueToString(text);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cpf;
    }
}