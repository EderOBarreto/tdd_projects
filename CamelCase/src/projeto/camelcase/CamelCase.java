package projeto.camelcase;

import java.util.ArrayList;
import java.util.List;

public class CamelCase {

	public static List<String> converterCamelCase(String original){
		try {
			List<String> list = new ArrayList<>();
			checarPrimeiroCaracter(original);
			checarCaracterIlegal(original);
			list = dividirString(original);
			return list;
		} catch (IllegalArgumentException illegal) {
			throw illegal;
		}
	}

	//criado durante a refatora��o
	//criar fun��o para dividir as strings
	private static List<String> dividirString(String str) {
		List<String> list = new ArrayList<>();
		String dividido = "";
		for(char c : str.toCharArray()) 
			if(checarTipoDiferente(c,dividido)) {
				list.add(converterTipoCaixa(dividido));
				dividido = c + "";
			}
			else 
				dividido += c;
		list.add(converterTipoCaixa(dividido));
		return list;
	}

	//Caso o texto tenha apenas o primeiro n�mero maiusculo
	//ele � convertido para texto de caixa baixa sen�o ele � mantido
	private static String converterTipoCaixa(String str) {
		return (str.length() > 1 && Character.isUpperCase(str.charAt(0)) && Character.isLowerCase(str.charAt(1)))? str.toLowerCase(): str;
	}
	
	//criado durante a refatora��o
	private static boolean checarTipoDiferente(char c, String str) {
		return str.length() > 1 && Character.getType(c) != Character.getType(str.charAt(1));
	}
	
	//criado durante a refatora��o
	private static void checarPrimeiroCaracter(String str) {
		if (!Character.isJavaIdentifierStart(str.charAt(0))) {
			throw new IllegalArgumentException("Caracter ilegal no in�cio!");
		}
	}
	//criado durante a refatora��o
	private static void checarCaracterIlegal(String str) {
		if (str.matches("\\W"))
			throw new IllegalArgumentException("N�o s�o permitidos caracteres especiais!");
	}
}
