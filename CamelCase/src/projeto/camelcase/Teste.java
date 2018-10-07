package projeto.camelcase;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class Teste {

	@Test
	public void chamaConverter() {
		String str = "camelcase";
		List<String> list = CamelCase.converterCamelCase(str);
		assertEquals("camelcase", list.get(0));
	}
	
	@Test
	public void chamaConverterParaMinusculo() {
		String str = "Camel";
		List<String> list = CamelCase.converterCamelCase(str);
		assertEquals("camel", list.get(0));
	}
	
	@Test
	public void chamaConverterParaDividirString() {
		String str = "camelCase";
		List<String> list = CamelCase.converterCamelCase(str);
		assertEquals("camel", list.get(0));
		assertEquals("case", list.get(1));
	}
	
	@Test
	public void chamaConverterComPalavraEmCaixaAltaNoFinal() {
		String str = "camelCASE";
		List<String> list = CamelCase.converterCamelCase(str);
		assertEquals("camel", list.get(0));
		assertEquals("CASE", list.get(1));
	}
	
	@Test
	public void chamaConverterComPalavraEmCaixaAltaNoInicio() {
		String str = "CAMELcase";
		List<String> list = CamelCase.converterCamelCase(str);
		assertEquals("CAMEL", list.get(0));
		assertEquals("case", list.get(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void chamaConverterComNumeroNoInicio() {
		String str = "10case";
		List<String> list = CamelCase.converterCamelCase(str);
	}
	
	@Test
	public void chamaConverterComNumeroNoFinal() {
		String str = "case10";
		List<String> list = CamelCase.converterCamelCase(str);
		assertEquals("case", list.get(0));
		assertEquals("10", list.get(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void chamaConverterComCaracterIlegal() {
		String str = "10case$#@";
		List<String> list = CamelCase.converterCamelCase(str);
	}
	
	@Test
	public void chamaConverterComTodosTiposPermitidos() {
		String str = "camelCase10CPF";
		List<String> list = CamelCase.converterCamelCase(str);
		assertEquals("camel", list.get(0));
		assertEquals("case", list.get(1));
		assertEquals("10", list.get(2));
		assertEquals("CPF", list.get(3));
	}
	
	
	
}
