%%% EJERCICIO 2

%clauses
entrada(paella).
entrada(gazpacho).
entrada(consomé).

carne(filete_de_cerdo).
carne(pollo_asado).

pescado(trucha).
pescado(bacalao).

postre(flan).
postre(helado).
postre(pastel).
%fin clauses

%%% Resolución
menu(En, PP, Po, Be):- entrada(En), carne(PP), postre(Po), bebida(Be).
menu(En, PP, Po, Be):- entrada(En), pescado(PP), postre(Po), bebida(Be).

% nuevas clausulas
bebida(vino).
bebida(cerveza).
bebida("agua mineral").