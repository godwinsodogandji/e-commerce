
java
public class Matrix<T> {
  
    // Déclaration d'un tableau d'objets 2D pour stocker les éléments de la matrice.
    private Object[][] matrix;

    // Constructeur de la classe Matrix. Initialise la matrice avec le nombre de lignes et de colonnes spécifiés.
    public Matrix(int rows, int cols) {
        matrix = new Object[rows][cols];
    }
    
    // Méthode pour obtenir la valeur à la position (i, j) de la matrice.
    // Note : Les indices sont ajustés pour être basés sur 1 (i - 1 et j - 1).
    // La conversion de Object à T est effectuée via un cast non sécurisé, ce qui peut causer des problèmes à l'exécution.
    public T get(int i, int j) {
        return (T) matrix[i - 1][j - 1];
    }
    
    // Méthode pour définir la valeur à la position (i, j) de la matrice.
    // Comme pour la méthode get, les indices sont ajustés pour être basés sur 1.
    public void set(int i, int j, T value) {
        matrix[i - 1][j - 1] = value;
    }
    
    // Méthode pour définir toutes les valeurs d'une ligne donnée (i) dans la matrice.
    // Utilise une varargs (T... values) pour permettre la passation d'un nombre variable d'arguments.
    public void setRow(int i, T... values) {
        matrix[i - 1] = values;
    }
    
    // Méthode pour échanger les valeurs entre deux positions (i1, j1) et (i2, j2) dans la matrice.
    // Effectue un échange en utilisant une variable temporaire.
    public void swap(int i1, int j1, int i2, int j2) {
        T temp = get(i1, j1);
        set(i1, j1, get(i2, j2));
        set(i2, j2, temp);
    }
    
    // Méthode pour convertir la matrice en un tableau de chaînes de caractères.
    // Chaque élément de la matrice est converti en String et stocké dans un tableau 2D de chaînes.
    public String[][] toArray() {
        String[][] arr = new String[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                arr[i][j] = String.valueOf(matrix[i][j]);
            }
        }
        return arr;
    }
}
