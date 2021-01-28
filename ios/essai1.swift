/*func jour (_ j: Int) -> String{
switch j {
case 1: return "Lundi"
case 2: return "Mardi"
case 3: return "Mercredi"
case 4: return "Jeudi"
case 5: return "Vendredi"
case 6: return "Semedi"
case 7: return "Dimache"
default:
    return("Vous vous êtes trompé de jour")
}
}
print (jour (4))*/

/*func iterative(i : Int){
	var nombre = 0
while nombre <= i {
   print (nombre)
    nombre += 1
}
}
iterative( i : 10)*/

/*func interactive(n : Int){
	var nombre = 0
	for nombre in 1...n {
    	print (nombre)
	}
}
interactive(n:10)*/

print("Jeux")
var hasard = Int.random(in: 0...100)
var valeur = 0

if let nombre = readLine() {
    valeur = Int(nombre) ?? 0
    print("Le nombre random est \(hasard)")
   
}

    if valeur < hasard{
        print("plus grand")
    }else{
        print("plus petit")
    }