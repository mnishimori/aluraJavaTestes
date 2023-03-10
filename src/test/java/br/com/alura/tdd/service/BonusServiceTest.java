package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService bonusService = new BonusService();

        assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(new Funcionario("Rodrigo",
                LocalDate.now(), new BigDecimal("25000"))));
    }

    @Test
    void deveriaLancarExcecaoParaFuncionarioComSalarioMuitoAlto() {
        BonusService bonusService = new BonusService();

        try {
            bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
            fail("Não lançou a exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Funcionário com salário maior do que R$ 10 mil não pode receber bônus!", e.getMessage());
        }
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario(){
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(),
                new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalarioParaSalarioDeExatamente10000(){
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(),
                new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}