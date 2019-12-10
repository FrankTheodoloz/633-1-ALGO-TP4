package domaine;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe dont la responsabilité est de connaître tous les mots de tous les documents
 */
public class Corpus {

  private Set<String> corpus;

  public Corpus() {
    this.corpus = new HashSet<String>();
  }

  /**
   * Ajouter les mots d'un document aux mots du corpus
   * @param document le document contenant les mots à ajouter
   */
  public void addDocument(Document document) {
    // TODO: Compléter la méthode
  }

  /**
   * Obtenir la liste de tous les mots distincts contenus dans tous les documents
   * @return un Set contenant tous les mots
   */
  public Set<String> getCorpus() {
    return this.corpus;
  }

}
