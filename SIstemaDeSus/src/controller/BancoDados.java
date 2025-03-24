package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import model.Medico;
import model.Paciente;

public class BancoDados {
    private Medico medico;
    private Paciente paciente;
    private ArrayList<Medico> medicos;
    private ArrayList<Paciente> pacientes;
    private ArrayList<String> linhas;

    public BancoDados() {
        medicos = new ArrayList<Medico>();
        pacientes = new ArrayList<Paciente>();
        linhas = ler(); 
        pacientes = transformarPacientes(linhas);  
        medicos = transformarMedicos(linhas);
    }

    public ArrayList<Medico> getMedico() {
        return medicos;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
    
    public ArrayList<String> ler() {
        try {
            FileInputStream fisM = new FileInputStream("medico.txt");
            InputStreamReader isrM = new InputStreamReader(fisM);
            BufferedReader brM = new BufferedReader(isrM);
            
            ArrayList<String> linhasMedico = new ArrayList<>();
            String linhaMedico = brM.readLine();
            
          
            while (linhaMedico != null) {
                linhasMedico.add(linhaMedico);
                linhaMedico = brM.readLine();
            }

            brM.close();
            isrM.close();
            fisM.close();
            
            FileInputStream fis = new FileInputStream("pacientes.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            ArrayList<String> linhasPaciente = new ArrayList<>();
            String linhaPaciente = br.readLine();

      
            while (linhaPaciente != null) {
                linhasPaciente.add(linhaPaciente);
                linhaPaciente = br.readLine();
            }

            br.close();
            isr.close();
            fis.close();
            
        
            ArrayList<String> todasLinhas = new ArrayList<>();
            todasLinhas.addAll(linhasMedico);
            todasLinhas.addAll(linhasPaciente);
            
            return todasLinhas;
            
        } catch (Exception e) {
            System.out.println("Erro ao ler os arquivos: " + e.getMessage());
            return null;
        }
    }


    public ArrayList<Paciente> transformarPacientes(ArrayList<String> linhas) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        
        for (String linha : linhas) {
            String[] linha_obj = linha.split(",");
            
            if (linha_obj.length == 5) {  
                try {
                    String nome = linha_obj[0].trim();
                    int idade = Integer.parseInt(linha_obj[1].trim());
                    double peso = Double.parseDouble(linha_obj[2].trim());
                    double altura = Double.parseDouble(linha_obj[3].trim());
                    String cpf = linha_obj[4].trim();
                    
                    paciente = new Paciente(nome, idade, peso, altura, cpf);
                    pacientes.add(paciente);
                } catch (NumberFormatException e) {
                	NumberFormatException exception;
                }
            }
        }
        
        return pacientes;
    }


    public ArrayList<Medico> transformarMedicos(ArrayList<String> linhas) {
        ArrayList<Medico> medicos = new ArrayList<>();
        
        for (String linha : linhas) {
            String[] linha_obj = linha.split(",");
            
            if (linha_obj.length == 2) {  
                String nome = linha_obj[0].trim();
                String especialidade = linha_obj[1].trim();
                
                medico = new Medico(nome, especialidade);
                medicos.add(medico);
            }
        }
        
        return medicos;
    }

    public void salvar(Paciente p) throws IOException {
        OutputStream os = new FileOutputStream("pacientes.txt", true);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        String linha = p.getNome() + ", " + p.getIdade() + ", " + p.getPeso() + ", " + p.getAltura() + ", " + p.getCpf();
        bw.write(linha);
        bw.newLine();

        bw.close();
        osw.close();
        os.close();
    }
    
    public void salvar(Medico m) throws IOException {
        OutputStream os = new FileOutputStream("medico.txt", true);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        String linha = m.getNome() + ", " + m.getEspecialidade();
        bw.write(linha);
        bw.newLine();

        bw.close();
        osw.close();
        os.close();
    }

}
