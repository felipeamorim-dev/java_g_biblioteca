package com.felipesa.g_biblioteca.entities_interface;

import com.felipesa.g_biblioteca.enumtype.StatusEnum;

public interface BookManagerInterface {
	
	void updateAmountBook();
	
	void updateStatusLoan(StatusEnum status);
}
