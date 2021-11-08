INSERT INTO TB_STUDENT (COURSE, NAME, PERIOD, REGISTRATION) VALUES ('LICENCIATURA PLENA EM FÍSICA', 'FELIPE AMORIM', 5, 94586);
INSERT INTO TB_STUDENT (COURSE, NAME, PERIOD, REGISTRATION) VALUES ('LICENCIATURA EM MATEMÁTICA', 'JOSÉ DE ALMEIDA DA SILVA', 3, 95712);
INSERT INTO TB_STUDENT (COURSE, NAME, PERIOD, REGISTRATION) VALUES ('LICENCIATURA EM MATEMÁTICA', 'FERNANDO LISBOA DE CASTRO', 7, 75421);
INSERT INTO TB_STUDENT (COURSE, NAME, PERIOD, REGISTRATION) VALUES ('MEDICINA', 'KENDRA GOLÇALVES', 2, 75410);
INSERT INTO TB_STUDENT (COURSE, NAME, PERIOD, REGISTRATION) VALUES ('ENGENHARIA MECÂNICA', 'ENANDRO FIGUEROA', 6, 74256);
INSERT INTO TB_STUDENT (COURSE, NAME, PERIOD, REGISTRATION) VALUES ('BACHARELADO EM CIÊNCIAS BIOLOGICAS', 'AVELINO KENNIDE', 4, 14221);


INSERT INTO tb_authors (first_name, last_name) VALUES ('Paul', 'Deitel');
INSERT INTO tb_authors (first_name, last_name) VALUES ('Harvey', 'Deitel');
INSERT INTO tb_authors (first_name, last_name) VALUES ('Abbey', 'Deitel');
INSERT INTO tb_authors (first_name, last_name) VALUES ('Dan', 'Quirk');
INSERT INTO tb_authors (first_name, last_name) VALUES ('Michael', 'Morgano');


INSERT INTO tb_books (isbn, name, number_edition, copyright) VALUES ('0132121360', 'Android for Programmers: An App-Driven Approach', 1, 2012);
INSERT INTO tb_books (isbn, name, number_edition, copyright) VALUES ('0132151006', 'Internet & World Wide Web How to Program', 5, 2012);
INSERT INTO tb_books (isbn, name, number_edition, copyright) VALUES ('0132575655', 'Java How to Program, Late Objects Version', 10, 2015);
INSERT INTO tb_books (isbn, name, number_edition, copyright) VALUES ('0132990440', 'C How to Program', 7, 2013);
INSERT INTO tb_books (isbn, name, number_edition, copyright) VALUES ('0132990601', 'Simply Visual Basic 2010', 4, 2013);
INSERT INTO tb_books (isbn, name, number_edition, copyright) VALUES ('0133378713', 'C++ How to Program', 9, 2014);
INSERT INTO tb_books (isbn, name, number_edition, copyright) VALUES ('0133379337', 'Visual C# 2012 How to Program', 5, 2014);
INSERT INTO tb_books (isbn, name, number_edition, copyright) VALUES ('0133406954', 'Visual Basic 2012 How to Program ', 6, 2014);
INSERT INTO tb_books (isbn, name, number_edition, copyright) VALUES ('0133570924', 'Android How to Program', 2, 2015);
INSERT INTO tb_books (isbn, name, number_edition, copyright) VALUES ('0133807800', 'Java How to Program', 10, 2015);
INSERT INTO tb_books (isbn, name, number_edition, copyright) VALUES ('0136151574', 'Visual C++ 2008 How to Program', 2, 2008);


INSERT INTO tb_books_authors (author_id, isbn) VALUES (1, '0132151006');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (2, '0132151006');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (3, '0132151006');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (1, '0133807800');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (2, '0133807800');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (1, '0132575655');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (2, '0132575655');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (2, '0132990440');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (1, '0132990440');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (1, '0132990601');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (2, '0132990601');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (3, '0132990601');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (1, '0133406954');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (2, '0133406954');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (3, '0133406954');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (1, '0133379337');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (2, '0133379337');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (1, '0136151574');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (2, '0136151574');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (4, '0136151574');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (1, '0133378713');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (2, '0133378713');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (1, '0132121360');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (2, '0132121360');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (3, '0132121360');
INSERT INTO tb_books_authors (author_id, isbn) VALUES (5, '0132121360');

