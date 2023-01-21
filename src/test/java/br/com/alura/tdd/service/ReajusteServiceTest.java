package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeAll
    public static void antesDeTodos(){
        System.out.println("Antes de todos!");
    }

    @BeforeEach
    public void inicializar(){
        System.out.println("Inicializando teste...");
        this.service = new ReajusteService();
    }

    @AfterAll
    public static void depoisDeTodos(){
        System.out.println("Depois de todos");
    }

    @AfterEach
    public void finalizar(){
        System.out.println("Finalizando teste...");
    }

    @Test
    void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar(){
        funcionario = new Funcionario("Ana", LocalDate.now(),
                new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom(){
        funcionario = new Funcionario("João", LocalDate.now(),
                new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo(){
        funcionario = new Funcionario("Pedro", LocalDate.now(),
                new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
