videostore
==========

The videostore example from Episode 3 of cleancoders.com.
Based upon, but not identical to, the first chapter of Martin Fowler's classic book: Refactoring.

Une location concerne un film ou plusieurs films pour une durée determinée

il existe 4 categories de film
Regular
new release
children

Grille tarifaire par categorie de film
Regular : 2 € si la durée n'excède par 2 journées
		sinon c'est 2 € + (nbr jours de location - 2) * 1.5
New release : nbr jours de location * 3
Children : 1.5 € si la durée n'excede par 3 journées
		sinon c'est 1.5 € + (nbr jours de location - 3) * 1.5
		
Fidelisation		
Pour chaque film loué le client recoit un point de fidelité
Pour chaque film new release loué, si la nombre de jour de location excède une journée 
le client recoit 1 point de fidelité supplémentaire

Chaque film sera affiché comme suivant:
Titre du film + "\t" + son prix

Chaque Location aura un affichage
"You owed " + Total + "\n";
"You earned " + Nombre de point de fidelité + " frequent renter points\n";