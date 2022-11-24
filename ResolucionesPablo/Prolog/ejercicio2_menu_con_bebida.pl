%%%% EJERCICIO 2 - MENÚ CON BEBIDA %%%%

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

bebida(vino).
bebida(cerveza).
bebida(agua).
%fin clauses

%%% REGLAS %%%

principal(P):-
    carne(P);
    pescado(P).

%%% A 
menu(En, Pp, Po, Be):-
    entrada(En),
    principal(Pp),
    postre(Po),
    bebida(Be).

%%% B
con_consome(consomé, Pp, Po, Be):-
    menu(consomé, Pp, Po, Be).

%%% C
sin_flan(En, Pp, Po, Be):-
    menu(En, Pp, Po, Be),
    Po \= flan.






