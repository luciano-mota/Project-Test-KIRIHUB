package com.project.kirihub.utils;

import java.text.DecimalFormat;

public class FormatDoubleCasasDecimais {
	
	public static String format(Double valor) {
		DecimalFormat formatter = new DecimalFormat("#0.00");
		return formatter.format(valor);
	}
}
