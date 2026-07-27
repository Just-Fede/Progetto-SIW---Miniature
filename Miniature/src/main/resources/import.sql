INSERT INTO utente (id, bio, url_foto_profilo, data_registrazione) VALUES (999, 'Appassionato di miniature Warhammer da 10 anni', '/img/fotoProfilo/default.jpg', '2024-01-15');
INSERT INTO utente (id, bio, url_foto_profilo, data_registrazione) VALUES (998, 'Pittore hobbista, specializzato in Age of Sigmar', '/img/fotoProfilo/default.jpg', '2024-03-20');
INSERT INTO utente (id, bio, url_foto_profilo, data_registrazione) VALUES (997, 'Veterano di Warhammer 40K, collezionista dal 2005', '/img/fotoProfilo/default.jpg', '2024-06-01');
INSERT INTO credenziali (id, username, email, password, role, utente_id) VALUES (999, 'mario_w40k', 'mario@example.com', '$2a$10$7QxYhs3NNqbXSPWdU8O1re3PBT2DpJxBdSgXYFBJ7l9qAK0z3gWUi', 'USER', 999);
INSERT INTO credenziali (id, username, email, password, role, utente_id) VALUES (998, 'giulia_sigmar', 'giulia@example.com', '$2a$10$7QxYhs3NNqbXSPWdU8O1re3PBT2DpJxBdSgXYFBJ7l9qAK0z3gWUi', 'USER', 998);
INSERT INTO credenziali (id, username, email, password, role, utente_id) VALUES (997, 'admin', 'admin@miniatureworld.it', '$2a$10$7QxYhs3NNqbXSPWdU8O1re3PBT2DpJxBdSgXYFBJ7l9qAK0z3gWUi', 'ADMIN', 997);
INSERT INTO utente (id, bio, url_foto_profilo, data_registrazione) VALUES (996, 'Collezionista di Space Marines della prima ora, amo i mezzi pesanti e le armature massicce.', '/img/fotoProfilo/default.jpg', '2024-08-12');
INSERT INTO utente (id, bio, url_foto_profilo, data_registrazione) VALUES (995, 'Speed Freeks nel cuore! Se non fa casino e non va veloce, non e un vero veicolo Orko.', '/img/fotoProfilo/default.jpg', '2025-02-05');
INSERT INTO utente (id, bio, url_foto_profilo, data_registrazione) VALUES (994, 'Giocatore competitivo di Catachan e fanatico delle storie dell Astra Militarum.', '/img/fotoProfilo/default.jpg', '2025-05-20');
INSERT INTO utente (id, bio, url_foto_profilo, data_registrazione) VALUES (993, 'La Mente Alveare mi guida. Pittore specializzato in schemi di colore biologici ed effetti speciali lucidi.', '/img/fotoProfilo/default.jpg', '2025-11-11');
INSERT INTO credenziali (id, username, email, password, role, utente_id) VALUES (996, 'luca_gravis', 'luca@example.com', '$2a$10$7QxYhs3NNqbXSPWdU8O1re3PBT2DpJxBdSgXYFBJ7l9qAK0z3gWUi', 'USER', 996);
INSERT INTO credenziali (id, username, email, password, role, utente_id) VALUES (995, 'khorne_buggy', 'khorne@example.com', '$2a$10$7QxYhs3NNqbXSPWdU8O1re3PBT2DpJxBdSgXYFBJ7l9qAK0z3gWUi', 'USER', 995);
INSERT INTO credenziali (id, username, email, password, role, utente_id) VALUES (994, 'sly_fan', 'slyfan@example.com', '$2a$10$7QxYhs3NNqbXSPWdU8O1re3PBT2DpJxBdSgXYFBJ7l9qAK0z3gWUi', 'USER', 994);
INSERT INTO credenziali (id, username, email, password, role, utente_id) VALUES (993, 'hive_mind93', 'hive@example.com', '$2a$10$7QxYhs3NNqbXSPWdU8O1re3PBT2DpJxBdSgXYFBJ7l9qAK0z3gWUi', 'USER', 993);
--Prodotti Originali--
INSERT INTO prodotto_originale (nome, descrizione, categoria, store_url, immagine_url) VALUES ('Stompa', 'Il Stompa e un gigantesco mech da guerra Orko, un colosso di acciaio arrugginito. Porta devastazione sul campo di battaglia con cannoni e klaw gigantesche.', 'Warhammer 40K', 'https://www.warhammer.com/en-GB/shop/Ork-Stompa', 'https://www.warhammer.com/app/resources/catalog/product/920x950/99120103021_StompaNEW01.jpg?fm=webp&w=892&h=920');
INSERT INTO prodotto_originale (nome, descrizione, categoria, store_url, immagine_url) VALUES ('Soulblight Gravelords - Evocazione', 'Set esclusivo Warhammer+ dedicato ai Soulblight Gravelords, i signori vampirici. Include miniature di non morti evocati dal potere oscuro dei vampiri.', 'Age of Sigmar', 'https://www.warhammer.com/en-GB/shop/warhammer-plus-soulblight-gravelords-the-summons-2025-year-5', 'https://www.warhammer.com/app/resources/catalog/product/920x950/99120207203_WarhammerPlusSoulblightSummons1.jpg?fm=webp&w=892&h=920');
INSERT INTO prodotto_originale (nome, descrizione, categoria, store_url, immagine_url) VALUES ('Capitano in Armatura Gravis', 'I Capitani degli Space Marines che indossano l armatura Gravis sono i comandanti piu risoluti e corazzati del capitolo. Capaci di avanzare sotto il fuoco nemico piu pesante, guidano la carica con spade potenziose e guanti d arme Bolt.', 'Warhammer 40K', 'https://www.warhammer.com/en-GB/shop/space-marines-captain-in-gravis-armour-2022', 'https://www.warhammer.com/app/resources/catalog/product/920x950/99070101077_SMCPTGravisArmourLead.jpg?fm=webp&w=892&h=920');
INSERT INTO prodotto_originale (nome, descrizione, categoria, store_url, immagine_url) VALUES ('Commissario Astra Militarum', 'Il Commissario e il simbolo dell autorita e della disciplina ferrea nell Astra Militarum. Con il cappello alto e il soprabito imperiale ispira terrore nei nemici.', 'Warhammer 40K', 'https://www.warhammer.com/en-GB/shop/astra-militarum-commissar-2023', 'https://www.warhammer.com/app/resources/catalog/product/920x950/99120105099_AMCommissar1.jpg?fm=webp&w=892&h=920');
INSERT INTO prodotto_originale (nome, descrizione, categoria, store_url, immagine_url) VALUES ('Space Marines Rhino', 'Il Rhino e il veicolo di trasporto truppe piu utilizzato dagli Space Marines. Corazzato, affidabile e armato con requiem binati, e progettato per consegnare le squadre d assalto direttamente nel cuore della battaglia.', 'Warhammer 40K', 'https://www.warhammer.com/en-GB/shop/Space-Marines-Rhino-2020', 'https://www.warhammer.com/app/resources/catalog/product/920x950/99120101063_SpaceMarineRhinoNEW01.jpg?fm=webp&w=892&h=920');
INSERT INTO prodotto_originale (nome, descrizione, categoria, store_url, immagine_url) VALUES ('Orks Rukkatrukk Squigbuggy', 'Un velocissimo veicolo d assalto degli Orki progettato per seminare il panico tra le linee nemiche lanciando Squig famelici e cariche esplosive a corto raggio.', 'Warhammer 40K', 'https://www.warhammer.com/en-GB/shop/Orks-Rukkatrukk-Squigbuggy-2018', 'https://www.warhammer.com/app/resources/catalog/product/920x950/99120103066_RukkatrukkSquigbuggy01.jpg?fm=webp&w=892&h=920');
INSERT INTO prodotto_originale (nome, descrizione, categoria, store_url, immagine_url) VALUES ('Astra Militarum Sly Marbo', 'Sly Marbo e un leggendario soldato della Guardia Imperiale, una macchina da guerra solitaria capace di infiltrarsi dietro le linee nemiche ed eliminare interi reggimenti usando solo un coltello e una pistola da ferma.', 'Warhammer 40K', 'https://www.warhammer.com/en-GB/shop/Astra-Militarum-Sly-Marbo-2018', 'https://www.warhammer.com/app/resources/catalog/product/920x950/99810105030_SlyMarbo01.jpg?fm=webp&w=892&h=920');
INSERT INTO prodotto_originale (nome, descrizione, categoria, store_url, immagine_url) VALUES ('Tyranids Haruspex', 'L Haruspex e una mostruosita dei Tiranni creata al solo scopo di consumare materia organica a una velocita spaventosa. Cattura le prede con la sua lingua tentacolare e le trita all istante nella sua enorme fauci acuminate.', 'Warhammer 40K', 'https://www.warhammer.com/en-GB/shop/Haruspex', 'https://www.warhammer.com/app/resources/catalog/product/920x950/99120106026_Haruspex01.jpg?fm=webp&w=892&h=920');



--Post--
INSERT INTO post (titolo, descrizione, data, utente_id, prodotto_originale_id) VALUES ('Il mio Stompa finalmente completato!', 'Dopo 3 mesi di lavoro ho finalmente finito di dipingere questo colosso. Ho usato la tecnica del chipping con la spugna per simulare il metallo usurato tipico degli Orki. Base verde Waaagh, highlights con Skarsnik Green e wash con Agrax Earthshade.', '2026-06-10', 999, 1);
INSERT INTO post (titolo, descrizione, data, utente_id, prodotto_originale_id) VALUES ('Vampiri evocati - Schema colori gotico', 'Ho dipinto i miei Soulblight con una palette fredda: pelle pallida con Corax White e Druchii Violet, mantelli in Naggaroth Night con highlight Xereus Purple. Le fiamme magiche in turchese per un effetto spettrale inquietante!', '2026-06-12', 998, 2);
INSERT INTO post (titolo, descrizione, data, utente_id, prodotto_originale_id) VALUES ('Commissario Ciaparelli - Guardiano del mio reggimento', 'Presentazione del Commissario della mia armata Astra Militarum. Dipinto con divisa in Abaddon Black con dettagli in Retributor Armour. La cappa rossa e Mephiston Red con wash Carroburg Crimson.', '2026-06-14', 997, 4);
INSERT INTO post (titolo, descrizione, data, utente_id, prodotto_originale_id) VALUES ('Capitano Gravis ultimato!', 'Ho impiegato una settimana solo per le sfumature blu dell armatura del mio Capitano. Finitura opaca fantastica.', '2026-06-15', 996, 3);
INSERT INTO post (titolo, descrizione, data, utente_id, prodotto_originale_id) VALUES ('Il mio primo Rhino da trasporto', 'Veicolo classico ma immortale. Ho aggiunto un po di fango artificiale sui cingoli per dare l idea del movimento.', '2026-06-16', 996, 5);
INSERT INTO post (titolo, descrizione, data, utente_id, prodotto_originale_id) VALUES ('Squigbuggy pronto a fare casino!', 'Questo modello Orko e pieno di dettagli folli! Ho dipinto gli Squig di un rosso acceso per farli risaltare.', '2026-06-17', 995, 6);
INSERT INTO post (titolo, descrizione, data, utente_id, prodotto_originale_id) VALUES ('Sly Marbo, un vero incubo da dipingere', 'Dettagli minuscoli sui muscoli e sul volto, ma Sly Marbo merita questo e altro. Pronto per la giungla!', '2026-06-18', 994, 7);
INSERT INTO post (titolo, descrizione, data, utente_id, prodotto_originale_id) VALUES ('Haruspex della Flotta Alveare Leviathan', 'Schema di colore classico viola e bianco. Ho aggiunto del gel lucido trasparente sulle fauci per l effetto bava.', '2026-06-19', 993, 8);
INSERT INTO post (titolo, descrizione, data, utente_id, prodotto_originale_id) VALUES ('Il mio Sly Marbo stile mimetica urbana', 'Ho voluto distaccarmi dal classico schema da giungla per dare a Marbo un look da infiltrazione cittadina. Tonalita di grigio Codex, lavaggio leggero con Nuln Oil e dettagli della lama in acciaio graffiato.', '2026-06-19', 999, 7);
--Immagini--
INSERT INTO immagine (url, copertina, post_id) VALUES ('Stompas.jpg', true, 1);
INSERT INTO immagine (url, copertina, post_id) VALUES ('thesummons.jpg', true, 2);
INSERT INTO immagine (url, copertina, post_id) VALUES ('CommissarGraves.jpg', true, 3);
INSERT INTO immagine (url, copertina, post_id) VALUES ('capitangravis.jpg', true, 4);
INSERT INTO immagine (url, copertina, post_id) VALUES ('rhino.jpg', true, 5);
INSERT INTO immagine (url, copertina, post_id) VALUES ('squigbuggy.jpg', true, 6);
INSERT INTO immagine (url, copertina, post_id) VALUES ('marbo.jpg', true, 7);
INSERT INTO immagine (url, copertina, post_id) VALUES ('haruspex.jpg', true, 8);
INSERT INTO immagine (url, copertina, post_id) VALUES ('marbo1.jpg', true, 9);
--Nuovi Utenti--
INSERT INTO utente (id, bio, url_foto_profilo, data_registrazione) VALUES (992, 'Appassionato di terreni e diorami, creo basi scenografiche uniche.', '/img/fotoProfilo/default.jpg', '2025-01-10');
INSERT INTO utente (id, bio, url_foto_profilo, data_registrazione) VALUES (991, 'Fan sfegatato dei Necron, amo la pittura NMM (non-metallic metal).', '/img/fotoProfilo/default.jpg', '2025-03-15');
INSERT INTO utente (id, bio, url_foto_profilo, data_registrazione) VALUES (990, 'Gioco Kill Team da 2 anni, prediligo le fazioni Xenos.', '/img/fotoProfilo/default.jpg', '2025-04-22');
INSERT INTO utente (id, bio, url_foto_profilo, data_registrazione) VALUES (989, 'Modellista esperto, converto e scultureggio miniature da 15 anni.', '/img/fotoProfilo/default.jpg', '2024-11-05');
INSERT INTO utente (id, bio, url_foto_profilo, data_registrazione) VALUES (988, 'Nuovo nel hobby, sto ancora imparando le basi della pittura.', '/img/fotoProfilo/default.jpg', '2026-01-08');
INSERT INTO utente (id, bio, url_foto_profilo, data_registrazione) VALUES (987, 'Organizzatore di tornei locali, appassionato di lore Warhammer.', '/img/fotoProfilo/default.jpg', '2025-08-30');

INSERT INTO credenziali (id, username, email, password, role, utente_id) VALUES (992, 'terra_diorama', 'terra@example.com', '$2a$10$7QxYhs3NNqbXSPWdU8O1re3PBT2DpJxBdSgXYFBJ7l9qAK0z3gWUi', 'USER', 992);
INSERT INTO credenziali (id, username, email, password, role, utente_id) VALUES (991, 'necron_nmm', 'necron@example.com', '$2a$10$7QxYhs3NNqbXSPWdU8O1re3PBT2DpJxBdSgXYFBJ7l9qAK0z3gWUi', 'USER', 991);
INSERT INTO credenziali (id, username, email, password, role, utente_id) VALUES (990, 'killteam_xenos', 'killteam@example.com', '$2a$10$7QxYhs3NNqbXSPWdU8O1re3PBT2DpJxBdSgXYFBJ7l9qAK0z3gWUi', 'USER', 990);
INSERT INTO credenziali (id, username, email, password, role, utente_id) VALUES (989, 'scultore_15anni', 'scultore@example.com', '$2a$10$7QxYhs3NNqbXSPWdU8O1re3PBT2DpJxBdSgXYFBJ7l9qAK0z3gWUi', 'USER', 989);
INSERT INTO credenziali (id, username, email, password, role, utente_id) VALUES (988, 'newbie_painter', 'newbie@example.com', '$2a$10$7QxYhs3NNqbXSPWdU8O1re3PBT2DpJxBdSgXYFBJ7l9qAK0z3gWUi', 'USER', 988);
INSERT INTO credenziali (id, username, email, password, role, utente_id) VALUES (987, 'torneo_organizer', 'torneo@example.com', '$2a$10$7QxYhs3NNqbXSPWdU8O1re3PBT2DpJxBdSgXYFBJ7l9qAK0z3gWUi', 'USER', 987);

--Commenti (2 per post, id post 1-9)--
-- Nota: Commento usa GenerationType.AUTO, che non genera un default a livello di colonna:
-- servono id espliciti anche qui, come gia' avviene per utente e credenziali.
INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9001, 'Lavoro incredibile', 'Il chipping sullo Stompa e fatto benissimo, sembra davvero arrugginito e vissuto sul campo di battaglia!', '2026-06-11', 1, 998);
INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9002, 'Che mostro', 'Dimensioni pazzesche, complimenti per la pazienza nel dipingere una miniatura cosi grande.', '2026-06-11', 1, 991);

INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9003, 'Palette perfetta', 'Il contrasto tra la pelle pallida e il Naggaroth Night e stupendo, molto gotico.', '2026-06-13', 2, 997);
INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9004, 'Fiamme spettrali top', 'L effetto turchese sulle fiamme magiche da davvero un tocco soprannaturale, bravissima!', '2026-06-13', 2, 989);

INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9005, 'Divisa impeccabile', 'Il nero opaco con i dettagli in Retributor Armour crea un contrasto perfetto.', '2026-06-15', 3, 996);
INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9006, 'Fa paura solo a vederlo', 'La cappa rossa con il wash Carroburg Crimson e semplicemente perfetta, complimenti Commissario!', '2026-06-15', 3, 987);

INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9007, 'Sfumature notevoli', 'Le sfumature blu sono lisce e uniformi, si vede il lavoro certosino dietro.', '2026-06-16', 4, 993);
INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9008, 'Finitura da manuale', 'La finitura opaca dona un aspetto davvero professionale all armatura Gravis.', '2026-06-16', 4, 990);

INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9009, 'Classico intramontabile', 'Il fango sui cingoli e un dettaglio che fa la differenza, ottimo lavoro sul Rhino.', '2026-06-17', 5, 995);
INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9010, 'Weathering superbo', 'Anche io uso questa tecnica per i veicoli, il risultato qui e davvero convincente.', '2026-06-17', 5, 992);

INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9011, 'Squig fantastici', 'Il rosso acceso degli Squig risalta benissimo sul resto del veicolo, ottima scelta cromatica.', '2026-06-18', 6, 994);
INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9012, 'Follia Orka al massimo', 'Modello pieno di dettagli, hai reso benissimo il caos tipico degli Orki.', '2026-06-18', 6, 988);

INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9013, 'Dettagli minuscoli notevoli', 'I muscoli e il volto sono resi con una precisione incredibile, complimenti per la pazienza.', '2026-06-19', 7, 999);
INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9014, 'Pronto per la giungla', 'Un lavoro certosino su una miniatura cosi piccola e dettagliata, davvero notevole.', '2026-06-19', 7, 991);

INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9015, 'Effetto bava riuscitissimo', 'Il gel lucido sulle fauci rende benissimo l idea della bava, ottima trovata.', '2026-06-20', 8, 997);
INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9016, 'Viola e bianco top', 'Schema di colore classico ma eseguito alla perfezione, complimenti per l Haruspex.', '2026-06-20', 8, 989);

INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9017, 'Idea originale', 'Mi piace molto l idea di uno schema urbano per Marbo, cambia dal solito verde giungla.', '2026-06-20', 9, 990);
INSERT INTO commento (id, titolo, testo, data, post_id, utente_id) VALUES (9018, 'Lama molto realistica', 'Il graffiato sulla lama d acciaio e un dettaglio che aggiunge tantissimo realismo.', '2026-06-20', 9, 987);

--UpVote (piu voti per post, utenti vari)--
INSERT INTO up_vote (post_id, utente_id) VALUES (1, 998);
INSERT INTO up_vote (post_id, utente_id) VALUES (1, 997);
INSERT INTO up_vote (post_id, utente_id) VALUES (1, 991);
INSERT INTO up_vote (post_id, utente_id) VALUES (2, 999);
INSERT INTO up_vote (post_id, utente_id) VALUES (2, 996);
INSERT INTO up_vote (post_id, utente_id) VALUES (2, 989);
INSERT INTO up_vote (post_id, utente_id) VALUES (3, 998);
INSERT INTO up_vote (post_id, utente_id) VALUES (3, 995);
INSERT INTO up_vote (post_id, utente_id) VALUES (3, 987);
INSERT INTO up_vote (post_id, utente_id) VALUES (4, 999);
INSERT INTO up_vote (post_id, utente_id) VALUES (4, 993);
INSERT INTO up_vote (post_id, utente_id) VALUES (4, 990);
INSERT INTO up_vote (post_id, utente_id) VALUES (5, 997);
INSERT INTO up_vote (post_id, utente_id) VALUES (5, 992);
INSERT INTO up_vote (post_id, utente_id) VALUES (6, 999);
INSERT INTO up_vote (post_id, utente_id) VALUES (6, 994);
INSERT INTO up_vote (post_id, utente_id) VALUES (6, 988);
INSERT INTO up_vote (post_id, utente_id) VALUES (7, 998);
INSERT INTO up_vote (post_id, utente_id) VALUES (7, 991);
INSERT INTO up_vote (post_id, utente_id) VALUES (8, 999);
INSERT INTO up_vote (post_id, utente_id) VALUES (8, 989);
INSERT INTO up_vote (post_id, utente_id) VALUES (9, 997);
INSERT INTO up_vote (post_id, utente_id) VALUES (9, 990);

--Aggiornamento sequenze (eseguito per ultimo, considera anche i nuovi id)--
SELECT setval(pg_get_serial_sequence('utente', 'id'), COALESCE(max(id), 1)) FROM utente;
SELECT setval(pg_get_serial_sequence('credenziali', 'id'), COALESCE(max(id), 1)) FROM credenziali;