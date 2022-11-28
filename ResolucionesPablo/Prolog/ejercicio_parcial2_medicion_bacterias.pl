%%%% EJERCICIO PARCIAL 2 - MEDICION BACTERIAS %%%%
%
%%% muestras
medicion(0, 0, 10001).   % inv
medicion(1, 200, 1000).
medicion(2, 180, 1200).
medicion(3, 220, 1300).
medicion(4, 190, 10200). % inv
medicion(5, 250, 1500).
medicion(6, 250, 11000). % inv
medicion(7, 260, 1620).


%%% reglas

% a
valida(M, VMin, VMax):-
    medicion(M, VMin, VMax),
    VMax - VMin =< 10000.

% b
primer_valida(M, VMin, VMax):-
    valida(M, VMin, VMax),
    !.

% c
no_mayores(M, VMin, VMax):-
    valida(M, VMin, VMax),
    valida(_, _, VMax1),
    VMax < VMax1.
mayor_vmax(M, VMin, VMax):-
    valida(M, VMin, VMax),
    \+ no_mayores(M, VMin, VMax).
