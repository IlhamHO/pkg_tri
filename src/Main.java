import eu.epfc.prm2.Array;

import java.util.Scanner;

public class Main {
    public static void saisie(Date d){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez votre date de naissance:");
        System.out.println("Entrez le jour de votre naissance:");
        d.jour=sc.nextInt();
        System.out.println("Entrez le mois de votre naissance:");
        d.mois=sc.nextInt();
        System.out.println("Entrez l'année de votre naissance:");
        d.annee=sc.nextInt();
    }

    public static void saisie(Personne p){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez votre nom:");
        p.nom=sc.next();
        System.out.println("Entrez votre prénom:");
        p.prenom=sc.next();
        p.ddn = new Date();
        saisie(p.ddn);
    }

    public static void affiche(Date d){
        System.out.println("Date de naissance:"+d.jour+"/"+d.mois+"/"+d.annee);
    }
    public static void affiche(Personne p){
        System.out.println("Nom:"+p.nom+", Prenom:"+p.prenom);
        affiche(p.ddn);
    }

    public static int compare(Date d1, Date d2){
        int date1 = d1.annee*1000+d1.mois*100+d1.jour;
        int date2 = d2.annee*1000+d2.mois*100+d2.jour;
        return date1-date2;
    }

    public static int compareAge(Personne p1, Personne p2){
        return -(compare(p1.ddn,p2.ddn));
    }

    public static int compareNomPrenom(Personne p1, Personne p2){
        return (p1.nom+" "+p1.prenom).compareTo(p2.nom+" "+p2.prenom);
    }

    public static Array<Personne> personnesTab (){
        Array<Personne> tab = new Array<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nombre de personnes de votre tableau:");
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            Personne p = new Personne();
            saisie(p);
            tab.add(p);
        }
        return tab;
    }

    public static void affichePersonnesTab(Array<Personne> tab){
        for(int i=0; i<tab.size(); i++){
            affiche(tab.get(i));
        }
    }
     public static void affichePersonnePlusJeune(Array<Personne> tab){
        Personne minAgePersonne = new Personne();
         for(int i=0; i<tab.size();++i){
            minAgePersonne = tab.get(i);
            for(int j=1; j<tab.size();++j){
               int d = compareAge(tab.get(i),tab.get(j));
               if(d>0) minAgePersonne=tab.get(j);
            }
        }
         System.out.println("la personne la plus jeune est: ");
         affiche(minAgePersonne);
     }

     public static void triSelectionOrdreAlphab(Array<Personne> tab){
        for (int i=0; i<tab.size(); ++i){
            int indMin = i;
            for (int j=i+1; j<tab.size();++j){
                int val=compareNomPrenom(tab.get(indMin),tab.get(j));
                if(val<0)  indMin = j;

                Personne tmp = tab.get(i);
                tab.set(i,tab.get(indMin));
                tab.set(indMin, tmp);
            }
        }
     }

     public static void triAgeOrdreCroissant(Array<Personne> tab){
        for(int i=0; i<tab.size();++i) {
            Personne valPersonne = tab.get(i);
            int j=i;
            while ((j>0 && compareAge(valPersonne,tab.get(j-1))<0)){
                tab.set(j, tab.get(j-1));
                --j;
            }
            tab.set(j,valPersonne);
        }
     }

     public static void saisie(Array<Integer> tab){
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nombre de valeurs à inserer dans le tableau:");
        int n = sc.nextInt();

        for(int i=0; i<tab.size()+n;++i) {
            System.out.println("Entrez la valeur suivante");
            int val = sc.nextInt();

            insertion(tab, val);
        }

     }

     public static void insertion(Array<Integer> tab, int val){
        int tmp = val;
        int k = tab.size()-1;
        while (k>0 && val<tab.get(k-1)){
           tab.set(k,tab.get(k-1));
           --k;
       }
       tab.set(k,tmp);
     }



    public static void main(String[] args) {
//        Array<Personne> pTab =personnesTab();
//        affichePersonnesTab(pTab);
//        affichePersonnePlusJeune(pTab);
//        triSelectionOrdreAlphab(pTab);
//        triSelectionOrdreAlphab(pTab);
//        System.out.println("le tri du tableau en ordre alphabetique du nom et prénom donne:");
//        affichePersonnesTab(pTab);
//        triAgeOrdreCroissant(pTab);
//        System.out.println("le tri du tableau en ordre croissant de l'age des personnes donne:");
//        affichePersonnesTab(pTab);
//        System.out.println("----------------------------------------------");
        Array<Integer> nTab = new Array<Integer>(1,2,3);
        saisie(nTab);
    }
}
