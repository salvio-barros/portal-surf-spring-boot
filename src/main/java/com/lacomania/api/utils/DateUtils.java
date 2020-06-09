package com.lacomania.api.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public final class DateUtils {

    public static final int CST_NUMERO_24 = 24;
    public static final int CST_ANO_1970 = 1970;
    public static final int CST_24_INT_PRIMITIVO = 24;
    public static final int CST_60_INT = 60;
    public static final long CST_60_LONG = 60L;
    public static final int CST_1000_INT = 1000;
    public static final double CST_MES_EM_MILISEGUNDOS = 2592000000f;

    public static final String CST_STRING_DD_MM_YYYY = "dd/MM/yyyy";
    public static final String CST_STRING_DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";
    public static final String CST_FORMATO_DATA_DD_MM = "dd/MM";
    public static final String CST_PARAM_DATA_ATUAL = "data.atual";
    public static final String FORMATO_MOTOR_PROCESSOS = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String CST_ERRO_0050 = "erro.0050";
    protected static final String[] MESES = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
            "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };

    @Autowired
    private static Logger log = Logger.getLogger(DateUtils.class);

    private DateUtils() {
    }

    public static String format(Date date, String format) {
        SimpleDateFormat dt = new SimpleDateFormat(format);
        return dt.format(date);
    }

    /**
     * Cria um array com os meses de duração do ciclo de avaliação.
     * 
     * @param maximaDuracao A duração do ciclo de avaliação.
     * @return O array de inteiros com os meses de duração como elementos.
     */
    public static int[] calcularMesesDuracaoCicloAvaliacao(int maximaDuracao) {

        int[] x = new int[maximaDuracao + 1];
        int i = 1;
        x[0] = 0;
        while (i <= maximaDuracao) {
            x[i] = i;
            i++;
        }
        return x;
    }

    /**
     * @param d1 uma data a ser compararada
     * @param d2 outra data a ser compararada
     * @return true se as datas representam a mesma data em (ano,mês,dia), false
     *         caso contrário
     */
    public static boolean isMesmaData(Date d1, Date d2) {
        if (d1 == null || d2 == null) {
            return false;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(d1);

        Calendar otherCal = Calendar.getInstance();
        otherCal.setTime(d2);

        /* Uma data é igual a outra se ela... */
        return cal.get(Calendar.YEAR) == otherCal.get(Calendar.YEAR) /* for do mesmo ano. */
                && cal.get(Calendar.MONTH) == otherCal.get(Calendar.MONTH) /* for do mesmo mês. */
                && cal.get(Calendar.DAY_OF_MONTH) == otherCal.get(Calendar.DAY_OF_MONTH); /*
                                                                                           * for do mesmo dia.
                                                                                           */
    }

    /**
     * @param data1 Uma data a ser comparada
     * @param data2 outra data a ser comparada
     * @return true se data1 é menor que data2, false caso contrário
     */
    public static Boolean menorQue(Date data1, Date data2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(data1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(data2);

        return cal1.before(cal2);
    }

    /**
     * Método que verificar se a data 1 é menor ou igual a data 2.
     * 
     * @param data1
     * @param data2
     * @return true se data1 for menor ou igual a data2.
     */
    public static boolean menorOuIgual(Date data1, Date data2) {
        return menorQue(data1, data2) || isMesmaData(data1, data2);
    }

    /**
     * @param data1 Uma data a ser comparada
     * @param data2 outra data a ser comparada
     * @return true se data1 é maior que data2, false caso contrário
     */
    public static Boolean maiorQue(Date data1, Date data2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(data1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(data2);

        return cal1.after(cal2);
    }

    /**
     * Método que verificar se a data 1 é maior ou igual a data 2.
     * 
     * @param data1
     * @param data2
     * @return true se data1 for maior ou igual a data2.
     */
    public static boolean maiorOuIgual(Date data1, Date data2) {
        return maiorQue(data1, data2) || isMesmaData(data1, data2);
    }

    /**
     * Método que verifica se a data 1 está entre a data2 e a data 3.
     * 
     * @param data1
     * @param data2
     * @param data3
     * @return true se data1 estiver entre a data2 e data3.
     */
    public static boolean entre(Date data1, Date data2, Date data3) {
        boolean retorno = false;
        if (DateUtils.maiorOuIgual(data1, data2) && DateUtils.menorOuIgual(data1, data3)) {
            retorno = true;
        }
        return retorno;
    }

}