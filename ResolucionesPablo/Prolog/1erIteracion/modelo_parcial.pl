%%% Modelo 2do Parcial %%%

reporta_a(juan, pedro).
reporta_a(carlos, juan).
reporta_a(jose, carlos).

recibe_ordenes_de(Emp, Emp):- true.

recibe_ordenes_de(Emp, Sup):-
    reporta_a(Emp, SupDir),
    recibe_ordenes_de(SupDir, Sup).