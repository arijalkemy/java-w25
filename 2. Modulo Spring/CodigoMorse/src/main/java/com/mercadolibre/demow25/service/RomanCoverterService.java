package com.mercadolibre.demow25.service;

import org.springframework.stereotype.Service;

@Service
public class RomanCoverterService {

    public String castToRoman(Integer number){
        if (number >= 4000)
            return "Error";
        String romanString = "";
        String numberString = number.toString();
        int numberLen = numberString.length();
        for (int i=1 ; i <= numberLen;i++){
            switch (i){
                case 1-> romanString=getUnitsRoman(numberString.charAt(numberLen-i));
                case 2-> romanString=getTensRoman(numberString.charAt(numberLen-i))+romanString;
                case 3-> romanString=getHundredsRoman(numberString.charAt(numberLen-i))+romanString;
                case 4-> romanString=getThousandsRoman(numberString.charAt(numberLen-i))+romanString;
                default -> romanString = "Error";
            }
        }
        return romanString;
    }


    private String getUnitsRoman(char numberChar){
        String romanChar;
        switch (numberChar){
            case  '1' ->  romanChar = "I";
            case  '2' ->  romanChar = "II";
            case  '3' ->  romanChar = "III";
            case  '4' ->  romanChar = "IV";
            case  '5' ->  romanChar = "V";
            case  '6' ->  romanChar = "VI";
            case  '7' ->  romanChar = "VII";
            case  '8' ->  romanChar = "VIII";
            case  '9' ->  romanChar = "IX";
            default -> romanChar="0";
        }
        return  romanChar;
    }

    private String getTensRoman(char numberChar){
        String romanChar;
        switch (numberChar){
            case  '1' ->  romanChar = "X";
            case  '2' ->  romanChar = "XX";
            case  '3' ->  romanChar = "XXX";
            case  '4' ->  romanChar = "XL";
            case  '5' ->  romanChar = "L";
            case  '6' ->  romanChar = "LX";
            case  '7' ->  romanChar = "LXX";
            case  '8' ->  romanChar = "LXXX";
            case  '9' ->  romanChar = "XC";
            default -> romanChar="0";
        }
        return  romanChar;
    }

    private String getHundredsRoman(char numberChar){
        String romanChar;
        switch (numberChar){
            case  '1' ->  romanChar = "C";
            case  '2' ->  romanChar = "CC";
            case  '3' ->  romanChar = "CCC";
            case  '4' ->  romanChar = "CD";
            case  '5' ->  romanChar = "D";
            case  '6' ->  romanChar = "DC";
            case  '7' ->  romanChar = "DCC";
            case  '8' ->  romanChar = "DCCC";
            case  '9' ->  romanChar = "CM";
            default -> romanChar="0";
        }
        return  romanChar;
    }

    private String getThousandsRoman(char numberChar){
        String romanChar;
        switch (numberChar){
            case  '1' ->  romanChar = "M";
            case  '2' ->  romanChar = "MM";
            case  '3' ->  romanChar = "MMM";
            default -> romanChar="0";
        }
        return  romanChar;
    }
}
