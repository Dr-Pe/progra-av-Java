

mostrar_lista([]).
mostrar_lista([X|Y]):- write(X), write(" "), mostrar_lista(Y).

contiene([X|Y], Z):- 
    X==Z; 
    contiene(Y, Z).

largo([], 0).
largo([_|Y], I):-
    largo(Y, Ip), I is Ip + 1.

concatenar([], [], []).
concatenar([], X, X).
concatenar(X, [], X).
concatenar([X|Y], Z, [X|W]):-
    concatenar(Y, Z, W).
