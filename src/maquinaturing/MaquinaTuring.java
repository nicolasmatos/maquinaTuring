package maquinaturing;

import java.util.ArrayList;

public class MaquinaTuring {
    private String txtEstados;
    private String txtAlfabetoMt;
    private String txtAlfabetoFt;
    private String txtRegras;
    private String txtEntrada;
    
    private ArrayList<String> estados;
    private ArrayList<String> alfabetoMt;
    private ArrayList<String> alfabetoFt;
    private ArrayList<String> regras;
    private ArrayList<String> entrada;
    
    private ArrayList<String> fita;

    public MaquinaTuring() { }

    public MaquinaTuring(String txtEstados, String txtAlfabetoMt, String txtAlfabetoFt, String txtRegras, String txtEntrada) {
        this.txtEstados = txtEstados;
        this.txtAlfabetoMt = txtAlfabetoMt;
        this.txtAlfabetoFt = txtAlfabetoFt;
        this.txtRegras = txtRegras;
        this.txtEntrada = txtEntrada;
        
        estados = new ArrayList();
        alfabetoMt = new ArrayList();
        alfabetoFt = new ArrayList();
        regras = new ArrayList();
        entrada = new ArrayList();
        fita = new ArrayList();
    }
    
    public void setValores() {
        String[] arrayEstados = txtEstados.split(",");
        String[] arrayAlfabetoMt = txtAlfabetoMt.split(",");
        String[] arrayAlfabetoFt = txtAlfabetoFt.split(",");
        String[] arrayRegras = txtRegras.split(",");
        
        for (int i = 0; i < arrayRegras.length; i++) {
            for (String regra : arrayRegras[i].split("/")) {
                regras.add(regra);
                regras.add("$");
            }
            regras.add("$");
        }
        
        for (int i = 0; i < regras.size(); i+=11) {
            for (int j = 0; j < arrayEstados.length; j++) {
                if ((regras.get(i)).equals(arrayEstados[j])) {
                    regras.add(i, j + 1 + "");
                    regras.remove(regras.get(i + 1));
                }
                if ((regras.get(i + 6)).equals(arrayEstados[j])) {
                    regras.add(i + 6, j + 1 + "");
                    regras.remove(regras.get(i + 7));
                }
            }
            for (int j = 0; j < arrayAlfabetoMt.length; j++) {
                if ((regras.get(i + 2)).equals(arrayAlfabetoMt[j])) {
                    regras.add(i + 2, j + 1 + "");
                    regras.remove(regras.get(i + 3));
                }
                if ((regras.get(i + 4)).equals(arrayAlfabetoMt[j])) {
                    regras.add(i + 4, j + 1 + "");
                    regras.remove(regras.get(i + 5));
                }
            }
            if ((regras.get(i + 8)).equals("L")) {
                regras.add(i + 8, "1");
                regras.remove(regras.get(i + 9));
            }
            else if ((regras.get(i + 8)).equals("R")) {
                regras.add(i + 8, "2");
                regras.remove(regras.get(i + 9));
            }
            else {
                regras.add(i + 8, "3");
                regras.remove(regras.get(i + 9));
            }
        }
        
        String[] arrayEntrada = txtEntrada.split("/");
        
        fita.add("b");
        
        for (int i = 0; i < arrayEstados.length; i++) {
            estados.add(arrayEstados[i]);
            fita.add((i + 1) + "");
            fita.add("$");
        }
        fita.add("#");
        for (int i = 0; i < arrayAlfabetoMt.length; i++) {
            alfabetoMt.add(arrayAlfabetoMt[i]);
            fita.add((i + 1) + "");
            fita.add("$");
        }
        fita.add("#");
        for (int i = 0; i < arrayAlfabetoFt.length; i++) {
            alfabetoFt.add(arrayAlfabetoFt[i]);
            fita.add((i + 1) + "");
            fita.add("$");
        }
        fita.add("#");   
        for (int i = 0; i < regras.size(); i++) {
            fita.add(regras.get(i));
        }
        fita.add("#");   
        for (int i = 0; i < arrayEntrada.length; i++) {
            for (int j = 0; j < arrayAlfabetoMt.length; j++) {
                if (arrayEntrada[i].equals(arrayAlfabetoMt[j])) {
                    fita.add(j + 1 + "");
                    fita.add("$");
                }
            }
        }
        fita.add("#");
        
        fita.add("b");
    }
    
    public String verificacao() {
        String result = "";
        this.setValores();
        
        for (int i = 0; i < fita.size(); i++) {
            result = result + fita.get(i);
        }
        
        return result;
    }
}