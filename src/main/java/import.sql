INSERT INTO autore(nome, cognome, nazionalità, data_nascita, data_morte)
VALUES ('Pablo', 'Picasso', 'Spagnolo', ('2003-1-1'::timestamp), ('2003-1-1'::timestamp));
INSERT INTO quadro (titolo, anno, tecnica, dimensione, autore_id)
VALUES ('Guernica', 180000, 'olio su tela', '100x120', 1);