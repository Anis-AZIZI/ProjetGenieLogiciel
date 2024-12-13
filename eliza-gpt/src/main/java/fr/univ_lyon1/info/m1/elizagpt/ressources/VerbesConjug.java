package fr.univ_lyon1.info.m1.elizagpt.ressources;

import java.util.HashMap;

/**
 * apres plusieurs tentatives de chargement d'un fichier json.
 * on a decider de proceder autrement.
 * Backup verbs conjugues en cas d'indisponibilite du fichier json.
 * Contient les verbes les plus utilises de la langue francaise selon
 * un rapport de CNRS.
 */
public class VerbesConjug {

    private static final HashMap<String, String> VERBCONJUG = new HashMap<>();

    /**
     * constructeur.
     */
    protected VerbesConjug() {
        VERBCONJUG.put("trouve", "trouvez");
        VERBCONJUG.put("donne", "donnez");
        VERBCONJUG.put("parle", "parlez");
        VERBCONJUG.put("aime", "aimez");
        VERBCONJUG.put("passe", "passez");
        VERBCONJUG.put("demande", "demandez");
        VERBCONJUG.put("semble", "semblez");
        VERBCONJUG.put("laisse", "laissez");
        VERBCONJUG.put("reste", "restez");
        VERBCONJUG.put("pense", "pensez");
        VERBCONJUG.put("finis", "finissez");
        VERBCONJUG.put("agis", "agissez");
        VERBCONJUG.put("regarde", "regardez");
        VERBCONJUG.put("arrive", "arrivez");
        VERBCONJUG.put("cherche", "cherchez");
        VERBCONJUG.put("porte", "portez");
        VERBCONJUG.put("entre", "entrez");
        VERBCONJUG.put("appelle", "appelez");
        VERBCONJUG.put("tombe", "tombez");
        VERBCONJUG.put("commence", "commencez");
        VERBCONJUG.put("montre", "montrez");
        VERBCONJUG.put("arrête", "arrêtez");
        VERBCONJUG.put("lève", "levez");
        VERBCONJUG.put("écoute", "écoutez");
        VERBCONJUG.put("continue", "continuez");
        VERBCONJUG.put("ajoute", "ajoutez");
        VERBCONJUG.put("joue", "jouez");
        VERBCONJUG.put("marche", "marchez");
        VERBCONJUG.put("garde", "gardez");
        VERBCONJUG.put("manque", "manquez");
        VERBCONJUG.put("retrouve", "retrouvez");
        VERBCONJUG.put("rappelle", "rappelez");
        VERBCONJUG.put("quitte", "quittez");
        VERBCONJUG.put("tourne", "tournez");
        VERBCONJUG.put("crie", "criez");
        VERBCONJUG.put("songe", "songez");
        VERBCONJUG.put("presente", "presentez");
        VERBCONJUG.put("existe", "existez");
        VERBCONJUG.put("envoie", "envoyez");
        VERBCONJUG.put("explique", "expliquez");
        VERBCONJUG.put("mange", "mangez");
        VERBCONJUG.put("suis", "suivez");
        VERBCONJUG.put("ai", "avez");
        VERBCONJUG.put("peux", "pouvez");
        VERBCONJUG.put("fais", "faites");
        VERBCONJUG.put("dis", "dites");
        VERBCONJUG.put("vois", "voyez");
        VERBCONJUG.put("sais", "savez");
        VERBCONJUG.put("veux", "voulez");
        VERBCONJUG.put("viens", "venez");
        VERBCONJUG.put("fais", "faites");
        VERBCONJUG.put("dois", "devez");
        VERBCONJUG.put("crois", "croyez");
        VERBCONJUG.put("prends", "prenez");
        VERBCONJUG.put("mets", "mettez");
        VERBCONJUG.put("tiens", "tenez");
        VERBCONJUG.put("entends", "entendez");
        VERBCONJUG.put("repends", "rependez");
        VERBCONJUG.put("rends", "rendez");
        VERBCONJUG.put("connais", "connaissez");
        VERBCONJUG.put("sens", "sentez");
        VERBCONJUG.put("attends", "attendez");
        VERBCONJUG.put("comprends", "comprenez");
        VERBCONJUG.put("deviens", "devenez");
        VERBCONJUG.put("retiens", "retenez");
        VERBCONJUG.put("écris", "écrivez");
        VERBCONJUG.put("reprends", "reprenez");
        VERBCONJUG.put("préserve", "préservez");
        VERBCONJUG.put("meurs", "mourez");
        VERBCONJUG.put("pars", "partez");
        VERBCONJUG.put("ouvre", "ouvrez");
        VERBCONJUG.put("lis", "lisez");
        VERBCONJUG.put("sers", "servez");
        VERBCONJUG.put("reçois", "recevez");
        VERBCONJUG.put("perds", "perdez");
        VERBCONJUG.put("aperçois", "apercevez");
        VERBCONJUG.put("autorise", "autorisez");
        VERBCONJUG.put("descends", "descendez");
        VERBCONJUG.put("apprends", "apprenez");
        VERBCONJUG.put("aperçois", "apercevez");
        VERBCONJUG.put("permets", "permettez");
    }

    /**
     * a function that takes a key and return the value from the hashmap.
     * @param key key.
     * @return String
     */
    public static String get(final String key) {
        return VERBCONJUG.get(key);
    }
    /**
     * return the hashmap.
     */
    public static HashMap<String, String> getVerbsConjug() {
        return VERBCONJUG;
    }
    /**
     * return the size of the hashmap.
     */
    public static int getSize() {
        return VERBCONJUG.size();
    }

}
