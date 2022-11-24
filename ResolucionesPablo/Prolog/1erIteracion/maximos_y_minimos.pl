%%%% MAXIMOS Y MINIMOS %%%%

n(1). n(1). n(2). n(2). n(3). n(4). n(5). n(6). n(6).

%%% REGLAS %%%

nxn(N1, N2):-
    n(N1), n(N2).

no_mayores(N):-
    nxn(N, O), N < O.

no_menores(N):-
    nxn(N, O), N > O.

max(N):-
    n(N), \+ no_mayores(N), !.

min(N):-
    n(N), \+ no_menores(N), !.