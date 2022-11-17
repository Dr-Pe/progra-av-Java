%%%% EJERCICIO 9 %%%%%

%%% Conocimiento
ventas1erSem(jim, 21000).
ventas1erSem(dwight, 21500).
ventas1erSem(phyllis, 21500).
ventas1erSem(ryan, 42000).

ventas2doSem(jim, 21600).
ventas2doSem(dwight, 21100).
ventas2doSem(phyllis, 18000).
ventas2doSem(andy, 10001).

%%% Reglas
ventasAnuales(Vendedor, Sem1, Sem2, Tot):-
    ventas1erSem(Vendedor, Sem1),
    not(ventas2doSem(Vendedor, _)),
    Tot is Sem1,
    Sem2 is 0.

ventasAnuales(Vendedor, Sem1, Sem2, Tot):-
    ventas2doSem(Vendedor, Sem2),
    not(ventas1erSem(Vendedor, _)),
    Tot is Sem2,
    Sem1 is 0.

ventasAnuales(Vendedor, Sem1, Sem2, Tot):-
    ventas1erSem(Vendedor, Sem1),
    ventas2doSem(Vendedor, Sem2),
    Tot is Sem1 + Sem2.

% Caso1
comision(Vendedor, Comision):-
	ventasAnuales(Vendedor, S1, S2, Tot),
    S1 > 20000, S2 > 20000,
    Comision is Tot * 0.2.
% Caso2
comision(Vendedor, Comision):-
	ventasAnuales(Vendedor, S1, S2, Tot),
    (S1 < 20000; S2 < 20000),
    (S1 > 0, S2 > 0),
    Comision is Tot * 0.1.
% Caso2
comision(Vendedor, Comision):-
	ventasAnuales(Vendedor, S1, S2, Tot),
    ((S1 == 0, S2 > 0); (S1 > 0, S2 == 0)),
    Comision is Tot * 0.05.
