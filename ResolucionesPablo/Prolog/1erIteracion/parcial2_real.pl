%%% EJ 1 DEL PARCIAL 2  
%   		14/11/22 %%%

gusta(lucasp, mate).
gusta(veronica, cafe).
gusta(hernan, cocoa).

sirve(encuentro, cocoa).
sirve(encuentro, mate).
sirve(ideas, cafe).
sirve(gaucho, mate).

frecuenta(lucasp, encuentro).
frecuenta(veronica, encuentro).
frecuenta(hernan, encuentro).

%%% RESOLUCION %%%

%% 1A)
gusta_bar(Per, Bar):-
    gusta(Per, Beb),
    sirve(Bar, Beb).

paralucasyhernan(Bar):-
    gusta_bar(lucasp, Bar),
    gusta_bar(hernan, Bar).

paralucap(Bar):-
    gusta_bar(lucasp, Bar),
    \+ paralucasyhernan(Bar). % Devuelve "gaucho", el bar que sirve cosas 
							  % que le gustan a lucasp pero no a hernan

%% 1B)
sufridos(Per, Bar):-
    frecuenta(Per, Bar),
    \+ gusta_bar(Per, Bar). % Devuelve a veronica, que frecuenta "encuentro"
							% incluso cuando no sirven cafe

