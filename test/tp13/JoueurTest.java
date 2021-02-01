package tp13;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Ex2 2. Le test passe au rouge avec 2 failures

//TODO Ex3 1.
public class JoueurTest {
	private Joueur joueur;

	@Before
	public void setUp() throws Exception {
		joueur = new Joueur("Findlay", "Tychus", 24, new Pokemon[] {null,null,null,null,null});
	}

	@After
	public void tearDown() throws Exception {
		this.joueur = null;
	}

	@Test
	public void testGetNom() {
		if( joueur.getNom() != null) {
			if(joueur.getNom().equals("Findlay")) {
				System.out.println("Nom correct");
			}
			else {
				fail("Ce n'est pas l'initialisation souhaitée");
			}
		}
	}

	@Test
	public void testGetPrenom() {
		
		if(joueur.getPrenom() != null) {
			if(joueur.getPrenom().equals("Tychus")) {
				System.out.println("Prénom correct");
	
			}
			else {
				fail("Ce n'est pas l'initialisation souhaitée");
			}
		}
	}
	
	@Test
	public void testCapturer() {
		Pokemon piplup = new Pokemon(393 ,"Piplup", "EAU", 5, true,null,null,51, 53, 61, 56, new Attaque[] {new AttaqueBulle(),new AttaquePistoleEau()});
		boolean verifNull = false;
		
		capturer(piplup);
		
		
		if(joueur.getPokemons().length < 5 && joueur.getPokemons()[0] == piplup) {
			for(int i = 1; i < joueur.getPokemons().length;i++){
				if(joueur.getPokemons()[i] == null) verifNull = true;
				else verifNull = false;
			}
		}
		if(verifNull) System.out.println(joueur.getPokemons()[0].getMonJoueur());
		else System.out.println("Il ne doit y avoir qu'un seul pokémon");
	}

	@Test
	public void testLiberer() {
		Pokemon piplup = new Pokemon(393 ,"Piplup", "EAU", 5, true,null,null,51, 53, 61, 56, new Attaque[] {new AttaqueBulle(),new AttaquePistoleEau()});
		boolean verifNull = false;
		capturer(piplup);
		
		liberer(piplup);
		
		if(joueur.getPokemons().length < 5 && joueur.getPokemons()[0] == null) {
			for(int i = 0; i < joueur.getPokemons().length;i++){
				if(joueur.getPokemons()[i] == null) verifNull = true;
				else verifNull = false;
			}
		}
		if(verifNull) System.out.println(joueur.getPokemons()[0].getMonJoueur());
		else System.out.println("Il ne doit y avoir aucun pokémon");
	}
	
	
	@Test
	public void testCapturerAvecMaitre() {
		Joueur joueur = new Joueur("Mengsk", "Arcturus", 20, new Pokemon[] {null,null,null,null,null});
		Pokemon piplup = new Pokemon(393 ,"Piplup", "EAU", 5, true,null,null,51, 53, 61, 56, new Attaque[] {new AttaqueBulle(),new AttaquePistoleEau()});
		boolean verifNull = false;
		
		capturer(piplup);
		
		if(joueur.getPokemons().length < 5 && joueur.getPokemons()[0] == piplup) {
			for(int i = 1; i < joueur.getPokemons().length;i++){
				if(joueur.getPokemons()[i] == null) verifNull = true;
				else verifNull = false;
			}
		}
		
	}

	@Test
	public void testCapturerPlusDePlace() {
		Pokemon piplup2 = new Pokemon(393 ,"Piplup", "EAU", 5, true,null,null,51, 53, 61, 56, new Attaque[] {new AttaqueBulle(),new AttaquePistoleEau()});
		Pokemon piplup3 = new Pokemon(393 ,"Piplup", "EAU", 5, true,null,null,51, 53, 61, 56, new Attaque[] {new AttaqueBulle(),new AttaquePistoleEau()});
		Pokemon piplup4 = new Pokemon(393 ,"Piplup", "EAU", 5, true,null,null,51, 53, 61, 56, new Attaque[] {new AttaqueBulle(),new AttaquePistoleEau()});
		Pokemon piplup5 = new Pokemon(393 ,"Piplup", "EAU", 5, true,null,null,51, 53, 61, 56, new Attaque[] {new AttaqueBulle(),new AttaquePistoleEau()});
		Pokemon piplup6 = new Pokemon(393 ,"Piplup", "EAU", 5, true,null,null,51, 53, 61, 56, new Attaque[] {new AttaqueBulle(),new AttaquePistoleEau()});
	
		try {
			Joueur joueur = new Joueur("Mengsk", "Arcturus", 20, new Pokemon[] {null,null,null,null,null});
			Pokemon piplup = new Pokemon(393 ,"Piplup", "EAU", 5, true,null,null,51, 53, 61, 56, new Attaque[] {new AttaqueBulle(),new AttaquePistoleEau()});
			boolean verifNull = false;
			
			capturer(piplup);
			capturer(piplup2);
			capturer(piplup3);
			capturer(piplup4);
			capturer(piplup5);
			capturer(piplup6);
		}
		catch (PlusDePlaceException p) {
			p.fillInStackTrace();
		}
	}
	
	@Test
	public void testCapturerDejaUnMaitre() {
		Joueur joueur = new Joueur("Mengsk", "Arcturus", 20, new Pokemon[] {null,null,null,null,null});
		Pokemon piplup = new Pokemon(393 ,"Piplup", "EAU", 5, true,null,null,51, 53, 61, 56, new Attaque[] {new AttaqueBulle(),new AttaquePistoleEau()});
		boolean verifNull = false;
		
		if(verifNull) System.out.println(joueur.getPokemons()[0].getMonJoueur());
		else System.out.println("Il ne doit y avoir qu'un seul pokémon");
	}
	
	@Test
	public void testLibererDUnAutreMaitre() {
		Joueur joueur = new Joueur("Mengsk", "Arcturus", 20, new Pokemon[] {null,null,null,null,null});
		Pokemon piplup = new Pokemon(393 ,"Piplup", "EAU", 5, true,null,null,51, 53, 61, 56, new Attaque[] {new AttaqueBulle(),new AttaquePistoleEau()});
		boolean verifNull = false;
		
		capturer(piplup);
		
		if(joueur.getPokemons().length < 5 && joueur.getPokemons()[0] == null) {
			for(int i = 0; i < joueur.getPokemons().length;i++){
				if(joueur.getPokemons()[i] == null) verifNull = true;
				else verifNull = false;
			}
		}
		if(verifNull) System.out.println(joueur.getPokemons()[0].getMonJoueur());
		else System.out.println("Il ne doit y avoir aucun pokémon");
	}
	
	@Test
	public void testLibererDUnAutreMaitreE() {
		
	}
	
	@Test
	public void LibererLibre() {
		
	}
	
	private void capturer(Pokemon piplup) {
		
		if (piplup != null) {
			joueur.rencontrer(piplup);
		}
		if (piplup.getMonJoueur()!=null ) {
			throw new DejaUnMaitreException();
		}
		else {
			int premierePlaceDisponible = joueur.trouverPokemon(null);
			if (premierePlaceDisponible != -1) {
				joueur.getPokemons()[premierePlaceDisponible] = piplup;
				System.out.println("Ce pokemon devient la propriete du joueur " + joueur.getNom());
				piplup.setMonJoueur(joueur);
				piplup.baisserLoyaute(100); // car la methode en question remet la valeur a zero si le resultat est negatif
				piplup.baisserAppetit(100);
				piplup.monterAppetit(10);
			}
		}
	}
	
	private void liberer(Pokemon piplup) {
		int positionPokemon = joueur.trouverPokemon(piplup);
		if(positionPokemon != -1) {
			joueur.getPokemons()[positionPokemon] = null;
			System.out.println("Ce pokemon n'est plus la propriete du joueur " + joueur.getNom());
			piplup.setMonJoueur(null);
			piplup.setNomDonne(null);
			piplup.baisserLoyaute(100); // car la methode en question remet la valeur a zero si le resultat est negative
			piplup.baisserAppetit(100);
			piplup.monterAppetit(10);
		}
		else if(piplup.getMonJoueur()!=null){
			joueur.rencontrer(piplup);
		}
	}
}





















