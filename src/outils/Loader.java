package outils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Loader {

  /**
   * Charger un fichier
   *
   * @param filename nom du fichier à charger
   * @return le contenu du fichier au format String
   * @throws IOException lance une erreur lorsque le fichier spécifié n'a pas pu être traité
   */
  public static String readFileAsString(String filename) throws IOException {
    try {
      return new String(Files.readString(Paths.get(filename)));
    } catch (Exception e) {
      throw new IOException("Erreur lors de la lecture du fichier");
    }
  }
}
