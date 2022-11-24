%%%% EJERCICIO 1 - MENÚ %%%%

%clauses
entrada(paella).
entrada(gazpacho).
entrada(consomé).
carne(filete_de_cerdo).
carne(pollo_asado).
pescado(trucha).
pescado(bacalao).
postre(flan).
postre(helado).
postre(pastel).
%fin clauses

%%% REGLAS %%%

principal(P):-
    carne(P);
    pescado(P).

%%% A 
menu(En, Pp, Po):-
    entrada(En),
    principal(Pp),
    postre(Po).

%%% B
con_consome(consomé, Pp, Po):-
    menu(consomé, Pp, Po).

%%% C
sin_flan(En, Pp, Po):-
    menu(En, Pp, Po),
    Po \= flan.






