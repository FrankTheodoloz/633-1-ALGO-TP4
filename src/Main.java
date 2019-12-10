import algebre.Distance;
import algebre.Vector;
import domaine.Corpus;
import domaine.Document;
import outils.Loader;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    String file1 = Loader.readFileAsString("lewis.txt");
    String file2 = Loader.readFileAsString("verne.txt");

    Document doc1 = new Document(file1);
    Document doc2 = new Document(file2);
    testDocument(doc1);
    testDocument(doc2);

    Corpus corpus = new Corpus();
    corpus.addDocument(doc1);
    corpus.addDocument(doc2);

    Vector vec1 = Vector.vectorize(doc1, corpus);
    Vector vec2 = Vector.vectorize(doc2, corpus);

    double distance = Distance.cosineDistance(vec1, vec2);

    System.out.println("Cosine distance " + distance);

  }

  public static void testDocument(Document doc1) {
    System.out.println("Lines " + doc1.getNumLines());
    System.out.println("Number of words " + doc1.getNumWords());
    System.out.println("Number of unique words " + doc1.getNumDistinctWords());
  }
}
