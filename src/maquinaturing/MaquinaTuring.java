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
    private ArrayList<String> saida;
    private ArrayList<String> fita;
    private String[] arrayEstados;
    private String[] arrayAlfabetoMt;
    private String[] arrayAlfabetoFt;
    private String[] arrayRegras;
    private String[] arrayEntrada;

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
        saida = new ArrayList();
        fita = new ArrayList();
    }
    
    public void setValores() {
        arrayEstados = txtEstados.split(",");
        arrayAlfabetoMt = txtAlfabetoMt.split(",");
        arrayAlfabetoFt = txtAlfabetoFt.split(",");
        arrayRegras = txtRegras.split(",");
        
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
            for (int j = 0; j < arrayAlfabetoFt.length; j++) {
                if ((regras.get(i + 2)).equals(arrayAlfabetoFt[j])) {
                    regras.add(i + 2, j + 1 + "");
                    regras.remove(regras.get(i + 3));
                }
                if ((regras.get(i + 4)).equals(arrayAlfabetoFt[j])) {
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
        
        arrayEntrada = txtEntrada.split("/");
        
        fita.add("!");
        
        for (int i = 0; i < arrayEstados.length; i++) {
            estados.add(arrayEstados[i]);
        }
        fita.add(arrayEstados.length + "");
        fita.add("#");
        for (int i = 0; i < arrayAlfabetoMt.length; i++) {
            alfabetoMt.add(arrayAlfabetoMt[i]);
        }
        fita.add(arrayAlfabetoMt.length + "");
        fita.add("#");
        for (int i = 0; i < arrayAlfabetoFt.length; i++) {
            alfabetoFt.add(arrayAlfabetoFt[i]);
        }
        fita.add(arrayAlfabetoFt.length + "");
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
                    if (i + 1 < arrayEntrada.length) fita.add("$");
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
    
    public String converterExecucao(String estadoAnt, String leitura, String escrita, String estadoAtual, String direcao) {
        String result = "";
        result = "(" + estados.get(Integer.parseInt(estadoAnt) - 1) + ", " + alfabetoFt.get(Integer.parseInt(leitura) - 1) + ")->(" + alfabetoFt.get(Integer.parseInt(escrita) - 1) + ", " + estados.get(Integer.parseInt(estadoAtual) - 1) + ", ";
        
        if (direcao.equals("1"))
            result = result + "L)";
        else if (direcao.equals("2"))
            result = result + "R)";
        else
            result = result + "H)";
        
        return result;
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
        
        saida = (ArrayList<String>) entrada.clone();
        saida.add("!");
        
        int x = 0, ctrl = 0;
        String estadoAnt = "";
        while (x < saida.size()) {
            for (int j = posTrans; j < fita.size(); j+=11) {
                if (estadoAtual.equals(fita.get(j))) {
                    if (saida.get(x).equals(fita.get(j + 2))) {
                        saida.add(x, fita.get(j + 4));
                        saida.remove(x + 1);
                        estadoAnt = estadoAtual;
                        estadoAtual = fita.get(j + 6);
                        
                        System.out.println(converterExecucao(estadoAnt, fita.get(j + 2), fita.get(j + 4), estadoAtual, fita.get(j + 8)));
                        
                        String palavra = "";
                        
                        for(int i = 0; i < saida.size() - 1; i++) {
                            palavra = palavra + alfabetoFt.get(Integer.parseInt(saida.get(i)) - 1);
                        }
                        System.out.println(palavra);
                        
                        if (fita.get(j + 8).equals("1")) {
                            x--;
                        }
                        if (fita.get(j + 8).equals("2")) {
                            x++;
                        }
                        
                        if (fita.get(j + 8).equals("3")) {
                            if (saida.get(x).equals("!")) {
                                System.out.println("Ultima");
                            }
                            
                            j = fita.size();
                            x = saida.size();
                        }
                        
                        j = fita.size();
                    }
                }
            }
        }
        
        fita.add(fita.size() - 1, "#");
        
        saida.remove(saida.size() - 1);
        
        for (int i = 0; i < saida.size(); i++) {
            fita.add(fita.size() - 1, saida.get(i));
            if (i + 1 < saida.size()) fita.add(fita.size() - 1, "$");
        }
            
        for (int i = 0; i < fita.size(); i++) {
            result = result + fita.get(i);
        }
        
        return result;
    }
    
    public String codificacao(){
        String result = "";
        String codigoParcial = "";
        for (int i = 0; i < fita.size(); i++) {
            if (!fita.get(i).equals("!")) {
                if (fita.get(i).equals("$")) codigoParcial = codigoParcial + "2";
                else if (fita.get(i).equals("#")) codigoParcial = codigoParcial + "3";
                else codigoParcial = codigoParcial + (Integer.toBinaryString(Integer.parseInt(fita.get(i))));
            }
        }
        
        char[] arrayCodigoParcial = codigoParcial.toCharArray();
        String codigo = "";
        for (int i = 0;i < arrayCodigoParcial.length;i ++) {
            if (arrayCodigoParcial[i] == '0') {
                codigo = codigo + "00";
            }
            else if (arrayCodigoParcial[i] == '1') {
                codigo = codigo + "01";
            }
            else if (arrayCodigoParcial[i] == '2') {
                codigo = codigo + "10";
            }
            else if (arrayCodigoParcial[i] == '3') {
                codigo = codigo + "11";
            }
        }
        
        result  = codigo;

        return result;
    }

    public void setEstadoAtual(String estadoAtual) {
        this.estadoAtual = estadoAtual;
    }
}