% EJERCICIO 1

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

% Resolución
menu(En, PP, Po):- entrada(En), carne(PP), postre(Po).
menu(En, PP, Po):- entrada(En), pescado(PP), postre(Po).

% a: menu(X,Y,Z) muestra todos los menus
% b: menu(consomé,Y,Z) muestra todos los menus con consomé de entrada
% c: menu(X,Y,Z), Z \= flan