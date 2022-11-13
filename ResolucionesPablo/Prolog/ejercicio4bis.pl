%%% EJERCICIO 4bis - Promocionaste? v1, v2 %%%

% notas %

parcial1(ana,7).
parcial1(juan,4).
parcial1(pablo,8).
parcial1(felipe,4).
parcial1(cristian,9).
parcial1(th,4).

parcial2(ana,9).
parcial2(juan,8).
parcial2(pablo,9).
parcial2(felipe,3).
parcial2(cristian,8).
parcial2(lola,6).

% resolucion %

nota_final(Nombre, NotaFinal):-
    parcial1(Nombre, P1),
    parcial2(Nombre, P2),
    NotaFinal is (P1 + P2) / 2.

menores_notas(A):-
    nota_final(_, A), nota_final(_, B),
    A < B.

mayor_nota(Nota):-
    nota_final(_, Nota), \+ menores_notas(Nota), !.

% 1
promociona(Nombre, NotaFinal):-
    parcial1(Nombre, P1), P1 >= 7,
    parcial2(Nombre, P2), P2 >= 7,
    nota_final(Nombre, NotaFinal).
% 2
cursada_aprobada(Nombre):-
	parcial1(Nombre, P1), P1 >= 4,
    parcial2(Nombre, P2), P2 >= 4.
% 3
recursa(Nombre):-
    parcial1(Nombre, P1), P1 < 4;
    parcial2(Nombre, P2), P2 < 4.
% 4
premiados(Nombre, NotaFinal):-
    mayor_nota(NotaFinal),
    nota_final(Nombre, NotaFinal).
% v2
ausente(Nombre):-
    parcial1(Nombre, _), \+ parcial2(Nombre, _).
ausente(Nombre):-
    parcial2(Nombre, _), \+ parcial1(Nombre, _).
    
    
    
    