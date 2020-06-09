package com.lacomania.api.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class FormatUtils {

	    private FormatUtils() {

	    }
	    
	    public static String formataDateDDMMYYYY(Date date) {
	        return formatDate("dd/MM/yyyy", date);
	    }

	    public static String formataDateMMYYYY(Date date) {
	        return formatDate("MM/yyyy", date);
	    }
	    
	    public static String formataDateHHMM(Date date) {
	        return formatDate("HH:mm", date);
	    }

	    public static String formataDateYYYYMMDD(Date date) {
	        return formatDate("yyyy/MM/dd", date);
	    }

	    private static String formatDate(String pattern, Date date) {
	        if (date == null) {
	            return "";
	        }
	        return new SimpleDateFormat(pattern).format(date);
	    }

	    public static String formataCNAE(Long cnae) {
	        if (cnae == null) {
	            return "";
	        }
	        return formataCNAE(Long.toString(cnae));
	    }

	    public static String formataCNAE(String numero) {
	        if (numero == null || numero.isEmpty()) {
	            return "";
	        }
	        String retorno = numero;
	        retorno = retorno.replaceAll("-", "").replaceAll("/", "").replaceAll("_", "").replaceAll(" ", "");
	        if (retorno.length() < 5) {
	            retorno = StringUtils.leftPad(retorno, 5, '0');
	        }
	        if (retorno.length() <= 5) {
	            retorno = retorno.substring(0, 4) + "-" + retorno.substring(4, 5);

	        } else {
	            if (retorno.length() == 6) {
	                retorno = StringUtils.leftPad(retorno, 7, '0');
	            }
	            retorno =retorno.substring(0, 4) + "-" + retorno.substring(4, 5) + "/" + retorno.substring(5);

	        }
	        return retorno;
	    }

	    public static String formataTelefone(Long numero) {
	        if (numero == null) {
	            return "";
	        }
	        return formataTelefone(Long.toString(numero));
	    }

	    /**
	     * Espera-se que o numero possa ser formatado como (XX) XXXX-XXXX
	     * 
	     * @param numero
	     * @return
	     */
	    public static String formataTelefone(String numero) {
	        if (numero == null || numero.isEmpty()) {
	            return "";
	        }
	        String retorno = numero;
	        retorno = retorno.replaceAll("-", "").replaceAll("/", "").replaceAll("_", "").replaceAll(" ", "");
	        if (retorno.length() < 10) {
	            retorno = StringUtils.leftPad(retorno, 10, '0');
	        }

	        retorno = "(" + retorno.substring(0, 2) + ") " + retorno.substring(2, 6) + "-" + retorno.substring(6);

	        return retorno;
	    }

	    public static String formataCelular(Long numero) {
	        if (numero == null) {
	            return "";
	        }
	        return formataCelular(Long.toString(numero));
	    }

	    public static String formataCelular(String numero) {
	        if (numero == null || numero.isEmpty()) {
	            return "";
	        }
	        String retorno = numero;
	        retorno = retorno.replaceAll("-", "").replaceAll("/", "").replaceAll("_", "").replaceAll(" ", "")
	                .replaceAll("\\.", "");
	        if (retorno.length() < 10) {
	            retorno = StringUtils.leftPad(retorno, 10, '0');
	        }
	        if (retorno.length() == 11) {
	            retorno = "(" + retorno.substring(0, 2) + ") " + retorno.substring(2, 3) + "." + retorno.substring(3, 7)
	                    + "-" + retorno.substring(7);
	        } else {
	            retorno = "(" + retorno.substring(0, 2) + ") " + retorno.substring(2, 6) + "-" + retorno.substring(6);
	        }

	        return retorno;
	    }

	    /**
	     * 01 234 567 891011 1213 00.000.000/0000-00
	     * 
	     */
	    public static String formataCNPJ(String numero) {
	        if (numero == null || numero.isEmpty()) {
	            return "";
	        }
	        String retorno = numero.replaceAll("\\D", "");
	        if (retorno.length() < 14) {
	            retorno = StringUtils.leftPad(retorno, 14, '0');
	        }
	        return retorno.substring(0, 2) + "." + retorno.substring(2, 5) + "." + retorno.substring(5, 8) + "/"
	                + retorno.substring(8, 12) + "-" + retorno.substring(12);
	    }

	    /**
	     * 01 234 567 891011 1213 00.000.000/0000-00
	     * 
	     */
	    public static String formataCNPJ(Long numero) {
	        if (numero == null) {
	            return "";
	        }
	        return formataCNPJ(Long.toString(numero));
	    }
	    
	    public static Long parseCNPJ(String numero){
	    
	    	String retorno = numero.replace(".", "");
	    	retorno = retorno.replace("/","");
	    	retorno = retorno.replaceAll("-", "");
	    	
	    	return Long.parseLong(retorno);
	    	
	    }

	    /**
	     * 012 345 678 910 000.000.000-00
	     * 
	     */
	    public static String formataCPF(String numero) {
	        if (numero == null) {
	            return "";
	        }
	        String retorno = numero;
	        retorno = retorno.replaceAll("-", "").replaceAll("/", "").replaceAll("_", "").replaceAll(" ", "")
	                .replaceAll("\\.", "");
	        if (retorno.length() < 11) {
	            retorno = StringUtils.leftPad(retorno, 11, '0');
	        }
	        retorno = retorno.substring(0, 3) + "." + retorno.substring(3, 6) + "." + retorno.substring(6, 9) + "-"
	                + retorno.substring(9);
	        return retorno;
	    }

	    public static String formataCPF(Long numero) {
	        if (numero == null) {
	            return "";
	        }
	        return formataCPF(Long.toString(numero));
	    }

	    /**
	     * Método utilizado para gerar cpf com os zeros no formato de String( serve para
	     * busca por LDAP)
	     * 
	     * @param numero
	     * @return
	     */

	    public static String formataCPFComZeros(String numero) {
	        if (numero == null) {
	            return "";
	        }
	        String retorno = numero;
	        retorno = retorno.replaceAll("-", "").replaceAll("/", "").replaceAll("_", "").replaceAll(" ", "")
	                .replaceAll("\\.", "");
	        if (retorno.length() < 11) {
	            retorno = StringUtils.leftPad(retorno, 11, '0');
	        }
	        return retorno;
	    }

	    public static String formataCPFComZeros(Long numero) {
	        if (numero == null) {
	            return "";
	        }
	        return formataCPFComZeros(Long.toString(numero));
	    }

	    /**
	     * 012 345 678 910 000.000.000-00
	     * 
	     */
	    public static String formataCEP(String numero) {
	        if (numero == null || numero.isEmpty()) {
	            return "";
	        }
	        String retorno = numero;
	        retorno = retorno.replaceAll("-", "").replaceAll("/", "").replaceAll("_", "").replaceAll(" ", "")
	                .replaceAll("\\.", "");
	        if (retorno.length() < 8) {
	            retorno = StringUtils.leftPad(retorno, 8, '0');
	        }
	        retorno = retorno.substring(0, 5) + "\u002D" + retorno.substring(5);
	        return retorno;
	    }

	    public static String formataCEP(Long numero) {
	        if (numero == null) {
	            return "";
	        }
	        return formataCEP(Long.toString(numero));
	    }

}
