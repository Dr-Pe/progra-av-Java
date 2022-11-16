%%% INTENTO DEL EJ 1 DEL PARCIAL 2 
%   SEGÚN LO QUE RECUERDO DE LA CONSIGNA 
%   						14/11/22 %%%

gusta(lucas, cafe).
gusta(hernan, cerveza).
gusta(yo, cafe).

sirve(gato_negro, cafe).
sirve(ideas, cafe).
sirve(ideas, cerveza).
sirve(encuentros, cerveza).

frecuenta(lucas, ideas).
frecuenta(hernan, gato_negro).
frecuenta(yo, encuentros).


%%% RESOLUCION %%%

%%% 1 - bares donde lucas tiene cosas que le gusten pero hernan no %%%
gusta_bar(Per, Bar):-
    gusta(Per, Beb),
    sirve(Bar, Beb).

lucasyhernan(Bar):-
    gusta_bar(lucas, Bar),
    gusta_bar(hernan, Bar).

lucas_no_hernan(Bar):-
    gusta_bar(lucas, Bar),
    \+ lucasyhernan(Bar). % NO DA CONJ VACÍO. CREO QUE EL PARCIAL ESTABA BIEN

%%% 2 - personas que frecuenten bares sin cosas que les gusten %%%

sufridos(Per):-
    frecuenta(Per, Bar),
    \+ gusta_bar(Per, Bar).
