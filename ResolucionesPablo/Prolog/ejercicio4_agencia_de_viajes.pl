%%%% EJERCICIO 4 - AGENCIA DE VIAJES %%%%

% clauses
transporte(roma,20).
transporte(londres,30).
transporte(tunez,10).
alojamiento(roma,hotel,50).
alojamiento(roma,hostal,30).
alojamiento(roma,camping,10).
alojamiento(londres,hotel,60).
alojamiento(londres,hostal,40).
alojamiento(londres,camping,20).
alojamiento(tunez,hotel,40).
alojamiento(tunez,hostal,20).
alojamiento(tunez,camping,5).
% finclauses

% reglas

viaje(C, S, H, P):-
    transporte(C, PT),
    alojamiento(C, H, PH),
    P is PT + (S * PH).

viajeeconomico(C, S, H, P, Pmax):-
    viaje(C, S, H, P),
    P =< Pmax.