%%%% 5 - Árbol genealógico %%%%

%%% pred

padre(enrique7, enrique8).
padre(enrique7, arturo).
padre(enrique7, margarita).
padre(enrique8, maria).
padre(enrique8, isabel).
padre(enrique8, eduardo).

padre(edmundo, enrique7).

madre(catalina, maria).
madre(ana, isabel).
madre(juana, eduardo).

madre(isabelDeYork, enrique7).

%%% rel

progenitor(P, H):-
    padre(P, H);
    madre(P, H).

antepasado(A, P):-
    progenitor(As, P),
    antepasado(A, As).

antepasado(A, P):-
    progenitor(A, P).

abuelo_a(A, P):-
    progenitor(A, Pp),
    progenitor(Pp, P).

hermano_a(P1, P2):-
    progenitor(Pp, P1),
    progenitor(Pp, P2),
    P1 \= P2.
