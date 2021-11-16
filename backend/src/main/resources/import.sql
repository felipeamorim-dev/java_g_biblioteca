INSERT INTO TB_STUDENT (COURSE, NAME, PERIOD, REGISTRATION) VALUES ('LICENCIATURA PLENA EM FÍSICA', 'FELIPE AMORIM', 5, 94586);
INSERT INTO TB_STUDENT (COURSE, NAME, PERIOD, REGISTRATION) VALUES ('LICENCIATURA EM MATEMÁTICA', 'JOSÉ DE ALMEIDA DA SILVA', 3, 95712);
INSERT INTO TB_STUDENT (COURSE, NAME, PERIOD, REGISTRATION) VALUES ('LICENCIATURA EM MATEMÁTICA', 'FERNANDO LISBOA DE CASTRO', 7, 75421);
INSERT INTO TB_STUDENT (COURSE, NAME, PERIOD, REGISTRATION) VALUES ('MEDICINA', 'KENDRA GOLÇALVES', 2, 75410);
INSERT INTO TB_STUDENT (COURSE, NAME, PERIOD, REGISTRATION) VALUES ('ENGENHARIA MECÂNICA', 'ENANDRO FIGUEROA', 6, 74256);
INSERT INTO TB_STUDENT (COURSE, NAME, PERIOD, REGISTRATION) VALUES ('BACHARELADO EM CIÊNCIAS BIOLOGICAS', 'AVELINO KENNIDE', 4, 14221);


INSERT INTO tb_books (isbn, name, number_edition, copyright, author) VALUES ('0132121360', 'Android for Programmers: An App-Driven Approach', 1, 2012, 'Paul, Harvey, Abbey Deitel e Michael Morgano');
INSERT INTO tb_books (isbn, name, number_edition, copyright, author) VALUES ('0132151006', 'Internet & World Wide Web How to Program', 5, 2012, 'Paul, Harvey e Abbey Deitel');
INSERT INTO tb_books (isbn, name, number_edition, copyright, author) VALUES ('0132575655', 'Java How to Program, Late Objects Version', 10, 2015, 'Paul e Harvey Deitel');
INSERT INTO tb_books (isbn, name, number_edition, copyright, author) VALUES ('0132990440', 'C How to Program', 7, 2013, 'Paul e Harvey Deitel');
INSERT INTO tb_books (isbn, name, number_edition, copyright, author) VALUES ('0132990601', 'Simply Visual Basic 2010', 4, 2013, 'Paul e Harvey Deitel');
INSERT INTO tb_books (isbn, name, number_edition, copyright, author) VALUES ('0133378713', 'C++ How to Program', 9, 2014, 'Paul e Harvey Deitel');
INSERT INTO tb_books (isbn, name, number_edition, copyright, author) VALUES ('0133379337', 'Visual C# 2012 How to Program', 5, 2014, 'Paul e Harvey Deitel');
INSERT INTO tb_books (isbn, name, number_edition, copyright, author) VALUES ('0133406954', 'Visual Basic 2012 How to Program ', 6, 2014, 'Abbey e Harvey Deitel');
INSERT INTO tb_books (isbn, name, number_edition, copyright, author) VALUES ('0133570924', 'Android How to Program', 2, 2015, 'Paul, Harvey e Abbey Deitel');
INSERT INTO tb_books (isbn, name, number_edition, copyright, author) VALUES ('0133807800', 'Java How to Program', 10, 2015, 'Paul e Harvey Deitel');
INSERT INTO tb_books (isbn, name, number_edition, copyright, author) VALUES ('0136151574', 'Visual C++ 2008 How to Program', 2, 2008, 'Paul, Harvey Deitel e Dan Quirk');


INSERT INTO tb_section (name) VALUES ('Física');
INSERT INTO tb_section (name) VALUES ('Matemática');
INSERT INTO tb_section (name) VALUES ('Informática');
INSERT INTO tb_section (name) VALUES ('Ciências Biológicas');
INSERT INTO tb_section (name) VALUES ('Medicina');


INSERT INTO tb_book_management (isbn_id, section_id, available_quantity, total_amount) VALUES ('0132151006', 3, 3, 5);
INSERT INTO tb_book_management (isbn_id, section_id, available_quantity, total_amount) VALUES ('0133807800', 3, 9, 10);
INSERT INTO tb_book_management (isbn_id, section_id, available_quantity, total_amount) VALUES ('0132575655', 3, 6, 6);
INSERT INTO tb_book_management (isbn_id, section_id, available_quantity, total_amount) VALUES ('0132990440', 3, 5, 5);
INSERT INTO tb_book_management (isbn_id, section_id, available_quantity, total_amount) VALUES ('0132990601', 3, 5, 5);
INSERT INTO tb_book_management (isbn_id, section_id, available_quantity, total_amount) VALUES ('0133406954', 3, 5, 5);
INSERT INTO tb_book_management (isbn_id, section_id, available_quantity, total_amount) VALUES ('0133379337', 3, 5, 5);
INSERT INTO tb_book_management (isbn_id, section_id, available_quantity, total_amount) VALUES ('0136151574', 3, 5, 5);
INSERT INTO tb_book_management (isbn_id, section_id, available_quantity, total_amount) VALUES ('0133378713', 3, 4, 5);
INSERT INTO tb_book_management (isbn_id, section_id, available_quantity, total_amount) VALUES ('0133570924', 3, 4, 4);
INSERT INTO tb_book_management (isbn_id, section_id, available_quantity, total_amount) VALUES ('0132121360', 3, 4, 4);

INSERT INTO tb_loan(status, student_id) VALUES ('BORROWED', 1)
INSERT INTO tb_loan(status, student_id) VALUES ('BORROWED', 2)

INSERT INTO tb_book_loan(book_isbn, loan_id, loan_date, return_date) VALUES ('0133807800', 1, '2021-03-05', '2021-04-05');
INSERT INTO tb_book_loan(book_isbn, loan_id, loan_date, return_date) VALUES ('0133378713', 1, '2021-03-05', '2021-03-25');
INSERT INTO tb_book_loan(book_isbn, loan_id, loan_date, return_date) VALUES ('0132151006', 2, '2021-03-05', '2021-03-25');
