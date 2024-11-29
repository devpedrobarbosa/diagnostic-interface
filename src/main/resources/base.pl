% Gripe
causa(febre, gripe).
causa(tosse, gripe).
causa(dor_de_garganta, gripe).
causa(dor_de_cabeca, gripe).
causa(coriza, gripe).
causa(fadiga, gripe).

% Dengue
causa(febre, dengue).
causa(dor_no_corpo, dengue).
causa(dor_de_cabeca, dengue).
causa(erupcoes_na_pele, dengue).
causa(nausea, dengue).
causa(vomito, dengue).

% Pneumonia
causa(febre, pneumonia).
causa(tosse, pneumonia).
causa(dor_no_peito, pneumonia).
causa(falta_de_ar, pneumonia).
causa(calafrios, pneumonia).
causa(fadiga, pneumonia).

% COVID-19
causa(febre, covid19).
causa(tosse_seca, covid19).
causa(fadiga, covid19).
causa(perda_de_olfato, covid19).
causa(perda_de_paladar, covid19).
causa(dor_no_corpo, covid19).

% Alergias
causa(coceira, alergia).
causa(erupcoes_na_pele, alergia).
causa(espirros, alergia).
causa(olhos_vermelhos, alergia).
causa(coriza, alergia).

% Infeccao Urinaria
causa(febre, infeccao_urinaria).
causa(dor_ao_urinar, infeccao_urinaria).
causa(dor_abdominal, infeccao_urinaria).
causa(urina_escura, infeccao_urinaria).
causa(urgencia_para_urinar, infeccao_urinaria).

% Gastrite
causa(dor_abdominal, gastrite).
causa(azia, gastrite).
causa(queimacao, gastrite).
causa(nausea, gastrite).
causa(vomito, gastrite).

% Ataque Cardiaco
causa(dor_no_peito, ataque_cardiaco).
causa(falta_de_ar, ataque_cardiaco).
causa(sudorese_excessiva, ataque_cardiaco).
causa(dor_no_braco_esquerdo, ataque_cardiaco).
causa(nausea, ataque_cardiaco).
causa(palpitacoes, ataque_cardiaco).

% Artrite
causa(dor_nas_articulacoes, artrite).
causa(rigidez_matinal, artrite).
causa(inflamacao_articular, artrite).
causa(dor_no_joelho, artrite).

% Enxaqueca
causa(dor_de_cabeca, enxaqueca).
causa(sensibilidade_a_luz, enxaqueca).
causa(sensibilidade_a_sons, enxaqueca).
causa(nausea, enxaqueca).
causa(vomito, enxaqueca).

% Ansiedade
causa(palpitacoes, ansiedade).
causa(falta_de_ar, ansiedade).
causa(sudorese_excessiva, ansiedade).
causa(tremores, ansiedade).
causa(insonia, ansiedade).
causa(fadiga, ansiedade).

% Insonia
causa(dificuldade_para_dormir, insonia).
causa(acordar_durante_a_noite, insonia).
causa(fadiga, insonia).
causa(dor_de_cabeca, insonia).
causa(dificuldade_de_concentracao, insonia).

% Depressao
causa(humor_deprimido, depressao).
causa(perda_de_interesse, depressao).
causa(insonia, depressao).
causa(fadiga, depressao).
causa(dificuldade_de_concentracao, depressao).

% Intoxicacao Alimentar
causa(nausea, intoxicacao_alimentar).
causa(vomito, intoxicacao_alimentar).
causa(dor_abdominal, intoxicacao_alimentar).
causa(diarreia, intoxicacao_alimentar).
causa(febre, intoxicacao_alimentar).

% Hepatite
causa(pele_amarelada, hepatite).
causa(olhos_amarelados, hepatite).
causa(dor_abdominal, hepatite).
causa(nausea, hepatite).
causa(fadiga, hepatite).

% Malaria
causa(febre, malaria).
causa(calafrios, malaria).
causa(suor_excessivo, malaria).
causa(dor_de_cabeca, malaria).
causa(dor_no_corpo, malaria).

% Sinusite
causa(dor_de_cabeca, sinusite).
causa(dor_facial, sinusite).
causa(congestao_nasal, sinusite).
causa(coriza, sinusite).
causa(fadiga, sinusite).

% Diabetes
causa(sede_excessiva, diabetes).
causa(muita_fome, diabetes).
causa(perda_de_peso, diabetes).
causa(urinar_frequentemente, diabetes).
causa(fadiga, diabetes).
causa(visao_embacada, diabetes).

% Hipertensao
causa(dor_de_cabeca, hipertensao).
causa(tontura, hipertensao).
causa(nausea, hipertensao).
causa(palpitacoes, hipertensao).
causa(visao_embacada, hipertensao).

% AVC
causa(perda_de_forca, avc).
causa(dormencia, avc).
causa(dificuldade_para_falar, avc).
causa(dificuldade_para_andar, avc).
causa(perda_de_visao, avc).

% Cancer de Pulmao
causa(tosse_persistente, cancer_pulmao).
causa(sangue_no_escarro, cancer_pulmao).
causa(dor_no_peito, cancer_pulmao).
causa(perda_de_peso, cancer_pulmao).
causa(fadiga, cancer_pulmao).

% Apneia_do_Sono
causa(ronco_excessivo, apneia_do_sono).
causa(sonolencia_diurna, apneia_do_sono).
causa(falta_de_ar, apneia_do_sono).
causa(fadiga, apneia_do_sono).
causa(dificuldade_de_concentracao, apneia_do_sono).

% Bronquite
causa(tosse_persistente, bronquite).
causa(producao_de_muco, bronquite).
causa(dor_no_peito, bronquite).
causa(fadiga, bronquite).
causa(falta_de_ar, bronquite).

% Insuficiencia Renal
causa(fadiga, insuficiencia_renal).
causa(inchaco, insuficiencia_renal).
causa(dor_lombar, insuficiencia_renal).
causa(urina_espumosa, insuficiencia_renal).
causa(perda_de_apetite, insuficiencia_renal).

% Meningite
causa(febre, meningite).
causa(dor_de_cabeca, meningite).
causa(rigidez_no_pescoco, meningite).
causa(sensibilidade_a_luz, meningite).
causa(nausea, meningite).

especialista(gripe, clinico_geral).
especialista(dengue, infectologista).
especialista(pneumonia, pneumologista).
especialista(covid19, infectologista).
especialista(alergia, alergologista_imunologista).
especialista(infeccao_urinaria, urologista).
especialista(gastrite, gastroenterologista).
especialista(ataque_cardiaco, cardiologista).
especialista(artrite, reumatologista).
especialista(enxaqueca, neurologista).
especialista(ansiedade, psiquiatra).
especialista(insonia, psiquiatra).
especialista(depressao, psiquiatra).
especialista(intoxicacao_alimentar, gastroenterologista).
especialista(hepatite, hepatologista).
especialista(malaria, infectologista).
especialista(sinusite, otorrinolaringologista).
especialista(diabetes, endocrinologista).
especialista(hipertensao, cardiologista).
especialista(avc, neurologista).
especialista(cancer_pulmao, oncologista).
especialista(apneia_do_sono, otorrinolaringologista).
especialista(bronquite, pneumologista).
especialista(insuficiencia_renal, nefrologista).
especialista(meningite, infectologista).

% Identifica todas as causas possiveis baseadas nos sintomas fornecidos
possivel_causa(Sintomas, Causa) :-
    % Para cada sintoma fornecido, encontra uma causa associada
    findall(C, (member(S, Sintomas), causa(S, C)), Causas),
    sort(Causas, Candidatos),
    % Garante que ao menos uma causa seja encontrada
    member(Causa, Candidatos).

% Diagnostico preciso: conta quantos sintomas coincidem com cada causa
diagnostico_preciso(Sintomas, Causa) :-
    % Para cada sintoma fornecido, encontra a causa associada
    findall(C, (member(S, Sintomas), causa(S, C)), TodasCausas),
    % Agrupa todas as causas encontradas
    sort(TodasCausas, CausasUnicas),
    % Verifica se a causa e uma das possiveis
    member(Causa, CausasUnicas),
    % Verifica se TODOS os sintomas fornecidos estao relacionados a causa
    forall(member(S, Sintomas), causa(S, Causa)).