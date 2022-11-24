%%% EJERCICIO 3

hombre(pedro).
hombre(manuel).
hombre(arturo).
mujer(maría).
padre(pedro, manuel).
padre(pedro, arturo).
padre(pedro, maría).

%%% Res

niño(X,Y):- padre(Y,X). % expresa que X es hijo o hija de Y.
hijo(X,Y):- niño(X,Y), hombre(X). % expresa que X es un hijo varón de Y.
hija(X,Y):- niño(X,Y), mujer(X). % expresa que X es una hija de Y.
hermano_o_hermana(X,Y):- niño(X,Z), niño(Y,Z), X \= Y. % expresa que X es hermano o hermana de Y.
hermano(X,Y):- hermano_o_hermana(X,Y), hombre(X). % expresa que X es un hermano de Y.
hermana(X,Y):- hermano_o_hermana(X,Y), mujer(X). % expresa que X es una hermana de Y.

% Nota: Un individuo no puede ser hermano ni hermana de sí mismo
