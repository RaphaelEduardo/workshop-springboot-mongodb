package com.example.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decodeParam(String text) {
		// Retorna o String decodificado ou o String vazio (caso ocorra algum problema)
		try {
			// Função do Java (parametro/texto, padrao de decodificaçao)
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
}
