def puissance(a, b):
    return a ** b


while True:
    try:
        a = int(input("Entrez la base a : "))
        b = int(input("Entrez l'exposant b : "))
        print(f"{a}^{b} = {puissance(a, b)}")
    except ValueError:
        print("Veuillez entrer des entiers valides !")
