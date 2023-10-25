package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aluno {
    private String nome;
    private String cpf;
    private Date dataDeAniversario;
    private List<Double> notas = new ArrayList<Double>();
    private List<Integer> frequencia = new ArrayList<Integer>();
    private Curso curso;

}
