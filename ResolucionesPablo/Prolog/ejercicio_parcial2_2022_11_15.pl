%%%% EJERCICIO PARCIAL 2 - 15/11/2022 %%%%

ventas(enero, 1200).
ventas(febrero, 600).
ventas(marzo, 1500).
ventas(abril, 1200).
ventas(mayo, 1500).
ventas(junio, 100).

%%% Se desea conocer los 2 meses con más ventas %%%

vXvXv(V1, V2, V3):-
    ventas(_, V1),
    ventas(_, V2),
    ventas(_, V3).

no2mayores(V1):-
    vXvXv(V1, V2, V3),
    V1 < V2,
    V2 < V3.

dos_mayores(M, V):-
    ventas(M, V),
    \+ no2mayores(V).