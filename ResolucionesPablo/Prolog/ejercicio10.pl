%%%% EJERCICIO 10 - Recursividad %%%%

%%% b - fibonacci %%%
%
% lease "el Iesimo nro de la sucesión es el F"
fibonacci(I, F):-
    fib(I, _, F).    
% funciones internas
fib(1, 0, 1):- !.
fib(I, Np, N):-
    Ip is I - 1,
    fib(Ip, Npp, Np),
    N is Npp + Np.

%%% c- factorial %%%
%
factorial(0, 1):- !.
factorial(N, F):-
    Np is N - 1,
    factorial(Np, Fp),
    F is Fp * N.