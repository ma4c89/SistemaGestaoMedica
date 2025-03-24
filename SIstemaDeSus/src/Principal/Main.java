package Principal;

import java.io.IOException;
import java.util.ArrayList;

import controller.BancoDados;
import model.Medico;
import model.Paciente;

public class Main {
    public static void main(String[] args) {
        BancoDados b = new BancoDados();
        

        ArrayList<Paciente> pacientes = b.getPacientes();
        ArrayList<Medico> medicos = b.getMedico();
        
        System.out.println("\t---Lista de Pacientes---");
        for (Paciente p : pacientes) {
            System.out.println("Nome: " + p.getNome());
            System.out.println("Idade: " + p.getIdade());
            System.out.println("Peso: " + p.getPeso());
            System.out.println("Altura: " + p.getAltura());
            System.out.println("CPF: " + p.getCpf());
            System.out.println("---------------------------");
        }
        
       
        System.out.println("\n\t---Lista de Médicos---");
        for (Medico m : medicos) {
            System.out.println("Nome: " + m.getNome());
            System.out.println("Especialidade: " + m.getEspecialidade());
            System.out.println("---------------------------");
        }
        
     
        Paciente p = new Paciente("Daniel", 45, 62.9, 1.72, "123456789");
        try {
            b.salvar(p);
            System.out.println("Salvou o paciente: " + p.getNome());
        } catch (IOException e) {
            System.out.println("Erro ao salvar o paciente: " + e.getMessage());
        }
        

        Medico m = new Medico("Dr. João", "Cardiologia");
        try {
            b.salvar(m);
            System.out.println("Salvou o médico: " + m.getNome());
        } catch (IOException e) {
            System.out.println("Erro ao salvar o médico: " + e.getMessage());
        }
    }
}
