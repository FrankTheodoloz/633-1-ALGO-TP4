package algebre;

import exceptions.BadSizeException;

/**
 * Classe qui contient toutes les méthodes de distance entre deux vecteurs.
 */
public class Distance {

  /**
   * Calculer la distance de cosinus entre deux vecteurs.
   *
   * @param vec1 premier vecteur
   * @param vec2 deuxième vecteur
   * @return la distance entre les deux vecteurs
   */
  public static double cosineDistance(Vector vec1, Vector vec2) {

    // the distance is the arcsine of the quotient of inner product divided by the product of the both norms
    double distance = 0;
    try {
      distance = Math.acos(vec1.innerProduct(vec2) / (vec1.norm() * vec2.norm()));
    } catch (BadSizeException e) {
      e.getMessage();
    }
    return distance;
  }

}
