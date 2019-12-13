package domaine;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Classe dont la responsabilité est de connaître le contenu d'un document, ses fréquences et mots et d'autres statistiques
 */
public class Document {

  private String content;
  private int numLines = 0;
  private int numWords = 0;
  private Map<String, Integer> frequency;

  public Document(String content) {
    this.content = content;
    this.processDocument(content);
  }

  /**
   * Méthode qui compte le nombre de mots, de nombre de lignes, le nombre de mots uniques et leur fréquence
   *
   * @param content contenu en String du document
   */
  private void processDocument(String content) {
    frequency = new HashMap<String, Integer>();
    Scanner scanString = new Scanner(content);
    // process all lines
    while (scanString.hasNextLine()) {
      Scanner scanLine = new Scanner(scanString.nextLine());
      numLines++;

      while (scanLine.hasNext()) {
        numWords++;
        // runs over the line word by word
        String word = scanLine.next();
        // replaces all punctuation and signsin the word by nothing and convert to lower case
        word = word.replaceAll("[\\p{P}|]*", "").toLowerCase();
        // if the word does not exists yet, put it in the map with the initial value of 1
        if (!frequency.containsKey(word)) {
          frequency.put(word, 1);
        } else {
          // if the word is present process it -> increment its value by 1
          frequency.put(word, frequency.get(word) + 1);
        }
      }
    }
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
    return frequency.size();
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
