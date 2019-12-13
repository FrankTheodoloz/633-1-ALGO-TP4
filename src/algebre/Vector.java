package algebre;

import domaine.Corpus;
import domaine.Document;
import exceptions.BadSizeException;

import java.util.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Classe qui contient toutes les méthodes nécessaires à la gestion d'un vecteur
 */
public class Vector {

  private int[] values;

  /**
   * Constructeur de la classe vecteur.
   *
   * @param size taille du vecteur à créer. Ce vecteur est automatiquement rempli de zéros.
   */
  public Vector(int size) {
    values = new int[size];
  }

  /**
   * Modifier une valeur dans le vecteur
   *
   * @param index indice de la valeur à modifier
   * @param value valeur à être stockée dans le vecteur
   */
  public void set(int index, int value) {
    values[index] = value;
  }

  /**
   * Obtenir un élément du vecteur
   *
   * @param index indice de l'élément à retourner
   * @return la valeur trouvée
   */
  public int get(int index) {
    return values[index];
  }

  /**
   * Donne la taille du vecteur. Est toujours égale à la taille passée dans le constructeur
   *
   * @return la taille du vecteur
   */
  public int size() {
    return values.length;
  }

  /**
   * Calculer le produit scalaire entre ce vecteur et un autre vecteur
   *
   * @param other vector avec lequel le produit scalaire sera calculé
   * @return la valeur du produit scalaire
   * @throws BadSizeException exception de type RunTimeException qui est levée si la taille des vecteurs est différente
   */
  public int innerProduct(Vector other) throws BadSizeException {
    // throw the BadSizeException exception when the vectors size is different
    if (this.size() != other.size()) {
      throw new BadSizeException("La taille des vecteurs est différente");
    }
    // the scalar product is the sum of the products of the frequencies
    int product = 0;
    for (int i = 0; i < this.size(); i++) {
      product += this.get(i) * other.get(i);
    }
    return product;
  }

  /**
   * Calcule la norme euclidienne du vecteur
   *
   * @return la taille du vecteur
   */
  public double norm() {
    // the euclidean norm is square root of the sum of the squares of the frequencies
    int sumFreqSquares = 0;
    for (int i = 0; i < this.size(); i++) {
      sumFreqSquares += pow(this.get(i), 2);
    }
    return sqrt(sumFreqSquares);
  }

  /**
   * Retourne une représentation vectorielle de la fréquence de mots d'un document, étant donné un corpus
   *
   * @param document le document contenant les mots et la fréquence des mots
   * @param corpus   contient la liste de tous les mots de tous les documents à analyser
   * @return une instance de Vector
   */
  public static Vector vectorize(Document document, Corpus corpus) {
    // initialises the vector with the size of the corpus
    Vector v = new Vector(corpus.getCorpus().size());

    // runs over all corpus words (the keys)
    int i = 0;
    for (String s : corpus.getCorpus()) {
      // if the word in the corpus is present in the document
      if (document.getFrequency().containsKey(s)) {
        // add its frequency to the vector
        v.set(i, document.getFrequency().get(s));
      }
      // otherwise do nothing and process with next index
      i++;
    }
    return v;
  }

}
