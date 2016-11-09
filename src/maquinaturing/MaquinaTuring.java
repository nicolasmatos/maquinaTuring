package maquinaturing;

import java.util.ArrayList;

public class MaquinaTuring {
    private String txtEstados;
    private String txtAlfabetoMt;
    private String txtAlfabetoFt;
    private String txtRegras;
    private String txtEntrada;
    private String estadoAtual = new String();
    
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
            if (i + 1 < arrayRegras.length) regras.add("$");
        }
        
        regras.remove(regras.size() - 1);
        
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
        
        fita.add("!");
        
        for (int i = 0; i < arrayEstados.length; i++) {
            estados.add(arrayEstados[i]);
            fita.add((i + 1) + "");
            if (i + 1 < arrayEstados.length) fita.add("$");
        }
        fita.add("#");
        for (int i = 0; i < arrayAlfabetoMt.length; i++) {
            alfabetoMt.add(arrayAlfabetoMt[i]);
            fita.add((i + 1) + "");
            if (i + 1 < arrayAlfabetoMt.length) fita.add("$");
        }
        fita.add("#");
        for (int i = 0; i < arrayAlfabetoFt.length; i++) {
            alfabetoFt.add(arrayAlfabetoFt[i]);
            fita.add((i + 1) + "");
            if (i + 1 < arrayAlfabetoFt.length) fita.add("$");
        }
        fita.add("#");   
        for (int i = 0; i < regras.size(); i++) {
            fita.add(regras.get(i));
        }
        fita.add("#");   
        for (int i = 0; i < arrayEntrada.length; i++) {
            for (int j = 0; j < arrayAlfabetoMt.length; j++) {
                if (arrayEntrada[i].equals(arrayAlfabetoMt[j])) {
                    entrada.add(j + 1 + "");
                    fita.add(j + 1 + "");
                    if (i + 1 < arrayAlfabetoMt.length) fita.add("$");
                }
            }
        }
        
        fita.add("!");
        
        for (int j = 0; j < arrayEstados.length; j++) {
            if (estadoAtual.equals(arrayEstados[j])) {
                estadoAtual = j + 1 + "";
            }
        }
    }
    
    public String verificacao() {
        String result = "";
        this.setValores();
        
        int cont = 0, posTrans = 0;
        for (int j = 0; j < fita.size(); j++) {
            if (fita.get(j).equals("#")) {
                cont ++;
            }
            if (cont == 3) {
                posTrans = j + 1;
                j = fita.size();
            }
        }
        
        int x = 0;
        String estadoAnt = "";
        while (x < entrada.size()) {
            for (int j = posTrans; j < fita.size(); j+=11) {
                if (estadoAtual.equals(fita.get(j))) {
                    if (entrada.get(x).equals(fita.get(j + 2))) {
                        entrada.add(x, fita.get(j + 4));
                        entrada.remove(x + 1);
                        estadoAnt = estadoAtual;
                        estadoAtual = fita.get(j + 6);
                        String palavra = "";
                        System.out.println("(" + estadoAnt + ", " + fita.get(j + 2) + ")->(" + fita.get(j + 4) + ", " + estadoAtual + ", " + fita.get(j + 8) + ")");
                        for(int i = 0; i < entrada.size(); i++) {
                            palavra = palavra + entrada.get(i);
                        }
                        System.out.println(palavra);
                        
                        if (fita.get(j + 8).equals("1")) {
                            x--;
                        }
                        if (fita.get(j + 8).equals("2")) {
                            x++;
                        }
                        if (fita.get(j + 8).equals("3")) {
                            j = fita.size();
                            x = entrada.size();
                        }
                        
                        j = fita.size();
                    }
                }
            }
        }
        
        fita.add(fita.size() - 1, "#");
        
        for (int i = 0; i < entrada.size(); i++) {
            fita.add(fita.size() - 1, entrada.get(i));
            if (i + 1 < entrada.size()) fita.add(fita.size() - 1, "$");
        }
            
        for (int i = 0; i < fita.size(); i++) {
            result = result + fita.get(i);
        }
        
        return result;
    }

    public void setEstadoAtual(String estadoAtual) {
        this.estadoAtual = estadoAtual;
    }
}