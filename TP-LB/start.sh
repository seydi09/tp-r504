#!/bin/bash

# (a) Création du réseau Docker
docker network create tplb

# (b) Construction de l'image
docker build -t im-nginx-lb ./tp-A

# (c) Création des dossiers
mkdir -p tp-A/shared1 tp-A/shared2

# (d) Création des fichiers HTML
echo '<h1>Hello 1</h1>' > tp-A/shared1/index.html
echo '<h1>Hello 2</h1>' > tp-A/shared2/index.html

# (e) Lancement de nginx1
docker run -d --rm --name nginx1 --network tplb -p 81:80 -v "$(pwd)/tp-A/shared1:/usr/share/nginx/html" nginx:latest

# (e) Lancement de nginx2
docker run -d --rm --name nginx2 --network tplb -p 82:80 -v "$(pwd)/tp-A/shared2:/usr/share/nginx/html" nginx:latest

# (f) Lancement du load balancer
docker run -d --rm --name nginx-lb --network tplb -p 83:80 im-nginx-lb

echo "Tous les conteneurs sont démarrés."
