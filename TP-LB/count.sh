#!/bin/bash

nb1=0
nb2=0

for i in $(seq 1 500)
do
    resultat=$(curl -s http://localhost:83)

    if [[ "$resultat" == *"Hello 1"* ]]; then
        ((nb1++))
    elif [[ "$resultat" == *"Hello 2"* ]]; then
        ((nb2++))
    fi
done

echo "Serveur nginx1 : $nb1 réponses"
echo "Serveur nginx2 : $nb2 réponses"

echo "Total : $((nb1 + nb2)) réponses"

echo "Répartition nginx1 : $((nb1 * 100 / 500))%"
echo "Répartition nginx2 : $((nb2 * 100 / 500))%"
