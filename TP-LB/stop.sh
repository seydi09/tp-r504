#!/bin/bash

# Arrêter les trois conteneurs
docker stop nginx1 nginx2 nginx-lb

# Supprimer les conteneurs s'ils existent encore
docker rm nginx1 nginx2 nginx-lb

# Supprimer le réseau Docker
docker network rm tplb

echo "Tous les conteneurs et le réseau ont été supprimés."
