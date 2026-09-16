import fonction as f

while True:
    try:
        a = int(input("Entrez la base a : "))
        b = int(input("Entrez l'exposant b : "))
        res = f.puissance(a, b)
        print(f"{a}^{b} = {res}")
    except ValueError:
        print("Veuillez entrer des entiers valides !")
    except TypeError:
        print("Erreur : la fonction puissance n'accepte que des entiers !")

# Q2.5 - Vérification avec des flottants (ne sera jamais atteint à cause de la boucle infinie)
