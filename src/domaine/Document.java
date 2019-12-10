package domaine;

import java.util.Map;

/**
 * Classe dont la responsabilité est de connaître le contenu d'un document, ses fréquences et mots et d'autres statistiques
 */
public class Document {

  private String content;
  private int numLines = -1;
  private int numWords = -1;
  private Map<String, Integer> frequency;

  /**
   * Méthode qui compte le nombre de mots, de nombre de lignes, le nombre de mots uniques et leur fréquence
   *
   * @param content contenu en String du document
   */
  private void processDocument(String content) {
    // TODO: Compléter la méthode
  }

  public Document(String content) {
    this.content = content;
    this.processDocument(content);
  }

  /**
   * Obtenir le nombre de lignes
   *
   * @return nombre de lignes
   */
  public int getNumLines() {
    return numLines;
  }

  /**
   * Obtenir le nombre de mots
   *
   * @return le nombre de mots
   */
  public int getNumWords() {
    return numWords;
  }

  /**
   * Obtenir le nombre de mots distincts
   *
   * @return nombre de mots distincts
   */
  public int getNumDistinctWords() {
    // TODO : Compléter la méthode
    return -1;
  }

  /**
   * Obtenir la fréquence de mots
   *
   * @return Dictionnaire contenant chaque mot et son nombre d'occurences
   */
  public Map<String, Integer> getFrequency() {
    return frequency;
  }
}
