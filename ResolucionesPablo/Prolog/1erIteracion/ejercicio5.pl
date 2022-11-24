%%% EJERCICIO 5 - Agencia Matrimonial %%%

% persona(N,A,C,E).
% Con: Nombre, Altura (alta, media, baja),
%	   Cabello (rubio, castaño, pelirrojo, negro), Edad (joven, adulto, viejo).

persona(santiago, media, castaño, joven).
persona(lean, baja, negro, joven).
persona(thiago, alta, castaño, joven).
persona(romina, alta, rubio, joven).
persona(nadia, media, negro, joven).

% gusta(N,M,L,S).
% Persona N, música M (clásica, pop, jazz), el
% género de literatura L (aventura, ciencia-ficción, policíaca), 
% y el deporte S (tenis, natación, jogging).

gusta(santiago, jazz, ciencia-ficción, jogging).
gusta(lean, pop, policíaca, joggin).
gusta(thiago, pop, aventura, tenis).
gusta(romina, jazz, ciencia-ficción, jogging).
gusta(nadia, pop, aventura, jogging).

% busca(N,A,C,E).
% Qué busca la persona N.

busca(santiago, alta, rubio, joven).
busca(lean, baja, negro, joven). busca(lean, media, negro, joven).
busca(thiago, media, negro, joven).
busca(romina, media, castaño, joven).
busca(nadia, alta, castaño, joven). busca(nadia, baja, negro, joven).

%%% RESOLUCION %%%

adecuados(X, Y):-
    conviene(X, Y),
    conviene(Y, X).

conviene(X, Y):-
    busca(X, AY, CY, EY),
    busca(Y, AX, CX, EX),
    persona(X, AX, CX, EX),
    persona(Y, AY, CY, EY),
    gusto_compartido(X, Y),
    X \= Y.

gusto_compartido(X, Y):-
    gusta(X, MX, LX, SX),
    gusta(Y, MY, LY, SY),
    (MX = MY; LX = LY; SX = SY).