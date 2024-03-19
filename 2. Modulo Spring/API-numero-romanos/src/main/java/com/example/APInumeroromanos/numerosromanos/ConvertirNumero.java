package com.example.APInumeroromanos.numerosromanos;

public class ConvertirNumero {

    public String decimalesARomanos(String num) {
        int flag = num.length();
        String numrom = "";
        while (flag > 0) {
            switch (flag) {
                case 4: {
                    numrom = numrom + millares(String.valueOf(num.charAt(num.length() - flag)));
                    flag--;
                    break;
                }
                case 3: {
                    numrom = numrom + validacion("CM", "D", "C", Integer.parseInt(String.valueOf(num.charAt(num.length() - flag))));
                    flag--;
                    break;
                }
                case 2: {
                    numrom = numrom + validacion("XC", "L", "X", Integer.parseInt(String.valueOf(num.charAt(num.length() - flag))));
                    flag--;
                    break;
                }
                case 1: {
                    numrom = numrom + validacion("IX", "V", "I", Integer.parseInt(String.valueOf(num.charAt(num.length() - flag))));
                    flag--;
                    break;
                }
            }
        }
        return numrom;
    }

        private String validacion(String letraA, String letraB, String letraC, int evaluar){
            String romano = "";
            if (evaluar == 9) {
                romano = letraA;
            } else if (evaluar >= 5) {
                romano = letraB;
                for (int i = 6; i <= evaluar; i++) {
                    romano = romano + letraC;
                }
            } else if (evaluar == 4) {
                return (letraC+letraB);
            } else {
                for (int i = 1; i <= evaluar; i++) {
                    romano = romano + letraC;
                }
            }
            return romano;
        }

        private String millares(String num){
            String mil = "";
            for (int i = 0; i < num.length(); i++){
                mil = mil + "M";
            }
        return mil;
        }

    }