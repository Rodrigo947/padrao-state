import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoletoTest {

    Boleto boleto;

    @BeforeEach
    public void setUp() {
        boleto = new Boleto();
    }

    // Boleto Criado

    @Test
    public void naoDeveCriarBoletoCriado() {
        boleto.setEstado(BoletoEstadoCriado.getInstance());
        assertFalse(boleto.criar());
    }

    @Test
    public void devePagarBoletoCriado() {
        boleto.setEstado(BoletoEstadoCriado.getInstance());
        assertTrue(boleto.pagar());
        assertEquals(BoletoEstadoPago.getInstance(), boleto.getEstado());
    }


    @Test
    public void deveVencerBoletoCriado()  {
        boleto.setEstado(BoletoEstadoCriado.getInstance());
        assertTrue(boleto.vencer());
        assertEquals(BoletoEstadoVencido.getInstance(), boleto.getEstado());
    }

    @Test
    public void deveCancelarBoletoCriado() {
        boleto.setEstado(BoletoEstadoCriado.getInstance());
        assertTrue(boleto.cancelar());
        assertEquals(BoletoEstadoCancelado.getInstance(), boleto.getEstado());
    }

    // Boleto Cancelado

    @Test
    public void naoDeveCriarBoletoCancelado() {
        boleto.setEstado(BoletoEstadoCancelado.getInstance());
        assertFalse(boleto.criar());
    }

    @Test
    public void naoDevePagarBoletoCancelado() {
        boleto.setEstado(BoletoEstadoCancelado.getInstance());
        assertFalse(boleto.pagar());
    }


    @Test
    public void naoDeveVencerBoletoCancelado()  {
        boleto.setEstado(BoletoEstadoCancelado.getInstance());
        assertFalse(boleto.vencer());
    }

    @Test
    public void naoDeveCancelarBoletoCancelado() {
        boleto.setEstado(BoletoEstadoCancelado.getInstance());
        assertFalse(boleto.cancelar());
    }

    // Boleto Pago

    @Test
    public void naoDeveCriarBoletoPago() {
        boleto.setEstado(BoletoEstadoPago.getInstance());
        assertFalse(boleto.criar());
    }

    @Test
    public void naoDevePagarBoletoPago() {
        boleto.setEstado(BoletoEstadoPago.getInstance());
        assertFalse(boleto.pagar());
    }


    @Test
    public void naoDeveVencerBoletoPago()  {
        boleto.setEstado(BoletoEstadoPago.getInstance());
        assertFalse(boleto.vencer());
    }

    @Test
    public void naoDeveCancelarBoletoPago() {
        boleto.setEstado(BoletoEstadoPago.getInstance());
        assertFalse(boleto.cancelar());
    }

    // Boleto Vencido

    @Test
    public void naoDeveCriarBoletoVencido() {
        boleto.setEstado(BoletoEstadoVencido.getInstance());
        assertFalse(boleto.criar());
    }

    @Test
    public void devePagarBoletoVencido() {
        boleto.setEstado(BoletoEstadoVencido.getInstance());
        assertTrue(boleto.pagar());
        assertEquals(BoletoEstadoPago.getInstance(), boleto.getEstado());
    }


    @Test
    public void naoDeveVencerBoletoVencido()  {
        boleto.setEstado(BoletoEstadoVencido.getInstance());
        assertFalse(boleto.vencer());
    }

    @Test
    public void deveCancelarBoletoVencido() {
        boleto.setEstado(BoletoEstadoVencido.getInstance());
        assertTrue(boleto.cancelar());
        assertEquals(BoletoEstadoCancelado.getInstance(), boleto.getEstado());
    }

}