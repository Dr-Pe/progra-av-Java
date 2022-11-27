%%%% EJERCICIO 4bis v2 - PROMOCIONASTE II %%%%
%
%%%% notas
parcial1(ana,7).
parcial1(juan,4).
parcial1(pablo, 8).
parcial1(cristian, 8).
parcial1(teo, 4).
parcial1(alan, 4).

parcial2(ana,9).
parcial2(juan,8).
parcial2(pablo, 8).
parcial2(cristian, 8).
parcial2(alan, 2).

%%%% reglas

% 1)
promociona(A, NF):-
    parcial1(A, N1),
    parcial2(A, N2),
    N1 >= 7,
    N2 >= 7,
    NF is (N1 + N2) / 2.

% 2)
aprueba_cursada(A):-
    parcial1(A, N1),
    parcial2(A, N2),
    N1 >= 4,
    N2 >= 4,
    \+ promociona(A, _).

% 3)
recursa(A):-
    parcial1(A, _),
    parcial2(A, _),
	\+ promociona(A, _),
    \+ aprueba_cursada(A).

% v2)
ausente(A):-
    (   parcial1(A, _),
        \+ parcial2(A, _)	);
    (   parcial2(A, _),
        \+ parcial1(A, _)	).