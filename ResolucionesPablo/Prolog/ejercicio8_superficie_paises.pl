%%%% EJERCICIO 8 - PAISES Y SUPERFICIES %%%%
%%%%%% version grupo del mundial

%%%% superficies en millones de km2
pais_sup(argentina, 2.78).
pais_sup(mexico, 1.96).
pais_sup(arabia, 2.15).
pais_sup(polonia, 0.32).

%%%% reglas
no_mayores(S):-
    pais_sup(_, S),
    pais_sup(_, S1),
    S < S1.
mayor(S):-
    pais_sup(_, S),
    \+ no_mayores(S), !.
mayor_pais(P, S):-
    pais_sup(P, S),
    mayor(S).

mejor_pais(argentina). % (?)